package Model;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;

public class FontStyleView extends JFrame{

	private JTextPane tp;

	private String[] fontName = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();
	private String[] fontStyleName = { "PLAIN", "BOLD", "ITALIC" };
	private String[] fontSize = { "6", "7", "8", "9", "10", "12", "14", "17", "20",
			"24", "30", "40" };
	private JList listFontName, listFontStyle, listFontSize;
	private JPanel listPanel, centerPanel, southPanel;

	private JPanel centerPan;	

	private JScrollPane listScrollPane;
	private JLabel textLabel;
	private JButton bConfirm, bCancel;
	private Font newFont = null;

	public FontStyleView(JTextPane tp) {  // ���ʿ��� ���ƿ� �Ű����� tp �̴�.
		
		super("Team.STriKe");
		this.tp = tp;


	}
	public void display()
	{
		// ��ġ ������
		Container con = getContentPane();
		setBounds(585, 110, 400, 500);

		centerPanel = new JPanel(new BorderLayout());
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0, 3));
		// ��Ʈ ���� �κ�
		listFontName = new JList(fontName);

		//FontSelectionListener fontSelect = new FontSelectionListener(this);
		//listFontName.addListSelectionListener(fontSelect);


		listScrollPane = new JScrollPane(listFontName);				// ScrollPanel �����ϰ� �׾ȿ� FontName�� �޿� �ִ� list�� �ִ´�
		listScrollPane.setBorder(new TitledBorder("Font Name"));	// ScrollPanel�ȿ� Title�� �ִ� border�� �߰�
		listPanel.add(listScrollPane);
		// ����Ʈ�� �ϳ��� ���ð����ϰ�, �ʵ��� ���� �������� �ش� ��Ʈ �̸��� �⺻������ ���� �Ǿ�����
		listFontName.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontName.setSelectedValue(tp.getFont().getName(), false);

		// ��Ʈ ��Ÿ�� �κ�
		listFontStyle = new JList(fontStyleName);

		//listFontStyle.addListSelectionListener(fontSelect);


		listScrollPane = new JScrollPane(listFontStyle);
		listScrollPane.setBorder(new TitledBorder("Font Style Name"));
		listPanel.add(listScrollPane);
		// ����Ʈ�� �ϳ��� ���ð����ϰ�, �ʵ��� ���� �������� �ش� ��Ʈ ��Ÿ�� �̸��� �⺻������ ���� �Ǿ�����
		listFontStyle
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontStyle.setSelectedIndex(tp.getFont().getStyle());
		// ��Ʈ ������ �κ�
		listFontSize = new JList(fontSize);

		//listFontSize.addListSelectionListener(fontSelect);


		listScrollPane = new JScrollPane(listFontSize);
		listScrollPane.setBorder(new TitledBorder("Font Size"));
		listPanel.add(listScrollPane);
		// ����Ʈ�� �ϳ��� ���ð����ϰ�, �ʵ��� ���� �������� �ش� ��Ʈ ����� �⺻������ ���� �Ǿ�����
		listFontSize.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontSize.setSelectedValue("" + tp.getFont().getSize(), false);
		// ��Ʈ ���� �κ�
		textLabel = new JLabel("Team.STriKe Project");
		textLabel.setHorizontalAlignment(JLabel.CENTER);

		// ���� ��Ʈ�� ���� �޸����ʵ忡 ���õ� ��Ʈ���� �����ͼ� ���õ�
		textLabel.setFont(new Font((String) (listFontName.getSelectedValue()),
				listFontStyle.getSelectedIndex(), Integer
						.parseInt((String) (listFontSize.getSelectedValue())))
		);

		centerPan = new JPanel();
		centerPan.setLayout(new GridLayout(3,1));

		centerPan.add(new JLabel("��"));
		centerPan.add(textLabel);
		centerPan.add(new JLabel("��"));

		
		centerPanel.add(listPanel, BorderLayout.CENTER);
		centerPanel.add(centerPan, BorderLayout.SOUTH);
		bConfirm = new JButton("Ȯ��");
		bCancel = new JButton("���");

		southPanel = new JPanel();
		southPanel.add(bConfirm);
		southPanel.add(bCancel);
		con.add(centerPanel, BorderLayout.CENTER);
		con.add(southPanel, BorderLayout.SOUTH);

		addListener();

		newFont = textLabel.getFont();

		setVisible(true);
	}

	private void addListener()
	{
		FontSelectionListener fontSelect = new FontSelectionListener(this);
		listFontName.addListSelectionListener(fontSelect);
		listFontStyle.addListSelectionListener(fontSelect);
		listFontSize.addListSelectionListener(fontSelect);

		FontBtnListener fontBtnListen = new FontBtnListener(this);
		bConfirm.addActionListener(fontBtnListen);
		bCancel.addActionListener(fontBtnListen);
	}

	class FontBtnListener implements ActionListener
	{
		private JFrame frame;

		public FontBtnListener(JFrame frame)
		{
			this.frame = frame;
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Ȯ��"))
				tp.setFont(newFont);
			frame.dispose();
		}
	};

	class FontSelectionListener implements ListSelectionListener
	{
		private JFrame frame;

		public FontSelectionListener(JFrame frame)
		{
			this.frame = frame;
		}
		// ����Ʈ�� �������� ��Ʈ�� �ٲ�
		public void valueChanged(ListSelectionEvent arg0) 
		{
			try 
			{
				textLabel.setFont(new Font((String) (listFontName.getSelectedValue()),
							listFontStyle.getSelectedIndex(), 
								Integer.parseInt((String) (listFontSize.getSelectedValue()))
				));		// Label ������ Text�� ������ �ִٰ�// Ȯ���� ������ ActionPerform.
				
				newFont = textLabel.getFont();
			} 
			catch (NullPointerException e) 
			{
				// e.printStackTrace();
			}
		}
	};
}