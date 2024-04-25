package HOTELPACK;

import java.sql.*;

public class HOTEL {
	public static Connection getCon() throws ClassNotFoundException, SQLException {
	String url ="jdbc:postgresql://localhost:5432/postgres";
	String username ="postgres";
	String password ="12345678";
	Connection con = DriverManager.getConnection(url,username,password);
	Statement st = con.createStatement();
	return con;
}	

}
