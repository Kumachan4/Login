// Sample_dbSelect_Main.java
//
// JDBC を下記に保存
// 
// C:\Program Files\Java\jdk-14.0.1\lib\mysql-connector-java-8.0.20.jar
// 環境変数に　下記を入力　最後の　. を忘れずに・・
// JDBC: CLASSPATH=C:\Program Files\Java\jdk-14.0.1\lib\mysql-connector-java-8.0.20.jar; .
// 
// データベースログイン 
// C:\XAMPP\MySQL\BIN\mysql -u root -p -h localhost
// 
// データベース作成
// CREATE DATABASE eng001 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
//
// テーブル作成　SQL
// TABLE : user_master
// CREATE TABLE user_master (
//  id CHAR(255) not null primary key, 
//  name TEXT,
//  pass TEXT,
//  mail TEXT,
//  rights INT
// );
// 
// データ追加　SQL
// INSERT INTO  user_master (id, name, pass, mail,rights ) VALUES ('user1','db_user_name1','pass001','mail01@gmail.com',0 );
// INSERT INTO  user_master (id, name, pass, mail,rights ) VALUES ('user2','db_user_name2','pass002','mail02@gmail.com',1 );
// INSERT INTO  user_master (id, name, pass, mail,rights ) VALUES ('user3','db_user_name3','pass003','mail01@gmail.com',1 );
// INSERT INTO  user_master (id, name, pass, mail,rights ) VALUES ('user4','db_user_name4','pass004','mail04@gmail.com',1 );
// INSERT INTO  user_master (id, name, pass, mail,rights ) VALUES ('user5','db_user_name5','pass005','mail05@gmail.com',1 );
// INSERT INTO user_master (id, name, pass, mail, rights) VALUES  ('db_user','db_user_name','db_user','db_user@gmail.com',1);
// 
// ユーザー追加　SQL
// CREATE USER 'db_user'@'%' IDENTIFIED BY 'db_user';
// 
// アクセス権追加　SQL
// GRANT ALL ON eng001.* TO db_user;
//
// MySQL ライブラリ読み込み
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Sample_dbSelect_Main {
   public static void main(String[] args ) {
	Sample_dbSelect_Method( );
    }

   public static void Sample_dbSelect_Method () {
	ArrayList<ArrayList<String>> dbTable = new ArrayList<>();
	Sample_dbSelect dbSelect = new Sample_dbSelect ( dbTable ); 

	// 取得したデータの表示
	for ( ArrayList<String> Row : dbTable ) {
	  for ( String Col : Row ) {
		System.out.print( Col );
 	  }
          System.out.println( "" );
	}
   }

}

class Sample_dbSelect {

   String DatabaseName	= "mysql://Localhost/eng002" ;
   String TableName	= "user_master" ;
   String DatabaseID	= "root" ;
   String DatabasePW	= "" ;
   String UserID	= "db_user" ;
   String UserPW	= "db_user" ;
   String SqlStr	= "" ;
   ResultSet rset	;

   // コンストラクタで実行
   public Sample_dbSelect ( ArrayList<ArrayList<String>> Table ) {

   SqlStr = "SELECT * FROM " + TableName + " ;" ;

   try {
	// MySQLのドライバ名 (定義不要？）
	// Class.forName("com.mysql.cj.jdbc.Driver");

	// 接続文字列の定義
	String ConectStr = "jdbc:" + DatabaseName +"?&" + 
			"user=" + DatabaseID + "&" +
			"password=" + DatabasePW + "&" + 
			"characterEncoding=utf8&" + 
			"useSSL=false&" + 
			"serverTimezone=GMT%2B9:00&" + 
			"rewriteBatchedStatements=true" ;

	// 接続文字列をドライバに送る
	// System.out.println (ConectStr) ;
	Connection conn = DriverManager.getConnection( ConectStr ) ;

	// ステートメントをドライバが作成
       	Statement stmt = conn.createStatement();

	// SQLの実行と結果の取得
       	rset = stmt.executeQuery( SqlStr );

	// 取得したデータの表示
	// ArrayList<ArrayList<String>> Table = new ArrayList<>();
	while ( rset.next() ) { 
		ArrayList<String> Item = new ArrayList<>();
		// System.out.print ( rset.getString("id") );
		// System.out.print ( rset.getString("name") );
		// System.out.print ( rset.getString("pass") );
		// System.out.print ( rset.getString("mail") );
		// System.out.print ( rset.getString("rights") );

		Item.add( rset.getString("id")    );
		Item.add( rset.getString("name")  );
		Item.add( rset.getString("pass")  );
		Item.add( rset.getString("mail")  );
		Item.add( rset.getString("tel")   );
		Item.add( rset.getString("rights"));
		// System.out.println( Item ) ;
	    	Table.add( Item ) ;
	}

	// Table.forEach(Ttem -> Ttem.forEach(It -> System.out.print(It) ) );

	// 結果セットをクリア
       	rset.close();
       	// ステートメントをクリア
       	stmt.close();
       	// 接続をクローズ
       	conn.close();

	// 取得したデータの表示
	// for ( ArrayList<String> Row : Table ) {
	//  for ( String Col : Row ) {
	// 	System.out.print( Col );
 	//   }
        //   System.out.println( "" );
	// }
     } catch (Exception e) {
	e.printStackTrace();
     }
  }
}