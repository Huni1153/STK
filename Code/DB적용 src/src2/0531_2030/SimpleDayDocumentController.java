import java.util.*;

public class SimpleDayDocumentController
{
	private StudyDocumentDAO studyDocumentDAO;
	private StudyDocumentDBDAO studyDocumentDBDAO;

	public SimpleDayDocumentController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
		this.studyDocumentDBDAO = StudyDocumentDBDAO.getInstance();
	}

	public String[][] getSimpleDayDocument(String y, String m, String d)
	{
		String dir = y+"/"+m+"/"+d;
		return convertSimpleDayDocument( dir );
	}

	public String[][] getSimpleDayDocument(String dir)
	{
		//String dir = y+"/"+m+"/"+d;
		return convertSimpleDayDocument( dir );
	}

	/*private String[][] convertSimpleDayDocument(String documentDirectory)
	{
		LinkedList<StudyDocumentInfo> docList = 
			studyDocumentDAO.searchStudyDocumentInfo(documentDirectory);
		StudyDocumentInfo docInfo = null;

		if( docList == null){
			return null;
		}
		else{

		String[][] simpleDayDocument;
		int dirSize = docList.size();

		simpleDayDocument = new String[dirSize][3];

		for(int i=0; i<dirSize; i++ )
		{
			docInfo = docList.get(i);
			simpleDayDocument[i][0] = docInfo.getDocumentCode();
			simpleDayDocument[i][1] = docInfo.getDocumentName();
			simpleDayDocument[i][2] = docInfo.getDocumentDirectory();
		}
		return simpleDayDocument;

		}
	}*/


// 0531_1852_´ë¼· ½´Á´
	private String[][] convertSimpleDayDocument(String documentDirectory)
	{
		//LinkedList<StudyDocumentInfo> docList = 
		//	studyDocumentDAO.searchStudyDocumentInfo(documentDirectory);

		return studyDocumentDBDAO.selectDocumentPath(documentDirectory);
	}
// 0531_1852_´ë¼· ½´Á´
}