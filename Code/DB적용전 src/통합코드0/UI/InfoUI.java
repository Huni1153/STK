import java.awt.*;
import javax.swing.*;

public class InfoUI extends JDialog
{
	private JPanel topPanel;
	private JPanel bottumPanel;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,label14,label15,label16;
	private JTextArea textArea;
	private JButton button;
	private GridBagConstraints c;
	private JScrollPane scrollPane;
	public InfoUI()
	{
		this.setTitle("상세 정보보기");
		this.setModal(true);
		this.topPanel=new JPanel(new GridBagLayout());
		this.bottumPanel=new JPanel(new GridBagLayout());
		this.c=new GridBagConstraints();
		this.setPreferredSize(new Dimension(350,800));
		this.setLocation(600,100);
		this.label1=new JLabel("상세 정보보기",JLabel.CENTER);
		this.label2=new JLabel("일정 제목",JLabel.CENTER);
		this.label3=new JLabel("Java 실습하기",JLabel.CENTER);
		this.label4=new JLabel("일정 종류",JLabel.CENTER);
		this.label5=new JLabel("공부 하기",JLabel.CENTER);
		this.label6=new JLabel("시작 일자",JLabel.CENTER);
		this.label7=new JLabel("2015-05-05 17:00",JLabel.CENTER);
		this.label8=new JLabel("종료 일자",JLabel.CENTER);
		this.label9=new JLabel("2015-05-05 20:00",JLabel.CENTER);
		this.label10=new JLabel("  장 소  ",JLabel.CENTER);
		this.label11=new JLabel("렉토 피아",JLabel.CENTER);
		this.label12=new JLabel("  메 모  ",JLabel.CENTER);
		this.label13=new JLabel("  알 람  ",JLabel.CENTER);
		this.label14=new JLabel("1시간 30분전",JLabel.CENTER);
		this.label15=new JLabel(" 이미지 ",JLabel.CENTER);
		this.label16=new JLabel();
		this.textArea=new JTextArea();
		this.button=new JButton("확 인");
		Color color=new Color(221,217,195);
		Dimension dimension=new Dimension(35,35);
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
        this.label1.setOpaque(true);
		this.label1.setBackground(new Color(221,217,195));
		this.label1.setPreferredSize(new Dimension(35,35));
		topPanel.add(label1,c);

		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		c.weightx=0.0;
        this.label2.setOpaque(true);
		this.label2.setBackground(new Color(221,217,195));
		this.label2.setPreferredSize(new Dimension(35,35));
		topPanel.add(label2,c);

		c.gridx=2;
		c.gridy=1;
		c.gridwidth=2;
		c.weightx=0.0;
        this.label3.setOpaque(true);
		this.label3.setBackground(new Color(221,217,195));
		this.label3.setPreferredSize(new Dimension(35,35));
		topPanel.add(label3,c);

		c.gridx=0;
		c.gridy=2;
		c.weightx=0.0;
        this.label4.setOpaque(true);
		this.label4.setBackground(new Color(221,217,195));
		this.label4.setPreferredSize(new Dimension(35,35));
		topPanel.add(label4,c);

		c.gridx=2;
		c.gridy=2;
		c.gridwidth=2;
		c.weightx=0.1;
        this.label5.setOpaque(true);
		this.label5.setBackground(new Color(221,217,195));
		this.label5.setPreferredSize(new Dimension(35,35));
		topPanel.add(label5,c);

		c.gridx=0;
		c.gridy=3;
		c.weightx=0.0;
        this.label6.setOpaque(true);
		this.label6.setBackground(new Color(221,217,195));
		this.label6.setPreferredSize(new Dimension(35,35));
		topPanel.add(label6,c);

		c.gridx=2;
		c.gridy=3;
		c.gridwidth=2;
		c.weightx=0.1;
        this.label7.setOpaque(true);
		this.label7.setBackground(new Color(221,217,195));
		this.label7.setPreferredSize(new Dimension(35,35));
		topPanel.add(label7,c);

		c.gridx=0;
		c.gridy=4;
		c.weightx=0.0;
        this.label8.setOpaque(true);
		this.label8.setBackground(new Color(221,217,195));
		this.label8.setPreferredSize(new Dimension(35,35));
		topPanel.add(label8,c);

		c.gridx=2;
		c.gridy=4;
		c.gridwidth=2;
		c.weightx=0.1;
        this.label9.setOpaque(true);
		this.label9.setBackground(new Color(221,217,195));
		this.label9.setPreferredSize(new Dimension(35,35));
		topPanel.add(label9,c);

		c.gridx=0;
		c.gridy=5;
		c.weightx=0.0;
        this.label10.setOpaque(true);
		this.label10.setBackground(new Color(221,217,195));
		this.label10.setPreferredSize(new Dimension(35,35));
		topPanel.add(label10,c);

		c.gridx=2;
		c.gridy=5;
		c.gridwidth=2;
		c.weightx=0.1;
        this.label11.setOpaque(true);
		this.label11.setBackground(new Color(221,217,195));
		this.label11.setPreferredSize(new Dimension(35,35));
		topPanel.add(label11,c);

		c.gridx=0;
		c.gridy=6;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
		this.label12.setOpaque(true);
		this.label12.setBackground(new Color(221,217,195));
		this.label12.setPreferredSize(new Dimension(35,35));
		topPanel.add(label12,c);
		
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
        this.label13.setOpaque(true);
		this.label13.setBackground(new Color(221,217,195));
		this.label13.setPreferredSize(new Dimension(35,35));
		topPanel.add(label13,c);

		c.gridx=2;
		c.gridy=8;
		c.gridwidth=2;
		c.weightx=0.1;
        this.label14.setOpaque(true);
		this.label14.setBackground(new Color(221,217,195));
		this.label14.setPreferredSize(new Dimension(35,35));
		topPanel.add(label14,c);		

		c.gridx=0;
		c.gridy=9;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
		this.label15.setOpaque(true);
		this.label15.setBackground(new Color(221,217,195));
		this.label15.setPreferredSize(new Dimension(35,35));
		topPanel.add(label15,c);
		
		c.gridx=0;
		c.gridy=10;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
		Image calImg1=new ImageIcon("Icon/java scheduler.png").getImage().getScaledInstance(320,100,Image.SCALE_DEFAULT);
		ImageIcon image1=new ImageIcon(calImg1);
		JLabel label16=new JLabel(image1);
		this.label16.setPreferredSize(new Dimension(80,80));
		topPanel.add(label16,c);

		this.button.setBackground(new Color(79,129,189));
		this.button.setForeground(Color.WHITE);
		bottumPanel.add(button);

		this.add(topPanel,BorderLayout.NORTH);
		this.add(bottumPanel,BorderLayout.SOUTH);
		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		InfoUI obj=new InfoUI();
		obj.set();
	}
}