//�ӽ� Ŭ���� JFrame
//��ư ���̴� �ڵ�
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
		button = new JButton("Ȯ��");
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
