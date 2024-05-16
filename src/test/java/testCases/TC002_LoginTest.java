package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Master","Sanity"})
	public void veifyLogin()
	{
		try {
			logger.info("***** started Execution *****");
			
			//HomePage
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("clicked on MyAccount....");
			
			hp.clickOnLogin();
			logger.info("clicked on Login....");
			
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			
			logger.info("Entering email....");
			lp.enterEmail(p.getProperty("email"));	
			
			logger.info("entering password....");
			lp.enterPassword(p.getProperty("password"));	
			
			logger.info("clicked on login button....");
			lp.clickLogin();
			
			//MyAccountPage
			MyAccountPage acc_page=new MyAccountPage(driver);
						
			boolean act_res=acc_page.isMyAccountPageExists();
			//Assert.assertTrue(act_res);
			
			Assert.assertEquals(act_res, true,"Login Failed");
						
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		finally {
			logger.info("***** Finished Execution *****");
		}
	}

}
