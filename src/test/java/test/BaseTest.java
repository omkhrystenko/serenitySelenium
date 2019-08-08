package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import step.UserSteps;

public class BaseTest {

@Steps
protected UserSteps user;

//Для инициализации WebDriver и чтобы не закрывать его в @After
    //Для того чтобы драйвер при запуске каждый раз открывал новое окно браузера, нужно добавить соотв. атр.
@Managed(driver = "chrome")
public WebDriver driver;

@Before
public void setupDriver() {
    //Для запуска на BrowserStack эта строка не нужна, там уже есть свой соответствующий драйвер и мы к нему подключаемся по ключу
    //Для локального запуска эта строка нужна
    WebDriverManager.chromedriver().setup();
    }
}
