package pageobjects.blockContainers;

import com.automation.businessEntities.SlotsMachineDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SlotsInnerContainer extends ElementsContainer {

    @FindBy(css = "#slotMachineContainer")
    public SlotsMachineContainer slotsMachineContainer;

    @FindBy(css = "#tryMe")
    private SelenideElement tryMeButton;

    public void verifyCoreElementsAreDisplayed() {
        slotsMachineContainer.getSelf().shouldBe(Condition.visible);
        tryMeButton.shouldBe(Condition.visible);
    }

    public void verifyBet(int arg0) {
        Assert.assertEquals(Integer.parseInt(slotsMachineContainer.currentBetLabel.getText()), arg0);
    }

    public void spin() {
        slotsMachineContainer.spinButton.click();
        slotsMachineContainer.spinButton.shouldNotHave(Condition.cssClass("disabled"));
    }

    public void storeSlotMachineState(SlotsMachineDTO slotsMachineDTO) {
        slotsMachineDTO.setBet(slotsMachineContainer.currentBetLabel.getText());
        slotsMachineDTO.setLastWin(slotsMachineContainer.lastWinLabel.getText());
        slotsMachineDTO.setTotalSpinsLeft(slotsMachineContainer.totalSpinsLeftlabel.getText());

        slotsMachineDTO.setReelsStates(slotsMachineContainer.getReelStates());
    }
}
