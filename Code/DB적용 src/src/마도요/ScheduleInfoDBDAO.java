import java.sql.*;
import java.util.*;

public class ScheduleInfoDBDAO
{
   final private DBConnectionModule connModule;
   private Connection daoConn;

   public ScheduleInfoDBDAO(){
      this.connModule = DBConnectionModule.getInstance();
      this.daoConn = connModule.getConn();
   }
   public ScheduleInfoDBDAO(DBConnectionModule connModule){
      this.connModule = connModule;
      this.daoConn = this.connModule.getConn();
   }
   public DBConnectionModule getConnModule(){
      return this.connModule;
   }

   public int insert(String scheduleCode, String scheduleKindCode, String scheduleName, java.util.Date startDate, java.util.Date endDate, String place, java.util.Date alarm, String image, String note){
      int rowNum = 0;
      PreparedStatement pstmt = null;
      java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
      java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
      java.sql.Date sqlAlarm = new java.sql.Date(alarm.getTime());
      try{
         String sql = "insert into ScheduleInfo(scheduleCode, scheduleKindCode, scheduleName, startDate, endDate, place, alarm, image, note) values(?,?,?,?,?,?,?,?,?)";
         pstmt = daoConn.prepareStatement(sql);
         pstmt.setString(1,scheduleCode);
         pstmt.setString(2,scheduleKindCode);
         pstmt.setString(3,scheduleName);
         pstmt.setDate(4,sqlStartDate);
         pstmt.setDate(5,sqlEndDate);
         pstmt.setString(6,place);
         pstmt.setDate(7,sqlAlarm);
         pstmt.setString(8,image);
         pstmt.setString(9,note);

         rowNum = pstmt.executeUpdate();
      }
      catch(SQLException se){
         System.out.println(se.getMessage());
      }
      catch(Exception ex){
         System.out.println(ex.getMessage());
      }
      finally{
         try{
            if(pstmt != null) pstmt.close();
         }
         catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }
      return rowNum;
   }
   
   public int update(String scheduleCode, String scheduleKindCode, String scheduleName, java.util.Date startDate, java.util.Date endDate, String place, java.util.Date alarm, String image, String note){
      int rowNum = 0;
      PreparedStatement pstmt = null;

      java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
      java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
      java.sql.Date sqlAlarm = new java.sql.Date(alarm.getTime());
      try{
         String sql = "update ScheduleInfo set scheduleKindCode = ?, scheduleName = ?, startDate = ?, endDate = ?, place = ?, alarm = ?, image = ?, note = ? where scheduleCode = ?";
         pstmt = daoConn.prepareStatement(sql);
         
         pstmt.setString(1,scheduleKindCode);
         pstmt.setString(2,scheduleName);
         pstmt.setDate(3,sqlStartDate);
         pstmt.setDate(4,sqlEndDate);
         pstmt.setString(5,place);
         pstmt.setDate(6,sqlAlarm);
         pstmt.setString(7,image);
         pstmt.setString(8,note);
         pstmt.setString(9,scheduleCode);

         rowNum = pstmt.executeUpdate();
      }
      catch(SQLException se){
         System.out.println(se.getMessage());
      }
      catch(Exception ex){
         System.out.println(ex.getMessage());
      }
      finally{
         try{
            if(pstmt != null) pstmt.close();
         }
         catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }
      return rowNum;
   }
   public int delete(String scheduleCode){
      int rowNum = 0;
      PreparedStatement pstmt = null;
      try{
         String sql = "delete from ScheduleInfo where scheduleCode = ?";
         pstmt = daoConn.prepareStatement(sql);

         pstmt.setString(1,scheduleCode);

         rowNum = pstmt.executeUpdate();
      }
      catch(SQLException se){
         System.out.println(se.getMessage());
      }
      catch(Exception ex){
         System.out.println(ex.getMessage());
      }
      finally{
         try{
            if(pstmt != null) pstmt.close();
         }
         catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }
      return rowNum;
   }

