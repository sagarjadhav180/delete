package testdata;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CampaignAndTrackingNumberPage;
import pom.CampaignBuilderPage;
import pom.GeoRouteLocationsPage;
import pom.GroupsAndUserPage;
import pom.HomePage;
import pom.LoginPage;
import pom.TrackingNumberBuilderPage;
import pom.WebHookPage;
import tests.TestBase;
import tests.TrackingNumberTest;
import tests.WebHookTest;

public class TestDataCreation extends TestBase implements TestDataFunctions {

	public void login() throws Exception {
	
		LoginPage lp=new LoginPage(driver);
		logger.log(LogStatus.INFO, "login method called");
		lp.validLogin();
		HomePage hp=new HomePage(driver);
		hp.left_hand_navigation_bar_click();
		
	}

	public void createGroup() throws InterruptedException {
		
		HomePage hp=new HomePage(driver);
		hp.clickAction(Constants.HomePage.group_User_page);
		
		GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		gp.expandSection(Constants.GroupsAndUser.sub_groups);
		gp.createGroup(account);
		
		hp.clickAction(Constants.HomePage.home_page);
	}

	public void createUser() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.clickAction(Constants.HomePage.group_User_page);
		
		GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		gp.expandSection(Constants.GroupsAndUser.user_settings);
		gp.createUser(first_name, last_name, user_id, Constants.GroupsAndUser.admin_role);;
	
		hp.clickAction(Constants.HomePage.home_page);
	}

    public void trackingNumberSettings() throws InterruptedException {
    	HomePage hp=new HomePage(driver);
		hp.clickAction(Constants.HomePage.group_User_page);
		
		GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		gp.expandSection(Constants.GroupsAndUser.tn_settings);
		
		hp.clickAction(Constants.HomePage.home_page);		
	}
	
	public void createCampaign() throws InterruptedException {
		
		HomePage hp=new HomePage(driver);
        
		try {
			hp.clickAction(Constants.HomePage.campaign_tracking_number_page);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		
		cp.clickAction("add","");
		cb.create(campaignToBeEdited,"",0,0);
		cb.clickAction("list");
		hp.clickAction(Constants.HomePage.home_page);
	}

	public void createTrackingNumber() throws InterruptedException {
        HomePage hp=new HomePage(driver);
        
		try {
			hp.clickAction(Constants.HomePage.campaign_tracking_number_page);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TrackingNumberBuilderPage tn=new TrackingNumberBuilderPage(driver);
		TrackingNumberTest tt=new TrackingNumberTest();
		tt.createInstance();
	    tn.createSimpleNumber(tracking_number);
	    Thread.sleep(2000);		
		hp.clickAction(Constants.HomePage.home_page);

	}

	public void timeZone() throws InterruptedException {
		
		HomePage hp=new HomePage(driver);
		hp.timeZoneSetting();
		hp.clickAction(Constants.HomePage.home_page);		
	}

	public void createGeoLoaction() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.clickAction(Constants.HomePage.settings_section);
		hp.click_subLink(Constants.HomePage.geo_locations);
		
		GeoRouteLocationsPage geo=new GeoRouteLocationsPage(driver);
		geo.addMainLocation(geo_location);
		hp.clickAction(Constants.HomePage.home_page);				
	}

	public void createWebHook() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.clickAction(Constants.HomePage.settings_section);
		hp.click_subLink(Constants.HomePage.webhook);
		WebHookPage wh=new WebHookPage(driver);
		
		logger=extent.startTest("Webhook creation");
		wh.createWebHook(webhook, webhook_url);

		
	}

	public void logOut() {
		
		
	}

}
