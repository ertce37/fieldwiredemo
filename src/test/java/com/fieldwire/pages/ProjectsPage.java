package com.fieldwire.pages;

import com.fieldwire.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage extends BasePage {

    @FindBy(css = "button.fw-button.fw-button-primary")
    private WebElement newProjectButton;

    @FindBy(css = "input[name='name']")
    private WebElement projectNameInput;

    @FindBy(css = "button.fw-button.fw-button-primary")
    private WebElement createProjectButton;

    @FindBy(xpath = "(//div[@class='projects-heading']/span)[1]")
    private WebElement projectCount;

    @FindBy(xpath = "(//input[@name='input']")
    private WebElement deleteProjectName;

    @FindBy(xpath = "(//fw-button[@kind=\"danger\"]/button")
    private WebElement deleteButton;


    public ProjectsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void clickCreateButton() {
        clickVisibleAndClickableButton(createProjectButton);
    }

    public void clickNewProjectButton() {
        clickVisibleAndClickableButton(newProjectButton);
    }

    public void enterProjectName(String projectName) {
        populateVisableInputFieldWithText(projectNameInput, projectName);
    }

    public int getProjectCount() {
        return getCount(projectCount);
    }

    public void deleteProject(String projectName) {
    }
}
