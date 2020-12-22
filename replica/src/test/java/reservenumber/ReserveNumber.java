package reservenumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ReserveNumber {
 
	
     
	public static String makeNumberReseve() throws ClientProtocolException, IOException, EncryptedDocumentException, InvalidFormatException, JSONException
	{
		
		String access_token = GetAuthToken.authToken();
		List<String> numbers = GetNumber.getNumberToReserve(access_token);
		String number1 = null ; 
		for(int i=0;i<numbers.size();i++){
			if(!numbers.get(i).startsWith("3")){ 
			String number=numbers.get(i);
			 number1=number;
			 break;
			}
			}
		 
		
		System.out.println("compiler entered into request method");
		
		
		//connection created
		CloseableHttpClient httpclients = HttpClients.createDefault();
		
		//posting URL
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property"); 
		prop.load(file);
		
		String stag = prop.getProperty("Environment").replaceAll("D\\", "");
		String url = prop.getProperty("https://stag-"+stag+"-cfaapi-1.convirza.com/v2/number/reserve");
		
		HttpPost httppost=new HttpPost(url); 

		
		JSONObject jo=new JSONObject();
		try{
		jo.put("number", Integer.valueOf(number1));
		}catch(Exception n){
			n.printStackTrace();
		}
		jo.put("source", 10001);
		
		JSONArray ja=new JSONArray();
		ja.put(jo);
		
		httppost.setEntity(new StringEntity(ja.toString()));
		System.out.println("payload----------");
		System.out.println(ja.toString());

				
		//posting headers
		Map<String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json");
		headermap.put("Authorization", "bearer "+access_token);
		for(Entry<String, String> entry:headermap.entrySet())
		{
			
			httppost.addHeader(entry.getKey(),entry.getValue());
			
		} 
		CloseableHttpResponse httpresponse;
		
		//hitting POST request and storing response 
		httpresponse= httpclients.execute(httppost);
			
        int statuscode = httpresponse.getStatusLine().getStatusCode();
		
		
		HttpEntity httpentity = httpresponse.getEntity();
		String responsestring = EntityUtils.toString(httpentity);
		
		System.out.println(responsestring);
		System.out.println(statuscode);
		String utilresponse = GetAuthToken.getValueByJpath(new JSONObject(responsestring),"err");
		
		System.out.println("error is "+utilresponse);
//		
		return number1;

	}
	
}
