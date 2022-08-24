package com.demoqa.utils;

public class RandomUtils {

    public static String getRandomGender() {
        String[] arr = {"Female", "Male", "Other"};
        int rand = (int) (Math.random() * 4);
        String randElement = arr[rand];

        return randElement;
    }

    public static String getRandomMonth() {
        String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int rand = (int) (Math.random() * 13);
        String randElement = arr[rand];

        return randElement;
    }

    public static String getRandomHobby() {
        String[] arr = {"Sports", "Reading", "Music"};
        int rand = (int) (Math.random() * 4);
        String randElement = arr[rand];

        return randElement;
    }

}
