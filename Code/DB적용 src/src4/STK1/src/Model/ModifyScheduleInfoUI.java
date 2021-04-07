package Model;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FileDialog;
import java.util.Date;
import java.awt.image.*;

public class ModifyScheduleInfoUI extends JDialog 
{
	private JTextField titleTxf;//���� ����
	private JTextField placeTxf;//���
	private JTextArea memoTxa;//�޸�
	private JButton startBtn;//�������� ��ư
	private JButton endBtn;//�������� ��ư
	private JButton alarmBtn;//�˶� ��ư
	private JButton imageBtn;//�̹��� ��ư
	private JButton confirmBtn;
	private JButton cancelBtn;

	private FileDialog fileDialog;
	private JPanel panel;
	private GridBagConstraints c;
	private JLabel imageInputLb;//�̹���
	private Alarm alarm;
	private String tTime;//�˶� �ð�
	private String tMin;//�˶� ��

	private Date startDate;//��������(����Ͻð���)
	private Date endDate;//��������
	private JComboBox<String> typeCmb;//���� ����

	private JMyCalendar jMyCalendar;//���� �޷�
	private JMyCalendar jMyCalendar2;//���� �޷�

	private String modifyScheduleCode;
	private String modifyScheduleName;

	private ModifyScheduleInfoUI modifyScheduleInfoUI;
	private DailySchedule dailySchedule;



	public ModifyScheduleInfoUI(String title)
	{
		setTitle(title);
		setModal(true);
	}
	public ModifyScheduleInfoUI()
	{
		setTitle("�����ϱ�");
		setModal(true);
	}

	public ModifyScheduleInfoUI(DailySchedule dailySchedule)
	{
      this.dailySchedule = dailySchedule;
      //this.modifyScheduleInfoUI = modifyScheduleInfoUI;
      //this.modifyScheduleCode = modifyScheduleCode;
      //this.modifyScheduleName = modifyScheduleName;
      

      setTitle("�����ϱ�");
      setModal(true);
      jMyCalendar = new JMyCalendar(this,"��������");
      jMyCalendar2 = new JMyCalendar(this,"��������");
	}


	public void setDailySchedule(DailySchedule dailySchedule){
		this.dailySchedule = dailySchedule;
	}


