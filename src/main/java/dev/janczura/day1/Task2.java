package dev.janczura.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        List<String> lines = Task1.getInputData();
        for (String line : lines) {
            String[] numbers = line.trim().split("\\s+");
            if (numbers.length == 2) {
                list1.add(Integer.parseInt(numbers[0]));
                list2.add(Integer.parseInt(numbers[1]));
            }
        }

        System.out.println(list1);
        System.out.println(list2);


        int finalValue = 0;
        for (Integer integer : list1) {
            int counter = 0;
            for (Integer integer2 : list2) {
                if (Objects.equals(integer, integer2)) {
                    counter++;
                }
            }
            finalValue = finalValue + (integer * counter);
        }
        System.out.println("Result " + finalValue);
    }
}
