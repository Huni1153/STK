class GirlFriend extends Thread
{
	public void run()
	{
		System.out.println("Girl : ������ ������...");
		for(int i=0; i<10; i++)
		{
			System.out.println(i+1+"�� ���");
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			System.out.println();
		}
		System.out.println("Girl : ����");
	}
}

class BoyFriend extends Thread
{
	public void run()
	{
		GirlFriend ksy = new GirlFriend();
		ksy.start();

		System.out.println("Boy : ������ ����...");
		try
		{ 
			ksy.join(3000);
			ksy.join();
		}
		catch (InterruptedException e)
		{
		}
		System.out.println("Boy : ���� ��ȭ���� ����.");
	}
}

public class JoinTest
{
	public static void main(String[] args)
	{
		BoyFriend bf = new BoyFriend();
		bf.start();
	}
}
