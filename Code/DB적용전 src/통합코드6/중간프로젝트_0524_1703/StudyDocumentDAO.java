import java.util.*;
import java.text.*;
import java.io.*;

public class StudyDocumentDAO implements Serializable{

	private HashMap<String, LinkedList<StudyDocumentInfo>> studyDocumentDAO;
	private ArrayList<String> directoryList;

	final private static StudyDocumentDAO obj = new StudyDocumentDAO();

	public static StudyDocumentDAO getInstanceMethod() {
		return obj;
	}

	private StudyDocumentDAO() {
		this.studyDocumentDAO = new HashMap<String, LinkedList<StudyDocumentInfo>>();
		this.directoryList = new ArrayList<String>();
	}

	private boolean createDocumentDirectory()
	{
		StringTokenizer st = new StringTokenizer(new SimpleDateFormat().format(new Date()),". ");
		String todayDirectory = st.nextToken() + "/" + st.nextToken() + "/" + st.nextToken();
		// ���� ��¥�� ���丮�� �����Ǿ��ִ��� Ȯ��
		Iterator iter = directoryList.iterator();
		while(iter.hasNext())
		{
			// ���� ������ ���丮�� ������
			if( todayDirectory.equals(iter.next()) )
			{

				return true;//����
			}
		}
		// ���� ������ ���丮�� ������
		// ���� ��¥�� ���丮 ����
		directoryList.add(todayDirectory);

		studyDocumentDAO.put(todayDirectory, new LinkedList<StudyDocumentInfo>());
		return true;
	}

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

	// ������ �߰��ϱ� �޼ҵ�!!
	public String addNewStudyDocumentInfo(String directoryName)
	{
		return createDocumentCode(directoryName);
	}
	private String createDocumentCode(String directoryName)
	{
		System.out.println( " ���ݵ��丮 : " +  directoryName);
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(directoryName);
		String code="";

		if (docList == null)
		{
			docList = new LinkedList<StudyDocumentInfo>();
			
			StringTokenizer stok = new StringTokenizer(directoryName, "/");
			while(stok.hasMoreTokens())
			{
				code += stok.nextToken();
			}
			code += "1001";
			String newDocCon = "class  \n{\n\tpublic static void main(String[] args)\n{\t\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}\n";
			docList.add(new StudyDocumentInfo(code, "�� ����", new Date(), directoryName, new StudyContentsInfo(new StringBuilder(newDocCon), new StringBuilder("")), ".java"));

			studyDocumentDAO.put(directoryName, docList);
		}

		else
		{
			System.out.println( " ���� ������ : " + docList.size() );
			if( docList.size() == 0 )
			{
				StringTokenizer stok = new StringTokenizer(directoryName, "/");
				while(stok.hasMoreTokens())
				{
					code += stok.nextToken();
				}
				code += "1001";
				String newDocCon = "class  \n{\n\tpublic static void main(String[] args)\n{\t\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}\n";
				docList.add(new StudyDocumentInfo(code, "�� ����", new Date(), directoryName, new StudyContentsInfo(new StringBuilder(newDocCon), new StringBuilder("")), ".java"));		

			}
			else
			{

				for(int i=0; i<docList.size(); i++)
				{
					code = docList.get(i).getDocumentCode();
				}
				code = Integer.toString(Integer.parseInt(code) + 1);
				String newDocCon = "class  \n{\n\tpublic static void main(String[] args)\n\t{\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}\n";
				docList.add(new StudyDocumentInfo(code, "�� ����", new Date(), directoryName, new StudyContentsInfo(new StringBuilder(newDocCon), new StringBuilder("")), ".java"));		
			}
		}

		return code;
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

	// ���� �����ϱ� �޼ҵ� !!
	public boolean addStudyDocumentInfo(String documentCode, String documentName, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection, String documentForm)
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		StudyDocumentInfo docInfo = null;
		if(docList != null)
		{
			for(int i=0; i<docList.size(); i++)
			{
				docInfo = docList.get(i);
				if( docInfo.getDocumentCode().equals(documentCode) )
				{
					docInfo.setDocumentName(documentName);
					docInfo.setDocumentDate(new Date());
					docInfo.setDocumentContent(codeSection, annotationSection);
					docInfo.setDocumentForm(documentForm);
					return true;
				}
			}
			return false;
		}
		return false;
	}
	// ���丮 �̸����� ���� �ҷ�����
	public LinkedList<StudyDocumentInfo> searchStudyDocumentInfo( String documentDirectory )
	{
		return studyDocumentDAO.get(documentDirectory);
	}
	
