package simpletests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.*;


public class SelenideSimpleTest {
    @Test
    @DisplayName("Simple test покажет attachments и source")
    @Owner("Elena, Ilikaeva")
    @Severity(SeverityLevel.NORMAL)
    @Feature("Проверяем работу simple test")
     void searchForIssueName() {
       SelenideLogger.addListener("allure", new AllureSelenide());
        // Откроем страницу в GitHub
        open("https://github.com/");
        // Кликнем на поле Search
        $(".header-search-input").click();
        // В поле для поиска внесем значение
        $(".header-search-input").sendKeys("IlikaevaE/JacksonProject");
        $(".header-search-input").submit();
        //Найдем значение 'IlikaevaE/JacksonProject' и кликнем на ссылку
        $("a[href*='IlikaevaE/JacksonProject']").click();
        //Кликнем на вкладку Issues
        $("[id=issues-tab]").click();
        //Проверим, что Issue c именем test существует
        $("div.js-navigation-container").shouldHave(Condition.text("test"));
       Allure.attachment("Source", webdriver().driver().source());
       Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
               ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
    }
}
