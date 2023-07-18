package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//button[@class='btn btn-primary btn-lg'])[2]")
    WebElement bankLogin;


    //  By BankLogin=By.xpath("(//button[@class='btn btn-primary btn-lg'])[2]");

    public void clickOnLogin() {
        clickOnElement(bankLogin);
        CustomListeners.test.log(Status.PASS,"clickOnLogin");
    }

}
