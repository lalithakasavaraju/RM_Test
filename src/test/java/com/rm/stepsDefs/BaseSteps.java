package com.rm.stepsDefs;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class BaseSteps {

    // this would log parameter as a sub-step in Allure report
    @Step(value = "{0}")
    public void logString(String log) {
        System.out.println(log);
    }

    @Step(value = "{0}")
    public void documentStep(String documentation) {
        // nothing to do here
    }
}
