import java.awt.*;
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
	private STKprojectTextUI stkProjectTextUI;
////////////////////////////////////////////////
	

	public SchedulerUI(){
		super("Study Tool Kit");
		
		contentPane = getContentPane();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1200, 800);

		
		//setLocation(100,10);
		//setPreferredSize(new Dimension(1200,800));
	
		topBar = new JToolBar("Top Bar", JToolBar.HORIZONTAL);
		topBar.setOpaque(true);
		topBar.setBackground(new Color(219,238,244));
		//topBar.setLayout(new BorderLayout());

		sidePanel = new JPanel(new GridLayout(2,1));
		myCalendar = new MyCalendar();
		//weekSchedule = new WeekSchedule();
		weeklySchedule = new WeeklySchedule();

////////////////////////////////////////////////////////////////////////
		dailySchedule = new DailySchedule();
		addScheduleInfoUI = new AddScheduleInfoUI();
		modifyScheduleInfoUI = new ModifyScheduleInfoUI();
		stkProjectTextUI = new STKprojectTextUI();
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

	private void addComponent(){
		add(topBar,BorderLayout.NORTH);
		add(sidePanel, BorderLayout.WEST);
	////////////////////////////////////////////////////
		add(dailySchedule, BorderLayout.CENTER);
////////////////////////////////////////////////////

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
				System.out.println("시작 일자");
			}
			else if(e.getSource() == endMonth){
				System.out.println("종료 일자");
			}
			else if(e.getSource() == searchSchedule){
				System.out.println("일정 검색하기");
			}
			else if(e.getSource() == deleteSchedule){
				System.out.println("일정 삭제하기");
			}
			else if(e.getSource() == printSchedule){
				System.out.println("일정 프린트하기");
			}
			else if(e.getSource() == exitSchedule){
				closeUI();
			}
			else {}
		}
	}

	class DocumentInfoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addNewDocument){
				stkProjectTextUI.displayTextScreen();
			}
			else if(e.getSource() == editDocument){
				System.out.println("문서 수정하기");
			}
			else if(e.getSource() == deleteDocument){
				System.out.println("문서 삭제하기");
			}
			else {}
		}
	}

}
