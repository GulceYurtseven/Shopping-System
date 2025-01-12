package mysqlDeneme.business.concretes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import mysqlDeneme.business.abstracts.IAddressService;

public class AddressManager implements IAddressService {

	@Override
	public void showAddress() {
		System.out.println("adres tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM adres");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getInt(1) + "  müþteri id:"+ myRs.getInt(2) 
				+"  adresi:"+ myRs.getString(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void showCustomersAddress() {
		System.out.println("müþterilerin adresleri:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, c.city, adr.adres FROM adres adr INNER JOIN customer_table c ON c.id = adr.customer_id;");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getString(1) + "  "+ myRs.getString(2) 
				+ "  adresi:"+ myRs.getString(3) + "  "+ myRs.getString(4));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
