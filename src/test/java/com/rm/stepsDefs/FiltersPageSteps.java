package com.rm.stepsDefs;


import com.rm.Pages.BasePage;
import com.rm.Pages.FiltersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class FiltersPageSteps extends BaseSteps {

    private BasePage basePage;
    private FiltersPage filtersPage;

    public FiltersPageSteps(BasePage basePage, FiltersPage filtersPage) {
        this.basePage = basePage;
        this.filtersPage = filtersPage;
    }

    @When("^I set the filters to shortlist the houses$")
    public void i_set_the_filters_to_shortlist_the_houses() throws Throwable {
        filtersPage.selectRadiusdropDown();
        filtersPage.selectMinimumPrice();
        filtersPage.selectMaximumPrice();
        filtersPage.selectMinBedrooms();
        filtersPage.selectMaxBedrooms();
        filtersPage.selectPropertyType();
        filtersPage.clickDaysSinceAdded();
        filtersPage.clickStc();
    }

    @When("^click on 'find properties'$")
    public void click_on_find_properties() throws Throwable {
        filtersPage.clickFindPropertiesButton();
    }

    @When("^I verify \"([^\"]*)\" is visible on filters page$")
    public void i_verify_is_visible_on_filters_page(String title) throws Throwable {
        logString(title);
        Assert.assertTrue(filtersPage.getLocation().contains(title));
        Assert.assertTrue(filtersPage.isSearchPresentOnPage());
    }

}
