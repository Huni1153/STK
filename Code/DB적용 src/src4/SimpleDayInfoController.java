import java.util.*;
public class SimpleDayInfoController
{
	private AMonthDayInfoController aMonthDayInfoController;
	private DisplayInfoController displayInfoController;
	
	//수정
	private final ScheduleDBDAO scheduleDBDAO;
	
	private LinkedList<String[]> list;

	private String year;
	private String month;
	private String day;

	private String[][] returnSchedule;
	private LinkedList<SimpleDayInfo> simpleList;

	private boolean isDay;

	public LinkedList<SimpleDayInfo> getSimpleList(){
		return this.simpleList;
	}
	public boolean getIsDay(){
		return this.isDay;
	}

	public SimpleDayInfoController(String year, String month, String day, DisplayInfoController displayInfoController){
		scheduleDBDAO = ScheduleDBDAO.getInstance();

		
		this.year = year;
		this.month = month;
		this.day = day;
		this.displayInfoController = displayInfoController;
		this.returnSchedule = null;
		this.isDay = false;
		aMonthDayInfoController = new AMonthDayInfoController(displayInfoController);

		aMonthDayInfoController.getOnlyAMonthInfo(year,month);
		aMonthDayInfoController.divideDayPerSchedule();

		//if(check == true)
		list = aMonthDayInfoController.onlyADayInfo(day);
		if(list == null)
			this.isDay = false;
		else
			this.isDay = true;
		//else dd 여기까지


        simpleList = new LinkedList<SimpleDayInfo>();
		/*
		System.out.println("My Test!!!!!!");
		System.out.println(list.get(0)[0]);
		System.out.println(list.get(0)[1]);
		System.out.println(list.get(0)[2]);
		System.out.println(list.get(0)[3]);
		System.out.println(list.get(0)[4]);
		System.out.println(list.get(0)[5]);
		System.out.println(list.get(0)[6]);
		System.out.println(list.get(0)[7]);
		System.out.println(list.get(0)[8]);
		System.out.println(list.get(0)[9]);
		*/
		searchADaySimpleSchedule(year,month,day);
	}
	
	public void divideSchedule(){
		//LinkedList<SimpleDayInfo> simpleDayInfo = new LinkedList<SimpleDayInfo>();

		for(int cnt=0; cnt<list.size(); cnt++){

			//System.out.println("Here My check"+list.size());
			String []info = list.get(cnt);
			splitModule(Integer.parseInt(info[4]),Integer.parseInt(info[5]),Integer.parseInt(info[7]),Integer.parseInt(info[8]),info[0],info[1],info[2], info[9]);
		}

		//여기서 호출
		//searchADaySimpleSchedule(year,month,day);
	}

	public void searchADaySimpleSchedule(String year, String month, String day){
		DayScheduleInfo []infoList = scheduleDBDAO.searchADayScheduleInfo(new Date(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day)));

		if(infoList.length==0){
			System.out.println("## DB에는 Data가 없습니다");
		}
		
		//Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day)
		System.out.println();
		System.out.println();
		System.out.println("############################");
		System.out.println("year month day Parse 확인!!");
		System.out.println("Year is : "+Integer.parseInt(year));
		System.out.println("Month is : "+ (Integer.parseInt(month)-1) );
		System.out.println("Day is : "+Integer.parseInt(day));


		for(int cnt=0; cnt<infoList.length; cnt++){
			String scheduleCode = infoList[cnt].getScheduleCode();
			String scheduleKind = infoList[cnt].getScheduleKind().getKindName();
			String scheduleName = infoList[cnt].getScheduleName();
			int startHour = infoList[cnt].getStartDay().getHours();
			int startMinutes = infoList[cnt].getStartDay().getMinutes();
			int endHour = infoList[cnt].getEndDay().getHours();
			int endMinutes = infoList[cnt].getEndDay().getMinutes();

			simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, endHour, endMinutes));
		}
	}


	
	public void splitModule(int startHour, int startMinutes, int endHour, int endMinutes, String scheduleCode, String scheduleKind, String scheduleName, String aroundTime){
		//LinkedList<SimpleDayInfo> simpleList = new LinkedList<SimpleDayInfo>();
		if(aroundTime.equals("1")){
			int cnt=0;
			if( (((endHour * 60) + endMinutes) - (12*60)) > 0) cnt++;
			if( (((endHour * 60) + endMinutes) - (18*60)) > 0) cnt++;
			if( (((endHour * 60) + endMinutes) - (24*60)) > 0) cnt++;

			if(cnt == 0){ 
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, endHour, endMinutes));
			}
			else if(cnt == 1){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, 12, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 12, 0, endHour, endMinutes));
			}
			else if(cnt == 2){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, 12, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 12, 0, 18, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 18, 0, endHour, endMinutes));
			}
			
		}
		else if(aroundTime.equals("4")){
			int cnt=0;

			if( (((endHour * 60) + endMinutes) - (6*60)) > 0)cnt++;
			if( (((endHour * 60) + endMinutes) - (12*60)) > 0) cnt++;
			if( (((endHour * 60) + endMinutes) - (18*60)) > 0) cnt++;
			if( (((endHour * 60) + endMinutes) - (24*60)) > 0) cnt++;

			if(cnt == 0){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, endHour, endMinutes));
			}
			else if(cnt == 1){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, 6, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 6, 0, endHour, endMinutes));
			}
			else if(cnt == 2){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, 6, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 6, 0, 12, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 12, 0, endHour, endMinutes));
			}
			else if(cnt == 3){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, 6, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 6, 0, 12, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 12, 0, 18, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 18, 0, endHour, endMinutes));
			}
			
		}

		else if(aroundTime.equals("2")){
			int cnt=0;
			if( (((endHour * 60) + endMinutes) - (18*60)) > 0) cnt++;
			if( (((endHour * 60) + endMinutes) - (24*60)) > 0) cnt++;

			if(cnt == 0){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, endHour, endMinutes));
			}
			else if(cnt == 1){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, 18, 0));
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, 18, 0, endHour, endMinutes));
			}
		}
		else if(aroundTime.equals("3")){
			int cnt=0;
			if( (((endHour * 60) + endMinutes) - (24*60)) > 0) cnt++;

			if(cnt == 0){
				simpleList.add(new SimpleDayInfo(scheduleCode, scheduleKind, scheduleName, startHour, startMinutes, endHour, endMinutes));
			}

		}
		

	}
	public String[][] returnDisplaySchedule(){
		return null;		
	}
	
}

