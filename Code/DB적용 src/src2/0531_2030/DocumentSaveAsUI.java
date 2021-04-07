import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DocumentSaveAsUI extends JDialog
{
	private JPanel topPanel,centerPanel,bottumPanel;
	private JLabel lTitle,lFileName,lFileType;
	private JTextField tFileName;
	private JComboBox cFileType;
	private JButton bSave,bCancel;
	private GridBagConstraints c;
	private StringBuilder leftArea,rightArea;
	private String documentCode,documentDirectory;
	private boolean check;

	public DocumentSaveAsUI(String documentCode,String documentDirectory,StringBuilder left,StringBuilder right)
	{
		this.setTitle("�����ϱ�");
		this.setModal(true);
		this.setPreferredSize(new Dimension(400,200));
		this.setLocation(600,100);
		
		this.documentCode=documentCode;
		this.documentDirectory=documentDirectory;
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
	public boolean set()
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
		return check;
	}
	public void listener()
	{
		this.bSave.addActionListener(new DocumentSaveAsUIListener());
		this.bCancel.addActionListener(new DocumentSaveAsUIListener());
	}

	class DocumentSaveAsUIListener implements ActionListener
	{
		private SaveAsStudyDocumentInfoController saveAsController;
		public DocumentSaveAsUIListener()
		{
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==bSave)
			{
				reMake();
				check=true;
			}
			else
			{
				check=false;
				dispose();
			}
		}
		public void reMake()
		{
			this.saveAsController=new SaveAsStudyDocumentInfoController();
			if(((String)cFileType.getSelectedItem()).equals("Java(*.java)"))
			{
				if(this.saveAsController.createJava(tFileName.getText(),leftArea,rightArea,".java"))
				{
					JOptionPane.showMessageDialog(null,"���� ���� �Ϸ�!", "����", JOptionPane.INFORMATION_MESSAGE);
					if(this.saveAsController.saveAsStudyDocumentInfo(documentCode,tFileName.getText(),documentDirectory,leftArea,rightArea,".java")&& this.saveAsController.saveAsStudyDocumentInfoToDB(documentCode,tFileName.getText(),documentDirectory,leftArea,rightArea))
					{
						JOptionPane.showMessageDialog(null,"���� �Ϸ�!", "��ư", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"���� ����!", "��ư", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"���� ���� ����!", "����", JOptionPane.ERROR_MESSAGE);
					dispose();
				}
				/*if(this.saveController.SaveStudyDocumentInfo("155111001",tFileName.getText(),"15/5/11",leftArea,rightArea,(String)cFileType.getSelectedItem()))
				{
					JOptionPane.showMessageDialog(null,"���� �Ϸ�!", "��ư", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"���� ����!", "��ư", JOptionPane.INFORMATION_MESSAGE);
				}*/
			//	System.out.println("���� ���� : "+tFileName.getText()+".java");
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