package com.nexsoft.pom;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddHeaderListName {

	private AndroidDriver driver;
	private WebDriverWait wait;

	@AndroidFindBy(id = "com.lolo.io.onelist:id/title")
	private WebElement headerTitle;
	@AndroidFindBy(id = "com.lolo.io.onelist:id/buttonAddList")
	private WebElement btnAddNewList;
	@AndroidFindBy(id = "com.lolo.io.onelist:id/listTitle")
	public WebElement txtListName;
	@AndroidFindBy(id = "com.lolo.io.onelist:id/cancelEditList")
	public WebElement btnCancelList;
	@AndroidFindBy(id = "com.lolo.io.onelist:id/validateEditList")
	public WebElement btnValidateList;

	public AddHeaderListName(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public String getTitle() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lolo.io.onelist:id/title"))).getText();
	}

	public void clickAddNewList() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.lolo.io.onelist:id/buttonAddList"))).click();
	}

}
