import java.util.*;

public class TestMain
{
	public static void main(String []args){
		
		/*
		DayScheduleInfo obj1 = new DayScheduleInfo("휴가","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj2 = new DayScheduleInfo("휴가","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj3 = new DayScheduleInfo("휴가","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj4 = new DayScheduleInfo("휴가","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");

		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj1);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj2);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj3);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj4);


		for(int cnt=0; cnt<DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().size(); cnt++){
			System.out.println(DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().get(cnt));
			System.out.println();
		}
*/
		DayScheduleInfoDAO.getInstance().fileSave();
		
		
		
		DayScheduleInfoDAO.getInstance().fileLoad();
		
		for(int cnt=0; cnt<DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().size(); cnt++){
			System.out.println(DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().get(cnt));
			System.out.println();	

		}
		/*
		DayScheduleInfo obj1 = new DayScheduleInfo("공부","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj1);
		DayScheduleInfo obj2 = new DayScheduleInfo("공부","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj2);
		DayScheduleInfo obj3 = new DayScheduleInfo("공부","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj3);
		DayScheduleInfo obj4 = new DayScheduleInfo("공부","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj4);
		DayScheduleInfo obj5 = new DayScheduleInfo("공부","신나는휴가",new Date(), new Date(), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj5);
		*/

		System.out.println();System.out.println();

		for(int cnt=0; cnt<DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().size(); cnt++){
			System.out.println(DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().get(cnt));
			System.out.println();
		}

		//DayScheduleInfoDAO.getInstance().fileSave();
	}
}