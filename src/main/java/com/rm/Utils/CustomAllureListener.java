package com.rm.Utils;


import org.junit.runner.notification.Failure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.cucumberjvm.AllureRunListener;

public class CustomAllureListener extends AllureRunListener {

    @Override
    public void testFailure(Failure failure) {
        super.testFailure(failure);
        // check is needed to avoid double attaching
        if (!failure.getDescription().isSuite()) {
            saveScreenshot();
            saveBrowserLog();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) BrowserFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser log", type = "text/plain")
    public String saveBrowserLog(){
        return getBrowserLog();
    }

    private String getBrowserLog() {
        LogEntries logEntries = BrowserFactory.getDriver().manage().logs().get(LogType.BROWSER);
        StringBuilder log = new StringBuilder();
        for (LogEntry entry : logEntries) {
            log.append(entry.getMessage() + "\n");
        }
        try {
            String jsCode = "return (window.consoleMessages.filter(function(message) {return !message.dontInclude}).map(function(message){return typeof message == 'object' ? JSON.stringify(message) : message}) || []).join('\n')";
            Object jsLogs = ((JavascriptExecutor) BrowserFactory.getDriver()).executeScript(jsCode);
            log.append(jsLogs);
        } catch (Exception e) {
            System.out.println("Can't get JS console logs for Allure: " + e.getMessage());
        }
        return log.toString();
    }
}