package com.rm.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private static final int DEFAULT_WEBDRIVER_WAIT_SECONDS = 25;

    protected static WebDriver driver;

    public void setWebDriver(WebDriver driver){

        this.driver=driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickWithJS(By button) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", driver.findElement(button));
    }

    /**
     * Clicks on the specified button or link.
     *
     * @param button
     *            that needs to be clicked.
     */
    public void click(By button) {
        driver.findElement(button).click();
    }

    /**
     * Enters the text into the input field, but first clicks in the field.
     *
     * @param field
     *            where text should be entered.
     * @param text
     *            that needs to be entered.
     */
    public void enterText(By field, String text) {
        // need to click first to the input field to point exactly to the input
        // field you want to enter text
        driver.findElement(field).click();
        driver.findElement(field).sendKeys(text);
    }

    public void enterTextForSearchFields(By field, String text) {
        driver.findElement(field).sendKeys(text);
    }

    /**
     * Gets the text from the element.
     *
     * @param element
     *            from which text should be taken.
     * @param s
     * @return the text as String.
     */
    public String getText(By element, String s) {
        return driver.findElement(element).getText();
    }

    /**
     * Scrolls to the element in case this element is below the screen's
     * boundaries. Selenium works just with visible elements, and if element is
     * hidden by screen boundaries script might fail.
     *
     * @param element
     *            to which page should be scrolled
     */
    public void scrollToElement(By element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeAsyncScript("arguments[0].scrollIntoView(true); setTimeout(arguments[arguments.length-1])", driver.findElement(element));
        sleep(1);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }
    }

    public boolean isTextVisible(String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
    }

    public boolean isElementPresent(By elementBy) {
        List<WebElement> elements = driver.findElements(elementBy);
        if (elements.isEmpty()) {
            return false;
        }
        return driver.findElement(elementBy).isDisplayed();
    }

    public String getAttribute(By element, String attribute) {
        return driver.findElement(element).getAttribute(attribute);
    }

    public void clearInputFieldWithKeys(By inputField) {
        for (int i = 0; i < 25; i++) {
            driver.findElement(inputField).sendKeys(Keys.BACK_SPACE);
            driver.findElement(inputField).sendKeys(Keys.DELETE);
        }
        sleep(2);
    }

    public boolean doesUrlContain(String url) {
        return waitUntil(ExpectedConditions.urlContains(url));
    }

    public <T> T waitUntil(ExpectedCondition<T> condition) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WEBDRIVER_WAIT_SECONDS);
        return wait.until(condition);
    }

    public void selectOptionByText(By element, String text) {
        Select dropdownName = new Select(driver.findElement(element));
        dropdownName.selectByVisibleText(text);
    }

    public void selectOptionByValue(By element, String value) {
        Select dropdownName = new Select(driver.findElement(element));
        dropdownName.selectByValue(value);
    }

    public void selectOptionByValue(By element, int value) {
        selectOptionByValue(element, Integer.toString(value));
    }

    public void clearInputField(By inputField) {
        driver.findElement(inputField).clear();
    }

    public String getText(By element) {
        return driver.findElement(element).getText();
    }

}
