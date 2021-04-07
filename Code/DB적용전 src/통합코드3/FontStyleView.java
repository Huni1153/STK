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

	public FontStyleView(JTextPane tp) {  // 저쪽에서 날아온 매개번수 tp 이다.
		
		super("Team.STriKe");
		this.tp = tp;


	}
	public void display()
	{
		// 배치 관리자
		Container con = getContentPane();
		setBounds(585, 110, 400, 500);

		centerPanel = new JPanel(new BorderLayout());
		listPanel = new JPanel();
		listPanel.setLayout(new GridLayout(0, 3));
		// 폰트 네임 부분
		listFontName = new JList(fontName);

		//FontSelectionListener fontSelect = new FontSelectionListener(this);
		//listFontName.addListSelectionListener(fontSelect);


		listScrollPane = new JScrollPane(listFontName);				// ScrollPanel 생성하고 그안에 FontName이 쭈욱 있는 list를 넣는다
		listScrollPane.setBorder(new TitledBorder("Font Name"));	// ScrollPanel안에 Title이 있는 border를 추가
		listPanel.add(listScrollPane);
		// 리스트는 하나만 선택가능하고, 필드의 값을 가져오면 해당 폰트 이름에 기본적으로 선택 되어있음
		listFontName.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontName.setSelectedValue(tp.getFont().getName(), false);

		// 폰트 스타일 부분
		listFontStyle = new JList(fontStyleName);

		//listFontStyle.addListSelectionListener(fontSelect);


		listScrollPane = new JScrollPane(listFontStyle);
		listScrollPane.setBorder(new TitledBorder("Font Style Name"));
		listPanel.add(listScrollPane);
		// 리스트는 하나만 선택가능하고, 필드의 값을 가져오면 해당 폰트 스타일 이름에 기본적으로 선택 되어있음
		listFontStyle
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontStyle.setSelectedIndex(tp.getFont().getStyle());
		// 폰트 사이즈 부분
		listFontSize = new JList(fontSize);

		//listFontSize.addListSelectionListener(fontSelect);


		listScrollPane = new JScrollPane(listFontSize);
		listScrollPane.setBorder(new TitledBorder("Font Size"));
		listPanel.add(listScrollPane);
		// 리스트는 하나만 선택가능하고, 필드의 값을 가져오면 해당 폰트 사이즈에 기본적으로 선택 되어있음
		listFontSize.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listFontSize.setSelectedValue("" + tp.getFont().getSize(), false);
		// 폰트 예문 부분
		textLabel = new JLabel("Team.STriKe Project");
		textLabel.setHorizontalAlignment(JLabel.CENTER);

		// 예문 폰트는 현재 메모장필드에 세팅된 폰트값을 가져와서 세팅됨
		textLabel.setFont(new Font((String) (listFontName.getSelectedValue()),
				listFontStyle.getSelectedIndex(), Integer
						.parseInt((String) (listFontSize.getSelectedValue())))
		);

		centerPan = new JPanel();
		centerPan.setLayout(new GridLayout(3,1));

		centerPan.add(new JLabel("　"));
		centerPan.add(textLabel);
		centerPan.add(new JLabel("　"));

		
		centerPanel.add(listPanel, BorderLayout.CENTER);
		centerPanel.add(centerPan, BorderLayout.SOUTH);
		bConfirm = new JButton("확인");
		bCancel = new JButton("취소");

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
			if (e.getActionCommand().equals("확인"))
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
		// 리스트를 고를때마다 폰트가 바뀜
		public void valueChanged(ListSelectionEvent arg0) 
		{
			try 
			{
				textLabel.setFont(new Font((String) (listFontName.getSelectedValue()),
							listFontStyle.getSelectedIndex(), 
								Integer.parseInt((String) (listFontSize.getSelectedValue()))
				));		// Label 영역이 Text를 가지고 있다가// 확인이 눌리면 ActionPerform.
				
				newFont = textLabel.getFont();
			} 
			catch (NullPointerException e) 
			{
				// e.printStackTrace();
			}
		}
	};
}