	public void display()
	{
		addComponent();
		setModal(true);
		setPreferredSize(new Dimension(310,530));
		setLocation(400,50);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void addComponent()
	{
		imageInputLb = new JLabel();

		JLabel sectionLb = new JLabel("���� �����ϱ�",JLabel.CENTER);//���� �߰��ϱⰡ �ƴ� parameter�� �޾Ƽ� set�ϱ�
		JLabel titleLb = new JLabel("��������",JLabel.CENTER);
		JLabel typeLb = new JLabel("��������",JLabel.CENTER);
		JLabel startLb = new JLabel("��������",JLabel.CENTER);
		JLabel endLb = new JLabel("��������",JLabel.CENTER);
		JLabel placeLb = new JLabel("���",JLabel.CENTER);
		JLabel memoLb = new JLabel("�޸�",JLabel.CENTER);
		JLabel alarmLb = new JLabel("�˶�",JLabel.CENTER);
		JLabel imageLb = new JLabel("�̹���",JLabel.CENTER);
		
		//JPanel secionIcnPanel = new JPanel(new ImageIcon("Icon/add.png"));
		//ImageIcon sectionIcn = new ImageIcon("Icon/add.png");//�°���?
		JLabel sectionIcn = new JLabel(new ImageIcon("Icon/edit.png"));
		Container contentPane = getContentPane();
		panel = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		JPanel buttonPanel = new JPanel(new FlowLayout());
		
		//���� ������
		c.insets = new Insets(5,5,5,5);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 1;
		panel.add(sectionIcn,c);

		//���� ��
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.weightx = 1;
		//sectionLb.Component.CENTER_ALIGNMENT;
		//sectionLb.labelFor.CENTER_ALIGNMENT;
		sectionLb.setPreferredSize(new Dimension(200,37));
		sectionLb.setOpaque(true);
		sectionLb.setBackground(new Color(221,217,195));
		panel.add(sectionLb ,c);

		//���� ��
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		titleLb.setPreferredSize(new Dimension(65,30));
		titleLb.setOpaque(true);
		titleLb.setBackground(new Color(221,217,195));
		panel.add(titleLb ,c);

		//���� �ؽ�Ʈ �ʵ�
		titleTxf = new JTextField();
		titleTxf.setText(modifyScheduleName);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(titleTxf ,c);

		//���� ���� ��
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.weightx = 1;
		typeLb.setPreferredSize(new Dimension(65,30));
		typeLb.setOpaque(true);
		typeLb.setBackground(new Color(221,217,195));
		panel.add(typeLb, c);

		//���� ���� JComboBox
		String[] typeList = {"�ް�","�̷�","�ǽ�","�޽�","�","���� ���� �ܰ�","�������̽� �м��ܰ�",
			"Ŭ���� �м��ܰ�","Ŭ���� ����ܰ�","Ŭ���� �� ����ܰ�","�ҽ��ڵ� �� ����� �ܰ�","�����۾� �� ��ǥ�غ�ܰ�",
			"���� �Ϸ� �ܰ�","����","��ȥ �����"};
		typeCmb = new JComboBox<String>(typeList);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 3;
		c.weightx = 1;
		panel.add(typeCmb, c);

		//�������� ��
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 1;
		startLb.setPreferredSize(new Dimension(65,30));
		startLb.setOpaque(true);
		startLb.setBackground(new Color(221,217,195));
		panel.add(startLb ,c);
		
		//�������� ��ư
		//startBtn = new JButton(new ImageIcon("Icon/calendar.png"));
		Image calImg = new ImageIcon("Icon/calendar.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		//startBtn = new JButton((ImageIcon)img);
		//Image img = new Image("Icon/calendar.png").getImage().getScaledInstance(25,30,Image.SCALE_DEFAULT);
		ImageIcon startBtnImg = new ImageIcon(calImg);
		startBtn = new JButton(startBtnImg);
		//startBtn = new JButton(new ImageIcon("Icon/calendar.png").getImage().getScaledInstance(25,30,Image.SCALE_DEFAULT));
		//startBtn = new JButton(new Image("Icon/calendar.png").getScaledInstance(25,30,Image.SCALE_DEFAULT));
		startBtn.setPreferredSize(new Dimension(25,35));
		//Image startBtnImg = new ImageIcon("Icon/calendar.png").getImage().getScaledInstance(25,30,SCALE_DEFAULT);
		startBtn.setOpaque(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setBorderPainted(false);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 1;
		panel.add(startBtn ,c);
		
		//�������� ��
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 1;
		endLb.setPreferredSize(new Dimension(65,30));
		endLb.setOpaque(true);
		endLb.setBackground(new Color(221,217,195));
		panel.add(endLb ,c);
		
		//�������� ��ư
		//endBtn = new JButton(new ImageIcon("Icon/calendar.png"));
		//ImageIcon startBtnImg = new ImageIcon(calImg);
		endBtn = new JButton(new ImageIcon(calImg));
		endBtn.setPreferredSize(new Dimension(25,35));
		endBtn.setOpaque(false);
		endBtn.setContentAreaFilled(false);
		endBtn.setBorderPainted(false);
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 1;
		panel.add(endBtn ,c);
		
		//��� ��
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.weightx = 1;
		placeLb.setPreferredSize(new Dimension(65,30));
		placeLb.setOpaque(true);
		placeLb.setBackground(new Color(221,217,195));
		panel.add(placeLb ,c);
		
		//��� �ؽ�Ʈ �ʵ�
		placeTxf = new JTextField();
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 3;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(placeTxf ,c);

		//�޸� ��
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 4;
		c.weightx = 1;
		memoLb.setPreferredSize(new Dimension(65,30));
		memoLb.setOpaque(true);
		memoLb.setBackground(new Color(221,217,195));
		panel.add(memoLb, c);

		//��area�� ���� panel
		//�޸� �ؽ�Ʈ area
		memoTxa = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(memoTxa);
		//JPanel memoPanel = new JPanel();
		//memoPanel.add(memoTxa, BorderLayout.CENTER);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 4;
		scrollPane.setPreferredSize(new Dimension(70,70));
		//c.gridheight = 3;
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.fill = GridBagConstraints.VERTICAL;
		c.weightx = 1;
		//c.weighty = 2;
		panel.add(scrollPane, c);


		//�˶� ��
		c.gridx = 0;
		c.gridy = 8;
		c.weightx = 1;
		c.fill = GridBagConstraints.NONE;
		alarmLb.setPreferredSize(new Dimension(65,30));
		alarmLb.setOpaque(true);
		alarmLb.setBackground(new Color(221,217,195));
		panel.add(alarmLb, c);

		//�˶� ��ư
		//alarmBtn = new JButton(new ImageIcon("Icon/alarm.png"));
		alarmBtn = new JButton(new ImageIcon(new ImageIcon("Icon/alarm.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)));
		alarmBtn.setPreferredSize(new Dimension(35,35));
		alarmBtn.setOpaque(false);
		alarmBtn.setContentAreaFilled(false);
		alarmBtn.setBorderPainted(false);
		c.gridx = 1;
		c.gridy = 8;
		c.weightx = 3;
		c.fill = GridBagConstraints.NONE;
		panel.add(alarmBtn, c);

		//�̹��� ��
		c.gridx = 0;
		c.gridy = 9;
		c.weightx = 1;
		imageLb.setPreferredSize(new Dimension(65,30));
		imageLb.setOpaque(true);
		imageLb.setBackground(new Color(221,217,195));
		panel.add(imageLb, c);

		//�̹��� ��ư
		//imageBtn = new JButton(new ImageIcon("Icon/image.png"));
		imageBtn = new JButton(new ImageIcon(new ImageIcon("Icon/image.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)));
		imageBtn.setPreferredSize(new Dimension(35,35));
		//imageBtn.setBackground(Color.getTransparency());
		imageBtn.setOpaque(false);
		imageBtn.setContentAreaFilled(false);
		imageBtn.setBorderPainted(false);
		c.gridx = 1;
		c.gridy = 9;
		c.weightx = 1;
		c.fill = GridBagConstraints.NONE;
		panel.add(imageBtn, c);

		//Ȯ�ι�ư
		confirmBtn = new JButton("Ȯ��");
		
		//��ҹ�ư
		cancelBtn = new JButton("���");

		buttonPanel.add(confirmBtn);
		buttonPanel.add(cancelBtn);


		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		addListener();
	}

	public void addListener()
	{
		/*
		private JButton startBtn;
		private JButton endBtn;
		private JButton alarmBtn;
		private JButton imageBtn;
		private JButton confirmBtn;
		private JButton cancelBtn;
		*/
		
		confirmBtn.addActionListener(new ModifyScheduleActionListener(this));
		cancelBtn.addActionListener(new ModifyScheduleActionListener(this));
		alarmBtn.addActionListener(new ModifyScheduleActionListener(this));
		imageBtn.addActionListener(new ModifyScheduleActionListener(this));
		startBtn.addActionListener(new ModifyScheduleActionListener(this));
		endBtn.addActionListener(new ModifyScheduleActionListener(this));
	}

	public void setImgFile()
	{
		String fileName = fileDialog.getFile();//���õ� �ĸ� �̸�
		String fileDirectory = fileDialog.getDirectory();//���õ� ������ ���
		System.out.println(fileName);
		//if(fileName.equals(null))
		//	return;
		System.out.println(fileDirectory);

		//�̹����� �а��ؾ���

		//�̹��� ���� ��
		//Icon icon = new ImageIcon(new ImageIcon(""+fileDirectory+fileName).getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT));
		//JLabel imageInputLb = new JLabel();
		//imageInputLb.setIcon(icon);
		//Image image = new ImageIcon(""+fileDirectory+fileName).getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT);
		//Icon icon = new ImageIcon(new ImageIcon(""+fileDirectory+fileName).getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT));

		//panel.remove(imageInputLb);
		//imageInputLb = new JLabel();
		//imageInputLb.setIcon(icon);

		panel.remove(imageInputLb);
		imageInputLb = new JLabel(new ImageIcon(new ImageIcon(""+fileDirectory+fileName).getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT)));

		c.gridx = 0;
		c.gridy = 10;
		c.weightx = 1;
		imageInputLb.setPreferredSize(new Dimension(250,150));
		panel.add(imageInputLb, c);
		//imageInputLb.setSize(new Dimension(310,700));
		super.setBounds(400, 50, 310, 675);
		super.setBounds(400, 50, 310, 676);
	}

	public void modifyScheduleInfo()//controller�� ����
	{
		/*String kind = (String)typeCmb.getSelectedItem();//��������
      String title = titleTxf.getText();//��������
      int startYear = startDate.getYear();//��������
      int startMonth = startDate.getMonth();
      int startDay = startDate.getDay();
      int startHour = startDate.getHours();
      int startMin = startDate.getMinutes();
      int endYear = endDate.getYear();//��������
      int endMonth = endDate.getMonth();
      int endDay = endDate.getDay();
      int endHour = endDate.getHours();
      int endMin = endDate.getMinutes();
      String place = placeTxf.getText();//���
      String memo = memoTxa.getText();//�޸�
      //int alarmHour = tTime;//�׳� �ٷ� tTime/tMin���
      //int alarmMin = tMin;
      String image = ""+fileDialog.getFile()+fileDialog.getDirectory();//�̹��� ���
      //ImageIcon imageIcon = imageInputLb.getIcon().getImage();//�̹��� ��ü//(���X)
      //Icon icon = imageInputLb.getIcon();
      //BufferedImage imageIcon = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
      */


     String kind = (String)typeCmb.getSelectedItem();//��������
      String title = titleTxf.getText();//��������
      int startYear;//��������
      int startMonth;
      int startDay;
      int startHour;
      int startMin;
      int endYear;//��������
      int endMonth;
      int endDay;
      int endHour;
      int endMin;
      if(startDate != null)
      {
         startYear = startDate.getYear();//��������
         startMonth = startDate.getMonth();
         startDay = startDate.getDay();
         startHour = startDate.getHours();
         startMin = startDate.getMinutes();
         
       System.out.println("�������� ������!!");
         System.out.println(startYear);//Ȯ��
         System.out.println(startMonth);
         System.out.println(startDay);
         System.out.println(startHour);
         System.out.println(startMin);
      }
      if(endDate != null)
      {
         endYear = endDate.getYear();//��������
         endMonth = endDate.getMonth();
         endDay = endDate.getDay();
         endHour = endDate.getHours();
         endMin = endDate.getMinutes();
 
       System.out.println("�������� ������!!");
         System.out.println(endYear);
         System.out.println(endMonth);
         System.out.println(endDay);
         System.out.println(endHour);
         System.out.println(endMin);
      }
      String place = placeTxf.getText();//���
      String memo = memoTxa.getText();//�޸�
      //int alarmHour = tTime;//�׳� �ٷ� tTime/tMin���
      //int alarmMin = tMin;
      String image = "null image";
      if(fileDialog != null)
      {
         System.out.println("Ȯ��Ȯ��");
         image = ""+fileDialog.getDirectory()+fileDialog.getFile();//�̹��� ���
         System.out.println(image);
      }
      else
         System.out.println("�̹��� �ֿ�");



      //Ȯ��
      System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
      System.out.println(kind);
      System.out.println(title);
      
      System.out.println(place);
      System.out.println(memo);
      
      if(alarm != null)
      {
         System.out.println(tTime);
         System.out.println(tMin);
      }
     Date alarmTemp = new Date(0000,11,22,Integer.parseInt(tTime), Integer.parseInt(tMin));
     //scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image
    
     this.modifyScheduleCode=dailySchedule.getCodeOfModify();
     this.modifyScheduleName=dailySchedule.getNameOfModify();
     
     System.out.println("Modify!!!!!!!!!!!!!!!!!==============");
     System.out.println(modifyScheduleCode);
     //�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�controller����κФѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�//
      ModifyScheduleInfoController modifyController = new ModifyScheduleInfoController();
     //modifyController.modifyScheduleInfo(modifyScheduleCode, kind, title, startDate, endDate, place, memo, alarmTemp, image);
	 modifyController.modifyScheduleInfoToDB(modifyScheduleCode, kind, title, startDate, endDate, place, memo, alarmTemp, image);
	}



	public void getCalendarInfo(String division, String year, String month, int day, String hour, String min)
	{
      //�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ��߰��ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�//
      int monthNum=0;
      if(month.equals("January"))
         monthNum=1;
      else if(month.equals("Fabruary"))
         monthNum=2;
      else if(month.equals("March"))
         monthNum=3;
      else if(month.equals("April"))
         monthNum=4;
      else if(month.equals("May"))
         monthNum=5;
      else if(month.equals("June"))
         monthNum=6;
      else if (month.equals("July"))
      {
         monthNum=7;
      }
      else if (month.equals("August"))
      {
         monthNum=8;
      }
      else if (month.equals("September"))
      {
         monthNum=9;
      }
      else if (month.equals("October"))
      {
         monthNum=10;
      }
      else if (month.equals("November"))
      {
         monthNum=11;
      }
      else if (month.equals("December"))
      {
         monthNum=12;
      }
      if(division.equals("��������"))
      {
         startDate = new Date(Integer.parseInt(year), monthNum-1, day, Integer.parseInt(hour), Integer.parseInt(min));
      }
      else if(division.equals("��������"))
      {
         endDate = new Date(Integer.parseInt(year), monthNum-1, day, Integer.parseInt(hour), Integer.parseInt(min));
      }
     
		System.out.println("�ѤѤѼ����ϱ� â�ѤѤ�");
		System.out.println(division);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(min);
	}




	class ModifyScheduleActionListener implements ActionListener
   {
      private ModifyScheduleInfoUI baseUI;
      public ModifyScheduleActionListener(){}
      public ModifyScheduleActionListener(ModifyScheduleInfoUI baseUI)
      {
         this.baseUI = baseUI;
      }
      public void actionPerformed(ActionEvent e)
      {
         JButton btn = (JButton)e.getSource();
         if(btn.getText().equals("Ȯ��"))
         {
            modifyScheduleInfo();
            baseUI.dispose();
         }
         else if(btn.getText().equals("���"))
         {
            baseUI.dispose();
         }
         else if(btn == startBtn)
         {
            jMyCalendar.display();
         }
         else if(btn == endBtn)
         {
            jMyCalendar2.display();
         }
         else if(btn == alarmBtn)
         {
            //new Alarm().set();
            alarm = new Alarm();
            alarm.set();
            tTime = alarm.returnTime();
            tMin = alarm.returnMin();
            System.out.println(tTime);
            System.out.println(tMin);
         }
         else if(btn == imageBtn)
         {
            readImgFile();
         }   
      }

      public void readImgFile()
      {
         fileDialog = new FileDialog(baseUI, "�̹��� ����", 0);//load?
         fileDialog.setVisible(true);
         setImgFile();
      }
   }
}