package com.demoqa.tests;


import com.demoqa.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;


public class TestDemoQa extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    static Faker faker = new Faker(new Locale("EN"));

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(1, 30) + "",
            month = getRandomMonth(),
            year = faker.number().numberBetween(1990, 2000) + "",
            subject = "Maths",
            hobby = getRandomHobby(),
            filePath = "src/test/resources/cat.jpg",
            fileName = "cat.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";


    @Test
    void fillPracticeForm() {

        //Заполнение полей

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .uploadFile(filePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();


        //Проверка тестовой формы
        registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", gender)
                .checkResults("Mobile", phoneNumber)
                .checkResults("Date of Birth", day + " " + month + "," + year)
                .checkResults("Subjects", subject)
                .checkResults("Hobbies", hobby)
                .checkResults("Picture", fileName)
                .checkResults("Address", address)
                .checkResults("State and City", state + " " + city)
                .closeResultModal();


    }


}
