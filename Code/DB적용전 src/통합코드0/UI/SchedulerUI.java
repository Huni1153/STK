import java.awt.*;
import javax.swing.*;

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

	private MyCalendar myCalendar;


	public SchedulerUI(){
		super("Study Tool Kit");

		contentPane = getContentPane();

		setLocation(200,200);
		setPreferredSize(new Dimension(1200,800));
	
		topBar = new JToolBar("Top Bar", JToolBar.HORIZONTAL);

		myCalendar = new MyCalendar();

		addSchedule = new JButton(new ImageIcon("Icon/schedule.png"));
		editSchedule = new JButton(new ImageIcon("Icon/pen.png"));
		startMonth = new JButton(new ImageIcon("Icon/month.png"));
		endMonth = new JButton(new ImageIcon("Icon/month2.png"));
		searchSchedule = new JButton(new ImageIcon("Icon/search.png"));
		deleteSchedule = new JButton(new ImageIcon("Icon/delete.png"));
		printSchedule = new JButton(new ImageIcon("Icon/print.png"));
		exitSchedule = new JButton(new ImageIcon("Icon/exit.png"));


		searchText = new JTextField(5);
		
		addNewDocument = new JButton(new ImageIcon("Icon/text.png"));
		editDocument = new JButton(new ImageIcon("Icon/load.png"));
		deleteDocument = new JButton(new ImageIcon("Icon/remove.png"));

		emptyLabel1 = new JLabel("                 ");
		//emptyLabel1 = new JLabel(new ImageIcon("Icon/night.png"));
		emptyLabel2 = new JLabel("                ");
		
		//emptyLabel1.setPreferredSize(new Dimension(50,50));
		
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

		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		addComponent();
		

	}
	private void addComponent(){
		add(topBar,BorderLayout.NORTH);
		add(myCalendar, BorderLayout.WEST);
	}

	public void displayUI(){
		setVisible(true);
	}
}
