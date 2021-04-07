package Model;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;
import java.util.*;

public class WeeklySchedule extends JPanel 
{
	/*private JLabel sunLabel;
	private JLabel monLabel;
	private JLabel tueLabel;
	private JLabel wedLabel;
	private JLabel thuLabel;
	private JLabel friLabel;
	private JLabel satLabel;

	private JTable sunTable; private DefaultTableModel sunModel;
	private JTable monTable; private DefaultTableModel monModel;
	private JTable tueTable; private DefaultTableModel tueModel;
	private JTable wedTable; private DefaultTableModel wedModel;
	private JTable thuTable; private DefaultTableModel thuModel;
	private JTable friTable; private DefaultTableModel friModel;
	private JTable satTable; private DefaultTableModel satModel;

	private JTable contentTable; private DefaultTableModel contentModel;

	private JPanel daysPanel;
	private JPanel contentPanel;

	public WeeklySchedule(){
		
		daysPanel = new JPanel(new GridLayout(7,1));
		
		contentPanel = new JPanel(new GridLayout(7,1));

		setLayout(new BorderLayout());
		
		sunLabel = new JLabel(new ImageIcon("Icon/��.png"));
		//sunLabel = new JLabel("�����ٶ�");
		//sunLabel.setOpaque(true);
		//sunLabel.setBackground(new Color(220,230,242));
		monLabel = new JLabel(new ImageIcon("Icon/��.png"));
		tueLabel = new JLabel(new ImageIcon("Icon/ȭ.png"));
		wedLabel = new JLabel(new ImageIcon("Icon/��.png"));
		thuLabel = new JLabel(new ImageIcon("Icon/��.png"));
		friLabel = new JLabel(new ImageIcon("Icon/��.png"));
		satLabel = new JLabel(new ImageIcon("Icon/��.png"));

		daysPanel.add(sunLabel);daysPanel.add(monLabel);daysPanel.add(tueLabel);
		daysPanel.add(wedLabel);daysPanel.add(thuLabel);daysPanel.add(friLabel);
		daysPanel.add(satLabel);


		sunModel = new DefaultTableModel();//(1,4);
		sunTable = new JTable(sunModel);

		monModel = new DefaultTableModel();//1,4);
		monTable = new JTable(monModel);

		tueModel = new DefaultTableModel();//1,4);
		tueTable = new JTable(tueModel);

		wedModel = new DefaultTableModel(1,4);
		wedTable = new JTable(wedModel);

		thuModel = new DefaultTableModel(1,4);
		thuTable = new JTable(thuModel);

		friModel = new DefaultTableModel(1,4);
		friTable = new JTable(friModel);

		satModel = new DefaultTableModel(1,4);
		satTable = new JTable(satModel);

		
		//contentModel = new DefaultTableModel(7,4);
		//contentTable = new JTable(contentModel);

		setNoLines();
		setColor();

		Object [][]data = {{"123","123","123","123"}};
		
		sunModel.addColumn("a");sunModel.addColumn("a");sunModel.addColumn("a");sunModel.addColumn("a");

		sunModel.addRow(new Object[]{"123","123","123","123"});




		contentPanel.add(sunTable);
		contentPanel.add(monTable);
		contentPanel.add(tueTable);
		contentPanel.add(wedTable);
		contentPanel.add(thuTable);
		contentPanel.add(friTable);
		contentPanel.add(satTable);

		sunTable.setRowHeight(50);
		monTable.setRowHeight(50);
		tueTable.setRowHeight(50);
		wedTable.setRowHeight(50);
		thuTable.setRowHeight(50);
		friTable.setRowHeight(50);
		satTable.setRowHeight(50);

		add(daysPanel, BorderLayout.WEST);
		add(contentPanel, BorderLayout.CENTER);
		//add(contentTable,BorderLayout.CENTER);

	}
	private void addComponent(){
		
	}
	private void setNoLines(){
		
		sunTable.setShowHorizontalLines(false);sunTable.setShowVerticalLines(false);
		monTable.setShowHorizontalLines(false);monTable.setShowVerticalLines(false);
		tueTable.setShowHorizontalLines(false);tueTable.setShowVerticalLines(false);
		wedTable.setShowHorizontalLines(false);wedTable.setShowVerticalLines(false);
		thuTable.setShowHorizontalLines(false);thuTable.setShowVerticalLines(false);
		friTable.setShowHorizontalLines(false);friTable.setShowVerticalLines(false);
		satTable.setShowHorizontalLines(false);satTable.setShowVerticalLines(false);
	
	}
	private void setColor(){
		
		daysPanel.setOpaque(true);
		daysPanel.setBackground(new Color(219,238,244));
		contentPanel.setOpaque(true);
		contentPanel.setBackground(new Color(219,238,244));
		sunTable.setOpaque(true); sunTable.setBackground(new Color(219,238,244));
		monTable.setOpaque(true); monTable.setBackground(new Color(219,238,244));
		tueTable.setOpaque(true); tueTable.setBackground(new Color(219,238,244));
		wedTable.setOpaque(true); wedTable.setBackground(new Color(219,238,244));
		thuTable.setOpaque(true); thuTable.setBackground(new Color(219,238,244));
		friTable.setOpaque(true); friTable.setBackground(new Color(219,238,244));
		satTable.setOpaque(true); satTable.setBackground(new Color(219,238,244));
	
	}*/

	//private SimpleDayDocumentController simpleDayDocumentController;

	//private String[] documentDirectoryList;	// ��ü ���丮 ����Ʈ
	//private String[][][] simpleDayDocumentList;	// ���� ��¥�� ��ü java���� ����Ʈ
	//private Object[] currentDocumentArr;	// ���� ������ ����.
	//private String currentDocCode;




////////////// 0524 �뼷 ����////////////// 0524 �뼷 ����
	private String[] documentDirectoryList;	// ��ü ���丮 ����Ʈ
	private ArrayList<StudyDocumentInfo> list;

	private DefaultTableModel weeklyModel;
	private JTable weeklyTable;
	private JScrollPane weeklyScroll;

	public WeeklySchedule(){

		setPreferredSize(new Dimension(200,300));
		setLayout(new BorderLayout());
/*
		list = new ArrayList<StudyDocumentInfo>();

		documentDirectoryList = new GetDocumentDirectoryListController().getDirectoryList();

		System.out.println("���� : " + documentDirectoryList.length);
		for(int i=0; i<documentDirectoryList.length; i++)
		{
			LinkedList<StudyDocumentInfo> link = StudyDocumentDAO.getInstanceMethod().searchStudyDocumentInfo(documentDirectoryList[i]);
			System.out.println(link);
			for(int j=0; j<link.size(); j++)
			{
				list.add(link.get(j));
			}
		}*/

		String[] colName = {"���ϸ�", "���� ��¥"};
		String[][] data = new StudyDocumentListController().getStudyDocumentList();

	//	for(int i=0; i<list.size(); i++)
	//	{
	//		data[i][0] = list.get(i).getDocumentName()+".java";  data[i][1] = list.get(i).getDocumentDirectory();
	//	}
		weeklyModel = new DefaultTableModel(data, colName);
		weeklyTable = new JTable(weeklyModel);
		JTableHeader header = weeklyTable.getTableHeader();
		header.setBackground(new Color(212,255,234));
		header.setForeground(Color.BLACK);
		header.setOpaque(false);
		weeklyScroll=new JScrollPane(weeklyTable);
		add(weeklyScroll, BorderLayout.CENTER);
////////////// 0524 �뼷 ����////////////// 0524 �뼷 ����
	}
}
