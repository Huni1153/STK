package Model;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;

public class SearchResultUI extends JDialog
{
   private JPanel panel,bottumPanel;
   private JLabel lDate,lIcon;
   private JTable table;
   private JButton bCheck;
   private JButton bCancel;
   private GridBagConstraints c;
   private DefaultTableModel model;
   private JScrollPane scrollPane;

   private String [][]resultString;

   public SearchResultUI(String [][]resultString){
      this.setTitle("검색 결과");
      this.setModal(true);
      this.panel=new JPanel(new GridBagLayout());
      this.bottumPanel=new JPanel();
      this.c=new GridBagConstraints();
      this.setPreferredSize(new Dimension(400,470));
      this.setLocation(200,200);
      this.lDate=new JLabel("검색하기",JLabel.CENTER);
      this.bCheck=new JButton("확인");
      this.bCancel=new JButton("취소");

      this.resultString = resultString;

      String[] str={"일정 제목","일정 일자"};
      //this.model=new DefaultTableModel(str,0);
      this.model=new DefaultTableModel(resultString,str);

   }
   public void set()
   {
      c.insets=new Insets(10,10,10,10);

      c.gridx=0;
      c.gridy=0;
      c.gridwidth=2;
      Image calImg=new ImageIcon("Icon/Search (2).png").getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
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
      this.bCheck.setForeground(Color.BLACK);
      bottumPanel.add(bCheck);


      this.bCancel.setBackground(new Color(79,129,189));
      this.bCancel.setForeground(Color.BLACK);
      bottumPanel.add(bCancel);
      
      this.bCheck.addActionListener(new SearchResultUIListener());
      this.bCancel.addActionListener(new SearchResultUIListener());

      this.add(panel,BorderLayout.NORTH);
      this.add(bottumPanel,BorderLayout.SOUTH);
      this.setResizable(false);
      super.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      this.pack();
      this.setVisible(true);
   }
   public void closeUI(){
      this.dispose();

   }

   class SearchResultUIListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource()==bCheck){
            closeUI();
         }
         else if(e.getSource() == bCancel){
            closeUI();
         }

         
      }
   }

}