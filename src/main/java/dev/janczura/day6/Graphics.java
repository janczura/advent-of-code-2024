package dev.janczura.day6;

public enum Graphics {
    FIELD('.'),
    BUILDING('#'),
    FOOTPRINT('X'),
    PLAYER('^'),
    OSTRUCTION('O');
    private final char icon;

    Graphics(char icon) {
        this.icon = icon;
    }

    public char getIcon() {
        return icon;
    }
}