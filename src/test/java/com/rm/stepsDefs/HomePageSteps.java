package com.rm.stepsDefs;


import com.rm.Pages.BasePage;
import com.rm.Pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HomePageSteps extends BaseSteps {

    private BasePage basePage;
    private HomePage homePage;

    public HomePageSteps(BasePage basePage, HomePage homePage) {
        this.basePage = basePage;
        this.homePage = homePage;
    }

    @Given("^I am on rightmove homepage$")
    public void i_am_on_rightmove_homepage() throws Throwable {
        documentStep("Verifies whether the user is on the rightmove homepage");
        Assert.assertTrue(basePage.doesUrlContain("https://www.rightmove.co.uk/"));
        Assert.assertTrue(homePage.isRmLogoVisible());
    }

    @When("^I do a sale search for \"([^\"]*)\"$")
    public void i_do_a_sale_search_for(String name) throws Throwable {
        homePage.searchForProperties(name);
    }

}
