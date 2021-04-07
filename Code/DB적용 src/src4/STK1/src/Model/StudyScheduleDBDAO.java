package Model;
import java.sql.*;
import java.util.*;

public class StudyScheduleDBDAO
{//대섭 0529_1236
	final private DBConnectionModule connModule = DBConnectionModule.getInstance();
	private Connection daoConn;

	public StudyScheduleDBDAO()
	{
		daoConn = connModule.getConn();
	}
	public StudyScheduleDBDAO(Connection daoConn)
	{
		this.daoConn = daoConn;
	}

	public DBConnectionModule getConnModule()
	{
		return this.connModule;
	}

	public int delete(String studyScheduleCode)
	{
		int rowNum = 0;
		PreparedStatement pstmt = null;
		try
		{
			String sql = "delete from StudySchedule where studyScheduleCode = ?";
			pstmt = daoConn.prepareStatement(sql);
			pstmt.setString(1, studyScheduleCode);

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

	public DayScheduleInfo[] selectScheduleCode( java.util.Date studyScheduleDate)
	{
		java.sql.Date d = new java.sql.Date(studyScheduleDate.getTime());

		ArrayList<DayScheduleInfo> schList = new ArrayList<DayScheduleInfo>();
		DayScheduleInfo schInfo = null;
		PreparedStatement pstmt = null;
		String scheduleCode = "";
		ResultSet rs = null;
		try
		{
			String url = "select distinct(scheduleCode) from StudySchedule where ? >= trunc(studyScheduleDate) and ? < trunc(studyScheduleDate+1)";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setDate(1, d);
			pstmt.setDate(2, d);

			rs = pstmt.executeQuery();
			while( rs.next() )
			{
				scheduleCode = rs.getString("scheduleCode");

				schInfo = new ScheduleInfoDBDAO().selectCode(scheduleCode);
				schList.add(schInfo);
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
				if(pstmt != null)
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return schList.toArray( new DayScheduleInfo[schList.size()] );
	}



	public StudyDocumentInfo[] selectDocumentCode(java.util.Date studyScheduleDate)
	{
		java.sql.Date d = new java.sql.Date( studyScheduleDate.getTime() );

		ArrayList<StudyDocumentInfo> docList = new ArrayList<StudyDocumentInfo>();
		StudyDocumentInfo docInfo = null;
		PreparedStatement pstmt = null;
		String documentCode = "";
		ResultSet rs = null;
		try
		{
			String url = "select * from StudySchedule where ? >= trunc(studyScheduleDate) and ? < trunc(studyScheduleDate+1)";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setDate(1, d);
			pstmt.setDate(2, d);

			rs = pstmt.executeQuery();
			while( rs.next() )
			{
				documentCode = rs.getString("documentCode");
				docInfo = new StudyDocumentInfoDBDAO().selectCode(documentCode);
				docList.add(docInfo);
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
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		return docList.toArray( new StudyDocumentInfo[docList.size()] );
	}



/*  Deprecated
	public StudyDocumentInfo[] selectDocumentCode(java.util.Date studyScheduleDate)
	{
		java.sql.Date d = new java.sql.Date( studyScheduleDate.getTime() );

		ArrayList<StudyDocumentInfo> docList = new ArrayList<StudyDocumentInfo>();
		StudyDocumentInfo docInfo = null;
		StudyContentsInfo conInfo = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String documentCode = "";
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try
		{
			String url = "select * from StudySchedule where ? >= trunc(studyScheduleDate) and ? < trunc(studyScheduleDate+1)";
			pstmt = daoConn.prepareStatement(url);
			pstmt.setDate(1, d);
			pstmt.setDate(2, d);

			rs = pstmt.executeQuery();
			while( rs.next() )
			{
				documentCode = rs.getString("documentCode");

				url = "select * from StudyDocumentInfo where documentCode = ?";
				pstmt = daoConn.prepareStatement(url);
				pstmt.setString(1, documentCode);

				rs1 = pstmt.executeQuery();
				while( rs1.next() )
				{
					String documentCode1 = rs1.getString("documentCode");
					String documentName1 = rs1.getString("documentName");
					java.util.Date documentDate1 = (java.util.Date)rs1.getDate("documentDate");
					String documentPath1 = rs1.getString("documentPath");
					String documentForm1 = rs1.getString("documentForm");

					url = "select * from StudyContentsInfo where documentCode = ?";
					pstmt2 = daoConn.prepareStatement(url);
					pstmt2.setString(1, documentCode1);

					rs2 = pstmt2.executeQuery();
					while( rs2.next() )
					{
						String codeSection1 = rs2.getString("codeSection");
						String noteSection1 = rs2.getString("noteSection");

						conInfo = new StudyContentsInfo( new StringBuilder(codeSection1), new StringBuilder(noteSection1));
					}

					docInfo = new StudyDocumentInfo( documentCode1, documentName1, documentDate1, documentPath1, conInfo, documentForm1);
					docList.add(docInfo);
				}
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
					pstmt.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}

		}

		return docList.toArray( new StudyDocumentInfo[docList.size()] );
	}
*/


	//Deprecated
	public DayScheduleInfo[] selectScheduleCode(String studyScheduleCode, String scheduleCode)
	{
		return null;
	}

	private boolean selectScheduleCheck( String studyScheduleCode, String scheduleCode)
	{// 미확정
		return false;
	}

	//Deprecated
	public StudyDocumentInfo[] selectDocumentCode( String studyScheduleCode, String documentCode)
	{
		return null;
	}

	private boolean selectDocumentCheck( String studyScheduleCode, String documentCode)
	{// 미확정
		return false;
	}

	public static void main(String[] args)
	{
		StudyScheduleDBDAO con =new StudyScheduleDBDAO();
		DayScheduleInfo[] infoArr = con.selectScheduleCode( new java.util.Date() );
		for(DayScheduleInfo info : infoArr)
		{
			System.out.println( info );
		}

		System.out.println( "-------------------------------------------" );

		StudyDocumentInfo[] docArr = con.selectDocumentCode( new java.util.Date() );
		for( StudyDocumentInfo info : docArr)
		{
			System.out.println( info );
		}
	}
}