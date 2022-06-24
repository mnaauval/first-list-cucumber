package com.nexsoft.definitions;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.nexsoft.pom.ScreenshotHandler;
import com.nexsoft.pom.AddHeaderListName;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewListName {

	private AndroidDriver driver;
	private DesiredCapabilities capabilities;
	private WebDriverWait wait;
	private AddHeaderListName headerAdd;
	private ScreenshotHandler screenshot;

	@Before
	public void init() {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11");
		capabilities.setCapability("uid", "52c5c997");
		capabilities.setCapability("appPackage", "com.lolo.io.onelist");
		capabilities.setCapability("appActivity", "com.lolo.io.onelist.MainActivity");

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		headerAdd = new AddHeaderListName(driver);
		screenshot = new ScreenshotHandler(driver);
	}

	@Given("User at Main Activity")
	public void atMainActivity() {
		String actl = headerAdd.getTitle();
		String expt = "1List";
		Assert.assertEquals(actl, expt);
		System.out.println(actl);
	}

	@When("User tap add list name button")
	public void clickAddBtn() {
		headerAdd.clickAddNewList();
		System.out.println("Click add list name");
	}

	@And("User input list name alphabet {string}")
	public void inputListName1(String lstName) {
		headerAdd.txtListName.sendKeys(lstName);
		System.out.println(lstName);
	}

	@And("User input list name number {string}")
	public void inputListName2(String lstName) {
		headerAdd.txtListName.sendKeys(lstName);
		System.out.println(lstName);
	}

	@And("User input list name symbol {string}")
	public void inputListName3(String lstName) {
		headerAdd.txtListName.sendKeys(lstName);
		System.out.println(lstName);
	}

	@And("User input list name special char {string}")
	public void inputListName4(String lstName) {
		headerAdd.txtListName.sendKeys(lstName);
		System.out.println(lstName);
	}

	@And("User input empty field {string}")
	public void inputListName5(String lstName) {
		headerAdd.txtListName.sendKeys(lstName);
		System.out.println(lstName);
	}

	@Then("User validate list name")
	public void clickBtnValidate() {
		headerAdd.btnValidateList.click();
		System.out.println("Validate");
	}

	@Then("User cancel list name")
	public void clickBtnCancel() {
		headerAdd.btnCancelList.click();
		System.out.println("Cancel");
	}

	@And("New list name showed in header")
	public void showHeaderList() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> lstHeader = wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//androidx.recyclerview.widget.RecyclerView/"
						+ "android.widget.TextView[@resource-id='com.lolo.io.onelist:id/textView']")));
		boolean checkData = false;
		String file = "<img src='file://"
				+ screenshot.screenshootElm(driver.findElement(By.id("com.lolo.io.onelist:id/listsRecyclerView")))
				+ "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
		for (WebElement webElement : lstHeader) {
			String listname = webElement.getText().trim();
			System.out.println(listname);
			if (listname.equalsIgnoreCase("Bootcamp Test")) {
				checkData = true;
			}
			if (listname.equalsIgnoreCase("08951234")) {
				checkData = true;
			}
			if (listname.equalsIgnoreCase("!@#$%^&")) {
				checkData = true;
			}
			if (listname.equalsIgnoreCase("📅📅📅")) {
				checkData = true;
			}
		}
		assertTrue(checkData);
	}

	@And("New list name not showed in header")
	public void showHeaderList1() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String file = "<img src='file://"
				+ screenshot.screenshootElm(driver.findElement(By.id("com.lolo.io.onelist:id/listsRecyclerView")))
				+ "'height=\"350\" width=\"792\"/>";
		Reporter.log(file);
	}
}
