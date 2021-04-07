import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
public class SchedulerUI extends JFrame
{
	private Container contentPane;
	private JToolBar topBar;
	
	private JButton addSchedule;
	private JButton editSchedule;
	private JButton startMonth;
	private JButton endMonth;
	private JButton searchSchedule;
	private JButton deleteSchedule;
	private JButton printSchedule;
	private JButton exitSchedule;

	private JTextField searchText;

	private JButton addNewDocument;
	private JButton editDocument;
	private JButton deleteDocument;

	private JLabel emptyLabel1;
	private JLabel emptyLabel2;

	private JPanel sidePanel;

	private MyCalendar myCalendar;
	private WeeklySchedule weeklySchedule;
////////////////////////////////////////////////
	private DailySchedule dailySchedule;
	private AddScheduleInfoUI addScheduleInfoUI;
	private ModifyScheduleInfoUI modifyScheduleInfoUI;
	//private STKprojectTextUI stkProjectTextUI;
	private String[] documentDirectoryList;
	private String todayDocumentDirectory;

/////////////////////////////////////////재영

	private DisplayInfoController displayInfoController;
	private AMonthDayInfoController monthController;
	private SimpleDayInfoController simpleController;

	private String choiceYear;
	private String choiceMonth;
	private String choiceDate;

	private String modifyCode;
	private String modifyName;

	private String searchStartYear;
	private String searchStartMonth;
	private String searchStartDate;

	private String searchEndYear;
	private String searchEndMonth;
	private String searchEndDate;
/////////////////////////////////////////////////재영	

	

	public SchedulerUI(){
		super("Study Tool Kit");
		

		fileLoad();	//파일에서 읽어와서 메모리에 세팅!

////////////////////////////////////////
		DayScheduleInfoDAO.getInstance().fileLoad();
		DayScheduleInfoDAO.getInstance().setLatestCodeNum();
////////////////////

		GregorianCalendar cal = new GregorianCalendar();
		int year = cal.get(GregorianCalendar.YEAR);
		int month = cal.get(GregorianCalendar.MONTH)+1;
		int day = cal.get(GregorianCalendar.DAY_OF_MONTH);

		this.choiceYear = Integer.toString(year);
		this.choiceMonth = Integer.toString(month);
		this.choiceDate = Integer.toString(day);

		contentPane = getContentPane();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 10, 1185, 800);
		//setUndecorated(true);

		
		//setLocation(100,10);
		//setPreferredSize(new Dimension(1200,800));
	
		topBar = new JToolBar("Top Bar", JToolBar.HORIZONTAL);
		topBar.setOpaque(true);
		topBar.setBackground(new Color(219,238,244));
		//topBar.setLayout(new BorderLayout());

		sidePanel = new JPanel(new GridLayout(2,1));

///////////////////////////////재영
		displayInfoController = new DisplayInfoController();
		monthController = new AMonthDayInfoController(displayInfoController);
		//SimpleDayInfoController simpleController = new SimpleDayInfoController("2015","5","10",displayInfoController);
		SimpleDayInfoController simpleController = new SimpleDayInfoController(choiceYear,choiceMonth,choiceDate,displayInfoController);

		myCalendar = new MyCalendar(displayInfoController, simpleController, dailySchedule, this);
		//weekSchedule = new WeekSchedule();
		weeklySchedule = new WeeklySchedule();
/////////////////////////////////////////


		//myCalendar = new MyCalendar();

		todayDocumentDirectory = myCalendar.getTodayDir();

		//weekSchedule = new WeekSchedule();
/*                                                     */

////////////////////////////////////////////////////////////////////////
		dailySchedule = new DailySchedule(simpleController, this, choiceYear, choiceMonth, choiceDate);
		addScheduleInfoUI = new AddScheduleInfoUI();
		modifyScheduleInfoUI = new ModifyScheduleInfoUI(dailySchedule);
		//stkProjectTextUI = new STKprojectTextUI();
////////////////////////////////////////////////////////////////////////
		
		sidePanel.add(myCalendar);
		sidePanel.add(weeklySchedule);

		addSchedule = new JButton(new ImageIcon("Icon/schedule.png"));
		editSchedule = new JButton(new ImageIcon("Icon/pen.png"));
		startMonth = new JButton(new ImageIcon("Icon/month.png"));
		endMonth = new JButton(new ImageIcon("Icon/month2.png"));
		searchSchedule = new JButton(new ImageIcon("Icon/search.png"));
		deleteSchedule = new JButton(new ImageIcon("Icon/delete.png"));
		printSchedule = new JButton(new ImageIcon("Icon/print.png"));
		exitSchedule = new JButton(new ImageIcon("Icon/exit.png"));


