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
      if(kind == 1){kind = 1;kindName = "�̷�";}
      else if(kind == 2){kind = 2;kindName = "�ǽ�";}
      else if(kind == 3){kind = 3;kindName = "�޽�";}
      else if(kind == 4){kind = 4;kindName = "�";}
      
      else if(kind == 5){kind = 5; kindName = "���� ���� �ܰ�";}
      else if(kind == 6){ kind = 6; kindName ="�������̽� �м��ܰ�"; }
      else if(kind == 7){kind = 7; kindName = "Ŭ���� �м��ܰ�";}
      else if(kind == 8){kind = 8; kindName = "Ŭ���� ����ܰ�";}
      else if(kind == 9){ kind=9; kindName = "Ŭ���� �� ����ܰ�"; }
      else if(kind == 10) {kind =10; kindName = "�ҽ��ڵ� �� ����� �ܰ�";}
      else if(kind == 11){kind = 11; kindName = "�����۾� �� ��ǥ�غ�ܰ�";}
      else if(kind == 12){ kind=12; kindName = "���� �Ϸ� �ܰ�"; } 

      else if(kind == 13){ kind = 13; kindName = "�ް�"; }
      
      else if(kind == 14) {kind = 14; kindName = "����";}
      else if(kind == 15) {kind = 15; kindName = "��ȥ �����";}
   }
   

}