package dev.janczura.day5;

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
        int[][] rules = getRules(lines);
        List<String> tests = getTests(lines);
        List<String> correctTests = getCorrectTests(tests, rules);
        List<String> incorrectTests = getIncorrectTests(tests, correctTests);
        List<String> correctedTests = correctTests(incorrectTests, rules);
        List<Integer> middleNumbers = getMiddleNumbers(correctedTests);
        int sum = middleNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Suma: " + sum);

    }

    private static List<String> correctTests(List<String> incorrectTests, int[][] rules) {
        List<String> correctTests = new ArrayList<>();
        for (String test : incorrectTests) {
            String[] numbers = test.split(",");
            while (!testIsOk(String.join(",", numbers), rules)) {
                for (int i = 0; i < numbers.length; i++) {
                    int firstNumber = Integer.parseInt(numbers[i]);
                    for (int j = i; j < numbers.length; j++) {
                        int secondNumber = Integer.parseInt(numbers[j]);
                        if (rules[secondNumber][firstNumber] > 0) {
                            String temp = numbers[j];
                            numbers[j] = numbers[i];
                            numbers[i] = temp;
                        }
                    }
                }
            }
            correctTests.add(String.join(",", numbers));
        }
        return correctTests;
    }

    private static boolean testIsOk(String test, int[][] rules) {
        boolean testIsOk = true;
        String[] numbers = test.split(",");
        for (int i = 0; i < numbers.length; i++) {
            int firstNumber = Integer.parseInt(numbers[i]);
            for (int j = i; j < numbers.length; j++) {
                int secondNumber = Integer.parseInt(numbers[j]);
                if (rules[secondNumber][firstNumber] > 0) {
                    testIsOk = false;
                }
            }
        }
        return testIsOk;
    }

    private static List<String> getIncorrectTests(List<String> tests, List<String> correctTests) {
        List<String> incorrectTests = new ArrayList<>();
        for (String test : tests) {
            if (!correctTests.contains(test)) {
                incorrectTests.add(test);
            }
        }
        return incorrectTests;
    }

    private static List<Integer> getMiddleNumbers(List<String> correctTests) {
        List<Integer> middleNumbers = new ArrayList<>();
        for (String test : correctTests) {
            String[] numbers = test.split(",");
            int indexOfMiddle = (numbers.length - 1) / 2;
            middleNumbers.add(Integer.parseInt(numbers[indexOfMiddle]));
        }
        return middleNumbers;
    }

    public static List<String> getCorrectTests(List<String> allTests, int[][] rules) {
        List<String> correctTests = new ArrayList<>();
        for (String test : allTests) {
            boolean testOk = true;
            String[] numbers = test.split(",");
            for (int i = 0; i < numbers.length; i++) {
                int firstNumber = Integer.parseInt(numbers[i]);
                for (int j = i; j < numbers.length; j++) {
                    int secondNumber = Integer.parseInt(numbers[j]);
                    if (rules[secondNumber][firstNumber] > 0) {
                        testOk = false;
                    }
                }
            }
            if (testOk) {
                correctTests.add(test);
            }
        }
        return correctTests;
    }

    public static int[][] getRules(List<String> inputData) {
        int[][] rules = new int[100][100];
        for (String line : inputData) {
            if (line.contains("|")) {
                String[] rule = line.split("\\|");
                int num1 = Integer.parseInt(rule[0]);
                int num2 = Integer.parseInt(rule[1]);
                rules[num1][num2]++;
            }
        }
        return rules;
    }

    public static List<String> getTests(List<String> inputData) {
        List<String> tests = new ArrayList<>();
        for (String line : inputData) {
            if (line.contains(",")) {
                tests.add(line);
            }
        }
        return tests;
    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task2.class.getClassLoader().getResource("Day 5/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}
