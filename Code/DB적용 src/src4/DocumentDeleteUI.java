import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class DocumentDeleteUI extends JDialog
{
//////////////////////////////����1
	private JPanel leftPanel,topPanel,centerPanel,bottumPanel;
	private JLabel sLocationLabel,fileName,fileType,tempLabel;
	private JComboBox sLocationBox,fileNameBox,fileTypeBox;
	private JButton button1,button2,button3,button4,buttin5;
	private JButton icon1,icon2,icon3,icon4;
	private JButton bDelete,bCancel;
	private GridBagConstraints c;
	private JScrollPane scrollPane1,scrollPane2;
	final private JTable table = new JTable();
	//private JTable table;
	private DefaultTableModel model;
	final private JTextField fileNameText = new JTextField();


	private String[] documentDirectoryList;

///////////////����1
	//private SimpleDayDocumentController simpleDayDocumentController;
	//private String[][] simpleDayDocumentList;


	private String state = "";
	private String[][] simpleDayDocumentList;
	private SimpleDayDocumentController simpleDayDocumentController;
//////////////����1

	final private String [] name={"���� �̸�"};


	


	public DocumentDeleteUI (String fileName)
	{
		//super( fileName);
		//table = new JTable(0,name);
////////////// 0513_�뼷
		documentDirectoryList = new GetDocumentDirectoryListController().getDirectoryList();	// �ҷ����⸦ ���� ��Ʈ�ѷ�

////////////// 0513_�뼷

		this.setTitle(fileName);
		//this.setModal(true);
		this.leftPanel=new JPanel(new GridBagLayout());
		this.c=new GridBagConstraints();
		this.setPreferredSize(new Dimension(800,550));
		this.setLocation(350,200);

		this.sLocationLabel=new JLabel("    ã�� ��ġ(I):");

		
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


//////////////////////////////����1
		this.topPanel=new JPanel(new GridBagLayout());
		//String [] str={"a","b","c","d"};
		this.sLocationBox=new JComboBox(documentDirectoryList);
		sLocationBox.setSelectedItem(documentDirectoryList[0]);
		this.scrollPane1=new JScrollPane(sLocationBox);



		Image calImg=new ImageIcon("Icon/Left Arrow").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		image=new ImageIcon(calImg);
		this.icon1=new JButton(image);
		this.icon2=new JButton("Icon/Open In Browser-64");
		calImg=new ImageIcon("Icon/Left Arrow").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		image=new ImageIcon(calImg);
		this.icon3=new JButton("Icon/Add Folder-64");
		this.icon4=new JButton("Icon/Content-64");

//////////////////////////////����1
		/*this.centerPanel=new JPanel(new GridBagLayout());
		String [] name={"���� �̸�"};
		this.model=new DefaultTableModel(name,0);
		this.table=new JTable(model);*/

		this.bottumPanel=new JPanel(new GridBagLayout());
		this.fileName=new JLabel("���� �̸�(N):");
		this.fileType=new JLabel("���� ����(T):");
		this.fileNameBox=new JComboBox();
		this.fileTypeBox=new JComboBox();
		this.bDelete=new JButton("����(X)");
		this.bCancel=new JButton("  �� ��  ");


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
		this.sLocationBox.setPreferredSize(new Dimension(400,30));
		this.topPanel.add(this.sLocationBox);
		
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

//////////////////////////////����1
		
		c.insets=new Insets(5,5,5,5);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		this.bottumPanel.add(this.fileName,c);

		c.gridx=2;
		fileNameText.setPreferredSize(new Dimension(400,30));
		//this.fileNameBox.setPreferredSize(new Dimension(400,30));
		this.bottumPanel.add(this.fileNameText,c);

		c.gridx=4;
		c.gridwidth=2;
		//c.weightx=0.1;
		this.bottumPanel.add(this.bDelete,c);

		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
///////////////����1///////////////����1
		//this.bottumPanel.add(this.fileType,c);
		
		c.gridx=2;
///////////////����1///////////////����1
		//this.fileTypeBox.setPreferredSize(new Dimension(400,30));
		//this.bottumPanel.add(this.fileTypeBox,c);

		c.gridx=4;
		c.gridwidth=2;
		//c.weightx=0.1;
		this.bottumPanel.add(this.bCancel,c);

		FileLoadUIListener openListener = new FileLoadUIListener();
		bDelete.addActionListener(openListener);
		bCancel.addActionListener(openListener);

////////////////////////////////////////����

		DirectroyChangedListener dirListen = new DirectroyChangedListener(this);
		sLocationBox.addItemListener(dirListen);
////////////////////////////////////////����

////////////////////////////////////////
		/*scrollPane2=new JScrollPane(table);
		this.scrollPane2.setPreferredSize(new Dimension(600,300));
		this.centerPanel.add(scrollPane2);*/


		//add(centerPanel,BorderLayout.CENTER);
////////////////////////////////////////////
		
		this.add(leftPanel,BorderLayout.WEST);
		this.add(topPanel,BorderLayout.NORTH);
		this.add(bottumPanel,BorderLayout.SOUTH);
		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	class FileLoadUIListener implements ActionListener
	{
		//private JDialog dialog;
		public void FileLoadUIListener() {}
		/*
		public void FileLoadUIListener(JDialog dialog)
		{
			this.dialog = dialog;
		}*/
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==bDelete)
			{
				//����
				//System.out.println( table.getSelectedRow() );
				//table.getValueAt( table.getSelectedRow(), 0);

				//System.out.println( simpleDayDocumentList[table.getSelectedRow()][0] );
//////////////////////////////����1

				if( table.getSelectedRow() < 0 )
				{
					JOptionPane.showMessageDialog(null,"������ �����ϼ���", "ERROR", JOptionPane.ERROR_MESSAGE); 
				}
				else
				{
					DeleteStudyDocumentInfoController delete=new DeleteStudyDocumentInfoController();
					delete.deleteStudyDocumentInfo(simpleDayDocumentList[table.getSelectedRow()][0],state);
					//// 0531_1700 ���ƽ���
					delete.deleteStudyDocumentInfoToDB(simpleDayDocumentList[table.getSelectedRow()][0]);
					//// 0531_1700 ���ƽ���
					JOptionPane.showMessageDialog(null,"���� �Ǿ����ϴ�.", "DELETE", JOptionPane.INFORMATION_MESSAGE);
				}
				//stkProjectTextUI.toFront();
				//stkProjectTextUI.setState(Frame.NORMAL);

				//dialog.dispose();
//////////////////////////////����1
			}
			else if(e.getSource()==bCancel)
			{
				//���
				dispose();
			}
		}
	}


