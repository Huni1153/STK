//import java.util.*;

public class DataIOController
{
	//private DayScheduleInfoDAO dayScheduleInfoDAO;
	private StudyDocumentDAO studyDocumentDAO;

	public DataIOController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
	}
	
	public boolean fileLoad()
	{
		studyDocumentDAO.fileLoad();
		return true;
	}

	public boolean fileSave()
	{
		return true;
	}

	//public boolean file

}