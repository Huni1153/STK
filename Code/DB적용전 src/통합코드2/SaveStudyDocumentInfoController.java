import java.util.*;
import java.io.*;

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
	public boolean saveCheck(String documentCode,String documentName)
	{
		return true;
	}
	public boolean saveStudyDocumentInfo(String documentCode,String documentName,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		if(this.studyDocumentDAO.saveStudyDocumentInfo(documentCode,documentName,documentDirectory,codeSection,anNotationSection,documentForm))
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
			System.out.println("���Ϸ� ��� ����!");
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