//////////////////////////////����1
	class DirectroyChangedListener implements ItemListener
	{
		private JDialog openDialog;

		public DirectroyChangedListener(JDialog openDialog)
		{
			this.openDialog =  openDialog;
		}

		public void itemStateChanged(ItemEvent itemEvent) {
			/*
			int state = itemEvent.getStateChange();
        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
        System.out.println("Item: " + itemEvent.getItem());
        ItemSelectable is = itemEvent.getItemSelectable();
        System.out.println(", Selected: " + selectedString(is));*/
			//JComboBox comboBox = (JComboBox) itemEvent.getSource();
			state = (String)sLocationBox.getSelectedItem();
			System.out.println(state);

			//SimpleDayDocumentController simpleDayDocumentController = new SimpleDayDocumentController();
			simpleDayDocumentController = new SimpleDayDocumentController();
			//String[][] simpleDayDocumentList = simpleDayDocumentController.getSimpleDayDocument(state);
			simpleDayDocumentList = simpleDayDocumentController.getSimpleDayDocument(state);

			String[][] data = new String[simpleDayDocumentList.length][1];
			for(int i=0; i<data.length; i++)
			{
				data[i][0] = simpleDayDocumentList[i][1]+".java";
				System.out.println(data[i][0]);
			}

			centerPanel=new JPanel();
			//String [] name={"���� �̸�"};
			model=new DefaultTableModel(data, name);
			//table=new JTable(model);
			table.setModel(model);

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
				public void valueChanged(ListSelectionEvent e){
					if(e.getValueIsAdjusting()){
						ListSelectionModel model = table.getSelectionModel();  
						int lead = model.getLeadSelectionIndex(); 
						displayRowValues(lead);
					}
				}
				private void displayRowValues(int rowIndex){
					String country = "";   
					Object oCountry = table.getValueAt(rowIndex, 0);  
					country += oCountry.toString();
					fileNameText.setText(country );
				}
			});

			scrollPane2=new JScrollPane(table);
			scrollPane2.setPreferredSize(new Dimension(650,380));
			centerPanel.add(scrollPane2);


			openDialog.add(centerPanel,BorderLayout.CENTER);

			//scrollPane2.revalidate();
			centerPanel.revalidate();
			//openDialog.revalidate();
			//System.out.println(state);
		}
	}


////////////////////////����2

	/*
	public static void main(String [] args)
	{
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style â
		}catch(Exception e){
			e.printStackTrace();
		}
		FileLoadUI obj=new FileLoadUI("�ҷ� ����");
		obj.set();
	}*/
}