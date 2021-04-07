public class  Account
{
	private String accountNo;
	private String ownerName;
	private int balance;

	public Account()
	{
		this.accountNo = "";
		this.ownerName = "";
		this.balance = 0;
	}
	public Account(String accountNo, String ownerName, int balance)
	{
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	public String getAccountNo()
	{
		return this.accountNo;
	}
	public String getOwnerName()
	{
		return this.ownerName;
	}
	public int getBalance()
	{
		return this.balance;
	}

	public int deposit(int balance)
	{
		System.out.println(" ## �Ա��մϴ�~~ ");
		this.balance += balance;
		return this.balance;
	}
	public int withdraw(int amount) throws Exception
	{
		if(this.balance < amount)
		{
			throw new Exception(" �ܾ��� �����մϴ�. ");
		}
		System.out.println(" ## ����մϴ�~~ ");
		this.balance -= amount;
		return amount;
	}

	public String toString()	// toString() �������̵�
	{
		String str = "���� : " + accountNo +
					"\n������ �̸� : " + ownerName +
					"\n�ܾ� : " + balance + "\n";
		return str;
	}

}
