package com.fieldwire.step_definitions;

import com.fieldwire.utilities.ConfigurationReader;
import com.fieldwire.utilities.Driver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {
    private static Logger logger = Logger.getLogger(Hook.class);

    @Before
    public void setup() {
        logger.info("##############################");
        logger.info("Test setup!");
        if (!ConfigurationReader.getProperty("browser").contains("remote")) {
            Driver.get().manage().window().maximize();
            Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.error("Test failed!");
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } else {
            logger.info("Cleanup!");
            logger.info("Test completed!");
        }
        logger.info("##############################");
        Driver.close();
    }
}
