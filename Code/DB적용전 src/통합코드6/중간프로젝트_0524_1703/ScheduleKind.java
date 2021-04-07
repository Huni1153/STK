import java.io.*;
public class ScheduleKind implements Serializable
{
	//private NormalSchedule normalSchedule;
	//private DesignScheduleCategory designScheduleCategory;
	//private AnniversarySchedule anniversarySchedule;
	//private VacationSchedule vacationSchedule;
	private String kindName;
	private int kind;
	
	public ScheduleKind(){
		this.kindName = "기타";
		this.kind = 0;
	}
	public ScheduleKind(String kind){
		decideKind(kind);
	}

	public void setKind(int kind){
		this.kind = kind;
	}
	public void setKindName(String kindName){
		this.kindName = kindName;
	}
	public int getKind(){
		return this.kind;
	}
	public String getKindName(){
		return this.kindName;
	}
	public String toString(){
		return "종류 : "+this.kind + "\n일정종류 : "+this.kindName;
	}


	public void decideKind(String str){
		if(str.equals("이론")){kind = 1;kindName = "이론";}
		else if(str.equals("실습")){kind = 1;kindName = "실습";}
		else if(str.equals("휴식")){kind = 1;kindName = "휴식";}
		else if(str.equals("운동")){kind = 1;kindName = "운동";}
		
		else if(str.equals("정보 수집 단계")){kind = 2; kindName = "정보 수집 단계";}
		else if(str.equals("유즈케이스 분석단계")){ kind = 2; kindName ="유즈케이스 분석단계"; }
		else if(str.equals("클래스 분석단계")){kind = 2; kindName = "클래스 분석단계";}
		else if(str.equals("클래스 설계단계")){kind = 2; kindName = "클래스 설계단계";}
		else if(str.equals("클래스 상세 설계단계")){ kind=2; kindName = "클래스 상세 설계단계"; }
		else if(str.equals("소스코딩 및 디버깅 단계")) {kind =2; kindName = "소스코딩 및 디버깅 단계";}
		else if(str.equals("문서작업 및 발표준비단계")){kind = 2; kindName = "문서작업 및 발표준비단계";}
		else if(str.equals("최종 완료 단계")){ kind=2; kindName = "최종 완료 단계"; } 

		else if(str.equals("휴가")){ kind = 3; kindName = "휴가"; }
		
		else if(str.equals("생일")) {kind = 4; kindName = "생일";}
		else if(str.equals("결혼 기념일")) {kind = 4; kindName = "결혼 기념일";}
	}
	

}