package Lesson_3.PhoneBook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook;
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(surname,phoneNumbers);
            if (phoneBook.containsKey(surname))
            phoneNumbers.add(phoneNumber);
    }

    public void get(String keyValue) {
        if (phoneBook.containsKey(keyValue))
            System.out.println("Номера телефонов для фамилии "+keyValue+" "+phoneBook.get(keyValue));

        else
            System.out.println("В справочнике нет такой фамилии.");
    }
}
