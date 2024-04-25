package HOTELPACK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class test {
	public static void main(String[] a) throws SQLException {
		String url ="jdbc:postgresql://localhost:5432/postgres";
		String username ="postgres";
		String password ="12345678";
		Connection con = DriverManager.getConnection(url,username,password);
		Statement st = con.createStatement();
		System.out.println("Update Format:(roomno,roomfull)");
		int roomno,roomfull;
		Scanner s = new Scanner(System.in);
		roomno=s.nextInt();
		roomfull=s.nextInt();
		st.execute("update Rooms set Rf="+roomfull+" where Rno="+roomno+";");System.out.println("success");
	
	}
}
