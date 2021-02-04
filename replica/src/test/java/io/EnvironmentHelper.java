package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import dbUtil.DBConnectionParameters;
import tests.TestBase;

public class EnvironmentHelper {

	public void updateAppConfig() throws IOException {
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		prop.setProperty("username", System.getProperty("username"));
		prop.setProperty("password", System.getProperty("password"));
		prop.setProperty("Environment", System.getProperty("Environment"));
		prop.setProperty("url", System.getProperty("url"));
		prop.setProperty("api_url", System.getProperty("api_url"));

		FileOutputStream fis=new FileOutputStream(new File(".//property"));
		prop.store(fis, "Env");
		
		String user=prop.getProperty("username");
		TestBase.setUser_id(user);
		String pass=prop.getProperty("password");
		TestBase.setPassword(pass);
		String environment = prop.getProperty("Environment");
		TestBase.setEnv(environment);
	}
	
	public void updateDBConfig() throws IOException{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//PostgresConfig.properties");
		prop.load(file);
		prop.setProperty("username", DBConnectionParameters.read_and_write_user);
		prop.setProperty("password", DBConnectionParameters.read_and_write_password);
		prop.setProperty("driver", DBConnectionParameters.pg_driver);
		prop.setProperty("username", DBConnectionParameters.staging_db);
		prop.setProperty("connection_url", "jdbc:postgresql://"+TestBase.getEnv()+"-pg-1.convirza.com:5432");
		
		FileOutputStream fis=new FileOutputStream(new File(".//PostgresConfig.properties"));
		prop.store(fis, "DB");
	}
	
}
