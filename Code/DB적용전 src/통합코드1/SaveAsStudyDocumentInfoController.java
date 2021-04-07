import java.util.*;

public class SaveAsStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;

	public SaveAsStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
	}
	public SaveAsStudyDocumentInfoController(StudyDocumentDAO studyDocumentDAO)
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
	public boolean SaveStudyDocumentInfo(String documentCode,String documentName,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		if(this.studyDocumentDAO.modifyStudyDocumentInfo(documentCode,documentName,documentDirectory,codeSection,anNotationSection,documentForm))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}