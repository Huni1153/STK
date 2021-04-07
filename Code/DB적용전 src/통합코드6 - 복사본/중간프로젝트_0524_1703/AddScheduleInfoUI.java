import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FileDialog;
import java.util.Date;
import java.awt.image.*;

public class AddScheduleInfoUI extends JDialog 
{
   private JTextField titleTxf;
   private JTextField placeTxf;
   private JTextArea memoTxa;
   private JButton startBtn;
   private JButton endBtn;
   private JButton alarmBtn;
   private JButton imageBtn;
   private JButton confirmBtn;
   private JButton cancelBtn;

   private FileDialog fileDialog;
   private JPanel panel;
   private GridBagConstraints c;
   private JLabel imageInputLb;
   private Alarm alarm;
   private String tTime;
   private String tMin;

   private Date startDate;//��������(����Ͻð���)
   private Date endDate;//��������
   private JComboBox<String> typeCmb;//���� ����

   //����1��
   
   private String year;
   private String month;
   private int day;
   private String hour;
   private String min;
	
   private JMyCalendar jMyCalendar;
   private JMyCalendar jMyCalendar2;//��������//���߰�

   /*public AddSchedule InfoUI(String title)
   {
      setTitle(title);
      setModal(true);
   }*/
   public AddScheduleInfoUI()
   {
      setTitle("�߰��ϱ�");
      setModal(true);
      jMyCalendar = new JMyCalendar(this, "��������");
      jMyCalendar2 = new JMyCalendar(this, "��������");
   }
   public void display()
   {
      addComponent();
      setModal(true);
      setPreferredSize(new Dimension(310,530));
      setLocation(400,55);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      pack();
      setVisible(true);
   }
   public void addComponent()
   {
      imageInputLb = new JLabel();

      JLabel sectionLb = new JLabel("���� �߰��ϱ�",JLabel.CENTER);//���� �߰��ϱⰡ �ƴ� parameter�� �޾Ƽ� set�ϱ�
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
      JLabel sectionIcn = new JLabel(new ImageIcon("Icon/add.png"));
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
      Image calImg = new ImageIcon("Icon/calendar.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);

      ImageIcon startBtnImg = new ImageIcon(calImg);
      startBtn = new JButton(startBtnImg);
      startBtn.setPreferredSize(new Dimension(25,35));
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

      //�޸� �ؽ�Ʈ area
      memoTxa = new JTextArea();
      
      JScrollPane scrollPane = new JScrollPane(memoTxa);
      c.gridx = 0;
      c.gridy = 6;
      c.gridwidth = 4;
      scrollPane.setPreferredSize(new Dimension(70,70));
      c.weightx = 1;
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
      imageBtn = new JButton(new ImageIcon(new ImageIcon("Icon/image.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT)));
      imageBtn.setPreferredSize(new Dimension(35,35));
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
      confirmBtn.addActionListener(new AddScheduleActionListener(this));
      cancelBtn.addActionListener(new AddScheduleActionListener(this));
      alarmBtn.addActionListener(new AddScheduleActionListener(this));
      imageBtn.addActionListener(new AddScheduleActionListener(this));
      startBtn.addActionListener(new AddScheduleActionListener(this));
      endBtn.addActionListener(new AddScheduleActionListener(this));
   }

   public void setImgFile()
   {
      String fileName = fileDialog.getFile();//���õ� �ĸ� �̸�
      String fileDirectory = fileDialog.getDirectory();//���õ� ������ ���
      
      panel.remove(imageInputLb);
      imageInputLb = new JLabel(new ImageIcon(new ImageIcon(""+fileDirectory+fileName).getImage().getScaledInstance(250,150,Image.SCALE_DEFAULT)));

      c.gridx = 0;
      c.gridy = 10;
      c.weightx = 1;
      imageInputLb.setPreferredSize(new Dimension(250,150));
      panel.add(imageInputLb, c);
      super.setBounds(300, 20, 310, 675);
      super.setBounds(300, 20, 310, 676);
   }

   public void addScheduleInfo()
   {
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
         startDay = startDate.getDate();
         startHour = startDate.getHours();
         startMin = startDate.getMinutes();
      }
      if(endDate != null)
      {
         endYear = endDate.getYear();//��������
         endMonth = endDate.getMonth();
         endDay = endDate.getDate();
         endHour = endDate.getHours();
         endMin = endDate.getMinutes();
       }
      String place = placeTxf.getText();//���
      String memo = memoTxa.getText();//�޸�
      //int alarmHour = tTime;//�׳� �ٷ� tTime/tMin���
      //int alarmMin = tMin;
      String image = "null image";
      if(fileDialog != null)
      {
         image = ""+fileDialog.getDirectory()+fileDialog.getFile();//�̹��� ���
      }
      else



      if(alarm != null)
      {
         System.out.println(tTime);
         System.out.println(tMin);
      }
	  Date alarmTemp = new Date(0000,11,22,Integer.parseInt(tTime), Integer.parseInt(tMin));
	  AddScheduleInfoSplitController splitController = new AddScheduleInfoSplitController();
	  splitController.splitAndTransfer(kind, title, startDate, endDate, place, memo, alarmTemp, image);
	  
	  System.out.println("split ������~~~~");

   }
   public void getCalendarInfo(String division, String year, String month, int day, String hour, String min)
   {
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
			startDate = new Date(Integer.parseInt(year), monthNum, day, Integer.parseInt(hour), Integer.parseInt(min));
	   }
	   else if(division.equals("��������"))
	   {
			endDate = new Date(Integer.parseInt(year), monthNum, day, Integer.parseInt(hour), Integer.parseInt(min));
	   }
   }

   class AddScheduleActionListener implements ActionListener
   {
      private AddScheduleInfoUI baseUI;
      public AddScheduleActionListener(){}
      public AddScheduleActionListener(AddScheduleInfoUI baseUI)
      {
         this.baseUI = baseUI;
      }
      public void actionPerformed(ActionEvent e)
      {
         JButton btn = (JButton)e.getSource();
         if(btn.getText().equals("Ȯ��"))
         {
            addScheduleInfo();
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
            alarm = new Alarm();
            alarm.set();
            tTime = alarm.returnTime();
            tMin = alarm.returnMin();
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
