package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags=(""),snippets=SnippetType.CAMELCASE,publish=true,dryRun = false,
   plugin ={ "pretty","json:target\\Output.json" },features="src\\test\\resources",glue="com.stepdefinition")

public class TestRunnerClass extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectLocator()+getPropertyFileValue("jsonPath"));
	}

}
