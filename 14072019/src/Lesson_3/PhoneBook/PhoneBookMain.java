package Lesson_3.PhoneBook;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Фамилия3","+798919919919");
        phoneBook.add("Фамилия3","+798919919719");
        phoneBook.get("Фамилия3");
    }
}
