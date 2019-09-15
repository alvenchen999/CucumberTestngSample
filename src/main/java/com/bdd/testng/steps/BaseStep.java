package com.bdd.testng.steps;

import com.bdd.testng.lib.SharedData;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import org.slf4j.LoggerFactory;
import org.apache.log4j.Logger;
import com.bdd.testng.lib.MyLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class BaseStep {

    private Logger logger;
    private MyLogger mlog = new MyLogger();

    @Before
    public void beforeScenario(Scenario scenario){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_SSS");
        String datetime = LocalDateTime.now().format(formatter);
        String scenario_name = scenario.getName().replace(" ", "_");
        String filename = String.format("test_%s_%s.log", scenario_name, datetime);
        String logName = String.format("%s_%s", scenario_name, datetime);
        mlog.setFilename(filename);
        mlog.setLogName(logName);
        logger = mlog.getLogger(logName);

        int thread = Thread.currentThread().hashCode();
        if(!SharedData.tsmap.containsKey(thread)){

            SharedData.putThreadLog(thread, logger);
            SharedData.putThreadScen(thread, logName);
        }
        logger.info("Before scenario...Before");

    }

    @After
    public void afterScenario(Scenario scenario){
        logger.info("After scenario...After");
    }
}
