package com.bdd.testng.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = "features/demo1.feature",
        tags = "@demo2",
        glue = "com.bdd.testng.steps",
        plugin =  {"pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/cucumber1.json"}
)
public class DemoRunner1 {
    private TestNGCucumberRunner testRunner;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is beforeSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass");
        this.testRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is beforeMethod");
    }

    @Test(groups = "cucumber-testng", description = "Example of using TestNGCucumberRunner to invoke Cucumber",
            dataProvider = "scenarios"
        )
    public void test1(PickleEventWrapper wrapper, CucumberFeatureWrapper cwrapper) throws Throwable{
        this.testRunner.runScenario(wrapper.getPickleEvent());
    }

    @DataProvider
    public Object[][] scenarios(){
        return testRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testRunner.finish();
    }
}
