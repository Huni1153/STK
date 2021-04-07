import java.util.*;

public class StudyDocumentDAO
{
   private LinkedList<StudyDocumentInfo> studyDocumentList;
   private StudyDocumentInfoDAO studyDocumentInfoDAO;

   public StudyDocumentDAO()
   {
	   this.studyDocumentList=new LinkedList<StudyDocumentInfo>();
   }
   public StudyDocumentDAO(StudyDocumentInfoDAO studyDocumentInfoDAO)
   {
      this.studyDocumentInfoDAO = studyDocumentInfoDAO;
   }
   public void setStudyDocumentList(LinkedList<StudyDocumentInfo> studyDocumentList)
   {
	   this.studyDocumentList=studyDocumentList;
   }
   public LinkedList<StudyDocumentInfo> getStudyDocumentList()
   {
	   return this.studyDocumentList;
   }
   public int insert(String documentCode,String documentName,String documentPath,StringBuilder codeSection,StringBuilder noteSection,String documentForm)
   {
	   StudyDocumentInfo obj=new StudyDocumentInfo(documentCode,documentName,documantPath,codeSection,noteSection,documentForm);
		this.studyDocumentList.add();
   }
   public int updateName(String documentCode, String documentName)
   {
   }
   public int updateDate(String documentCode, String documentDate)
   {
   }
   public int update(String documentCode, String documentName, String documentDate)
   {
   }
   public int delete(String documentCode)
   {
   }
   public StudyDocumentInfo selectCode(String documentCode)
   {
   }
   public StudyDocumentInfo[] selectName(String documentName)
   {
   }
   public StudyDocumentInfo[] selectPath(String documentPath)
   {
   }
}