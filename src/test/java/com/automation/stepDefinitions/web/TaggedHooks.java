package com.automation.stepDefinitions.web;

import com.automation.BasicTest;
import cucumber.api.java.Before;

public class TaggedHooks extends BasicTest {

    @Before("@NewBrowser")
    public void relaunchBrowser() {
        tierDown();
        startUp();
    }
}
