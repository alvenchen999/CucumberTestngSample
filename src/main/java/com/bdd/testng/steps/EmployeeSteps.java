package com.bdd.testng.steps;

import com.bdd.testng.lib.SharedData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.slf4j.LoggerFactory;
import com.bdd.testng.lib.MyLogger;

public class EmployeeSteps{

    Integer salary;
    private Logger logger= SharedData.getLogger(Thread.currentThread().hashCode());
        //Logger.getLogger(EmployeeSteps.class);//SharedData.getLogger(EmployeeSteps.class.getName());

    @When("^Employee get hire for job with salary: (\\d+)$")
    public void setEmpSalary(Integer salary){
        this.salary = salary;
        logger.info("employee salary has been set...");
        logger.info("get:"+Thread.currentThread().hashCode());
    }

    @When("^Employee get salary increased by (\\d+) dollar.$")
    public void salaryUpdate(Integer ammount) throws Exception{
        this.salary += ammount;
        logger.info("employee salary updated");
        logger.info("increased:"+Thread.currentThread().hashCode());
        Thread.sleep(5000);
    }

    @Then("^Employee salary is (\\d+)$")
    public void salaryAssert(Integer salaryExp){
        Assert.assertEquals(this.salary, salaryExp);
        logger.info("salary is correct");
        logger.info("assert:"+Thread.currentThread().hashCode());
    }
}
