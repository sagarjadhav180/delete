package apiUtil;

import java.io.File;
import java.io.IOException;

import apiUtil.Constants;

import apiUtil.Directory;

import apiUtil.HelperClass;

public class FileConstants {

	public static String callUploadDateFormat() {
		String dateFormat = "yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'";
		return dateFormat;
	}
	
	public static class FileExtention {
		public static final String XLS = ".xls";
		public static final String JSON = ".json";
		public static final String YAML = ".yaml";
	}
	
	public static String getExcelTestDataFile() {
		String fileName = "";
		try {
			if (HelperClass.current_environment().contains("staging"))
				fileName = HelperClass.current_environment() + ".xls";
			else if (HelperClass.current_environment().equals("production"))
				fileName = "Production.xls";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Directory.getExcelTestDataDir() + fileName;
	}
	
	
	public static String getMP3File(String size) {
		String filePath;
		if(size.equals("5mb")) {
			filePath = System.getProperty("user.dir")+"/src/main/java/testdata/testfile.mp3";			
		}
		else if(size.equals("55mb")) {
			filePath = Constants.PROJECT_DIR + Constants.TEST_DATA_DIR + File.separator 
					+ Constants.TEST_FILE_55MB_MP3;			
		}
		else
			filePath = System.getProperty("user.dir")+"/src/main/java/testdata/testfile.mp3";

		return filePath;
	}
}
