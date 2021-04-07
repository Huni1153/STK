package Model;
import java.util.*;

public class AddScheduleInfoController
{
	private final DayScheduleInfoDAO dayScheduleInfoDAO;
	//����
	private final ScheduleDBDAO scheduleDBDAO;


	public AddScheduleInfoController()
	{
		this.dayScheduleInfoDAO=DayScheduleInfoDAO.getInstance();
		this.scheduleDBDAO = ScheduleDBDAO.getInstance();
	}
	public AddScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO, ScheduleDBDAO scheduleDBDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
		this.scheduleDBDAO = scheduleDBDAO;
	}
	public boolean addCheck(String scheduleCode,String scheduleName)
	{
		return true;
	}
	public boolean addScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		this.dayScheduleInfoDAO.addDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
		return true;
	}

	//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѽ��� ���ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�//
	public boolean addScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		System.out.println("������ DAO�� �߰� ��Ű�� �κ�!!");
		// convert�� �����ϴ� Method�� ù parameter���� ��µ� File���̹Ƿ� �Ƚᵵ �ɵ�
		//this.dayScheduleInfoDAO.addDayScheduleInfo(convertKindToCode(scheduleKind),scheduleName,startDay,endDay,place,note,alarm,image);
		this.dayScheduleInfoDAO.addDayScheduleInfo(convertKindToCode(scheduleKind),scheduleName,startDay,endDay,place,note,alarm,image);
		//����
		return true;
	}
	// DB�� �߰��ϱ�
	public int addScheduleInfoToDB(String scheduleKind, String scheduleName, Date startDate, Date endDate, String place, Date alarm, String image, String note){
		System.out.println("���� DB�� �߰��ϴ� Method!!");
		
		System.out.println("���⿩�⿩��!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(convertKindToCode(scheduleKind));
		/*
		System.out.println("StartDate Ȯ���ϱ�!!!!!!!!!!!!!!11");
		System.out.println(startDate);
		System.out.println("endDate Ȯ���ϱ�!!!!!!!!!!!!!!11");
		System.out.println(endDate);
		*/
		return this.scheduleDBDAO.insertDayScheduleInfo(convertKindToCode(scheduleKind), scheduleName, startDate, endDate, place, alarm, image, note);

	}


	//����
	public String convertKindToCode(String scheduleKind){
		String code = null;

		if(scheduleKind.equals("�̷�")) code = "1";
		else if(scheduleKind.equals("�ǽ�")) code = "2";
		else if(scheduleKind.equals("�޽�")) code = "3";
		else if(scheduleKind.equals("�")) code = "4";
		else if(scheduleKind.equals("���� ���� �ܰ�")) code = "5";
		else if(scheduleKind.equals("�������̽� �м��ܰ�")) code = "6";
		else if(scheduleKind.equals("Ŭ���� �м��ܰ�")) code = "7";
		else if(scheduleKind.equals("Ŭ���� ����ܰ�")) code = "8";
		else if(scheduleKind.equals("Ŭ���� �� ����ܰ�")) code = "9";
		else if(scheduleKind.equals("�ҽ��ڵ� �� ����� �ܰ�")) code = "10";
		else if(scheduleKind.equals("�����۾� �� ��ǥ�غ�ܰ�")) code = "11";
		else if(scheduleKind.equals("���� �Ϸ� �ܰ�")) code = "12";
		else if(scheduleKind.equals("�ް�")) code = "13";
		else if(scheduleKind.equals("����")) code = "14";
		else if(scheduleKind.equals("��ȥ �����")) code = "15";

		return code;
		
	
	}
}
