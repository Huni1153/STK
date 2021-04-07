import java.util.*;
import java.io.*;

public class SaveStudyDocumentInfoController	// 0531 세훈추가
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;

	public SaveStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO=StudyDocumentDBDAO.getInstance();
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
	public boolean saveStudyDocumentInfo(String documentCode,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection)
	{
		if(this.studyDocumentDAO.saveStudyDocumentInfo(documentCode,documentDirectory,codeSection,anNotationSection))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean saveStudyDocumentInfoToDB(String documentCode,String documentDirectory,StringBuilder codeSection,StringBuilder noteSection) // 0531 세훈추가
	{
		if(this.studyDocumentDBDAO.updateDocumentInfo(documentCode,documentDirectory,codeSection,noteSection))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean createJava(String documentName,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		String obj=""+anNotationSection;
		StringTokenizer str=new StringTokenizer(obj);
		PrintWriter writer=null;
		try
		{
			writer=new PrintWriter("Codes/"+documentName+documentForm);
			writer.print(codeSection);
			writer.print(anNotationSection);
			return true;
		}
		catch (IOException ioe)
		{
			System.out.println("파일로 출력 실패!");
			ioe.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (Exception e)
			{
			}
		}
	}
}