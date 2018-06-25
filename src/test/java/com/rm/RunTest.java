package com.rm;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "com.rm",
            plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
            tags = {}
    )

    public class RunTest {

    }

