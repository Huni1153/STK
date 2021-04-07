public class SaveCheckController
{
   private StudyDocumentDAO studyDocumentDAO;
   private StudyDocumentDBDAO studyDocumenDBtoDAO;

   public SaveCheckController()
   {
      this.studyDocumentDAO=StudyDocumentDAO.getInstanceMethod();
      this.studyDocumenDBtoDAO=StudyDocumentDBDAO.getInstance();
   }
   public SaveCheckController(StudyDocumentDAO studyDocumentDAO)
   {
      this.studyDocumentDAO=studyDocumentDAO;
   }
   public boolean saveCheck(String documentCode,String documentDirectory)
   {
      if(this.studyDocumentDAO.saveCheck(documentCode,documentDirectory))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
 // 0531_1950 ¼¼ÈÆ  // 0531_1950 ¼¼ÈÆ 
   public boolean saveCheck(String documentCode)
   {
      if(this.studyDocumenDBtoDAO.checkDocumentCode(documentCode))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}