import java.awt.event.*;
import java.awt.print.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;

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

	String pad;




	public STKprojectTextUI()
	{
		super("Document_STK");
		
		//textFileName = "TextEditor_STK";
	}

	public void displayTextScreen() 
	{
		contentPane = getContentPane();

		setLeftButtons();
		setTopButtons();

		createTopToolBar();
		createLeftToolBar();
		createTextPane();

//		addListener();

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1025);
		setVisible(true);
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
				FontStyleView FontStyleView = new FontStyleView(leftArea);	// ���⼭ ���� textArea ta �� ����(fontStyleView Class) ���� �Ѱܼ� ���� ����
				FontStyleView.setBounds(585, 110, 400, 500);
				FontStyleView.setVisible(true);
			}
			else if(e.getSource() == tCalc) {
				Calculator cal = new Calculator();
				cal.setBounds(1500, 0, 300, 400);
				cal.pack();
				cal.setVisible(true);
			}
			else if(e.getSource() == tClose) {

				int result = JOptionPane.showConfirmDialog(null, 
							"���� ������ �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.YES_OPTION)
				{
					JOptionPane.showMessageDialog(null,"�� ������ �Ѵ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//System.exit(1);
				}
				else if(result == JOptionPane.NO_OPTION)
				{
					JOptionPane.showMessageDialog(null,"�� ������ �����ʰ� ���� �Ѵ�", "��ư", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//System.exit(1);
				}
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
					STKprojectTextUI s = new STKprojectTextUI();
					s.displayTextScreen();
				}
			}
			else if(e.getSource() == tOpen) 
			{
				FileLoadUI open=new FileLoadUI("���Ϻҷ�����");
				open.set();
				//JOptionPane.showMessageDialog(null,"�� Open ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tSave)
			{
				int i=0;
				int j=0;
				//JOptionPane.showMessageDialog(null,"�� Save ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);

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
				while(true)
				{
					try
					{
						leftLine = br.readLine();
						if(leftLine==null){break;}
						i++;				
					}
					catch (IOException ioe)
					{
						ioe.printStackTrace();
					}
				}
				String[] str=new String[i];
				i=0;
				sr = new StringReader(leftArea.getText()); 
				br = new BufferedReader(sr);
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
			//					str[i]=leftLine;
								break;
							}
							else
							{
								left.append(leftLine);
								str[i]=leftLine;
							}
						}
						else
						{
							strTz=new StringTokenizer(rightLine,"#",true);
							if(leftLine == null)
							{
								leftLine="";
								str[i]=leftLine;
							}
							if(rightLine.equals(""))
							{
								rightLine="#";
							}
							left.append(leftLine);
							
							str[i]=leftLine;
							//System.out.println(str[i]);
							
							right.append(rightLine);
							if(strTz!=null)
							{
								while(strTz.hasMoreTokens())
								{
									String ch=strTz.nextToken();
									if(ch.equals("#"))
									{
										j++;
									}
									else if(!ch.equals("#"))
									{
										str[j]+=ch;
									}
								}
							}
						}
					}
					catch (IOException ee)
					{
						ee.printStackTrace();
					}
					i++;
				}
				for(int r=0;r<str.length;r++)
				{
					System.out.println(str[4]);
				}
				FileSaveUI save=new FileSaveUI(left,right);
				save.set();
	///////////////////////////////////////////////////////////////////////////////
			}
			else if (e.getSource() == tSaveAs)
			{
				JOptionPane.showMessageDialog(null,"�� SaveAs ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tPrint)
			{
				JOptionPane.showMessageDialog(null,"�� Print ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}
			else if (e.getSource() == tDelete)
			{
				JOptionPane.showMessageDialog(null,"�� Delete ��ư�� Ŭ���ߴ�. ������ ������������", "��ư", JOptionPane.INFORMATION_MESSAGE);
			}	
			
		}
	};

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

	private void createTopToolBar()
	{
		JLabel label = new JLabel("����������������������������������������");

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
						else if (text.substring(wordL, wordR).matches("(\\W)*(private|public|protected)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrBlue, false);
						else if (text.substring(wordL, wordR).matches("(\\W)*(lo)"))
                            setCharacterAttributes(wordL, wordR - wordL, attrGreen, false);
                        else
                            setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
                        wordL = wordR;
                    }
                    wordR++;
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
					System.out.println(text);
                    setCharacterAttributes(before, after - before, attrRed, false);
                } 
				else if (text.substring(before, after).matches("(\\W)*(lo)"))
				{
					setCharacterAttributes(before, after - before, attrGreen, false);
				}
				else if (text.substring(before, after).matches("(\\W)*(private|public|protected)"))
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
		//leftArea = new JTextPane();
		rightArea = new JTextPane();

/*
		leftArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                //jTextPane1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
               // jTextPane1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPane1KeyTyped(evt);
            }
        });*/

	  
		//cont.setBackground(Color.black);

		//leftArea.setBackground(Color.black);
		//leftArea.setForeground(Color.white);
		//leftArea.setBackground(new Color(100,0,0,0));
		leftArea.setSelectionColor(Color.GREEN);
		//leftArea.setOpaque(false);
		//leftArea.setBackground(new Color(100,0,0,0));
/*
		leftArea.setUI(new BasicSplitPaneUI() {
            public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                public void setBorder(Border b) {
                }

                @Override
                    public void paint(Graphics g) {
                    g.setColor(Color.black);
                    g.fillRect(0, 0, getSize().width, getSize().height);
                        super.paint(g);
                    }
            };
            }
        });*/


		JScrollPane leftScroll = new JScrollPane(leftArea);
		JScrollPane rightScroll = new JScrollPane(rightArea);

//////////////////////
		TextLineNumber tln1 = new TextLineNumber(leftArea);
		leftScroll.setRowHeaderView(tln1);
		//leftScroll.setBackground(Color.BLACK);
		TextLineNumber tln2 = new TextLineNumber(rightArea);
		rightScroll.setRowHeaderView(tln2);
/////////////////////

		//splitPane.setBackground(Color.BLACK);

		splitPane.setLeftComponent(leftScroll);
		splitPane.setRightComponent(rightScroll);

		splitPane.setDividerLocation(1000);
		splitPane.setOneTouchExpandable(true);

		//contentPane.setBackground(Color.BLACK);

		contentPane.add(splitPane, BorderLayout.CENTER);
	}

	/*private void jTextPane1KeyTyped(java.awt.event.KeyEvent evt) {                                    

		String SyntaxedCode = leftArea.getText();
		leftArea.setText(SyntaxedCode.replaceAll("//", "<span style='color: green'>//</span>"));
	
	}*/
	



	public static void main(String[] agrs)
	{
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	// Nimbus style â
		}catch(Exception e){
			e.printStackTrace();
		}
		STKprojectTextUI s = new STKprojectTextUI();
		s.displayTextScreen();
	}
}