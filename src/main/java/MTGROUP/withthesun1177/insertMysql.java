package MTGROUP.withthesun1177;
import java.sql.*;
public class insertMysql{    
	public void insertData(String eventTime) {
		try {
            // MySQLデータベースに接続 (DB名,ID,パスワードを指定)
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "a12345678");
            System.out.println("MySQLに接続できました。");
            System.out.println("received data is ="+ eventTime );
            // ステートメントを作成
            Statement stmt = con.createStatement();

            // INSERT
            stmt.executeUpdate("INSERT INTO economic (time) VALUES ('"+eventTime+"')");
            System.out.println("Table economic　の timeカラムにinsert出来ました。");
            // ステートメントをクローズ
            stmt.close();
            // 接続をクローズfda
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}