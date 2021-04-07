import java.util.*;

public class AddStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	private String documentCode;

	public AddStudyDocumentInfoController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.documentCode = "";
	}
	
	public AddStudyDocumentInfoController(String documentDirectory)
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.documentCode = "";
	}
	/*
	public AddStudyDocumentInfoController(StudyDocumentDAO studyDocumentDAO)
	{
		this.studyDocumentDAO=studyDocumentDAO;
	}*/
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
		//this.studyDocumentDAO.getInstanceMethod().addStudyDocumentInfo(documentCode,documentName,documentDate,documentDirectory,codeSection,anNotationSection,documentForm);
		return true;
	}
}