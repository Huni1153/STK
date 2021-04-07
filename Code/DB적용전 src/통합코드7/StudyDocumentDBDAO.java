import java.util.*;
import java.text.*;
import java.io.*;

public class StudyDocumentDBDAO implements Serializable
{
   final private  LinkedList<StudyDocumentInfo> studyDocumentDBDAO;
   final static private StudyDocumentDBDAO obj = new StudyDocumentDBDAO();

   private StudyDocumentDBDAO()
   {
      this.studyDocumentDBDAO = new LinkedList<StudyDocumentInfo>();
   }
   public static StudyDocumentDBDAO getInstance()
   {
      return obj;
   }

 //0531_1514 ´ë¼·½´Á´
	public boolean insertDocumentInfo(String documentCode, String documentDirectory, StringBuilder codeSection, StringBuilder noteSection)
	{
		String newDocCon = "class  \n{\n\tpublic static void main(String[] args)\n\t{\n\t\tSystem.out.println(\"Hello World!\");\n\t}\n}\n";
		studyDocumentDBDAO.add(new StudyDocumentInfo(documentCode, "»õ ¹®¼­", new Date(), documentDirectory, new StudyContentsInfo(new StringBuilder(newDocCon), noteSection), ".java"));

		if( studyDocumentDBDAO.size() >= 2)
		{
			StudyDocumentInfoDBDAO documentJDBC = new StudyDocumentInfoDBDAO();
			StudyContentsInfoDBDAO contentsJDBC = new StudyContentsInfoDBDAO();

			for( StudyDocumentInfo docInfo : studyDocumentDBDAO )
			{
				int row1 = documentJDBC.insert( docInfo.getDocumentCode(), docInfo.getDocumentName(), docInfo.getDocumentDate(), docInfo.getDocumentDirectory(), docInfo.getDocumentForm() );
				StudyContentsInfo conInfo = docInfo.getDocumentContent();
				row1 = contentsJDBC.insert( docInfo.getDocumentCode(), ""+conInfo.getCodeSection(), ""+conInfo.getAnnotationSection() );
			}
			studyDocumentDBDAO.clear();
		}
		return true;
	}
//0531_1514 ´ë¼·½´Á´


 
	public boolean updateAsDocumentInfo(String documentCode, String documentName, String documentDirectory, StringBuilder codeSection, StringBuilder noteSection) //¼öÁ¤ ¹Ú¼¼ÈÆ
    {
		StudyDocumentInfoDBDAO document=null;
	  StudyContentsInfoDBDAO contents=null;
      Iterator<StudyDocumentInfo> iterator=studyDocumentDBDAO.iterator();
      StudyDocumentInfo docInfo = null;
      while(iterator.hasNext())
      {
         docInfo=(StudyDocumentInfo)iterator.next();
         if(docInfo.getDocumentCode().equals(documentCode))
         {
               docInfo.setDocumentName(documentName);
               docInfo.setDocumentDate(new Date());
               docInfo.setDocumentContent(codeSection,noteSection);
               return true;
         }
      }
		document=new StudyDocumentInfoDBDAO();
		contents=new StudyContentsInfoDBDAO();
		if(document.update(documentCode,documentName,new Date())==1 && contents.update(documentCode,codeSection+"",noteSection+"")==1)
	   {
			return true;
	   }
	   else
	   {
			return false;
	   }
   }

   public boolean updateDocumentInfo(String documentCode, String documentDirectory, StringBuilder codeSection, StringBuilder noteSection) //¼öÁ¤ ¹Ú¼¼ÈÆ
   {
	  StudyDocumentInfoDBDAO document=null;
	  StudyContentsInfoDBDAO contents=null;
      Iterator iterator=studyDocumentDBDAO.iterator();
      StudyDocumentInfo docInfo = null;
      while(iterator.hasNext())
      {
         docInfo=(StudyDocumentInfo)iterator.next();
         if(docInfo.getDocumentCode().equals(documentCode))
         {
               docInfo.setDocumentDate(new Date());
               docInfo.setDocumentContent(codeSection,noteSection);
               return true;
         }
      }
		document=new StudyDocumentInfoDBDAO();
		contents=new StudyContentsInfoDBDAO();
		if(document.updateDate(documentCode,new Date())==1 && contents.update(documentCode,codeSection+"",noteSection+"")==1)
	   {
			return true;
	   }
	   else
	   {
			return false;
	   }
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
      Iterator iterator=this.studyDocumentDBDAO.iterator();
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
      }
      return 0;
   }
   public StudyDocumentInfo selectDocumentCode(String documentCode)
   {
	  StudyDocumentInfoDBDAO document=null;
      StudyDocumentInfo obj=null;
      Iterator iterator=this.studyDocumentDBDAO.iterator();
      while(iterator.hasNext())
      {
         obj=(StudyDocumentInfo)iterator.next();
         if(obj.getDocumentCode().equals(documentCode))
         {
            return obj;
         }
      }
	  document=new StudyDocumentInfoDBDAO();
	  obj=document.selectCode(documentCode);
      return obj;
   }
   public boolean deleteStudyDocumentInfo(String documentCode)
   {
		StudyDocumentInfoDBDAO document=null;
		StudyDocumentInfo obj=null;
		Iterator iterator=this.studyDocumentDBDAO.iterator();
		while(iterator.hasNext())
		{
			obj=(StudyDocumentInfo)iterator.next();
			if(obj.getDocumentCode().equals(documentCode))
			{
				this.studyDocumentDBDAO.remove(obj);
				return true;
			}
		}
		document=new StudyDocumentInfoDBDAO();
		if(document.delete(documentCode)==1)
		{
			return true;
		}
		else
		{
			return false;
		}
   }
   public boolean checkDocumentCode(String documentCode) //0531 ¼¼ÈÆ ¼öÁ¤
   {
	   StudyDocumentInfoDBDAO document=null;
	   StudyDocumentInfo obj=null;
	   Iterator iterator=this.studyDocumentDBDAO.iterator();
	   while(iterator.hasNext())
	   {
		   obj=(StudyDocumentInfo)iterator.next();
		   if(obj.getDocumentCode().equals(documentCode))
		   {
			   if(obj.getDocumentName().equals("»õ ¹®¼­"))
			   {
				   return true;
			   }
		   }
	   }
	   document=new StudyDocumentInfoDBDAO();
	   if(document.checkCode(documentCode)!=null)
	   {
			return true;
	   }
		else
	   {
			return false;
	   }
   }
   /*
   public static void main(String[] args)
   {

      StudyDocumentDBDAO obj=new StudyDocumentDBDAO();
      StudyDocumentInfo res=null;
      obj.insertAsDocumentInfo("155291007","test1","15/5/29",new StringBuilder("test1Class"),new StringBuilder("test1Class"),".java");
      obj.insertAsDocumentInfo("155291008","test2","15/5/29",new StringBuilder("test2Class"),new StringBuilder("test2Class"),".java");
//      StudyDocumentInfoDBDAO dao=new StudyDocumentInfoDBDAO();
//      res=dao.selectCode("155291008");
//      System.out.println(res);
//      SimpleDocument[] list=null;
//      list=obj.viewDocumentInfo();
//      for(int i=0;i<list.length;i++)
//      {
//         System.out.println(list[i]);
//      }
      
   }*/
}