package io.github.kurau;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.openqa.selenium.chrome.ChromeOptions.CAPABILITY;
import static org.openqa.selenium.remote.CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION;
import static org.openqa.selenium.remote.CapabilityType.PAGE_LOAD_STRATEGY;

public class WdRule extends ExternalResource {

    private WebDriver webDriver;

    private final DesiredCapabilities capabilities = new DesiredCapabilities();
    private final ChromeOptions chromeOptions = new ChromeOptions();

    protected void before() throws Throwable {
        webDriver = new RemoteWebDriver(new URL("http://selenoid-01-sas.sas.yp-c.yandex.net:4444/wd/hub"), getCapabilities());
    }

    protected void after() {
        if (webDriver!=null) {
            webDriver.quit();
        }
    }

    private DesiredCapabilities getCapabilities() {

        capabilities.setBrowserName("chrome");
        capabilities.setVersion("73");
        capabilities.setPlatform(Platform.ANY);
        capabilities.setCapability(ENSURING_CLEAN_SESSION, true);
        capabilities.setCapability(PAGE_LOAD_STRATEGY, "normal");
        capabilities.setCapability("enableVideo", true);

        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--proxy-server='direct://'");
        chromeOptions.addArguments("--proxy-bypass-list=*");

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-browser-side-navigation");
        chromeOptions.addArguments("--disable-gpu");

        capabilities.setCapability(CAPABILITY, chromeOptions);

        return capabilities;
    }

    public WebDriver driver() {
        return webDriver;
    }
}
