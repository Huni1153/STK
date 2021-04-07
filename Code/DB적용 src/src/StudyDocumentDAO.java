import java.util.*;
import java.text.*;
import java.io.*;

public class StudyDocumentDBDAO implements Serializable
{
	private  LinkedList<StudyDocumentInfo> studyDocumentDBDAO;

	public StudyDocumentDBDAO()
	{
		this.studyDocumentDBDAO = new LinkedList<StudyDocumentInfo>();
	}
	public boolean insertAsDocumentInfo(String documentCode, String documentName, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection, String documentForm) //���� �ڼ���
	{
		StudyDocumentInfoDBDAO document=null;
		StudyContentsInfoDBDAO contents=null;
		StudyContentsInfo info=new StudyContentsInfo(codeSection,annotationSection);
		StudyDocumentInfo obj=new StudyDocumentInfo(documentCode,documentName,new Date(),documentDirectory,info,documentForm);
		
		this.studyDocumentDBDAO.add(obj);
		if(this.studyDocumentDAO.size()==10)
		{
			Iterator iterator=this.studyDocumentDBDAO.iterator();
			document=new StudyDocumentInfoDBDAO();
			contents=new StudyContentsInfoDBDAO();
			while(iterator.hasNext())
			{
				obj=(StudyDocumentInfo)iterator.next();
				document.insert(obj.getDocumentCode(),obj.getDocumentName(),obj.getDocumentDate(),obj.getDocumentDirectory(),obj.getDocumentForm());
				info=obj.getDocumentContent();
				contents.insert(obj.getDocumentCode(),info.getCodeSection()+"",info.getAnnotationSection()+"");
			}			
		}
		return true;
	}

	public boolean insertDocumentInfo(String documentCode, String documentDirectory, StringBuilder codeSection, StringBuilder annotationSection) //���� �ڼ���
	{

		Iterator iterator=studyDocumentDBDAO.iterator();
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
	public SimpleDocument[] viewDocumentInfo()
	{
		StudyDocumentInfoDBDAO obj=new StudyDocumentInfoDBDAO();
		SimpleDocument[] list=obj.selectAll();
		return list;
	}

	public int updateStudyDocumentInfo(String documentCode,String documentName,StringBuilder codeSection,StringBuilder noteSection)
	{
		int row=0;
		StudyDocumentInfoDBDAO documentDAO=new StudyDocumentInfoDBDAO();
		Iterator iterator=this.studyDocumentDAO.iterator();
		while(iterator.hasNext())
		{
			StudyDocumentInfo obj=(StudyDocumentInfo)iterator.next();
			if(obj.getDocumentCode().equals(documentCode))
			{
				obj.setDocumentName(documentName);
				obj.setDocumentDate(new Date());
				obj.setDocumentContent(codeSection,noteSection);
				return 1;
			}
			else
			{
				//documentDAO.update(
			}
		}
		return 0;
	}
	public static void main(String[] args)
	{

		StudyDocumenDBtDAO obj=new StudyDocumentDBDAO();
		StudyDocumentInfo res=null;
		obj.saveAsStudyDocumentInfo("155291007","test1","15/5/29",new StringBuilder("test1Class"),new StringBuilder("test1Class"),".java");
		obj.saveAsStudyDocumentInfo("155291008","test2","15/5/29",new StringBuilder("test2Class"),new StringBuilder("test2Class"),".java");
//		StudyDocumentInfoDBDAO dao=new StudyDocumentInfoDBDAO();
//		res=dao.selectCode("155291008");
//		System.out.println(res);
//		SimpleDocument[] list=null;
//		list=obj.viewDocumentInfo();
//		for(int i=0;i<list.length;i++)
//		{
//			System.out.println(list[i]);
//		}
		
	}
}