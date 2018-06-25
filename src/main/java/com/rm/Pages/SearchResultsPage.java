package com.rm.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    WebDriver driver;

    private By amountOfSearchResults = By.xpath("//span[@class='searchHeader-resultCount']");
    private By newestList = By.id("sortType");
    private By firstProperty = By.xpath("//div[@data-test='propertyCard-0']");
    private By propertyAddress = By.xpath("//div[@data-test='propertyCard-0']//span[@data-bind='text: displayAddress']");

    public SearchResultsPage() {
        this.driver = BasePage.driver;
    }

    public void selectNewestProperty() {
        selectOptionByText(newestList, "Newest Listed");
        sleep(2);
    }

    public int getDisplayedNumberOfSearchResults() {
        String textPresent = getText(amountOfSearchResults);
        String[] textParts = textPresent.split(" ");
        String numberOfLinksInSearchResults = textParts[0];
        return Integer.parseInt(numberOfLinksInSearchResults);
    }

    public String getAddressFromFirstProperty() {
        return getText(propertyAddress);
    }

    public void clickFirstProperty() {
        click(firstProperty);
    }
}
