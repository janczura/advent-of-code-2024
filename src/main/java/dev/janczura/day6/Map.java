package dev.janczura.day6;

import java.util.List;

public class Map {
    private char[][] map;
    private int[][] moveMap;
    private final int size;

    public Map(int size, List<String> lines) {
        this.size = size;
        this.map = new char[size][size];
        this.moveMap = new int[size][size];
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

    public int[][] getMoveMap() {
        return moveMap;
    }

    public void setMoveMap(int[][] moveMap) {
        this.moveMap = moveMap;
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

    public int countSteps(char q) {
        int steps = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (map[y][x] == q || map[y][x] == '^') {
                    steps++;
                }
            }
        }
        return steps;
    }

    public void addToMoveMap(Player player) {
        getMoveMap()[player.getPosition().y][player.getPosition().x]++;
    }

    public boolean isMapLooped() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (getMoveMap()[y][x] >= 4) {
                    return true;
                }
            }
        }
        return false;
    }
}
