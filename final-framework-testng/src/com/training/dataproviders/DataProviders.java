package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.AddFeaturesBean;
import com.training.dao.AddMultipleFeaturesDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class DataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<AddFeaturesBean> list = new AddMultipleFeaturesDAO().getFeatures(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(AddFeaturesBean temp : list){
			Object[]  obj = new Object[3]; 
			obj[0] = temp.getfeatureName(); 
			obj[1] = temp.getslugName(); 
			obj[2] = temp.getenterDescription();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:/Users/Sonali/PropertyTestData.xlsx";
		String SheetName="RETC_082";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:/Users/Sonali/PropertyTestData.xlsx"; 
		String SheetName="RETC_083";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	@DataProvider(name = "excel-inputs3")
	public Object[][] getExcelData3(){
		String fileName ="C:/Users/Sonali/PropertyTestData.xlsx"; 
		String SheetName="RETC_084";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
