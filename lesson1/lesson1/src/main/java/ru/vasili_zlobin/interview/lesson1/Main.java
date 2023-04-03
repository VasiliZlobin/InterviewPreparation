package ru.vasili_zlobin.interview.lesson1;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Person.Builder().setFirstName("Василий")
                .setLastName("Петров")
                .setAge(40)
                .build().toString());
    }
}
