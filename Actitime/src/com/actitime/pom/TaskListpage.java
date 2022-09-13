package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListpage 
{
	@FindBy(xpath="//div[@class='addNewContainer']")
	private WebElement addnewbtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newcustomerbtn;
	
	@FindBy(xpath="//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")
	private WebElement Entercustomername;
	
	@FindBy(xpath="//textarea[@class='textarea' and @placeholder='Enter Customer Description']")
	private WebElement entercustomerdesp;
	
	@FindBy(xpath="//div[.='- Select Customer -' and @class='emptySelection']")
	private WebElement existcustomer;
	
	@FindBy(xpath="//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourcompany;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcustomer;
	
	@FindBy(xpath = "(//div[@class='editButton'])[17]/..")
	private WebElement ActualCustomer;
	
    public TaskListpage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewcustomerbtn() {
		return newcustomerbtn;
	}

	public WebElement getEntercustomername() {
		return Entercustomername;
	}

	public WebElement getEntercustomerdesp() {
		return entercustomerdesp;
	}

	public WebElement getExistcustomer() {
		return existcustomer;
	}

	public WebElement getOurcompany() {
		return ourcompany;
	}

	public WebElement getCreatecustomer() {
		return createcustomer;
	}
	public WebElement getActualCustomer() {
		return  ActualCustomer;
	}


	}
