package dev.janczura.day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Map {
    private char[][] map;
    private char[][] antiNodesMap;
    private final int size;

    public Map(int size, List<String> lines) {
        this.size = size;
        this.map = new char[size][size];
        this.antiNodesMap = new char[size][size];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            char[] tableOfLine = line.toCharArray();
            for (int j = 0; j < tableOfLine.length; j++) {
                this.map[i][j] = tableOfLine[j];
            }
        }
    }

    public char[][] getMap() {
        return map;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (map == null || map.length == 0) {
            return "Mapa jest pusta.";
        }

        StringBuilder builder = new StringBuilder();
        for (char[] row : map) {
            for (char cell : row) {
                builder.append(cell).append(' '); // Dodajemy znak i spację dla czytelności
            }
            builder.append('\n'); // Nowa linia po każdej kolumnie
        }

        return builder.toString();
    }

    public String getAntiNodeMapAsString() {
        StringBuilder builder = new StringBuilder();
        for (char[] row : antiNodesMap) {
            for (char cell : row) {
                builder.append(cell).append(' ');
            }
            builder.append('\n');
        }

        return builder.toString();
    }

    public int countAntiNodes(char q) {
        int steps = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (antiNodesMap[x][y] == q) {
                    steps++;
                }
            }
        }
        return steps;
    }

    public void generateAntiNodes(char character) {
        List<Point> points = new ArrayList<>();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (getMap()[y][x] == character) {
                    points.add(new Point(x, y));
                }
            }
        }

        Set<Point> antiNodes = AntinodeFinder.findAntinodes2(points, map.length);
        for (Point point : antiNodes) {
            antiNodesMap[point.x][point.y] = '#';
        }
        System.out.println(antiNodes);
    }
}
