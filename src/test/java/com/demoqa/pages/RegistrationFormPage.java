package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput");


    public RegistrationFormPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {

        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {

        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {

        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {

        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {

        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {

        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String value) {

        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {

        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadFile(String path) {

        $("#uploadPicture").uploadFile(new File(path));

        return this;
    }

    public RegistrationFormPage setAddress(String value) {

        $("#currentAddress").setValue(value);


        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").scrollTo().click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $(byText(value)).click();

        return this;
    }

    public void submit() {
        $("#submit").scrollTo();
        $("#submit").click();


    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResults(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }

    public void closeResultModal() {
        $("#closeLargeModal").scrollTo().click();

    }


}
