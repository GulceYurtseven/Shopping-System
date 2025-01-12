package mysqlDeneme.business.concretes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import mysqlDeneme.business.abstracts.IPuanService;

public class PuanManager implements IPuanService {

	@Override
	public void showPuan() {
		System.out.println("puan tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM puanlar");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getInt(1) + "  müþteri id:"+ myRs.getInt(2) 
				+ "  müþteri puaný:"+ myRs.getInt(3)
				+"  müþteri yorumu:"+ myRs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void showCustomerAddressPuan() {
		System.out.println("adres puan tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, p.puanlar,p.yorumlar, adr.adres FROM adres adr left JOIN customer_table c ON c.id = adr.customer_id left join puanlar p on adr.customer_id = p.id;");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getString(1) + "  "+ myRs.getString(2) 
				+"  puaný:"+ myRs.getInt(3) +"  yorumu:"+ myRs.getString(4)+"  adresi:"+ myRs.getString(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void showCustomerPuan() {
		System.out.println("müþterilerin verdikleri puanlarýn tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, p.puanlar,p.yorumlar FROM puanlar p left join customer_table c on c.id = p.id;");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getString(1) + "  "+ myRs.getString(2) 
				+"  puaný:"+ myRs.getInt(3)+"  yorumu:"+ myRs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
