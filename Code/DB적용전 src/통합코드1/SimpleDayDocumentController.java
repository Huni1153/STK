import java.util.*;

public class SimpleDayDocumentController
{
	private StudyDocumentDAO studyDocumentDAO;
	public SimpleDayDocumentController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
	}

	public String[][] getSimpleDayDocument(String y, String m, String d)
	{
		String dir = y+"/"+m+"/"+d;
		return convertSimpleDayDocument( dir );
	}

	private String[][] convertSimpleDayDocument(String documentDirectory)
	{
		LinkedList<StudyDocumentInfo> docList = 
			studyDocumentDAO.searchStudyDocumentInfo(documentDirectory);
		StudyDocumentInfo docInfo = null;

		String[][] simpleDayDocument;
		int dirSize = docList.size();

		simpleDayDocument = new String[dirSize][3];

		for(int i=0; i<dirSize; i++ )
		{
			docInfo = docList.get(i);
			simpleDayDocument[i][0] = docInfo.getDocumentCode();
			simpleDayDocument[i][1] = docInfo.getDocumentName()+docInfo.getDocumentForm();
			simpleDayDocument[i][2] = docInfo.getDocumentDirectory();
		}
		return simpleDayDocument;
	}
}