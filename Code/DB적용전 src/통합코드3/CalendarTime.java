import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalendarTime extends JPanel
{
	private JButton hourUp;
	private JButton hourDown;
	private JButton minUp;
	private JButton minDown;
	private JTextField hourTxf;
	private JTextField minTxf;
	private JButton confirmBtn;
	private JButton cancelBtn;

	private String year;
	private String month;
	private int day;
	private AddScheduleInfoUI addScheduleInfoUI;
	private JMyCalendar myCalendar;

	//public CalendarTime(){}
	public CalendarTime(AddScheduleInfoUI addScheduleInfoUI, JMyCalendar myCalendar)
	{
		this.addScheduleInfoUI = addScheduleInfoUI;
		this.myCalendar = myCalendar;
		display();
	}
	public void display()
	{
		
		setBounds(200,50, 200,150);
		setLayout(new BorderLayout());
		addComponent();
	}

	public void addComponent()
	{
		GridBagConstraints c = new GridBagConstraints();
		JPanel timePanel = new JPanel(new GridBagLayout());
		JPanel buttonPanel = new JPanel(new FlowLayout());

		//시간 위 버튼
		hourUp = new JButton(new ImageIcon(new ImageIcon("icon/up.png").getImage().getScaledInstance(50,40,Image.SCALE_DEFAULT)));
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		hourUp.setPreferredSize(new Dimension(50,40));
		hourUp.setOpaque(false);
		hourUp.setContentAreaFilled(false);
		hourUp.setBorderPainted(false);
		timePanel.add(hourUp, c);

		//시간 텍스트
		hourTxf = new JTextField("12");
		hourTxf.setPreferredSize(new Dimension(30,30));
		hourTxf.setHorizontalAlignment(JTextField.CENTER);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		timePanel.add(hourTxf, c);

		//시간 아래 버튼
		hourDown = new JButton(new ImageIcon(new ImageIcon("icon/down.png").getImage().getScaledInstance(50,40,Image.SCALE_DEFAULT)));
		c.gridx =0;
		c.gridy =2;
		c.weightx = 1;
		hourDown.setPreferredSize(new Dimension(50,40));
		hourDown.setOpaque(false);
		hourDown.setContentAreaFilled(false);
		hourDown.setBorderPainted(false);
		timePanel.add(hourDown, c);

		//분 위 버튼
		minUp = new JButton(new ImageIcon(new ImageIcon("icon/up.png").getImage().getScaledInstance(50,40,Image.SCALE_DEFAULT)));
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		minUp.setPreferredSize(new Dimension(50,40));
		minUp.setOpaque(false);
		minUp.setContentAreaFilled(false);
		minUp.setBorderPainted(false);
		timePanel.add(minUp,c);
		
		//분 텍스트
		minTxf = new JTextField("00");
		minTxf.setPreferredSize(new Dimension(30,30));
		minTxf.setHorizontalAlignment(JTextField.CENTER);
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1;
		timePanel.add(minTxf, c);

		//분 아래 버튼
		minDown = new JButton(new ImageIcon(new ImageIcon("icon/down.png").getImage().getScaledInstance(50,40,Image.SCALE_DEFAULT)));
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1;
		minDown.setPreferredSize(new Dimension(50,40));
		minDown.setOpaque(false);
		minDown.setContentAreaFilled(false);
		minDown.setBorderPainted(false);
		timePanel.add(minDown,c);

		//확인 및 취소 버튼
		confirmBtn = new JButton("확인");
		cancelBtn = new JButton("취소");

		buttonPanel.add(confirmBtn);
		buttonPanel.add(cancelBtn);

		add(timePanel,BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		addListener();
	}

	public void getCalendarInfo(String year, String month, Object day)
	{
		//확인
		System.out.println("확인확인확인확인확인확인확인확인확인확인확인");
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		//System.out.por
		this.year = year;
		this.month = month;
		if(day==null){}
			//this.day = 0;
		else{
			this.day = (int)day;
			System.out.println(this.day);
		}
	}

	public void addListener()
	{
		confirmBtn.addActionListener(new CalendarTimeActionListener(myCalendar, this));
		cancelBtn.addActionListener(new CalendarTimeActionListener(myCalendar, this));
		hourUp.addActionListener(new CalendarTimeActionListener());
		hourDown.addActionListener(new CalendarTimeActionListener());
		minUp.addActionListener(new CalendarTimeActionListener());
		minDown.addActionListener(new CalendarTimeActionListener());
	}

	class CalendarTimeActionListener implements ActionListener
	{
		private JMyCalendar myCalendar;
		private CalendarTime calendarTime;
		public CalendarTimeActionListener(){}
		public CalendarTimeActionListener(JMyCalendar myCalendar, CalendarTime calendarTime)
		{
			this.myCalendar = myCalendar;
			this.calendarTime = calendarTime;
		}
		public void actionPerformed(ActionEvent e)
		{
			JButton button = (JButton)e.getSource();
			if(button.getText().equals("확인"))
			{
				addScheduleInfoUI.getCalendarInfo(year, month, day, hourTxf.getText(), minTxf.getText());
				
				/*System.out.println("년 :"+year);
				System.out.println("월 :"+month);
				System.out.println("일 :"+day);
				System.out.println("시 :"+hourTxf.getText());
				System.out.println("분 :"+minTxf.getText());*/
				myCalendar.dispose();
				
			}
			else if(button.getText().equals("취소"))
			{
				myCalendar.dispose();
			}
			else if(button == hourUp)
			{
				if(Integer.parseInt(hourTxf.getText())!=24)
				{
					int hour = Integer.parseInt(hourTxf.getText());
					hourTxf.setText(""+(++hour));
				}
				else
					hourTxf.setText(""+00);
			}
			else if(button == hourDown)
			{
				if(Integer.parseInt(hourTxf.getText())!=00)
				{
					int hour = Integer.parseInt(hourTxf.getText());
					hourTxf.setText(""+(--hour));
				}
				else
					hourTxf.setText(""+24);
			}
			else if(button == minUp)
			{
				if(Integer.parseInt(minTxf.getText())!=60)
				{
					int min = Integer.parseInt(minTxf.getText());
					minTxf.setText(""+(++min));
				}
				else
					minTxf.setText(""+00);
			}
			else if(button == minDown)
			{
				if(Integer.parseInt(minTxf.getText())!=00)
				{
					int min = Integer.parseInt(minTxf.getText());
					minTxf.setText(""+(--min));
				}
				else
					minTxf.setText(""+60);
			}
			
		}
	}

	/*public static void main(String[] args) 
	{
		//new BaseUI().display();
		JFrame d  = new JFrame("testtt");
		d.getContentPane().add(new CalendarTime());
		d.setSize(250,200);
		d.setVisible(true);
	}*/
}
