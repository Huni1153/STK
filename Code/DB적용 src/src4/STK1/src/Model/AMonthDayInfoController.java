package Model;
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
	public void getOnlyAMonthInfo(String searchYear ,String searchMonth){
		aMonthInfo = displayInfoController.getOnlyAMonthInfo(searchYear,searchMonth);
	}

	public void divideDayPerSchedule(){

		int days = aMonthInfo.length;
		System.out.println("Cnt is "+days);
		for(int cnt=0; cnt<days; cnt++){
		
			LinkedList<String[]> list = hashMap.get(aMonthInfo[cnt][5]);
			if(list == null){
				LinkedList<String[]> addList = new LinkedList<String[]>();
				hashMap.put(aMonthInfo[cnt][5], addList);
			}
			else{}
		}

		for(int day=0; day < days; day++){
			String []str = new String[10];
			
			str[0] = aMonthInfo[day][0]; // 일정 코드
			str[1] = aMonthInfo[day][1]; // 일정 종류
			str[2] = aMonthInfo[day][2]; // 일정 이름
			str[3] = aMonthInfo[day][5]; // 시작 일
			str[4] = aMonthInfo[day][6]; // 시작 시간
			str[5] = aMonthInfo[day][7]; // 시작 분
			str[6] = aMonthInfo[day][10]; // 끝 일
			str[7] = aMonthInfo[day][11]; // 끝 시간
			str[8] = aMonthInfo[day][12]; // 끝 분
			
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
			
			}
		}
		
		
	}

	public LinkedList<String[]> onlyADayInfo(String day){
		return hashMap.get(day);
	}
}
