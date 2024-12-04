package dev.janczura.day4;

import dev.janczura.day3.Task12;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String[][] data = getInputData();
        int result =Xmas.getXmasCounter2(data);
        System.out.println(result);
    }

    public static String[][] getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task12.class.getClassLoader().getResource("Day 4/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        String[][] data = new String[lines.size()][lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                data[i][j] = String.valueOf(line.charAt(j));
            }
        }
        return data;
    }
}
