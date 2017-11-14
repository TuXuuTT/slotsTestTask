package pageobjects.blockContainers;

import com.automation.businessEntities.SlotsMachineDTO;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OverallSlotMachinesContainer extends ElementsContainer {

    @FindBy(css = "#slotMachineContainer")
    private SingleSlotsMachineContainer singleSlotsMachineContainer;

    @FindBy(css = ".prizes_list_slot_machine")
    private ElementsCollection prizesLists;

    private By prizeRowLocator = By.cssSelector("span.tdPayout");

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

    public void setSlotMachineStateSpin(SlotsMachineDTO slotsMachineDTO) {
        slotsMachineDTO.setBet(singleSlotsMachineContainer.currentBetLabel.getText());
        slotsMachineDTO.setLastWin(singleSlotsMachineContainer.lastWinLabel.getText());
        slotsMachineDTO.setTotalSpinsLeft(singleSlotsMachineContainer.totalSpinsLeftlabel.getText());

        slotsMachineDTO.setReelsStates(singleSlotsMachineContainer.getReelStates());
    }

    public void setSlotMachineStateAppearence(SlotsMachineDTO slotsMachineDTO) {
        slotsMachineDTO.setBackgroundViewId(getActiveBackgroundId());
        slotsMachineDTO.setIconsViewId(getActiveIconsViewId());
        slotsMachineDTO.setMachineViewId(getActiveMachineViewId());
    }

    private String getActiveBackgroundId() {
        return $$(backgroundLocator).stream().filter(el -> !el.getAttribute("style").contains("display: none")).map(el -> el.getAttribute("data-id")).findFirst().orElseThrow(() -> new IllegalStateException("None background ID is present in HTML code"));
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

    public void increaseBetBy(int arg0) {
        for (int i = 0; i < arg0; i++) {
            singleSlotsMachineContainer.betUp.click();
        }
    }

    public void decreaseBetBy(int arg0) {
        for (int i = 0; i < arg0; i++) {
            singleSlotsMachineContainer.betDown.click();
        }
    }

    public Boolean isWinChartDisplaysMultipliedWinPoints() {
        boolean result = false;
        ElementsCollection visibleCurrentPrizeRows = prizesLists.filterBy(Condition.visible).shouldHaveSize(1).first().$$(prizeRowLocator);
        List<Integer> defaultBasePrizes = visibleCurrentPrizeRows.stream().map(el -> (int) Double.parseDouble(el.getAttribute("data-basepayout"))).collect(Collectors.toList());
        List<Integer> actualPrizes = visibleCurrentPrizeRows.stream().map(el -> Integer.parseInt(el.getText())).collect(Collectors.toList());

        int bet = Integer.parseInt(singleSlotsMachineContainer.currentBetLabel.getText());
        List<Integer> multipliedDefaultPrizes = defaultBasePrizes.stream().map(l -> l * bet).collect(Collectors.toList());

        if (multipliedDefaultPrizes.equals(actualPrizes)) {
            result = true;
        }
        return result;
    }
}
