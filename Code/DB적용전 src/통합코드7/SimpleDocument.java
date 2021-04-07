public class SimpleDocument
{
   private String documentName;
   private String documentCode;
   private String documentDirectory;

   public SimpleDocument(){}
   public SimpleDocument(String documentName, String documentCode, String documentDirectory)
   {
      this.documentName  = documentName;
      this.documentCode = documentCode;
      this.documentDirectory = documentDirectory;
   }
   public void setDocumentName(String documentName)
   {
      this.documentName = documentName;
   }
   public String getDocumentName()
   {
      return documentName;
   }
   public void setDocumentCode(String documentCode)
   {
      this.documentCode = documentCode;
   }
   public String getDocumentCode()
   {
      return documentCode;
   }
   public void setDocumentDirectory(String documentDirectory)
   {
      this.documentDirectory = documentDirectory;
   }
   public String getDocumentDirectory()
   {
      return documentDirectory;
   }
   public String toString()
   {
      return "코드 : "+this.documentCode+"\n파일 명 : "+this.documentName+"\n파일 위치 : "+this.documentDirectory;
   }
}