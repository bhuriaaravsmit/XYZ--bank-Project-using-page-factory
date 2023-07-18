package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement home;

    // By home = By.xpath("//button[@class='btn home']");


    // @CacheLookup
    @FindBy(xpath = "//button[text()='Customer Login' ]")
    WebElement customerLogin;
    //  By customerLogin = By.xpath("//button[text()='Customer Login' ]");


    //@CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchName;


    // @CacheLookup
    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;
    //By searchName = By.xpath("//select[@id='userSelect']");

    // By loginButton = By.xpath("//button[text()='Login']");

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutButton;

    // By logoutButton = By.xpath("//button[@class='btn logout']");

    public WebElement getSearchName() {
        return searchName;
    }


    public void clickOnHome() {
        clickOnElement(home);
        CustomListeners.test.log(Status.PASS,"clickOnHome");
    }

    public void clickOnCustomerLogin() {
        clickOnElement(customerLogin);
        CustomListeners.test.log(Status.PASS,"clickOnCustomerLogin");
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"clickOnLogin");
    }

    public void clickOnLogout() {
        clickOnElement(logoutButton);
        CustomListeners.test.log(Status.PASS,"clickOnLogout");
    }


    public void selectNameFromDropDown(String name) {
        selectByVisibleTextFromDropDown(searchName, name);
    }

}
