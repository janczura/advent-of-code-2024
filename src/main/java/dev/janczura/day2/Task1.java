package dev.janczura.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<SingleLineOfData> singleLineOfDataList = getInputData();
        int result = 0;
        for (SingleLineOfData singleLineOfData : singleLineOfDataList) {
            if (singleLineOfData.isSafe()) {
                result = result + 1;
            }
        }
        System.out.println(result);
    }

    public static List<SingleLineOfData> getInputData() throws IOException, URISyntaxException {
        Path path = Paths.get(dev.janczura.day2.Task1.class.getClassLoader().getResource("Day 2/input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        List<SingleLineOfData> singleLineOfDataList = new ArrayList<>();
        for (String line : lines) {
            String[] splitted = line.split(" ");
            singleLineOfDataList.add(new SingleLineOfData(splitted));
        }
        return singleLineOfDataList;
    }
}


