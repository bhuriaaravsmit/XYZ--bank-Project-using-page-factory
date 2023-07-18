package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement deposit;

    // By deposit = By.xpath("//button[@ng-class='btnClass2']");

    //@CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    // By amount=By.xpath("//input[@placeholder='amount']");
    @CacheLookup
    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Deposit Successful']")
    WebElement depositSuccessful;

    //By depositButton= By.xpath("//button[text()='Deposit']");
    //  By depositSuccessful =By.xpath("//span[text()='Deposit Successful']");

    public WebElement getDepositSuccessful() {
        return depositSuccessful;
    }


    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass3']")
    WebElement withdrawal;


    // By withdrawal = By.xpath("//button[@ng-class='btnClass3']");

    @CacheLookup
    @FindBy(xpath = "//button[text()='Withdraw']")
    WebElement withdrawButton;

    // By withdrawButton= By.xpath("//button[text()='Withdraw']");


    @CacheLookup
    @FindBy(xpath = "//span[text()='Transaction successful']")
    WebElement transactionSuccessful;


    public WebElement getTransactionSuccessful() {
        return transactionSuccessful;
    }

    public void clickOnDepositButton() {
        clickOnElement(depositButton);
        CustomListeners.test.log(Status.PASS,"clickOnDepositButton");
    }

    public void clickOnDeposit() {
        clickOnElement(deposit);
        CustomListeners.test.log(Status.PASS,"clickOnDeposit");
    }

    public void clickOnWithdrawal() {
        clickOnElement(withdrawal);
        CustomListeners.test.log(Status.PASS,"clickOnWithdrawal");
    }

    public void clickOnWithdrawalButton() {
        clickOnElement(withdrawButton);
        CustomListeners.test.log(Status.PASS,"clickOnWithdrawalButton");
    }

    public void sendTextToAmount(String amount) {
        sendTextToElement(this.amount, amount);
        CustomListeners.test.log(Status.PASS,"sendTextToAmount");
    }
}
