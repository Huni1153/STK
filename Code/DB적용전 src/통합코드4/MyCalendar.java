import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyCalendar extends JPanel
{
//	private JFrame frameMain;
//	private Container contentPane;

	private JLabel monthLabel;
	private JLabel yearLabel;

	private JButton prevButton;
	private JButton nextButton;
	
	private JPanel panelCalendar;

	private JTable tableCalendar;
	private DefaultTableModel modelCalendar;
	private JScrollPane scrollPaneCalendar;
	private JComboBox yearCombo;

	private int realYear;
	private int realMonth;
	private int realDay;
	private int currentYear;
	private int currentMonth;

	////////////////////////////재영
	private DisplayInfoController displayInfoController;
	private SimpleDayInfoController simpleController;
	private DailySchedule dailyPanel;
	private SchedulerUI mainFrame;
	////////////////////////////재영


	//ublic MyCalendar(){
////////////////////////////재영
	public MyCalendar(DisplayInfoController displayInfoController, SimpleDayInfoController simpleController, DailySchedule dailyPanel, SchedulerUI mainFrame){
		this.displayInfoController = displayInfoController;
		this.simpleController = simpleController;
		this.dailyPanel = dailyPanel;
		this.mainFrame = mainFrame;
////////////////////////////재영
		//setTitle("MyCalendar");
		//super();

		setLayout(new BorderLayout());
		
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}

		//check
		/*frameMain = new JFrame("MyCalendar");*/
		
		
		//check
		//frameMain.setSize(330,375);
		
		/*frameMain.setPreferredSize(new Dimension(330,375));*/
		setPreferredSize(new Dimension(330,375));
		
		/*contentPane = frameMain.getContentPane();*/
		
		//contentPane = getContentPane();


		//contentPane.setLayout(null);

		monthLabel = new JLabel("January");
		yearLabel = new JLabel("Change year : ");

		yearCombo = new JComboBox();
		prevButton = new JButton("<--");
		nextButton = new JButton("-->");

		//check
		//modelCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		modelCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return true;}};
		tableCalendar = new JTable(modelCalendar);
		scrollPaneCalendar = new JScrollPane(tableCalendar);
		panelCalendar = new JPanel(null);

		//Set border
		panelCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
	
		//Register action listeners
		prevButton.addActionListener(new PrevButtonActionListener());
		nextButton.addActionListener(new NextButtonActionListener());
		yearCombo.addActionListener(new YearComboActionListener());


		//Add controls to pane
		//contentPane.add(panelCalendar);
		add(panelCalendar);
		
		panelCalendar.add(monthLabel);
		panelCalendar.add(yearLabel);
		panelCalendar.add(yearCombo);
		panelCalendar.add(prevButton);
		panelCalendar.add(nextButton);
		panelCalendar.add(scrollPaneCalendar);

		//Set bounds
		panelCalendar.setBounds(0,0,320,335);
		//panelCalendar.setBounds(0,0,500,500);
		monthLabel.setBounds(160 - monthLabel.getPreferredSize().width / 2, 25, 100, 25);
		//yearLabel.setBounds(10,305,80,20);
		yearLabel.setBounds(10,305,100,20);
		yearCombo.setBounds(230,305,80,20);
		
		//prevButton.setBounds(10,25,50,25);
		//nextButton.setBounds(260,25,50,25);
		prevButton.setBounds(10,25,60,25);
		nextButton.setBounds(250,25,60,25);
		
		scrollPaneCalendar.setBounds(10,50,300,250);
		
		//Make frame visible

		/*frameMain.setResizable(false);*/
		//setResizable(false);
		
		
		//frameMain.setVisible(true);

		//get real month / year
		GregorianCalendar cal = new GregorianCalendar();
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
		realMonth = cal.get(GregorianCalendar.MONTH);
		realYear = cal.get(GregorianCalendar.YEAR);
		currentMonth = realMonth;
		currentYear = realYear;


		// setting setSelection

		

		//tableCalendar.setCellSelectionEnabled(true);

		//ListSelectionModel cellSelectionModel = tableCalendar.getSelectionModel();
		//cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		
		//ListSelectionListener tableListener = new MyCalendarActionListener(tableCalendar, modelCalendar, yearCombo, monthLabel);
		
		//cellSelectionModel.addListSelectionListener(tableListener);

		tableCalendar.setCellSelectionEnabled(true);
		//TableColumnModelListener columnListener = new MyCalendarSelectActionListener(tableCalendar, modelCalendar, yearCombo, monthLabel);
////////////////////////재영///////////////////////////////////////////////////////////////
		TableColumnModelListener columnListener = new MyCalendarSelectActionListener(tableCalendar, modelCalendar, yearCombo, monthLabel, displayInfoController, simpleController, dailyPanel, mainFrame);
////////////////////////재영///////////////////////////////////////////////////////////////


		TableColumnModel columnModel = tableCalendar.getColumnModel();
		columnModel.addColumnModelListener(columnListener);

		//tableCalendar.getColumnModel().getSelectionModel().addListSelectionListener(columnListener);
		//tableCalendar.getColumnModel().addColumnModelListener(columnListener);


		//add headers

		String []headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for(int i=0; i<7; i++){
			modelCalendar.addColumn(headers[i]);
		}

		tableCalendar.getParent().setBackground(tableCalendar.getBackground()); // setBackground


		// No resize / reorder
		tableCalendar.getTableHeader().setResizingAllowed(false);
		tableCalendar.getTableHeader().setReorderingAllowed(false);
		//tableCalendar.getTableHeader().setResizingAllowed(true);
		//tableCalendar.getTableHeader().setReorderingAllowed(true);


		//Single cell selection
		tableCalendar.setColumnSelectionAllowed(true);
		tableCalendar.setRowSelectionAllowed(true);

		//tableCalendar.setColumnSelectionAllowed(false);
		//tableCalendar.setRowSelectionAllowed(false);
		tableCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//set row/column count
		tableCalendar.setRowHeight(38);
		modelCalendar.setColumnCount(7);
		modelCalendar.setRowCount(6);

		//populate table
		for(int i=realMonth - 100; i<=realYear+100; i++){
			yearCombo.addItem(String.valueOf(i));
		}

	
		/*frameMain.pack();
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/

	//	pack();
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		refreshCalendar(realMonth, realYear);	

	}

	public void display(){
		/*frameMain.setVisible(true);*/
		//setVisible(true);
	}

	public void refreshCalendar(int month, int year){
		String []months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int numberOfDays;
		int startOfMonth;

		prevButton.setEnabled(true);
		nextButton.setEnabled(true);

		if(month == 0 && year <= realYear - 10){
			prevButton.setEnabled(false); // Too early??
		}
		if(month == 11 && year >= realYear + 100){
			nextButton.setEnabled(false);
		}
		monthLabel.setText(months[month]);
		monthLabel.setBounds(160 - monthLabel.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
		yearCombo.setSelectedItem(String.valueOf(year));


		// clear table
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				modelCalendar.setValueAt(null,i,j);
			}
		}

		//Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year,month,1);
		numberOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);


		 //Draw calendar
		for(int i=1; i<=numberOfDays; i++){
			int row = new Integer((i+startOfMonth-2)/7);
			int column = (i+startOfMonth-2)%7;
			modelCalendar.setValueAt(i,row,column);
		}

		//Apply renderers

		tableCalendar.setDefaultRenderer(tableCalendar.getColumnClass(0), new tableCalendarRenderer());

	}
