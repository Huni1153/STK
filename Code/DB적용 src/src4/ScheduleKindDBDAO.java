import java.sql.*;
import java.util.*;

public class ScheduleKindDBDAO
{
	final private DBConnectionModule connModule;
	private Connection daoConn;
	//private static ScheduleKindDAO obj = new ScheduleKindDAO();

/*
	public static ScheduleKindDAO getInstance(){
		return obj;
	}
*/
	public ScheduleKindDBDAO(){
		System.out.println("333333333333333");
		this.connModule = DBConnectionModule.getInstance();
		this.daoConn = connModule.getConn();
		//try{
		//	System.out.println(this.daoConn.getSchema());
		//}
		//catch(SQLException se){
		//}
	}

	public ScheduleKindDBDAO(DBConnectionModule connModule){
		this.connModule = connModule;
		this.daoConn = this.connModule.getConn();
	}
	/*
	public void setConnModule(DBConnectionModule connModule){
		this.connModule = connModule;
		this.daoConn = this.connModule.getConn();
	}
	*/
	public DBConnectionModule getConnModule(){
		return this.connModule;
	}

	public int insert(String scheduleKindCode, String scheduleKindName){
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try{
			String sql = "insert into ScheduleKind(scheduleKindCode, scheduleKindName) values(?,?)";
			pstmt = daoConn.prepareStatement(sql);

			pstmt.setString(1,scheduleKindCode);
			pstmt.setString(2,scheduleKindName);

			rowNum = pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}

	public int update(String scheduleKindCode, String scheduleKindName){
		int rowNum = 0;
		PreparedStatement pstmt = null;

		try{
			String sql = "update ScheduleKind set scheduleKindName = ? where scheduleKindCode = ?";
			pstmt = daoConn.prepareStatement(sql);

			pstmt.setString(1,scheduleKindName);
			pstmt.setString(2,scheduleKindCode);
			
			rowNum = pstmt.executeUpdate();

		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		
		}
		return rowNum;
	}

	public int delete(String scheduleKindCode){
		int rowNum = 0;
		PreparedStatement pstmt = null;

		try{
			String sql = "delete from ScheduleKind where scheduleKindCode = ?";
			pstmt = daoConn.prepareStatement(sql);

			pstmt.setString(1,scheduleKindCode);

			rowNum = pstmt.executeUpdate();
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return rowNum;
	}
	public ScheduleKind selectCode(String scheduleKindCode){
		ScheduleKind kind = null;
		PreparedStatement pstmt = null;

		try{
			String sql = "select scheduleKindCode, scheduleKindName from ScheduleKind where scheduleKindCode = ?";
			pstmt = daoConn.prepareStatement(sql);
			pstmt.setString(1,scheduleKindCode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String scheduleKindCode1 = rs.getString("scheduleKindCode");
				String scheduleKindName1 = rs.getString("scheduleKindName");
				kind = new ScheduleKind(Integer.parseInt(scheduleKindCode1), scheduleKindName1);
			}		
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return kind;
	}

	public ScheduleKind[] selectName(String scheduleKindName){
		ScheduleKind[] kind = null;
		PreparedStatement pstmt = null;
		ArrayList<ScheduleKind>list = new ArrayList<ScheduleKind>();
		try{
			String sql = "select scheduleKindCode, scheduleKindName from ScheduleKind where scheduleKindName = ?";
			pstmt = daoConn.prepareStatement(sql);
			pstmt.setString(1,scheduleKindName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String scheduleKindCode1 = rs.getString("scheduleKindCode");
				String scheduleKindName1 = rs.getString("scheduleKindName");
				list.add(new ScheduleKind(Integer.parseInt(scheduleKindCode1), scheduleKindName1));			
			}
			kind = new ScheduleKind[list.size()];
			for(int cnt=0; cnt<list.size(); cnt++){
				kind[cnt] = list.get(cnt);
			}
		}
		catch(SQLException se){
			System.out.println(se.getMessage());
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			try{
				if(pstmt != null) pstmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return kind;
	}

	public static void main(String []args){
		ScheduleKindDBDAO dao = new ScheduleKindDBDAO();
		//System.out.println(dao.insert("5","¤¡¤¡¤¡"));
		//System.out.println(dao.delete("5"));
		//System.out.println(dao.update("5","Å×½ºÆ®"));
		//System.out.println(dao.selectCode("5"));
		//dao.insert("6","ÈÞ½Ä");

		ScheduleKind kind[] = null;

		kind = dao.selectName("ÈÞ½Ä");

		for(int cnt=0; cnt<kind.length; cnt++)
			System.out.println(kind[cnt]);

	}

}