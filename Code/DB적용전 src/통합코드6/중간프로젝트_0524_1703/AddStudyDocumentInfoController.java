import java.util.*;

public class AddStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	private String documentCode;
	private String documentDirectory;

	public AddStudyDocumentInfoController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.documentCode = "";
	}
	
	public AddStudyDocumentInfoController(String documentDirectory)
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.documentDirectory = documentDirectory;
	}
	public String addNewStudyDocumentInfo()
	{
		this.documentCode = studyDocumentDAO.addNewStudyDocumentInfo(documentDirectory);
		return documentCode;
	}
	public String addNewStudyDocumentInfo(String documentDirectory)
	{
		this.documentCode = studyDocumentDAO.addNewStudyDocumentInfo(documentDirectory);
		return documentCode;
	}
	public boolean addCheck(String documentCode,String documentName)
	{
		return true;
	}
	public boolean addStudyDocumentInfo(String documentCode,String documentName,Date documentDate,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		return true;
	}
}