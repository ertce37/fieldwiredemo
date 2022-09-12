package com.fieldwire.pages;

import com.fieldwire.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    @FindBy(id = "firstNameInput")
    private WebElement firstNameInput;

    @FindBy(id = "lastNameInput")
    private WebElement lastNameInput;

    @FindBy(id = "emailInput")
    private WebElement emailInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(id = "explicitAgreement")
    private WebElement agreement;

    @FindBy(css = "button.fw-button.fw-button-primary")
    private WebElement createAccountButton;

    @FindBy(id = "company")
    private WebElement companyName;

    @FindBy(id = "companyType")
    private WebElement companyType;

    @FindBy(id = "companySize")
    private WebElement companySize;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//fw-button[@label='Complete']/button")
    private WebElement complete;


    public SignUpPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void enterFirstName(String firstName) {
        populateVisableInputFieldWithText(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        populateVisableInputFieldWithText(lastNameInput, lastName);
    }

    public void enterEmailAddress(String emailAddress) {
        populateVisableInputFieldWithText(emailInput, emailAddress);
    }

    public void enterPassword(String password) {
        populateVisableInputFieldWithText(passwordInput, password);
    }

    public void acceptAgreement() {
        setCheckBoxTo(agreement, true);
    }

    public void clickCreateButton() {
        clickVisibleAndClickableButton(createAccountButton);
    }

    public void enterCompanyName(String company) {
        populateVisableInputFieldWithText(companyName, company);
    }

    public void selectCompanyTypeByIndex(int num) {
        Select selectCompanyType = new Select(companyType);
        selectCompanyType.selectByIndex(num);
    }

    public void selectCompanySizeByIndex(int num) {
        Select selectCompanySize = new Select(companySize);
        selectCompanySize.selectByIndex(num);
    }

    public void enterPhone(String phone) {
        populateVisableInputFieldWithText(phoneInput, phone);
    }

    public void clickCompleteButton() {
        clickVisibleAndClickableButton(complete);
    }

}
