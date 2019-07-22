package Lesson_3.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;


public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook;
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        ArrayList<String> phoneNumberList = this.phoneBook.get(surname);
        if (phoneNumberList == null) {
            phoneNumberList = new ArrayList<>();
            phoneBook.put(surname, phoneNumberList);
        }
        phoneNumberList.add(phoneNumber);
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname))
            System.out.println("Номера телефонов для фамилии "+surname+" "+phoneBook.get(surname));

        else
            System.out.println("В справочнике нет такой фамилии.");
    }
}
