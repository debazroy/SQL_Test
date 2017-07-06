package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL_Connection {
	public static void main (String[] args) throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JustTest?autoReconnect=true&useSSL=false","root","root");
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from employee");
	while (rs.next()) {
		System.out.println(rs.getString(1)
				+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)
				+", "+rs.getString(5)+", "+rs.getString(6)+", "+rs.getString(7));
		}
	conn.close();
	}
}
