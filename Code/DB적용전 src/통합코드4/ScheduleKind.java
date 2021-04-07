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
		else if(str.equals("�ǽ�")){kind = 1;kindName = "�ǽ�";}
		else if(str.equals("�޽�")){kind = 1;kindName = "�޽�";}
		else if(str.equals("�")){kind = 1;kindName = "�";}
		
		else if(str.equals("���� ���� �ܰ�")){kind = 2; kindName = "���� ���� �ܰ�";}
		else if(str.equals("�������̽� �м��ܰ�")){ kind = 2; kindName ="�������̽� �м��ܰ�"; }
		else if(str.equals("Ŭ���� �м��ܰ�")){kind = 2; kindName = "Ŭ���� �м��ܰ�";}
		else if(str.equals("Ŭ���� ����ܰ�")){kind = 2; kindName = "Ŭ���� ����ܰ�";}
		else if(str.equals("Ŭ���� �� ����ܰ�")){ kind=2; kindName = "Ŭ���� �� ����ܰ�"; }
		else if(str.equals("�ҽ��ڵ� �� ����� �ܰ�")) {kind =2; kindName = "�ҽ��ڵ� �� ����� �ܰ�";}
		else if(str.equals("�����۾� �� ��ǥ�غ�ܰ�")){kind = 2; kindName = "�����۾� �� ��ǥ�غ�ܰ�";}
		else if(str.equals("���� �Ϸ� �ܰ�")){ kind=2; kindName = "���� �Ϸ� �ܰ�"; } 

		else if(str.equals("�ް�")){ kind = 3; kindName = "�ް�"; }
		
		else if(str.equals("����")) {kind = 4; kindName = "����";}
		else if(str.equals("��ȥ �����")) {kind = 4; kindName = "��ȥ �����";}
	}
	

}