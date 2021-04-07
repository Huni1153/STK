import java.util.*;
import java.io.*;

public class StudyDocumentDAO implements Serializable{

	private HashMap<String, LinkedList<StudyDocumentInfo>> studyDocumentDAO;
	private ArrayList<String> directoryList;

	final private static StudyDocumentDAO obj = new StudyDocumentDAO();

	public static StudyDocumentDAO getInstanceMethod() {//���������� ����
		return obj;
	}

	private StudyDocumentDAO() {
		this.studyDocumentDAO = new HashMap<String, LinkedList<StudyDocumentInfo>>();
		this.directoryList = new ArrayList<String>();
	}
	/*
	public StudyDocumentDAO(HashMap<String, LinkedList<StudyDocumentInfo>> studyDocumentDAO) 
	{
		if(studyDocumentDAO != null)
		{
			this.studyDocumentDAO = studyDocumentDAO;
		}
		else
		{
			this.studyDocumentDAO = new HashMap<String, LinkedList<StudyDocumentInfo>>();
		}
	}*/
	
	public void setStudyDocumentList(HashMap<String, LinkedList<StudyDocumentInfo>> studyDocumentDAO) {
		this.studyDocumentDAO = studyDocumentDAO;
	}
	
	public HashMap<String, LinkedList<StudyDocumentInfo>> getStudyDocumentList() {
		return this.studyDocumentDAO;
	}

	public void setDirectoryList(ArrayList<String> directoryList)
	{
		this.directoryList = directoryList;
	}
	public ArrayList<String> getDirectoryList()
	{
		return this.directoryList;
	}

	public void addStudyDocumentInfo(String directoryName, StudyDocumentInfo docInfo)
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(directoryName);
		if(docList != null)
		{
			docList.add(docInfo);
		}
		else
		{
			docList = new LinkedList<StudyDocumentInfo>();
			docList.add(docInfo);
			studyDocumentDAO.put(directoryName, docList);
		}
	}

	public void addStudyDocumentInfo(String directoryName, LinkedList<StudyDocumentInfo> docInit)
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(directoryName);
		if(docList != null)
		{
			docList = docInit;
			for(int i=0; i<docInit.size(); i++)
			{
				docList.add( docInit.get(i) );
			}
		}
		else
		{
			docList = new LinkedList<StudyDocumentInfo>();
			docList = docInit;
			studyDocumentDAO.put(directoryName, docList);
		}
	}
	public boolean addStudyDocumentInfo(String documentCode,String documentName,Date documentDate,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		// �ڼ��� �߰�
		return true;
	}
	
	public boolean modifyStudyDocumentInfo(String documentCode,String documentName,Date documentDate,String documentDirectory,StringBuilder codeSection,StringBuilder anNotationSection,String documentForm)
	{
		// �ڼ��� �߰�
		return true;
	}
	public boolean deleteStudyDocumentInfo(String documentCode)
	{
		// �ڼ��� �߰�
		return true;
	}

	public boolean fileLoad()
	{
		directoryFileLoad("DocDirectoryList");
		documentDAOFileLoad("DocumentDAO");
		return true;
	}





/////////////////////////////////////////////////////////////////	
	private boolean directoryFileLoad(String fileName) // ���丮 ��� ���� load
	{
		BufferedReader read =null;
		try
		{
			read = new BufferedReader(new FileReader(fileName+".txt"));
			this.directoryList.clear();
			while(true)
			{
				String directoryName = read.readLine();
				if(directoryName == null)
				{
					break;
				}
				this.directoryList.add(directoryName);
			}
		}
		catch(FileNotFoundException fnfe)
		{
			return false;
		}
		catch (IOException ioe)
		{
			return false;
		}
	
		return true;
	}


	private boolean documentDAOFileLoad(String fileName)	// ���� ��� DAO load
	{
		StudyDocumentInfo docInfo = null;
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new FileInputStream(fileName + ".txt"));
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				while(true)
				{
					Object obj = in.readObject();
					if(obj==null)
						break;
					if( obj instanceof StudyDocumentInfo )
					{
						docInfo = (StudyDocumentInfo)obj;
						System.out.println(docInfo);
						addFromFileDirectoryList( docInfo.getDocumentDirectory(), docInfo);
					}
				}
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("������ �������� ����");
				return false;
			}
			catch(EOFException eofe)
			{
				return false;
			}
			catch(ClassNotFoundException cnfe)
			{
				System.out.println("Ŭ������ �������� ����");
				return false;
			}
			catch(IOException ioe)
			{
				System.out.println("���� �б� ����!");
				return false;
			}
			finally
			{
				try
				{
					in.close();
					return true;
				}
				catch (Exception eeee)
				{
					return false;
				}
			}
		}
	}

	public void addFromFileDirectoryList(String directoryName, StudyDocumentInfo docInfo)
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(directoryName);
		if(docList != null)
		{
			docList.add(docInfo);
		}
		else
		{
			docList = new LinkedList<StudyDocumentInfo>();
			docList.add(docInfo);
			studyDocumentDAO.put(directoryName, docList);
		}
	}

	private boolean documentDAOFileSave(String fileName)	// ���� DAO ���� save
	{
		LinkedList<StudyDocumentInfo> docList = null;
		StudyDocumentInfo docInfo = null;
		ObjectOutputStream out = null;
		try
		{
			out = new ObjectOutputStream(new FileOutputStream(fileName + ".txt"));

			for( int i=0; i<directoryList.size(); i++)
			{
				
				docList = studyDocumentDAO.get( directoryList.get(i) );
				for(int j=0; j<docList.size(); j++)
				{
					docInfo = docList.get(j);
					out.writeObject( docInfo );
				}
			}

		}
		catch (IOException ioe)
		{
			System.out.println("���� ��� ����!");
			return false;
		}
		finally
		{
			try
			{
				out.close();
			}
			catch (Exception e)
			{
				System.out.println("���� close() ����!");
			}
		}
		return true;
	}
