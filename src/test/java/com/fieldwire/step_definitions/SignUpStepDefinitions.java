package com.fieldwire.step_definitions;

import com.fieldwire.pages.SignUpPage;
import com.fieldwire.utilities.BrowserUtils;
import com.fieldwire.utilities.ConfigurationReader;
import com.fieldwire.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpStepDefinitions {
    SignUpPage signuppage = new SignUpPage();

    @Given("user is on the signUp page")
    public void user_is_on_the_signUp_page() {
        Driver.get().get(ConfigurationReader.getProperty("signUpPageUrl"));
    }

    @When("User enter following information first name ,last name, work email and Password")
    public void user_enter_following_information_first_name_last_name_work_email_and_Password() {
        signuppage.enterFirstName(signuppage.stringGenerator("user"));
        signuppage.enterLastName(signuppage.stringGenerator("lastname"));
        signuppage.enterEmailAddress(signuppage.stringGenerator("useremail") + "@gmail.com");
        signuppage.enterPassword(signuppage.stringGenerator("!userPassword"));

    }

    @When("click on Accept Agreement radio button")
    public void click_on_Accept_Agreement_radio_button() {
        signuppage.acceptAgreement();
    }

    @When("Click on Create account")
    public void click_on_Create_account() {
        signuppage.clickCreateButton();
    }

    @When("User enter following information company name, company type, number of employees and phone number")
    public void user_enter_following_information_company_name_company_type_number_of_employees_and_phone_number() {
        signuppage.enterCompanyName(signuppage.stringGenerator("company"));
        signuppage.selectCompanyTypeByIndex(2);
        signuppage.selectCompanySizeByIndex(1);
        signuppage.enterPhone("2015550123");
    }

    @When("click on complete button")
    public void click_on_complete_button() {
        signuppage.clickCompleteButton();
    }

    @Then("verify user is logged in and see project page")
    public void verify_user_is_logged_in_and_see_project_page() {
        BrowserUtils.wait(2);
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(ConfigurationReader.getProperty("projectPageUrl")));
    }
}
