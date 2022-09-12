package com.fieldwire.step_definitions;

import com.fieldwire.pages.ProjectsPage;
import com.fieldwire.utilities.BrowserUtils;
import com.fieldwire.utilities.ConfigurationReader;
import com.fieldwire.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProjectStepDefinitions {

    ProjectsPage projectsPage = new ProjectsPage();
    int projectCount;

    @Given("user is on the projects page")
    public void user_is_on_the_projects_page() {
        Driver.get().get(ConfigurationReader.getProperty("projectPageUrl"));
        projectCount = projectsPage.getProjectCount();

    }

    @When("User click on new project button")
    public void user_click_on_new_project_button() {
        projectsPage.clickNewProjectButton();

    }

    @When("User enters a Project name")
    public void user_enters_a_Project_name() {
        projectsPage.enterProjectName(projectsPage.stringGenerator("project"));
    }

    @When("clicks Create button")
    public void clicks_Create_button() {
        projectsPage.clickCreateButton();

    }

    @Then("user verifies a project is created in the projects page")
    public void user_verifies_a_project_is_created_in_the_projects_page() {
        BrowserUtils.wait(2);
        Driver.get().get(ConfigurationReader.getProperty("projectPageUrl"));
        Assert.assertEquals(projectCount + 1, projectsPage.getProjectCount());


    }


}
