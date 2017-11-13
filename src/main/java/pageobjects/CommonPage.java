package pageobjects;

import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class CommonPage extends BasicPage {


    @Step
    public void checkUrlContains(String text) {
        Assert.assertTrue(getWebDriverCurrent().getCurrentUrl().contains(text));
    }
}
