import java.util.*;
import java.text.*;
public class DeleteDayScheduleInfoController
{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;
   //수정
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
   //DB쪽 삭제하기
   public int deleteScheduleInfoToDB(String scheduleCode){
	  System.out.println("실제 DB로 삭제하는 Method");

	  return this.scheduleDBDAO.deleteDayScheduleInfo(scheduleCode);
	 
   }
}