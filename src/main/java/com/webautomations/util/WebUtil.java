package com.webautomations.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.webuiautomation.pageobjects.SignInPage;



public class WebUtil {

	public static SignInPage goToSignInPage(WebDriver driver) {
		driver.get("http://www.gmail.com");
		return PageFactory.initElements(driver,SignInPage.class);
	}

	public static void click(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}

	public static boolean isElementExist(WebDriver driver, By by) {
		return driver.findElements(By.partialLinkText("Inbox")).size()> 0 ;
		
	}

	public static void clearAndSendKeys(WebDriver driver, By by, String s) {
		WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(s);
		
	}

	public static String getElementText(WebDriver driver, By by) {
		 WebElement subjectArea = driver.findElement(by);
			return subjectArea.getText();
		
	}

}
