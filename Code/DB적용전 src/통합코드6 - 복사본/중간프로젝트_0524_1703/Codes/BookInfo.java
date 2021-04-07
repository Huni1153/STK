import java.io.*;

public class  BookInfo extends GoodsInfo implements Serializable
{
	 private String writer;
	private int page;

	public BookInfo()
	{
		super(null, null, 0);
	}
	public BookInfo(String code, String name, int price, String writer, int page)
	{
		super(code, name, price);
		this.writer = writer;
		this.page = page;
	}
	public void setWriter(String writer)
	{
		this.writer = writer;
	}
	public void setPage(int page)
	{
		this.page = page;
	}
	public String getWriter()
	{
		return this.writer;
	}
	public int getPage()
	{
		return this.page;
	}
	
	public String toString()
	{
		String str = super.toString() + writer + " / p" + page;
		return str;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException
	{

		out.defaultWriteObject();
	}
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		
		in.defaultReadObject();
	}
}
