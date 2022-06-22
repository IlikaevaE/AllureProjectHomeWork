package annotatedtests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationTest {
    @Test
    @DisplayName("Проверяем аннотацию @Step")
    @Owner("Elena, Ilikaeva")
    @Severity(SeverityLevel.TRIVIAL)
    @Feature("Проверяем annotated tests")
    @Story("Tест проверяет аннотацию @Step")
    void searchForIssueAnnotation() {
        WebStepsAnnotation webStepsAnnotation = new WebStepsAnnotation();
        SelenideLogger.addListener("allure", new AllureSelenide());
        webStepsAnnotation.openMainPage();
        webStepsAnnotation.clickOnSearch();
        webStepsAnnotation.enterValue();
        webStepsAnnotation.clickOnValue();
        webStepsAnnotation.clickOnTabIssue();
        webStepsAnnotation.checkIssue();
        webStepsAnnotation.takeScreenshot();
    }
}
