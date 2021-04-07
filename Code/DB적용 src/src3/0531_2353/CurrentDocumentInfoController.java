import java.util.*;

public class CurrentDocumentInfoController
{
	private StudyDocumentDAO studyDocumentDAO;
	public CurrentDocumentInfoController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
	}

	public Object[] getCurrentDocumentInfo(String documentCode, String documentDirectory)
	{
		return convertCurrentDocumentInfo(documentCode, documentDirectory);
	}
	private Object[] convertCurrentDocumentInfo(String documentCode, String documentDirectory)
	{
		Object[] obj = new Object[6];
		LinkedList<StudyDocumentInfo> docList = 
			studyDocumentDAO.searchStudyDocumentInfo(documentDirectory);
		StudyDocumentInfo docInfo = null;
		if( docList == null){
			return null;
		}

		else {

		Iterator<StudyDocumentInfo> iter = docList.iterator();

		System.out.println(docList.size());

		while(iter.hasNext())
		{
			docInfo = iter.next();
			System.out.println(docInfo.getDocumentCode() + "   ///   " + documentCode );

			if( docInfo.getDocumentCode().equals( documentCode ) ) { 
				
				obj[0] = docInfo.getDocumentCode();
				obj[1] = docInfo.getDocumentName();
				obj[2] = docInfo.getDocumentDirectory();
				obj[3] = docInfo.getDocumentContent().getCodeSection();
				obj[4] = docInfo.getDocumentContent().getAnnotationSection();
				obj[5] = docInfo.getDocumentForm();

				return obj;
			}
		}
		return null;
		}
		
	}
}