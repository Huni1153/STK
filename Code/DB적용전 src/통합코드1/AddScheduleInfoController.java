import java.util.*;

public class AddScheduleInfoController
{
	private DayScheduleInfoDAO dayScheduleInfoDAO;

	public AddScheduleInfoController()
	{
		this.dayScheduleInfoDAO=DayScheduleInfoDAO.getInstance();
	}
	public AddScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
	}
	public boolean addCheck(String scheduleCode,String scheduleName)
	{

		return true;
	}
	public boolean addScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		this.dayScheduleInfoDAO.addDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
		return true;
	}
}
