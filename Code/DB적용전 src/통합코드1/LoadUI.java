import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class LoadUI extends JDialog
{
	private JPanel panel,bottumPanel;
	private JLabel lDate,lIcon;
	private JTable table;
	private JButton bCheck;
	private JButton bCancel;
	private GridBagConstraints c;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	public LoadUI()
	{
		this.setTitle("불러오기");
		this.setModal(true);
		this.panel=new JPanel(new GridBagLayout());
		this.bottumPanel=new JPanel();
		this.c=new GridBagConstraints();
		this.setPreferredSize(new Dimension(400,500));
		this.setLocation(500,200);
		this.lDate=new JLabel("5월 11일",JLabel.CENTER);
		this.bCheck=new JButton("열기(O)");
		this.bCancel=new JButton("취소");


		String[] str={"파일 이름","파일 위치","파일 형식"};
		this.model=new DefaultTableModel(str,2);
	}
	public void set()
	{
		c.insets=new Insets(10,10,10,10);

		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		Image calImg=new ImageIcon("Icon/load.png").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon image=new ImageIcon(calImg);
		this.lIcon=new JLabel(image);
		this.panel.add(lIcon,c);

		c.gridx=3;
		c.gridy=0;
		c.gridwidth=4;
		c.weightx=0.1;
		c.fill=GridBagConstraints.HORIZONTAL;
        this.lDate.setOpaque(true);
		this.lDate.setBackground(new Color(221,217,195));
		this.lDate.setPreferredSize(new Dimension(50,50));
		panel.add(lDate,c);		
	
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=6;
		this.table=new JTable(model);
		this.scrollPane=new JScrollPane(table);
		this.scrollPane.setPreferredSize(new Dimension(300,300));
		this.panel.add(scrollPane,c);

		this.bCheck.setBackground(new Color(79,129,189));
		this.bCheck.setForeground(Color.WHITE);
		bottumPanel.add(bCheck);


		this.bCancel.setBackground(new Color(79,129,189));
		this.bCancel.setForeground(Color.WHITE);
		bottumPanel.add(bCancel);
		
		this.bCheck.addActionListener(new LoadUIListener());
		this.bCancel.addActionListener(new LoadUIListener());

		this.add(panel,BorderLayout.NORTH);
		this.add(bottumPanel,BorderLayout.CENTER);
		this.setResizable(false);
		super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	class LoadUIListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int row=table.getSelectedRow();
			if(e.getSource()==bCheck)
			{
				System.out.println("열기");
				if(row<0)
				{
					JOptionPane.showMessageDialog(null,"파일을 선택하세요!", "오류", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"넌 열기(O) 버튼을 클릭했다", "버튼", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else
			{
				setVisible(false);
			}
		}
	}

	public static void main(String[] args)
	{
		LoadUI obj=new LoadUI();
		obj.set();
	}
}