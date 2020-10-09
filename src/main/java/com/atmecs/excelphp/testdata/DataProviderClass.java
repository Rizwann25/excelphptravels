package com.atmecs.excelphp.testdata;

import java.io.IOException;
import org.testng.annotations.DataProvider;

import com.atmecs.excelphp.constant.ConstantClass;

	public class DataProviderClass {

	  @DataProvider(name="Data")
	   public static Object[][] getData() throws IOException
	   {
			XlsReader xls=new XlsReader(ConstantClass.TESTDATA_PATH);
			Object[][] data=xls.readExcelData("DataSheet");
			return data;
			
	   }
}
