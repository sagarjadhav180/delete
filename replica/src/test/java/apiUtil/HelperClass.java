package apiUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.JsonNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import apiUtil.FileConstants;



public class HelperClass {
	
	public static JsonNode rootNode;
	public static URI uri;
	public static String params;
	
	// Get the access_token through oauth/token api method
	public static String get_oauth_token(String username, String password) throws URISyntaxException, ClientProtocolException, IOException, ParseException{
		String api_url = HelperClass.get_api_url();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost(api_url)
				.setPath("/oauth/token")
				.build();
		HttpPost httppost = new HttpPost(uri);
		JSONObject json = new JSONObject();
		json.put("grant_type", "password");
		json.put("client_id", "system");
		json.put("client_secret", "f558ba166258089b2ef322c340554c");
		json.put("username", username);
		json.put("password", password);	

		StringEntity input = new StringEntity(json.toString());
		input.setContentType("application/json");
		httppost.setEntity(input);
		httppost.addHeader("Content-Type" , "application/json");
		HttpResponse response = httpclient.execute(httppost);

		// Return null if API returns error while fetching access token
		if (response.getStatusLine().getStatusCode() != 200 && response.getStatusLine().getStatusCode() != 201)
			return null;

		String result = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONParser parser = new JSONParser();
		Object resultObject = parser.parse(result);
		JSONObject obj =(JSONObject)resultObject;

		System.out.println(obj.get("access_token"));
		String access_token = obj.get("access_token").toString();
		return access_token;
	}
	
	public static CloseableHttpResponse make_post_request_call_upload(String path, String access_token, JSONObject nvps) throws ClientProtocolException, IOException, URISyntaxException{
		
		String[] fields= {"tracking_number","caller_id","ring_to" ,"disposition","call_date","file","group_id","group_ext_id","channel_id","campaign_id","line_type","assign_to","custom_source_type_1","custom_source_type_2","custom_source_type_3","custom_source_type_4","custom_source_type_5","company_name","city","zip_code","caller_name","address","state","swap_channels","is_outbound","tag_name"};
		String api_url = HelperClass.get_api_url();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		uri = new URIBuilder()
				.setScheme("https")
				.setHost(api_url)
				.setPath(path)
				.build();
		HttpPost httppost = new HttpPost(uri);       
//		httppost.addHeader("Content-Type", "application/json");
		if(!access_token.equals(""))
			httppost.addHeader("Authorization", "bearer "+access_token);
		
		try {

			MultipartEntityBuilder builder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			
			for(String fieldName:fields) {
					
					if(fieldName.equals("file")) {
						File file = new File(nvps.get("file").toString());
						builder.addBinaryBody(fieldName, new FileInputStream(file),
							    ContentType.MULTIPART_FORM_DATA,
							    file.getName());	
					}
					
					else {
						try {
							builder.addTextBody(fieldName, nvps.get(fieldName).toString(),ContentType.TEXT_PLAIN);							
						}catch(NullPointerException e) {
							builder.addTextBody(fieldName, "",ContentType.TEXT_PLAIN);
						}

					}			
				
				}
					

			HttpEntity multipart = builder.build();
			httppost.setEntity(multipart);
	
		
		}
		catch(ClassCastException e){
		
		}
		
		params = nvps.toJSONString();
		uri = httppost.getURI();

		CloseableHttpResponse response = httpclient.execute(httppost);
		return response;
	}

	
	
	public static String get_api_url() throws IOException{
		ArrayList<String> get_credential = new ArrayList<String>();
		get_credential.add("api_url");
		ArrayList<String> config = HelperClass.read_config(get_credential);
		return config.get(0);
	}
	
	public static ArrayList<String> read_config(ArrayList<String> fields) throws IOException{
		FileReader reader=new FileReader(System.getProperty("user.dir")+"/property");
		Properties prop =new Properties();  
		prop.load(reader);  
		ArrayList<String> fields_value = new ArrayList<String>();
		for(String field: fields){
			fields_value.add(prop.getProperty(field));
		}
		return fields_value;
	}
	
	public static ArrayList<String> readTestData(String class_name, String method_name) throws IOException{
		String fileName = "";
		if (HelperClass.current_environment().contains("stag"))

			fileName = "staging" + FileConstants.FileExtention.XLS;

		else if (HelperClass.current_environment().equals("production"))
			fileName = "Production.xls";
		String filePath = System.getProperty("user.dir")+"/src/main/java/testdata", sheetName = class_name;

		//Create a object of File class to open xlsx file
		File file = new File(filePath+"/"+fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		//Find the file extension by spliting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")){
			//If it is xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){
			//If it is xls file then create object of XSSFWorkbook class
			workbook = new HSSFWorkbook(inputStream);
		}
		//Read sheet inside the workbook by its name
		Sheet sheet = workbook.getSheet(sheetName);
		//Find number of rows workbook excel file
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

		ArrayList<String> cell_values = new ArrayList<String>();
		//Create a loop over all the rows of excel file to read it
		for (int i = 1; i < rowCount+1; i++) {
			Row row = sheet.getRow(i);	  
			if (row!=null) {
				if (row.getCell(0).getStringCellValue().equals(method_name)) {
					for (int j = 0; j < row.getLastCellNum(); j++) {
						//Print excel data in console
						DataFormatter formatter = new DataFormatter();
						cell_values.add(formatter.formatCellValue(row.getCell(j)));
					}
				} else
					continue;
			}    
			//Create a loop to print cell values in a row
		}
		return cell_values;
	}
	
	public static String current_environment() throws IOException{
		FileReader reader=new FileReader(System.getProperty("user.dir")+"/property");
		Properties p=new Properties();  
		p.load(reader);  
		String env = p.getProperty("Environment");
		return env;
	}
}
