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
import org.apache.http.HttpResponse;
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
import org.testng.Assert; 
import org.testng.annotations.Test;



public class GetAuthToken{


	public static String authToken() throws ClientProtocolException, IOException, EncryptedDocumentException, InvalidFormatException, JSONException
	{
		
		System.out.println("compiler entered into request method");
		
		
		//connection created
		CloseableHttpClient httpclients = HttpClients.createDefault();
		
		//posting URL
		
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		String stag = prop.getProperty("Environment").replaceAll("\\D", "");
		String url = "https://stag-"+stag+"-cfaapi-1.convirza.com/oauth/token";
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");		
		HttpPost httppost=new HttpPost(url);

		
		JSONObject ja=new JSONObject();
		ja.put("client_id", "system");
		ja.put("client_secret", "f558ba166258089b2ef322c340554c");
		ja.put("grant_type", "password");
		ja.put("password", password);
		ja.put("username", username);
		
		
		httppost.setEntity(new StringEntity(ja.toString()));
		System.out.println("payload----------");
		System.out.println(ja.toString());

				
		//posting headers
		Map<String,String> headermap=new HashMap<String,String>();
		headermap.put("Content-Type", "application/json");
		
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
		
	
		ja.put(responsestring, new JSONObject(responsestring));
		
		System.out.println("=========================Auth token began===============================");
		
		
         System.out.println("Response code is "+statuscode);
		
		
		
		
		
		System.out.println(ja );
		
		String utilresponse = getValueByJpath(new JSONObject(responsestring),"access_token");
		
		System.out.println(utilresponse);
		return utilresponse;
		
	}

	
	public static String getValueByJpath(JSONObject responsejson,String jpath) throws JSONException
	{
		
		Object obj=responsejson;
		
		for(String s:jpath.split("/"))
		{
			if(!s.isEmpty())
			{
				if(!(s.contains("[") || s.contains("]")))
				{
					obj=((JSONObject)obj).get(s);
				}
				else if(s.contains("[") || s.contains("]"))
				{
					 obj = ((JSONArray)((JSONObject)obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
				}
			}
		}
		return obj.toString();
		
	}
	
	
}
