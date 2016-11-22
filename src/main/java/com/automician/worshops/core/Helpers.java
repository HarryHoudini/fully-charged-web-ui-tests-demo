package com.automician.worshops.core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Helpers {

    public static Properties getProperties() {
        Properties profileProperties = new Properties();

        try {
            profileProperties.load(Helpers.class.getClassLoader().getResourceAsStream("config.properties"));

            Properties systemProperties = System.getProperties();

            System.out.println("\n[Properties reading] ---------------------------------------------------------");

            for (Map.Entry entry : profileProperties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                System.out.println(key + " = " + entry.getValue());
                if (systemProperties.containsKey(key)) {
                    String value = systemProperties.getProperty(key);
                    if (!value.equals("")) {
                        profileProperties.setProperty(key, value);
                        System.out.println(key + " = " + entry.getValue() + " !!! corrected");
                    }
                }
            }
            System.out.println("[Properties reading] ---------------------------------------------------------\n");

        } catch (IOException e) {
            System.out.println("Error : config.properties is not exist");
            e.printStackTrace();
        }
        return profileProperties;
    }

    public static boolean satisfied(SelenideElement element, Condition condition) {
        try {
            element.should(condition);
            return true;
        } catch (ElementNotFound e) {
            return false;
        }
    }
}
