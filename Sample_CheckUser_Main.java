// Sample_CheckUser_Main.java
// JDBC: CLASSPATH=C:\Program Files\Java\jdk-14.0.1\lib\mysql-connector-java-8.0.20.jar; .
import java.sql.*;

class Sample_CheckUser_Main {
   public static void main(String[] args) {
	String Id = "db_user" ;        
	String Pw = "db_user" ;
	String res ;
        
	Sample_CheckUser CU = new Sample_CheckUser (Id,Pw);
	res = CU.Sample_CheckUser_db() ;
	System.out.println( res );
    }
}

// TABLE : user_master
// CREATE TABLE user_master (
//  user_id CHAR(255) not null primary key, 
//  user_name TEXT,
//  user_pass TEXT,
//  user_mail TEXT,
//  user_rights INT
// );

class Sample_CheckUser {
   private static String user_id     ; //= rset.getString(1);
   private static String user_name   ; //= rset.getString(2);
   private static String user_pass   ; //= rset.getString(3);
   private static String user_mail   ; //= rset.getString(4);
   private static String user_tel   ; //= rset.getString(5);
   private static int    user_rights ; //= rset.getInt(6);
   
   private static String input_id     ; //= rset.getString(1);
   private static String input_pw     ; //= rset.getString(1);

   Sample_CheckUser (String U_ID, String U_PW) {
		input_id = U_ID ;
		input_pw = U_PW ;
   }

   public static String Sample_CheckUser_db() {
	String Flag = "Not";
     try {
        // MySQL�f�[�^�x�[�X�ɐڑ� (DB��,ID,�p�X���[�h���w��)
        // mysql-connector-java-8.0.20.jar (mysql-connector-java-8.0.20.jar)
	// CLASSPATH : "C:\Program Files\Java\jdk-14.0.1\lib\mysql-connector-java-8.0.19.jar; ."
	// MySQL�̃h���C�o��
        // Class.forName("com.mysql.cj.jdbc.Driver");

	// �ڑ���������h���C�o�ɑ���
	String ConectStr = "jdbc:mysql://localhost/eng002?&" + 
			   "user=root&" +
			   "password=&" + 
			   "characterEncoding=utf8&" + 
			   "useSSL=false&" + 
			   "serverTimezone=GMT%2B9:00&" + 
			   "rewriteBatchedStatements=true" ;
	// System.out.println (ConectStr) ;
	Connection conn = DriverManager.getConnection( ConectStr ) ;

	// �X�e�[�g�����g���h���C�o���쐬
       	Statement stmt = conn.createStatement();

	// user_master �̎擾
       	ResultSet rset = stmt.executeQuery("SELECT * FROM user_master ;");

	//Array�Ŏ���Ă���̂ł����Őݒ肵�Ă���
	while ( rset.next() ) {
		user_id     = rset.getString(1);
		user_name   = rset.getString(2);
		user_pass   = rset.getString(3);
		user_mail   = rset.getString(4);
		user_tel   = rset.getString(5);
		user_rights = rset.getInt(6);
		if ( user_id.equals(input_id)) {
		  if ( user_pass.equals(input_pw)) {
			// System.out print("IF:" + user_id  );
			// System.out.print("IF:" + user_pass );
			Flag="Found" ;
		  }
		}
        }

	// ���ʃZ�b�g���N���[�Y
       	rset.close();
       	// �X�e�[�g�����g���N���[�Y
       	stmt.close();
       	// �ڑ����N���[�Y
       	conn.close();
	return Flag ;
     }
        catch (Exception e) {
            e.printStackTrace();
     }     
	return Flag ;
  }
}