import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.border.*;

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

/////////////////////////////
	private SimpleDayDocumentController simpleDayDocumentController;
	private String[][] simpleDayDocumentList;

	private DefaultTableModel fiveModel;
	private JTable fiveTable;
//////////////////////////////////
	


	//btn.setSize();
	//btn.setLocation();

	//private 

	public DailySchedule()
	{
////////////////////////////대섭추가
		simpleDayDocumentController = new SimpleDayDocumentController();
		simpleDayDocumentList = simpleDayDocumentController.getSimpleDayDocument("15","5","10");

		for (String x[] : simpleDayDocumentList) {
			 for (String y : x) {
				System.out.print(y + "   ");
			}
			System.out.println();
		}
/////////////////////////////////
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


		northPanel.add(one);
		northPanel.add(two);
		northPanel.add(three);
		northPanel.add(four);
		northPanel.add(five);
////////////////////////////////////////////
		

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
			data[i][0] = simpleDayDocumentList[i][1];
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
		
		onePanel.setLayout(null);
		onePanel.setBounds(0,0,200,500);
		System.out.println(onePanel.getWidth());
		System.out.println(onePanel.getHeight());
	/*
		JLabel label2 = new JLabel("Coram Deo");
		label2.setLayout(null);
		label2.setBounds(0,250,190,750);
		label2.setOpaque(true);
		label2.setBackground(Color.RED);
		onePanel.add(label2);
	*/
		addSchedule();
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

		
		centerPanel.add(onePanel);
		centerPanel.add(twoPanel);
		centerPanel.add(threePanel);
		centerPanel.add(fourPanel);
		centerPanel.add(fivePanel);

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


////////////////////////////////////////////////
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

	}

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

	public void addSchedule(){
		double standardHour = 6;
		
		double startHour = 7;
		double startMinutes = 30;
		
		double endHour = 10;
		double endMinutes = 30;

		int startValue = (int)((startHour * 60.0 + startMinutes - 360.0 ) / 360.0 * 500.0);
		int endValue = (int)(( endHour * 60.0 + endMinutes - 360.0 ) / 360.0 * 500.0);
		
		/* JLabel 에 updateUI라는 녀석이 있음 */

		
		//int totalMinutes = (endHour * 60 + endMinutes) - (startHour * 60 + startMinutes);

		//double timeRatio = totalMinutes / 360;
		//int heightValue = (int)( (timeRatio * 0.001) * 100 );

		System.out.println(startValue); //175
		System.out.println(endValue); //525
		JLabel testLabel = new JLabel("운동하기");
		testLabel.setOpaque(true);
		testLabel.setBackground(Color.RED);
		testLabel.setLayout(null);
		testLabel.setBounds(0,startValue,162,endValue-startValue); //125 375
	//	testLabel.setBounds(0,0,200,300); //250 750
	//	testLabel.setBounds(0,30,162,450);
		
		//testLabel.setBounds(0,125,162,375);

		//testLabel.setBounds(0,20,162,400);

		onePanel.add(testLabel);
		/*
		JLabel label2 = new JLabel("Coram Deo");
		label2.setLayout(null);
		label2.setBounds(0,250,190,750);
		label2.setOpaque(true);
		label2.setBackground(Color.RED);
		onePanel.add(label2);
	*/
	}

}