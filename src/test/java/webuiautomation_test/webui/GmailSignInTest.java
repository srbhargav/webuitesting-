package webuiautomation_test.webui;


import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webautomations.util.Constant;
import com.webautomations.util.WebUtil;
import com.webuiautomation.categories.Critical;
import com.webuiautomation.categories.Major;
import com.webuiautomation.pageobjects.EmailHomepage;
import com.webuiautomation.pageobjects.EmailViewPage;
import com.webuiautomation.pageobjects.SignInPage;

import java.sql.Driver;

import org.junit.*;



public class GmailSignInTest {
	WebDriver driver = new FirefoxDriver();
	@Category({Critical.class})
	@Test
	
       public void gmailloginshouldbesuccessfull() throws InterruptedException{
          //1. Go to Gmail website
		  SignInPage signInPage = WebUtil.goToSignInPage(driver);
		 
		  //2. Fill in the username
		  signInPage.fillInUserName(driver,Constant.Username);
          signInPage.clickOnNext(driver);
          
          //3. Fill in the password
          signInPage.fillInPassword(driver,Constant.Password);
          //4. Click on Sign in button
          EmailHomepage emailHomepage = signInPage.clickSignin(driver);
          
          //5. Verify User did sign in
          Assert.assertTrue("Inbox should exist", emailHomepage.isInboxExist(driver));
          
          //6. sign out
          signInPage =  emailHomepage.signOut(driver);
          
          //7. Verified User signed out 
         // Assert.assertTrue("Signin Button should exist", signInPage.isSignInButtonExist(driver) );
      
      }
		
	@Category({Major.class})
	@Test
	
    public void gmailSendandReceiveEmailTest() throws InterruptedException{
     	 //1. Click on Signin
		
		 //1. Go to Gmail website
		 SignInPage signInPage = WebUtil.goToSignInPage(driver);
		 //2. Fill in the username
		 signInPage.fillInUserName(driver,Constant.Username);
         signInPage.clickOnNext(driver);
         
         //3. Fill in the password
         signInPage.fillInPassword(driver,Constant.Password);
         //4. Click on Sign in button
         EmailHomepage emailHomepage = signInPage.clickSignin(driver);
         
         //5. Verify User did sign in
         Assert.assertTrue("Inbox should exist", emailHomepage.isInboxExist(driver));
         
         //2. Click on compose
         emailHomepage.clickComposeButton(driver);
         
         //3. fill in the recipent
         emailHomepage.fillInReceipent(driver,Constant.eMail);
         
         //4. Fill in subject line
         final String subject = "Gmail Send Email Test";
         emailHomepage.fillInSubject(driver,subject);
         
         //5. Fill in EMail Body
         final String body = "Hello Testers Good Morning";
         emailHomepage.fillInEmailBody(driver,body);
         
         //6. Click Send
         emailHomepage.clickSendEmail(driver);
        
         //7. Click Inbox Again
         emailHomepage.clickInboxWithNewEmail(driver,"Inbox (20)");
    
         //8. Click Email
        EmailViewPage emailViewPage = emailHomepage.clickNewEmail(driver);
        
         //9. Verify the email subject and email body is correct
        String actualSubject = emailViewPage.getEmailSubjectText(driver);
         
        
         Assert.assertEquals("Email subject should be same", subject, actualSubject);
         
         String actualBody = emailViewPage.getEmailBodyText(driver);
         
         Assert.assertEquals("Email body should be same", body, actualBody);
	     //10. Sign out
         signInPage =  emailHomepage.signOut(driver);
       
		
		
	}
	@After
	  public void tearDown(){
		  driver.quit();
	  }
}

