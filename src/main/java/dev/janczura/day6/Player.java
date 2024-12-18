package dev.janczura.day6;

import java.awt.*;

public class Player {
    private int moves = 0;
    private Point position;

    public Player(int x, int y, Player player) {
        setPosition(new Point(x, y));
    }

    public Player(Map map) {
        for (int y = 0; y < map.getSize(); y++) {
            for (int x = 0; x < map.getSize(); x++) {
                if (map.getMap()[y][x] == Graphics.PLAYER.getIcon()) {
                    setPosition(new Point(x, y));
                }
            }
        }
    }

    public Player(Map map, Player player) {
        for (int y = 0; y < map.getSize(); y++) {
            for (int x = 0; x < map.getSize(); x++) {
                if (map.getMap()[y][x] == Graphics.PLAYER.getIcon()) {
                    setPosition(new Point(x, y));
                }
            }
        }
        this.moves = player.getMoves();
    }

    public void stepForward(Map map) throws Exception {
        if (map.getMap()[getPosition().getLocation().y][getPosition().getLocation().x] != Graphics.PLAYER.getIcon()) {
            throw new Exception("Cos się zepsuło - na miejscu gracza jest coś innego");
        }
        Point nextPositionPoint = new Point(position.getLocation().x + getNextMove().getLocation().x, position.getLocation().y - getNextMove().getLocation().y);
        char nextPosition = map.getMap()[nextPositionPoint.getLocation().y][nextPositionPoint.getLocation().x];
        while (nextPosition == Graphics.BUILDING.getIcon() || nextPosition == Graphics.OSTRUCTION.getIcon()) {
            rotate();
            //System.out.println(moves);
            nextPositionPoint = new Point(position.getLocation().x + getNextMove().getLocation().x, position.getLocation().y - getNextMove().getLocation().y);
            nextPosition = map.getMap()[nextPositionPoint.getLocation().y][nextPositionPoint.getLocation().x];
        }
        map.getMap()[nextPositionPoint.getLocation().y][nextPositionPoint.getLocation().x] = Graphics.PLAYER.getIcon();
        map.getMap()[position.getLocation().y][position.getLocation().x] = Graphics.FOOTPRINT.getIcon();
        position = nextPositionPoint;
    }

    public Point getNextMove() throws Exception {
        if (moves % 4 == 0) {
            return new Point(0, 1);
        }
        if (moves % 4 == 1) {
            return new Point(1, 0);
        }
        if (moves % 4 == 2) {
            return new Point(0, -1);
        }
        if (moves % 4 == 3) {
            return new Point(-1, 0);
        }
        throw new Exception("Coś się zepsuło i nie bylo mnie słychać (...)");
    }

    public void rotate() {
        setMoves(getMoves() + 1);
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}