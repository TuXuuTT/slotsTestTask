package pageobjects.blockContainers;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;

public class SlotsMachineContainer extends ElementsContainer {

    @FindBy(css = "#spinButton")
    public SelenideElement spinButton;

    @FindBy(css = "#betSpinUp")
    public SelenideElement betUp;

    @FindBy(css = "#betSpinDown")
    public SelenideElement betDown;

    @FindBy(css = "span#bet")
    public SelenideElement currentBetLabel;

    @FindBy(css = "span#credits")
    public SelenideElement totalSpinsLeftlabel;

    @FindBy(css = "span#lastWin")
    public SelenideElement lastWinLabel;

    private By reelOne = By.cssSelector("#reel1");
    private By reelTwo = By.cssSelector("#reel2");
    private By reelThree = By.cssSelector("#reel3");

    public List<String> getReelStates() {
        return new ArrayList<>(Arrays.asList($(reelOne), $(reelTwo), $(reelThree)).stream().map(el -> el.getAttribute("style").replaceAll("\\D+", "")).collect(Collectors.toList()));
    }
}
