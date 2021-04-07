import java.util.*;
import java.io.*;

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
	public boolean saveCheck(String documentCode,String documentName)
	{
		return true;
	}
	public boolean saveAsStudyDocumentInfo(String documentCode,String documentName,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		if(this.studyDocumentDAO.saveAsStudyDocumentInfo(documentCode,documentName,documentDirectory,codeSection,anNotationSection,documentForm))
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