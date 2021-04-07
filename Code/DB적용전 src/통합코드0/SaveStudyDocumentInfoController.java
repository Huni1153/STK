import java.util.*;

public class SaveStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;

	public SaveStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
	}
	public SaveStudyDocumentInfoController(StudyDocumentDAO studyDocumentDAO)
	{
		this.studyDocumentDAO=studyDocumentDAO;
	}
	public Object[][] roadStudyDocumentInfo(String documentDirectory)
	{
		Object[][] obj=null;
		return obj;
	}
	public boolean SaveCheck(String documentCode,String documentName)
	{
		return true;
	}
	public boolean SaveStudyDocumentInfo(String documentCode,String documentName,Date documentDate,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		this.studyDocumentDAO.modifyStudyDocumentInfo(documentCode,documentName,documentDate,documentDirectory,codeSection,anNotationSection,documentForm);
		return true;
	}
}