package Model;
import java.util.*;

public class AddScheduleInfoController
{
	private final DayScheduleInfoDAO dayScheduleInfoDAO;
	//수정
	private final ScheduleDBDAO scheduleDBDAO;


	public AddScheduleInfoController()
	{
		this.dayScheduleInfoDAO=DayScheduleInfoDAO.getInstance();
		this.scheduleDBDAO = ScheduleDBDAO.getInstance();
	}
	public AddScheduleInfoController(DayScheduleInfoDAO dayScheduleInfoDAO, ScheduleDBDAO scheduleDBDAO)
	{
		this.dayScheduleInfoDAO=dayScheduleInfoDAO;
		this.scheduleDBDAO = scheduleDBDAO;
	}
	public boolean addCheck(String scheduleCode,String scheduleName)
	{
		return true;
	}
	public boolean addScheduleInfo(String scheduleCode,String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		this.dayScheduleInfoDAO.addDayScheduleInfo(scheduleCode,scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image);
		return true;
	}

	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ실제 사용ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
	public boolean addScheduleInfo(String scheduleKind,String scheduleName,Date startDay,Date endDay,String place,String note,Date alarm, String image)
	{
		System.out.println("실제로 DAO로 추가 시키는 부분!!");
		// convert를 수행하는 Method를 첫 parameter에서 썼는데 File쪽이므로 안써도 될듯
		//this.dayScheduleInfoDAO.addDayScheduleInfo(convertKindToCode(scheduleKind),scheduleName,startDay,endDay,place,note,alarm,image);
		this.dayScheduleInfoDAO.addDayScheduleInfo(convertKindToCode(scheduleKind),scheduleName,startDay,endDay,place,note,alarm,image);
		//수정
		return true;
	}
	// DB쪽 추가하기
	public int addScheduleInfoToDB(String scheduleKind, String scheduleName, Date startDate, Date endDate, String place, Date alarm, String image, String note){
		System.out.println("실제 DB로 추가하는 Method!!");
		
		System.out.println("여기여기여기!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(convertKindToCode(scheduleKind));
		/*
		System.out.println("StartDate 확인하기!!!!!!!!!!!!!!11");
		System.out.println(startDate);
		System.out.println("endDate 확인하기!!!!!!!!!!!!!!11");
		System.out.println(endDate);
		*/
		return this.scheduleDBDAO.insertDayScheduleInfo(convertKindToCode(scheduleKind), scheduleName, startDate, endDate, place, alarm, image, note);

	}


	//수정
	public String convertKindToCode(String scheduleKind){
		String code = null;

		if(scheduleKind.equals("이론")) code = "1";
		else if(scheduleKind.equals("실습")) code = "2";
		else if(scheduleKind.equals("휴식")) code = "3";
		else if(scheduleKind.equals("운동")) code = "4";
		else if(scheduleKind.equals("정보 수집 단계")) code = "5";
		else if(scheduleKind.equals("유즈케이스 분석단계")) code = "6";
		else if(scheduleKind.equals("클래스 분석단계")) code = "7";
		else if(scheduleKind.equals("클래스 설계단계")) code = "8";
		else if(scheduleKind.equals("클래스 상세 설계단계")) code = "9";
		else if(scheduleKind.equals("소스코딩 및 디버깅 단계")) code = "10";
		else if(scheduleKind.equals("문서작업 및 발표준비단계")) code = "11";
		else if(scheduleKind.equals("최종 완료 단계")) code = "12";
		else if(scheduleKind.equals("휴가")) code = "13";
		else if(scheduleKind.equals("생일")) code = "14";
		else if(scheduleKind.equals("결혼 기념일")) code = "15";

		return code;
		
	
	}
}
