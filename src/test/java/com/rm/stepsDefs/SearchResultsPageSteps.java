package com.rm.stepsDefs;


import com.rm.Pages.BasePage;
import com.rm.Pages.SearchResultsPage;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class SearchResultsPageSteps extends BaseSteps {

    private BasePage basePage;
    private SearchResultsPage searchResultsPage;

    public SearchResultsPageSteps(BasePage basePage, SearchResultsPage searchResultsPage) {
        this.basePage = basePage;
        this.searchResultsPage = searchResultsPage;
    }

    @Then("^I verify that I see results for search$")
    public void iVerifyThatISeeResultsForSearch() throws Throwable {
        int numOfLinksInSearchResultsHeader = searchResultsPage.getDisplayedNumberOfSearchResults();
        logString("NUmber of links present: "+ numOfLinksInSearchResultsHeader);
        Assert.assertTrue(numOfLinksInSearchResultsHeader != 0);
    }

    @Then("^set the search results to 'newest listed'$")
    public void set_the_search_results_to_newest_listed() throws Throwable {
        searchResultsPage.selectNewestProperty();
    }
}
