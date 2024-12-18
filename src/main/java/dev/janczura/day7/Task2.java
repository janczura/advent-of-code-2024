package dev.janczura.day7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = getInputData();
        List<Long> results = getResultsFromData(lines);
        List<String> numbers = getNumbersFromData(lines);
        System.out.println(results);
        System.out.println(numbers);
        long result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            boolean addToResult = checkIfCombinationGivesExpectedResult(numbers.get(i), results.get(i));
            if (addToResult) {
                result = result + results.get(i);
            }
        }
        System.out.println(result);
    }

    public static boolean checkIfCombinationGivesExpectedResult(String input, Long expectedResult) {
        String[] parts = input.split(" ");
        int n = parts.length - 1;
        int combinations = (int) Math.pow(3, n);

        for (int i = 0; i < combinations; i++) {
            long result = Long.parseLong(parts[0]);
            StringBuilder concatBuilder = new StringBuilder(parts[0]);
            boolean concatMode = false;
            int currentCombination = i;
            for (int j = 0; j < n; j++) {
                int operator = currentCombination % 3;
                currentCombination /= 3;
                if (operator == 0) {
                    if (concatMode) {
                        result = Long.parseLong(concatBuilder.toString());
                        concatBuilder.setLength(0);
                        concatMode = false;
                    }
                    result *= Long.parseLong(parts[j + 1]);
                } else if (operator == 1) {
                    if (concatMode) {
                        result = Long.parseLong(concatBuilder.toString());
                        concatBuilder.setLength(0);
                        concatMode = false;
                    }
                    result += Long.parseLong(parts[j + 1]);
                } else if (operator == 2) {
                    if (!concatMode) {
                        concatBuilder = new StringBuilder(String.valueOf(result));
                        concatMode = true;
                    }
                    concatBuilder.append(parts[j + 1]);
                }
            }
            if (concatMode) {
                result = Long.parseLong(concatBuilder.toString());
            }
            if (result == expectedResult) {
                return true;
            }
        }

        return false;
    }


    private static List<String> getNumbersFromData(List<String> lines) {
        List<String> results = new ArrayList<>();
        for (String line : lines) {
            String[] splitted = line.split(":");
            String result = splitted[1];
            results.add(result);
        }
        List<String> clearedResults = new ArrayList<>();
        for (String line : results) {
            String clered = line.replaceFirst(" ", "");
            clearedResults.add(clered);
        }
        return clearedResults;
    }

    private static List<Long> getResultsFromData(List<String> lines) {
        List<Long> results = new ArrayList<>();
        for (String line : lines) {
            String[] splitted = line.split(":");
            long result =Long.parseLong(splitted[0]);
            results.add(result);
        }
        return results;
    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task2.class.getClassLoader().getResource("Day 7/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}
