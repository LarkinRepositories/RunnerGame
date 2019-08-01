package Lesson_5;

public class ThreadsHomeWork {
    static final int SIZE = 10000000;
    static final int h = SIZE / 2;
    static float[] arr = new float[SIZE];

    public static void main(String[] args) {
        firstMethod(arr);

    }

    public static void firstMethod(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis()-a);

    }

}
