package Model;
//ModifyScheduleInfoController modifyController = new ModifyScheduleInfoController();
//modifyController.modifyScheduleInfo(kind, title, startDate, endDate, place, memo, alarmTemp, image);
import java.util.*;
public class ModifyScheduleInfoController
{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;
   //����
   private final ScheduleDBDAO scheduleDBDAO;
   

   public ModifyScheduleInfoController(){
      this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();
	  this.scheduleDBDAO = ScheduleDBDAO.getInstance();
   }
   public ModifyScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO, ScheduleDBDAO scheduleDBDAO)
   {
      this.dayScheduleInfoDAO = dayScheduleInfoDAO;
	  this.scheduleDBDAO = scheduleDBDAO;
   }
   public boolean modifyCheck(String scheduleCode, String scheduleName)
   {
      return true;
   }
   //�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѽ��� ���ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�//
   public boolean modifyScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
   {
      this.dayScheduleInfoDAO.modifyDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
      return true;
   }

   //DB�� �����ϱ�
   public int modifyScheduleInfoToDB(String scheduleCode, String scheduleKind, String scheduleName, Date startDay, Date endDay, String place, String note, Date alarm, String image){
      System.out.println("���� DB�� �����ϴ� Method");
	  return this.scheduleDBDAO.updateDayScheduleInfo(scheduleCode, convertKindToCode(scheduleKind), scheduleName, startDay, endDay, place, alarm, image, note);
   }



   
   /*public boolean modifyScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
   {
      this.dayScheduleInfoDAO.modifyDayScheduleInfo(scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
      return true;
   }*/


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