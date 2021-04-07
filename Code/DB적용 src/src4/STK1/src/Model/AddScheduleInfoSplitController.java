package Model;
import java.util.*;
public class AddScheduleInfoSplitController 
{
	private AddScheduleInfoController addController;

	public AddScheduleInfoSplitController(){
		this.addController = new AddScheduleInfoController();
	}

	public void splitAndTransfer(String kind, String title, Date startDay, Date endDay, String place, String memo, Date alarm, String image){
		int days=0;

		System.out.println("Split ����!!");
		int end = endDay.getDate();
		int start = startDay.getDate();	

		days = end - start + 1;

		System.out.println("How Much Days??  "+ days);

		if(days == 1){
			//File�� �߰��ϴ� Method ȣ��
			//addController.addScheduleInfo(kind, title, startDay, endDay, place, memo, alarm, image);
			//DB�� �߰��ϴ� Method ȣ��
			addController.addScheduleInfoToDB(kind, title, startDay, endDay, place, alarm, image, memo);
		}
		else if(days == 2){
			//File�� �߰��ϴ� Method ȣ��
			//addController.addScheduleInfo(kind, title, startDay, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate(), 23,59), place, memo, alarm, image);
			//addController.addScheduleInfo(kind, title, new Date(endDay.getYear(), endDay.getMonth(), endDay.getDate(), 0, 1), endDay, place, memo, alarm, image);
			//DB�� �߰��ϴ� Method ȣ��
			addController.addScheduleInfoToDB(kind, title, startDay, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate(), 23,59), place, alarm, image, memo);
			addController.addScheduleInfoToDB(kind, title, new Date(endDay.getYear(), endDay.getMonth(), endDay.getDate(), 0, 1), endDay, place, alarm, image, memo);
		}
		else if(days >= 3){
			for(int cnt=0; cnt < days; cnt++){
				if(cnt==0){
					//File�� �߰��ϴ� Method
					//addController.addScheduleInfo(kind, title, startDay, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate(), 23,59), place, memo, alarm, image);
					//DB�� �߰��ϴ� Method
					addController.addScheduleInfoToDB(kind, title, startDay, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate(), 23,59), place, alarm, image, memo);

				}
				else if(cnt == days-1){
					//File�� �߰��ϴ� Method
					//addController.addScheduleInfo(kind, title, new Date(endDay.getYear(), endDay.getMonth(), endDay.getDate(), 0, 1), endDay, place, memo, alarm, image);
					//DB�� �߰��ϴ� Method
					addController.addScheduleInfoToDB(kind, title, new Date(endDay.getYear(), endDay.getMonth(), endDay.getDate(), 0, 1), endDay, place, alarm, image, memo);

				}
				else{
					//File�� �߰��ϴ� Method
					//addController.addScheduleInfo(kind, title, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate()+cnt, 0,1), new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate()+cnt,23,59), place, memo, alarm, image);
					//DB�� �߰��ϴ� Method
					addController.addScheduleInfoToDB(kind, title, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate()+cnt, 0,1), new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate()+cnt,23,59), place, alarm, image, memo);
				}
			}
		}

		System.out.println("Split ���Դ�!!!");


	}

}
