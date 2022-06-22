package annotatedtests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebStepsAnnotation {
    @Step("Откроем страницу в GitHub")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Кликнем на поле Search")
    public void clickOnSearch() {
        $(".header-search-input").click();
    }

    @Step("В поле для поиска внесем значение")
    public void enterValue() {
        $(".header-search-input").sendKeys("IlikaevaE/JacksonProject");
        $(".header-search-input").submit();
    }

    @Step("Найдем значение 'IlikaevaE/JacksonProject' и кликнем на ссылку")
    public void clickOnValue() {
        $("a[href*='IlikaevaE/JacksonProject']").click();
    }

    @Step("Кликнем на вкладку Issues")
    public void clickOnTabIssue() {
        $("[id=issues-tab]").click();
    }

    @Step("Проверим, что Issue c именем test существует")
    public void checkIssue() {
        $("div.js-navigation-container").shouldHave(Condition.text("test"));
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
