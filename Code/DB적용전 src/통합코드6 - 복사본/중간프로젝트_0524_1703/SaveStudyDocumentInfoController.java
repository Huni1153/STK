import java.util.*;
import java.io.*;

public class SaveStudyDocumentInfoController
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
		this.studyDocumentDBDAO=StudyDocumentDBDAO.getInstance();
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
	public boolean saveStudyDocumentInfo(String documentCode,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection)
	{
		int year,month,day,hour,min;

		Calendar obj=new GregorianCalendar();
		year=obj.get(Calendar.YEAR);
		month=1+obj.get(Calendar.MONTH);
		day=obj.get(Calendar.DATE);
		hour=obj.get(Calendar.HOUR);
		min=obj.get(Calendar.MINUTE);

		if(this.studyDocumentDAO.saveStudyDocumentInfo(documentCode,documentDirectory,codeSection,anNotationSection))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean saveStudyDocumentInfoToDB(String documentCode,String documentDirectory,StringBuilder codeSection,StringBuilder noteSection)
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