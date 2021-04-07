import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.*;
public class UITestMain
{



	public static void main(String []args){
/*
	   try{
         UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");   // Nimbus style â
	   }catch(Exception e){
         e.printStackTrace();f
       }
*/
		new SchedulerUI().displayUI();
	
		Date date =  new Date(2015,05,05,13,30);
		Date date2 =  new Date(2015,05,04,12,00);
		

//		System.out.println(date - date2 );


		System.out.println( new SimpleDateFormat().format(date)  );

		//System.out.println(date.get)

		SimpleDateFormat d = new SimpleDateFormat("2015-05-05");
	
	/*

		JFrame frame = new JFrame("Study Took Kit");
		Container contentPane = frame.getContentPane();

		MyCalendar myCalendar = new MyCalendar();


		frame.setLocation(200,200);
		frame.setPreferredSize(new Dimension(1000,800));


		JToolBar topBar = new JToolBar("Top Bar", JToolBar.HORIZONTAL);

		

		JButton scheduleAdd = new JButton(new ImageIcon("Icon/schedule.png"));
		JButton scheduleEdit = new JButton(new ImageIcon("Icon/pen.png"));
		JButton scheduleStartMonth = new JButton(new ImageIcon("Icon/month.png"));
		JButton scheduleEndMonth = new JButton(new ImageIcon("Icon/month2.png"));
		JButton scheduleSearch = new JButton(new ImageIcon("Icon/search.png"));
		JButton scheduleDelete = new JButton(new ImageIcon("Icon/delete.png"));
		JButton schedulePrint = new JButton(new ImageIcon("Icon/print.png"));
		JButton scheduleExit = new JButton(new ImageIcon("Icon/exit.png"));

		JTextField searchText = new JTextField(5);
		
		JButton addNewDocument = new JButton(new ImageIcon("Icon/text.png"));
		JButton editDocument = new JButton(new ImageIcon("Icon/load.png"));
		JButton deleteDocument = new JButton(new ImageIcon("Icon/remove.png"));
		
		JLabel emptyLabel = new JLabel("                 ");
		JLabel emptyLabel2 = new JLabel("                ");

		topBar.add(scheduleAdd);
		topBar.add(scheduleEdit);
		topBar.add(scheduleStartMonth);
		topBar.add(scheduleEndMonth);
		topBar.add(searchText);
		topBar.add(scheduleSearch);
		topBar.add(scheduleDelete);
		topBar.add(schedulePrint);
		topBar.add(emptyLabel);
		topBar.add(addNewDocument);
		topBar.add(editDocument);
		topBar.add(deleteDocument);
		topBar.add(emptyLabel2);
		topBar.add(scheduleExit);

		frame.add(topBar,BorderLayout.NORTH);
		frame.add(myCalendar, BorderLayout.WEST);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	*/	


	}
}