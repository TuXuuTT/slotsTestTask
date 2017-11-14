package pageobjects.blockContainers;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class BlackBarContainer extends ElementsContainer {

    @FindBy(css = "a.btnChangeBackground")
    private SelenideElement changeBckgrndBtn;

    @FindBy(css = "a.btnChangeReels")
    private SelenideElement changeIconsBtn;

    @FindBy(css = "a.btnChangeBackground")
    private SelenideElement btnChangeMachine;

    public void changeBackground() {
        changeBckgrndBtn.click();
    }

    public void changeIcons() {
        changeIconsBtn.click();
    }

    public void changeMachine() {
        btnChangeMachine.click();
    }
}
