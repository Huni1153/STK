import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class FileLoadUI extends JDialog
{
	private JPanel leftPanel,topPanel,centerPanel,bottumPanel;
	private JLabel sLocationLabel,fileName,fileType,tempLabel;
	private JComboBox sLocationBox,fileNameBox,fileTypeBox;
	private JButton button1,button2,button3,button4,buttin5;
	private JButton icon1,icon2,icon3,icon4;
	private JButton bOpen,bCancel;
	private GridBagConstraints c;
	private JScrollPane scrollPane1,scrollPane2;
	private JTable table;
	private DefaultTableModel model;

////////////// 0513_대섭
	private String[] documentDirectoryList;

///////////////0513_대섭

	public FileLoadUI(String fileName)
	{
////////////// 0513_대섭
		documentDirectoryList = new GetDocumentDirectoryListController().getDirectoryList();	// 불러오기를 위한 컨트롤러

////////////// 0513_대섭

		this.setTitle(fileName);
		this.setModal(true);
		this.leftPanel=new JPanel(new GridBagLayout());
		this.c=new GridBagConstraints();
		this.setPreferredSize(new Dimension(800,550));
		this.setLocation(500,200);

		this.sLocationLabel=new JLabel("    찾는 위치(I):");

		
		ImageIcon image=new ImageIcon("Icon/Timer.png");
		this.button1=new JButton(image);
		//this.button1.setOpaque(false);
		//this.button1.setContentAreaFilled(false);
		//this.button1.setBorderPainted(false);
		
		image=new ImageIcon("Icon/Windows Client Filled2.png");
		this.button2=new JButton(image);
		image=new ImageIcon("Icon/Courses.png");
		this.button3=new JButton(image);
		image=new ImageIcon("Icon/Workstation2.png");
		this.button4=new JButton(image);
		this.tempLabel=new JLabel("");

		this.topPanel=new JPanel(new GridBagLayout());
		//String [] str={"a","b","c","d"};
		this.sLocationBox=new JComboBox(documentDirectoryList);
		this.scrollPane1=new JScrollPane(sLocationBox);
		Image calImg=new ImageIcon("Icon/Left Arrow").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		image=new ImageIcon(calImg);
		this.icon1=new JButton(image);
		this.icon2=new JButton("Icon/Open In Browser-64");
		calImg=new ImageIcon("Icon/Left Arrow").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		image=new ImageIcon(calImg);
		this.icon3=new JButton("Icon/Add Folder-64");
		this.icon4=new JButton("Icon/Content-64");

		this.centerPanel=new JPanel(new GridBagLayout());
		String [] name={"파일 이름"};
		this.model=new DefaultTableModel(name,0);
		this.table=new JTable(model);

		this.bottumPanel=new JPanel(new GridBagLayout());
		this.fileName=new JLabel("파일 이름(N):");
		this.fileType=new JLabel("파일 형식(T):");
		this.fileNameBox=new JComboBox();
		this.fileTypeBox=new JComboBox();
		this.bOpen=new JButton("열기(O)");
		this.bCancel=new JButton("  취 소  ");


	}
	public void set()
	{

		
		c.insets=new Insets(5,5,5,5);

		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		this.topPanel.add(sLocationLabel,c);

		c.gridx=3;
		this.sLocationBox.setOpaque(true);
		this.sLocationBox.setBackground(Color.WHITE);
		this.scrollPane1.setPreferredSize(new Dimension(400,30));
		this.topPanel.add(this.scrollPane1,c);
		
		c.gridx=5;
		this.icon1.setPreferredSize(new Dimension(30,30));
		this.topPanel.add(this.icon1,c);

		c.gridx=7;
		this.icon2.setPreferredSize(new Dimension(30,30));
		this.topPanel.add(this.icon2,c);

		c.gridx=9;
		this.icon3.setPreferredSize(new Dimension(30,30));
		this.topPanel.add(this.icon3,c);

		c.gridx=11;
		this.icon4.setPreferredSize(new Dimension(30,30));
		this.topPanel.add(this.icon4,c);

		c.gridx=13;
		this.topPanel.add(new JLabel("              "),c);

		c.gridx=15;
		this.topPanel.add(new JLabel("              "),c);

		c.insets=new Insets(10,10,10,10);

		c.gridx=0;
		c.gridy=0;
		this.button1.setPreferredSize(new Dimension(100,70));
		this.leftPanel.add(this.button1,c);

		c.gridy=1;
		this.button1.setPreferredSize(new Dimension(100,70));
		this.leftPanel.add(this.button1,c);

		c.gridy=2;
		this.button2.setPreferredSize(new Dimension(100,70));
		this.leftPanel.add(this.button2,c);

		c.gridy=3;
		this.button3.setPreferredSize(new Dimension(100,70));
		this.leftPanel.add(this.button3,c);

		c.gridy=4;
		this.button4.setPreferredSize(new Dimension(100,70));
		this.leftPanel.add(this.button4,c);
	
		c.insets=new Insets(0,0,0,0);
		c.gridx=0;
		c.gridy=0;
		scrollPane2=new JScrollPane(table);
/////////////////////////////////////////////////////////////////
		this.scrollPane2.setPreferredSize(new Dimension(600,300));
		this.centerPanel.add(scrollPane2);
		
		c.insets=new Insets(5,5,5,5);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		this.bottumPanel.add(this.fileName,c);

		c.gridx=2;
		this.fileNameBox.setPreferredSize(new Dimension(400,30));
		this.bottumPanel.add(this.fileNameBox,c);

		c.gridx=4;
		c.gridwidth=2;
		//c.weightx=0.1;
		this.bottumPanel.add(this.bOpen,c);

		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		this.bottumPanel.add(this.fileType,c);
		
		c.gridx=2;
		this.fileTypeBox.setPreferredSize(new Dimension(400,30));
		this.bottumPanel.add(this.fileTypeBox,c);

		c.gridx=4;
		c.gridwidth=2;
		//c.weightx=0.1;
		this.bottumPanel.add(this.bCancel,c);

		this.bOpen.addActionListener(new FileLoadUIListener());
		this.bCancel.addActionListener(new FileLoadUIListener());
		
		this.add(leftPanel,BorderLayout.WEST);
		this.add(topPanel,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		this.add(bottumPanel,BorderLayout.SOUTH);
		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	class FileLoadUIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==bOpen)
			{
				//열기
				setVisible(false);
			}
			else if(e.getSource()==bCancel)
			{
				//취소
				setVisible(false);
			}
		}
	}
	public static void main(String [] args)
	{
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style 창
		}catch(Exception e){
			e.printStackTrace();
		}
		FileLoadUI obj=new FileLoadUI("불러 오기");
		obj.set();
	}
}