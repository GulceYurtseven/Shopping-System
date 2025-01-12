package mysqlDeneme;

import mysqlDeneme.business.abstracts.IAddressService;
import mysqlDeneme.business.abstracts.ICustomerService;
import mysqlDeneme.business.abstracts.IProductService;
import mysqlDeneme.business.abstracts.IPuanService;
import mysqlDeneme.business.abstracts.IResultService;
import mysqlDeneme.business.concretes.AddressManager;
import mysqlDeneme.business.concretes.ConnectionClass;
import mysqlDeneme.business.concretes.CustomerManager;
import mysqlDeneme.business.concretes.ProductManager;
import mysqlDeneme.business.concretes.PuanManager;
import mysqlDeneme.business.concretes.ResultManager;

public class Main {

	public static void main(String[] args) {
		
		ConnectionClass connection = new ConnectionClass();
		connection.conn();
		
		ICustomerService customerService = new CustomerManager();
		//customerService.show();
		//customerService.add();
		//customerService.update();
		//customerService.del();
		//customerService.search();
		
		IAddressService addressService = new AddressManager();
		addressService.showAddress();
		//addressService.showCustomersAddress();
		
		IPuanService iPuanService = new PuanManager();
		//iPuanService.showPuan();
		//iPuanService.showCustomerAddressPuan();
		//iPuanService.showCustomerPuan();
		
		IResultService iResultService = new ResultManager();
		//iResultService.fun();
		
		IProductService iProductService = new ProductManager();
		//iProductService.show();
		iProductService.showProduct();
		//iProductService.showSelectedProduct1();
		//iProductService.showSelectedProduct2();
		
	}

}
