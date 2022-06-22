package lambdatests;

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
import static io.qameta.allure.Allure.step;

public class SelenideLambdaTest {
    private final String REPOSITORY = "IlikaevaE/JacksonProject";
    private final String ISSUE_NAME = "test";

    @Test
    @DisplayName("Проверим дизайн тестов с лямбда выражением")
    @Owner("Elena, Ilikaeva")
    @Severity(SeverityLevel.MINOR)
    @Feature("Проверяем тесты с лямбда выражениями")
    void searchForIssueNameLambda() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Откроем страницу в GitHub", () -> {
            open("https://github.com/");
        });
        step("Кликнем на поле Search", () -> {
            $(".header-search-input").click();
        });
        step("В поле для поиска внесем значение", () -> {
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Найдем значение 'IlikaevaE/JacksonProject' и кликнем на ссылку", () -> {
            $("a[href*='IlikaevaE/JacksonProject']").click();
        });
        step("Кликнем на вкладку Issues", () -> {
            $("[id=issues-tab]").click();
        });
        step("Проверим, что Issue c именем test существует", () -> {
            $("div.js-navigation-container").shouldHave(Condition.text(ISSUE_NAME));
        });
        Allure.attachment("Source", webdriver().driver().source());
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
                ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));

    }

}
