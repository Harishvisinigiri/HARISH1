package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.Loginpage;

public class Baseclass 
{
	static {
    System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	}
	public static	WebDriver driver;
			@BeforeTest
			public void openBrowser() {                         
			Reporter.log("openBrowser",true);
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			@AfterTest
			public void closeBrowser() {
				Reporter.log("closeBrowser",true);	           
				driver.close();                               
			}                                                 
			@BeforeMethod                               
			public void login() throws IOException {                              
			Reporter.log("login",true);	 
			Loginpage l=new Loginpage(driver);
			FileLib f=new FileLib();                          
			driver.get(f.getPropertyData("url"));
			l.setLogin(f.getPropertyData("username"), f.getPropertyData("password"));
			}                                                 
			@AfterMethod                                       
			public void logout() {                             
			Reporter.log("logout",true);	                    
			}
		}
/*
 * 1.open the browser 
 * 2.Enter the URL
 * 3.Login to application
 *4.Click on Task Tab
 *5.Click on Add New Bu                 
 *6.Select New Customer in the Menu
 *7.Enter the customer Name
 *8.Enter the Customer Description
 *9.Click on Select Customer DropDown
 *10.Select our company in the drop drown
 *11.Click on Create Customer
 *12 .Verify the Customer is successfully create or not
 *13.Logout of the Apllication                                        
 *14.Close the Browser
 */
