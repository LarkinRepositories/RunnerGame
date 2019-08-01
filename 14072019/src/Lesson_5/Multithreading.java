package Lesson_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Multithreading {
    static final int SIZE = 10000000;
    //static final int SIZE = 30;

    public static void main(String[] args) {
        Multithreading o = new Multithreading();
        o.calculateWithoutThreads();
        o.calculateWithThreads(5);
    }

    private static float[] calculateValues(float[] arr) {
        Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }

    private void calculateWithoutThreads() {
        float[] arr = new float[SIZE];
        long a = System.currentTimeMillis();
        arr = calculateValues(arr);
        System.out.println(System.currentTimeMillis()-a);
    }

    private void calculateWithThreads(int threadCount) {
        float[] arr = new float[SIZE];
        float from = 0;
        final float step = SIZE / (float) threadCount;
        List<float[]> subArrays = new ArrayList<>(threadCount);
        List<Thread> threads = new ArrayList<>(threadCount);
        long a = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            float to = from + step;
            if ( to > SIZE) to = SIZE;
            subArrays.add(Arrays.copyOfRange(arr, (int) from, (int) to));
            from +=step;
            int finalI = i;
            threads.add(new Thread(() -> subArrays.set(finalI, calculateValues(subArrays.get(finalI)))));
        }
        for (Thread t : threads) {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int offset = 0;
        for (float[] ar : subArrays) {
            System.arraycopy(ar, 0, arr, offset , ar.length);
            offset += ar.length;
        }
        System.out.println(System.currentTimeMillis() - a);
    }
}
