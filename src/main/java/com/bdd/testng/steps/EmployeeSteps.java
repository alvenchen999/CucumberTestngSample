package com.bdd.testng.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeSteps{

    Integer salary;
    private static Logger logger= LoggerFactory.getLogger(EmployeeSteps.class);

    @When("^Employee get hire for job with salary: (\\d+)$")
    public void setEmpSalary(Integer salary){
        this.salary = salary;
        logger.info("employee salary has been set...");
    }

    @When("^Employee get salary increased by (\\d+) dollar.$")
    public void salaryUpdate(Integer ammount) throws Exception{
        this.salary += ammount;
        logger.info("employee salary updated");
        Thread.sleep(5000);
    }

    @Then("^Employee salary is (\\d+)$")
    public void salaryAssert(Integer salaryExp){
        Assert.assertEquals(this.salary, salaryExp);
        logger.info("salary is correct");
    }
}