		searchText = new JTextField(15);
		searchText.setPreferredSize( new Dimension( 200, 60 ) );
		
		addNewDocument = new JButton(new ImageIcon("Icon/text.png"));
		editDocument = new JButton(new ImageIcon("Icon/load.png"));
		deleteDocument = new JButton(new ImageIcon("Icon/remove.png"));

		emptyLabel1 = new JLabel("                 ");
		emptyLabel2 = new JLabel("                ");
		

		topBar.add(addSchedule);
		topBar.add(editSchedule);
		topBar.add(startMonth);
		topBar.add(endMonth);
		topBar.add(searchText);
		topBar.add(searchSchedule);
		topBar.add(deleteSchedule);
		topBar.add(printSchedule);
		topBar.add(emptyLabel1);
		topBar.add(addNewDocument);
		topBar.add(editDocument);
		topBar.add(deleteDocument);
		topBar.add(emptyLabel2);
		topBar.add(exitSchedule);

		
		
		addComponent();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private boolean fileLoad()
	{
			
		DataIOController dataIOController = new DataIOController();
		dataIOController.fileLoad();

		GetDocumentDirectoryListController getDirectory = new GetDocumentDirectoryListController();
		documentDirectoryList = getDirectory.getDirectoryList();

		for( int i=0; i<documentDirectoryList.length; i++)
		{
			System.out.println(documentDirectoryList[i]);
		}

		//getTodayDocumentDirectory();

		return true;

	}
/////////////////////재영/////////////////////재영

	public void setSearchStart(String searchStartYear, String searchStartMonth, String searchStartDate, int start){
		this.searchStartYear = searchStartYear;
		this.searchStartMonth = searchStartMonth;
		this.searchStartDate = searchStartDate;
	}
	public void setSearchEnd(String searchEndYear, String searchEndMonth, String searchEndDate){
		this.searchEndYear = searchEndYear;
		this.searchEndMonth = searchEndMonth;
		this.searchEndDate = searchEndDate;
	}

	public void setModifyVariables(String modifyCode, String modifyName){
		this.modifyCode = modifyCode;
		 this.modifyName = modifyName;
	}

	public void setChoiceVariables(String year, String month, String date){
		this.choiceYear = year;
		this.choiceMonth = month;
		this.choiceDate = date;
	}
	public void reDisplay(){
		remove(dailySchedule);

		displayInfoController = new DisplayInfoController();
		monthController = new AMonthDayInfoController(displayInfoController);
		SimpleDayInfoController simpleController = new SimpleDayInfoController(choiceYear,choiceMonth,choiceDate,displayInfoController);
   
		dailySchedule = new DailySchedule(simpleController,this,choiceYear,choiceMonth,choiceDate);
		 modifyScheduleInfoUI.setDailySchedule(dailySchedule);
      //modifyScheduleInfoUI = new ModifyScheduleInfoUI(dailySchedule);
		add(dailySchedule,BorderLayout.CENTER);
      
		dailySchedule.revalidate();
	}
/////////////////////재영/////////////////////재영

	private void addComponent(){
		add(topBar,BorderLayout.NORTH);
		add(sidePanel, BorderLayout.WEST);
		add(dailySchedule, BorderLayout.CENTER);

		addListener();
	}
	private void addListener(){
		ActionListener listener = new DailyScheduleInfoActionListener();

		addSchedule.addActionListener(listener);
		editSchedule.addActionListener(listener);
		startMonth.addActionListener(listener);
		endMonth.addActionListener(listener);
		searchSchedule.addActionListener(listener);
		deleteSchedule.addActionListener(listener);
		printSchedule.addActionListener(listener);
		exitSchedule.addActionListener(listener);

		ActionListener documentListener = new DocumentInfoActionListener();
		addNewDocument.addActionListener(documentListener);
		editDocument.addActionListener(documentListener);
		deleteDocument.addActionListener(documentListener);
	}

	public void displayUI(){

		setVisible(true);
	}
	public void closeUI(){
/////////////////////재영/////////////////////재영
		DayScheduleInfoDAO.getInstance().fileSave();
/////////////////////재영/////////////////////재영
		setVisible(false);
		dispose();
	}
	
	public SchedulerUI returnFrame(){
		return this;
	}

