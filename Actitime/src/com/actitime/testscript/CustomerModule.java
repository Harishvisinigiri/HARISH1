package com.actitime.testscript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.Baseclass;
import com.actitime.generic.FileLib;
import com.actitime.pom.EnterTimeTrackpage;
import com.actitime.pom.TaskListpage;

@Listeners(com.actitime.generic.Listenerimplementation.class)
public class CustomerModule extends Baseclass 
{
	    @Test
		public void testCreateCustomer() throws InterruptedException, EncryptedDocumentException, IOException 
	    {
			EnterTimeTrackpage e=new EnterTimeTrackpage(driver);
			e.setTaskTab();
			TaskListpage t=new TaskListpage(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			t.getAddnewbtn().click();
			t.getNewcustomerbtn().click();
			FileLib f=new FileLib();
			String customerName = f.getExcelData("Sheet1",1,3);
		    String customerDescription = f.getExcelData("Sheet1", 1, 5);
			t.getEntercustomername().sendKeys(customerName);
			t.getEntercustomerdesp().sendKeys(customerDescription);
			t.getExistcustomer().click();
			t.getOurcompany().click();
			t.getCreatecustomer().click();
			Thread.sleep(3000);
		//	WebDriverWait wait=new WebDriverWait(driver, 10);
		//	wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomer(), customerName));
			String actualCustText = t.getActualCustomer().getText();
			Assert.assertEquals(actualCustText, customerName);
		}
	}
