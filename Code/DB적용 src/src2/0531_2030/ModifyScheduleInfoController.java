//ModifyScheduleInfoController modifyController = new ModifyScheduleInfoController();
//modifyController.modifyScheduleInfo(kind, title, startDate, endDate, place, memo, alarmTemp, image);
import java.util.*;
public class ModifyScheduleInfoController
{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;

   public ModifyScheduleInfoController(){
      this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();
   }
   public ModifyScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO)
   {
      this.dayScheduleInfoDAO = dayScheduleInfoDAO;
   }
   public boolean modifyCheck(String scheduleCode, String scheduleName)
   {
      return true;
   }
   //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ실제 사용ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
   public boolean modifyScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
   {
      this.dayScheduleInfoDAO.modifyDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
      return true;
   }
   /*public boolean modifyScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
   {
      this.dayScheduleInfoDAO.modifyDayScheduleInfo(scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
      return true;
   }*/
}