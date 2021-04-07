package Model;
public class ScheduleDataIOController
{
	private final DayScheduleInfoDAO dayScheduleInfoDAO;

	public ScheduleDataIOController(){
		this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();
	}
	public ScheduleDataIOController(DayScheduleInfoDAO dayScheduleInfoDAO){
		this.dayScheduleInfoDAO = dayScheduleInfoDAO;
	}
	public boolean requestScheduleFileLoad(){
		boolean check = dayScheduleInfoDAO.fileLoad();
		dayScheduleInfoDAO.setLatestCodeNum();
		return check;
		
	}
	public boolean requestScheduleFileSave(){
		return dayScheduleInfoDAO.fileSave();
	}
}