import java.util.*;

public class AddStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	
	public AddStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
	}
	public AddStudyDocumentInfoController(StudyDocumentDAO studyDocumentDAO)
	{
		this.studyDocumentDAO=studyDocumentDAO;
	}
	public boolean addCheck(String documentCode,String documentName)
	{

		return true;
	}
	public boolean addStudyDocumentInfo(String documentCode,String documentName,Date documentDate,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		this.studyDocumentDAO.addStudyDocumentInfo(documentCode,documentName,documentDate,documentDirectory,codeSection,anNotationSection,documentForm);
		return true;
	}
}