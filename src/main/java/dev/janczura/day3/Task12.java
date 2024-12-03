package dev.janczura.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class Task12 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = getInputData();
        int finalValue = 0;
        for (String line : lines) {
            Optional<Mul> firstMul = Mul.findFirstMul(line);
            while (firstMul.isPresent()) {
                finalValue = finalValue + firstMul.get().getValue();
                line = Mul.removeUntilMul(line, firstMul.get().getMul());
                firstMul = Mul.findFirstMul(line);
            }
        }
        System.out.println(finalValue);
    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task12.class.getClassLoader().getResource("Day 3/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}