	// ���丮, �����ڵ�� ���� �����ϱ�
	public boolean deleteStudyDocumentInfo( String documentCode,String documentDirectory)// �ڼ��� ����
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator<StudyDocumentInfo> iterator = docList.iterator();
		StudyDocumentInfo docInfo = null;
		if(docList != null)
		{
			while(iterator.hasNext())
			{
				docInfo=(StudyDocumentInfo)iterator.next();
				if(docInfo.getDocumentCode().equals(documentCode))
				{

					docList.remove(docInfo);
					return true;
				}
			}
		}
		return false;
	}
	public boolean deleteNewStudyDocumentInfo( String documentCode,String documentDirectory)// �ڼ��� ����
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator<StudyDocumentInfo> iterator = docList.iterator();
		StudyDocumentInfo docInfo = null;
		if(docList != null)
		{
			while(iterator.hasNext())
			{
				docInfo=(StudyDocumentInfo)iterator.next();
				if(docInfo.getDocumentCode().equals(documentCode))
				{
					if(docInfo.getDocumentName().equals("�� ����"))
					{
						docList.remove(docInfo);
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean deleteCheck(String documentCode,String documentDirectory)
	{
		LinkedList<StudyDocumentInfo> list=studyDocumentDAO.get(documentDirectory);
		Iterator<StudyDocumentInfo> iterator=list.iterator();
		StudyDocumentInfo obj=null;
		while(iterator.hasNext())
		{
			obj=(StudyDocumentInfo)iterator.next();
			if(obj.getDocumentCode().equals(documentCode))
			{
				if(obj.getDocumentName().equals("�� ����"))
				{
					return true;
				}
			}
		}
		return false;
	}

	// ���� �����ϱ� (���븸)
	public boolean modifyStudyDocumentInfo(String documentCode, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection)
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator<StudyDocumentInfo> iter = docList.iterator();
		StudyDocumentInfo docInfo = null;
		if(docList != null)
		{
			while( iter.hasNext() )
			{
				docInfo = iter.next();
				if( docInfo.getDocumentCode().equals(documentCode) )
				{
					docInfo.setDocumentDate(new Date());
					docInfo.setDocumentContent(codeSection, annotationSection);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	// ���� �����ϱ� 
	public boolean modifyStudyDocumentInfo(String documentCode, String documentName, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection, String documentForm)
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator<StudyDocumentInfo> iter = docList.iterator();
		StudyDocumentInfo docInfo = null;
		if(docList != null)
		{
			while( iter.hasNext() )
			{
				docInfo = iter.next();
				if( docInfo.getDocumentCode().equals(documentCode) )
				{
					docInfo.setDocumentName(documentName);
					docInfo.setDocumentDate(new Date());
					docInfo.setDocumentContent(codeSection, annotationSection);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean fileLoad()
	{
		//directoryFileLoad("doc");
		directoryFileLoad("DocDirectoryList");
		documentDAOFileLoad("DocumentDAO");
		return true;
	}

	public boolean fileSave()
	{
		directoryFileSave("DocDirectoryList");
		documentDAOFileSave("DocumentDAO");
		return true;
	}

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
					this.createDocumentDirectory();	// ������ ���丮 ���� �޼ҵ� ȣ��.
					break;
				}
				this.directoryList.add(directoryName);
			}
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
			return false;
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
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
						addFromFileDocumentDAO( docInfo.getDocumentDirectory(), docInfo);
					}
				}
			}
			catch(FileNotFoundException fnfe)
			{
				fnfe.printStackTrace();
				System.out.println("������ �������� ����");
				return false;
			}
			catch(EOFException eofe)
			{
				return false;
			}
			catch(ClassNotFoundException cnfe)
			{
				cnfe.printStackTrace();
				System.out.println("Ŭ������ �������� ����");
				return false;
			}
			catch(IOException ioe)
			{
				ioe.printStackTrace();
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
					eeee.printStackTrace();
					return false;
				}
			}
		}
	}

	public void addFromFileDocumentDAO(String directoryName, StudyDocumentInfo docInfo)
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

				if( docList == null )
				{
					continue;
				}
				else
				{
					for(int j=0; j<docList.size(); j++)
					{
						docInfo = docList.get(j);
						out.writeObject( docInfo );
					}
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

	private boolean directoryFileSave(String fileName) // ���丮 ��� ���� save
	{
		Iterator<String> iter = directoryList.iterator();
		PrintWriter write =null;
		try
		{
			write = new PrintWriter(new FileWriter(fileName+".txt"));
			while(iter.hasNext())
			{
				//System.out.println( iter.next() );
				write.println(iter.next());
			}
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
			return false;
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
				write.close();
			}
			catch (Exception e)
			{
				System.out.println("���� close() ����!");
			}
		}
		return true;
	}

///////////////////////////////�ʱⰪ ����.
	public void initStudyDocumentList()
	{
		//Date d = new Date(2015, 6, 8, 15, 30);
		StudyContentsInfo contents1 = new StudyContentsInfo(new StringBuilder("public class Thread1(){}\n"), new StringBuilder("Thread1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document1 = new StudyDocumentInfo("15581001", "Thread1", new Date(115, 4, 8, 15, 30), "15/5/8", contents1, ".java");

		StudyContentsInfo contents2_1 = new StudyContentsInfo(new StringBuilder("public class GUI1(){}\n"), new StringBuilder("GUI1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document2_1 = new StudyDocumentInfo("15591001", "GUI1", new Date(115, 4, 9, 6, 30), "15/5/9", contents2_1, ".java");

		StudyContentsInfo contents2_2 = new StudyContentsInfo(new StringBuilder("public class GUI2(){}\n"), new StringBuilder("GUI2 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document2_2 = new StudyDocumentInfo("15591002", "GUI2", new Date(115, 4, 9, 9, 30), "15/5/9", contents2_2, ".java");

		StudyContentsInfo contents2_3 = new StudyContentsInfo(new StringBuilder("public class GUI3(){}\n"), new StringBuilder("GUI3 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document2_3 = new StudyDocumentInfo("15591003", "GUI3", new Date(115, 4, 9, 19, 00), "15/5/9", contents2_3, ".java");

		StudyContentsInfo contents3_1 = new StudyContentsInfo(new StringBuilder("public class DailyTest1(){}\n"), new StringBuilder("DailyTest1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document3_1 = new StudyDocumentInfo("155101001", "DailyTest1", new Date(115, 4, 10, 10, 30), "15/5/10", contents3_1, ".java");

		StudyContentsInfo contents3_2 = new StudyContentsInfo(new StringBuilder("public class DailyTest2(){}\n"), new StringBuilder("DailyTest2 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document3_2 = new StudyDocumentInfo("155101002", "DailyTest2", new Date(115, 4, 10, 11, 00), "15/5/10", contents3_2, ".java");

		StudyContentsInfo contents4 = new StudyContentsInfo(new StringBuilder("public class RunableTest1(){}\n"), new StringBuilder("RunableTest1 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document4 = new StudyDocumentInfo("155111001", "RunableTest1", new Date(115, 4 , 11, 16, 00), "15/5/11", contents4, ".java");
	
		StudyContentsInfo contents5 = new StudyContentsInfo(new StringBuilder("public class RunableTest2(){}\n"), new StringBuilder("RunableTest2 Ŭ���� �Դϴ�.\n"));
		StudyDocumentInfo document5 = new StudyDocumentInfo("155121001", "RunableTest2", new Date(115, 4 , 12, 18, 00), "15/5/12", contents5, ".java");
	

		LinkedList<StudyDocumentInfo> docList1 = new LinkedList<StudyDocumentInfo>();
		docList1.add(document1);

		LinkedList<StudyDocumentInfo> docList2 = new LinkedList<StudyDocumentInfo>();
		docList2.add(document2_1);
		docList2.add(document2_2);
		docList2.add(document2_3);

		LinkedList<StudyDocumentInfo> docList3 = new LinkedList<StudyDocumentInfo>();
		docList3.add(document3_1);
		docList3.add(document3_2);

		LinkedList<StudyDocumentInfo> docList4 = new LinkedList<StudyDocumentInfo>();
		docList4.add(document4);

		LinkedList<StudyDocumentInfo> docList5 = new LinkedList<StudyDocumentInfo>();
		docList5.add(document5);

		studyDocumentDAO.put( directoryList.get(0), docList1);
		studyDocumentDAO.put( directoryList.get(1), docList2);
		studyDocumentDAO.put( directoryList.get(2), docList3);
		studyDocumentDAO.put( directoryList.get(3), docList4);
		studyDocumentDAO.put( directoryList.get(4), docList5);
	}

	public boolean saveCheck(String documentCode,String documentDirectory) // �ڼ��� ����
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator iterator=docList.iterator();
		StudyDocumentInfo obj=null;
		while(iterator.hasNext())
		{
			obj=(StudyDocumentInfo)iterator.next();
			if(obj.getDocumentCode().equals(documentCode))
			{
				if(obj.getDocumentName().equals("�� ����"))
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean saveAsStudyDocumentInfo(String documentCode, String documentName, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection, String documentForm) //���� �ڼ���
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator iterator=docList.iterator();
		StudyDocumentInfo docInfo = null;
		if(docList != null)
		{
			while(iterator.hasNext())
			{
				docInfo=(StudyDocumentInfo)iterator.next();
				if(docInfo.getDocumentCode().equals(documentCode))
				{
					docInfo.setDocumentName(documentName);
					docInfo.setDocumentDate(new Date());
					docInfo.setDocumentContent(codeSection, annotationSection);
					docInfo.setDocumentForm(documentForm);
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public boolean saveStudyDocumentInfo(String documentCode, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection) //���� �ڼ���
	{
		LinkedList<StudyDocumentInfo> docList = studyDocumentDAO.get(documentDirectory);
		Iterator iterator=docList.iterator();
		StudyDocumentInfo docInfo = null;
		while(iterator.hasNext())
		{
			docInfo=(StudyDocumentInfo)iterator.next();
			if(docInfo.getDocumentCode().equals(documentCode))
			{
					//docInfo.setDocumentName(documentName);
					docInfo.setDocumentDate(new Date());
					docInfo.setDocumentContent(codeSection, annotationSection);
					//docInfo.setDocumentForm(documentForm);
					return true;
			}
		}
		return false;
	}
}
