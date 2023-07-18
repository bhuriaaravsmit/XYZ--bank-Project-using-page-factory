package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {


    HomePage homepage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;

    CustomerLoginPage customerLoginPage;

    CustomersPage customersPage;

    @BeforeMethod(groups = {"sanity","Smoke", "regression"})
    public void inIT() {
        homepage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        sleep(2000);
        homepage.clickOnLogin();
        addCustomerPage.clickOnAddCustomer();
        addCustomerPage.sendTextToFirstName("Shweta");
        addCustomerPage.sendTextToLastName("Shah");
        addCustomerPage.sendTextToPostCode("BD85AE");
        addCustomerPage.clinkOnAddCustomerButton();
        sleep(2000);
        String message = driver.switchTo().alert().getText();
        sleep(2000);
        Assert.assertTrue(message.contains("Customer added successfully"));
        driver.switchTo().alert().accept();

    }

    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {

        sleep(2000);
        bankManagerShouldAddCustomerSuccessfully();
        bankManagerLoginPage.clickOnOpenAccount();
        bankManagerLoginPage.selectNameFromDropDown("Shweta Shah");
        bankManagerLoginPage.selectCurrencyFromDropDown("Pound");
        bankManagerLoginPage.clickOnProcess();
        String message = driver.switchTo().alert().getText();
        sleep(2000);
        Assert.assertTrue(message.contains("Account created successfully"));
        driver.switchTo().alert().accept();

    }

    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        customerLoginPage.clickOnHome();
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.selectNameFromDropDown("Shweta Shah");

        customerLoginPage.clickOnLogin();
        customerLoginPage.clickOnLogout();


        WebElement dropDown = customerLoginPage.getSearchName();
        Select select = new Select(dropDown);
        List<WebElement> names = select.getOptions();
        boolean isContains = false;
        for (WebElement name : names) {
            if (name.getText().equals("Shweta Shah")) {
                System.out.println(name.getText());
                isContains = true;
            }
        }

        Assert.assertTrue(isContains);
    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() {
        bankManagerShouldOpenAccountSuccessfully();
        customerLoginPage.clickOnHome();
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.selectNameFromDropDown("Shweta Shah");
        customerLoginPage.clickOnLogin();
        customersPage.clickOnDeposit();
        customersPage.sendTextToAmount("100");
        customersPage.clickOnDepositButton();
        verifyText(customersPage.getDepositSuccessful(), "Deposit Successful");
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() {

        customerShouldDepositMoneySuccessfully();
        customerLoginPage.clickOnHome();
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.selectNameFromDropDown("Shweta Shah");

        customerLoginPage.clickOnLogin();
        customersPage.clickOnWithdrawal();
        customersPage.sendTextToAmount("50");
        customersPage.clickOnWithdrawalButton();
        verifyText(customersPage.getTransactionSuccessful(), "Transaction successfull1");

    }

}
