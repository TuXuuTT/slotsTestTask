package pageobjects;

import com.automation.environment.EnvironmentConfigurator;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class BasicPage {
    protected final Logger LOGGER = LogManager.getLogger(this);
    private final WebDriver wd;

    public BasicPage() {
        wd = WebDriverRunner.getWebDriver();
    }

    public static String getAppURL() {
        return EnvironmentConfigurator.getInstance().getAppUrl();
    }

    protected WebDriver getWebDriverCurrent() {
        return wd;
    }

    protected void openUrl(String url) {
        Selenide.open(url);
        LOGGER.info("Loading page: {}", url);
    }

    public void setWebDriverWindowSize(int width, int height) {
        wd.manage().window().setPosition(new Point(0, 0));
        wd.manage().window().setSize(new Dimension(width, height));
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected Object executeJS(final String script, final Object... params) {
        return ((JavascriptExecutor) wd).executeScript(script, params);
    }

    /**
     * Pause the test to wait for the page to display completely.
     * This is not normally recommended practice, but is useful from time to time.
     */
    public void waitABit(final long delayInMilliseconds) {
        try {
            Thread.sleep(delayInMilliseconds);
        } catch (InterruptedException e) {
            LOGGER.warn("Wait a bit method was interrupted.", e);
        }
    }

    protected Map<String, Object> createMapFromTwoLists(List<String> inputKeysList, List inputValuesLists) {
        Map<String, Object> result = new HashMap<>();
        if (inputKeysList.size() == inputValuesLists.size()) {
            for (int i = 0; i < inputKeysList.size(); i++) {
                result.put(inputKeysList.get(i), inputValuesLists.get(i));
            }
        } else throw new IllegalArgumentException("Cannot map lists with different sizes");
        return result;
    }
}
