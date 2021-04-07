package Model;
import java.util.*;

public class GetDocumentDirectoryListController
{
	private StudyDocumentDAO studyDocumentDAO;
	public GetDocumentDirectoryListController()
	{
		this.studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
	}

	public String[] getDirectoryList()
	{
		return convertDirectoryList();
	}

	private String[] convertDirectoryList()
	{
		ArrayList<String> directoryList = studyDocumentDAO.getDirectoryList();
		String[] documentDirectoryList;
		int dirSize = directoryList.size();

		documentDirectoryList = new String[dirSize];

		for(int i=0; i<dirSize; i++ )
		{
			documentDirectoryList[i] = directoryList.get(i);
		}
		return documentDirectoryList;
	}
}