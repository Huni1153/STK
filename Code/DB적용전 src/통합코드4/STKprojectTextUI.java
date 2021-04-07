import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class STKprojectTextUI extends JFrame
{
	private Container contentPane;

	final private JToolBar topToolBar = new JToolBar("Top Tool Bar");
	final private JToolBar leftToolBar = new JToolBar("Left Tool Bar", JToolBar.VERTICAL);

	private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

	//private JTextArea leftArea;
	//private JTextArea rightArea;

	private JTextPane leftArea;
	private JTextPane rightArea;
//////////////
	private String currentDirectoryName;
////////////////
	final private JButton tNew = new JButton(new ImageIcon("images/tNew.png"));
	final private JButton tOpen = new JButton(new ImageIcon("images/tOpen.png"));
	final private JButton tSave = new JButton(new ImageIcon("images/tSave.png"));
	final private JButton tSaveAs = new JButton(new ImageIcon("images/tSaveAs.png"));
	final private JButton tPrint = new JButton(new ImageIcon("images/tPrint.png"));
	final private JButton tDelete = new JButton(new ImageIcon("images/tDelete.png"));

	final private JButton tUndo = new JButton(new ImageIcon("images/tUndo.png"));
	final private JButton tRedo = new JButton(new ImageIcon("images/tRedo.png"));

	final private JButton tFont = new JButton(new ImageIcon("images/tFont.png"));
	final private JButton tCut = new JButton(new ImageIcon("images/tCut.png"));
	final private JButton tCopy = new JButton(new ImageIcon("images/tCopy.png"));
	final private JButton tPaste = new JButton(new ImageIcon("images/tPaste.png"));

	final private JButton tFormat = new JButton(new ImageIcon("images/tFormat.png"));
	final private JButton tComment = new JButton(new ImageIcon("images/tComment.png"));
	
	final private JButton tCalc = new JButton(new ImageIcon("images/tCalc.png"));
	final private JButton tClose = new JButton(new ImageIcon("images/tClose.png"));

	private String pad;

//////////////////////////////////0513_�뼷�߰�
	private boolean m_resizing = false;
	private String[] documentDirectoryList;	// ��ü ���丮 ����Ʈ
	private String[][] simpleDayDocumentList;	// ���� ��¥�� ��ü java���� ����Ʈ
	private Object[] currentDocumentArr;	// ���� ������ ����.
	private String currentDocCode;
///////////////////////////////////0513_�뼷�߰�
	
	public STKprojectTextUI()
	{

	}


	public STKprojectTextUI(String currentDocCode)
	{
		super("Document_STK");

		// ��ü ���� �����´�.
////////////////////0513_�뼷�߰�
		documentDirectoryList = new GetDocumentDirectoryListController().getDirectoryList();	// �ҷ����⸦ ���� ��Ʈ�ѷ�
		this.currentDocCode = currentDocCode;
		
		
////////////////////0513_�뼷�߰�
		
		//textFileName = "TextEditor_STK";
	}

	public void displayTextScreen(String currentDirectoryName) 
	{
////////////////////0513_�뼷�߰�
		//System.out.println(" ���߿� " +  currentDocCode);
		CurrentDocumentInfoController currentDocumentInfo = new CurrentDocumentInfoController();
		currentDocumentArr = currentDocumentInfo.getCurrentDocumentInfo(currentDocCode, currentDirectoryName);
		this.currentDirectoryName = currentDirectoryName;

		//System.out.println(" ���߿�.......... " + currentDocumentArr[0]);
		setTitle((String)currentDocumentArr[1]);
		simpleDayDocumentList = new SimpleDayDocumentController().getSimpleDayDocument(currentDirectoryName);	// �ҷ����⸦ ���� ��Ʈ�ѷ�
////////////////////0513_�뼷�߰�

		contentPane = getContentPane();


		setLeftButtons();
		setTopButtons();

		createTopToolBar();
		createLeftToolBar();
		createTextPane();
//-------------------------------�ڼ��� 0514 ����--------------------------------------------
		ActionMap am = leftArea.getActionMap();
		am.put(DefaultEditorKit.insertBreakAction, new IndentBreakAction());
//---------------------------------�������---------------------------------------------------
		ShortCutListener shortCutListener = new ShortCutListener();
		leftArea.addKeyListener(shortCutListener);

//		addListener();

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 50, 1400, 800);
		setVisible(true);

		//setDivider();
	}



	class TopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {


			if(e.getSource() == tUndo) {
				JOptionPane.showMessageDialog(null,"�� Undo��ư�� Ŭ���ߴ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(e.getSource() == tRedo) {
				JOptionPane.showMessageDialog(null,"�� Redo��ư�� Ŭ���ߴ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tCut)
			{
				pad = leftArea.getSelectedText();
				JOptionPane.showMessageDialog(null,"�� Cut��ư�� Ŭ���ߴ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tCopy)
			{
				pad = leftArea.getSelectedText();
				JOptionPane.showMessageDialog(null,"�� Copy��ư�� Ŭ���ߴ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tPaste)
			{
				JOptionPane.showMessageDialog(null,"�� Paste��ư�� Ŭ���ߴ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tComment)
			{
				JOptionPane.showMessageDialog(null,"�� Block Comment��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}	
			else if(e.getSource() == tFont) {
				FontStyleView fontStyleView = new FontStyleView(leftArea);	// ���⼭ ���� textArea ta �� ����(fontStyleView Class) ���� �Ѱܼ� ���� ����
				fontStyleView.display();
			}
			else if(e.getSource() == tCalc) {
				Calculator cal = new Calculator();
				cal.setBounds(1500, 0, 300, 400);
				cal.pack();
				cal.setVisible(true);
			}
			else if(e.getSource() == tClose) {

				int result = JOptionPane.showConfirmDialog(null,"���� ������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					StringReader sr = new StringReader(leftArea.getText()); 
					BufferedReader br = new BufferedReader(sr);
					
					StringReader sr2=new StringReader(rightArea.getText());
					BufferedReader br2=new BufferedReader(sr2);
					String leftLine = "";
					String rightLine="";
					StringBuilder right=new StringBuilder();
					StringBuilder left=new StringBuilder();
					StringTokenizer strTz;
////////////////////////////////////////////////////////////////////////////////////////
					while (true)
					{
						try
						{
							leftLine = br.readLine();
							rightLine=br2.readLine();
							if(rightLine==null)
							{
								rightLine="";
								right.append(rightLine);
								if(leftLine == null)
								{
									leftLine="";
									left.append(leftLine);
									break;
								}
								else
								{
									left.append(leftLine+"\n");
								}
							}
							else
							{
								if(leftLine == null)
								{
									leftLine="";
								}
								else
								{
									left.append(leftLine+"\n");
								}
								right.append("//"+rightLine+"\n");
							
							}
						}
						catch (IOException ee)
						{
							ee.printStackTrace();
						}
					}
					SaveCheckController sCheck=new SaveCheckController();
					if(sCheck.saveCheck(currentDocCode,(String)currentDocumentArr[2]))
					{
						DocumentSaveAsUI saveAs=new DocumentSaveAsUI(currentDocCode,(String)currentDocumentArr[2],left,right);
						if(saveAs.set())
						{
							dispose();
						}
						else
						{
						}
					}
					else
					{
						SaveStudyDocumentInfoController save=new  SaveStudyDocumentInfoController();
						save.createJava((String)currentDocumentArr[1],left,right,".java");
						save.saveStudyDocumentInfo(currentDocCode,(String)currentDocumentArr[2],left,right);
						dispose();
					}
				}
				//-------------------------------�ڼ��� 0514 ����--------------------------------------------
				else if(result == JOptionPane.NO_OPTION)
				{
					DeleteStudyDocumentInfoController delete=new DeleteStudyDocumentInfoController();
					if(delete.deleteCheck(currentDocCode,(String)currentDocumentArr[2]))
					{
						delete.deleteNewStudyDocumentInfo(currentDocCode,(String)currentDocumentArr[2]);
					}
					dispose();
					//JOptionPane.showMessageDialog(null,"�� ������ �����ʰ� ���� �Ѵ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
					//System.exit(1);

					//DataIOController dataIOController = new DataIOController();
					//dataIOController.fileSave();
				}
				//-------------------------------�������--------------------------------------------
				else if(result == JOptionPane.CANCEL_OPTION)
				{
					JOptionPane.showMessageDialog(null,"�� ��Ҹ� ������", "��ư", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	};


	class LeftListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tNew) {
				//JOptionPane.showMessageDialog(null,"�� New��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);

				int result = JOptionPane.showConfirmDialog(null, 
							"���ο� ������ ���� �Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					/*String newDocCode = new AddStudyDocumentInfoController().addNewStudyDocumentInfo(currentDirectoryName);
					STKprojectTextUI s = new STKprojectTextUI(newDocCode);
					s.displayTextScreen(currentDirectoryName, newDocCode);*/
				}
			}
			else if(e.getSource() == tOpen) 
			{
				FileLoadUI open = new FileLoadUI("���Ϻҷ�����");
				open.set();
				//JOptionPane.showMessageDialog(null,"�� Open ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}



////////////////////////////// ����1
			else if (e.getSource() == tSave) // �ڼ��� ����
			{
	/////////////////////////////////////////////////////////////////////////////// ���پ� �о ǥ�� ���
				StringReader sr = new StringReader(leftArea.getText()); 
				BufferedReader br = new BufferedReader(sr);
				
				StringReader sr2=new StringReader(rightArea.getText());
				BufferedReader br2=new BufferedReader(sr2);
				String leftLine = "";
				String rightLine="";
				StringBuilder right=new StringBuilder();
				StringBuilder left=new StringBuilder();
				StringTokenizer strTz;
////////////////////////////////////////////////////////////////////////////////////////
				while (true){
					try
					{
						leftLine = br.readLine();
						rightLine=br2.readLine();
						if(rightLine==null)
						{
							rightLine="";
							right.append(rightLine);
							if(leftLine == null)
							{
								leftLine="";
								left.append(leftLine);
								break;
							}
							else
							{
								left.append(leftLine+"\n");
							}
						}
						else
						{
							if(leftLine == null)
							{
								leftLine="";
							}
							else
							{
								left.append(leftLine+"\n");
							}
							
							right.append("//"+rightLine+"\n");
							
						}
					}
					catch (IOException ee)
					{
						ee.printStackTrace();
					}
				}
				SaveCheckController sCheck=new SaveCheckController();
				if(sCheck.saveCheck(currentDocCode,(String)currentDocumentArr[2]))
				{
					DocumentSaveAsUI saveAs=new DocumentSaveAsUI(currentDocCode,(String)currentDocumentArr[2],left,right);
					saveAs.set();
				}
				else
				{
					SaveStudyDocumentInfoController save=new  SaveStudyDocumentInfoController();
					save.createJava((String)currentDocumentArr[1],left,right,".java");
					if(save.saveStudyDocumentInfo(currentDocCode,(String)currentDocumentArr[2],left,right))
					{
						JOptionPane.showMessageDialog(null,"���� �Ϸ�!", "��ư", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"���� �Ϸ�!", "��ư", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
			else if (e.getSource() == tSaveAs)   // �ڼ��� ����
			{
		
				StringReader sr = new StringReader(leftArea.getText()); 
				BufferedReader br = new BufferedReader(sr);
				
				StringReader sr2=new StringReader(rightArea.getText());
				BufferedReader br2=new BufferedReader(sr2);
				String leftLine = "";
				String rightLine="";
				StringBuilder right=new StringBuilder();
				StringBuilder left=new StringBuilder();
				StringTokenizer strTz;
/////////////////////////////////////////////////////////////////////////////////////////
				while (true){
					try
					{
						leftLine = br.readLine();
						rightLine=br2.readLine();
						if(rightLine==null)
						{
							rightLine="";
							right.append(rightLine);
							if(leftLine == null)
							{
								leftLine="";
								left.append(leftLine);
								break;
							}
							else
							{
								left.append(leftLine+"\n");
							}
						}
						else
						{
							if(leftLine == null)
							{
								leftLine="";
								left.append(leftLine);
							}
							else
							{
								left.append(leftLine+"\n");
							}
						
							right.append("//"+rightLine+"\n");
							
						}
					}
					catch (IOException ee)
					{
						ee.printStackTrace();
					}
				}
				DocumentSaveAsUI saveAs=new DocumentSaveAsUI(currentDocCode,(String)currentDocumentArr[2],left,right);
				saveAs.set();
			}
////////////////////////////// ����1

			else if (e.getSource() == tPrint)
			{
				JOptionPane.showMessageDialog(null,"�� Print ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tDelete)
			{
				DeleteStudyDocumentInfoController delete=new DeleteStudyDocumentInfoController();
				delete.deleteStudyDocumentInfo(currentDocCode,(String)currentDocumentArr[2]);
				dispose();
				//JOptionPane.showMessageDialog(null,"�� Delete ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}	
			
		}
	}
	

	// ���� ToolBar ��ư��.  ������, ����Ű ����
	private void setTopButtons()
	{
		TopListener topListener = new TopListener();
		tCalc.addActionListener(topListener);
		tClose.addActionListener(topListener);
		tFont.addActionListener(topListener);
		tCut.addActionListener(topListener);
		tCopy.addActionListener(topListener);
		tPaste.addActionListener(topListener);
		tUndo.addActionListener(topListener);
		tRedo.addActionListener(topListener);
		tComment.addActionListener(topListener);

		tCalc.getModel().setMnemonic('U');
		KeyStroke keyStroke = KeyStroke.getKeyStroke('U', Event.CTRL_MASK, true);
        tCalc.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		tClose.getModel().setMnemonic('Q');
		keyStroke = KeyStroke.getKeyStroke('Q', Event.CTRL_MASK, false);
        tClose.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		tFont.getModel().setMnemonic('F');
		keyStroke = KeyStroke.getKeyStroke('F', Event.CTRL_MASK, false);
        tFont.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		tCut.getModel().setMnemonic('X');
		keyStroke = KeyStroke.getKeyStroke('X', Event.CTRL_MASK, false);
        tCut.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		tCopy.getModel().setMnemonic('C');
		keyStroke = KeyStroke.getKeyStroke('C', Event.CTRL_MASK, false);
        tCopy.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		tPaste.getModel().setMnemonic('V');
		keyStroke = KeyStroke.getKeyStroke('V', Event.CTRL_MASK, false);
        tPaste.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

		tComment.getModel().setMnemonic('M');
		keyStroke = KeyStroke.getKeyStroke('M', Event.CTRL_MASK, false);
        tComment.registerKeyboardAction(topListener, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
	}


	private void setLeftButtons()
	{
		LeftListener leftListener = new LeftListener();
		tNew.addActionListener(leftListener);
		tOpen.addActionListener(leftListener);
		tSave.addActionListener(leftListener);
		tSaveAs.addActionListener(leftListener);
		tPrint.addActionListener(leftListener);
		tDelete.addActionListener(leftListener);

		tNew.setMnemonic(KeyEvent.VK_N);
		tOpen.setMnemonic(KeyEvent.VK_O);
		tSave.setMnemonic(KeyEvent.VK_V);
		tSaveAs.setMnemonic(KeyEvent.VK_A);
		tPrint.setMnemonic(KeyEvent.VK_P);
		tDelete.setMnemonic(KeyEvent.VK_D);
	}

////// ����////// ����////// ����
	public void setTextAreaShortCut(int count)
	{
		
		//leftArea.insert(" #1");
		//rightArea.setText("#1");
		StyledDocument leftDoc = leftArea.getStyledDocument();
		StyledDocument rightDoc = rightArea.getStyledDocument();
		
		//���߿� ����
		SimpleAttributeSet green = new SimpleAttributeSet();
		StyleConstants.setForeground(green, Color.GREEN);
		SimpleAttributeSet black = new SimpleAttributeSet();
		StyleConstants.setForeground(black, Color.BLACK);

		try
		{
			leftDoc.insertString(leftDoc.getLength(), " #"+count+"\n", null);
			rightDoc.insertString(rightDoc.getLength(), "\n#"+count+" ", green);
			rightDoc.insertString(rightDoc.getLength(), " ", black);
		}
		catch (Exception e)
		{
			System.out.println("insertString() ����");
		}
		//rightArea.setCaretPosition(rightArea.getDocument().getLength());
		rightArea.setCaretPosition(0);
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				rightArea.grabFocus();
				rightArea.requestFocus();
				rightArea.setCaretPosition(rightArea.getDocument().getLength());
				//rightArea.getDocument().insertString(rightArea.getDocument().getLength(), "", black);
			}
		});
	}
	//-------------------------------�ڼ��� 0514 ����--------------------------------------------
	// ���� �鿩����
	class IndentBreakAction extends TextAction
    {
         /**
         * Creates this object with the appropriate identifier.
         */
        public IndentBreakAction()
        {
            super(DefaultEditorKit.insertBreakAction);
        }

        /**
         * The operation to perform when this action is triggered.
         *
         * @param e the action event
         */
        public void actionPerformed(ActionEvent e)
        {
            JTextComponent target = getTextComponent(e);

            if (target == null) return;

            if ((! target.isEditable()) || (! target.isEnabled()))
            {
                UIManager.getLookAndFeel().provideErrorFeedback(target);
                return;
            }

            try
            {
                //  Determine which line we are on

                Document doc = target.getDocument();
                Element rootElement = doc.getDefaultRootElement();
                int selectionStart = target.getSelectionStart();
                int line = rootElement.getElementIndex( selectionStart );

                //  Get the text for this line

                int start = rootElement.getElement(line).getStartOffset();
                int end = rootElement.getElement(line).getEndOffset();
                int length = end - start;
                String text = doc.getText(start, length);
                int offset = 0;

                //  Get the number of white spaces characters at the start of the line

                for (offset = 0; offset < length; offset++)
                {
                    char c = text.charAt(offset);

                    if (c != ' ' && c != '\t')
                        break;
                }

                //  When splitting the text include white space at start of line
                //  else do default processing

                if (selectionStart - start > offset)
                    target.replaceSelection("\n" + text.substring(0, offset) );
                else
                    target.replaceSelection("\n");
            }
            catch(BadLocationException ble) {}
        }
    }
//---------------------------------�������------------------------------------------------
	
	class ShortCutListener implements KeyListener
	{
		int tab=0;
		int count=1;
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_F2)
			{
				setTextAreaShortCut(count);
				count++;
			}
		}
		public void keyTyped(KeyEvent e)
		{
		}
		public void keyReleased(KeyEvent e)
		{

		}
	}
////// ����
	private void createTopToolBar()
	{
		JLabel label = new JLabel("��������������������");

		topToolBar.setLayout(new BorderLayout());

		JPanel topLeftPanel = new JPanel();
		topLeftPanel.add(tUndo);
		topLeftPanel.add(tRedo);
		topToolBar.add(topLeftPanel, BorderLayout.WEST);

		JPanel topPanel = new JPanel();
		topPanel.add(tFont);
		topPanel.add(tCut);
		topPanel.add(tCopy);
		topPanel.add(tPaste);
		topPanel.add(label);
		topPanel.add(tFormat);
		topPanel.add(tComment);
		topToolBar.add(topPanel, BorderLayout.CENTER);

		JPanel topRightPanel = new JPanel();
		topRightPanel.add(tCalc);
		topRightPanel.add(tClose);
		topToolBar.add(topRightPanel, BorderLayout.EAST);

		//topToolBar.add(tCalc, BorderLayout.EAST);

		tUndo.setToolTipText("Undo");
		tRedo.setToolTipText("Redo");
		tFont.setToolTipText("�۲� ���� ( Ctrl+F )");
		tCut.setToolTipText("�ڸ��� ( Ctrl+X )");
		tCopy.setToolTipText("�����ϱ� ( Ctrl+C )");
		tPaste.setToolTipText("�ٿ��ֱ� ( Ctrl+V )");
		//tFormat.setToolTipText("����");
		tComment.setToolTipText("�ּ�ó��");
		tCalc.setToolTipText("���� ( Ctrl+U )");
		tClose.setToolTipText("���� ( Ctrl+Q )");


		contentPane.add(topToolBar, BorderLayout.NORTH);
	}

	private void createLeftToolBar()
	{
		leftToolBar.add(tNew);
		leftToolBar.addSeparator();
		leftToolBar.addSeparator();
		leftToolBar.add(tOpen);
		leftToolBar.addSeparator();			// ���� ���̿� �� ǥ��
		leftToolBar.addSeparator();
		leftToolBar.add(tSave);
		leftToolBar.addSeparator();
		leftToolBar.add(tSaveAs);
		leftToolBar.addSeparator();
		leftToolBar.addSeparator();
		leftToolBar.add(tPrint);
		leftToolBar.addSeparator();
		leftToolBar.addSeparator();
		leftToolBar.add(tDelete);
		leftToolBar.addSeparator();

		tNew.setToolTipText("�� ���� ( Alt+N )");
		tOpen.setToolTipText("���� ( Alt+O )");
		tSave.setToolTipText("���� ( Alt+V )");
		tSaveAs.setToolTipText("�ٸ� �̸����� ���� ( Alt+A )");
		tPrint.setToolTipText("�μ� ( Alt+P )");
		tDelete.setToolTipText("���� ( Alt+D )");

		contentPane.add(leftToolBar, BorderLayout.WEST);
	}

	private int findLastNonWordChar (String text, int index) {
        while (--index >= 0) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
        }
        return index;
    }

    private int findFirstNonWordChar (String text, int index) {
        while (index < text.length()) {
            if (String.valueOf(text.charAt(index)).matches("\\W")) {
                break;
            }
            index++;
        }
        return index;
    }



	private void createTextPane() 
	{
		final StyleContext cont = StyleContext.getDefaultStyleContext();
        final AttributeSet attrRed = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.RED);
		final AttributeSet attrBlue = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
		final AttributeSet attrGreen = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN);
        final AttributeSet attrBlack = cont.addAttribute(cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
        

		
		DefaultStyledDocument doc = new DefaultStyledDocument() {

            public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
                super.insertString(offset, str, a);
				

                String text = getText(0, getLength());
                int before = findLastNonWordChar(text, offset);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offset + str.length());
                int wordL = before;
                int wordR = before;
				
                while (wordR <= after) {
                    if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) {
                        if (text.substring(wordL, wordR).matches("(\\W)*(String|Exception|System)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrRed, false);
						else if (text.substring(wordL, wordR).matches("(\\W)*(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|if|goto|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
						else if (text.substring(wordL, wordR).matches("(\\W)*(//)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrGreen, false);
                        else
						{
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
						}
                        wordL = wordR;
                    }
                    wordR++;

					//System.out.println("{"+tab+"�� ����");
					
					//System.out.println(wordR);
                }
            }

            public void remove (int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String text = getText(0, getLength());

				

                int before = findLastNonWordChar(text, offs);
                if (before < 0) before = 0;
                int after = findFirstNonWordChar(text, offs);

                if (text.substring(before, after).matches("(\\W)*(String|Exception|System)")) 
				{
                    setCharacterAttributes(before, after - before, attrRed, false);
                } 
				else if (text.substring(before, after).matches("(\\W)*(//)"))
				{
					setCharacterAttributes(before, after - before, attrGreen, false);
				}
				else if (text.substring(before, after).matches("(\\W)*(abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|if|goto|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while|true|false|null)"))
				{
					setCharacterAttributes(before, after - before, attrBlue, false);
				}
				
				else 
				{
                    setCharacterAttributes(before, after - before, attrBlack, false);
                }
            }
        };




		leftArea = new JTextPane(doc);
		rightArea = new JTextPane();

		
		

		System.out.println(currentDocumentArr[3]);
		System.out.println(currentDocumentArr[4]);

		leftArea.setText(currentDocumentArr[3].toString());
		rightArea.setText(currentDocumentArr[4].toString());

		leftArea.setSelectionColor(Color.GREEN);

		ComponentListener cListen = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				if (!m_resizing) {
					m_resizing = true;
					splitPane.setDividerLocation(splitPane.getSize().width /5*3);
					m_resizing=false;
				}
			}
		};
		splitPane.addComponentListener(cListen);
	


		JScrollPane leftScroll = new JScrollPane(leftArea);
		JScrollPane rightScroll = new JScrollPane(rightArea);

//////////////////////
		LeftTextLineNumber tln1 = new LeftTextLineNumber(leftArea);
		leftScroll.setRowHeaderView(tln1);
		RightTextLineNumber tln2 = new RightTextLineNumber(rightArea);
		rightScroll.setRowHeaderView(tln2);
/////////////////////

		//splitPane.setBackground(Color.BLACK);

		splitPane.setLeftComponent(leftScroll);
		splitPane.setRightComponent(rightScroll);

		//splitPane.setDividerLocation(0.8);
		splitPane.setOneTouchExpandable(true);

		//contentPane.setBackground(Color.BLACK);

		contentPane.add(splitPane, BorderLayout.CENTER);
	}
	

	/*private void jTextPane1KeyTyped(java.awt.event.KeyEvent evt) {                                    

		String SyntaxedCode = leftArea.getText();
		leftArea.setText(SyntaxedCode.replaceAll("//", "<span style='color: green'>//</span>"));
	
	}*/
	


	/*
	public static void main(String[] agrs)
	{

		print();

	}

	public static void print()
	{
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style â
		}catch(Exception e){
			e.printStackTrace();
		}
		STKprojectTextUI s = new STKprojectTextUI();
		s.displayTextScreen();

	}*/

	/*private void setDivider() {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                //mainSplittedPane.setDividerLocation(mainSplittedPane.getSize().height /2);
				splitPane.setDividerLocation(splitPane.getSize().width /5*3);
                //mainSplittedPane.setDividerLocation(mainSplittedPane.getSize().width /2);
            }
        });
    }*/
	//splitPane.setDividerLocation(0.8);
	
}