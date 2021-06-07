package apiEndpoints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiUtil.Constants;
import apiUtil.FileConstants;
import apiUtil.HelperClass;
import apiUtil.DateUtils;
import apiUtil.RandomContentGenerator;
import dbUtil.TNUtil;
import tests.TestBase;


public class CallUpload {

	public static String access_token = "";
	String class_name="CallUpload";
	ArrayList<String> testdata;
	String caller_id,ring_to ,disposition,call_date,file,org_unit_id,group_ext_id,channel_id,campaign_id,tracking_number,line_type,assign_to;
	String custom_source_type_1 ,custom_source_type_2,custom_source_type_3,custom_source_type_4,custom_source_type_5,company_name;
	String city,zip_code,caller_name,address,state,swap_channels,is_outbound,tag_name;

	JSONObject payload=new JSONObject();
	String[] fields= {"tracking_number","caller_id","ring_to" ,"disposition","call_date","file","group_id","group_ext_id","channel_id","campaign_id","line_type","assign_to","custom_source_type_1","custom_source_type_2","custom_source_type_3","custom_source_type_4","custom_source_type_5","company_name","city","zip_code","caller_name","address","state","swap_channels","is_outbound","tag_name"};
	
	
	public void getAccessToken() throws ClientProtocolException, URISyntaxException, IOException, ParseException{
		 // Get the access token
		 ArrayList<String> get_credential = new ArrayList<String>();
		 get_credential.add("username");
		 get_credential.add("password");
		 ArrayList<String> config = HelperClass.read_config(get_credential);
		 access_token = HelperClass.get_oauth_token(config.get(0),config.get(1));
	}
	
	@SuppressWarnings("unchecked")
//	@BeforeClass
	public void setUpForCallUpload() throws IOException, ParseException, URISyntaxException {
		getAccessToken();
		testdata = HelperClass.readTestData("PostCallUpload", "uploadCallWithValidCallDate");
		caller_id = testdata.get(1);
		payload.put("caller_id", caller_id);
		ring_to = testdata.get(2);
		payload.put("ring_to", ring_to);
		disposition = testdata.get(3);
		payload.put("disposition", disposition);
		line_type=testdata.get(11);
		payload.put("line_type", line_type);
		swap_channels=testdata.get(24);
		payload.put("swap_channels", swap_channels);
		is_outbound=testdata.get(25);
		payload.put("is_outbound", is_outbound);
		company_name=testdata.get(18);
		payload.put("company_name", company_name);
		tag_name=testdata.get(26);
		payload.put("tag_name", tag_name);
		caller_name=testdata.get(21);
		payload.put("caller_name", caller_name);
		custom_source_type_1=testdata.get(13);
		payload.put("custom_source_type_1", custom_source_type_1);
		custom_source_type_2=testdata.get(14);
		payload.put("custom_source_type_2", custom_source_type_2);		
		custom_source_type_3=testdata.get(15);
		payload.put("custom_source_type_3", custom_source_type_3);
		custom_source_type_4=testdata.get(16);
		payload.put("custom_source_type_4", custom_source_type_4);
		custom_source_type_5=testdata.get(17);
		payload.put("custom_source_type_5", custom_source_type_5);
		call_date = DateUtils.getDate(FileConstants.callUploadDateFormat(), "-1");
		payload.put("call_date", call_date);
		file=FileConstants.getMP3File("1mb");
		payload.put("file", file);
		org_unit_id = TestBase.getOrg_unit_id();
		payload.put("group_id", org_unit_id);
//		group_ext_id=confGroupHierarchy.get(TestDataYamlConstants.GroupConstants.GROUP_EXT_ID).toString();
		group_ext_id=RandomContentGenerator.getRandomString();
		payload.put("group_ext_id", group_ext_id);
		city = testdata.get(19);
		payload.put("city", city);
		zip_code= testdata.get(20);
		payload.put("zip_code", zip_code);
		address= testdata.get(22);
		payload.put("address", address);
		state= testdata.get(23);
		payload.put("state", state);
//		tracking_number=confGroupHierarchy.get(TestDataYamlConstants.GroupConstants.PHONE_NUMBER).toString();
//		payload.put("tracking_number", tracking_number);
		channel_id= testdata.get(8);	
		payload.put("channel_id", channel_id);
		
		tracking_number= TNUtil.getTN(TestBase.getOrg_unit_id());
		payload.put("tracking_number", tracking_number);
		
		campaign_id= TNUtil.getCampaignId(tracking_number);
		payload.put("campaign_id", campaign_id);
		assign_to = testdata.get(12);
		payload.put("assign_to", assign_to);
	}
	
	public JSONObject createPayload(String field,String value) throws IOException, ParseException, URISyntaxException {
		setUpForCallUpload();
		JSONObject json = new JSONObject();
	
		for(String field1:fields) {
			
			if(field1.equals(field)){
				json.put(field1, value);
			}
			else {
				if(field1.equals("zip_code") || field1.equals("campaign_id")) {
					json.put(field1, Integer.parseInt(payload.get(field1).toString()));
				}
				else if (field1.equals("swap_channels") || field1.equals("is_outbound")){
					json.put(field1,Boolean.getBoolean(payload.get(field1).toString()));
				}
				else {
					json.put(field1, payload.get(field1));					
				}
			}
		}

		return json;
		
	}
	
	
	
	public void uploadCalls() throws ClientProtocolException, IOException, URISyntaxException, ParseException {
	
		JSONObject json = new JSONObject();
		json=createPayload("","");
		
		CloseableHttpResponse response = HelperClass.make_post_request_call_upload("/v2/call/upload", access_token, json);
		Assert.assertTrue(!(response.getStatusLine().getStatusCode() == 500 || response.getStatusLine().getStatusCode() == 401 ), "Invalid status code is displayed. "+ "Returned Status: "+response.getStatusLine().getStatusCode()+" "+response.getStatusLine().getReasonPhrase());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		String line = "";
	    
		while ((line = rd.readLine()) != null) {
			   // Convert response to JSON object
			   JSONParser parser = new JSONParser();
			   JSONObject jsonobj = (JSONObject) parser.parse(line); 
		
			   String result = jsonobj.get("result").toString();
			   String exp_result="success";
			   
			   Assert.assertEquals(result, exp_result,"Result did not return success message");
			   Assert.assertNull(jsonobj.get("err"));
			   
		}
		
	}
	
	
}
