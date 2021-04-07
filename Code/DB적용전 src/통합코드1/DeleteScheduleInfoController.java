public class DeleteScheduleInfoController
{
	private DayScheduleInfoDAO dayScheduleInfoDAO;

	public DeleteScheduleInfoController()
	{
		this.dayScheduleInfoDAO=DayScheduleInfoDAO.getInstance();
	}
	public DeleteScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
	}
	public boolean delteStudyInfo(String scheduleCode)
	{
		this.dayScheduleInfoDAO.deleteDayScheduleInfo(scheduleCode);
		return true;
	}

}