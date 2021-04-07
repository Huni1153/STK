import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;

public class DailySchedule extends JPanel 
{
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;

	final private JLabel one = new JLabel(new ImageIcon("Icon/Sunrise.png"), JLabel.CENTER);
	final private JLabel two = new JLabel(new ImageIcon("Icon/Sun.png"), JLabel.CENTER);
	final private JLabel three = new JLabel(new ImageIcon("Icon/Moon.png"), JLabel.CENTER);
	final private JLabel four = new JLabel(new ImageIcon("Icon/Star.png"), JLabel.CENTER);
	final private JLabel five = new JLabel(new ImageIcon("Icon/Folder.png"), JLabel.CENTER);

	final private JLabel crying = new JLabel(new ImageIcon("Icon/Crying.png"), JLabel.CENTER);
	final private JLabel happy = new JLabel(new ImageIcon("Icon/Happy.png"), JLabel.CENTER);
	final private JLabel sleeping = new JLabel(new ImageIcon("Icon/Sleeping.png"), JLabel.CENTER);
	final private JLabel statement;
	
	private JPanel onePanel = new JPanel();
	private JPanel twoPanel = new JPanel();
	private JPanel threePanel = new JPanel();
	private JPanel fourPanel = new JPanel();
	private JPanel fivePanel = new JPanel();


/////////////////////////////재영
	private String compareCode;
	private int colorNum;
	private Random random;
	
	private SimpleDayInfoController simpleController;
////////////////////////////////재영
	private SimpleDayDocumentController simpleDayDocumentController;
	private String[][] simpleDayDocumentList;

	private DefaultTableModel fiveModel;
	private JTable fiveTable;

	


	//btn.setSize();
	//btn.setLocation();

	//private 

	//public DailySchedule()
////////////////////////////재영추가
	public DailySchedule(SimpleDayInfoController simpleController)
	{
		this.compareCode = "0";
		this.random = new Random();
		this.colorNum = random.nextInt(11);

		this.colorNum = random.nextInt(11);
		////////////////////////////////////////////
		// 일정 쪼개는 부분
		
		this.simpleController = simpleController;
		if(simpleController.getIsDay())
			this.simpleController.divideSchedule();
		else
		{}

////////////////////////////재영추가
		simpleDayDocumentController = new SimpleDayDocumentController();
		simpleDayDocumentList = simpleDayDocumentController.getSimpleDayDocument("15","5","10");
/*
		for (String x[] : simpleDayDocumentList) {
			 for (String y : x) {
				System.out.print(y + "   ");
			}
			System.out.println();
		}*/
		setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		//setBorder(BorderFactory.createTitledBorder(""));

		
		northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(0,5));
		northPanel.setBackground(Color.white);

	

		//northPanel.add(new JLabel("일",JLabel.CENTER));

		one.setBorder(new LineBorder(Color.gray, 1));
		two.setBorder(new LineBorder(Color.gray, 1));
		three.setBorder(new LineBorder(Color.gray, 1));
		four.setBorder(new LineBorder(Color.gray, 1));
		five.setBorder(new LineBorder(Color.gray, 1));


/////////////////////////////////재영
		northPanel.add(four);
		northPanel.add(one);
		northPanel.add(two);
		northPanel.add(three);
		northPanel.add(five);
/////////////////////////////////////////////재영
		

		//JButton btn = new JButton("버튼");
		//centerPanel.add(btn);
		//btn.setSize(300,20);
		//btn.setLocation(0,0);


	    //JPanel centerPan = new JPanel();
		//centerPan.setLayout(new GridLayout(0, 5));

		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1,5));

//////////////////////////////////
		String[] colName = {"파일명"};
		//System.out.println( simpleDayDocumentList.length );

		String[][] data = new String[simpleDayDocumentList.length][1];

		for(int i=0; i<data.length; i++)
		{
			data[i][0] = simpleDayDocumentList[i][1]+".java";
		}
		fiveModel = new DefaultTableModel(data, colName);
		fiveTable = new JTable(fiveModel);
		//fiveModel = new DefaultTableModel(data, colName);
		/*fiveTable = new JTable(fiveModel)
		{
			public Class getColumnClass(int col)
			{
				return getValueAt(0, col).getClass();
			}
		};*/
		TableColumn column =  column = fiveTable.getColumnModel().getColumn(0);
		column.setPreferredWidth(160);

		fiveTable.setRowHeight(30);	// table 높이
		fiveTable.setTableHeader(null);	// colName 없앰

