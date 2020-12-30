package reservenumber;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class ReserveNumber {
 
	
     
	public static String makeNumberReseve() throws Exception
	{
		
		String access_token = GetAuthToken.authToken();
		String number1 = GetNumber.getNumberToReserve(access_token);
		
		System.out.println("compiler entered into request method");
		
		
		//connection created
		CloseableHttpClient httpclients = HttpClients.createDefault();
		
		//posting URL
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property"); 
		
		prop.load(file);
		String stag = prop.getProperty("Environment").replaceAll("\\D", "");
		String url = "https://stag-"+stag+"-cfaapi-1.convirza.com/v2/number/reserve";
		
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
