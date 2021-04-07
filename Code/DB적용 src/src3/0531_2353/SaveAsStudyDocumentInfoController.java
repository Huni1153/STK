import java.util.*;
import java.io.*;

public class SaveAsStudyDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;

	private ArrayList<String> leftList;
	private ArrayList<String> rightList;
   	final private ArrayList<String> leftTmp = new ArrayList<String>();
	final private ArrayList<String> rightTmp = new ArrayList<String>();
	final private ArrayList<String> javaList = new ArrayList<String>();

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
	public boolean saveAsStudyDocumentInfoToDB(String documentCode,String documentName,String documentDirectory,StringBuilder codeSection,StringBuilder noteSection)
	{
		if(this.studyDocumentDBDAO.updateAsDocumentInfo(documentCode,documentName,documentDirectory,codeSection,noteSection))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

//// 0531_2035 대섭 슈졍
	public boolean createJava(String documentName,ArrayList<String> leftList ,ArrayList<String> rightList ,String documentForm)
	{

		//System.out.println( "L 사이즈 : " + leftList.size());
		//System.out.println( "R 사이즈 : " + rightList.size());

		this.leftList = leftList;
		this.rightList = rightList;
		StringBuilder lBuilder = new StringBuilder();
		StringBuilder rBuilder = new StringBuilder();

		leftTmp.clear();
		rightTmp.clear();
		javaList.clear();

		for(String str : leftList)
		{
			if ( str.length() < 3)
			{
				lBuilder.append(str+"\n");
			}
			else
			{
				if( str.substring(str.length()-2, str.length()-1).equals("#") )
				{
					lBuilder.append(str.substring(0, str.length()-3)+"\n");
					lBuilder.trimToSize();
					leftTmp.add( ""+lBuilder );
					lBuilder.setLength(0);
				}
				else
				{
					lBuilder.append( str+"\n" );
				}
			}
		}
		lBuilder.trimToSize();
		leftTmp.add( ""+lBuilder );

		for(String str : rightList)
		{
			if (str.length() < 2)
			{
				rBuilder.append( "//" + str + "\n" );
			}
				else
				{
				if( str.substring(0,2).equals("#1") )
				{
					rBuilder.append( "//" + str.substring( 4, str.length() )+"\n" );
				}
				else
				{
					if ( str.substring(0,1).equals("#") )
					{
						rBuilder.trimToSize();
						rightTmp.add( ""+rBuilder );
						rBuilder.setLength(0);
						rBuilder.append( "//" + str.substring( 4, str.length() )+"\n" );
					}
					else
					{
						rBuilder.append( "//" + str + "\n" );
					}
				}
			}
		}
		rBuilder.trimToSize();
		rightTmp.add( ""+rBuilder );

		Iterator<String> iter = rightTmp.iterator();
		Iterator<String> iter1 = leftTmp.iterator();

	outLoop:
		while( iter1.hasNext() )
		{
			javaList.add( iter1.next() );	

			while( iter.hasNext() )
			{
				javaList.add( iter.next() );
				continue outLoop;

			}
		}

		save("Codes/"+documentName+documentForm);

		return true;
	}

	public boolean save(String javaPath)
	{
		PrintWriter writer=null;
		try
		{
			writer=new PrintWriter(javaPath);
			for(String str : javaList)
			{
				writer.print(str);
			}
		}
		catch (IOException ioe)
		{
			System.out.println("파일로 출력 실패!");
			ioe.printStackTrace();
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

		return true;
	}
/*
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
	//}
}