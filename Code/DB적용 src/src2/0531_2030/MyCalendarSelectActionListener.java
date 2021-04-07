import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class MyCalendarSelectActionListener implements TableColumnModelListener
{
	private JTable tableCalendar;
	private DefaultTableModel tableModel;
	private JComboBox yearCombo;
	private JLabel monthLabel;

////////////////////////�翵
	private DisplayInfoController displayInfoController;
	private SimpleDayInfoController simpleController;
	private DailySchedule dailyPanel;
	private SchedulerUI mainFrame;
////////////////////////�翵


	//public MyCalendarSelectActionListener(JTable tableCalendar, DefaultTableModel tableModel, JComboBox yearCombo, JLabel monthLabel){
	/*public MyCalendarSelectActionListener(JTable tableCalendar, DefaultTableModel tableModel, JComboBox yearCombo, JLabel monthLabel, DisplayInfoController displayInfoController, SimpleDayInfoController simpleController, JPanel dailyPanel, JFrame mainFrame){

		this.tableCalendar = tableCalendar;
		this.tableModel = tableModel;
		this.yearCombo = yearCombo;
		this.monthLabel = monthLabel;

////////////////////////�翵////////////////////////�翵
		this.displayInfoController = displayInfoController;
		this.simpleController = simpleController;
		this.dailyPanel = dailyPanel;
		this.mainFrame = mainFrame;
////////////////////////�翵////////////////////////�翵
	}*/

	public MyCalendarSelectActionListener(JTable tableCalendar, DefaultTableModel tableModel, JComboBox yearCombo, JLabel monthLabel, DisplayInfoController displayInfoController, SimpleDayInfoController simpleController, DailySchedule dailyPanel, SchedulerUI mainFrame){
		this.tableCalendar = tableCalendar;
		this.tableModel = tableModel;
		this.yearCombo = yearCombo;
		this.monthLabel = monthLabel;

		this.displayInfoController = displayInfoController;
		this.simpleController = simpleController;
		this.dailyPanel = dailyPanel;
		this.mainFrame = mainFrame;
	}

	public void columnAdded(TableColumnModelEvent e) {
        //System.out.println("Added");
      }

      public void columnMarginChanged(ChangeEvent e) {
        //System.out.println("Margin");
      }

      public void columnMoved(TableColumnModelEvent e) {
        //System.out.println("Moved");
      }

      public void columnRemoved(TableColumnModelEvent e) {
        //System.out.println("Removed");
      }

	public void columnSelectionChanged(ListSelectionEvent e) {
        tableCalendar.getSelectedRow(); tableCalendar.getSelectedColumn();
		int row = tableCalendar.getSelectedRow();
		int col = tableCalendar.getSelectedColumn();
		String year = (String)yearCombo.getSelectedItem();
		String month = monthLabel.getText();

////////////////////////�翵////////////////////////�翵

		if(month.equals("January")) month = "1";
		else if(month.equals("February")) month = "2";
		else if(month.equals("March")) month = "3";
		else if(month.equals("April")) month = "4";
		else if(month.equals("May")) month = "5";
		else if(month.equals("June")) month = "6";
		else if(month.equals("July")) month = "7";
		else if(month.equals("August")) month = "8";
		else if(month.equals("September")) month = "9";
		else if(month.equals("October")) month = "10";
		else if(month.equals("November")) month = "11";
		else if(month.equals("December")) month = "12";
	////////////////////////�翵////////////////////////�翵
	
		//System.out.println(row);
		//System.out.println(col);
		//System.out.println(year);
		//System.out.println(month);
		if(row > -1 && col > -1 && month != null){
			
	////////////////////////�翵////////////////////////�翵

			System.out.println(tableCalendar.getValueAt(row,col));
			String day = ""+tableCalendar.getValueAt(row,col);
			System.out.println(year);
			System.out.println(month);

			mainFrame.setChoiceVariables(year,month,day);


			


			mainFrame.reDisplay();
		////////////////////////�翵////////////////////////�翵

		}
		else
		{}
      } 
}


