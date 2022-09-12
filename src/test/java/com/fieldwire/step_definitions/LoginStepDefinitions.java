package com.fieldwire.step_definitions;

import com.fieldwire.pages.LoginPage;
import com.fieldwire.utilities.BrowserUtils;
import com.fieldwire.utilities.ConfigurationReader;
import com.fieldwire.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("loginPageUrl"));
    }

    @When("user enter email_address and clicks next")
    public void user_enter_and_clicks_next() {
        loginPage.enterEmailAddress(ConfigurationReader.getProperty("username"));

    }

    @Then("verify user can see password field")
    public void verify_user_can_see_password_field() {
        Assert.assertTrue(loginPage.isPasswordFieldVisible());
    }

    @When("user enter password and click login")
    public void user_enter_password_and_click_login() {
        loginPage.enterPassword(ConfigurationReader.getProperty("password"));
        loginPage.clickLoginButton();
    }

    @Then("verify user lands on Project Page")
    public void verify_user_lands_on_Project_Page() {
        BrowserUtils.wait(2);
        Assert.assertEquals(Driver.get().getCurrentUrl(), ConfigurationReader.getProperty("projectPageUrl"));
    }

    @When("user enter email address {string} and press Enter")
    public void user_enter_email_address_and_press_Enter(String string) {
        loginPage.enterEmailAddress(string);
    }

    @When("user enter password {string} and press Enter")
    public void user_enter_password_and_press_Enter(String string) {
        loginPage.enterPassword(string);
    }

    @Then("validate {string} error message is displayed on the page")
    public void validate_error_message_is_displayed_on_the_page(String string) {
        Assert.assertEquals(loginPage.getErrorMessage(), string);
    }


}
