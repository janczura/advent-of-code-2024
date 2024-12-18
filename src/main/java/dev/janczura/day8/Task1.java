package dev.janczura.day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = getInputData();
        List<Character> uniqueAntennas = getUniqueAntennas(lines);
        Map map = new Map(lines.size(), lines);
        System.out.println(map);
        System.out.println("Uniques: " + uniqueAntennas);

        for (char character : uniqueAntennas) {
            map.generateAntiNodes(character);
        }
        System.out.println(map.countAntiNodes('#'));
    }

    private static List<Character> getUniqueAntennas(List<String> lines) {
        List<Character> characters = new ArrayList<>();
        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (char character : chars) {
                if (!characters.contains(character) && character != '.') {
                    characters.add(character);
                }
            }
        }
        return characters;
    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(dev.janczura.day6.Task1.class.getClassLoader().getResource("Day 8/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}