package dev.janczura.day6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = getInputData();

        Map map = new Map(lines.size(), lines);
        Player player = new Player(map);
        while (true) {
            try {
                player.stepForward(map);
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.out.println("steps:" + map.countSteps('X'));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println(map);

    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task1.class.getClassLoader().getResource("Day 6/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}
