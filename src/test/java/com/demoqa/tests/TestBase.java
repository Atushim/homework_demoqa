package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configureBefore() {
        Configuration.baseUrl = "https://demoqa.com";
    }
}
