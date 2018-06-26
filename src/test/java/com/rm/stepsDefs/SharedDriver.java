package com.rm.stepsDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.rm.Utils.BrowserFactory;

public class SharedDriver extends EventFiringWebDriver {

    public SharedDriver() {
        super(BrowserFactory.getDriver());
    }

    @Before

    public void startBrowser() {
        BrowserFactory.openBrowser();
    }

    @After

    public void quitBrowser() {
        BrowserFactory.closeBrowser();
    }
}