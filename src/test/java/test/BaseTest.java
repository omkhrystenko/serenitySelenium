package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import step.UserSteps;

import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {

@Steps
protected UserSteps user;

    //Для инициализации WebDriver и чтобы не закрывать его в @After
    //Для того чтобы драйвер при запуске каждый раз открывал новое окно браузера, нужно добавить соотв. атр.
    //@Managed(driver = "chrome")
    //private WebDriver driver;

    //Инициализация при запуске на Remote driver
    //public RemoteWebDriver driver;

    // Для запуска в доккер контейнере на Selenoid мы используем нижеследующую реализацию инициализации драйвера
    @Managed(uniqueSession = true) //В каждой новой сессии перезапуск браузера
    private WebDriver driver;


@Before
public void setupDriver() throws MalformedURLException {
    //Для запуска на BrowserStack эта строка не нужна, там уже есть свой соответствующий драйвер и мы к нему подключаемся по ключу
    //Для локального запуска эта строка нужна WebDriverManager.chromedriver().setup();
    WebDriverManager.chromedriver().setup();

    /*DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    capabilities.setVersion("76.0");
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", false);

    RemoteWebDriver driver = new RemoteWebDriver(
            URI.create("http://localhost:4444/wd/hub").toURL(),
            capabilities
    );*/


    }
}
