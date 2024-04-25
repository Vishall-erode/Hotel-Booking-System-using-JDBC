package HOTELPACK;
//import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Scanner;

//import HOTEL.HOTEL;
public class DUBtil
{
	private static Connection con;
private static Statement st;
private static ResultSet rs;
private static PreparedStatement pst;
private static Scanner ip=new Scanner(System.in);


	public static void create() throws ClassNotFoundException, SQLException {
		con=HOTEL.getCon();
		st=con.createStatement();

			st.execute("create table Guestnew(phoneno varchar(15),name varchar(15),Age varchar(15));");
			st.execute("create table Roomsnew(Roomno numeric(15),Roomdetails varchar(15));");
			st.execute("create table Paymentsnew(Guestname varchar(15),phoneno varchar(15),paymentdone  varchar(15));");
			System.out.println("success");
	}
	
	public static void insert1() throws ClassNotFoundException, SQLException {
		con=HOTEL.getCon();
		pst=con.prepareStatement("insert into Guestnew values(?,?,?)");   //phoneno varchar(15),name varchar(15),Age varchar(15));
		System.out.println("enter the guest details:");
		for(int i=0;i<4;i++) {
			System.out.println("phoneno:");
			pst.setString(1,ip.next());
			System.out.println("Name:");
			pst.setString(2,ip.next());
			System.out.println("Age:");
			pst.setString(3,ip.next());
			pst.executeUpdate();
			System.out.println("success");
		
	}}
	public static void insert2() throws ClassNotFoundException, SQLException
	{  
		con=HOTEL.getCon();
		
		pst=con.prepareStatement("insert into Roomsnew values(?,?)"); //Roomno numeric(15),Roomdetails varchar(15)
		
		System.out.println("enter the Rooms details:");
		for(int i=0;i<4;i++) {
			System.out.println("Room number:");
			pst.setInt(1,ip.nextInt());
			System.out.println("room avaiable:");
			pst.setString(2,ip.next());
			
			pst.executeUpdate();
			System.out.println("success");
		} }
	
	public static void insert3() throws ClassNotFoundException, SQLException
	{
con=HOTEL.getCon();
		
		pst=con.prepareStatement("insert into Paymentsnew values(?,?,?)");
		
		System.out.println("enter the payments details:");    //Guestname varchar(15),phoneno varchar(15),paymentdone  varchar(15))
		for(int i=0;i<4;i++) {
			
			System.out.println("guest name:");
			pst.setString(1,ip.next());
			System.out.println("phonenumber:");
			pst.setString(2,ip.next());
			System.out.println("paymentdone:");
			pst.setString(3,ip.next());
			
			pst.executeUpdate();
			System.out.println("success");
		}
		
		//"update Roomsnew set roomdetails="+Roomdetails+" where Roomno="+Roomno+";"
		
	}
	public static void update1() throws ClassNotFoundException, SQLException
	{
		con=HOTEL.getCon();
		System.out.println("update Roomsnew set roomdetails='no' where Roomno=3;");
		pst=con.prepareStatement("update Roomsnew set roomdetails='no' where Roomno=3;");
		pst.execute();
		System.out.println("success");
	
	}
	public static void update2() throws ClassNotFoundException, SQLException
	{con=HOTEL.getCon();
	st=con.createStatement();
		System.out.println("Update Format:(phone,paymentdone)");
		String phone;
		int paymentdone;
		Scanner s = new Scanner(System.in);
		phone=s.next();
		paymentdone=s.nextInt();
		st.execute("update Paymentsnew set pd="+paymentdone+" where pno='"+phone+"';");System.out.println("success");
	}
	
	
	public static void delete() throws ClassNotFoundException, SQLException {
		con=HOTEL.getCon();
		pst=con.prepareStatement("delete from Guestnew where phoneno=?");
		System.out.println(" delete from product where p=?\" ");
		System.out.println("enter phone number");
		pst.setString(1, ip.next());
		pst.executeUpdate();
		System.out.println("success DELETED");
	}
	
	public static void display() throws ClassNotFoundException, SQLException {
		con=HOTEL.getCon();
		pst=con.prepareStatement("select * from Guestnew ");
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
	}
	
	public static void display1() throws ClassNotFoundException, SQLException {
		con=HOTEL.getCon();
		pst=con.prepareStatement("select * from Roomsnew "); // Roomsnew(Roomno numeric(15),Roomdetails varchar(15));")
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
	}
	public static void display2() throws ClassNotFoundException, SQLException {
		con=HOTEL.getCon();
		pst=con.prepareStatement("select * from paymentsnew "); //Paymentsnew(Guestname varchar(15),phoneno varchar(15),paymentdone  varchar(15));");
		rs=pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(2)+" "+rs.getInt(2)+" "+rs.getString(2));
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		int a;
		//1create();
		System.out.println("press=1(Guest table) ");
		System.out.println("press=2(Rooms table) ");
		System.out.println("press=3(payement table) ");
		System.out.println("press=4(room updatetable) ");
		System.out.println("press=5(payment table) ");
		System.out.println("press=6(delete the infromation) ");
		System.out.println("press=7(display the  guest infromation)");
		System.out.println("press=8(display the  room infromation)");
		System.out.println("press=9(display the  payment infromation)");
		
		//System.out.println("press=3(payment table) ");
		Scanner s = new Scanner(System.in);
		a=s.nextInt();
		switch(a)
		{
		case 1:
			insert1();
			break;
		case 2:
			insert2();
			break;
		case 3:
			insert3();
			break;
			
			
		case 4:
			update1();
			break;
		case 5:
			update2();
			break;
			
		case 6:
			delete();
			break;
			
		case 7:
			 display();
			break;	
			
		case 8:
			 display1();
			break;
			
		case 9:
			 display2();
			break;	
		}
		
	}
}