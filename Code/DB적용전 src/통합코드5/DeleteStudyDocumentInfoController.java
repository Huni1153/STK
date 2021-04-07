public class DeleteStudyDocumentInfoController 
{
	private StudyDocumentDAO studyDocumentDAO;

	public DeleteStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
	}
	public DeleteStudyDocumentInfoController(StudyDocumentDAO studyDocumentDAO)
	{
		this.studyDocumentDAO=studyDocumentDAO;
	}
	public boolean deleteCheck(String documentCode,String documentDirectory)
	{
		if(this.studyDocumentDAO.deleteCheck(documentCode,documentDirectory))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean deleteNewStudyDocumentInfo(String documentCode,String documentDirectory)
	{
		if(this.studyDocumentDAO.deleteStudyDocumentInfo(documentCode,documentDirectory))
		{
			return true;
		}
		return false;
	}
	public boolean deleteStudyDocumentInfo(String documentCode,String documentDirectory)
	{
		if(this.studyDocumentDAO.deleteStudyDocumentInfo(documentCode,documentDirectory))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//public boolean deleteStudyDocumentInfo
}
