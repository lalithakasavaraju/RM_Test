package com.rm.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiltersPage extends BasePage {

    WebDriver driver;
    private By seachField = By.xpath("//label[@for='radius']");
    private By radius = By.id("radius");
    private By minPrice = By.id("minPrice");
    private By maxPrice = By.id("maxPrice");
    private By minBedrooms = By.id("minBedrooms");
    private By maxBedrooms = By.id("maxBedrooms");
    private By propertyType = By.id("displayPropertyType");
    private By addedDays = By.id("maxDaysSinceAdded");
    private By stcButton = By.xpath("//label[@for='includeSSTC']");
    private By findProperties = By.id("submit");
    private By locationDetails = By.xpath("//h1");

    public FiltersPage() {
        this.driver = BasePage.driver;
    }

    public boolean isSearchPresentOnPage() {
        return isElementPresent(seachField);
    }

    public void selectRadiusdropDown() {
        selectOptionByText(radius, "Within ½ mile");
        sleep(2);
    }

    public void selectMinimumPrice() {
        selectOptionByText(minPrice, "650,000");
        sleep(2);
    }

    public void selectMaximumPrice() {
        selectOptionByText(maxPrice, "700,000");
        sleep(2);
    }

    public void selectMinBedrooms() {
        selectOptionByText(minBedrooms, "3");
        sleep(2);
    }

    public void selectMaxBedrooms() {
        selectOptionByText(maxBedrooms, "4");
        sleep(2);
    }

    public void selectPropertyType() {
        selectOptionByText(propertyType, "Houses");
        sleep(2);
    }

    public void clickDaysSinceAdded() {
        selectOptionByText(addedDays, "Anytime");
    }

    public void clickStc() {
        click(stcButton);
    }

    public void clickFindPropertiesButton() {
        click(findProperties);
        sleep(2);
    }

    public String getLocation() {
        return getText(locationDetails);
    }

}
