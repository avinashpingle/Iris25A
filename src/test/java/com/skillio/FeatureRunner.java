package com.skillio;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@Runwith(io.cucumber.testng.Cucumber.class)
@CucumberOptions(features = "src/test/resources",
glue="com.skillio")
public class FeatureRunner extends AbstractTestNGCucumberTests {

}
