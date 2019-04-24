package com.bdd.testng.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class DemoSteps {

    String msg;

    @When("^User print value: (.*)$")
    public void printMessage(String message) {
        this.msg = message;
        System.out.println(this.msg);
    }

    @Then("^message should be：(.*)$")
    public void messageAssertion(String msg1) {
        Assert.assertEquals(this.msg, msg1);
    }
}
