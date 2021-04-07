class GirlFriend extends Thread
{
	public void run()
	{
		System.out.println("Girl : 약속장소 가는중...");
		for(int i=0; i<10; i++)
		{
			System.out.println(i+1+"분 경과");
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
		System.out.println("Girl : 도착");
	}
}

class BoyFriend extends Thread
{
	public void run()
	{
		GirlFriend ksy = new GirlFriend();
		ksy.start();

		System.out.println("Boy : 약속장소 도착...");
		try
		{ 
			ksy.join(3000);
			ksy.join();
		}
		catch (InterruptedException e)
		{
		}
		System.out.println("Boy : 같이 영화보러 간다.");
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
