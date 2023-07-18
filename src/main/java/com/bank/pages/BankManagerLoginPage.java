package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccount;

    // By openAccount = By.xpath("//button[@ng-class='btnClass2']");
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement customerName;
    //  By customerName = By.id("userSelect");

    @CacheLookup
    @FindBy(id = "currency")
    WebElement currencyPound;
    //By currencyPound = By.id("currency");
    @CacheLookup
    @FindBy(xpath = "//button[text()='Process']")
    WebElement processButton;
    //  By processButton = By.xpath("//button[text()='Process']");

    public void selectNameFromDropDown(String name) {
        selectByVisibleTextFromDropDown(customerName, name);
        CustomListeners.test.log(Status.PASS,"selectNameFromDropDown");
    }


    public void selectCurrencyFromDropDown(String currency) {
        selectByVisibleTextFromDropDown(currencyPound, currency);
        CustomListeners.test.log(Status.PASS,"selectCurrencyFromDropDown");

    }

    public void clickOnProcess() {
        clickOnElement(processButton);
        CustomListeners.test.log(Status.PASS,"clickOnProcess");

    }

    public void clickOnOpenAccount() {
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS,"clickOnOpenAccount");
    }


}
