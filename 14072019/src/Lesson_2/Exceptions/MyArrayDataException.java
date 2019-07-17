package Lesson_2.Exceptions;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message, int i) {
        super("В ячейке"+i+"находятся данные не int типа");

    }
}
