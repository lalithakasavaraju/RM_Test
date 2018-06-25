package com.rm.stepsDefs;

import com.rm.Pages.PropertyDetailsPage;
import com.rm.Pages.SearchResultsPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class PropertyDetailsPageSteps extends BaseSteps {

    private PropertyDetailsPage propertyDetailsPage;
    private SearchResultsPage searchResultsPage;

    public PropertyDetailsPageSteps(PropertyDetailsPage propertyDetailsPage, SearchResultsPage searchResultsPage) {
        this.propertyDetailsPage = propertyDetailsPage;
        this.searchResultsPage = searchResultsPage;
    }

    @Then("^I select the first proeprty and verify that I am seeing the details of my selected property$")
    public void iSelectTheFirstProeprtyAndVerifyThatIAmSeeingTheDetailsOfMySelectedProperty() throws Throwable {
        String addressOnListPage = searchResultsPage.getAddressFromFirstProperty();
        searchResultsPage.clickFirstProperty();
        Assert.assertEquals("Address is not same", addressOnListPage, propertyDetailsPage.getPropertyAddress());
        Assert.assertTrue(propertyDetailsPage.isDescriptionTabDisplayed());
    }
}
