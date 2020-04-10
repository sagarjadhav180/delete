package testdata;

public interface TestDataFunctions {

	public void login() throws Exception;
	public void createGroup() throws InterruptedException;
	public void createUser() throws InterruptedException;
	public void createCampaign() throws InterruptedException;
	public void createTrackingNumber() throws InterruptedException;
	public void trackingNumberSettings() throws InterruptedException;
	public void timeZone() throws InterruptedException;
	public void createGeoLoaction() throws InterruptedException;
	public void createWebHook() throws InterruptedException;
	public void logOut();
		
	
}
