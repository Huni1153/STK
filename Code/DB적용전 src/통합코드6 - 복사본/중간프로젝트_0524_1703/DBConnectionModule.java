import java.sql.*;

public class DBConnectionModule
{
	private Connection conn;
	private String url;
	private String dbId;
	private String dbPwd;
	private static DBConnectionModule obj=new DBConnectionModule();
	
	public static DBConnectionModule getInstance()
	{
		return obj;
	}
	private DBConnectionModule()
	{
		this("jdbc:oracle:thin:@127.0.0.1:1521:XE","huni","1153");
	}
	private DBConnectionModule(String url,String dbId,String dbPwd)
	{
		this.url=url;
		this.dbId=dbId;
		this.dbPwd=dbPwd;
		this.connect();
	}
	private void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn=DriverManager.getConnection(this.url,this.dbId,this.dbPwd);
			this.conn.setAutoCommit(true);
		}
		catch(ClassNotFoundException cn)
		{
			System.out.println("해당 드라이버를 찾을 수 없습니다.\n"+cn.getMessage());
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
	public void disconnect()
	{
		try
		{
			if(this.conn!=null)
			{
				this.conn.close();
			}
		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
	}
	public void setConn(Connection conn)
	{
		this.conn=conn;
	}
	public void setUrl(String url)
	{
		this.url=url;
	}
	public void setDbId(String dbId)
	{
		this.dbId=dbId;
	}
	public void setDbPwd(String dbPwd)
	{
		this.dbPwd=dbPwd;
	}
	public Connection getConn()
	{
		return this.conn;
	}
	public String getUrl()
	{
		return this.url;
	}
	public String getDbId()
	{
		return this.dbId;
	}
	public String getDbPwd()
	{
		return this.dbPwd;
	}

}