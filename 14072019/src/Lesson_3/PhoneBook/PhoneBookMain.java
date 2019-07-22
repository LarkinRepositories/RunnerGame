package Lesson_3.PhoneBook;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Фамилия2","+798919919919");
        phoneBook.add("Фамилия2","+798919919719");
        phoneBook.add("Фамилия3", "+7193181919919");
        phoneBook.get("Фамилия2");
        phoneBook.get("Фамилия3");
    }
}
