package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

//Note: Run through xml as parameter has been defined in base class
public class TC001_AccountRegistration extends BaseClass {

	// On Test class we just call page objects and check validation
	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration() {
		logger.info("*******Starting TC001_Account Registration Test************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on my Account link");
			hp.clickRegister();
			logger.info("Clicked on Register link");
			AccountRegistration regpage = new AccountRegistration(driver);
			// Here are randomly passing the values to the already created methods on P.O
			logger.info("Providing customer details");
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastName(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com"); // randomly generated the email
			regpage.setTelephone(randomNumber());
			String password = randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			logger.info("Validating expected message...");
			String confmsg = regpage.getConfirmationMsg();
			if (confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed...");
				logger.debug("Debug logs...");
				Assert.fail();
			}
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("Finished Test");
	}
}
