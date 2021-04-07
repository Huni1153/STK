public class DisplayScheduleInfoController
{
	private DayScheduleInfoDAO dayScheduleInfoDAO;

	public DisplayScheduleInfoController()
	{
	}
	public DisplayScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
	}
	public String[][] requestProvideMonthInfo()
	{
		String[][] obj=null;
		return obj;
	}
}