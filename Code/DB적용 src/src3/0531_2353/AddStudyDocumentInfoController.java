import java.util.*;

public class AddStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;
	private String documentCode;
	private String documentDirectory;

	public AddStudyDocumentInfoController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO = StudyDocumentDBDAO.getInstance();
		this.documentCode = "";
	}
	
	public AddStudyDocumentInfoController(String documentDirectory)
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO = StudyDocumentDBDAO.getInstance();
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
	///0531_1447 ´ë¼·½´Á´
		//this.addStudyDocumentInfoToDB(documentCode, "»õ ¹®¼­", new Date(), documentDirectory, new StringBuilder(""), new StringBuilder(""));
	///0531_1447 ´ë¼·½´Á´
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

///0531_1427 ´ë¼·½´Á´
	public String addStudyDocumentInfoToDB(String documentCode, String documentName, Date documentDate, String documentDirectory, StringBuilder codeSection, StringBuilder noteSection)
	{
		studyDocumentDBDAO.insertDocumentInfo(documentCode, documentDirectory, codeSection, noteSection);
		return documentCode;
	}
	public String addStudyDocumentInfoToDB()
	{
		//this.documentCode = studyDocumentDBDAO.insertDocumentInfo(documentCode, );
		return "";
	}
	
}