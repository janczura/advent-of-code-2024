package dev.janczura.day4;

public class Xmas {


    public static int getXmasCounter(String[][] data, String xmasWord) {
        int counter = 0;
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data.length; x++) {
                //horizontal
                int correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y][x + i].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y][x - i].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
                //vertical
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y + i][x].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y - i][x].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
                //lewo gora
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y + i][x - i].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }

                //prawo gora
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y + i][x + i].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
                //lewo dol
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y - i][x - i].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
                //prawo dol
                correct = 0;
                for (int i = 0; i < xmasWord.length(); i++) {
                    try {
                        if (data[y - i][x + i].equals(String.valueOf(xmasWord.charAt(i)))) {
                            correct = correct + 1;
                        }
                    } catch (Exception ignore) {
                        correct = 0;
                    }
                    if (correct == xmasWord.length()) {
                        counter = counter + 1;
                    }
                }
            }
        }
        return counter;
    }

    public static int getXmasCounter2(String[][] data) {
        int counter = 0;
        for (int y = 0; y < data.length; y++) {
            for (int x = 0; x < data.length; x++) {
                if (data[y][x].equals("A")) {
                    try {
                        if (data[y - 1][x - 1].equals("M") && data[y + 1][x + 1].equals("S")) {
                            if (data[y + 1][x - 1].equals("M") && data[y - 1][x + 1].equals("S")) {
                                counter++;
                            }
                            if (data[y + 1][x - 1].equals("S") && data[y - 1][x + 1].equals("M")) {
                                counter++;
                            }
                        }
                        if (data[y - 1][x - 1].equals("S") && data[y + 1][x + 1].equals("M")) {
                            if (data[y + 1][x - 1].equals("M") && data[y - 1][x + 1].equals("S")) {
                                counter++;
                            }
                            if (data[y + 1][x - 1].equals("S") && data[y - 1][x + 1].equals("M")) {
                                counter++;
                            }
                        }
                    } catch (Exception ignore) {
                    }
                }
            }
        }
        return counter;
    }
}
