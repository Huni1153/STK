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
		setTitle("�ӽ� ����");
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
		JLabel sectionLb = new JLabel("���� �߰��ϱ�",JLabel.CENTER);//���� �߰��ϱⰡ �ƴ� parameter�� �޾Ƽ� set�ϱ�
		JLabel titleLb = new JLabel("��������",JLabel.CENTER);
		JLabel typeLb = new JLabel("��������",JLabel.CENTER);
		JLabel startLb = new JLabel("��������",JLabel.CENTER);
		JLabel endLb = new JLabel("��������",JLabel.CENTER);
		JLabel placeLb = new JLabel("���",JLabel.CENTER);
		JLabel memoLb = new JLabel("�޸�",JLabel.CENTER);
		JLabel alarmLb = new JLabel("�˶�",JLabel.CENTER);
		JLabel imageLb = new JLabel("�̹���",JLabel.CENTER);
		JLabel imageInputLb;
		//JPanel secionIcnPanel = new JPanel(new ImageIcon("Icon/add.png"));
		//ImageIcon sectionIcn = new ImageIcon("Icon/add.png");//�°���?
		JLabel sectionIcn = new JLabel(new ImageIcon("Icon/add.png"));
		Container contentPane = getContentPane();
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
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
		JComboBox<String> typeCmb = new JComboBox<String>(typeList);
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
		c.weightx = 3;
		c.fill = GridBagConstraints.NONE;
		panel.add(imageBtn, c);

		//�̹��� ���� ��
		fileDialog = new FileDialog(this, "�̹��� ����", FileDialog.LOAD);//load?
		fileDialog.setDirectory("C:");
		//imageInputLabel = new imageInputLabel(


		//Ȯ�ι�ư
		confirmBtn = new JButton("Ȯ��");
		
		//��ҹ�ư
		cancelBtn = new JButton("���");

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
