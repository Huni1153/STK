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

   private Date startDate;//시작일자(년월일시간분)
   private Date endDate;//종료일자
   private JComboBox<String> typeCmb;//일정 종류

   //수정1차
   
   private String year;
   private String month;
   private int day;
   private String hour;
   private String min;
	
   private JMyCalendar jMyCalendar;
   private JMyCalendar jMyCalendar2;//종료일자//★추가

   /*public AddSchedule InfoUI(String title)
   {
      setTitle(title);
      setModal(true);
   }*/
   public AddScheduleInfoUI()
   {
      setTitle("추가하기");
      setModal(true);
      jMyCalendar = new JMyCalendar(this, "시작일자");
      jMyCalendar2 = new JMyCalendar(this, "종료일자");
   }
   public void display()
   {
      addComponent();
      setModal(true);
      setPreferredSize(new Dimension(310,530));
      setLocation(400,300);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      pack();
      setVisible(true);
   }
   public void addComponent()
   {
      imageInputLb = new JLabel();

      JLabel sectionLb = new JLabel("일정 추가하기",JLabel.CENTER);//일정 추가하기가 아닌 parameter로 받아서 set하기
      JLabel titleLb = new JLabel("일정제목",JLabel.CENTER);
      JLabel typeLb = new JLabel("일정종류",JLabel.CENTER);
      JLabel startLb = new JLabel("시작일자",JLabel.CENTER);
      JLabel endLb = new JLabel("종료일자",JLabel.CENTER);
      JLabel placeLb = new JLabel("장소",JLabel.CENTER);
      JLabel memoLb = new JLabel("메모",JLabel.CENTER);
      JLabel alarmLb = new JLabel("알람",JLabel.CENTER);
      JLabel imageLb = new JLabel("이미지",JLabel.CENTER);

      //JPanel secionIcnPanel = new JPanel(new ImageIcon("Icon/add.png"));
      //ImageIcon sectionIcn = new ImageIcon("Icon/add.png");//맞겟지?
      JLabel sectionIcn = new JLabel(new ImageIcon("Icon/add.png"));
      Container contentPane = getContentPane();
      panel = new JPanel(new GridBagLayout());
      c = new GridBagConstraints();
      JPanel buttonPanel = new JPanel(new FlowLayout());

      //섹션 아이콘
      c.insets = new Insets(5,5,5,5);
      c.anchor = GridBagConstraints.WEST;
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.weightx = 1;
      panel.add(sectionIcn,c);

      //섹션 라벨
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

      //제목 라벨
      c.gridx = 0;
      c.gridy = 1;
      c.gridwidth = 1;
      c.weightx = 1;
      titleLb.setPreferredSize(new Dimension(65,30));
      titleLb.setOpaque(true);
      titleLb.setBackground(new Color(221,217,195));
      panel.add(titleLb ,c);

      //제목 텍스트 필드
      titleTxf = new JTextField();
      c.gridx = 1;
      c.gridy = 1;
      c.gridwidth = 3;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      panel.add(titleTxf ,c);

      //일정 종류 라벨
      c.gridx = 0;
      c.gridy = 2;
      c.gridwidth = 1;
      c.weightx = 1;
      typeLb.setPreferredSize(new Dimension(65,30));
      typeLb.setOpaque(true);
      typeLb.setBackground(new Color(221,217,195));
      panel.add(typeLb, c);

      //일정 종류 JComboBox
      String[] typeList = {"휴가","이론","실습","휴식","운동","정보 수집 단계","유즈케이스 분석단계",
         "클래스 분석단계","클래스 설계단계","클래스 상세 설계단계","소스코딩 및 디버깅 단계","문서작업 및 발표준비단계",
         "최종 완료 단계","생일","결혼 기념일"};
      typeCmb = new JComboBox<String>(typeList);
      c.gridx = 1;
      c.gridy = 2;
      c.gridwidth = 3;
      c.weightx = 1;
      panel.add(typeCmb, c);

      //시작일자 라벨
      c.gridx = 0;
      c.gridy = 3;
      c.gridwidth = 1;
      c.weightx = 1;
      startLb.setPreferredSize(new Dimension(65,30));
      startLb.setOpaque(true);
      startLb.setBackground(new Color(221,217,195));
      panel.add(startLb ,c);
      
      //시작일자 버튼
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
      
      //종료일자 라벨
      c.gridx = 2;
      c.gridy = 3;
      c.gridwidth = 1;
      c.weightx = 1;
      endLb.setPreferredSize(new Dimension(65,30));
      endLb.setOpaque(true);
      endLb.setBackground(new Color(221,217,195));
      panel.add(endLb ,c);
      
      //종료일자 버튼
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
      
      //장소 라벨
      c.gridx = 0;
      c.gridy = 4;
      c.gridwidth = 1;
      c.weightx = 1;
      placeLb.setPreferredSize(new Dimension(65,30));
      placeLb.setOpaque(true);
      placeLb.setBackground(new Color(221,217,195));
      panel.add(placeLb ,c);
      
      //장소 텍스트 필드
      placeTxf = new JTextField();
      c.gridx = 1;
      c.gridy = 4;
      c.gridwidth = 3;
      c.weightx = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      panel.add(placeTxf ,c);

      //메모 라벨
      c.gridx = 0;
      c.gridy = 5;
      c.gridwidth = 4;
      c.weightx = 1;
      memoLb.setPreferredSize(new Dimension(65,30));
      memoLb.setOpaque(true);
      memoLb.setBackground(new Color(221,217,195));
      panel.add(memoLb, c);

      //메모 텍스트 area
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


      //알람 라벨
      c.gridx = 0;
      c.gridy = 8;
      c.weightx = 1;
      c.fill = GridBagConstraints.NONE;
      alarmLb.setPreferredSize(new Dimension(65,30));
      alarmLb.setOpaque(true);
      alarmLb.setBackground(new Color(221,217,195));
      panel.add(alarmLb, c);

      //알람 버튼
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

      //이미지 라벨
      c.gridx = 0;
      c.gridy = 9;
      c.weightx = 1;
      imageLb.setPreferredSize(new Dimension(65,30));
      imageLb.setOpaque(true);
      imageLb.setBackground(new Color(221,217,195));
      panel.add(imageLb, c);

      //이미지 버튼
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

      //확인버튼
      confirmBtn = new JButton("확인");
      
      //취소버튼
      cancelBtn = new JButton("취소");

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
      String fileName = fileDialog.getFile();//선택된 파름 이름
      String fileDirectory = fileDialog.getDirectory();//선택된 파일의 경로
      
      /*if(fileName.equals("null"))
         System.out.println("확인1");
      else if(fileName.equals(null))
         System.out.println("확인2");
      else if(fileName.equals(""))
         System.out.println("확인3");*/

      //System.out.println(fileName);
      //System.out.println(fileDirectory);

      //이미지만 읽게해야함

      //이미지 삽입 라벨
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
      super.setBounds(300, 20, 310, 675);
      super.setBounds(300, 20, 310, 676);
   }

   public void addScheduleInfo()
   {
      String kind = (String)typeCmb.getSelectedItem();//일정종류
      String title = titleTxf.getText();//일정제목
      int startYear;//시작일자
      int startMonth;
      int startDay;
      int startHour;
      int startMin;
      int endYear;//종료일자
      int endMonth;
      int endDay;
      int endHour;
      int endMin;
      if(startDate != null)
      {
         startYear = startDate.getYear();//시작일자
         startMonth = startDate.getMonth();
         startDay = startDate.getDate();
         startHour = startDate.getHours();
         startMin = startDate.getMinutes();
   /*      
		 System.out.println("시작일자 존재합!!");
         System.out.println(startYear);//확인
         System.out.println(startMonth);
         System.out.println(startDay);
         System.out.println(startHour);
         System.out.println(startMin);*/
      }
      if(endDate != null)
      {
         endYear = endDate.getYear();//종료일자
         endMonth = endDate.getMonth();
         endDay = endDate.getDate();
         endHour = endDate.getHours();
         endMin = endDate.getMinutes();
 
	/*	 System.out.println("종료일자 존재합!!");
         System.out.println(endYear);
         System.out.println(endMonth);
         System.out.println(endDay);
         System.out.println(endHour);
         System.out.println(endMin);*/
      }
      String place = placeTxf.getText();//장소
      String memo = memoTxa.getText();//메모
      //int alarmHour = tTime;//그냥 바로 tTime/tMin사용
      //int alarmMin = tMin;
      String image = "null image";
      if(fileDialog != null)
      {
  //       System.out.println("확인확인");
         image = ""+fileDialog.getDirectory()+fileDialog.getFile();//이미지 경로
  //       System.out.println(image);
      }
      else
  //       System.out.println("이미지 있움");



      //확인
	  /*
      System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
      System.out.println(kind);
      System.out.println(title);
      
      System.out.println(place);
      System.out.println(memo);
      */
      if(alarm != null)
      {
         System.out.println(tTime);
         System.out.println(tMin);
      }
	  Date alarmTemp = new Date(0000,11,22,Integer.parseInt(tTime), Integer.parseInt(tMin));
	  //scheduleKind,scheduleName,startDay,endDay,place,note,alarm,image
	 
	  
	  //AddScheduleInfoController addController = new AddScheduleInfoController();
	  //addController.addScheduleInfo(kind, title, startDate, endDate, place, memo, alarmTemp, image);
	  AddScheduleInfoSplitController splitController = new AddScheduleInfoSplitController();
	  splitController.splitAndTransfer(kind, title, startDate, endDate, place, memo, alarmTemp, image);
	  
	  System.out.println("split 끝났다~~~~");
	  /*
	  for(int cnt=0; cnt<DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().size(); cnt++){
			System.out.println(DayScheduleInfoDAO.getInstance().getDayScheduleInfoDAO().get(cnt));
			System.out.println();
	  }
	  */

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
	   if(division.equals("시작일자"))
	   {
			startDate = new Date(Integer.parseInt(year), monthNum, day, Integer.parseInt(hour), Integer.parseInt(min));
	   }
	   else if(division.equals("종료일자"))
	   {
			endDate = new Date(Integer.parseInt(year), monthNum, day, Integer.parseInt(hour), Integer.parseInt(min));
	   }
/*     
      System.out.println("ㅡㅡㅡ추가하기 창ㅡㅡㅡ");
	  System.out.println(division);
      System.out.println(year);
      System.out.println(month);
      System.out.println(day);
      System.out.println(hour);
      System.out.println(min);
*/
	  /*
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.min = min;
      System.out.println("ㅡㅡㅡ추가하기 창ㅡㅡㅡ");
      System.out.println(year);
      System.out.println(month);
      System.out.println(day);
      System.out.println(hour);
      System.out.println(min);
	  */
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
         if(btn.getText().equals("확인"))
         {
            addScheduleInfo();
            baseUI.dispose();
         }
         else if(btn.getText().equals("취소"))
         {
            baseUI.dispose();
         }
         else if(btn == startBtn)
         {
            jMyCalendar.display();
            //new JMyCalendar(baseUI).display();
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
  //          System.out.println(tTime);
  //          System.out.println(tMin);
         }
         else if(btn == imageBtn)
         {
            readImgFile();
         } 
         
      }
      public void readImgFile()
      {
         fileDialog = new FileDialog(baseUI, "이미지 열기", 0);//load?
         fileDialog.setVisible(true);
         setImgFile();
      }
   }
}
