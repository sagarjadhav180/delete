package reservenumber;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class GetNumber {
	
	
	public  static String getNumberToReserve(String access_token) throws ParseException, IOException, org.json.simple.parser.ParseException{
    
		System.out.println("compiler entered into request method");
		String number = null;
		
		//connection created
		CloseableHttpClient httpclients = HttpClients.createDefault();
		
		//posting URL
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		
		String stag = prop.getProperty("Environment").replaceAll("\\D", "");
		String url = "https://stag-"+stag+"-cfaapi-1.convirza.com/v2/number/search";
		
		HttpGet httpget=new HttpGet(url);

		
				
		//posting headers
		Map<String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("Authorization", "bearer "+access_token);
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httpget.addHeader(entry.getKey(),entry.getValue());
			
		}
		
		//hitting POST request and storing response 
		CloseableHttpResponse response= httpclients.execute(httpget);
		Assert.assertTrue(!(response.getStatusLine().getStatusCode() == 500 || response.getStatusLine().getStatusCode() == 401), "Invalid status code is displayed. "+ "Returned Status: "+response.getStatusLine().getStatusCode()+" "+response.getStatusLine().getReasonPhrase());
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line = "";
	    
		while ((line = rd.readLine()) != null) {
			   // Convert response to JSON object
			   JSONParser parser = new JSONParser();
			   JSONObject json = (JSONObject) parser.parse(line);
			   String success = json.get("result").toString();
			   Assert.assertTrue(success.equals("success"),"api did not retun success");
			   Assert.assertNull(json.get("err"),"api returned err "+json.get("err"));	
			   JSONArray json_arr = (JSONArray) json.get("data");
			   JSONObject json_obj = (JSONObject) json_arr.get(0);
			   number = json_obj.get("number").toString();
		}
        return number;
		
	}

}
