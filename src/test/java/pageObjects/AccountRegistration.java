package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//Note: In any page object class- there should be constructor(receive WebDriver instance), locators and actions
public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	/*
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-newsletter']") WebElement btnSubscribe;
	@FindBy(xpath = "//input[@name='agree']") WebElement btnPolicy;
	@FindBy(xpath = "//button[normalize-space()='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	*/
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	//Actions
	
	// First Name
	public void setFirstName(String fname) {
	    txtFirstname.sendKeys(fname);
	}

	// Last Name
	public void setLastName(String lname) {
	    txtLastname.sendKeys(lname);
	}

	// Email
	public void setEmail(String email) {
	    txtEmail.sendKeys(email);
	}

	// Telephone
	public void setTelephone(String tel) {
	    txtTelephone.sendKeys(tel);
	}

	// Password
	public void setPassword(String pwd) {
	    txtPassword.sendKeys(pwd);
	}

	// Confirm Password
	public void setConfirmPassword(String pwd) {
	    txtConfirmPassword.sendKeys(pwd);
	}

	// Policy checkbox
	public void setPrivacyPolicy() {
	    chkdPolicy.click();
	}

	// Continue button click
	public void clickContinue() {

	    // Sol1
	    btnContinue.click();
	    
	    // Sol2
	    // btnContinue.submit();

	    // Sol3
	    // Actions act = new Actions(driver);
	    // act.moveToElement(btnContinue).click().perform();

	    // Sol4
	    // JavascriptExecutor js = (JavascriptExecutor)driver;
	    // js.executeScript("arguments[0].click();", btnContinue);

	    // Sol5
	    // btnContinue.sendKeys(Keys.RETURN);

	    // Sol6
	    // WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
