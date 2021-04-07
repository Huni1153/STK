package Model;
import java.sql.*;
import java.util.*;

public class ScheduleInfoDBDAO
{
	final private DBConnectionModule connModule;
	private Connection daoConn;
	//private static ScheduleInfoDAO obj = new ScheduleInfoDAO();
	/*
	public static ScheduleInfoDAO getInstance(){
		return obj;
	}
	*/
	public ScheduleInfoDBDAO(){
		this.connModule = DBConnectionModule.getInstance();
		this.daoConn = connModule.getConn();
	}
	public ScheduleInfoDBDAO(DBConnectionModule connModule){
		this.connModule = connModule;
		this.daoConn = this.connModule.getConn();
	}
	public DBConnectionModule getConnModule(){
		return this.connModule;
	}

	public int insert(String scheduleCode, String scheduleKindCode, String scheduleName, java.util.Date startDate, java.util.Date endDate, String place, java.util.Date alarm, String image, String note){
		int rowNum = 0;
		PreparedStatement pstmt = null;

		java.sql.Timestamp sqlStartTimeStamp = new java.sql.Timestamp(startDate.getTime());
		java.sql.Timestamp sqlEndTimeStamp = new java.sql.Timestamp(endDate.getTime());
		java.sql.Timestamp sqlAlarmTimeStamp = new java.sql.Timestamp(alarm.getTime());

/*
		java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
		java.sql.Date sqlAlarm = new java.sql.Date(alarm.getTime());
*/

/*
		System.out.println("StartDate 확인하기!!!!!!!!!!!!!!11");
		System.out.println(sqlStartDate);
		//System.out.println(sqlStartDate.getHours());
		System.out.println("endDate 확인하기!!!!!!!!!!!!!!11");
		System.out.println(sqlEndDate);
		//System.out.println(sqlEndDate.getHours()); 
*/

		try{
			String sql = "insert into ScheduleInfo(scheduleCode, scheduleKindCode, scheduleName, startDate, endDate, place, alarm, image, note) values(?,?,?,?,?,?,?,?,?)";
			pstmt = daoConn.prepareStatement(sql);
			pstmt.setString(1,scheduleCode);
			pstmt.setString(2,scheduleKindCode);
			pstmt.setString(3,scheduleName);
			
			/*
			
			pstmt.setDate(4,sqlStartDate);
			pstmt.setDate(5,sqlEndDate);
			pstmt.setDate(7,sqlAlarm);
			*/

			pstmt.setTimestamp(4,sqlStartTimeStamp);
			pstmt.setTimestamp(5,sqlEndTimeStamp);
			pstmt.setTimestamp(7,sqlAlarmTimeStamp);

			pstmt.setString(6,place);
			
			pstmt.setString(8,image);
			pstmt.setString(9,note);

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
	
	public int update(String scheduleCode, String scheduleKindCode, String scheduleName, java.util.Date startDate, java.util.Date endDate, String place, java.util.Date alarm, String image, String note){
		int rowNum = 0;
		PreparedStatement pstmt = null;

		java.sql.Timestamp sqlStartTimeStamp = new java.sql.Timestamp(startDate.getTime());
		java.sql.Timestamp sqlEndTimeStamp = new java.sql.Timestamp(endDate.getTime());
		java.sql.Timestamp sqlAlarmTimeStamp = new java.sql.Timestamp(alarm.getTime());
		/*
		java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
		java.sql.Date sqlAlarm = new java.sql.Date(alarm.getTime());
		*/
		try{
			String sql = "update ScheduleInfo set scheduleKindCode = ?, scheduleName = ?, startDate = ?, endDate = ?, place = ?, alarm = ?, image = ?, note = ? where scheduleCode = ?";
			pstmt = daoConn.prepareStatement(sql);
			
			pstmt.setString(1,scheduleKindCode);
			pstmt.setString(2,scheduleName);
			
			
			//pstmt.setDate(3,sqlStartDate);
			//pstmt.setDate(4,sqlEndDate);
			//pstmt.setDate(6,sqlAlarm);
			pstmt.setTimestamp(3,sqlStartTimeStamp);
			pstmt.setTimestamp(4,sqlEndTimeStamp);
			pstmt.setTimestamp(6,sqlAlarmTimeStamp);


			pstmt.setString(5,place);
			pstmt.setString(7,image);
			pstmt.setString(8,note);
			pstmt.setString(9,scheduleCode);

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
	public int delete(String scheduleCode){
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try{
			String sql = "delete from ScheduleInfo where scheduleCode = ?";
			pstmt = daoConn.prepareStatement(sql);

			pstmt.setString(1,scheduleCode);

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
	
	public String latestCodeNum(){
		String codeString = null;
		PreparedStatement pstmt = null;
		try{
			String sql = "select MAX(scheduleCode) from ScheduleInfo";
			pstmt = daoConn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String code = rs.getString("MAX(scheduleCode)");
				
				char []chCode = code.toCharArray();

				codeString = String.valueOf(chCode, chCode.length-4, 4);
				System.out.println("Max Value Of Code is : "+ codeString);
				//System.out.println("Here We are22222");
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
		return codeString;
	}
	
/*
	public String latestCodeNum(){
		String codeString = null;
		Statement stmt = null;
		
		try{
			stmt = daoConn.createStatement();
			ResultSet rs = stmt.executeQuery("select MAX(scheduleCode) from ScheduleInfo");

			while(rs.next()){
				System.out.println("9999");
				String code = rs.getString("MAX(scheduleCode)");

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
				if(stmt != null) stmt.close();
			}
			catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		return codeString;
	}

*/
	public DayScheduleInfo selectCode(String scheduleCode){
		DayScheduleInfo info = null;
		PreparedStatement pstmt = null;
		try{
			String sql = "select * from ScheduleInfo where scheduleCode = ?";
			pstmt = daoConn.prepareStatement(sql);

			pstmt.setString(1,scheduleCode);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String scheduleCode1 = rs.getString("scheduleCode");
				String scheduleKindCode1 = rs.getString("scheduleKindCode");
				String scheduleName1 = rs.getString("scheduleName");
				java.sql.Date startDate1 = rs.getDate("startDate");
				java.sql.Date endDate1 = rs.getDate("endDate");
				String place1 = rs.getString("place");
				java.sql.Date alarm1 = rs.getDate("alarm");
				String image1 = rs.getString("image");
				String note1 = rs.getString("note");

				info = new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, new java.util.Date(startDate1.getTime()), new java.util.Date(endDate1.getTime()), place1, note1, new java.util.Date(alarm1.getTime()), image1);

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
		return info;
	}
	
	public DayScheduleInfo[] selectDate(/*java.util.Date startDate, java.util.Date startDate2*/){
		DayScheduleInfo []info = null;
		PreparedStatement pstmt = null;
		ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();
		//java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
		//java.sql.Date sqlStartDate2 = new java.sql.Date(startDate2.getTime());
		try{
			//String sql = "select * from ScheduleInfo where startDate >= ? AND endDate < TO_DATE(?) + interval '1' day";
			String sql = "select * from ScheduleInfo";
			pstmt = daoConn.prepareStatement(sql);
			//pstmt.setDate(1,sqlStartDate);
			//pstmt.setDate(2,sqlStartDate2);
			ResultSet rs = pstmt.executeQuery();

			//String sql = "select * from ScheduleInfo where scheduleName = ? AND startDate >= ? AND endDate < TO_DATE(?) + interval '1' day";
			//System.out.println("안들어오나");			
			while(rs.next()){
				//System.out.println("안들어오나");

				String scheduleCode1 = rs.getString("scheduleCode");	//System.out.println("scheduleCode is  "+ scheduleCode1);

				String scheduleKindCode1 = rs.getString("scheduleKindCode"); //System.out.println("scheduleKindCode is  "+scheduleKindCode1);
				String scheduleName1 = rs.getString("scheduleName");  //System.out.println("scheduleName is  "+scheduleName1);
				
				java.sql.Date startDate1 = rs.getDate("startDate"); //System.out.println("startDate is  "+startDate1);
				Time startTime = rs.getTime("startDate"); //System.out.println("startDate is  "+startTime);
				
				java.sql.Date endDate1 = rs.getDate("endDate"); //System.out.println("endDate is  "+endDate1);
				Time endTime = rs.getTime("endDate"); 

				//java.sql.Date endDate1 = new java.sql.Date((rs.getDate("endDate")).getTime()); System.out.println("endDate is  "+endDate1);
				
				String place1 = rs.getString("place");  // System.out.println("place is  "+place1);
				
				java.sql.Date alarm1 = rs.getDate("alarm"); //System.out.println("alarm is  "+alarm1);
				Time alarmTime = rs.getTime("alarm");
				//java.sql.Date alarm1 = new java.sql.Date((rs.getDate("alarm")).getTime()); System.out.println("alarm is  "+alarm1);
				
				String image1 = rs.getString("image"); //System.out.println("image is  "+image1);
				String note1 = rs.getString("note");	//		System.out.println("note is  "+note1);	

				

				//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
				list.add(new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, 
					new java.util.Date(startDate1.getYear(), startDate1.getMonth(),startDate1.getDate(),startTime.getHours(), startTime.getMinutes()), 
					new java.util.Date(endDate1.getYear(), endDate1.getMonth(), endDate1.getDate(), endTime.getHours(), endTime.getMinutes()), place1, note1, 
					new java.util.Date(alarm1.getYear(), alarm1.getMonth(), alarm1.getDate(), alarmTime.getHours(), alarmTime.getMinutes()), image1));
				//System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");
				/*
				System.out.println("확인할거!!!!!!!!!!!!!!!!1");
				System.out.println();
				System.out.println(startTime.getHours());
				System.out.println(startTime.getMinutes());
				
				System.out.println(new java.util.Date(startDate1.getYear(), startDate1.getMonth(),startDate1.getDate(),startTime.getHours(), startTime.getMinutes()));
				System.out.println(new java.util.Date(endDate1.getYear(), endDate1.getMonth(), endDate1.getDate(), endTime.getHours(), endTime.getMinutes()));
				System.out.println(new java.util.Date(alarm1.getYear(), alarm1.getMonth(), alarm1.getDate(), alarmTime.getHours(), alarmTime.getMinutes()));
				
				System.out.println("확인할거!!!!!!!!!!!!!!!!1");
				*/
			}
			info = new DayScheduleInfo[list.size()];
			for(int cnt=0; cnt<list.size(); cnt++){
				info[cnt] = list.get(cnt);
			}
		}
		catch(SQLException se){
			se.printStackTrace();
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
		return info;
	
	}
	public DayScheduleInfo[] selectName(String scheduleName, java.util.Date startDate, java.util.Date endDate){
		DayScheduleInfo []info = null;
		PreparedStatement pstmt = null;
		ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();

		java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
		
		//System.out.println("Here You Are");
		//System.out.println(sqlStartDate);
		//System.out.println(sqlEndDate);
		
		try{
			String sql = "select * from ScheduleInfo where scheduleName = ? AND startDate >= ? AND endDate < TO_DATE(?) + interval '1' day";
			pstmt = daoConn.prepareStatement(sql);
			
			pstmt.setString(1,scheduleName);
			pstmt.setDate(2,sqlStartDate);
			pstmt.setDate(3,sqlEndDate);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String scheduleCode1 = rs.getString("scheduleCode");	//System.out.println("scheduleCode is  "+ scheduleCode1);

				String scheduleKindCode1 = rs.getString("scheduleKindCode"); //System.out.println("scheduleKindCode is  "+scheduleKindCode1);
				String scheduleName1 = rs.getString("scheduleName");  //System.out.println("scheduleName is  "+scheduleName1);
				
				java.sql.Date startDate1 = rs.getDate("startDate"); //System.out.println("startDate is  "+startDate1);
				Time startTime = rs.getTime("startDate"); //System.out.println("startDate is  "+startTime);
				
				java.sql.Date endDate1 = rs.getDate("endDate"); //System.out.println("endDate is  "+endDate1);
				Time endTime = rs.getTime("endDate"); 

				//java.sql.Date endDate1 = new java.sql.Date((rs.getDate("endDate")).getTime()); System.out.println("endDate is  "+endDate1);
				
				String place1 = rs.getString("place");   //System.out.println("place is  "+place1);
				
				java.sql.Date alarm1 = rs.getDate("alarm"); //System.out.println("alarm is  "+alarm1);
				Time alarmTime = rs.getTime("alarm");
				//java.sql.Date alarm1 = new java.sql.Date((rs.getDate("alarm")).getTime()); System.out.println("alarm is  "+alarm1);
				
				String image1 = rs.getString("image"); //System.out.println("image is  "+image1);
				String note1 = rs.getString("note");			//System.out.println("note is  "+note1);	

				//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
				list.add(new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, 
					new java.util.Date(startDate1.getYear(), startDate1.getMonth(),startDate1.getDate(),startTime.getHours(), startTime.getMinutes()), 
					new java.util.Date(endDate1.getYear(), endDate1.getMonth(), endDate1.getDate(), endTime.getHours(), endTime.getMinutes()), place1, note1, 
					new java.util.Date(alarm1.getYear(), alarm1.getMonth(), alarm1.getDate(), alarmTime.getHours(), alarmTime.getMinutes()), image1));
				//System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");
			}
			info = new DayScheduleInfo[list.size()];
			for(int cnt=0; cnt<list.size(); cnt++){
				info[cnt] = list.get(cnt);
			}
		}
		catch(SQLException se){
			se.printStackTrace();
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
		return info;
		
	}

	public DayScheduleInfo[] selectName(String scheduleName){
		DayScheduleInfo []info = null;
		PreparedStatement pstmt = null;
		ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();
		try{
			String sql = "select * from ScheduleInfo where scheduleName = ?";
			pstmt = daoConn.prepareStatement(sql);

			pstmt.setString(1,scheduleName);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String scheduleCode1 = rs.getString("scheduleCode");
				
				String scheduleKindCode1 = rs.getString("scheduleKindCode");
				

				String scheduleName1 = rs.getString("scheduleName");
				java.sql.Date startDate1 = rs.getDate("startDate");
				java.sql.Date endDate1 = rs.getDate("endDate");
				String place1 = rs.getString("place");
				java.sql.Date alarm1 = rs.getDate("alarm");
				String image1 = rs.getString("image");
				String note1 = rs.getString("note");				

				list.add(new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, new java.util.Date(startDate1.getTime()), new java.util.Date(endDate1.getTime()), place1, note1, new java.util.Date(alarm1.getTime()), image1));

			}

			info = new DayScheduleInfo[list.size()];
			for(int cnt=0; cnt<list.size(); cnt++){
				info[cnt] = list.get(cnt);
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
		return info;
	}
	


	public static void main(String []args){
		ScheduleInfoDBDAO dao = new ScheduleInfoDBDAO();

		//System.out.println(dao.insert("1111","2","테스트",new java.util.Date(2015,5,28), new java.util.Date(2015,5,28), "렉토피아", new java.util.Date(2015,4,4), "이미지","노트노트"));
		//System.out.println(dao.update("1111","4","테스트수정",new java.util.Date(2015,5,28), new java.util.Date(2015,5,28), "렉토피아", new java.util.Date(2015,4,4), "이미지수정","노트노트수정"));
		//System.out.println(dao.insert("2222","2","테스트",new java.util.Date(2015,5,28), new java.util.Date(2015,5,28), "렉토피아", new java.util.Date(2015,4,4), "이미지","노트노트"));
		//System.out.println(dao.insert("3333","2","테스트",new java.util.Date(2015,5,28), new java.util.Date(2015,5,28), "렉토피아", new java.util.Date(2015,4,4), "이미지","노트노트"));
		
		/*
		DayScheduleInfo[] info = dao.selectName("테스트");
		for(int cnt=0; cnt<info.length; cnt++){
			System.out.println(info[cnt]);
		}
		System.out.println(dao.selectCode("1111"));
		*/

		//System.out.println(dao.insert("5555","2","테스트",new java.util.Date(2015,5,29), new java.util.Date(2015,5,29), "렉토피아", new java.util.Date(2015,4,4), "이미지","노트노트"));
		//System.out.println(dao.insert("6666","2","테스트",new java.util.Date(2015,5,30), new java.util.Date(2015,5,30), "렉토피아", new java.util.Date(2015,4,4), "이미지","노트노트"));

		System.out.println("rrrrrrrr");
		
		
		DayScheduleInfo[] info = dao.selectName("테스트", new java.util.Date(2015-1900,5,29), new java.util.Date(2015-1900,5,30));
		if(info != null){
		for(int cnt=0; cnt<info.length; cnt++){
			System.out.println(info[cnt]);
		}
		}
	
		
		//System.out.println(dao.selectCode("1111"));
		

	}

} 