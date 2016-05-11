package com.webuiautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomations.util.WebUtil;



public class EmailViewPage {

	public String getEmailSubjectText(WebDriver driver) {
		return WebUtil.getElementText(driver,By.cssSelector("h2[class='hP']"));
		
	}

	public String getEmailBodyText(WebDriver driver) {
		return WebUtil.getElementText(driver, By.cssSelector("div[class='nH aHU'] div[dir='ltr']"));
		
	}

}
