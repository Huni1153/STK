import java.io.*;

public class GoodsInfo22 implements java.io.Serializable
{
	private String code;
	transient private String name;
	private int price;

	public GoodsInfo22()
	{
		this.code = "";
		this.name = "";
		this.price = 0;
	}
	public GoodsInfo22(String code, String name , int price)
	{
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getCode()
	{
		return this.code;
	}
	public String getName()
	{
		return this.name;
	}
	public int getPrice()
	{
		return this.price;
	}

	public void setCode()
	{
		this.code = code;
	}
	public void setName()
	{
		this.name = name;
	}
	public void setPrice()
	{
		this.price = price;
	}

	public String toString()
	{
		String str = code + " / " + name + " / " + price + "�� / " ;
		return str;
	}
}

