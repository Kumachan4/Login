// Sample_ListBox_Main.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Sample_ListBox_Main {
  public static void main(String args[]){
    new Sample_ListBox_Sub ();
  }
}

// Panel表示クラス
class Sample_ListBox_Sub extends JFrame{

  JPanel  Title_panel ;
  JPanel  Main_panel ;

  JButton End_Button ;
  JButton Start_Button ;

  JLabel Title_label ;

  DefaultListModel<String> model;

  // コンストラクタ
 Sample_ListBox_Sub (){

    setTitle("Login");
    setBounds(100, 100, 640, 360);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

	Title_panel = new JPanel();
	Title_panel.setBounds(50, 10, 500, 50);
	Title_panel.setBackground(Color.DARK_GRAY);
   	Title_panel.setVisible(true);
	Title_panel.setLayout(new BorderLayout());

   	Title_label = new JLabel("登録情報");
    	Title_label.setPreferredSize(new Dimension(200, 50));
    	Title_label.setBackground(Color.WHITE);
	Title_label.setForeground(Color.WHITE);
	Title_label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
 	Title_label.setHorizontalAlignment(JLabel.CENTER);
	Title_label.setVerticalAlignment(JLabel.CENTER);
	Title_panel.add(Title_label);

	Main_panel = new JPanel();
	Main_panel.setBounds(50, 80, 500, 200);
	Main_panel.setBackground(Color.LIGHT_GRAY);
	Main_panel.setLayout(null);
   	 
	ArrayList<ArrayList<String>> dbTable = new ArrayList<>();
	Sample_dbSelect dbSelect = new Sample_dbSelect ( dbTable ); 

        model = new DefaultListModel<String>();

	// 取得したデータの表示
	int i = 0 ;
	for ( ArrayList<String> Row : dbTable ) {
	  String Item = "";
	  for ( String Col : Row ) { Item = Item + " : " + Col ; }
	  model.add(i, Item );
	  i++ ;         
	  // System.out.println( "MODEL:" + Item );
	}

	/* JListの初期データ */
	// String[] initData = {"Blue", "Green", "Red", "Whit", "Black"};
	// JList<String> Data_list = new JList<String>( initData );

	JList<String> Data_list = new JList<String>( model );
	Data_list.setBounds(20, 20, 450, 130);
	// Data_list.setVisible(true);
	Main_panel.add(Data_list);

	End_Button = new JButton("終了");
	End_Button.setBounds(400,155, 80, 40);
	End_Button.setBackground(Color.WHITE);
	End_Button.addActionListener(new Botton_EndActionListener());
	Main_panel.add(End_Button);

	// Start_Button = new JButton("ログイン");
	// Start_Button.setBounds(120,150, 100, 40);
	// Start_Button.addActionListener(new Botton_LoginActionListener());
	// Main_panel.add(Start_Button);

	Container contentPane = getContentPane();
	contentPane.add(Title_panel);
	contentPane.add(Main_panel);
	setVisible(true);
  }

  // Botton_End Eventの処理
  class Botton_EndActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
	System.exit(0);
      }
  }

  // Botton_Login Eventの処理
  // class Botton_LoginActionListener implements ActionListener {
  //     public void actionPerformed(ActionEvent e) {
  // 	System.exit(0);
  //     }
  // }
}
