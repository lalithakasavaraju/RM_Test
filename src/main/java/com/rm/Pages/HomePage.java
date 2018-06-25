package com.rm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver;

    private By rMLogo = By.id("rm-site-logo");
    private By searchInputField = By.name("searchLocation");
    private By buyButton = By.id("buy");


    public HomePage() {
        this.driver =BasePage.driver;
    }

    public boolean isRmLogoVisible() {
        return isElementPresent(rMLogo);
    }

    public void searchForProperties(String location) {
        clearInputField(searchInputField);
        enterText(searchInputField, location);
        click(buyButton);
        sleep(2);
    }
}
