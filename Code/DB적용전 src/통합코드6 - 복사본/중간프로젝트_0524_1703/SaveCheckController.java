public class SaveCheckController
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;

	public SaveCheckController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO=StudyDocumentDBDAO.getInstance();
	}
	public SaveCheckController(StudyDocumentDAO studyDocumentDAO)
	{
		this.studyDocumentDAO=studyDocumentDAO;
	}
	public boolean saveCheck(String documentCode,String documentDirectory)
	{
		if(this.studyDocumentDAO.saveCheck(documentCode,documentDirectory))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean saveCheckToDB(String documentCode,String documentDirectory)
	{
		if(this.studyDocumentDBDAO.selectDocumentCode(documentCode)!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}