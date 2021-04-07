import java.util.*;
import javax.swing.*;

public class DayScheduleInfoList
{
	LinkedList<DayScheduleInfo> dayScheduleInfoList;

	public DayScheduleInfoList()
	{
		this.dayScheduleInfoList=new LinkedList<DayScheduleInfo>();
	}
	public DayScheduleInfoList(DayScheduleInfo dayScheduleInfo)
	{
		this.dayScheduleInfoList=new LinkedList<DayScheduleInfo>();
		this.dayScheduleInfoList.add(dayScheduleInfo);
	}
	public void setDayScheduleInfoList(LinkedList<DayScheduleInfo> dayScheduleInfoList)
	{
		this.dayScheduleInfoList=dayScheduleInfoList;
	}
	public LinkedList<DayScheduleInfo> getDayScheduleInfoList()
	{
		return this.dayScheduleInfoList;
	}
	public boolean addDayScheduleInfoList(String scheduleCode,ScheduleKind scheduleKind,String scheduleName,String startDay,String endDay,String place,String note,String alarm,ImageIcon image)
	{
		DayScheduleInfo obj=new DayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
		this.dayScheduleInfoList.add(obj);
		return true;
	}
	public boolean addDayScheduleInfoList(DayScheduleInfo dayScheduleInfo)
	{
		this.dayScheduleInfoList.add(dayScheduleInfo);
		return true;
	}
	public boolean modifyDayScheduleInfoList(String scheduleCode,ScheduleKind scheduleKind,String scheduleName,String startDay,String endDay,String place,String note,String alarm,ImageIcon image)
	{
		Iterator iterator=this.dayScheduleInfoList.iterator();
		DayScheduleInfo obj=null;
		while(iterator.hasNext())
		{
			obj=(DayScheduleInfo)iterator.next();
			if(obj.getScheduleCode().equals(scheduleCode))
			{
				obj.setScheduleKind(scheduleKind);
				obj.setScheduleName(scheduleName);
				obj.setStartDay(startDay);
				obj.setEndDay(endDay);
				obj.setPlace(place);
				obj.setNote(note);
				obj.setAlarm(alarm);
				obj.setImage(image);
				return true;
			}
		}
		return false;
	}
	public  boolean modifyDayScheduleInfoList(DayScheduleInfo dayScheduleInfo)
	{
		int i=0;
		Iterator iterator=this.dayScheduleInfoList.iterator();
		DayScheduleInfo obj=null;
		while(iterator.hasNext())
		{
			obj=(DayScheduleInfo)iterator.next();
			if(obj.getScheduleCode().equals(dayScheduleInfo.getScheduleCode()))
			{
				this.dayScheduleInfoList.set(i,dayScheduleInfo);
			}
			i++;
		}
		return true;
	}
	public DayScheduleInfo searchDayScheduleInfo(String scheduleCode)
	{
		Iterator iterator=this.dayScheduleInfoList.iterator();
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
		Iterator iterator=this.dayScheduleInfoList.iterator();
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
	public boolean deleteDayScheduleInfo(String target)
	{
		return true;
	}
	public boolean deleteDayScheduleInfo(int i)
	{
		this.dayScheduleInfoList.remove(i);
		return true;
	}
	public boolean deleteDayScheduleInfo(DayScheduleInfo dayScheduleInfo)
	{
		this.dayScheduleInfoList.remove(dayScheduleInfo);
		return true;
	}
}