package com.demoqa;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TestDemoQa {
    @BeforeAll
    static void configureBefore(){
        Configuration.baseUrl = "https://demoqa.com/";
    }




    @Test
    void fillPracticeForm(){
        //Заполнение полей

        open("automation-practice-form");
        $("#firstName").setValue("Daniil");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(9);
        $(".react-datepicker__year-select").selectOptionContainingText("1997");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        $("#currentAddress").setValue("Italian street, 19, St. Petersburg,");
        $("#state").scrollTo().click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").scrollTo();
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#submit").click();

        //Проверка тестовой формы

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Daniil Ivanov"));
        $(".modal-body").shouldHave(text("test@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("1111111111"));
        $(".modal-body").shouldHave(text("03 October,1997"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("cat.jpg"));
        $(".modal-body").shouldHave(text("Italian street, 19, St. Petersburg,"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").scrollTo().click();

    }


}
