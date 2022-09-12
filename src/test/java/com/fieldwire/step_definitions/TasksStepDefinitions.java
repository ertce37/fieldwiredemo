package com.fieldwire.step_definitions;

import com.fieldwire.pages.TasksPage;
import com.fieldwire.utilities.BrowserUtils;
import com.fieldwire.utilities.ConfigurationReader;
import com.fieldwire.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TasksStepDefinitions {
    TasksPage tasksPage = new TasksPage();
    String priority = "Priority 1";
    int taskCountInPriority1;

    @Given("user is on the tasks page in a project")
    public void user_is_on_the_tasks_page_in_a_project() {
        Driver.get().get(ConfigurationReader.getProperty("taskPageUrlForTestProject"));
        taskCountInPriority1 = tasksPage.getPriorityTaskCount();
    }

    @When("User click on new task button")
    public void user_click_on_new_task_button() {
        tasksPage.clickOnNewTaskButton();
    }

    @When("enters a task title")
    public void enters_a_task_title() {
        tasksPage.enterTaskName(tasksPage.stringGenerator("task"));
    }

    @When("user clicks ok")
    public void user_clicks_ok() {
        tasksPage.clickTaskConfirmButton();
    }

    @When("user selects a priority")
    public void user_selects_a_priority() {
        tasksPage.selectTaskPriority(priority);
    }

    @Then("user verifies a task is created under the selected priority column in the tasks page")
    public void user_verifies_a_task_is_created_under_the_selected_priority_column_in_the_tasks_page() {
        BrowserUtils.wait(2);
        Driver.get().get(ConfigurationReader.getProperty("taskPageUrlForTestProject"));
        Assert.assertEquals(taskCountInPriority1 + 1, tasksPage.getPriorityTaskCount());
    }

}
