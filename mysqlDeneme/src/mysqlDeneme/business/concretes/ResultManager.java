package mysqlDeneme.business.concretes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import mysqlDeneme.business.abstracts.IResultService;

public class ResultManager implements IResultService {

	@Override
	public void fun() {
		
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, p.puanlar,p.yorumlar FROM puanlar p left join customer_table c on c.id = p.id;");
			System.out.println("puaný 3 den düþük verenler: ");			
			while(myRs.next()) {//sýrayla tabloyu yazar
				if(myRs.getInt(3)<3) {
					System.out.println(myRs.getString(1) + "  "+ myRs.getString(2) 
				    +"  puaný:"+ myRs.getInt(3) +"  yorumu:"+ myRs.getString(4));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}	
}