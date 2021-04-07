package Model;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FileDialog;
import java.util.Date;
import java.awt.image.*;

public class ModifyScheduleInfoUI extends JDialog 
{
	private JTextField titleTxf;//일정 제목
	private JTextField placeTxf;//장소
	private JTextArea memoTxa;//메모
	private JButton startBtn;//시작일자 버튼
	private JButton endBtn;//종료일자 버튼
	private JButton alarmBtn;//알람 버튼
	private JButton imageBtn;//이미지 버튼
	private JButton confirmBtn;
	private JButton cancelBtn;

	private FileDialog fileDialog;
	private JPanel panel;
	private GridBagConstraints c;
	private JLabel imageInputLb;//이미지
	private Alarm alarm;
	private String tTime;//알람 시간
	private String tMin;//알람 분

	private Date startDate;//시작일자(년월일시간분)
	private Date endDate;//종료일자
	private JComboBox<String> typeCmb;//일정 종류

	private JMyCalendar jMyCalendar;//시작 달력
	private JMyCalendar jMyCalendar2;//종료 달력

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
		setTitle("수정하기");
		setModal(true);
	}

	public ModifyScheduleInfoUI(DailySchedule dailySchedule)
	{
      this.dailySchedule = dailySchedule;
      //this.modifyScheduleInfoUI = modifyScheduleInfoUI;
      //this.modifyScheduleCode = modifyScheduleCode;
      //this.modifyScheduleName = modifyScheduleName;
      

      setTitle("수정하기");
      setModal(true);
      jMyCalendar = new JMyCalendar(this,"시작일자");
      jMyCalendar2 = new JMyCalendar(this,"종료일자");
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

		JLabel sectionLb = new JLabel("일정 수정하기",JLabel.CENTER);//일정 추가하기가 아닌 parameter로 받아서 set하기
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
		JLabel sectionIcn = new JLabel(new ImageIcon("Icon/edit.png"));
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
		titleTxf.setText(modifyScheduleName);
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

		//★area는 따로 panel
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
		String fileName = fileDialog.getFile();//선택된 파름 이름
		String fileDirectory = fileDialog.getDirectory();//선택된 파일의 경로
		System.out.println(fileName);
		//if(fileName.equals(null))
		//	return;
		System.out.println(fileDirectory);

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
		super.setBounds(400, 50, 310, 675);
		super.setBounds(400, 50, 310, 676);
	}

	public void modifyScheduleInfo()//controller로 보냄
	{
		/*String kind = (String)typeCmb.getSelectedItem();//일정종류
      String title = titleTxf.getText();//일정제목
      int startYear = startDate.getYear();//시작일자
      int startMonth = startDate.getMonth();
      int startDay = startDate.getDay();
      int startHour = startDate.getHours();
      int startMin = startDate.getMinutes();
      int endYear = endDate.getYear();//종료일자
      int endMonth = endDate.getMonth();
      int endDay = endDate.getDay();
      int endHour = endDate.getHours();
      int endMin = endDate.getMinutes();
      String place = placeTxf.getText();//장소
      String memo = memoTxa.getText();//메모
      //int alarmHour = tTime;//그냥 바로 tTime/tMin사용
      //int alarmMin = tMin;
      String image = ""+fileDialog.getFile()+fileDialog.getDirectory();//이미지 경로
      //ImageIcon imageIcon = imageInputLb.getIcon().getImage();//이미지 자체//(사용X)
      //Icon icon = imageInputLb.getIcon();
      //BufferedImage imageIcon = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
      */


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
         startDay = startDate.getDay();
         startHour = startDate.getHours();
         startMin = startDate.getMinutes();
         
       System.out.println("시작일자 존재합!!");
         System.out.println(startYear);//확인
         System.out.println(startMonth);
         System.out.println(startDay);
         System.out.println(startHour);
         System.out.println(startMin);
      }
      if(endDate != null)
      {
         endYear = endDate.getYear();//종료일자
         endMonth = endDate.getMonth();
         endDay = endDate.getDay();
         endHour = endDate.getHours();
         endMin = endDate.getMinutes();
 
       System.out.println("종료일자 존재합!!");
         System.out.println(endYear);
         System.out.println(endMonth);
         System.out.println(endDay);
         System.out.println(endHour);
         System.out.println(endMin);
      }
      String place = placeTxf.getText();//장소
      String memo = memoTxa.getText();//메모
      //int alarmHour = tTime;//그냥 바로 tTime/tMin사용
      //int alarmMin = tMin;
      String image = "null image";
      if(fileDialog != null)
      {
         System.out.println("확인확인");
         image = ""+fileDialog.getDirectory()+fileDialog.getFile();//이미지 경로
         System.out.println(image);
      }
      else
         System.out.println("이미지 있움");



      //확인
      System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
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
     //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡcontroller연결부분ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
      ModifyScheduleInfoController modifyController = new ModifyScheduleInfoController();
     //modifyController.modifyScheduleInfo(modifyScheduleCode, kind, title, startDate, endDate, place, memo, alarmTemp, image);
	 modifyController.modifyScheduleInfoToDB(modifyScheduleCode, kind, title, startDate, endDate, place, memo, alarmTemp, image);
	}



	public void getCalendarInfo(String division, String year, String month, int day, String hour, String min)
	{
      //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ추가ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ//
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
         startDate = new Date(Integer.parseInt(year), monthNum-1, day, Integer.parseInt(hour), Integer.parseInt(min));
      }
      else if(division.equals("종료일자"))
      {
         endDate = new Date(Integer.parseInt(year), monthNum-1, day, Integer.parseInt(hour), Integer.parseInt(min));
      }
     
		System.out.println("ㅡㅡㅡ수정하기 창ㅡㅡㅡ");
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
         if(btn.getText().equals("확인"))
         {
            modifyScheduleInfo();
            baseUI.dispose();
         }
         else if(btn.getText().equals("취소"))
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
         fileDialog = new FileDialog(baseUI, "이미지 열기", 0);//load?
         fileDialog.setVisible(true);
         setImgFile();
      }
   }
}