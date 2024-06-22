package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;
import java.util.Map;

public class Register {
     WebDriver driver;
    HomePage home;
    RegisterPage registerpage;
    AccountSuccessPage actSucPage;
    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        driver= DriverFactory.getDriver();
        home=new HomePage(driver);
        home.clickOnMyAccount();
        registerpage=home.clickOnRegisterLink();
    }

    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {
        Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
        registerpage.enterFirstName(dataMap.get("firstName"));
        registerpage.enterLastName(dataMap.get("lastName"));
        registerpage.enterEmailID(CommonUtils.getEmailWithTimeStamp());
        registerpage.enterTelephoneNumber(dataMap.get("telephone"));
        registerpage.enterPassword(dataMap.get("password"));
        registerpage.enterConfirmPassword(dataMap.get("password"));
    }

    @When("User selects Privacy Policy")
    public void user_selects_privacy_policy() {

        registerpage.clickOnPrivacyPolicy();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() throws InterruptedException {
        actSucPage=registerpage.clickOnContinueButton();
        Thread.sleep(5000);
    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        Assert.assertEquals("Account name not matched","Your Account Has Been Created!",actSucPage.verifyAccountSuccessMsg());

    }

    @When("User enters the details into below fields with duplicate email")
    public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
        Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
        registerpage.enterFirstName(dataMap.get("firstName"));
        registerpage.enterLastName(dataMap.get("lastName"));
        registerpage.enterEmailID(dataMap.get("email"));
        registerpage.enterTelephoneNumber(dataMap.get("telephone"));
        registerpage.enterPassword(dataMap.get("password"));
        registerpage.enterConfirmPassword(dataMap.get("password"));
    }

    @When("User selects {string} for Newsletter")
    public void user_selects_yes_for_newsletter(String yesMsg) {
        if(yesMsg.equals("Yes")){
            registerpage.clickOnYesRadioButton();
        }else if(yesMsg.equals("No")){
            registerpage.clickOnNoRadioButton();
        }else {
            Assert.assertFalse("No choice is selected", false);
        }
    }

    @Then("User account should get a proper warning about duplicate email")
    public void user_account_should_get_a_proper_warning_about_duplicate_email() {
        Assert.assertEquals("Msg not equal", "Warning: E-Mail Address is already registered!", registerpage.getDuplicateWarningMsg());
    }

    @When("User don't enter any details into fields")
    public void user_don_t_enter_any_details_into_fields() {
            //TBD
    }


    @Then("User should get proper warning message for every mandatory field")
    public void user_should_get_proper_warning_message_for_every_mandatory_field() {
          Assert.assertTrue(registerpage.getWarningMsgOfPrivacyPolicy().contains("Warning: You must agree to the Privacy Policy!"));
          Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getErrorMsgOfFirstName());
          Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getErrorMsgOfLastName());
          Assert.assertEquals("E-Mail Address does not appear to be valid!", registerpage.getErrorMsgOfEmailId());
          Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerpage.getErrorMsgOfTelephoneNum());
          Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getErrorMsgOfPassword());
    }


}
