package com.webuiautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.webautomations.util.Constant;
import com.webautomations.util.WebUtil;



public class SignInPage {

	public void fillInUserName(WebDriver driver, String s) {
		WebUtil.clearAndSendKeys(driver, By.id("Email"), Constant.eMail);
		
	}

	public void clickOnNext(WebDriver driver) throws InterruptedException {
		WebUtil.click(driver, By.id("next"));
        Thread.sleep(2000);
	}

	public void fillInPassword(WebDriver driver, String string) {
		  WebUtil.clearAndSendKeys(driver, By.name("Passwd"), Constant.Password);		
	}
   


	public EmailHomepage clickSignin(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		WebUtil.click(driver, By.id("signIn"));
         Thread.sleep(1000);
         return PageFactory.initElements(driver,EmailHomepage.class);
	}

	public boolean isSignInButtonExist(WebDriver driver) {
		return WebUtil.isElementExist(driver, By.name("signIn"));
	
	}


}