///////////////0513대섭추가!!///////////////0513대섭추가!!
	public String getTodayDir()
	{
		return ""+(realYear-2000)+"/"+(realMonth+1)+"/"+(realDay);
	}
///////////////0513대섭추가!!///////////////0513대섭추가!!
	// render (display)
	class tableCalendarRenderer extends DefaultTableCellRenderer{ //defaltTable의 cell을 보여준다?!
		public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column){
			super.getTableCellRendererComponent(table,value,selected,focused,row,column);
			if(column == 0 || column == 6){ //Week - end
				setBackground(new Color(255,220,220));
			}
			else{ // Week
				setBackground(new Color(255,255,255));
			}

			if(value != null){
				if(Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){
					setBackground(new Color(220,220,255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}



	class PrevButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(currentMonth == 0){
				currentMonth = 11;
				currentYear -=1;
			}
			else{
				currentMonth -= 1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}

	class NextButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(currentMonth == 11){
				currentMonth = 0;
				currentYear += 1;
			}
			else{
				currentMonth+=1;
			}
			refreshCalendar(currentMonth, currentYear);
		}
	}
	class YearComboActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(yearCombo.getSelectedItem()!= null){
				String b = yearCombo.getSelectedItem().toString();
				currentYear = Integer.parseInt(b);
				refreshCalendar(currentMonth, currentYear);
			}
		}
	}

	//public static void main(String []args){
	//	new MyCalendar();
	//}


}
