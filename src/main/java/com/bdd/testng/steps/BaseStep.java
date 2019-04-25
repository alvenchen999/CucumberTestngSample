package com.bdd.testng.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class BaseStep {

    static Logger logger = LoggerFactory.getLogger(BaseStep.class);


    @Before
    public void beforeScenario(Scenario scenario){
        logger.info("Before scenario...Before");
    }

    @After
    public void afterScenario(Scenario scenario){
        logger.info("After scenario...After");
    }
}
