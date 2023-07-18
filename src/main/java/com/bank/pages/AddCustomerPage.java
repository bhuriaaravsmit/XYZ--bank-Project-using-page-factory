package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;

    // By addCustomer = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]");

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    // By firstName = By.xpath("//input[@placeholder='First Name']");

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    // By lastName = By.xpath("//input[@placeholder='Last Name']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    //By postCode = By.xpath("//input[@placeholder='Post Code']");

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement addCustomerButton;
    // By addCustomerButton = By.xpath("//button[@class='btn btn-default']");

    public void clickOnAddCustomer() {
        clickOnElement(addCustomer);
        CustomListeners.test.log(Status.PASS,"clickOnAddCustomer");

    }

    public void sendTextToFirstName(String name) {
        sendTextToElement(firstName, name);
        CustomListeners.test.log(Status.PASS,"Enter FirstNane" +name);
    }

    public void sendTextToLastName(String lastname) {
        sendTextToElement(lastName, lastname);
        CustomListeners.test.log(Status.PASS,"Enter LastName" +lastname);
    }

    public void sendTextToPostCode(String postCode1) {
        sendTextToElement(postCode, postCode1);
        CustomListeners.test.log(Status.PASS,"Enter PostCode" +postCode1);
    }

    public void clinkOnAddCustomerButton() {
        clickOnElement(addCustomerButton);
        CustomListeners.test.log(Status.PASS,"clinkOnAddCustomerButton");
    }
}