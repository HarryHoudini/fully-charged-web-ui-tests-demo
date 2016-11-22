package com.automician.workshops.fullychargedwebuitestsdemo.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.automician.worshops.core.Helpers.satisfied;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.$;

public class ConfirmationDialog {

    private SelenideElement container = $(".noty_type_confirm");

    @Step
    public void confirm() {
        this.container.find(".btn-primary").click();
    }

    @Step
    public void ensureConfirmation() {
        if (satisfied(this.container, visible)) {
            this.container.find(".btn-primary").click();
        }
    }
}
