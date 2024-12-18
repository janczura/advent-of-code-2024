package dev.janczura.day6;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> lines = getInputData();

        int loops = 0;
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.size(); x++) {
                Map map = new Map(lines.size(), lines);
                LoopException loopException = new LoopException(x, y, map);
                Player player = new Player(map);
                if (player.getPosition().y == y && player.getPosition().x == x) {
                    continue;
                }
                map.getMap()[y][x] = Graphics.OSTRUCTION.getIcon();
                while (true) {
                    try {
                        player.stepForward(map);
                        player = new Player(map, player);
                        map.addToMoveMap(player);
                        if (map.isMapLooped()) {
                            throw loopException;
                        }
                    } catch (LoopException aloopException) {
                        loops++;
                        System.out.println(aloopException);
                        map.setMoveMap(new int[lines.size()][lines.size()]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
                //System.out.println("---");
            }
        }

        System.out.println("loops:" + loops);
    }

    public static List<String> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(Task2.class.getClassLoader().getResource("Day 6/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        return lines;
    }
}