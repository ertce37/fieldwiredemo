package com.fieldwire.pages;

import com.fieldwire.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends BasePage {

    @FindBy(xpath = "//*[@label='New task']/button")
    private WebElement newTaskButton;

    @FindBy(xpath = "//span[contains(text(), 'Enter title')][2]")
    private WebElement taskTitleButton;

    @FindBy(css = "textarea.edit-task-name-input")
    private WebElement taskTitleInput;

    @FindBy(css = "span[class='status-label ng-binding']")
    private WebElement priorityDropdownBase;

    @FindBy(partialLinkText = "span[class='status-label ng-binding']")
    private WebElement selectPriorityInput;

    @FindBy(css = "form.task-edit-form button.fw-button.fw-button-primary.only-icon")
    private WebElement confirmTask;

    @FindBy(xpath = "//span[@title='Priority 1']/following-sibling::span")
    private WebElement priority1TaskCount;

    public TasksPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void clickTaskConfirmButton() {
        clickVisibleAndClickableButton(confirmTask);
    }

    public void enterTaskName(String taskTitle) {
        clickVisibleAndClickableButton(taskTitleButton);
        populateVisableInputFieldWithText(taskTitleInput, taskTitle);
    }


    public void selectPriority(String selectedPriority) {
        WebElement targetPriority = Driver.get().findElement(By.partialLinkText(selectedPriority));
        clickVisibleAndClickableButton(targetPriority);
    }

    public void selectTaskPriority(String priority) {
        clickVisibleAndClickableButton(priorityDropdownBase);
        selectPriority(priority);
    }

    public void clickOnNewTaskButton() {
        clickVisibleAndClickableButton(newTaskButton);
    }

    public int getPriorityTaskCount() {
        return getCount(priority1TaskCount);
    }


}
