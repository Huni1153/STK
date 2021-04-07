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
	public boolean deleteStudyInfo(String documentCode)
	{
		this.studyDocumentDAO.deleteStudyDocumentInfo(documentCode);
		return true;
	}
}