package pageobjects;

import com.automation.businessEntities.SlotsMachineDTO;
import org.openqa.selenium.support.FindBy;
import pageobjects.blockContainers.SlotsInnerContainer;
import ru.yandex.qatools.allure.annotations.Step;

public class SlotsHomePage extends BasicPage {

    @FindBy(css = "#SlotsInnerContainer")
    private SlotsInnerContainer slotsInnerContainer;


    @Step
    public void verifyCoreElementsAreDisplayed() {
        slotsInnerContainer.verifyCoreElementsAreDisplayed();
    }

    @Step
    public void verifyCurrentBet(int arg0) {
        slotsInnerContainer.verifyBet(arg0);

    }

    @Step
    public void clickSpin() {
        slotsInnerContainer.spin();
    }

    public void storeSlotMachineState(SlotsMachineDTO slotsMachineDTO) {
        slotsInnerContainer.storeSlotMachineState(slotsMachineDTO);
    }
}
