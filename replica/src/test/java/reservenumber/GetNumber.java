package reservenumber;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class GetNumber {
	
	
	public  static List<String> getNumberToReserve(String access_token) throws ParseException, IOException{
    
		System.out.println("compiler entered into request method");
		
		
		//connection created
		CloseableHttpClient httpclients = HttpClients.createDefault();
		
		//posting URL
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		String url = prop.getProperty("getnumberendpoint");
		
		HttpGet httpget=new HttpGet(url);

		
				
		//posting headers
		Map<String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("Authorization", "bearer "+access_token);
		
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httpget.addHeader(entry.getKey(),entry.getValue());
			
		}
		CloseableHttpResponse httpresponse;
		
		//hitting POST request and storing response 
		httpresponse= httpclients.execute(httpget);
			
        int statuscode = httpresponse.getStatusLine().getStatusCode();
		
		
		HttpEntity httpentity = httpresponse.getEntity();
		String responsestring = EntityUtils.toString(httpentity);
		
		System.out.println(responsestring);
	
		JSONObject ja = new JSONObject();
//		ja.put(responsestring, new JSONObject(responsestring));
		
		System.out.println("=========================Auth token began===============================");
		
		
         System.out.println("Response code is "+statuscode);
		
		
		
		
		
//		System.out.println(ja );
//		
		String utilresponse = GetAuthToken.getValueByJpath(new JSONObject(responsestring),"data");
		
		System.out.println(utilresponse);
		
	
		JSONArray json=new JSONArray(utilresponse);
//		json.put(stringresponse);
		System.out.println("sagar "+(json));
        
		JSONObject jo = null;
		String number = null ;
        List<String> numbers=new ArrayList<String>();
		
		for(int i=0;i<json.length();i++){

               jo=json.optJSONObject(i);
               number=GetAuthToken.getValueByJpath(jo,"number");
               numbers.add((number));
               
		    
			
		}
		


		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
        for(String num:numbers){
        	System.out.println("number is "+num);
        }
        return numbers;
		
	}

}
