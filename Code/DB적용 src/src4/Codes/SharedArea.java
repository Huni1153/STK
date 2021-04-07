public class SharedArea
{
	Account account1;
	Account account2;

	synchronized void transfer(int amount)
	{
		try
		{
			account1.withdraw(100000);
			System.out.println(" ������� : 10���� ����, ");
			account2.deposit(100000);
			System.out.println(" ������� : 10���� �Ա�");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	synchronized int getTotal()
	{
		return account1.getBalance() + account2.getBalance();
	}
}
