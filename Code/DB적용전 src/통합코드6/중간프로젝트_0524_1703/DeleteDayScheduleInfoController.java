import java.util.*;
import java.text.*;
public class DeleteDayScheduleInfoController
{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;

   public DeleteDayScheduleInfoController(){
      this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();
   }
   public DeleteDayScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO){
      this.dayScheduleInfoDAO = dayScheduleInfoDAO;
   }
   public boolean requestDeleteDayScheduleInfo(String scheduleCode){
      return dayScheduleInfoDAO.deleteDayScheduleInfo(scheduleCode);
   }
}