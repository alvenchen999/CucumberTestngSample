package com.bdd.testng.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "features/demo1.feature",
        tags = "@demo2",
        glue = {"com.bdd.testng.steps"},
        plugin = { "pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/rerun.txt",
                "json:target/cucumber1.json" })
public class DemoRunner extends AbstractTestNGCucumberTests{
}
