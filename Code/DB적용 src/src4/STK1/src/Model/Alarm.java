package Model;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Alarm extends JDialog
{
	private JPanel topPanel,buttonPanel;
	private JTextField tTime,tMin;
	private JLabel rTime,rMin;
	private JButton bYes,bCancel;//확인,취소 버튼
	
	public Alarm()
	{
		setTitle("알람 설정");
		topPanel=new JPanel();
		buttonPanel=new JPanel();
		this.tTime=new JTextField(5);
		this.tMin=new JTextField(5);
		this.rTime=new JLabel("시");
		this.rMin=new JLabel("분");
		this.bYes=new JButton("확인");
		this.bCancel=new JButton("취소");
	}
	public void set()
	{
		this.setModal(true);

		this.setPreferredSize(new Dimension(200,100));
		this.setLocation(400,200);

		topPanel.add(tTime);
		topPanel.add(rTime);
		this.bYes.setBackground(new Color(79,129,189));
		this.bYes.setForeground(Color.WHITE);
		topPanel.add(tMin);
		this.bCancel.setBackground(new Color(79,129,189));
		this.bCancel.setForeground(Color.WHITE);
		topPanel.add(rMin);
		buttonPanel.add(bYes);
		buttonPanel.add(bCancel);
		this.add(topPanel,BorderLayout.CENTER);
		this.add(buttonPanel,BorderLayout.SOUTH);

		addListener();

		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	public void addListener()
	{
		bYes.addActionListener(new AlarmActionListener(this));
		bCancel.addActionListener(new AlarmActionListener(this));
	}

	public String returnTime()
	{
		return tTime.getText();
	}
	public String returnMin()
	{
		return tMin.getText();
	}
	class AlarmActionListener implements ActionListener
	{
		private Alarm alarm;

		public AlarmActionListener(){}
		public AlarmActionListener(Alarm alarm)
		{
			this.alarm = alarm;
		}
		public void actionPerformed(ActionEvent e)
		{
			JButton btn = (JButton)e.getSource();
			if(btn.getText().equals("확인"))
			{
				alarm.setVisible(false);
				alarm.dispose();
			}
			else if(btn.getText().equals("취소"))
			{
				alarm.dispose();
			}
		}
	}
}