package dev.janczura.day8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AntinodeFinder {
    public static Set<Point> findAntinodes(List<Point> points, int mapSize) {
        Set<Point> antinodes = new HashSet<>();
        System.out.println("Map size " + mapSize);
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                for (int i = 0; i < points.size(); i++) {
                    for (int j = 0; j < points.size(); j++) {
                        if (i != j) {
                            Point point1 = points.get(i);
                            Point point2 = points.get(j);
                            Point antiNode = new Point(x, y);
                            if (isValidAntinode(point1, point2, antiNode, mapSize, mapSize)) {
                                if (arePointsOnSameLine(point1, point2, antiNode)) {
                                    if (manhattanDistance(antiNode, point1) * 2 == manhattanDistance(antiNode, point2) || manhattanDistance(antiNode, point2) * 2 == manhattanDistance(antiNode, point1)) {
                                        antinodes.add(antiNode);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return antinodes;
    }

    public static Set<Point> findAntinodes2(List<Point> points, int mapSize) {
        Set<Point> antinodes = new HashSet<>();
        System.out.println("Map size " + mapSize);
        System.out.println(points);
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                for (int i = 0; i < points.size(); i++) {
                    for (int j = 0; j < points.size(); j++) {
                        if (i != j) {
                            Point point1 = points.get(i);
                            Point point2 = points.get(j);
                            Point antiNode = new Point(x, y);
                            if (arePointsOnSameLine(point1, point2, antiNode)) {
                                int distance1 = manhattanDistance(point2, point1);
                                int distance2 = manhattanDistance(antiNode, point2);
                                int distance3 = manhattanDistance(antiNode, point1);

                                if (distance1 != 0 && distance2 % distance1 == 0 || distance1 != 0 && distance3 % distance1 == 0) {
                                    antinodes.add(antiNode);
                                }
                            }
                        }
                    }
                }
            }
        }

        return antinodes;
    }

    public static boolean arePointsOnSameLine(Point point1, Point point2, Point point3) {
        return (point2.y - point1.y) * (point3.x - point2.x) == (point3.y - point2.y) * (point2.x - point1.x);
    }

    private static boolean isValidAntinode(Point p1, Point p2, Point antinode, int mapWidth, int mapHeight) {
        if (antinode.x < 0 || antinode.x >= mapWidth || antinode.y < 0 || antinode.y >= mapHeight) {
            return false;
        }

        int d1 = manhattanDistance(p1, antinode);
        int d2 = manhattanDistance(p2, antinode);

        return d1 == 2 * d2 || d2 == 2 * d1;
    }

    public static int manhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

}