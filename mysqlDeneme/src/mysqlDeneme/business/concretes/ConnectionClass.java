package mysqlDeneme.business.concretes;

import java.sql.DriverManager;

public class ConnectionClass {
	public void conn() {
		try {
			DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","1234");
			System.out.println("ba�lant� ba�ar�l�");
		}catch(Exception e) {
			System.out.println("ba�lant� ba�ar�s�z");
			e.printStackTrace();
		}
}
}
