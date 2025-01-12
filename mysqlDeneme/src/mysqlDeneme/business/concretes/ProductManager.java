package mysqlDeneme.business.concretes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import mysqlDeneme.business.abstracts.IProductService;

public class ProductManager implements IProductService{

	@Override
	public void show() {
		System.out.println("product tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM products");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getInt(1) + "  "+ myRs.getString(2));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void showProduct() {
		System.out.println("product tablosu:");
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, p.puanlar,p.yorumlar, p.products_id, pro.product_name FROM puanlar p left JOIN customer_table c ON c.id = p.customer_id left join products pro on pro.products_id = p.products_id;");
			while(myRs.next()) {//sýrayla tabloyu yazar
				System.out.println(myRs.getString(1) + "\t"+ myRs.getString(2)
				+ "  puan:"+ myRs.getInt(3)+ " yorum:"+ myRs.getString(4)+ "  aldýðý ürün ve id si:"+ myRs.getInt(5)
				+ "  "+ myRs.getString(6)+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void showSelectedProduct1() {		
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();			
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, p.puanlar,p.yorumlar, p.products_id, pro.product_name FROM puanlar p left JOIN customer_table c ON c.id = p.customer_id left join products pro on pro.products_id = p.products_id where pro.product_name = \"masa\";");
			
			while(myRs.next()) {//sýrayla tabloyu yazar
					System.out.println(myRs.getString(1) + "\t"+ myRs.getString(2)
					+ "  puan:"+ myRs.getInt(3)+ " yorum:"+ myRs.getString(4)+ "  aldýðý ürün ve id si:"+ myRs.getInt(5)
					+ "  "+ myRs.getString(6)+"\n");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void showSelectedProduct2() {
		try {
			Connection myConn = (Connection) DriverManager.getConnection(a,"root","1234");
			Statement myStat = (Statement) myConn.createStatement();			
			ResultSet myRs = myStat.executeQuery("SELECT c.name, c.surname, p.puanlar,p.yorumlar, p.products_id, pro.product_name FROM puanlar p left JOIN customer_table c ON c.id = p.customer_id left join products pro on pro.products_id = p.products_id where pro.product_name = \"sandalye\";");
			
			while(myRs.next()) {//sýrayla tabloyu yazar
					System.out.println(myRs.getString(1) + "\t"+ myRs.getString(2)
					+ "  puan:"+ myRs.getInt(3)+ " yorum:"+ myRs.getString(4)+ "  aldýðý ürün ve id si:"+ myRs.getInt(5)
					+ "  "+ myRs.getString(6)+"\n");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void showSelectedProduct3() {
		// TODO Auto-generated method stub
		
	}	
}