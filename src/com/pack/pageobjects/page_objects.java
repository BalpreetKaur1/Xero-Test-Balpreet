package com.pack.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class page_objects {
	private WebDriver driver;
	
	public page_objects(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement username(){
		return driver.findElement(By.id("email"));
	}
	public WebElement password(){
		return driver.findElement(By.id("password"));
	}
	public WebElement submit(){
		return driver.findElement(By.id("submitButton"));
	}
	public WebElement authWithOtherMethod(){
		return driver.findElement(By.xpath("//button[@data-automationid='auth-othermethodbutton']"));
	}
	public WebElement authWithSecurityQuestions(){
		return driver.findElement(By.xpath("//button[@data-automationid='auth-authwithsecurityquestionsbutton']"));
	}
	public WebElement authFirstQuestion(){
		return driver.findElement(By.xpath("//span[contains(@class,'auth-firstquestion')]"));
	}
	public WebElement authSecondQuestion(){
		return driver.findElement(By.xpath("//span[contains(@class,'auth-secondquestion')]"));
	}
	public WebElement authFirstAnswer(){
		return driver.findElement(By.xpath("//input[@data-automationid='auth-firstanswer--input']"));
	}
	public WebElement authSecondAnswer(){
		return driver.findElement(By.xpath("//input[@data-automationid='auth-secondanswer--input']"));
	}
	public WebElement authSubmitAnswers(){
		return driver.findElement(By.xpath("//button[@data-automationid='auth-submitanswersbutton']"));
	}
	
	public WebElement accounts(){
		return driver.findElement(By.xpath("//a[text()='Accounts']"));
	}
	public WebElement bankAccounts(){
		return driver.findElement(By.xpath("//a[text()='Bank Accounts']"));
	}
	public WebElement addBankAccounts(){
		return driver.findElement(By.xpath("//span[@data-automationid='Add Bank Account-button']"));
	}
	public WebElement searchFields(){
		return driver.findElement(By.id("xui-searchfield-1018-inputEl"));
	}
		
	public WebElement searchBank(){
		return driver.findElement(By.xpath("//div[@id='component-1027']//a"));
	}
	public WebElement clickBankFromList(){
		return driver.findElement(By.xpath("//ul[@id='dataview-1025']//li"));
	}
	public WebElement bankAccountName(){
		return driver.findElement(By.id("accountname-1037-inputEl"));
	}
	public WebElement bankAccountType(){
		return driver.findElement(By.id("accounttype-1039-inputEl"));
	}
	
	public WebElement accountNumber(){
		return driver.findElement(By.id("accountnumber-1068-inputEl"));
	}
	public WebElement accountSubmit(){
		return driver.findElement(By.id("common-button-submit-1015-btnInnerEl"));
	}
	public WebElement accountAdded(){
		return driver.findElement(By.xpath("//div[@id='notify01']//div//p"));
	}	
	public List<WebElement> totalBanksAdded(){
		return driver.findElements(By.xpath("//div[@class='bank']//div[1]//a//span"));
	}
}
