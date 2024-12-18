package dev.janczura.day6;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        Map map = new Map(getInputData().size(), getInputData());
        Player player = new Player(map);

        try {
            System.out.println(map);
            player.stepForward(map);
            System.out.println(map);
            player.stepForward(map);
            System.out.println(map);
            player.stepForward(map);
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            // System.out.println(map.countSteps('X'));
        }
    }

    private static List<String> getInputData() throws IOException, URISyntaxException {
        List<String> lines = List.of(input.split("\\n"));
        return lines;
    }

    private static String input = "#.,\n" +
            "^.#\n" +
            ".#.";
}
