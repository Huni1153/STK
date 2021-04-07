import java.util.*;
import java.text.*;
public class ScheduleDAO
{
   private LinkedList<DayScheduleInfo> scheduleDAO;
   private ScheduleInfoDAO scheduleInfoDAO;

   private int intCode;

   public ScheduleDAO(){
      this.scheduleDAO = new LinkedList<DayScheduleInfo>();
      this.scheduleInfoDAO = new ScheduleInfoDAO();
      getCodeString();
   }
   
   public ScheduleDAO(LinkedList<DayScheduleInfo> scheduleDAO, ScheduleInfoDAO scheduleInfoDAO){
      this.scheduleDAO = scheduleDAO;
      this.scheduleInfoDAO = scheduleInfoDAO;
      getCodeString();
   }
   public void setScheduleDAO(LinkedList<DayScheduleInfo> scheduleDAO){
      this.scheduleDAO = scheduleDAO;
   }
   public void setScheduleInfoDAO(ScheduleInfoDAO scheduleInfoDAO){
      this.scheduleInfoDAO = scheduleInfoDAO;
   }
   public LinkedList<DayScheduleInfo> getScheduleDAO(){
      return this.scheduleDAO;
   }
   public ScheduleInfoDAO getScheduleInfoDAO(){
      return this.scheduleInfoDAO;
   }
   public int insertDayScheduleInfo(String scheduleKindCode, String scheduleName, Date startDate, Date endDate, String place, Date alarm, String image, String note){
      String code = makeCode();
      System.out.println("code");
      System.out.println(code);


      scheduleDAO.add(new DayScheduleInfo(code, scheduleKindCode, scheduleName, startDate, endDate, place, note, alarm, image));
      if(scheduleDAO.size() == 10){
         saveSchedule();
         deleteSchedule();
      }


   return 0;
   }
   public int deleteDayScheduleInfo(String scheduleCode){
      for(int cnt=0; cnt<scheduleDAO.size(); cnt++){
         if(scheduleDAO.get(cnt).getScheduleCode().equals(scheduleCode)){
            scheduleDAO.remove(cnt);

            return 2;
         }
      }
      return scheduleInfoDAO.delete(scheduleCode);
   }
   public int updateDayScheduleInfo(String scheduleCode, String scheduleKindCode, String scheduleName, Date startDate, Date endDate, String place, Date alarm, String image, String note){
      for(int cnt=0; cnt<scheduleDAO.size(); cnt++){
         if(scheduleDAO.get(cnt).getScheduleCode().equals(scheduleCode)){
            scheduleDAO.get(cnt).modifyScheduleInfo(scheduleKindCode, scheduleName, startDate, endDate, place, note, alarm, image);
            return 2;
         }
      }

      return scheduleInfoDAO.update(scheduleCode, scheduleKindCode, scheduleName, startDate, endDate, place, alarm, image, note);

   }
   public Iterator<DayScheduleInfo> requestProvideAll(){
      return null;
   }
   public Iterator<DayScheduleInfo> searchDayInfo(Date startDate, Date endDate){
      return null;
   }
   public Iterator<DayScheduleInfo> searchDay(Date startDate, Date endDate){
      return null;
   }
   



   public int deleteSchedule(){
      for(int cnt=scheduleDAO.size()-1; cnt>=0; cnt--){
         scheduleDAO.remove(cnt);
      }
      return 1;
   }

   public int saveSchedule(){
      for(int cnt=0; cnt<scheduleDAO.size(); cnt++){
         DayScheduleInfo info = scheduleDAO.get(cnt);
         Integer integ = new Integer(info.getScheduleKind().getKind());

         scheduleInfoDAO.insert(info.getScheduleCode(), integ.toString(), info.getScheduleName(), info.getStartDay(), info.getEndDay(), info.getPlace(), info.getAlarm(), info.getImage(), info.getNote());
      }
      return 1;
   }

   public String makeCode(){
      Date d = new Date();
      StringTokenizer st = new StringTokenizer(new SimpleDateFormat().format(d),". ");

      String year = st.nextToken();
      String month = st.nextToken();
      String day = st.nextToken();

      System.out.println(year + month + day);
      intCode++;
      Integer code = new Integer(intCode);

      return year + month + day + code.toString();

   }

   public void getCodeString(){
      this.intCode = Integer.parseInt(scheduleInfoDAO.latestCodeNum());
      System.out.println("Here");
      System.out.println(this.intCode);
   }

   public static void main(String []args){
      new ScheduleDAO();
      /*
      String code = "155192001";
      char []chCode = code.toCharArray();

      String codeString = String.valueOf(chCode, chCode.length-4, 4);
      System.out.println(codeString);
      */
   }
}