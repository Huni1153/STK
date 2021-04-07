package Model;
import java.util.*;
import java.text.*;
public class ScheduleDBDAO
{
	private LinkedList<DayScheduleInfo> scheduleDBDAO;
	private ScheduleInfoDBDAO scheduleInfoDBDAO;
	private static ScheduleDBDAO obj = new ScheduleDBDAO();
	private int intCode;

	public static ScheduleDBDAO getInstance(){
		return obj;
	}

	private ScheduleDBDAO(){
		this.scheduleDBDAO = new LinkedList<DayScheduleInfo>();
		this.scheduleInfoDBDAO = new ScheduleInfoDBDAO();
		getCodeString();
	}
	
	public ScheduleDBDAO(LinkedList<DayScheduleInfo> scheduleDBDAO, ScheduleInfoDBDAO scheduleInfoDBDAO){
		this.scheduleDBDAO = scheduleDBDAO;
		this.scheduleInfoDBDAO = scheduleInfoDBDAO;
		getCodeString();
	}
	public void setScheduleDBDAO(LinkedList<DayScheduleInfo> scheduleDBDAO){
		this.scheduleDBDAO = scheduleDBDAO;
	}
	public void setScheduleInfoDBDAO(ScheduleInfoDBDAO scheduleInfoDBDAO){
		this.scheduleInfoDBDAO = scheduleInfoDBDAO;
	}
	public LinkedList<DayScheduleInfo> getScheduleDBDAO(){
		return this.scheduleDBDAO;
	}
	public ScheduleInfoDBDAO getScheduleInfoDBDAO(){
		return this.scheduleInfoDBDAO;
	}
	public int insertDayScheduleInfo(String scheduleKindCode, String scheduleName, Date startDate, Date endDate, String place, Date alarm, String image, String note){
		String code = makeCode();
		System.out.println("code");
		System.out.println(code);
		/*
		System.out.println("두번째 여기여기여기!!!!!!!!!!!!!!!");
		System.out.println(scheduleKindCode);
		*/
		/*
		System.out.println("StartDate 확인하기!!!!!!!!!!!!!!11");
		System.out.println(startDate);
		System.out.println("endDate 확인하기!!!!!!!!!!!!!!11");
		System.out.println(endDate);
		*/
		scheduleDBDAO.add(new DayScheduleInfo(code, scheduleKindCode, scheduleName, startDate, endDate, place, note, alarm, image));
		if(scheduleDBDAO.size() == 1){
			saveSchedule();
			deleteSchedule();
		}


	return 0;
	}
	public int deleteDayScheduleInfo(String scheduleCode){
		for(int cnt=0; cnt<scheduleDBDAO.size(); cnt++){
			if(scheduleDBDAO.get(cnt).getScheduleCode().equals(scheduleCode)){
				scheduleDBDAO.remove(cnt);
				return 2;
			}
		}
		return scheduleInfoDBDAO.delete(scheduleCode);
	}
	public int updateDayScheduleInfo(String scheduleCode, String scheduleKindCode, String scheduleName, Date startDate, Date endDate, String place, Date alarm, String image, String note){
		for(int cnt=0; cnt<scheduleDBDAO.size(); cnt++){
			if(scheduleDBDAO.get(cnt).getScheduleCode().equals(scheduleCode)){
				scheduleDBDAO.get(cnt).modifyScheduleInfo(scheduleKindCode, scheduleName, startDate, endDate, place, note, alarm, image);
				return 2;
			}
		}

		return scheduleInfoDBDAO.update(scheduleCode, scheduleKindCode, scheduleName, startDate, endDate, place, alarm, image, note);

	}
	public Iterator<DayScheduleInfo> ProvideAll(){
		return null;
	}
	public DayScheduleInfo[] searchDayInfo(String scheduleName, Date startDate, Date endDate){
		DayScheduleInfo []info = scheduleInfoDBDAO.selectDate();

		DayScheduleInfo []returnInfo = null;
		ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();

		for(int cnt=0; cnt<info.length; cnt++){
			if(info[cnt].getStartDay().getDate() >= startDate.getDate() && info[cnt].getEndDay().getDate() <= endDate.getDate()){
				if(info[cnt].getScheduleName().equals(scheduleName)){
					list.add(info[cnt]);
				}
			}
		}

		returnInfo = new DayScheduleInfo[list.size()];
		for(int cnt=0; cnt<list.size(); cnt++){
			returnInfo[cnt] = list.get(cnt);
		}

		return returnInfo;
		/*
		DayScheduleInfo []info = scheduleInfoDBDAO.selectName(scheduleName, startDate, endDate);

		//ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();
		return info;
		*/
	}

