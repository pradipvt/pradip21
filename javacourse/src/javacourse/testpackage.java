package javacourse;



import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;





public class testpackage{



public static void main(String[] args){

	String url ="jdbc:mysql://localhost:3306/testdb";

	String user ="root";

	String password ="12345";



	String filepath ="C:\\storeimage\\gym.jpg";

	try{

		

	Connection conn = DriverManager.getConnection(url,user,password);

	String sql ="INSERT INTO storeimg(name,image)values(?,?)";

	PreparedStatement statement =conn.prepareStatement(sql);

	statement.setString(1,"Pradip");



	FileInputStream inputStream = new FileInputStream(new File(filepath));

	statement.setBlob(2,inputStream);



	int row =statement.executeUpdate();

	

	if(row > 0){

		

	System.out.println("A contact was inserted with photo image.");

	

	}

	conn.close();

	

	}catch(SQLException ex){ 

	ex.printStackTrace();

	}catch(IOException ex){

	ex.printStackTrace();

	}

}

}