   public DayScheduleInfo selectCode(String scheduleCode){
      DayScheduleInfo info = null;
      PreparedStatement pstmt = null;
      try{
         String sql = "select * from ScheduleInfo where scheduleCode = ?";
         pstmt = daoConn.prepareStatement(sql);

         pstmt.setString(1,scheduleCode);

         ResultSet rs = pstmt.executeQuery();
         while(rs.next()){
            String scheduleCode1 = rs.getString("scheduleCode");
            String scheduleKindCode1 = rs.getString("scheduleKindCode");
            String scheduleName1 = rs.getString("scheduleName");
            java.sql.Date startDate1 = rs.getDate("startDate");
            java.sql.Date endDate1 = rs.getDate("endDate");
            String place1 = rs.getString("place");
            java.sql.Date alarm1 = rs.getDate("alarm");
            String image1 = rs.getString("image");
            String note1 = rs.getString("note");

            info = new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, new java.util.Date(startDate1.getTime()), new java.util.Date(endDate1.getTime()), place1, note1, new java.util.Date(alarm1.getTime()), image1);

         }
      }
      catch(SQLException se){
         System.out.println(se.getMessage());
      }
      catch(Exception ex){
         System.out.println(ex.getMessage());
      }
      finally{
         try{
            if(pstmt != null) pstmt.close();
         }
         catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }
      return info;
   }

   public DayScheduleInfo[] selectName(String scheduleName){
      DayScheduleInfo []info = null;
      PreparedStatement pstmt = null;
      ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();
      try{
         String sql = "select * from ScheduleInfo where scheduleName = ?";
         pstmt = daoConn.prepareStatement(sql);

         pstmt.setString(1,scheduleName);

         ResultSet rs = pstmt.executeQuery();
         while(rs.next()){
            String scheduleCode1 = rs.getString("scheduleCode");
            String scheduleKindCode1 = rs.getString("scheduleKindCode");
            String scheduleName1 = rs.getString("scheduleName");
            java.sql.Date startDate1 = rs.getDate("startDate");
            java.sql.Date endDate1 = rs.getDate("endDate");
            String place1 = rs.getString("place");
            java.sql.Date alarm1 = rs.getDate("alarm");
            String image1 = rs.getString("image");
            String note1 = rs.getString("note");            

            list.add(new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, new java.util.Date(startDate1.getTime()), new java.util.Date(endDate1.getTime()), place1, note1, new java.util.Date(alarm1.getTime()), image1));

         }

         info = new DayScheduleInfo[list.size()];
         for(int cnt=0; cnt<list.size(); cnt++){
            info[cnt] = list.get(cnt);
         }
      }
      catch(SQLException se){
         System.out.println(se.getMessage());
      }
      catch(Exception ex){
         System.out.println(ex.getMessage());
      }
      finally{
         try{
            if(pstmt != null) pstmt.close();
         }
         catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }
      return info;
   }
   public DayScheduleInfo[] selectName(String scheduleName, java.util.Date startDate, java.util.Date endDate){
      DayScheduleInfo []info = null;
      PreparedStatement pstmt = null;
      ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();

      java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
      java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());


      try{
         String sql = "select * from ScheduleInfo where scheduleName = ? AND startDate <= ? AND endDate >= ?";
         pstmt = daoConn.prepareStatement(sql);
         
         pstmt.setString(1,scheduleName);
         pstmt.setDate(2,sqlStartDate);
         pstmt.setDate(3,sqlEndDate);

         ResultSet rs = pstmt.executeQuery();
         while(rs.next()){
            String scheduleCode1 = rs.getString("scheduleCode");
            String scheduleKindCode1 = rs.getString("scheduleKindCode");
            String scheduleName1 = rs.getString("scheduleName");
            java.sql.Date startDate1 = rs.getDate("startDate");
            java.sql.Date endDate1 = rs.getDate("endDate");
            String place1 = rs.getString("place");
            java.sql.Date alarm1 = rs.getDate("alarm");
            String image1 = rs.getString("image");
            String note1 = rs.getString("note");            

            list.add(new DayScheduleInfo(scheduleCode1, scheduleKindCode1, scheduleName1, new java.util.Date(startDate1.getTime()), new java.util.Date(endDate1.getTime()), place1, note1, new java.util.Date(alarm1.getTime()), image1));
            
         }
         info = new DayScheduleInfo[list.size()];
         for(int cnt=0; cnt<list.size(); cnt++){
            info[cnt] = list.get(cnt);
         }
      }
      catch(SQLException se){
         System.out.println(se.getMessage());
      }
      catch(Exception ex){
         System.out.println(ex.getMessage());
      }
      finally{
         try{
            if(pstmt != null) pstmt.close();
         }
         catch(SQLException se){
            System.out.println(se.getMessage());
         }
      }
      return info;
      
   }

} 