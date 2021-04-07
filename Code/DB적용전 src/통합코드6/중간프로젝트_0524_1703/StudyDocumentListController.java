import java.util.*;

////////////// 0516_´ë¼·_½´Á´3////////////// 0516_´ë¼·_½´Á´3
public class StudyDocumentListController
{
	private StudyDocumentDAO studyDocumentDAO;

	public StudyDocumentListController()
	{
		studyDocumentDAO = StudyDocumentDAO.getInstanceMethod();
	}

	public String[][] getStudyDocumentList()
	{
		return convertStudyDocumentList();
	}

	private String[][] convertStudyDocumentList()
	{
		ArrayList<String> dirList = studyDocumentDAO.getDirectoryList();

		ArrayList<StudyDocumentInfo> list = new ArrayList<StudyDocumentInfo>();

		for(int i=0; i<dirList.size(); i++)
		{
			LinkedList<StudyDocumentInfo> link = studyDocumentDAO.getInstanceMethod().searchStudyDocumentInfo(dirList.get(i));


//////////////////// 0524´ë¼· ½´Á´//////////////////// 0524´ë¼· ½´Á´
			if (link == null)
			{
				continue;
			}
			else
			{
				System.out.println(link);
				for(int j=0; j<link.size(); j++)
				{
					list.add(link.get(j));
				}
			}
//////////////////// 0524´ë¼· ½´Á´//////////////////// 0524´ë¼· ½´Á´
		}

		String[][] data = new String[list.size()][2];
		for(int i=0; i<list.size(); i++)
		{
			data[i][0] = list.get(i).getDocumentName()+".java";  data[i][1] = list.get(i).getDocumentDirectory();
		}

		return data;
	}
}