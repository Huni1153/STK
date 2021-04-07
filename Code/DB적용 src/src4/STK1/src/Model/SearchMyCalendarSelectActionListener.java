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
public class SearchMyCalendarSelectActionListener implements TableColumnModelListener
{
   private JTable tableCalendar;
   private DefaultTableModel tableModel;
   private JComboBox yearCombo;
   private JLabel monthLabel;


   //private CalendarTime calendarTime;
   private SchedulerUI schedulerUI;
   private String division;
   private SearchMyCalendar searchMyCalendar;
   
   public SearchMyCalendarSelectActionListener(JTable tableCalendar, DefaultTableModel tableModel, JComboBox yearCombo, JLabel monthLabel, SchedulerUI schedulerUI, String division, SearchMyCalendar searchMyCalendar){
      this.tableCalendar = tableCalendar;
      this.tableModel = tableModel;
      this.yearCombo = yearCombo;
      this.monthLabel = monthLabel;
      this.schedulerUI = schedulerUI;
      this.division = division;
      this.searchMyCalendar = searchMyCalendar;
   //   this.calendarTime = calendarTime;
   //   this.schedulerUI = null;
   }
   /*
   public JMyCalendarSelectActionListener(JTable tableCalendar, DefaultTableModel tableModel, JComboBox yearCombo, JLabel monthLabel, SchedulerUI schedulerUI, String division){
      this.tableCalendar = tableCalendar;
      this.tableModel = tableModel;
      this.yearCombo = yearCombo;
      this.monthLabel = monthLabel;
      this.schedulerUI = schedulerUI;
      this.division = division;
      this.calendarTime = null;
   }
   */
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


      if(row > -1 && col > -1 && month != null){
         
         //System.out.println(tableCalendar.getValueAt(row,col));
         //System.out.println(year);
         //System.out.println(month);
         String day = ""+tableCalendar.getValueAt(row,col);


         System.out.println();
         System.out.println("==================================================================");
         System.out.println();

         if(division.equals("검색 시작일자")){
               schedulerUI.setSearchStart(year, month, day,1);
               searchMyCalendar.closeUI();
         }
         else if(division.equals("검색 종료일자")){
               schedulerUI.setSearchEnd(year,month,day);
               searchMyCalendar.closeUI();
         }
      
            
      }
      else
      {}
      } 
}

