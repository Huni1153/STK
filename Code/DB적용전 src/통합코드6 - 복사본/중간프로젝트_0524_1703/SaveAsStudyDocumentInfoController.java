import java.util.*;
import java.io.*;

public class SaveAsStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;

	public SaveAsStudyDocumentInfoController()
	{
		this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO=StudyDocumentDBDAO.getInstance();
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
	public boolean saveAsStudyDocumentInfoToDB(String documentCode,String documentName,String documentDirectory,StringBuilder codeSection,StringBuilder noteSection,String documentForm)
	{
		if(this.studyDocumentDBDAO.insertAsDocumentInfo(documentCode,documentName,documentDirectory,codeSection,noteSection,documentForm))
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
			System.out.println("---------------");
			System.out.println(codeSection);
			writer.print(codeSection);
			System.out.println("---------------");
			writer.print(anNotationSection);
			System.out.println(anNotationSection);
			System.out.println("---------------");
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

/*
		String code = ""+codeSection;
		String annotation = ""+anNotationSection;

		ArrayList<String> codeList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(code,"\n");
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			codeList.add(s);
		}

		ArrayList<String> annotationList = new ArrayList<String>();
		st = new StringTokenizer(annotation,"\n");
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			annotationList.add(s);
		}*/

		/*
		String code = ""+codeSection;
		String annotation = ""+anNotationSection;

		ArrayList<String> codeList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(code,"\n");
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			codeList.add(s);
		}

		ArrayList<String> annotationList = new ArrayList<String>();
		st = new StringTokenizer(annotation,"\n");
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			annotationList.add(s);
		}*/



		//return true;
	}
}