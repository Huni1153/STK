package Model;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class JMyCalendarSelectActionListener implements TableColumnModelListener
{
	private JTable tableCalendar;
	private DefaultTableModel tableModel;
	private JComboBox yearCombo;
	private JLabel monthLabel;
	private CalendarTime calendarTime;

	public JMyCalendarSelectActionListener(JTable tableCalendar, DefaultTableModel tableModel, JComboBox yearCombo, JLabel monthLabel, CalendarTime calendarTime){
		this.tableCalendar = tableCalendar;
		this.tableModel = tableModel;
		this.yearCombo = yearCombo;
		this.monthLabel = monthLabel;
		this.calendarTime = calendarTime;
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
		
		//System.out.println(row);
		//System.out.println(col);
		//System.out.println(year);
		//System.out.println(month);
		if(row > -1 && col > -1 && month != null){
			
			//System.out.println(tableCalendar.getValueAt(row,col));
			//System.out.println(year);
			//System.out.println(month);
			calendarTime.getCalendarInfo(year, month, tableCalendar.getValueAt(row,col));
		}
		else
		{}
      } 
}


