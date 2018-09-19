package com.pack.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.pack.pageobjects.page_objects;


public class setUp {
	protected WebDriver driver;
	protected page_objects bankAccountTest_Obj ;
	
	@BeforeTest
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\balpreet\\Downloads\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bankAccountTest_Obj = new page_objects(driver);
	}
	
	@BeforeClass
	public void loginXero(){
		   driver.get("https://login.xero.com/");
		   String first_answer, second_answer, first_question, second_question;
		    bankAccountTest_Obj.username().sendKeys("balpreet.onestop@gmail.com");
		    bankAccountTest_Obj.password().sendKeys("test1234");
		    bankAccountTest_Obj.submit().click();
		    bankAccountTest_Obj.authWithOtherMethod().click(); 
		    bankAccountTest_Obj.authWithSecurityQuestions().click();
			first_question=bankAccountTest_Obj.authFirstQuestion().getText();
			second_question=bankAccountTest_Obj.authSecondQuestion().getText();
			
			if (first_question.equals("What was the name of your favourite stuffed animal?")){
				first_answer="bear";
			}else if(first_question.equals("What is the name of your favourite cartoon?")){
				first_answer="micky";
			}else{
				first_answer="tester";
			}
			if (second_question.equals("What was the name of your favourite stuffed animal?")){
				second_answer="bear";
			}else if(second_question.equals("What is the name of your favourite cartoon?")){
				second_answer="micky";
			}else{
				second_answer="tester";
			}
			bankAccountTest_Obj.authFirstAnswer().sendKeys(first_answer);
			bankAccountTest_Obj.authSecondAnswer().sendKeys(second_answer);
			bankAccountTest_Obj.authSubmitAnswers().click();
	}
	
	@AfterTest
	public void tearDown() {
		this.driver.close();
		System.out.println("--> Automation test finished");
	}

}