	public DayScheduleInfo[] searchADayScheduleInfo(Date startDate){
		DayScheduleInfo []info = scheduleInfoDBDAO.selectDate(/*startDate,startDate2*/);
		
		DayScheduleInfo []returnInfo = null;
		ArrayList<DayScheduleInfo> list = new ArrayList<DayScheduleInfo>();

		for(int cnt=0; cnt<info.length; cnt++){
			int year = info[cnt].getStartDay().getYear();
			int month = info[cnt].getStartDay().getMonth();
			int date = info[cnt].getStartDay().getDate();

			/*
			System.out.println();System.out.println();System.out.println();
			System.out.println(year);
			System.out.println(month);
			System.out.println(date);
			*/
			if(year == startDate.getYear() && month == startDate.getMonth() && date == startDate.getDate()){
				list.add(info[cnt]);
			}
		}
		
		returnInfo = new DayScheduleInfo[list.size()];
		for(int cnt=0; cnt<returnInfo.length; cnt++){
			returnInfo[cnt] = list.get(cnt);
		}

		return returnInfo;
	}

	/*
	public Iterator<SimpleSchedule> searchDayScheduleInfo(String scheduleName ,Date startDate, Date endDate){
		return null;
	}
	*/



	public int deleteSchedule(){
		for(int cnt=scheduleDBDAO.size()-1; cnt>=0; cnt--){
			scheduleDBDAO.remove(cnt);
		}
		return 1;
	}

	public int saveSchedule(){
		for(int cnt=0; cnt<scheduleDBDAO.size(); cnt++){
			DayScheduleInfo info = scheduleDBDAO.get(cnt);
			Integer integ = new Integer(info.getScheduleKind().getKind());
			/*
			System.out.println("세번째 여기여기여기!!!!!!!!!!!!!!!11");
			System.out.println(info.getScheduleKind().getKind());
			System.out.println(integ.toString());
			System.out.println("세번째 여기여기여기!!!!!!!!!!!!!!!11");
			System.out.println(info.getScheduleKind().getKindName());
			System.out.println(integ.toString());
			*/
			/*
			System.out.println(info.getStartDay());
			System.out.println(info.getEndDay());
			*/
			scheduleInfoDBDAO.insert(info.getScheduleCode(), integ.toString(), info.getScheduleName(), info.getStartDay(), info.getEndDay(), info.getPlace(), info.getAlarm(), info.getImage(), info.getNote());
		}
		return 1;
	}

	public String makeCode(){
		Date d = new Date();
		StringTokenizer st = new StringTokenizer(new SimpleDateFormat().format(d),". ");

		String year = st.nextToken();
		String month = st.nextToken();
		String day = st.nextToken();

		System.out.println(year + month + day);
		intCode++;
		Integer code = new Integer(intCode);

		return year + month + day + code.toString();

	}

	public void getCodeString(){
		this.intCode = Integer.parseInt(scheduleInfoDBDAO.latestCodeNum());
		System.out.println("Here");
		System.out.println(this.intCode);
	}

	public static void main(String []args){
		ScheduleDBDAO dao = new ScheduleDBDAO();
		
		System.out.println("Here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
		/*
		DayScheduleInfo []info = dao.searchADayScheduleInfo(new Date(2015,4,29));
		//System.out.println(info);
		for(int cnt=0; cnt<info.length; cnt++){
			System.out.println(info[cnt]);
		}
		*/
		DayScheduleInfo []search = dao.searchDayInfo("테스트수정22",new Date(2015,5,1), new Date(2015,5,2));
		for(int cnt=0; cnt<search.length; cnt++){
			System.out.println(search[cnt]);
		}

		/*
		String code = "155192001";
		char []chCode = code.toCharArray();

		String codeString = String.valueOf(chCode, chCode.length-4, 4);
		System.out.println(codeString);
		*/
	}
}