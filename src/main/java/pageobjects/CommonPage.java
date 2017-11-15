package pageobjects;

import io.qameta.allure.Step;
import org.testng.Assert;

public class CommonPage extends BasicPage {

    @Step
    public void checkUrlContains(String text) {
        Assert.assertTrue(getWebDriverCurrent().getCurrentUrl().contains(text), String.format("Expected to see %s, but was %s", text, getWebDriverCurrent().getCurrentUrl()));
    }
}
