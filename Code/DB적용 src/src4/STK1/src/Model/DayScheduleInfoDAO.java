package Model;
import java.util.*;
import javax.swing.*;
import java.io.*;
public class DayScheduleInfoDAO implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2481400956139384358L;
	private final LinkedList<DayScheduleInfo> dayScheduleInfoDAO;
	private static DayScheduleInfoDAO obj = new DayScheduleInfoDAO();

	public static DayScheduleInfoDAO getInstance(){
		return obj;
	}
	private DayScheduleInfoDAO(){
		this.dayScheduleInfoDAO = new LinkedList<DayScheduleInfo>();
	}
	/*
	public DayScheduleInfoList()
	{
		this.dayScheduleInfoList=new LinkedList<DayScheduleInfo>();
	}
	public DayScheduleInfoList(DayScheduleInfo dayScheduleInfo)
	{
		this.dayScheduleInfoList=new LinkedList<DayScheduleInfo>();
		this.dayScheduleInfoList.add(dayScheduleInfo);
	}
	*/
	/*
	public void setDayScheduleInfoDAO(LinkedList<DayScheduleInfo> dayScheduleInfoDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
	}
	*/
	public LinkedList<DayScheduleInfo> getDayScheduleInfoDAO()
	{
		return this.dayScheduleInfoDAO;
	}

	public boolean addDayScheduleInfo(String scheduleCode,ScheduleKind scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		this.dayScheduleInfoDAO.add(new DayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image));
		return true;
	}
	public boolean addDayScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		this.dayScheduleInfoDAO.add(new DayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image));
		return true;
	}
	public boolean addDayScheduleInfo(DayScheduleInfo dayScheduleInfo)
	{
		this.dayScheduleInfoDAO.add(dayScheduleInfo);
		return true;
	}
	public boolean addDayScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		this.dayScheduleInfoDAO.add(new DayScheduleInfo(scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image));
		return true;
	}


   //�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѽ��� ���ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�//
   public boolean modifyDayScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
   {
      int index = findIndex(scheduleCode);
      dayScheduleInfoDAO.get(index).modifyScheduleInfo(scheduleKind, scheduleName, startDay, endDay, place, note, alarm, image);
      return true;   
   }
	/*public boolean modifyDayScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
	{
		int index = findIndex(scheduleCode);
		dayScheduleInfoDAO.get(index).modifyScheduleInfo(scheduleKind, scheduleName, startDay, endDay, place, note, alarm, image);
		return true;	
	}*/
	/*
	public boolean modifyDayScheduleInfo(DayScheduleInfo dayScheduleInfo)
	{
		int index = findIndex(dayScheduleInfo.getScheduleCode());
		
	}
	*/
	public Iterator<DayScheduleInfo> provideAllInfo(){
		ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();
		for(int cnt=0; cnt<dayScheduleInfoDAO.size(); cnt++){
			list.add(dayScheduleInfoDAO.get(cnt));
		}
		return list.iterator();
	}
