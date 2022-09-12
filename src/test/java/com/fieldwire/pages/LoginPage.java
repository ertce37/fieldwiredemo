package com.fieldwire.pages;

import com.fieldwire.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "email-input")
    private WebElement emailInput;

    @FindBy(xpath = "//fw-button[@label='Next']/button")
    private WebElement nextButton;

    @FindBy(id = "password-input")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@translate='FAILURE_NOT_FOUND_IN_DATABASE']")
    private WebElement errorMessage;

    @FindBy(xpath = "//fw-button[@label='Log in']/button")
    private WebElement loginButton;


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void enterEmailAddress(String emailAddress) {

        populateVisableInputFieldWithText(emailInput, emailAddress);
        emailInput.sendKeys(Keys.TAB, Keys.ENTER);
    }

    public void enterPassword(String password) {
        populateVisableInputFieldWithText(passwordInput, password);
        passwordInput.sendKeys(Keys.TAB, Keys.ENTER);
    }

    public void clickLoginButton() {
        clickVisibleAndClickableButton(loginButton);
    }

    public boolean isPasswordFieldVisible() {
        return passwordInput.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
