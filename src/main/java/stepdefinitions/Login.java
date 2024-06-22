package stepdefinitions;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

import java.time.Duration;
import java.util.Date;

public class Login {

    WebDriver driver;
    HomePage home;
    LoginPage loginPage;
    AccountPage accountpage;

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        driver=DriverFactory.getDriver();
        home=new HomePage(driver);
        home.clickOnMyAccount();
        loginPage=home.clickOnLogin();
    }

    @When("User enters valid email address {string} into email field")
    public void user_enters_valid_email_address_into_email_field(String emailId) {
        loginPage.provideEmailID(emailId);
    }

    @When("User enters valid password {string} into password field")
    public void user_enters_valid_password_into_password_field(String password) {
        loginPage.providePassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        accountpage=loginPage.clickOnSubmitButton();
    }

    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        String ele=accountpage.verifyAccountText();
        Assert.assertEquals("Title not matched","My Account",ele);
    }

    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_field() {
        loginPage.provideEmailID(CommonUtils.getEmailWithTimeStamp());
    }

    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_field(String invalidPassword) {
        loginPage.providePassword(invalidPassword);
    }

    @Then("User should get proper warning message about credentials mismatch")
    public void user_should_get_proper_warning_message_about_credentials_mismatch() {
        Assert.assertTrue(loginPage.verifyWarningMsg().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("User don't enter email address into email field")
    public void user_don_t_enter_email_address_into_email_field() {
        loginPage.provideEmailID("");
    }

    @When("User don't enter password into password field")
    public void user_don_t_enter_password_into_password_field() {
        loginPage.providePassword("");
    }



}
