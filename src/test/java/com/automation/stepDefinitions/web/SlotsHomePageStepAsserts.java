package com.automation.stepDefinitions.web;

import cucumber.api.java.en.Then;
import org.testng.Assert;

public class SlotsHomePageStepAsserts {

    @Then("^slot machine is displayed$")
    public void slotMachineAndTryMeButtonAreDisplayed() throws Throwable {
        slotsHomePage.verifySlotMachineDisplayed();
    }

    @Then("^current bet by default equals (\\d+)$")
    public void currentBetByDefaultEquals(int arg0) throws Throwable {
        Assert.assertEquals(slotsHomePage.getCurrentBet(), arg0, "Current bet is not like expected");
    }

    @Then("^slots are spinned$")
    public void slotsAreSpinned() throws Throwable {
        Assert.assertNotEquals(beforeSpin.getReelsStates(), afterSpin.getReelsStates());
    }

    @Then("^Try Me button points to Spin button$")
    public void tryMeButtonPointsToSpinButton() throws Throwable {
        slotsHomePage.verifyTryMeButtonPointsToSpinButton();
    }

    @Then("^Try Me button points to Change Background button$")
    public void tryMeButtonPointsToChangeBackgroundButton() throws Throwable {
        slotsHomePage.verifyTryMeButtonPointsToChangeBackgroundButton();
    }

    @Then("^Try me button not displayed$")
    public void tryMeButtonNotDisplayed() throws Throwable {
        slotsHomePage.verifyTryMeButtonIsNotDisplayed();
    }

    @Then("^Total spins amount has changed$")
    public void totalSpinsAmountHasChanged() throws Throwable {
        Assert.assertNotEquals(beforeSpin.getTotalSpinsLeft(), afterSpin.getTotalSpinsLeft());
    }

    @Then("^background changes$")
    public void backgroundChanges() throws Throwable {
        Assert.assertNotEquals(beforeSpin.getBackgroundViewId(), afterSpin.getBackgroundViewId());
    }


    @Then("^machine changes$")
    public void machineChanges() throws Throwable {
        Assert.assertNotEquals(beforeSpin.getMachineViewId(), afterSpin.getMachineViewId());
    }

    @Then("^icons change$")
    public void iconsChange() throws Throwable {
        Assert.assertNotEquals(beforeSpin.getIconsViewId(), afterSpin.getIconsViewId());
    }
}
