package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

		
		
		@Test(groups= {"Master","Regression"})
		public void verify_account_registration() throws InterruptedException
		{
			try 
			{
			logger.info("***** Starting TC001_AccountRegistrationTest *****");			
			
			HomePage hp=new HomePage(driver);
						
			hp.clickMyAccount();
			logger.info("clicked on My Account.....");
			
			hp.clickOnRegister();
			logger.info("clicked on Register.....");
			Thread.sleep(1000);

			logger.info("Entering customer details.....");
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString());
			regpage.setEmailId(randomString()+"@gmail.com");
			regpage.seTelephoneNo(randomNumber());
			String pwd=randomString();
			regpage.setPassword(pwd);
			regpage.setConfirmPassword(pwd);
			regpage.setPolicy();
			Thread.sleep(1000);
			regpage.clickContinue();
			
			logger.info("validating confirmation message......");
			String confirm_msg=regpage.getConfirmantionMessage();
			
			if(confirm_msg.equals("Your Account Has Been Created!"))
				{
					Assert.assertTrue(true);
				}
			else
				{
					logger.error("Test Failed..");
					logger.debug("Debug logs..");
					Assert.assertTrue(false);
				}
			}
			
			catch(Exception e)
			{
				
				Assert.fail();
			}
		
			logger.info("********* Finished TC001_AccountRegistrationTest *******");
				
		
		
		}
		
}

