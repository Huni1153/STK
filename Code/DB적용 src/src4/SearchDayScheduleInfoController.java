import java.util.*;
import java.text.*;
public class SearchDayScheduleInfoController{
   private final DayScheduleInfoDAO dayScheduleInfoDAO;

   //수정
   private final ScheduleDBDAO scheduleDBDAO;
   
   public SearchDayScheduleInfoController(){
      this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();
	  this.scheduleDBDAO = ScheduleDBDAO.getInstance();
   }
   public SearchDayScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO, ScheduleDBDAO scheduleDBDAO){
      this.dayScheduleInfoDAO = dayScheduleInfoDAO;
	  this.scheduleDBDAO = scheduleDBDAO;
   }

   //DB쪽 검색하는 Method
   private DayScheduleInfo[] searchDayScheduleInfoToDB(String scheduleName, Date startDate, Date endDate){
      DayScheduleInfo []infoList = scheduleDBDAO.searchDayInfo(scheduleName, startDate, endDate);
	  return infoList;
   }


   //File쪽 원래 Method
   public String[][] requestSearchDayScheduleInfo(String scheduleName, Date startDate, Date endDate){
      ArrayList<DayScheduleInfo> list = dayScheduleInfoDAO.searchDayScheduleInfo(scheduleName,startDate,endDate);
      
	  DayScheduleInfo []returnList = searchDayScheduleInfoToDB(scheduleName, startDate, endDate);

	  for(int cnt=0; cnt<returnList.length; cnt++){
	      list.add(returnList[cnt]);
	  }

      int rowNum = list.size();
      String [][]searchString = new String[rowNum][5];

      for(int cnt=0; cnt<rowNum; cnt++){
         searchString[cnt][0] = list.get(cnt).getScheduleCode();
         searchString[cnt][1] = list.get(cnt).getScheduleName();
         searchString[cnt][2] = ""+(list.get(cnt).getStartDay().getYear());
         searchString[cnt][3] = ""+(list.get(cnt).getStartDay().getMonth());
         searchString[cnt][4] = ""+(list.get(cnt).getStartDay().getDate());
      }
   
      return searchString;

   }
   public String[][] requestSearchDayScheduleInfo(Date startDate, Date endDate){
      ArrayList<DayScheduleInfo> list = dayScheduleInfoDAO.searchDayScheduleInfo(startDate,endDate);
      
      int rowNum = list.size();
      String [][]searchString = new String[rowNum][2];

      for(int cnt=0; cnt<rowNum; cnt++){
         searchString[cnt][0] = list.get(cnt).getScheduleCode();
         searchString[cnt][1] = list.get(cnt).getScheduleName();
      }
   
      return searchString;

   }



}