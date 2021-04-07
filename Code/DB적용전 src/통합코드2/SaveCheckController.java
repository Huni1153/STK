public class SaveCheckController
{
	private StudyDocumentDAO studyDocumentDAO;

	public SaveCheckController()
	{
		this.studyDocumentDAO.getInstanceMethod();
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
}