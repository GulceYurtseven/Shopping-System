package mysqlDeneme.business.abstracts;

public interface ICustomerService {
	String a = "jdbc:mysql://localhost/customer";
	void show();
	void add();
	void update();
	void del();
	void search();
}
