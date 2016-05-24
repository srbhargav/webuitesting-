package com.webuiautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.webautomations.util.Constant;
import com.webautomations.util.WebUtil;



public class EmailHomepage {

	public SignInPage signOut(WebDriver driver) throws InterruptedException {
		  WebUtil.click(driver,By.cssSelector(".gb_3a.gbii" ));
		 Thread.sleep(1000);
          WebUtil.click(driver, By.xpath(".//*[@id='gb_71']"));
          Thread.sleep(2000);
		 return PageFactory.initElements(driver, SignInPage.class);
		}

	

	public boolean isInboxExist(WebDriver driver) {
		return WebUtil.isElementExist(driver,By.partialLinkText("Inbox"));
		
		
	}



	public void clickComposeButton(WebDriver driver) throws InterruptedException {
		Thread.sleep(1000);
		WebUtil.click(driver, By.cssSelector("div[role='button'][gh='cm']"));     
	}



	public void fillInReceipent(WebDriver driver, String email) throws InterruptedException {
		Thread.sleep(2000);
	    WebUtil.clearAndSendKeys(driver, By.cssSelector("textarea[name='to']"),Constant.eMail);
        
		
	}



	public void fillInSubject(WebDriver driver, String subject) throws InterruptedException {
		Thread.sleep(1000);
		WebUtil.clearAndSendKeys(driver, By.cssSelector("input[name='subjectbox']"), subject);
		
	}



	public void fillInEmailBody(WebDriver driver, String body) throws InterruptedException {
		Thread.sleep(1000);
		WebUtil.clearAndSendKeys(driver, By.cssSelector("div[aria-label='Message Body']"), body);
		
	}



	public void clickSendEmail(WebDriver driver) {
		 WebUtil.click(driver, By.cssSelector("div[aria-label*='Send']"));
		
	}



	public void clickInboxWithNewEmail(WebDriver driver, String string) throws InterruptedException {
	     Thread.sleep(2000);
	     WebUtil.click(driver, By.linkText("Inbox (20)"));
		
	}



	public EmailViewPage clickNewEmail(WebDriver driver) throws InterruptedException {
		 Thread.sleep(2000);
		 WebUtil.click(driver, By.cssSelector("div[class='y6'] span[id] b"));
         return PageFactory.initElements(driver, EmailViewPage.class);
		
	}

}
