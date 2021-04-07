  import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class SchedulerUI extends JFrame
{
	private Container contentPane;
	private JToolBar topBar;
	
	private JButton addSchedule;
	private JButton editSchedule;
	private JButton startMonth;
	private JButton endMonth;
	private JButton searchSchedule;
	private JButton deleteSchedule;
	private JButton printSchedule;
	private JButton exitSchedule;

	private JTextField searchText;

	private JButton addNewDocument;
	private JButton editDocument;
	private JButton deleteDocument;

	private JLabel emptyLabel1;
	private JLabel emptyLabel2;

	private JPanel sidePanel;

	private MyCalendar myCalendar;
	private WeeklySchedule weeklySchedule;
////////////////////////////////////////////////
	private DailySchedule dailySchedule;
	private AddScheduleInfoUI addScheduleInfoUI;
	private ModifyScheduleInfoUI modifyScheduleInfoUI;
	//private STKprojectTextUI stkProjectTextUI;
	private String[] documentDirectoryList;
	private String todayDocumentDirectory;

/////////////////////////////////////////�翵

	private DisplayInfoController displayInfoController;
	private AMonthDayInfoController monthController;
	private SimpleDayInfoController simpleController;

	private String choiceYear;
	private String choiceMonth;
	private String choiceDate;
/////////////////////////////////////////////////�翵	

	public SchedulerUI(){
		super("Study Tool Kit");
		

		fileLoad();	//���Ͽ��� �о�ͼ� �޸𸮿� ����!

////////////////////////////////////////
		DayScheduleInfoDAO.getInstance().fileLoad();
		DayScheduleInfoDAO.getInstance().setLatestCodeNum();
////////////////////

		GregorianCalendar cal = new GregorianCalendar();
		int year = cal.get(GregorianCalendar.YEAR);
		int month = cal.get(GregorianCalendar.MONTH)+1;
		int day = cal.get(GregorianCalendar.DAY_OF_MONTH);

		this.choiceYear = Integer.toString(year);
		this.choiceMonth = Integer.toString(month);
		this.choiceDate = Integer.toString(day);

		contentPane = getContentPane();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1200, 800);
		//setUndecorated(true);

		
		//setLocation(100,10);
		//setPreferredSize(new Dimension(1200,800));
	
		topBar = new JToolBar("Top Bar", JToolBar.HORIZONTAL);
		topBar.setOpaque(true);
		topBar.setBackground(new Color(219,238,244));
		//topBar.setLayout(new BorderLayout());

		sidePanel = new JPanel(new GridLayout(2,1));

///////////////////////////////�翵
		displayInfoController = new DisplayInfoController();
		monthController = new AMonthDayInfoController(displayInfoController);
		//SimpleDayInfoController simpleController = new SimpleDayInfoController("2015","5","10",displayInfoController);
		SimpleDayInfoController simpleController = new SimpleDayInfoController(choiceYear,choiceMonth,choiceDate,displayInfoController);

		myCalendar = new MyCalendar(displayInfoController, simpleController, dailySchedule, this);
		//weekSchedule = new WeekSchedule();
		weeklySchedule = new WeeklySchedule();
/////////////////////////////////////////


		//myCalendar = new MyCalendar();

		todayDocumentDirectory = myCalendar.getTodayDir();

		//weekSchedule = new WeekSchedule();
/*                                                     */

////////////////////////////////////////////////////////////////////////
		dailySchedule = new DailySchedule(simpleController);
		addScheduleInfoUI = new AddScheduleInfoUI();
		modifyScheduleInfoUI = new ModifyScheduleInfoUI();
		//stkProjectTextUI = new STKprojectTextUI();
////////////////////////////////////////////////////////////////////////
		
		sidePanel.add(myCalendar);
		sidePanel.add(weeklySchedule);

		addSchedule = new JButton(new ImageIcon("Icon/schedule.png"));
		editSchedule = new JButton(new ImageIcon("Icon/pen.png"));
		startMonth = new JButton(new ImageIcon("Icon/month.png"));
		endMonth = new JButton(new ImageIcon("Icon/month2.png"));
		searchSchedule = new JButton(new ImageIcon("Icon/search.png"));
		deleteSchedule = new JButton(new ImageIcon("Icon/delete.png"));
		printSchedule = new JButton(new ImageIcon("Icon/print.png"));
		exitSchedule = new JButton(new ImageIcon("Icon/exit.png"));


		searchText = new JTextField(15);
		searchText.setPreferredSize( new Dimension( 200, 60 ) );
		
		addNewDocument = new JButton(new ImageIcon("Icon/text.png"));
		editDocument = new JButton(new ImageIcon("Icon/load.png"));
		deleteDocument = new JButton(new ImageIcon("Icon/remove.png"));

		emptyLabel1 = new JLabel("                 ");
		emptyLabel2 = new JLabel("                ");
		

		topBar.add(addSchedule);
		topBar.add(editSchedule);
		topBar.add(startMonth);
		topBar.add(endMonth);
		topBar.add(searchText);
		topBar.add(searchSchedule);
		topBar.add(deleteSchedule);
		topBar.add(printSchedule);
		topBar.add(emptyLabel1);
		topBar.add(addNewDocument);
		topBar.add(editDocument);
		topBar.add(deleteDocument);
		topBar.add(emptyLabel2);
		topBar.add(exitSchedule);

		
		
		addComponent();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private boolean fileLoad()
	{
			
		DataIOController dataIOController = new DataIOController();
		dataIOController.fileLoad();

		GetDocumentDirectoryListController getDirectory = new GetDocumentDirectoryListController();
		documentDirectoryList = getDirectory.getDirectoryList();

		for( int i=0; i<documentDirectoryList.length; i++)
		{
			System.out.println(documentDirectoryList[i]);
		}

		//getTodayDocumentDirectory();

		return true;

	}
/////////////////////�翵/////////////////////�翵


	public void setChoiceVariables(String year, String month, String date){
		this.choiceYear = year;
		this.choiceMonth = month;
		this.choiceDate = date;
	//	reDisplay();
		//reDisplay();
	}
	public void reDisplay(){
		simpleController = new SimpleDayInfoController(choiceYear,choiceMonth,choiceDate,displayInfoController);	
		dailySchedule = new DailySchedule(simpleController);
		setVisible(false);
		setVisible(true);
	}
/////////////////////�翵/////////////////////�翵

	private void addComponent(){
		add(topBar,BorderLayout.NORTH);
		add(sidePanel, BorderLayout.WEST);
		add(dailySchedule, BorderLayout.CENTER);

		addListener();
	}
	private void addListener(){
		ActionListener listener = new DailyScheduleInfoActionListener();

		addSchedule.addActionListener(listener);
		editSchedule.addActionListener(listener);
		startMonth.addActionListener(listener);
		endMonth.addActionListener(listener);
		searchSchedule.addActionListener(listener);
		deleteSchedule.addActionListener(listener);
		printSchedule.addActionListener(listener);
		exitSchedule.addActionListener(listener);

		ActionListener documentListener = new DocumentInfoActionListener();
		addNewDocument.addActionListener(documentListener);
		editDocument.addActionListener(documentListener);
		deleteDocument.addActionListener(documentListener);
	}

	public void displayUI(){

		setVisible(true);
	}
	public void closeUI(){
/////////////////////�翵/////////////////////�翵
		DayScheduleInfoDAO.getInstance().fileSave();
/////////////////////�翵/////////////////////�翵
		setVisible(false);
		dispose();
	}


	class DailyScheduleInfoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addSchedule){
				addScheduleInfoUI.display();
			}
			else if(e.getSource() == editSchedule){
				modifyScheduleInfoUI.display();
			}
			else if(e.getSource() == startMonth){
				System.out.println("���� ����");
			}
			else if(e.getSource() == endMonth){
				System.out.println("���� ����");
			}
			else if(e.getSource() == searchSchedule){
				System.out.println("���� �˻��ϱ�");
			}
			else if(e.getSource() == deleteSchedule){
				System.out.println("���� �����ϱ�");
			}
			else if(e.getSource() == printSchedule){
				System.out.println("���� ����Ʈ�ϱ�");
			}
			else if(e.getSource() == exitSchedule){
				DataIOController dataIOController = new DataIOController();
				dataIOController.fileSave();
				closeUI();
			}
			else {}
		}
	}

	class DocumentInfoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addNewDocument){
				try{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style â
				}catch(Exception est){
					est.printStackTrace();
				}
	
				//System.out.println("���� ���丮: " + todayDocumentDirectory);
				AddStudyDocumentInfoController add = new AddStudyDocumentInfoController(todayDocumentDirectory);
				String newDocCode = add.addNewStudyDocumentInfo();

				//System.out.println("     @@    " + newDocCode);

				STKprojectTextUI stkProjectTextUI = new STKprojectTextUI(newDocCode);
				stkProjectTextUI.displayTextScreen( todayDocumentDirectory);
			}
			else if(e.getSource() == editDocument){
				System.out.println("���� �����ϱ�");
			}
			else if(e.getSource() == deleteDocument){
				System.out.println("���� �����ϱ�");
			}
			else {}
		}
	}

}
