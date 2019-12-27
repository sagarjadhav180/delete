package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pom.LoginPage;


@Test
public class LoginTest extends TestBase
{
	public void login() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);

        lp.validLogin();		
	}

}
