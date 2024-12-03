package dev.janczura.day3;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mul {
    private final String mul;
    private static boolean doo = true;

    public Mul(String mul) {
        this.mul = mul;
    }

    public String getMul() {
        return mul;
    }

    public int getValue() {
        String pattern = "mul\\((-?\\d+),(-?\\d+)\\)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(this.getMul());

        if (m.matches()) {
            int num1 = Integer.parseInt(m.group(1));
            int num2 = Integer.parseInt(m.group(2));
            if (doo) {
                return num1 * num2;
            } else {
                return 0;
            }
        } else if (getMul().equals("do")) {
            doo = true;
        } else if (getMul().equals("don't")) {
            doo = false;
        } else {
            throw new IllegalArgumentException("Coś się zepsuło i nie było mnie słychać: " + this.getMul());
        }
        return 0;
    }

    public static Optional<Mul> findFirstMul(String text) {
        String regex = "mul\\(\\d+,\\d+\\)|don't|do";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return Optional.of(new Mul(matcher.group()));
        }
        return Optional.empty();
    }

    public static String removeUntilMul(String text, String mul) {
        String escapedMul = Pattern.quote(mul);
        String pattern = ".*?" + escapedMul;
        return text.replaceFirst(pattern, "");
    }

}
