package com.bdd.test.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "features/demo1.feature",
        glue = {"com.bdd.testng.steps"},
        plugin = { "pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/rerun.txt",
                "json:target/cucumber1.json" })
public class MyRunner extends AbstractTestNGCucumberTests{

}
