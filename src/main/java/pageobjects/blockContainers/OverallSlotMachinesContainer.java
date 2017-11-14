package pageobjects.blockContainers;

import com.automation.businessEntities.SlotsMachineDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverallSlotMachinesContainer extends ElementsContainer {

    @FindBy(css = "#slotMachineContainer")
    public SingleSlotsMachineContainer singleSlotsMachineContainer;

    private By backgroundLocator = By.cssSelector("div.changeable_background");
    private By slotsSelectorWrapperLocator = By.cssSelector("#slotsSelectorWrapper");

    public void verifySlotMachineDisplayed() {
        singleSlotsMachineContainer.getSelf().shouldBe(Condition.visible);
    }

    public int getCurrentBet() {
        return Integer.parseInt(singleSlotsMachineContainer.currentBetLabel.getText());
    }

    public void spin() {
        singleSlotsMachineContainer.spinButton.click();
        singleSlotsMachineContainer.spinButton.shouldNotHave(Condition.cssClass("disabled"));
    }

    public void storeSlotMachineState(SlotsMachineDTO slotsMachineDTO) {
        slotsMachineDTO.setBet(singleSlotsMachineContainer.currentBetLabel.getText());
        slotsMachineDTO.setLastWin(singleSlotsMachineContainer.lastWinLabel.getText());
        slotsMachineDTO.setTotalSpinsLeft(singleSlotsMachineContainer.totalSpinsLeftlabel.getText());

        slotsMachineDTO.setReelsStates(singleSlotsMachineContainer.getReelStates());

        slotsMachineDTO.setBackgroundViewId(getActiveBackgroundId());
        slotsMachineDTO.setIconsViewId(getActiveIconsViewId());
        slotsMachineDTO.setMachineViewId(getActiveMachineViewId());
    }

    private String getActiveBackgroundId() {
        return String.valueOf($$(backgroundLocator).stream().filter(el -> el.getAttribute("style").contains("display: block")).map(el -> el.getAttribute("data-id")).findFirst());
    }

    private String getActiveIconsViewId() {
        String classAttrValue = $(slotsSelectorWrapperLocator).getAttribute("class");
        Pattern p = Pattern.compile("reelSet\\d");
        Matcher m = p.matcher(classAttrValue);
        m.find();
        return m.group();
    }

    private String getActiveMachineViewId() {
        String classAttrValue = $(slotsSelectorWrapperLocator).getAttribute("class");
        Pattern p = Pattern.compile("slotMachine\\d");
        Matcher m = p.matcher(classAttrValue);
        m.find();
        return m.group();
    }
}
