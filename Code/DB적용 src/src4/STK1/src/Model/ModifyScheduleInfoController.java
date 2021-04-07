package Model;
//ModifyScheduleInfoController modifyController = new ModifyScheduleInfoController();
//modifyController.modifyScheduleInfo(kind, title, startDate, endDate, place, memo, alarmTemp, image);
import java.util.*;
public class ModifyScheduleInfoController
{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;
   //수정
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
   //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ실제 사용ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
   public boolean modifyScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
   {
      this.dayScheduleInfoDAO.modifyDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
      return true;
   }

   //DB쪽 수정하기
   public int modifyScheduleInfoToDB(String scheduleCode, String scheduleKind, String scheduleName, Date startDay, Date endDay, String place, String note, Date alarm, String image){
      System.out.println("실제 DB로 수정하는 Method");
	  return this.scheduleDBDAO.updateDayScheduleInfo(scheduleCode, convertKindToCode(scheduleKind), scheduleName, startDay, endDay, place, alarm, image, note);
   }



   
   /*public boolean modifyScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
   {
      this.dayScheduleInfoDAO.modifyDayScheduleInfo(scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
      return true;
   }*/


   public String convertKindToCode(String scheduleKind){
		String code = null;

		if(scheduleKind.equals("이론")) code = "1";
		else if(scheduleKind.equals("실습")) code = "2";
		else if(scheduleKind.equals("휴식")) code = "3";
		else if(scheduleKind.equals("운동")) code = "4";
		else if(scheduleKind.equals("정보 수집 단계")) code = "5";
		else if(scheduleKind.equals("유즈케이스 분석단계")) code = "6";
		else if(scheduleKind.equals("클래스 분석단계")) code = "7";
		else if(scheduleKind.equals("클래스 설계단계")) code = "8";
		else if(scheduleKind.equals("클래스 상세 설계단계")) code = "9";
		else if(scheduleKind.equals("소스코딩 및 디버깅 단계")) code = "10";
		else if(scheduleKind.equals("문서작업 및 발표준비단계")) code = "11";
		else if(scheduleKind.equals("최종 완료 단계")) code = "12";
		else if(scheduleKind.equals("휴가")) code = "13";
		else if(scheduleKind.equals("생일")) code = "14";
		else if(scheduleKind.equals("결혼 기념일")) code = "15";

		return code;
		
	
	}
}