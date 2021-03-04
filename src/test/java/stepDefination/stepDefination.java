package stepDefination;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefination{
	static WebDriver driver;

//	@BeforeClass 
//	public WebDriver launchBrowser() {
//		System.setProperty("webdriver.chrome.driver","D:\\FLexMoneyAssignment\\Automation\\src\\test\\java\\Drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//		return driver;
//	}
	
	@Test
	@Given("^I am on simulation page$")
	public WebDriver i_am_on_simulation_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","D:\\FLexMoneyAssignment\\Automation\\src\\test\\java\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://staging.instacred.me/simulation/tpsl/e2e-transaction.jsp");
        driver.manage().window().maximize();
		return driver;
		
	}

//	@Given("^I enter incorrect mobile number$")
//	public void i_enter_incorrect_mobile_number() throws Throwable {
//		UIElements.mobileNumberTextbox.sendKeys("1231231230");
//	}

	@When("^I click on continue button$")
	public void i_click_on_continue_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='continueBtn']")).click();
	}

	@Then("^I verify that user is on payment enter mobile page$")
	public void i_verify_that_user_is_on_payment_enter_mobile_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		boolean paymentEnterMobileNumber = driver.findElement(By.xpath("//input[contains(@id,'payment-enter-mobile')]")).isDisplayed();
		Assert.assertTrue(paymentEnterMobileNumber);
		
	}

	@When("^I enter correct mobile number$")
	public void i_enter_correct_mobile_number() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[contains(@id,'payment-enter-mobile')]")).sendKeys("9988998899");
	}

	@When("^I click on Submit button$")
	public void i_click_on_Submit_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@id=\"submitButton\"]")).click();
	}

	@Then("^I verify user is on EMI selection page$")
	public void i_verify_user_is_on_EMI_selection_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean selectEMI = driver.findElement(By.xpath("//button[@id=\"submitButton\"]")).isDisplayed();
		System.out.println(selectEMI);
		Assert.assertTrue(selectEMI);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@When("^I select EMI option of three months$")
	public void i_select_EMI_option_of_three_months() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement emiOption = driver.findElement(By.xpath("//*[contains(@id,'emi-panel-0')]"));
		emiOption.click();
	}

	@When("^I click on Confirm Button$")
	public void i_click_on_Confirm_Button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//*[contains(@id,\"submitButton\")]")).click();
	}

	@Then("^I am redirected Transaction Confirmation Page$")
	public void i_am_redirected_Transaction_Confirmation_Page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean TransactionConfirmationPage = driver.findElement(By.xpath("//*[@id=\"accountNo\"]")).isDisplayed();
		Assert.assertEquals(true, TransactionConfirmationPage);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		this.cleanUp();
	}
	
	public void cleanUp() {
		driver.close(); // close the browser
	}


	
}
