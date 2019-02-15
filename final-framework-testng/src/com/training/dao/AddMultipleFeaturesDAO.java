package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.AddFeaturesBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class AddMultipleFeaturesDAO {
	
	Properties properties; 
	
	public AddMultipleFeaturesDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AddFeaturesBean> getFeatures(){
		String sql = properties.getProperty("get.features"); 
		
		GetConnection gc  = new GetConnection(); 
		List<AddFeaturesBean> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<AddFeaturesBean>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				AddFeaturesBean temp = new AddFeaturesBean(); 
				temp.setfeatureName(gc.rs1.getString(1));
				temp.setslugName(gc.rs1.getString(2));
				temp.setenterDescription(gc.rs1.getString(3));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new AddMultipleFeaturesDAO().getFeatures().forEach(System.out :: println);
	}
	
	
}
