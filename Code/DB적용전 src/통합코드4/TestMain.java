import java.util.*;

public class TestMain
{
	public static void main(String []args){
		
		DayScheduleInfo obj1 = new DayScheduleInfo("휴가","신나는휴가",new Date(2015,5,10,11,30), new Date(2015,5,10,19,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj2 = new DayScheduleInfo("휴가","신나는휴가",new Date(2015,5,11,12,30), new Date(2015,5,11,14,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj3 = new DayScheduleInfo("휴가","신나는휴가",new Date(2015,5,12,9,30), new Date(2015,5,12,11,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj4 = new DayScheduleInfo("휴가","신나는휴가",new Date(2015,5,10,12,30), new Date(2015,5,10,14,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj5 = new DayScheduleInfo("휴가","신나는휴가",new Date(2016,5,10,12,30), new Date(2016,5,10,14,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj6 = new DayScheduleInfo("이론","열공하기!!",new Date(2015,5,10,9,30), new Date(2015,5,10,10,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj7 = new DayScheduleInfo("실습","실습하기!!",new Date(2015,5,10,21,30), new Date(2015,5,10,22,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		DayScheduleInfo obj8 = new DayScheduleInfo("실습","실습하기!!",new Date(2015,5,10,1,30), new Date(2015,5,10,2,30), "광안리", "사랑하는 사람들과 함께", new Date(), "C/Image");
		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj1);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj2);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj3);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj4);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj5);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj6);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj7);
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj8);
		//DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj8);

		for(int cnt=0; cnt<DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().size(); cnt++){
			System.out.println(DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().get(cnt));
			System.out.println();
		}

		DayScheduleInfoDAO.getInstance().fileSave();
		
		
		
		DayScheduleInfoDAO.getInstance().fileLoad();
		
		for(int cnt=0; cnt<DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().size(); cnt++){
			System.out.println(DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().get(cnt));
			System.out.println();	

		}
		
		//같이 묶어여 할 코드!! 중요 중요!!
		DayScheduleInfoDAO.getInstance().setLatestCodeNum();
		System.out.println(DayScheduleInfo.getCodeNum());
		System.out.println();
		DisplayInfoController controller = new DisplayInfoController();

		String [][] str = controller.requestProvideAllInfo();

		for(int row=0; row<str.length; row++){
			for(int col=0; col<21; col++){
				System.out.println(str[row][col]);
			}
		}


		System.out.println();System.out.println();

		//controller.getOnlyAMonthInfo("5");
		
		System.out.println();System.out.println();

		AMonthDayInfoController monthController = new AMonthDayInfoController(controller);

		//monthController.getOnlyAMonthInfo("2015","5");
		monthController.getOnlyAMonthInfo("2015","5");
		monthController.divideDayPerSchedule();

		SimpleDayInfoController simpleController = new SimpleDayInfoController("2015","5","10",controller);

		
	}
}