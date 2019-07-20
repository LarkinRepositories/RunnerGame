package Lesson_2.Exceptions;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String message, int i, int j) {
        super(message+" ["+i+"]"+"["+j+"]");

    }
}
