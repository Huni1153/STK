//임시 클래스 JFrame
//버튼 붙이는 코드
//addSchedule = new JButton(new ImageIcon("Icon/schedule.png"));
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class BaseUI extends JFrame
{
	private AddScheduleInfoUI addScheduleInfoUI;
	private JButton button;

	public BaseUI()
	{
		super("base frame");
		addScheduleInfoUI = new AddScheduleInfoUI();
	}
	public void display()
	{
		addComponent();
		setPreferredSize(new Dimension(100,200));
		setLocation(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void addComponent()
	{
		button = new JButton("확인");
		Container contentPane = getContentPane();
		contentPane.add(button, BorderLayout.CENTER);
		addListener();
	}
	public void addListener()
	{
		button.addActionListener(new ConfirmActionListener());
	}
	class ConfirmActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			addScheduleInfoUI.display();
		}
	}
}
