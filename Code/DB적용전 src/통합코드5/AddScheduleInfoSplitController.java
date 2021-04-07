import java.util.*;
public class AddScheduleInfoSplitController 
{
	private AddScheduleInfoController addController;

	public AddScheduleInfoSplitController(){
		this.addController = new AddScheduleInfoController();
	}

	public void splitAndTransfer(String kind, String title, Date startDay, Date endDay, String place, String memo, Date alarm, String image){
		int days=0;

		System.out.println("Split 들어갔다!!");
		int end = endDay.getDate();
		int start = startDay.getDate();	

		days = end - start + 1;

		System.out.println("How Much Days??  "+ days);

		if(days == 1){
			addController.addScheduleInfo(kind, title, startDay, endDay, place, memo, alarm, image);
		}
		else if(days == 2){
			addController.addScheduleInfo(kind, title, startDay, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate(), 23,59), place, memo, alarm, image);
			addController.addScheduleInfo(kind, title, new Date(endDay.getYear(), endDay.getMonth(), endDay.getDate(), 0, 1), endDay, place, memo, alarm, image);
		}
		else if(days >= 3){
			for(int cnt=0; cnt < days; cnt++){
				if(cnt==0)
					addController.addScheduleInfo(kind, title, startDay, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate(), 23,59), place, memo, alarm, image);
				else if(cnt == days-1)
					addController.addScheduleInfo(kind, title, new Date(endDay.getYear(), endDay.getMonth(), endDay.getDate(), 0, 1), endDay, place, memo, alarm, image);
				else
					addController.addScheduleInfo(kind, title, new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate()+cnt, 0,1), new Date(startDay.getYear(), startDay.getMonth(), startDay.getDate()+cnt,23,59), place, memo, alarm, image);
			}
		}

		System.out.println("Split 나왔다!!!");


	}

}
