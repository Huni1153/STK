import java.sql.*;
import java.util.*;
import java.util.Date;

class StudyDocumentInfoDBDAO
{
	private StudyContentsInfoDBDAO daoContents;
	private final DBConnectionModule connModule;
	private Connection daoConn;

	public StudyDocumentInfoDBDAO()
	{
		this.connModule=this.connModule.getInstance();
		this.daoConn=this.connModule.getConn();
	}
	public StudyDocumentInfoDBDAO(DBConnectionModule connModule)
	{
		this.connModule=connModule;
	}
	public DBConnectionModule getConnModule()
	{
		return this.connModule;
	}

	public int insert(String documentCode,String documentName,java.util.Date documentDate,String documentPath,String documentForm)
	{
		int row=0;
		java.sql.Date date=new java.sql.Date(documentDate.getTime());
		PreparedStatement ps=null;
		try
		{
			String sql="insert into studyDocumentInfo(documentCode,documentName,documentDate,documentPath,documentForm) values(?,?,?,?,?)";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentCode);
			ps.setString(2,documentName);
			ps.setDate(3,date);
			ps.setString(4,documentPath);
			ps.setString(5,documentForm);
			row=ps.executeUpdate();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return row;
	}

	public int updateName(String documentCode,String documentName)
	{
		int row=0;
		PreparedStatement ps=null;
		try
		{
			String sql="update studyDocumentInfo set documentName=? where documentCode=?";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentName);
			ps.setString(2,documentCode);
			row=ps.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return row;
	}

	public int updateDate(String documentCode,java.util.Date documentDate)
	{
		int row=0;
		java.sql.Date date=new java.sql.Date(documentDate.getTime());
		PreparedStatement ps=null;
		try
		{
			String sql="update studyDocumentInfo set documentDate=? where documentCode=?";
			ps=this.daoConn.prepareStatement(sql);
			ps.setDate(1,date);
			ps.setString(2,documentCode);
			row=ps.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return row;
	}

	public int update(String documentCode,String documentName,java.util.Date documentDate)
	{
		int row=0;
		java.sql.Date date=new java.sql.Date(documentDate.getTime());
		PreparedStatement ps=null;
		try
		{
			String sql="update studyDocumentInfo set documentName=?,documentDate=? where documentCode=?";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentName);
			ps.setDate(2,date);
			ps.setString(3,documentCode);
			row=ps.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return row;
	}

	public int delete(String documentCode)
	{
		int row=0;
		PreparedStatement ps=null;
		try
		{
			String sql="delete from studyDocumentInfo where documentCode=?";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentCode);
			row=ps.executeUpdate();
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return row;
	}
	public SimpleDocument[] selectAll()
	{
		int i=0;
		LinkedList<SimpleDocument> list=new LinkedList<SimpleDocument>();
		SimpleDocument sDocument=null;
		SimpleDocument[] rDocument=null;
		PreparedStatement ps=null;
		try
		{
			String sql="select * from StudyDocumentInfo";
			ps=this.daoConn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String rDocumentCode=rs.getString("documentCode");
				String rDocumentName=rs.getString("documentName");
				String rDocumentPath=rs.getString("documentPath");
				sDocument=new SimpleDocument(rDocumentName,rDocumentCode,rDocumentPath);
				list.add(sDocument);
			}
			rDocument=new SimpleDocument[list.size()];
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				sDocument=(SimpleDocument)iterator.next();
				rDocument[i]=sDocument;
				i++;
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return rDocument;
	}
	public StudyDocumentInfo selectCode(String documentCode)
	{
		this.daoContents=new StudyContentsInfoDBDAO();
		this.daoContents.select(documentCode);
		StudyDocumentInfo document=null;
		PreparedStatement ps=null;
		try
		{
			String sql="select * from StudyDocumentInfo where documentCode=?";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentCode);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String rDocumentCode=rs.getString("documentCode");
				String rDocumentName=rs.getString("documentName");
				java.util.Date rDocumentDate=rs.getDate("documentDate");
				String rDocumentPath=rs.getString("documentPath");
				String rDocumentForm=rs.getString("documentForm");
				document=new StudyDocumentInfo(rDocumentCode,rDocumentName,rDocumentDate,rDocumentPath,daoContents.select(rDocumentCode),rDocumentForm);
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return document;
	}
	public StudyDocumentInfo[] selectName(String documentName)
	{
		int i=0;
		LinkedList<StudyDocumentInfo> list=new LinkedList<StudyDocumentInfo>();
		this.daoContents=new StudyContentsInfoDBDAO();
		StudyDocumentInfo document=null;
		StudyDocumentInfo[] rDocument=null;
		PreparedStatement ps=null;
		try
		{
			String sql="select * from StudyDocumentInfo where documentName=? ";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String rDocumentCode=rs.getString("documentCode");
				String rDocumentName=rs.getString("documentName");
				java.util.Date rDocumentDate=rs.getDate("documentDate");
				String rDocumentPath=rs.getString("documentPath");
				String rDocumentForm=rs.getString("documentForm");
				document=new StudyDocumentInfo(rDocumentCode,rDocumentName,rDocumentDate,rDocumentPath,this.daoContents.select(rDocumentCode),rDocumentForm);
				list.add(document);
			}
			rDocument=new StudyDocumentInfo[list.size()];
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				document=(StudyDocumentInfo)iterator.next();
				rDocument[i]=document;
				i++;
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return rDocument;
	}
	public StudyDocumentInfo[] selectPath(String documentPath)
	{
		int i=0;
		LinkedList<StudyDocumentInfo> list=new LinkedList<StudyDocumentInfo>();
		this.daoContents=new StudyContentsInfoDBDAO();
		StudyDocumentInfo document=null;
		StudyDocumentInfo[] rDocument=null;
		PreparedStatement ps=null;
		try
		{
			String sql="select * from StudyDocumentInfo where documentPath=?";
			ps=this.daoConn.prepareStatement(sql);
			ps.setString(1,documentPath);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String rDocumentCode=rs.getString("documentCode");
				String rDocumentName=rs.getString("documentName");
				java.util.Date rDocumentDate=rs.getDate("documentDate");
				String rDocumentPath=rs.getString("documentPath");
				String rDocumentForm=rs.getString("documentForm");
				document=new StudyDocumentInfo(rDocumentCode,rDocumentName,rDocumentDate,rDocumentPath,this.daoContents.select(rDocumentCode),rDocumentForm);
				list.add(document);
			}
			rDocument=new StudyDocumentInfo[list.size()];
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				document=(StudyDocumentInfo)iterator.next();
				rDocument[i]=document;
				i++;
			}					
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return rDocument;
	}
	public static void main(String[] args)
	{
//		StudyDocumentInfoDAO obj=new StudyDocumentInfoDAO();
//		StudyDocumentInfo res;
//		StudyDocumentInfo[] aRes=obj.selectPath("15/5/15");
//		res=obj.selectCode("155101001");
//		System.out.println(res);
//		for(int i=0;i<aRes.length;i++)
//		{
//			System.out.println(aRes[i]);
//		}
//		int re;
//		re=obj.insert("155281005","TestMain",new Date(),"15/5/28",".java");
//		System.out.println(re);
//		res=obj.selectCode("155281003");
//		System.out.println(res);
//		re=obj.updateName("155281002","�׽�Ʈ!!");
//		System.out.println(re);*/

	}
}