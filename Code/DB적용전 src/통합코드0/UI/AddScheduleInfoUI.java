import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FileDialog;

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

	public AddScheduleInfoUI(String title)
	{
		setTitle(title);
		setModal(true);
	}
	public AddScheduleInfoUI()
	{
		setTitle("임시 제목");
		setModal(true);
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
		JLabel sectionLb = new JLabel("일정 추가하기",JLabel.CENTER);//일정 추가하기가 아닌 parameter로 받아서 set하기
		JLabel titleLb = new JLabel("일정제목",JLabel.CENTER);
		JLabel typeLb = new JLabel("일정종류",JLabel.CENTER);
		JLabel startLb = new JLabel("시작일자",JLabel.CENTER);
		JLabel endLb = new JLabel("종료일자",JLabel.CENTER);
		JLabel placeLb = new JLabel("장소",JLabel.CENTER);
		JLabel memoLb = new JLabel("메모",JLabel.CENTER);
		JLabel alarmLb = new JLabel("알람",JLabel.CENTER);
		JLabel imageLb = new JLabel("이미지",JLabel.CENTER);
		JLabel imageInputLb;
		//JPanel secionIcnPanel = new JPanel(new ImageIcon("Icon/add.png"));
		//ImageIcon sectionIcn = new ImageIcon("Icon/add.png");//맞겟지?
		JLabel sectionIcn = new JLabel(new ImageIcon("Icon/add.png"));
		Container contentPane = getContentPane();
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
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
		JComboBox<String> typeCmb = new JComboBox<String>(typeList);
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
		c.weightx = 3;
		c.fill = GridBagConstraints.NONE;
		panel.add(imageBtn, c);

		//이미지 삽입 라벨
		fileDialog = new FileDialog(this, "이미지 열기", FileDialog.LOAD);//load?
		fileDialog.setDirectory("C:");
		//imageInputLabel = new imageInputLabel(


		//확인버튼
		confirmBtn = new JButton("확인");
		
		//취소버튼
		cancelBtn = new JButton("취소");

		this.confirmBtn.setBackground(new Color(79,129,189));
		this.confirmBtn.setForeground(Color.WHITE);
		this.cancelBtn.setBackground(new Color(79,129,189));
		this.cancelBtn.setForeground(Color.WHITE);
		buttonPanel.add(confirmBtn);
		buttonPanel.add(cancelBtn);


		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
	}
	/*public void addListener()
	{
	}
	class ButtonActionListener implements ActionListener
	{
		public void ActionPerformed(ActionEvent e)
		{
		}
	}*/
}
