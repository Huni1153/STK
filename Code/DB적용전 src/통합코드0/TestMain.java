import java.util.*;

public class TestMain
{
	public static void main(String []args){
		
		/*
		DayScheduleInfo obj1 = new DayScheduleInfo("�ް�","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");
		DayScheduleInfo obj2 = new DayScheduleInfo("�ް�","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");
		DayScheduleInfo obj3 = new DayScheduleInfo("�ް�","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");
		DayScheduleInfo obj4 = new DayScheduleInfo("�ް�","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");

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
		DayScheduleInfo obj1 = new DayScheduleInfo("����","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj1);
		DayScheduleInfo obj2 = new DayScheduleInfo("����","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj2);
		DayScheduleInfo obj3 = new DayScheduleInfo("����","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj3);
		DayScheduleInfo obj4 = new DayScheduleInfo("����","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");		
		DayScheduleInfoDAO.getInstance().addDayScheduleInfo(obj4);
		DayScheduleInfo obj5 = new DayScheduleInfo("����","�ų����ް�",new Date(), new Date(), "���ȸ�", "����ϴ� ������ �Բ�", new Date(), "C/Image");		
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