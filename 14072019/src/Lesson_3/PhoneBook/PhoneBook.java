package Lesson_3.PhoneBook;

import java.util.HashMap;
import java.util.HashSet;


public class PhoneBook {
    private HashMap<String, HashSet<String>> phoneBook;
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        HashSet<String> phoneNumberSet = this.phoneBook.get(surname);
        if (phoneNumberSet == null) {
            phoneNumberSet = new HashSet<>();
            phoneBook.put(surname, phoneNumberSet);
        }
        phoneNumberSet.add(phoneNumber);
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname))
            System.out.println("Номера телефонов для фамилии "+surname+" "+phoneBook.get(surname));

        else
            System.out.println("В справочнике нет такой фамилии.");
    }
}
