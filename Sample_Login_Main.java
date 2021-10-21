// Sample_Login_Main.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Sample_Login_Main {
  // 戻り値：継承時にカプセル化
  static String Global_Message;
  static String Global_UserID;
  static String Global_PassID;

  public static void main(String args[]){
    new Sample_Login_Sub ();
  }
}

// Panel表示クラス
class Sample_Login_Sub extends JFrame{
  // 戻り値：継承時にカプセル化
  public static String Global_Message;
  public static String Global_UserID;
  public static String Global_PassID;

  //名前を入れるテキストフィールド
  JTextField	text_id;
  JLabel	label_res;

  JPanel	Title_panel ;
  JLabel	Title_label ;

  JPanel	 Block_panel ;
  JLabel	 ID_label;
  JTextField	 ID_text ;
  JLabel	 ID_label_res;

  JLabel	 PW_label;
  JPasswordField PW_text ;
  JLabel	 PW_label_res;

  JLabel	 DB_label;

  JButton End_Button ;

  JButton Login_Button ;

  // コンストラクタ
  Sample_Login_Sub (){

    setTitle("Login");
    setBounds(100, 100, 640, 360);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    Title_panel = new JPanel();
	Title_panel.setBounds(50, 10, 500, 50);
	Title_panel.setBackground(Color.DARK_GRAY);
   	Title_panel.setVisible(true);
	Title_panel.setLayout(new BorderLayout());

   	Title_label = new JLabel("ログイン");
    	Title_label.setPreferredSize(new Dimension(200, 50));
    	Title_label.setBackground(Color.WHITE);
	Title_label.setForeground(Color.WHITE);
	Title_label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 24));
 	Title_label.setHorizontalAlignment(JLabel.CENTER);
	Title_label.setVerticalAlignment(JLabel.CENTER);

	Title_panel.add(Title_label);

    Block_panel = new JPanel();
	Block_panel.setBounds(50, 80, 500, 200);
	Block_panel.setBackground(Color.LIGHT_GRAY);
	Block_panel.setLayout(null);
   	Block_panel.setVisible(true);
	
  	ID_label = new JLabel("ユーザーID：");
	ID_label.setBounds(10, 30, 200, 30);
	ID_label.setBackground(Color.BLACK);
	ID_label.setForeground(Color.BLACK);
	ID_label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));

    	ID_text = new JTextField("");
    	ID_text.setBounds(120, 30, 200, 30);
    	ID_text.setBackground(Color.WHITE);
	ID_text.setHorizontalAlignment(JTextField.LEFT); 
	ID_text.addActionListener(new TextActionListener());
	ID_text.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));

  	ID_label_res = new JLabel("");
	ID_label_res.setBounds(400, 30, 100, 30);
	ID_label_res.setBackground(Color.BLACK);
	ID_label_res.setForeground(Color.BLACK);
	ID_label_res.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));
	
	PW_label = new JLabel("パスワード：");
    	PW_label.setBounds(10, 80, 200, 30);
    	PW_label.setBackground(Color.BLACK);
	PW_label.setForeground(Color.BLACK);
	PW_label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));

	PW_text = new JPasswordField(10);
    	PW_text.setBounds(120, 80, 200, 30);
    	PW_text.setBackground(Color.WHITE);
	PW_text.setHorizontalAlignment(JTextField.LEFT); 
	PW_text.addActionListener(new PwActionListener()); 
	
	PW_label_res = new JLabel("******");
	PW_label_res.setBounds(400, 220, 100, 30);
	PW_label_res.setForeground(Color.WHITE);
	PW_label_res.setBackground(Color.WHITE);
	PW_label_res.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));

	DB_label = new JLabel("IDとパスワードを入力してください");
	DB_label.setBounds(120, 120, 200, 30);
	DB_label.setForeground(Color.BLACK);
	DB_label.setBackground(Color.WHITE);
	DB_label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));

	End_Button = new JButton("終了");
	End_Button.setBounds(400,155, 80, 40);
	End_Button.setBackground(Color.WHITE);
	End_Button.addActionListener(new Botton_EndActionListener());

	Login_Button = new JButton("ログイン");
	Login_Button.setBounds(120,155, 200, 40);
	Login_Button.setBackground(Color.WHITE);
	Login_Button.addActionListener(new Botton_LoginActionListener());

   	Block_panel.add(ID_label);
	Block_panel.add(ID_text);
	Block_panel.add(ID_label_res);
	Block_panel.add(PW_label);
	Block_panel.add(PW_text);
	Block_panel.add(PW_label_res);
	Block_panel.add(DB_label);
	Block_panel.add(End_Button);
	Block_panel.add(Login_Button);

   Container contentPane = getContentPane();
   contentPane.add(Title_panel);
   contentPane.add(Block_panel);
   setVisible(true);
  }

  public void set_ID_Label ()  {
  	ID_label = new JLabel("ユーザーＩＤ：");
	ID_label.setBounds(10, 30, 200, 30);
	ID_label.setBackground(Color.WHITE);
	ID_label.setForeground(Color.WHITE);
	ID_label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 16));
  }

  // TextFelde Eventの処理
  class TextActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
	Global_UserID = ID_text.getText();
	ID_label_res.setText( Global_UserID );
	System.out.println( Global_UserID );
	System.out.println( "" );
      }
  }

  // PassswordFelde Eventの処理
  class PwActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
	char[] password = PW_text.getPassword();
	String passwordstr = new String(password);
	Global_PassID = passwordstr;
	System.out.println( Global_PassID );
	System.out.println( "" );
      }
  }

  // Botton_End Eventの処理
  class Botton_EndActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
	Global_Message="end";
	System.out.println( Global_Message );
	System.exit(0);
      }
  }

  // Botton_Login Eventの処理
  class Botton_LoginActionListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
	Global_Message="login";

	char[] password = PW_text.getPassword();
	String passwordstr = new String(password);
	Global_PassID = passwordstr;

	Global_UserID = ID_text.getText();

	// Global_Message = "login"   ;
	// Global_UserID  = "db_user" ;
	// Global_PassID  = "db_user" ;

	System.out.println( Global_Message );
	System.out.println( Global_PassID );
	System.out.println( Global_UserID  );
        
	Sample_CheckUser CU = new Sample_CheckUser (Global_UserID,Global_PassID);
	String res = CU.Sample_CheckUser_db() ;
	if ( res.equals("Found")) {
		DB_label.setText( "ログイン可能です" );
		new Sample_ListBox_Sub () ;
	} else {
		DB_label.setText( "IDかパスワードが間違っています" );
	}
	System.out.println( "RES " + res );
	
      }
  }

}