public ArrayList<DayScheduleInfo> searchDayScheduleInfo(Date startDay, Date endDay){
      ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();

      int index=0;

      while(true){
         if(dayScheduleInfoDAO.get(index).getStartDay().getDate() >= startDay.getDate() && dayScheduleInfoDAO.get(index).getStartDay().getDate() <= endDay.getDate()){
            list.add(dayScheduleInfoDAO.get(index));
         }
         index++;

         if(index >= dayScheduleInfoDAO.size())
            break;
      }

      return list;
      
   }
   public ArrayList<DayScheduleInfo> searchDayScheduleInfo(String scheduleName, Date startDay, Date endDay){
      ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();

      int index=0;

      while(true){
         if(dayScheduleInfoDAO.get(index).getStartDay().getDate() >= startDay.getDate() && dayScheduleInfoDAO.get(index).getStartDay().getDate() <= endDay.getDate()){
            if(dayScheduleInfoDAO.get(index).getScheduleName().equals(scheduleName))
               list.add(dayScheduleInfoDAO.get(index));
         }
         index++;

         if(index >= dayScheduleInfoDAO.size())
            break;
      }

      return list;
      
   }
	// �Ʒ� 2�� �����ϱ�
	public DayScheduleInfo searchDayScheduleInfo(String scheduleCode)
	{
		Iterator iterator=this.dayScheduleInfoDAO.iterator();
		DayScheduleInfo obj=null;
		while(iterator.hasNext())
		{
			obj=(DayScheduleInfo)iterator.next();
			if(obj.getScheduleCode().equals(scheduleCode))
			{
				return obj;
			}
		}
		return obj;
	}
	public DayScheduleInfo searchDayScheduleInfo(DayScheduleInfo dayScheduleInfo)
	{
		Iterator iterator=this.dayScheduleInfoDAO.iterator();
		DayScheduleInfo obj=null;
		while(iterator.hasNext())
		{
			obj=(DayScheduleInfo)iterator.next();
			if(obj.getScheduleCode().equals(dayScheduleInfo.getScheduleCode()))
			{
				return obj;
			}
		}
		return obj;
	}
	public boolean deleteDayScheduleInfo(String scheduleCode){
      int index = findIndex(scheduleCode);
      if(index == -1) return false;
      dayScheduleInfoDAO.remove(index);
      return true;
   }
	public boolean deleteDayScheduleInfo(int index){
		dayScheduleInfoDAO.remove(index);
		return true;
	}
	public boolean deleteDayScheduleInfo(DayScheduleInfo dayScheduleInfo)
	{
		this.dayScheduleInfoDAO.remove(dayScheduleInfo);
		return true;
	}

	public int findIndex(String scheduleCode){
		for(int cnt=0; cnt<dayScheduleInfoDAO.size(); cnt++){
			if(dayScheduleInfoDAO.get(cnt).getScheduleCode().equals(scheduleCode))
				return cnt;
		}
		return -1;
	}
	public void setLatestCodeNum(){
		//System.out.println("Here"+dayScheduleInfoDAO.size());
		dayScheduleInfoDAO.get(dayScheduleInfoDAO.size()-1).setLatestCodeNum();

		//System.out.println(dayScheduleInfoDAO.get(dayScheduleInfoDAO.size()-1));
	}
	public int collectionSize(){
		return dayScheduleInfoDAO.size();
	}
	public int typeElementsMemberCnt(){
		return new DayScheduleInfo().memberCnt();
	}

	public boolean fileLoad(){
		return dayScheduleInfoFileLoad("DayScheduleList.txt");
	}
	private boolean dayScheduleInfoFileLoad(String fileName){
		if(fileName == null) return false;
		
		ObjectInputStream in = null;

		try{
			in = new ObjectInputStream(new FileInputStream(fileName));
			while(true){
				DayScheduleInfo obj = (DayScheduleInfo)in.readObject();
				dayScheduleInfoDAO.add(obj);
			//	System.out.println(dayScheduleInfoDAO.size());
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println("������ ã�� �� �����ϴ�");
		}
		catch(EOFException eofe){
			System.out.println("������ ��� �о����ϴ�");
		}
		catch(IOException ioe){
			System.out.println("������ ���� �� �����ϴ�");
		}
		catch(ClassNotFoundException cnfe){
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�");
		}
		finally{
			try{ in.close(); }
			catch(Exception e){}
		}
		//System.out.println("Here222"+dayScheduleInfoDAO.size());
		//setLatestCodeNum();
		return true;
	}
	public boolean fileSave(){
		return dayScheduleInfoFileSave("DayScheduleList.txt");
	}
	private boolean dayScheduleInfoFileSave(String fileName){
		if(fileName == null) return false;
		ObjectOutputStream out = null;

		try{
			out = new ObjectOutputStream(new FileOutputStream(fileName));
			for(int cnt=0; cnt<dayScheduleInfoDAO.size(); cnt++){
				out.writeObject(dayScheduleInfoDAO.get(cnt));
			}
		}
		catch(IOException ioe){
			System.out.println("123");
			ioe.printStackTrace();
			System.out.println("���Ϸ� ����� �� �����ϴ�");
			
		}
		finally{
			try{ out.close(); }
			catch(Exception e){}
		}
		return true;
	}
}