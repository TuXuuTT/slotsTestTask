package pageobjects;

import com.automation.businessEntities.SlotsMachineDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import pageobjects.blockContainers.BlackBarContainer;
import pageobjects.blockContainers.OverallSlotMachinesContainer;

public class SlotsHomePage extends BasicPage {

    @FindBy(css = "#slot_machines_container")
    private OverallSlotMachinesContainer overallSlotMachinesContainer;

    @FindBy(css = "div.black_bar")
    private BlackBarContainer blackBarContainer;

    @FindBy(css = "div#SlotsOuterContainer.won")
    private SelenideElement redWinBackgroundLabel;

    @FindBy(css = "form[action='https://www.paypal.com/cgi-bin/webscr']")
    private SelenideElement buyPayPalBtn;

    @FindBy(css = "form[action='https://bitpay.com/checkout']")
    private SelenideElement buyBitcoinBtn;

    private By tryMeButtonLocator = By.cssSelector("#tryMe");

    public void verifySlotMachineDisplayed() {
        overallSlotMachinesContainer.verifySlotMachineDisplayed();
    }

    public int getCurrentBet() {
        return overallSlotMachinesContainer.getCurrentlyDisplayedBet();
    }

    public void clickSpin() {
        overallSlotMachinesContainer.spin();
    }

    public void storeSlotMachineStateSpin(SlotsMachineDTO slotsMachineDTO) {
        overallSlotMachinesContainer.setSlotMachineStateSpin(slotsMachineDTO);
    }

    public void storeSlotMachineStateAppearence(SlotsMachineDTO slotsMachineDTO) {
        overallSlotMachinesContainer.setSlotMachineStateAppearence(slotsMachineDTO);
    }

    public void verifyTryMeButtonPointsToSpinButton() {
        overallSlotMachinesContainer.getSelf().$(tryMeButtonLocator).shouldBe(Condition.visible);
        blackBarContainer.getSelf().$$(tryMeButtonLocator).shouldHaveSize(0);
    }

    public void verifyTryMeButtonPointsToChangeBackgroundButton() {
        blackBarContainer.getSelf().$(tryMeButtonLocator).shouldBe(Condition.visible);
        overallSlotMachinesContainer.getSelf().$$(tryMeButtonLocator).shouldHaveSize(0);

    }

    public void verifyTryMeButtonIsNotDisplayed() {
        blackBarContainer.getSelf().$(tryMeButtonLocator).shouldNotBe(Condition.visible);
        overallSlotMachinesContainer.getSelf().$$(tryMeButtonLocator).shouldHaveSize(0);
    }

    public void clickChangeBackground() {
        blackBarContainer.changeBackground();
        waitABit(500);
    }

    public void clickChangeIcons() {
        blackBarContainer.changeIcons();
        waitABit(500);
    }

    public void clickChangeMachine() {
        blackBarContainer.changeMachine();
        waitABit(500);
    }

    public void increaseBetByArrowNthTimes(int arg0) {
        overallSlotMachinesContainer.increaseBetBy(arg0);
    }

    public void decreaseBetByArrowNthTimes(int arg0) {
        overallSlotMachinesContainer.decreaseBetBy(arg0);
    }

    public boolean isWinChartDisplaysMultipliedWinPoints() {
        return overallSlotMachinesContainer.isWinChartDisplaysMultipliedWinPoints();
    }


    public boolean isWin() {
        return redWinBackgroundLabel.is(Condition.visible);
    }

    public boolean isLastWinFieldDisplaysEqualsHighlightedPrizeRow() {
        return overallSlotMachinesContainer.getCurrentlyDisplayedWin() == overallSlotMachinesContainer.getHighlightedWonPrizeAmount();
    }

    public boolean isTotalSpinsAmountChangedAccordinglyToBetIfWinOrLose(SlotsMachineDTO beforeChanges, SlotsMachineDTO afterChanges) {
        boolean result;
        int before = beforeChanges.getTotalSpinsLeft();
        int after = afterChanges.getTotalSpinsLeft();
        if (isWin()) {
            int expectedCalculatedAfter = (before - getCurrentBet()) + overallSlotMachinesContainer.getHighlightedWonPrizeAmount();
            result = after == expectedCalculatedAfter;
        } else {
            int expectedCalculatedAfter = (before - getCurrentBet());
            result = after == expectedCalculatedAfter;
        }

        return result;
    }

    public void buyWithPayPal() {
        buyPayPalBtn.click();
        waitForPageToLoad(10000);
    }

    public void buyWithBitCoin() {
        buyBitcoinBtn.click();
        waitForPageToLoad(10000);
    }
}
