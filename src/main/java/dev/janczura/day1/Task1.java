package dev.janczura.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();


        for (String line : getInputData()) {
            String[] numbers = line.trim().split("\\s+");
            if (numbers.length == 2) {
                list1.add(Integer.parseInt(numbers[0]));
                list2.add(Integer.parseInt(numbers[1]));
            }
        }

        System.out.println(list1);
        System.out.println(list2);

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(list1);
        System.out.println(list2);

        int finalValue = 0;
        for (int i = 0; i < list1.size(); i++) {
            int diff = Math.abs(list1.get(i) - list2.get(i));
            finalValue = finalValue + diff;
        }
        System.out.println("Result " + finalValue);
    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task1.class.getClassLoader().getResource("Day 1/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}
