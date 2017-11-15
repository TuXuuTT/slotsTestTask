package com.automation.stepDefinitions.web;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import pageobjects.SlotsHomePage;

import static com.codeborne.selenide.Selenide.page;

public class SlotsHomePageStepAsserts {
    SlotsHomePage slotsHomePage = page(SlotsHomePage.class);

    @Then("^slot machine is displayed$")
    public void slotMachineAndTryMeButtonAreDisplayed() throws Throwable {
        slotsHomePage.verifySlotMachineDisplayed();
    }

    @Then("^current bet equals (\\d+)$")
    public void currentBetEquals(int arg0) throws Throwable {
        Assert.assertEquals(slotsHomePage.getCurrentBet(), arg0, "Current bet is not like expected");
    }

    @Then("^slots are spun$")
    public void slotsAreSpun() throws Throwable {
        Assert.assertNotEquals(SlotsHomePageStepDefs.beforeChanges.getReelsStates(), SlotsHomePageStepDefs.afterChanges.getReelsStates(), "Slot reels were not spun correctly");
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

    @Then("^background changes$")
    public void backgroundChanges() throws Throwable {
        Assert.assertNotEquals(SlotsHomePageStepDefs.beforeChanges.getBackgroundViewId(), SlotsHomePageStepDefs.afterChanges.getBackgroundViewId(), "Background did not change");
    }

    @Then("^machine changes$")
    public void machineChanges() throws Throwable {
        Assert.assertNotEquals(SlotsHomePageStepDefs.beforeChanges.getMachineViewId(), SlotsHomePageStepDefs.afterChanges.getMachineViewId(), "Machine did not change");
    }

    @Then("^icons change$")
    public void iconsChange() throws Throwable {
        Assert.assertNotEquals(SlotsHomePageStepDefs.beforeChanges.getIconsViewId(), SlotsHomePageStepDefs.afterChanges.getIconsViewId(), "Icons did not change");
    }

    @Then("^win chart shows updated multiplies by current bet amount$")
    public void winChartShowsUpdatedMultipliesByCurrentBetAmount() throws Throwable {
        Assert.assertTrue(slotsHomePage.isWinChartDisplaysMultipliedWinPoints(), "Win chart updated wrongly");
    }

    @Then("^Total spins amount reduced or upgraded if win or loose$")
    public void totalSpinsAmountReducedOrUpgradedIfWinOrLoose() throws Throwable {
        Assert.assertTrue(slotsHomePage.isTotalSpinsAmountChangedAccordinglyToBetIfWinOrLose(SlotsHomePageStepDefs.beforeChanges, SlotsHomePageStepDefs.afterChanges), "Total spins amount calculated wrong!");
    }

    @Then("^last win field updates or remains according to win or loose$")
    public void lastWinFieldUpdatesOrRemainsAccordingToWinOrLoose() throws Throwable {
        if (slotsHomePage.isWin()) {
            Assert.assertTrue(slotsHomePage.isLastWinFieldDisplaysEqualsHighlightedPrizeRow(), "Last win field does not correspond to highlighted row in prize table");
        } else {
            Assert.assertEquals(SlotsHomePageStepDefs.afterChanges.getLastWin(), SlotsHomePageStepDefs.beforeChanges.getLastWin(), "Last win section was reset but should not");
        }
    }
}
