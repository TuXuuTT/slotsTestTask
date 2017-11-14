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

    private By tryMeButtonLocator = By.cssSelector("#tryMe");

    public void verifySlotMachineDisplayed() {
        overallSlotMachinesContainer.verifySlotMachineDisplayed();
    }

    public int getCurrentBet() {
        return overallSlotMachinesContainer.getCurrentBet();
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
}