//////////////////////////////////
		//centerPanel.setLayout(null);
		//centerPanel.setBounds(0,0,800,500);

		//System.out.println(centerPanel.getWidth());
		//System.out.println(centerPanel.getHeight());

		//one.setBorder(new LineBorder(Color.gray, 1));
		onePanel.setBorder(new LineBorder(Color.gray,1));
		twoPanel.setBorder(new LineBorder(Color.gray,1));
		threePanel.setBorder(new LineBorder(Color.gray,1));
		fourPanel.setBorder(new LineBorder(Color.gray,1));
		fivePanel.setBorder(new LineBorder(Color.gray,1));

		fivePanel.add(fiveTable);
/*		
		onePanel.setLayout(null);
		onePanel.setBounds(0,0,200,500);
		System.out.println(onePanel.getWidth());
		System.out.println(onePanel.getHeight());
*/

//////////////////////////재영
		onePanel.setLayout(null);
		onePanel.setBounds(0,0,200,500);
		twoPanel.setLayout(null);
		twoPanel.setBounds(0,0,200,500);
		threePanel.setLayout(null);
		threePanel.setBounds(0,0,200,500);
		fourPanel.setLayout(null);
		fourPanel.setBounds(0,0,200,500);



		paintSchedule();

		centerPanel.add(fourPanel);
		centerPanel.add(onePanel);
		centerPanel.add(twoPanel);
		centerPanel.add(threePanel);
//		centerPanel.add(fourPanel);
		centerPanel.add(fivePanel);
//////////////////////////재영



	/*
		JLabel label2 = new JLabel("Coram Deo");
		label2.setLayout(null);
		label2.setBounds(0,250,190,750);
		label2.setOpaque(true);
		label2.setBackground(Color.RED);
		onePanel.add(label2);
	*/
		//addSchedule();
		/*
		JLabel testLabel = new JLabel("Coram Deo");
		testLabel.setLayout(null);
		testLabel.setBounds(95,0,195,950);
		
		System.out.println(testLabel.getWidth());
		System.out.println(testLabel.getHeight());
		onePanel.add(testLabel);
		*/
		//onePanel.setLayout(null);[
		//onePanel.setBounds(0,0,50,50);

		


/////////////////////////////////
		crying.setPreferredSize(new Dimension(150,100));

		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		southPanel.setBorder(new LineBorder(Color.gray, 1));

		southPanel.add(crying, BorderLayout.WEST);

		statement = new JLabel();
		statement.setText("  휴식이 필요합니다.");

		southPanel.add(statement, BorderLayout.CENTER);
		southPanel.setBackground(Color.white);



		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

	}

