package com.bdd.testng.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "features/emp1.feature",
        glue = {"com.bdd.testng.steps"},
        plugin = { "pretty",
                "html:target/site/cucumber-pretty",
                "rerun:target/rerun_emp.txt",
                "json:target/cucumber_emp.json" })
public class EmpRunner extends AbstractTestNGCucumberTests {
}

