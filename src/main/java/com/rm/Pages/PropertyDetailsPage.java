package com.rm.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PropertyDetailsPage extends BasePage {

    WebDriver driver;

    private By propertyAddress = By.xpath("//address[@class='pad-0 fs-16 grid-25']");
    private By description = By.linkText("Description");

    public PropertyDetailsPage() {
        this.driver = BasePage.driver;
    }

    public boolean isDescriptionTabDisplayed() {
        return isElementPresent(description);
    }

    public String getPropertyAddress() {
        return getText(propertyAddress);
    }

}