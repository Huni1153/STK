public class DeleteStudyDocumentInfoController 
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;//0531 �ڼ��� �߰�

	public DeleteStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO=StudyDocumentDBDAO.getInstance();
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
   public boolean deleteStudyDocumentInfoToDB(String documentCode) //0531 �ڼ��� �߰�
   {
		if(this.studyDocumentDBDAO.deleteStudyDocumentInfo(documentCode))
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