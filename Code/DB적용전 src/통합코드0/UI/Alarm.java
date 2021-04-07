import java.awt.*;
import javax.swing.*;

public class Alarm extends JDialog
{
	private JPanel topPanel,bottumPanel;
	private JTextField tTime,tMin;
	private JLabel rTime,rMin;
	private JButton bYes,bCancel;
	
	public Alarm()
	{
		topPanel=new JPanel();
		bottumPanel=new JPanel();
		this.tTime=new JTextField(5);
		this.tMin=new JTextField(5);
		this.rTime=new JLabel("��");
		this.rMin=new JLabel("��");
		this.bYes=new JButton("Ȯ��");
		this.bCancel=new JButton("���");
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
		bottumPanel.add(bYes);
		bottumPanel.add(bCancel);
		this.add(topPanel,BorderLayout.CENTER);
		this.add(bottumPanel,BorderLayout.SOUTH);

		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String [] args)
	{
		Alarm obj=new Alarm();
		obj.set();
	}
}