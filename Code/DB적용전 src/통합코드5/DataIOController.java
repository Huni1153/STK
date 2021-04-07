//import java.util.*;

public class DataIOController
{
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
//////////////////////////////////
	public boolean fileSave()
	{
		//studyDocumentDAO.directoryFileSave();
		studyDocumentDAO.fileSave();
		return true;
	}
	/*
	public boolean studyDocumentFileSave()
	{
		studyDocumentDAO.fileSave();
		return true;
	}*/

}