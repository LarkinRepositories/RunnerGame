package Lesson_2.Exceptions;

public class Main {
    public static void main(String[] args) {
        String[][] strings = new String[][]{
                {"10","9","8","7"},{"6","5","4","3"}, {"2","1","0","-1"}, {"-2","-3","-4","-5"}
        };
       try {
           System.out.println(sumIt(strings));
       }
       catch (MyArraySizeException e) {
           e.printStackTrace();
       }
       catch (MyArrayDataException e) {
           e.printStackTrace();
       }
    }

   static int sumIt(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length !=4) throw new MyArraySizeException();
        for (int i = 0; i < array.length; i++) {
           for (int j = 0; j < array.length; j++) {
               try {
                   sum += Integer.parseInt(array[i][j]);
               } catch (NumberFormatException e) {
                   throw new MyArrayDataException("Данные, отличные от типа int находятся в ячейке", i, j);
               }
           }
        }
        return sum;
    }
}
