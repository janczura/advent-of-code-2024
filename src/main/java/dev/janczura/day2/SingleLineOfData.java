package dev.janczura.day2;

import java.util.ArrayList;
import java.util.List;

public class SingleLineOfData {
    private final List<Integer> integerList;


    public SingleLineOfData(String[] splitted) {
        integerList = new ArrayList<>();
        for (String number : splitted) {
            integerList.add(Integer.parseInt(number));
        }
    }

    public boolean isSafe() {
        boolean isIncreasing = isIncreasing(integerList);
        boolean isDecreasing = isDecreasing(integerList);
        return isIncreasing || isDecreasing;
    }

    public boolean isSafe2() {
        boolean isIncreasing = isIncreaseWithRemovingOne();
        boolean isDecreasing = isDecreasingWithRemovingOne();
        return isIncreasing || isDecreasing;
    }

    private boolean isDecreasingWithRemovingOne() {
        boolean decreasing = isDecreasing(integerList);
        for (int i = 0; i < integerList.size(); i++) {
            List<Integer> clonedList = new ArrayList<>();
            for (int k = 0; k < integerList.size(); k++) {
                if (i != k) {
                    clonedList.add(integerList.get(k));
                }
            }
            decreasing = isDecreasing(clonedList);
            if (decreasing) {
                return decreasing;
            }
        }
        return decreasing;
    }

    private boolean isIncreaseWithRemovingOne() {
        boolean increasing = isIncreasing(integerList);
        for (int i = 0; i < integerList.size(); i++) {
            List<Integer> clonedList = new ArrayList<>();
            for (int k = 0; k < integerList.size(); k++) {
                if (i != k) {
                    clonedList.add(integerList.get(k));
                }
            }
            increasing = isIncreasing(clonedList);
            if (increasing) {
                return increasing;
            }
        }
        return increasing;
    }


    private boolean isDecreasing(List<Integer> integerList) {
        int lastVal = -1;
        for (Integer integer : integerList) {
            if (lastVal == -1) {
                lastVal = integer;
            } else {
                if (lastVal > integer && Math.abs(lastVal - integer) <= 3) {
                    lastVal = integer;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isIncreasing(List<Integer> integerList) {
        int lastVal = -1;
        for (Integer integer : integerList) {
            if (lastVal == -1) {
                lastVal = integer;
            } else {
                if (lastVal < integer && Math.abs(lastVal - integer) <= 3) {
                    lastVal = integer;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
