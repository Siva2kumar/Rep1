package DriverFactory;

import CommonFunLibrary.StockAccounting;
import Utilities.ExcelFileutils;

public class DataDrivenTest {

	public static void main(String[] args) throws Throwable {
	
		StockAccounting app=new StockAccounting();
		ExcelFileutils excel=new ExcelFileutils();
		app.appLaunch("http://webapp.qedge.com");
		app.appLogin("admin", "master");
		for (int i=1;i<=excel.rowCount("SupplierData");i++)
		{
			String sName=excel.getData("SupplierData", i, 0);
			String add=excel.getData("SupplierData", i, 1);
			String city=excel.getData("SupplierData", i, 2);
			String country=excel.getData("SupplierData", i, 3);
			String cperson=excel.getData("SupplierData", i, 4);
			String pno=excel.getData("SupplierData", i, 5);
			String email=excel.getData("SupplierData", i, 6);
			String monbno=excel.getData("SupplierData", i, 7);
			String Notes=excel.getData("SupplierData", i, 8);
			
			String results=app.supplierCreation(sName, add, city, country, cperson, pno, email, monbno, Notes);
			excel.setData("SupplierData", i, 9, results);
		}
      app.appLogout();
      app.appClose();
	
	}
	

}
