package dev.janczura.day6;

public class LoopException extends Exception {
    private int x;
    private int y;
    private Map map;

    public LoopException(int x, int y, Map map) {
        this.x = x;
        this.y = y;
        this.map = map;
    }

    @Override
    public String toString() {
        return "LoopException{" +
                "x=" + x +
                ", y=" + y +
                ", map=\n" + map.toString() +
                '}';
    }
}
