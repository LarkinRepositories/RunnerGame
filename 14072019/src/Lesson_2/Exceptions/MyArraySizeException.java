package Lesson_2.Exceptions;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("Массив должен быть размером 4х4");
    }
}