	public String[][] makeSearchInfo(String [][] str){
      String [][]returnString = new String[str.length][2];

      for(int cnt=0; cnt<str.length; cnt++){
         returnString[cnt][0] = str[cnt][1];
         returnString[cnt][1] = str[cnt][2] + str[cnt][3] + str[cnt][4];
		}

		return returnString;
	}


	class DailyScheduleInfoActionListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if(e.getSource() == addSchedule){
            addScheduleInfoUI.display();
         }
         else if(e.getSource() == editSchedule){
            modifyScheduleInfoUI.display();
         }
         else if(e.getSource() == startMonth){
            new SearchMyCalendar(returnFrame(),"검색 시작일자").display();
         }
         else if(e.getSource() == endMonth){
            new SearchMyCalendar(returnFrame(),"검색 종료일자").display();
         }
         else if(e.getSource() == searchSchedule){
            SearchDayScheduleInfoController con = new SearchDayScheduleInfoController();
            String [][] returnStr = con.requestSearchDayScheduleInfo(searchText.getText(),new Date(Integer.parseInt(searchStartYear),Integer.parseInt(searchStartMonth),Integer.parseInt(searchStartDate)), 
               new Date(Integer.parseInt(searchEndYear),Integer.parseInt(searchEndMonth),Integer.parseInt(searchEndDate)));
         /*
            for(int row=0; row<returnStr.length; row++){
               for(int col=0; col<returnStr[row].length; col++){
                  System.out.println(returnStr[row][col]);
               }
            }*/

            searchText.setText("");
            SearchResultUI result = new SearchResultUI(makeSearchInfo(returnStr));
            result.set();
         
         }
         else if(e.getSource() == deleteSchedule){
            System.out.println("Delete Controller 생성!!!!!!");
            DeleteDayScheduleInfoController deleteController = new DeleteDayScheduleInfoController();
         /*
         try{
            Thread.sleep(1000);
         }
         catch(InterruptedException e){
            System.out.println(e.getMessage());
         }
         */
         //int k = 2000;
         //for(;;){k++; if(k==2000)break;}
         System.out.println("선택된 Code 값");
         System.out.println(dailySchedule.getCodeOfModify());
         boolean check = deleteController.requestDeleteDayScheduleInfo(dailySchedule.getCodeOfModify());
         if(check == true)
            System.out.println("삭제 완료!!!!!!!!!!!");
         else
            System.out.println("삭제 실패!!!!!!!!!!!");


         }
         else if(e.getSource() == printSchedule){
            System.out.println("일정 프린트하기");
         }
         else if(e.getSource() == exitSchedule){
            DataIOController dataIOController = new DataIOController();
            dataIOController.fileSave();
            //dataIOController.studyDocumentFileSave();
            closeUI();
         }
         else {}
      }
   }

	class DocumentInfoActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addNewDocument){
				try{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style 창
				}catch(Exception est){
					est.printStackTrace();
				}

				System.out.println("오늘 디렉토리: " + todayDocumentDirectory);

				AddStudyDocumentInfoController add = new AddStudyDocumentInfoController(todayDocumentDirectory);
				String newDocCode = add.addNewStudyDocumentInfo();
				//// 0531_1428 대섭슈졍
				String newDocCodeDB = add.addStudyDocumentInfoToDB(newDocCode, "새 문서", new Date(), todayDocumentDirectory, new StringBuilder(""), new StringBuilder(""));
				//// 0531_1428 대섭슈졍

				//System.out.println("     @@    " + newDocCodeDB);

				STKprojectTextUI stkProjectTextUI = new STKprojectTextUI(newDocCode);
				stkProjectTextUI.displayTextScreen( todayDocumentDirectory);
			}
			else if(e.getSource() == editDocument){
//////////////////////////////슈정1
				try{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style 창
				}catch(Exception est){
					est.printStackTrace();
				}

				//System.out.println( dailySchedule.getTableValue() + "   요고 선턱임");
/*
				STKprojectTextUI stkProjectTextUI = new STKprojectTextUI(simpleDayDocumentList[table.getSelectedRow()][0]);
				stkProjectTextUI.displayTextScreen(state);
				stkProjectTextUI.setVisible(true);
*/


				DocumentOpenUI open = new DocumentOpenUI("파일불러오기");
				open.set();
//////////////////////////////슈정1
			}
			else if(e.getSource() == deleteDocument){
				try{
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style 창
				}catch(Exception est){
					est.printStackTrace();
				}
				DocumentDeleteUI delete = new DocumentDeleteUI("파일삭제하기");
				delete.set();
			}
			else {}
		}
	}

}
