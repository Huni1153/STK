import java.sql.*;

public class StudyContentsInfoDBDAO
{//대섭 0529_1236
	final private DBConnectionModule connModule = DBConnectionModule.getInstance();
	private Connection daoConn;

	public StudyContentsInfoDBDAO()
	{
		daoConn = connModule.getConn();
	}

	public DBConnectionModule getConnModule()
	{
		return this.connModule;
	}

	public int insert(String documentCode, String codeSection, String noteSection)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String url = "insert into StudyContentsInfo values(?,?,?)";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setString(1, documentCode);
			pstmt.setString(2, codeSection);
			pstmt.setString(3, noteSection);

			rowNum = pstmt.executeUpdate();
			if( rowNum == 1)
			{
				daoConn.commit();
			}
			else
			{
				daoConn.rollback();
			}
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( pstmt != null)
				{
					pstmt.close();
				}
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return rowNum;
	}

	public int delete(String documentCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String url = "delete from StudyContentsInfo where documentCode = ?";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setString(1, documentCode);

			rowNum = pstmt.executeUpdate();
			/*if(rowNum == 1)
			{
				daoConn.commit();
			}
			else
			{
				daoConn.rollback();
			}*/
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(pstmt!=null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return rowNum;
	}

	public int updateCodeSection(String documentCode, String codeSection)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String url = "update StudyContentsInfo set codeSection = ? where documentCode = ?";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setString(1, codeSection);
			pstmt.setString(2, documentCode);

			rowNum = pstmt.executeUpdate();
			/*if( rowNum == 1)
			{
				daoConn.commit();
			}
			else
			{
				daoConn.rollback();
			}*/
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( pstmt != null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return rowNum;
	}

	public int updateNoteSection(String documentCode, String noteSection)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String url = "update StudyContentsInfo set noteSection = ? where documentCode = ?";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setString(1, noteSection);
			pstmt.setString(2, documentCode);

			rowNum = pstmt.executeUpdate();
			/*if( rowNum == 1)
			{
				daoConn.commit();
			}
			else
			{
				daoConn.rollback();
			}*/
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( pstmt != null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return rowNum;
	}

	public int update(String documentCode, String codSection, String noteSection)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String url = "update StudyContentsInfo set codeSection = ? , noteSection = ? where documentCode = ?";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setString(1, codSection);
			pstmt.setString(2, noteSection);
			pstmt.setString(3, documentCode);

			rowNum = pstmt.executeUpdate();
			/*if( rowNum == 1)
			{
				daoConn.commit();
			}
			else
			{
				daoConn.rollback();
			}*/
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( pstmt != null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return rowNum;
	}

	public StudyContentsInfo select(String documentCode)
	{
		StudyContentsInfo info = null;
		PreparedStatement pstmt = null;
		try
		{
			String url = "select * from StudyContentsInfo where documentCode = ?";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setString(1, documentCode);

			ResultSet rs = pstmt.executeQuery();
			while ( rs.next() )
			{
				String docCode = rs.getString("documentCode");
				String codeSec = rs.getString("codeSection");
				String noteSec = rs.getString("noteSection");
				if(noteSec == null)
					noteSec = "";

				info = new StudyContentsInfo(new StringBuilder(codeSec), new StringBuilder(noteSec));
			}
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (pstmt != null)
				{
					pstmt.close();
				}
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return info;
	}

/*
	public static void main(String[] args)
	{
		StudyContentsInfoDAO dao = StudyContentsInfoDAO.getInstance();

		//dao.insert("155111002", "public class Run2() { }", "Run2 클래스 입니다");
		System.out.println( dao.select("15591001") );

		//dao.update("155101001", "public class Run33() { }", "Run33 클래스 입니다");
		//System.out.println( dao.select("155101001") );

		//dao.delete("155101001");
		//System.out.println( dao.select("155101001") );
	}
	*/
}