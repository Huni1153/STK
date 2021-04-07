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
      this.kindName = "��Ÿ";
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
      return "���� : "+this.kind + "\n�������� : "+this.kindName;
   }


   public void decideKind(String str){
      if(str.equals("�̷�")){kind = 1;kindName = "�̷�";}
      else if(str.equals("�ǽ�")){kind = 2;kindName = "�ǽ�";}
      else if(str.equals("�޽�")){kind = 3;kindName = "�޽�";}
      else if(str.equals("�")){kind = 4;kindName = "�";}
      
      else if(str.equals("���� ���� �ܰ�")){kind = 5; kindName = "���� ���� �ܰ�";}
      else if(str.equals("�������̽� �м��ܰ�")){ kind = 6; kindName ="�������̽� �м��ܰ�"; }
      else if(str.equals("Ŭ���� �м��ܰ�")){kind = 7; kindName = "Ŭ���� �м��ܰ�";}
      else if(str.equals("Ŭ���� ����ܰ�")){kind = 8; kindName = "Ŭ���� ����ܰ�";}
      else if(str.equals("Ŭ���� �� ����ܰ�")){ kind=9; kindName = "Ŭ���� �� ����ܰ�"; }
      else if(str.equals("�ҽ��ڵ� �� ����� �ܰ�")) {kind =10; kindName = "�ҽ��ڵ� �� ����� �ܰ�";}
      else if(str.equals("�����۾� �� ��ǥ�غ�ܰ�")){kind = 11; kindName = "�����۾� �� ��ǥ�غ�ܰ�";}
      else if(str.equals("���� �Ϸ� �ܰ�")){ kind=12; kindName = "���� �Ϸ� �ܰ�"; } 

      else if(str.equals("�ް�")){ kind = 13; kindName = "�ް�"; }
      
      else if(str.equals("����")) {kind = 14; kindName = "����";}
      else if(str.equals("��ȥ �����")) {kind = 15; kindName = "��ȥ �����";}
   }
   public void decideKind(int kind){
      if(kind == 1){this.kind = 1;kindName = "�̷�";}
      else if(kind == 2){this.kind = 2;kindName = "�ǽ�";}
      else if(kind == 3){this.kind = 3;kindName = "�޽�";
            System.out.println("�ʳʳʳʳʳʿ������??!!!!");
      System.out.println(kind);
      System.out.println(kindName);
      }
      else if(kind == 4){this.kind = 4;kindName = "�";}
      
      else if(kind == 5){this.kind = 5; kindName = "���� ���� �ܰ�";}
      else if(kind == 6){ this.kind = 6; kindName ="�������̽� �м��ܰ�"; }
      else if(kind == 7){this.kind = 7; kindName = "Ŭ���� �м��ܰ�";}
      else if(kind == 8){this.kind = 8; kindName = "Ŭ���� ����ܰ�";}
      else if(kind == 9){ this.kind=9; kindName = "Ŭ���� �� ����ܰ�"; }
      else if(kind == 10) {this.kind =10; kindName = "�ҽ��ڵ� �� ����� �ܰ�";}
      else if(kind == 11){this.kind = 11; kindName = "�����۾� �� ��ǥ�غ�ܰ�";}
      else if(kind == 12){ this.kind=12; kindName = "���� �Ϸ� �ܰ�"; } 

      else if(kind == 13){ this.kind = 13; kindName = "�ް�"; }
      
      else if(kind == 14) {this.kind = 14; kindName = "����";}
      else if(kind == 15) {this.kind = 15; kindName = "��ȥ �����";}
   }
   

}