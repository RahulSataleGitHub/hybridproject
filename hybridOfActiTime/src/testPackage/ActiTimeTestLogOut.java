package testPackage;

import java.io.IOException;

import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;

public class ActiTimeTestLogOut extends BaseTest{
  @Test
  public void logout() throws InterruptedException, IOException 
  {
	  LoginPage lp = new LoginPage(driver);
	  Flib flib = new Flib();
	  lp.actiTimeValidLogin(flib.readPropertyData(PROP_PATH,"Username"), flib.readPropertyData(PROP_PATH,"Password"));
	  HomePage hp = new HomePage(driver);
	  hp.logOut();
  }
}
