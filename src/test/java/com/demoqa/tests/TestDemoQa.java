package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestDemoQa {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configureBefore() {
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void fillPracticeForm() {
        //Заполнение полей

        registrationFormPage.openPage()
                .setFirstName("Daniil")
                .setLastName("Ivanov")
                .setEmail("test@gmail.com")
                .setGender("Male")
                .setNumber("1111111111")
                .setBirthDate("03", "October", "1997")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadFile("src/test/resources/cat.jpg")
                .setAddress("Italian street, 19, St. Petersburg,")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();


        //Проверка тестовой формы
        registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", "Daniil Ivanov")
                .checkResults("Student Email", "test@gmail.com")
                .checkResults("Gender", "Male")
                .checkResults("Gender", "Male")
                .checkResults("Mobile", "1111111111")
                .checkResults("Date of Birth", "03 October,1997")
                .checkResults("Subjects", "Maths")
                .checkResults("Hobbies", "Sports")
                .checkResults("Picture", "cat.jpg")
                .checkResults("Address", "Italian street, 19, St. Petersburg,")
                .checkResults("State and City", "Haryana Karnal")
                .closeResultModal();


    }


}
