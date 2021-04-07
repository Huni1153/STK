import java.util.*;

public class ModifyScheduleInfoController
{
	private DayScheduleInfoDAO dayScheduleInfoDAO;

	public ModifyScheduleInfoController()
	{
		this.dayScheduleInfoDAO=DayScheduleInfoDAO.getInstance();
	}
	public ModifyScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
	}
	public boolean modifyCheck(String scheduleCode,String scheduleName)
	{
		return true;
	}
	public boolean modifyScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note, Date alarm, String image)
	{
		this.dayScheduleInfoDAO.getInstance().modifyDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
		return true;
	}
}