package com.fieldwire.pages;

import com.fieldwire.utilities.Driver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static Logger logger = Logger.getLogger(BasePage.class);


    public void populateVisableInputFieldWithText(WebElement targetElement, String inputText) {
        new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.visibilityOf(targetElement));
        targetElement.sendKeys(inputText);
    }

    public void clickVisibleAndClickableButton(WebElement targetElement) {
        new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.visibilityOf(targetElement));
        new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.elementToBeClickable(targetElement));
        targetElement.click();
    }

    public void setCheckBoxTo(WebElement targetElement, boolean isChecked) {
        new WebDriverWait(Driver.get(), 5).until(ExpectedConditions.visibilityOf(targetElement));
        boolean currentStatus = targetElement.isSelected();
        if (currentStatus != isChecked) targetElement.click();
    }

    public String stringGenerator(String input) {
        return input + (int) (Math.random() * 100000);
    }

    public int getCount(WebElement element) {
        return Integer.valueOf(element.getText().replaceAll("[^\\d.]", "").trim());
    }
}
