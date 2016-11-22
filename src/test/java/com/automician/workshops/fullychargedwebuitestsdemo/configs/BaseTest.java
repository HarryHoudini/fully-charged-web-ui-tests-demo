package com.automician.workshops.fullychargedwebuitestsdemo.configs;

import com.automician.worshops.core.Helpers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.BeforeClass;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    @BeforeClass
    public static void config() {
        Configuration.fastSetValue = true;
        /* makes entering new values to text inputs faster
         * and serves as workaround for some "issues" with entering values to some fields
         */

        Properties properties = Helpers.getProperties();
        Configuration.baseUrl = properties.getProperty("app.url");
        Configuration.timeout = Long.valueOf(properties.getProperty("test.timeout"));
        Configuration.browser = properties.getProperty("test.browser");

    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File testResultScreenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(testResultScreenshot);
    }

}
