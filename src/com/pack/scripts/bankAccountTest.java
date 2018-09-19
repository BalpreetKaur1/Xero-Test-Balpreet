package com.pack.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pack.base.setUp;
import java.util.Iterator;
import java.util.Random;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
public class bankAccountTest extends setUp {
	
	public String generateRandomString(){
		String alphabet= "abcdefghijklmnopqrstuvwxyz1234567890";
        String randomName = "";
        Random random = new Random();
        int randomLen = 1+random.nextInt(9);
        for (int i = 0; i < randomLen; i++) {
            char c = alphabet.charAt(random.nextInt(26));
            randomName+=c;
        }
        return randomName;
	}
	
	String randomAccountNumber = generateRandomString();
	String randomName = generateRandomString();
	
	public Boolean verifyBankDetail(){
	   Boolean flag=false;
	   Iterator<WebElement> iter = bankAccountTest_Obj.totalBanksAdded().iterator();
	   // this will check whether list has newly added bank details or not
	   while (iter.hasNext()) {
		WebElement item = iter.next();
		String label = item.getText();
		if(label.equals(randomAccountNumber)){
			flag=true;;
		}
	   }	
	   return flag;
     }
	
  @Test
  public void addingBankAccount() {
	    bankAccountTest_Obj.accounts().click();
	    bankAccountTest_Obj.bankAccounts().click();
	    bankAccountTest_Obj.addBankAccounts().click(); 
	    bankAccountTest_Obj.searchFields().sendKeys("ANZ (NZ)");
	    bankAccountTest_Obj.searchBank().click();
	    bankAccountTest_Obj.clickBankFromList().click();
	    bankAccountTest_Obj.bankAccountName().sendKeys(randomName);
	    bankAccountTest_Obj.bankAccountType().click();
	    bankAccountTest_Obj.bankAccountType().sendKeys(Keys.ENTER);	
	    bankAccountTest_Obj.accountNumber().sendKeys(randomAccountNumber);
	    bankAccountTest_Obj.accountSubmit().click();
		Assert.assertEquals(bankAccountTest_Obj.accountAdded().getText(), randomName+" has been added.");
		Assert.assertSame(verifyBankDetail(), true);
  }	
}