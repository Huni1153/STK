import java.util.*;
import java.text.*;
public class DeleteDayScheduleInfoController
{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;
   //����
   private final ScheduleDBDAO scheduleDBDAO;

   public DeleteDayScheduleInfoController(){
      this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();
	  this.scheduleDBDAO = ScheduleDBDAO.getInstance();
   }
   public DeleteDayScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO, ScheduleDBDAO scheduleDBDAO){
      this.dayScheduleInfoDAO = dayScheduleInfoDAO;
	  this.scheduleDBDAO = scheduleDBDAO;
   }
   public boolean requestDeleteDayScheduleInfo(String scheduleCode){
      return dayScheduleInfoDAO.deleteDayScheduleInfo(scheduleCode);
   }
   //DB�� �����ϱ�
   public int deleteScheduleInfoToDB(String scheduleCode){
	  System.out.println("���� DB�� �����ϴ� Method");

	  return this.scheduleDBDAO.deleteDayScheduleInfo(scheduleCode);
	 
   }
}