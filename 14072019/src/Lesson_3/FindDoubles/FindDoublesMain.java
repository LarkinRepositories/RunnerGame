package Lesson_3.FindDoubles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FindDoublesMain {
    public static void main(String[] args) {
        ArrayList<String> list =  new ArrayList<>();
        list.add("Россия");
        list.add("Германия");
        list.add("Россия");
        list.add("Болгария");
        list.add("Великобритания");
        list.add("Германия");
        list.add("Нидерланды");
        list.add("Россия");
        list.add("Нидерланды");
        list.add("Болгария");
        findDoubles(list);
    }
    static void findDoubles(ArrayList<String> list) {
        HashMap<String, Integer> doubles = new HashMap<>();
        for (String doubleValue : list) {
                doubles.put(doubleValue, Collections.frequency(list, doubleValue));
            }
        System.out.println(doubles);
    }
}