//////////////////////////




///////////////////////////////�ʱⰪ ����.
	public void initStudyDocumentList()
	{
		//Date d = new Date(2015, 6, 8, 15, 30);
		StudyContentsInfo contents1 = new StudyContentsInfo(new StringBuilder("public class Thread1(){}\n"), new StringBuilder("Thread1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document1 = new StudyDocumentInfo("155881001", "Thread1", new Date(2015, 4, 8, 15, 30), "15/5/8", contents1, ".java");

		StudyContentsInfo contents2_1 = new StudyContentsInfo(new StringBuilder("public class GUI1(){}\n"), new StringBuilder("GUI1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document2_1 = new StudyDocumentInfo("15591001", "GUI1", new Date(2015, 4, 9, 6, 30), "15/5/9", contents2_1, ".java");

		StudyContentsInfo contents2_2 = new StudyContentsInfo(new StringBuilder("public class GUI2(){}\n"), new StringBuilder("GUI2 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document2_2 = new StudyDocumentInfo("15591002", "GUI2", new Date(2015, 4, 9, 9, 30), "15/5/9", contents2_2, ".java");

		StudyContentsInfo contents2_3 = new StudyContentsInfo(new StringBuilder("public class GUI3(){}\n"), new StringBuilder("GUI3 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document2_3 = new StudyDocumentInfo("15591003", "GUI3", new Date(2015, 4, 9, 19, 00), "15/5/9", contents2_3, ".java");

		StudyContentsInfo contents3_1 = new StudyContentsInfo(new StringBuilder("public class DailyTest1(){}\n"), new StringBuilder("DailyTest1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document3_1 = new StudyDocumentInfo("155101001", "DailyTest1", new Date(2015, 4, 10, 10, 30), "15/5/10", contents3_1, ".java");

		StudyContentsInfo contents3_2 = new StudyContentsInfo(new StringBuilder("public class DailyTest2(){}\n"), new StringBuilder("DailyTest2 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document3_2 = new StudyDocumentInfo("155101002", "DailyTest2", new Date(2015, 4, 10, 11, 00), "15/5/10", contents3_2, ".java");

		StudyContentsInfo contents4 = new StudyContentsInfo(new StringBuilder("public class RunableTest1(){}\n"), new StringBuilder("RunableTest1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document4 = new StudyDocumentInfo("155111001", "RunableTest1", new Date(2015, 4 , 11, 16, 00), "15/5/11", contents4, ".java");
	
		LinkedList<StudyDocumentInfo> docList1 = new LinkedList<StudyDocumentInfo>();
		docList1.add(document1);

		LinkedList<StudyDocumentInfo> docList2 = new LinkedList<StudyDocumentInfo>();
		docList2.add(document2_1);
		docList2.add(document2_2);

		LinkedList<StudyDocumentInfo> docList3 = new LinkedList<StudyDocumentInfo>();
		docList3.add(document3_1);
		docList3.add(document3_2);

		LinkedList<StudyDocumentInfo> docList4 = new LinkedList<StudyDocumentInfo>();
		docList4.add(document4);

		studyDocumentDAO.put( directoryList.get(0), docList1);
		studyDocumentDAO.put( directoryList.get(1), docList2);
		studyDocumentDAO.put( directoryList.get(2), docList3);
		studyDocumentDAO.put( directoryList.get(3), docList4);
	}



/*
	
	public boolean fileLoad(String fileName) {
	
	}
	
	public boolean fileSave(String fileName) {
	
	}
	
	public boolean addStudyDocumentInfo(String directoryName) {
		
	}
	
	public boolean addStudyDocumentInfo(�н��������� documentInfo) {
	
	}
	
	public boolean<<�˻��Ѵ�<�ҷ��� �н������� �ִ�����, ���� ��¥�� ��������>> checkDocumentInfoByDate(Date targetDate) {
	
	}
	
	public boolean checkDocumentInfoByDirectoryName(String directroyName) {
	
	}
	
	public boolean checkExistDocumentInfo(String documentCode) {
	
	}
	
	public boolean checkExistDocumentInfo(String directoryName, String documentCode) {
	
	}
	
	public boolean checkExistDocumentDirectory(String directoryName) {
	
	}
	
	public DocumentInfo getStudyDocumentInfo(String directoryName, String documentCode) {
	
	}
	
	public boolean deleteStudyDocumentInfo(String documentCode) {
	
	}
	
	public boolean deleteStudyDocumentInfo(String directoryName, String documentCode) {
	
	}
	
	public boolean saveAsDocumentInfo(String newDirectoryName, DocumentInfo documentInfo) {
	
	}
	
	public DocumentInfo selectDocumentInfo(String directoryName, String documentName) {
	
	}
	
	public LinkedList<DocumentInfo> provideDocumentList(String directoryName) {
	
	}
	
	public Object[][] provideDocumentArray(String directoryName) {
	
	}*/

	public static void main(String[] agrs)
	{
		StudyDocumentDAO.getInstanceMethod().fileLoad();

		//doc.fileLoad();	
		//d.directoryFileLoad("DocDirectoryList");
		//doc.initStudyDocumentList();
		//doc.documentDAOFileSave("DocumentDAO");
		//d.documentDAOFileLoad("DocumentDAO");
	}

}
