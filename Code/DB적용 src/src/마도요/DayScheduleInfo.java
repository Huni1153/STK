import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class DayScheduleInfo implements Serializable
{
   private String scheduleCode;
   private ScheduleKind scheduleKind;
   private String scheduleName;
   private Date startDay;
   private Date endDay;
   private String place;
   private String note;
   private Date alarm;
   private String image;

   private static int codeNum;
   static{
      codeNum = 2000;
   }
   
   public static void setCodeNum(int num){
      codeNum = num;
   }
   public static int getCodeNum(){
      return codeNum;
   }
   public void setLatestCodeNum(){
      String str = scheduleCode.substring(scheduleCode.length()-4,scheduleCode.length());
      //System.out.println("가나다라  "+ scheduleCode);
      //System.out.println(scheduleCode.length()-1);
      int num = Integer.parseInt(str);
      codeNum = num;
         
   }
   public DayScheduleInfo()
   {
      /*
      this.scheduleCode = "없음"
      this.scheduleKind = ""
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.place = place;
      this.note = note;
      this.alarm = alarm;
      this.image = image;
      */
   }
   
   public DayScheduleInfo(String scehduleCode,ScheduleKind scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
   {
      this.scheduleCode = scheduleCode;
      this.scheduleKind = scheduleKind;
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.place = place;
      this.note = note;
      this.alarm = alarm;
      this.image = image;
   }
   public DayScheduleInfo(ScheduleKind scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
   {
      this.scheduleCode = makeCode();
      this.scheduleKind = scheduleKind;
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.place = place;
      this.note = note;
      this.alarm = alarm;
      this.image = image;
   }
   public DayScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
   {
      //System.out.println()
      System.out.println("Constructor");
      this.scheduleCode = scheduleCode;

      System.out.println(this.scheduleCode);

      this.scheduleKind = new ScheduleKind(Integer.parseInt(scheduleKind));
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.place = place;
      this.note = note;
      this.alarm = alarm;
      this.image = image;

   }
   public DayScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
   {
      this.scheduleCode = makeCode();
      this.scheduleKind = new ScheduleKind(scheduleKind);
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.place = place;
      this.note = note;
      this.alarm = alarm;
      this.image = image;

   }
   /*   
   public DayScheduleInfo(String scehduleCode,ScheduleKind scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
   {
      this.scheduleCode = scheduleCode;
      this.scheduleKind = scheduleKind;
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.place = place;
      this.note = note;
      this.alarm = alarm;
      this.image = image;
   }
   */
   public void setScehduleCode(String scheduleCode)
   {
      this.scheduleCode=scheduleCode;
   }
   public void setScheduleKind(ScheduleKind scheduleKind)
   {
      this.scheduleKind=scheduleKind;
   }
   public void setScheduleName(String scheduleName)
   {
      this.scheduleName=scheduleName;
   }
   public void setStartDay(Date startDay)
   {
      this.startDay=startDay;
   }
   public void setEndDay(Date endDay)
   {
      this.endDay=endDay;
   }
   public void setPlace(String place)
   {
      this.place=place;
   }
   public void setNote(String note)
   {
      this.note=note;
   }
   public void setAlarm(Date alram)
   {
      this.alarm=alarm;
   }
   public void setImage(String image)
   {
      this.image=image;
   }
   public String getScheduleCode()
   {
      return this.scheduleCode;
   }
   public ScheduleKind getScheduleKind()
   {
      return this.scheduleKind;
   }
   public String getScheduleName()
   {
      return this.scheduleName;
   }
   public Date getStartDay()
   {
      return this.startDay;
   }
   public Date getEndDay()
   {
      return this.endDay;
   }
   public String getPlace()
   {
      return this.place;
   }
   public String getNote()
   {
      return note;
   }
   public Date getAlarm()
   {
      return this.alarm;
   }
   public String getImage()
   {
      return this.image;
   }
   public String toString()
   {
      return "스케쥴 코드 : "+this.scheduleCode+"\n스케줄 종류 : "+this.scheduleKind.getKindName()+"\n스케쥴 이름 : "+this.scheduleName+"\n시작 일 : "+this.startDay.toString()+"\n종료 일 : "+this.endDay.toString()+"\n장소 : "+this.place+"\n노트 : "+this.note+"\n알람 : "+this.alarm.toString()+"\n이미지 : "+this.image;
   }

   public String makeCode(){
      Date d = new Date();
      StringTokenizer st = new StringTokenizer(new SimpleDateFormat().format(d),". ");

      String year = st.nextToken();
      String month = st.nextToken();
      String day = st.nextToken();

      System.out.println(year + month + day);
      codeNum++;
      Integer code = new Integer(codeNum);

      return year + month + day + code.toString();

   }
   public String provideScheduleKind(){
      return scheduleKind.getKindName();
   }
    public boolean modifyScheduleName(String name){
      if(name == null)
         return false;
      this.scheduleName = name;
      return true;
   }
   public boolean modifyScheduleKind(String kind){
      if(kind == null)
         return false;
      this.scheduleKind = new ScheduleKind(kind);
      return true;
   }
   public boolean modifyScheduleStartDay(Date date){
      if(date == null)
         return false;
      this.startDay = date;
      return true;
   }
   public boolean modifyScheduleEndDay(Date date){
      if(date == null)
         return false;
      this.endDay = date;
      return true;
   }
   public boolean modifyPlace(String place){
      if(place == null)
         return false;
      this.place = place;
      return true;
   }
   public boolean modifyNote(String note){
      if(note == null)
         return false;
      this.note = note;
      return true;
   }
   public boolean modifyAlarm(Date date){
      if(date == null)
         return false;
      this.alarm = date;
      return true;
   }
   public boolean modifyImage(String img){
      if(img == null)
         return false;
      this.image = img;
      return true;
   }
   public boolean checkScheduleName(String scheduleName){
      return this.scheduleName.equals(scheduleName);
   }
   public boolean modifyScheduleInfo(String scheduleKind, String scheduleName, Date startDay, Date endDay, String place, String note, Date alarm, String image){
      if(scheduleKind == null || scheduleName == null || startDay == null || endDay == null || place == null || note == null || alarm == null || image == null){
         return false;
      }
      this.scheduleKind = new ScheduleKind(scheduleKind);
      this.scheduleName = scheduleName;
      this.startDay = startDay;
      this.endDay = endDay;
      this.note = note;
      this.place = place;
      this.alarm = alarm;
      this.image = image;

      return true;
   }

   public boolean checkEssentialInfo(String scheduleName, String startDay, String endDay){
      if(scheduleName == null || startDay == null || endDay == null)
         return false;
      return true;
   }
   public int memberCnt(){
      return 8;
   }

   //////////////////////////////////////////////////이미지 테스트
   /*
   public void out()
   {   
      this.image=new ImageIcon("images/tNew.png");
      this.setImage(image);

      ObjectOutputStream out=null;
      try
      {
         out=new ObjectOutputStream(new FileOutputStream("info.txt"));
         out.writeObject(this);
      }
      catch (IOException ioe)
      {
         System.out.println(ioe.getMessage()+"  안됨");
      }
      finally
      {
         try
         {
            out.close();
         }
         catch (Exception e)
         {
         }
      }
   }
   public void in()
   {
      ObjectInputStream in=null;
      try
      {
         in=new ObjectInputStream(new FileInputStream("info.txt"));
         DayScheduleInfo obj=(DayScheduleInfo)in.readObject();
      }
      catch (FileNotFoundException fnfe)
      {
         System.out.println("파일이 존재하지 않습니다.");
      }
      catch (EOFException eofe)
      {
         System.out.println("끝");
      }
      catch(IOException ioe)
      {
         System.out.println(ioe.getMessage()+"  안됨");
      }
      catch(ClassNotFoundException cnfe)
      {
         System.out.println("해당 클래스가 존재하지 않습니다.");
      }
      finally
      {
         try
         {
            in.close();
         }
         catch (Exception e)
         {
         }
      }
   }
   static class TestUI extends JFrame
   {
      private JPanel pane;
      private JButton tNew;

      public TestUI(ImageIcon image)
      {
         this.pane=new JPanel();
         this.tNew=new JButton(image);
      }
      public void set()
      {
         this.setPreferredSize(new Dimension(150,150));
         this.setLocation(800,400);
         this.pane.add(tNew);
         this.add(pane);
         this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         this.pack();
         this.setVisible(true);
      }
   }
   */
   public static void main(String[] args) 
   {

      DayScheduleInfo obj = new DayScheduleInfo();
      //obj.makeCode();
      System.out.println(obj.makeCode());
      System.out.println(obj.makeCode());
      System.out.println(obj.makeCode());

   }
}