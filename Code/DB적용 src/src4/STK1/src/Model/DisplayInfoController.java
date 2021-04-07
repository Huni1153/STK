package Model;
import java.util.*;
import java.text.*;
public class DisplayInfoController
{
	private final DayScheduleInfoDAO dayScheduleInfoDAO;

	public DisplayInfoController(){
		this.dayScheduleInfoDAO = DayScheduleInfoDAO.getInstance();	
	}
	public DisplayInfoController(DayScheduleInfoDAO dayScheduleInfoDAO){
		this.dayScheduleInfoDAO = dayScheduleInfoDAO;
	}
	public String[][] requestProvideAllInfo(){
		Iterator<DayScheduleInfo> iterator = dayScheduleInfoDAO.provideAllInfo();

		int rowNum = dayScheduleInfoDAO.collectionSize();
		int colNum = dayScheduleInfoDAO.typeElementsMemberCnt();

		String [][]returnString = new String[rowNum][colNum+13];
		
		int row=0;
	
		while(iterator.hasNext()){
			DayScheduleInfo info = iterator.next();
			
			returnString[row][0] = info.getScheduleCode();
			returnString[row][1] = info.getScheduleKind().getKindName();
			returnString[row][2] = info.getScheduleName();
			returnString[row][3] = Integer.toString(info.getStartDay().getYear());
			returnString[row][4] = Integer.toString(info.getStartDay().getMonth());
			returnString[row][5] = Integer.toString(info.getStartDay().getDate());
			returnString[row][6] = Integer.toString(info.getStartDay().getHours());
			returnString[row][7] = Integer.toString(info.getStartDay().getMinutes());
			returnString[row][8] = Integer.toString(info.getEndDay().getYear());
			returnString[row][9] = Integer.toString(info.getEndDay().getMonth());
			returnString[row][10] = Integer.toString(info.getEndDay().getDate());
			returnString[row][11] = Integer.toString(info.getEndDay().getHours());
			returnString[row][12] = Integer.toString(info.getEndDay().getMinutes());
			returnString[row][13] = info.getPlace();
			returnString[row][14] = info.getNote();
			returnString[row][15] = Integer.toString(info.getAlarm().getYear());
			returnString[row][16] = Integer.toString(info.getAlarm().getMonth());
			returnString[row][17] = Integer.toString(info.getAlarm().getDate());
			returnString[row][18] = Integer.toString(info.getAlarm().getHours());
			returnString[row][19] = Integer.toString(info.getAlarm().getMinutes());
			returnString[row][20] = info.getImage();
			
			row++;
		}

		return returnString;

	}
	/*
	public String[][] getOnlyAMonthInfo(String searchMonth){
		String [][]allInfo = requestProvideAllInfo();
		int cnt=0;
		for(int row=0; row<allInfo.length; row++){
			if(allInfo[row][4].equals(searchMonth)){
				cnt++;
			}
		}
		String[][] onlyAMonthInfo = new String[cnt][12];

		for(int row=0; row<allInfo.length; row++){
			if(allInfo[row][4].equals(searchMonth)){
				onlyAMonthInfo[row][0] = allInfo[row][1]; //��������
				onlyAMonthInfo[row][1] = allInfo[row][2]; //�����̸�
				onlyAMonthInfo[row][2] = allInfo[row][3]; //���� ��
				onlyAMonthInfo[row][3] = allInfo[row][4]; // ��
				onlyAMonthInfo[row][4] = allInfo[row][5]; // ��
				onlyAMonthInfo[row][5] = allInfo[row][6]; // �ð�
				onlyAMonthInfo[row][6] = allInfo[row][7]; // ��
				onlyAMonthInfo[row][7] = allInfo[row][8]; // ���� ��
				onlyAMonthInfo[row][8] = allInfo[row][9]; // ��
				onlyAMonthInfo[row][9] = allInfo[row][10]; // ��
				onlyAMonthInfo[row][10] = allInfo[row][11]; // �ð�
				onlyAMonthInfo[row][11] = allInfo[row][12]; // ��
			}
		}
	

		System.out.println(cnt);
		return onlyAMonthInfo;
		

	}
	*/
	public String[][] getOnlyAMonthInfo(String searchYear, String searchMonth){
		String [][]allInfo = requestProvideAllInfo();
		int cnt=0;
		for(int row=0; row<allInfo.length; row++){
			if(allInfo[row][4].equals(searchMonth) && allInfo[row][3].equals(searchYear)){
				cnt++;
			}
		}
		System.out.println("~~~~~~~~~~~~~  "+ cnt);
		/*���� ����ó������!!*/
		String[][] onlyAMonthInfo = new String[cnt][13];

		/*�ݺ�Ƚ�� cnt��!!*/
		int isCnt=0;

		for(int row=0; row<allInfo.length; row++){
			if(allInfo[row][4].equals(searchMonth) && allInfo[row][3].equals(searchYear)){
				onlyAMonthInfo[isCnt][0] = allInfo[row][0]; //���� �ڵ�
				onlyAMonthInfo[isCnt][1] = allInfo[row][1]; //��������
				onlyAMonthInfo[isCnt][2] = allInfo[row][2]; //�����̸�
				onlyAMonthInfo[isCnt][3] = allInfo[row][3]; //���� ��
				onlyAMonthInfo[isCnt][4] = allInfo[row][4]; // ��
				onlyAMonthInfo[isCnt][5] = allInfo[row][5]; // ��
				onlyAMonthInfo[isCnt][6] = allInfo[row][6]; // �ð�
				onlyAMonthInfo[isCnt][7] = allInfo[row][7]; // ��
				onlyAMonthInfo[isCnt][8] = allInfo[row][8]; // ���� ��
				onlyAMonthInfo[isCnt][9] = allInfo[row][9]; // ��
				onlyAMonthInfo[isCnt][10] = allInfo[row][10]; // ��
				onlyAMonthInfo[isCnt][11] = allInfo[row][11]; // �ð�
				onlyAMonthInfo[isCnt][12] = allInfo[row][12]; // ��
				isCnt++;
			}
		}
	

		System.out.println(cnt);
		return onlyAMonthInfo;
		

	}






}