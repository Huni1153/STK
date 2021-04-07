import java.util.*;
public class AMonthDayInfoController
{
	private DisplayInfoController displayInfoController;
	private String searchMonth;
	private String searchDay;
	private HashMap< String, LinkedList<String[]> > hashMap;
	private String [][]aMonthInfo;

	public AMonthDayInfoController(DisplayInfoController displayInfoController){
		this.searchMonth = "5";
		
		this.hashMap = new HashMap< String,LinkedList<String[]> >();
		this.displayInfoController = displayInfoController;
	}
	public AMonthDayInfoController(String searchMonth){
		this.searchMonth = searchMonth;
		this.searchDay = "0";
	}
	/*
	public void getOnlyAMonthInfo(String searchMonth){
		aMonthInfo = displayInfoController.getOnlyAMonthInfo(searchMonth);
	}
	*/
	public void getOnlyAMonthInfo(String searchYear ,String searchMonth){
		aMonthInfo = displayInfoController.getOnlyAMonthInfo(searchYear,searchMonth);
		//if(aMonthInfo == null)
		//	return false;
		//return true;
	}

	public void divideDayPerSchedule(){
		//hashMap.put("13",String[][]);

		int days = aMonthInfo.length;
		System.out.println("Cnt is "+days);
		for(int cnt=0; cnt<days; cnt++){
		
			LinkedList<String[]> list = hashMap.get(aMonthInfo[cnt][5]);
			//System.out.println("How Much");
			if(list == null){
				LinkedList<String[]> addList = new LinkedList<String[]>();
				hashMap.put(aMonthInfo[cnt][5], addList);
			}
			else{}
		}

		for(int day=0; day < days; day++){
			//hashMap.put(aMonthInfo[row][4],aMonthInfo[day][])
			String []str = new String[10];
			
			str[0] = aMonthInfo[day][0]; // ���� �ڵ�
			str[1] = aMonthInfo[day][1]; // ���� ����
			str[2] = aMonthInfo[day][2]; // ���� �̸�
			str[3] = aMonthInfo[day][5]; // ���� ��
			str[4] = aMonthInfo[day][6]; // ���� �ð�
			str[5] = aMonthInfo[day][7]; // ���� ��
			str[6] = aMonthInfo[day][10]; // �� ��
			str[7] = aMonthInfo[day][11]; // �� �ð�
			str[8] = aMonthInfo[day][12]; // �� ��
			
			int total = ( Integer.parseInt(str[4]) * 60 ) + Integer.parseInt(str[5]);
			if( total >= (6*60) && total < (12 * 60)) str[9] = "1";
			else if( total>= (12*60) && total < (18 * 60)) str[9] = "2";
			else if( total>= (18*60) && total < (24 * 60)) str[9] = "3";
			else if( total>= 0 && total < (6 * 60)) str[9] = "4";

			LinkedList<String[]> list = hashMap.get(aMonthInfo[day][5]);
			list.add(str);

		}
		
		System.out.println("Here Start!!");
		
		System.out.println(hashMap.size());
		
		for(int cnt=0; cnt<hashMap.size(); cnt++){
			LinkedList<String[]> lt = hashMap.get("10");
			for(int i=0; i<lt.size(); i++){
				String str[] = lt.get(i);
			
			/*
				System.out.println(str[0]);
				System.out.println(str[1]);
				System.out.println(str[2]);
				System.out.println(str[3]);
				System.out.println(str[4]);
				System.out.println(str[5]);
				System.out.println(str[6]);
				System.out.println(str[7]);
				System.out.println(str[8]);
				*/
			}
		}
		
		
	}

	public LinkedList<String[]> onlyADayInfo(String day){
		return hashMap.get(day);
	}
}
