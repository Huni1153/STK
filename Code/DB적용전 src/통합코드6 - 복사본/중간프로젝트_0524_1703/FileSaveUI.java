import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FileSaveUI extends JDialog
{
	private JPanel topPanel,centerPanel,bottumPanel;
	private JLabel lTitle,lFileName,lFileType;
	private JTextField tFileName;
	private JComboBox cFileType;
	private JButton bSave,bCancel;
	private GridBagConstraints c;
	private StringBuilder leftArea,rightArea;

	public FileSaveUI(StringBuilder left,StringBuilder right)
	{
		this.setTitle("�����ϱ�");
		this.setModal(true);
		this.setPreferredSize(new Dimension(400,200));
		this.setLocation(600,100);
		
		this.leftArea=left;
		this.rightArea=right;

		this.topPanel=new JPanel();
		this.centerPanel=new JPanel(new GridBagLayout());
		this.bottumPanel=new JPanel();
		this.c=new GridBagConstraints();
		this.lTitle=new JLabel("���� �����ϱ�");
		this.lFileName=new JLabel("���� �̸� : ");
		this.lFileType=new JLabel("���� ���� : ");
		this.tFileName=new JTextField(17);
		String[] fileType={"Java(*.java)","Text(*.txt)"};
		this.cFileType=new JComboBox(fileType);
		this.bSave=new JButton("����");
		this.bCancel=new JButton("���");
	}
	public void set()
	{
		this.topPanel.add(this.lTitle);

		c.insets=new Insets(5,5,5,5);
		c.gridx=0;
		c.gridy=0;
		this.centerPanel.add(this.lFileName,c);

		c.gridx=2;
		this.centerPanel.add(this.tFileName,c);

		c.gridx=0;
		c.gridy=1;
		this.centerPanel.add(this.lFileType,c);

		c.gridx=2;
		c.gridy=1;
		c.fill=GridBagConstraints.HORIZONTAL;
		this.cFileType.setPreferredSize(new Dimension(190,30));
		this.centerPanel.add(this.cFileType,c);

		this.bottumPanel.add(this.bSave);
		this.bottumPanel.add(this.bCancel);
		this.listener();

		this.add(this.topPanel,BorderLayout.NORTH);
		this.add(this.centerPanel,BorderLayout.CENTER);
		this.add(this.bottumPanel,BorderLayout.SOUTH);
		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	public void listener()
	{
		this.bSave.addActionListener(new FileSavaListener());
		this.bCancel.addActionListener(new FileSavaListener());
	}

	class FileSavaListener implements ActionListener
	{
		public FileSavaListener()
		{
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==bSave)
			{
				reMake();
			}
			else
			{
				setVisible(false);
				//dispose(true);
			}
		}
		public void reMake()
		{
			int year,month,day,hour,min;

			Calendar obj=new GregorianCalendar();

			year=obj.get(Calendar.YEAR);
			month=1+obj.get(Calendar.MONTH);
			day=obj.get(Calendar.DATE);
			hour=obj.get(Calendar.HOUR);
			min=obj.get(Calendar.MINUTE);
			
			System.out.println(year+"��"+month+"��"+day+"��"+hour+"��"+min+"��");
			System.out.println("���� �̸� : "+tFileName.getText());
			System.out.println("���� ���� : "+(String)cFileType.getSelectedItem());
			if(((String)cFileType.getSelectedItem()).equals("Java(*.java)"))
			{
				System.out.println("���� ���� : "+tFileName.getText()+".java");
			}
			else
			{
				System.out.println("���� ���� : "+tFileName.getText()+".text");
			}
			System.out.println("�ڵ� : "+leftArea);
			System.out.println("�ּ� : "+rightArea);
		}
	}
}