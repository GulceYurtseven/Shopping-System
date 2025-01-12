package mysqlDeneme.business.concretes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import mysqlDeneme.business.abstracts.ICustomerService;

public class CustomerManager implements ICustomerService{	
	
	@Override
	public void show() {
		System.out.println("customer tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM customer_table");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getInt(1) + "  "+ myRs.getString(2) 
				+"  "+ myRs.getString(3)+"  "+ myRs.getString(4) +"  "+ myRs.getDate(5)
				+"  "+ myRs.getInt(6)+"  "+ myRs.getString(7) +"  "+ myRs.getString(8));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void add() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("yeni müþteri no: ");
		int newId = input.nextInt();
		
		System.out.print("yeni müþteri ismi: ");
		String newName = input.next();
		
		System.out.print("yeni müþteri soyismi: ");
		String newSurname = input.next();
		
		System.out.print("yeni müþteri þehiri: ");
		String newCity = input.next();
		
		System.out.print("yeni müþteri doðum günü: ");
		String newBirth = input.next();
		
		System.out.print("yeni müþteri yaþý: ");
		int newAge = input.nextInt();
		
		System.out.print("yeni müþteri cinsiyeti: ");
		String newGender = input.next();
		
		System.out.print("yeni müþteri uyruðu: ");
		String newNation = input.next();
		
		try {
			Connection myConn =  DriverManager.getConnection(a,"root","1234");
			Statement myStat =  myConn.createStatement();		
			String s=String.format("INSERT INTO `customer`.`customer_table` (`id`, `name`, `surname`, `city`, `birth`, `age`, `gender`, `nation`) VALUES ( %d, '%s','%s','%s','%s',%d,'%s','%s')", newId , newName, newSurname, newCity, newBirth, newAge, newGender, newNation);
			myStat.executeUpdate(s);
			System.out.println("kiþi eklendi");
		}catch(Exception e) {
			e.printStackTrace();
		}
		show();
}

	@Override
	public void update() {
		show();
		Scanner input = new Scanner(System.in);
		System.out.print("güncellemek istediðiniz müþterinin id'sini girin: ");
		int update=input.nextInt();
		
		System.out.print("yeni müþteri ismi: ");
		String newName = input.next();
		
		System.out.print("yeni müþteri soyismi: ");
		String newSurname = input.next();
		
		System.out.print("yeni müþteri þehiri: ");
		String newCity = input.next();
		
		System.out.print("yeni müþteri yaþý: ");
		int newAge = input.nextInt();
		
		try {
		Connection myConn =  DriverManager.getConnection(a,"root","1234");
		Statement myStat =  myConn.createStatement();		
		String s=String.format("UPDATE `customer`.`customer_table` SET `name` = '%s', `surname` = '%s', `city` = '%s', `age` = %d WHERE (`id` = %d);",newName,newSurname,newCity,newAge,update);
        myStat.executeUpdate(s);  
        System.out.println("müþteri güncellendi");
	
		}catch(Exception e) {
			e.printStackTrace();
		}	
		show();
	}

	@Override
	public void del() {
		show();
		Scanner input = new Scanner(System.in);
		System.out.print("silmek istediðiniz müþterinin id'sini girin: ");
		int del=input.nextInt();
		
		try{
			Connection myConn =  DriverManager.getConnection(a,"root","1234");
			Statement myStat =  myConn.createStatement();	
			String s=String.format("DELETE from `customer`.`customer_table` WHERE id = %d ",del);
	        myStat.executeUpdate(s);  
	        System.out.println("müþteri silindi");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
		show();
	}

	@Override
	public void search() {
		Scanner input = new Scanner(System.in);
		System.out.print("aramak istediðiniz müþterinin ismini girin: ");
		String search=input.next();
		
		try{
			Connection myConn =  DriverManager.getConnection(a,"root","1234");
			Statement myStat =  myConn.createStatement();	
			String s=String.format("SELECT * FROM `customer`.`customer_table` WHERE name LIKE '%s'",search);
			ResultSet myRs =  myStat.executeQuery(s);			
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println("müþteri bulundu");
				System.out.println(myRs.getInt(1) + "  "+ myRs.getString(2) 
				+"  "+ myRs.getString(3)+"  "+ myRs.getString(4) +"  "+ myRs.getDate(5)
				+"  "+ myRs.getInt(6)+"  "+ myRs.getString(7) +"  "+ myRs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}			
	}
}