import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;

public class FontStyleView extends JFrame implements ActionListener,
		ListSelectionListener {
	String[] fontName = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();
	String[] fontStyleName = { "PLAIN", "BOLD", "ITALIC" };
	String[] fontSize = { "6", "7", "8", "9", "10", "12", "14", "17", "20",
			"24", "30", "40" };
	JList listFontName, listFontStyle, listFontSize;
	JPanel listPanel, centerPanel, southPanel;

	JPanel centerPan;	

	JScrollPane listScrollPane;
	JLabel textLabel;
	JButton bConfirm, bCancel;
	Font newFont = null;
	//JTextArea ta;
	JTextPane tp;

	public FontStyleView(JTextPane tp) {  // ���� ChickenRun���� ���ƿ� �Ű����� ta �̴�.
		this.tp = tp;
		// ��ġ ������
		Container con = getContentPane();
		centerPanel = new JPanel(new BorderLayout());
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0, 3));
		// ��Ʈ ���� �κ�
		listFontName = new JList(fontName);
		listFontName.addListSelectionListener(this);
		listScrollPane = new JScrollPane(listFontName);	// ScrollPanel �����ϰ� �׾ȿ� FontName�� �޿� �ִ� list�� �ִ´�
		listScrollPane.setBorder(new TitledBorder("Font Name"));	// ScrollPanel�ȿ� Title�� �ִ� border�� �߰�
		listPanel.add(listScrollPane);
		// ����Ʈ�� �ϳ��� ���ð����ϰ�, �ʵ��� ���� �������� �ش� ��Ʈ �̸��� �⺻������ ���� �Ǿ�����
		listFontName
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontName.setSelectedValue(tp.getFont().getName(), false);

		// ��Ʈ ��Ÿ�� �κ�
		listFontStyle = new JList(fontStyleName);
		listFontStyle.addListSelectionListener(this);
		listScrollPane = new JScrollPane(listFontStyle);
		listScrollPane.setBorder(new TitledBorder("Font Style Name"));
		listPanel.add(listScrollPane);
		// ����Ʈ�� �ϳ��� ���ð����ϰ�, �ʵ��� ���� �������� �ش� ��Ʈ ��Ÿ�� �̸��� �⺻������ ���� �Ǿ�����
		listFontStyle
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontStyle.setSelectedIndex(tp.getFont().getStyle());
		// ��Ʈ ������ �κ�
		listFontSize = new JList(fontSize);
		listFontSize.addListSelectionListener(this);
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
		bConfirm.addActionListener(this);
		bCancel.addActionListener(this);
		southPanel = new JPanel();
		southPanel.add(bConfirm);
		southPanel.add(bCancel);
		con.add(centerPanel, "Center");
		con.add(southPanel, "South");
		newFont = textLabel.getFont();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Ȯ��"))
			tp.setFont(newFont);
		this.dispose();
	}

	// ����Ʈ�� �������� ���� ��Ʈ�� �ٲ�
	public void valueChanged(ListSelectionEvent arg0) {
		try {
			textLabel.setFont(new Font((String) (listFontName.getSelectedValue()),
							listFontStyle.getSelectedIndex(), 
							Integer.parseInt((String) (listFontSize.getSelectedValue()))
							));		// Label ������ Text�� ������ �ִٰ�// Ȯ���� ������ ActionPerform �ȴ�.
			newFont = textLabel.getFont();
		} catch (NullPointerException e) {
			// System.out.println("��Ʈ ó�� �������� ���� Error");
		}
	}
}