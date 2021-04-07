package Model;
import java.io.*;
public class ScheduleKind implements Serializable
{
   //static final long serialVersionUID = 10000;
   static final long serialVersionUID = 7339242259695047069l;
   
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
   public ScheduleKind(int kind){
      decideKind(kind);
   }
   public ScheduleKind(int kind,String kindName){
      this.kindName = kindName;
      this.kind = kind;
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
      else if(str.equals("실습")){kind = 2;kindName = "실습";}
      else if(str.equals("휴식")){kind = 3;kindName = "휴식";}
      else if(str.equals("운동")){kind = 4;kindName = "운동";}
      
      else if(str.equals("정보 수집 단계")){kind = 5; kindName = "정보 수집 단계";}
      else if(str.equals("유즈케이스 분석단계")){ kind = 6; kindName ="유즈케이스 분석단계"; }
      else if(str.equals("클래스 분석단계")){kind = 7; kindName = "클래스 분석단계";}
      else if(str.equals("클래스 설계단계")){kind = 8; kindName = "클래스 설계단계";}
      else if(str.equals("클래스 상세 설계단계")){ kind=9; kindName = "클래스 상세 설계단계"; }
      else if(str.equals("소스코딩 및 디버깅 단계")) {kind =10; kindName = "소스코딩 및 디버깅 단계";}
      else if(str.equals("문서작업 및 발표준비단계")){kind = 11; kindName = "문서작업 및 발표준비단계";}
      else if(str.equals("최종 완료 단계")){ kind=12; kindName = "최종 완료 단계"; } 

      else if(str.equals("휴가")){ kind = 13; kindName = "휴가"; }
      
      else if(str.equals("생일")) {kind = 14; kindName = "생일";}
      else if(str.equals("결혼 기념일")) {kind = 15; kindName = "결혼 기념일";}
   }
   public void decideKind(int kind){
      if(kind == 1){this.kind = 1;kindName = "이론";}
      else if(kind == 2){this.kind = 2;kindName = "실습";}
      else if(kind == 3){this.kind = 3;kindName = "휴식";
            System.out.println("너너너너너너여기들어가니??!!!!");
      System.out.println(kind);
      System.out.println(kindName);
      }
      else if(kind == 4){this.kind = 4;kindName = "운동";}
      
      else if(kind == 5){this.kind = 5; kindName = "정보 수집 단계";}
      else if(kind == 6){ this.kind = 6; kindName ="유즈케이스 분석단계"; }
      else if(kind == 7){this.kind = 7; kindName = "클래스 분석단계";}
      else if(kind == 8){this.kind = 8; kindName = "클래스 설계단계";}
      else if(kind == 9){ this.kind=9; kindName = "클래스 상세 설계단계"; }
      else if(kind == 10) {this.kind =10; kindName = "소스코딩 및 디버깅 단계";}
      else if(kind == 11){this.kind = 11; kindName = "문서작업 및 발표준비단계";}
      else if(kind == 12){ this.kind=12; kindName = "최종 완료 단계"; } 

      else if(kind == 13){ this.kind = 13; kindName = "휴가"; }
      
      else if(kind == 14) {this.kind = 14; kindName = "생일";}
      else if(kind == 15) {this.kind = 15; kindName = "결혼 기념일";}
   }
   

}