////////////////////////////////////////////////재영
	public void paintSchedule(){
		LinkedList<SimpleDayInfo> list = simpleController.getSimpleList();
		
		if(list == null)
			return ;

		for(int cnt=0; cnt<list.size(); cnt++){
			SimpleDayInfo info = list.get(cnt);

			addSchedule(info.getScheduleCode(), info.getScheduleName(), info.getStartHour(), info.getStartMinutes(), info.getEndHour(), info.getEndMinutes());
		}
	}
	
	public void addSchedule(String code, String name, int startHour, int startMinutes, int endHour, int endMinutes){

		double standardHour = 0.0;
		int choicePanel = 0;
		if( (startHour * 60 + startMinutes) >= 0 && (startHour * 60 + startMinutes) < 6 * 60 ){
			choicePanel = 4;
			standardHour = 0.0;
		}
		else if( (startHour * 60 + startMinutes) >= 6*60 && (startHour * 60 + startMinutes) < 12 * 60){
			choicePanel = 1;
			standardHour = 6.0;
		}
		else if( (startHour * 60 + startMinutes) >= 12*60 && (startHour * 60 + startMinutes) < 18*60 ){
			choicePanel = 2;
			standardHour = 12.0;
		}
		else if( (startHour * 60 + startMinutes) >= 18*60 && (startHour * 60 + startMinutes) < 24*60 ){
			choicePanel = 3;
			standardHour = 18.0;
		}

		int startValue = (int)((startHour * 60.0 + startMinutes - standardHour * 60.0 ) / 360.0 * 500.0);
		int endValue = (int)(( endHour * 60.0 + endMinutes - standardHour * 60.0 ) / 360.0 * 500.0);
		
		/* JLabel 에 updateUI라는 녀석이 있음 */


		System.out.println(startValue); //175
		System.out.println(endValue); //525
		JLabel testLabel = new JLabel(name);
		testLabel.setOpaque(true);
		//testLabel.setBackground(Color.RED);
		boolean check = compareLabel(code);
		
		if(check == true)
		{}
		else{ 
			colorNum = choiceColorNum(); // 정해지고
		}
		//	int colorNum = choiceNum();
		//int colorNum = choiceColorNum();

		
		// 이부분 체크해야함!!
		if(check == true){
			makeColor(testLabel, colorNum);
		}
		else{
		//	System.out.println("다른가??");
			while((colorNum = choiceColorNum())!=colorNum);
			makeColor(testLabel, colorNum);
		}
		
		//if(check == false){
		//	this.compareCode = code;
		//}
		//this.compareCode = code;

		//Color color = makeColor(testLabel);

		testLabel.setLayout(null);
		testLabel.setBounds(0,startValue,162,endValue-startValue); //125 375

		if(choicePanel == 1)
			onePanel.add(testLabel);
		else if(choicePanel == 2)
			twoPanel.add(testLabel);
		else if(choicePanel == 3)
			threePanel.add(testLabel);
		else if(choicePanel == 4)
			fourPanel.add(testLabel);

	}
	public boolean compareLabel(String compareCode){
		if(!(this.compareCode.equals(compareCode))){
			this.compareCode = compareCode;
			return false;
		}
		return true;
	}

	public int choiceColorNum(){
		//Random random = new Random();
		int num = random.nextInt(11);
		return num;
	}

	public void makeColor(JLabel label, int colorNum){
		//Random random = new Random();
		//int colorNum = random.nextInt(11);

		if(colorNum == 0) {label.setBackground(Color.BLUE); } 
		else if(colorNum == 1) { label.setBackground(Color.CYAN);}
		else if(colorNum == 2) { label.setBackground(Color.DARK_GRAY);  }
		else if(colorNum == 3) { label.setBackground(Color.GRAY); }
		else if(colorNum == 4) { label.setBackground(Color.GREEN);}
		else if(colorNum == 5) { label.setBackground(Color.LIGHT_GRAY); }
		else if(colorNum == 6) { label.setBackground(Color.MAGENTA); }
		else if(colorNum == 7) { label.setBackground(Color.ORANGE); }
		else if(colorNum == 8) { label.setBackground(Color.PINK); }
		else if(colorNum == 9) { label.setBackground(Color.RED); }
		else if(colorNum == 10) { label.setBackground(Color.YELLOW); }

		
	}




/*
	public int startPoint(int hour, int minutes, int kind){
		double standardHour = 0;
		if(kind == 1) standardHour = 6;
		else if(kind == 2) standardHour = 12;
		else if(kind == 3) standardHour = 18;
		else if(kind == 4) standardHour = 24;

		return (int)((hour * 60 + minutes - 360 ) / standardHour* 6 * 500);

	}
	public int endPoint(int hour, int minutes, int kind){
		double standardHour = 0;
		if(kind == 1) standardHour = 6;
		else if(kind == 2) standardHour = 12;
		else if(kind == 3) standardHour = 18;
		else if(kind == 4) standardHour = 24;

		return (int)(( hour * 60 + minutes - 360 ) / standardHour* 6 * 500);
	}
*/


}