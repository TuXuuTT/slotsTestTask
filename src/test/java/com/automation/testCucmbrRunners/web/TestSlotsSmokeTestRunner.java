package com.automation.testCucmbrRunners.web;


import com.automation.BasicTest;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@CucumberOptions(features = "src/test/resources/features/SlotsSmokeTest.feature",
        glue = "com.automation.stepDefinitions.web",
        plugin = {"html:build/reports/cucumber-report", "pretty"},
        strict = true,
        snippets = SnippetType.CAMELCASE,
        tags = {/*"~@LOAD"}*/}) //TODO Tags are for dev purposes only. For CI use tags from command line)
public class TestSlotsSmokeTestRunner extends BasicTest {
}
