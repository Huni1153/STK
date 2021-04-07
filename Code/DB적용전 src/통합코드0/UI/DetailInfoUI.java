import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DetailInfoUI extends JDialog
{
	private JPanel topPanel;
	private JPanel bottumPanel;
	private JLabel lInfo,lTitleLeft,lTitleRight,lTypeLeft,lTypeRight,lStartLeft,lStartRight,lEndLeft,lEndRight,lPlaceLeft,lPlaceRight,lMemo,lAlarmLeft,lAlarmRight,lImageTop,lImageBottum;
	private JTextArea textArea;
	private JButton button;
	private GridBagConstraints c;
	private JScrollPane scrollPane;
	public DetailInfoUI()
	{
		this.setTitle("상세 정보보기");
		this.setModal(true);
		this.topPanel=new JPanel(new GridBagLayout());
		this.bottumPanel=new JPanel(new GridBagLayout());
		this.c=new GridBagConstraints();
		this.setPreferredSize(new Dimension(350,800));
		this.setLocation(600,100);
		this.lInfo=new JLabel("상세 정보보기",JLabel.CENTER);
		this.lTitleLeft=new JLabel("일정 제목",JLabel.CENTER);
		this.lTitleRight=new JLabel("Java 실습하기",JLabel.CENTER);
		this.lTypeLeft=new JLabel("일정 종류",JLabel.CENTER);
		this.lTypeRight=new JLabel("공부 하기",JLabel.CENTER);
		this.lStartLeft=new JLabel("시작 일자",JLabel.CENTER);
		this.lStartRight=new JLabel("2015-05-05 17:00",JLabel.CENTER);
		this.lEndLeft=new JLabel("종료 일자",JLabel.CENTER);
		this.lEndRight=new JLabel("2015-05-05 20:00",JLabel.CENTER);
		this.lPlaceLeft=new JLabel("  장 소  ",JLabel.CENTER);
		this.lPlaceRight=new JLabel("렉토 피아",JLabel.CENTER);
		this.lMemo=new JLabel("  메 모  ",JLabel.CENTER);
		this.lAlarmLeft=new JLabel("  알 람  ",JLabel.CENTER);
		this.lAlarmRight=new JLabel("1시간 30분전",JLabel.CENTER);
		this.lImageTop=new JLabel(" 이미지 ",JLabel.CENTER);
		this.lImageBottum=new JLabel();
		this.textArea=new JTextArea();
		this.button=new JButton("확 인");
	}
	public void set()
	{
		c.insets=new Insets(10,10,10,10);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		Image calImg=new ImageIcon("Icon/Information.png").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(calImg);
		JLabel imageLabel=new JLabel(image);
		topPanel.add(imageLabel,c);

		c.gridx=3;
		c.gridy=0;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
        this.lInfo.setOpaque(true);
		this.lInfo.setBackground(new Color(221,217,195));
		this.lInfo.setPreferredSize(new Dimension(50,50));
		topPanel.add(lInfo,c);

		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		c.weightx=0.0;
        this.lTitleLeft.setOpaque(true);
		this.lTitleLeft.setBackground(new Color(221,217,195));
		this.lTitleLeft.setPreferredSize(new Dimension(35,35));
		topPanel.add(lTitleLeft,c);

		c.gridx=2;
		c.gridy=1;
		c.gridwidth=2;
		c.weightx=0.0;
        this.lTitleRight.setOpaque(true);
		this.lTitleRight.setBackground(new Color(221,217,195));
		this.lTitleRight.setPreferredSize(new Dimension(35,35));
		topPanel.add(lTitleRight,c);

		c.gridx=0;
		c.gridy=2;
		c.weightx=0.0;
        this.lTypeLeft.setOpaque(true);
		this.lTypeLeft.setBackground(new Color(221,217,195));
		this.lTypeLeft.setPreferredSize(new Dimension(35,35));
		topPanel.add(lTypeLeft,c);

		c.gridx=2;
		c.gridy=2;
		c.gridwidth=2;
		c.weightx=0.1;
        this.lTypeRight.setOpaque(true);
		this.lTypeRight.setBackground(new Color(221,217,195));
		this.lTypeRight.setPreferredSize(new Dimension(35,35));
		topPanel.add(lTypeRight,c);

		c.gridx=0;
		c.gridy=3;
		c.weightx=0.0;
        this.lStartLeft.setOpaque(true);
		this.lStartLeft.setBackground(new Color(221,217,195));
		this.lStartLeft.setPreferredSize(new Dimension(35,35));
		topPanel.add(lStartLeft,c);

		c.gridx=2;
		c.gridy=3;
		c.gridwidth=2;
		c.weightx=0.1;
        this.lStartRight.setOpaque(true);
		this.lStartRight.setBackground(new Color(221,217,195));
		this.lStartRight.setPreferredSize(new Dimension(35,35));
		topPanel.add(lStartRight,c);

		c.gridx=0;
		c.gridy=4;
		c.weightx=0.0;
        this.lEndLeft.setOpaque(true);
		this.lEndLeft.setBackground(new Color(221,217,195));
		this.lEndLeft.setPreferredSize(new Dimension(35,35));
		topPanel.add(lEndLeft,c);

		c.gridx=2;
		c.gridy=4;
		c.gridwidth=2;
		c.weightx=0.1;
        this.lEndRight.setOpaque(true);
		this.lEndRight.setBackground(new Color(221,217,195));
		this.lEndRight.setPreferredSize(new Dimension(35,35));
		topPanel.add(lEndRight,c);

		c.gridx=0;
		c.gridy=5;
		c.weightx=0.0;
        this.lPlaceLeft.setOpaque(true);
		this.lPlaceLeft.setBackground(new Color(221,217,195));
		this.lPlaceLeft.setPreferredSize(new Dimension(35,35));
		topPanel.add(lPlaceLeft,c);

		c.gridx=2;
		c.gridy=5;
		c.gridwidth=2;
		c.weightx=0.1;
        this.lPlaceRight.setOpaque(true);
		this.lPlaceRight.setBackground(new Color(221,217,195));
		this.lPlaceRight.setPreferredSize(new Dimension(35,35));
		topPanel.add(lPlaceRight,c);

		c.gridx=0;
		c.gridy=6;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
		this.lMemo.setOpaque(true);
		this.lMemo.setBackground(new Color(221,217,195));
		this.lMemo.setPreferredSize(new Dimension(35,35));
		topPanel.add(lMemo,c);
		
		c.gridx=0;
		c.gridy=7;
		c.gridwidth=4;
		c.weightx=0.0;
		this.textArea.setOpaque(true);
		this.textArea.setBackground(new Color(237,231,207));
		this.scrollPane=new JScrollPane(textArea);
		this.scrollPane.setPreferredSize(new Dimension(70,70));
		topPanel.add(scrollPane,c);

		c.gridx=0;
		c.gridy=8;
		c.gridwidth=2;
		c.weightx=0.0;
        this.lAlarmLeft.setOpaque(true);
		this.lAlarmLeft.setBackground(new Color(221,217,195));
		this.lAlarmLeft.setPreferredSize(new Dimension(35,35));
		topPanel.add(lAlarmLeft,c);

		c.gridx=2;
		c.gridy=8;
		c.gridwidth=2;
		c.weightx=0.1;
        this.lAlarmRight.setOpaque(true);
		this.lAlarmRight.setBackground(new Color(221,217,195));
		this.lAlarmRight.setPreferredSize(new Dimension(35,35));
		topPanel.add(lAlarmRight,c);		

		c.gridx=0;
		c.gridy=9;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
		this.lImageTop.setOpaque(true);
		this.lImageTop.setBackground(new Color(221,217,195));
		this.lImageTop.setPreferredSize(new Dimension(35,35));
		topPanel.add(lImageTop,c);
		
		c.gridx=0;
		c.gridy=10;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
		Image calImg1=new ImageIcon("Icon/java scheduler.png").getImage().getScaledInstance(320,100,Image.SCALE_DEFAULT);
		ImageIcon image1=new ImageIcon(calImg1);
		JLabel lImageBottum=new JLabel(image1);
		this.lImageBottum.setPreferredSize(new Dimension(80,80));
		topPanel.add(lImageBottum,c);

		this.button.setBackground(new Color(79,129,189));
		this.button.setForeground(Color.WHITE);
		bottumPanel.add(button);

		this.button.addActionListener(new DetailInfoUIListener());

		this.add(topPanel,BorderLayout.NORTH);
		this.add(bottumPanel,BorderLayout.SOUTH);
		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	class DetailInfoUIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("ㅅ;빌");
			if(e.getSource()==button)
			{
				setVisible(false);
			}
		}
	}
	public static void main(String[] args)
	{
		DetailInfoUI obj=new DetailInfoUI();
		obj.set();
	}
}