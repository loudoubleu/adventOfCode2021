package adventofcode2021;

import java.util.ArrayList;
import java.util.List;

public class DayOne {
    public static void main(String[] args) {
        String testString = "199\n" + "200\n" + "208\n" + "210\n" + "200\n" + "207\n" + "240\n" + "269\n" + "260\n" + "263\n";

        System.out.println(dayOnePartOne(testString));
        System.out.println(dayOnePartTwo(testString));
    }

    // Get count of numbers that were greater than the previous number
    public static int dayOnePartOne(String depthInput) {
        int counter = 0;
        String[] depthMeasurements = depthInput.split("\n");

        for(int i = 1; i < depthMeasurements.length; i++) {
            if(Integer.parseInt(depthMeasurements[i]) > Integer.parseInt(depthMeasurements[i - 1])) {
                counter++;
            }
        }

        return counter;
    }

    // Get count the number of times the sum of measurements in this sliding window increases from the previous sum.
    public static int dayOnePartTwo(String depthInput) {
        int counter = 0;
        List<Integer> testList = new ArrayList<Integer>();
        String[] depthMeasurements = depthInput.split("\n");

        for(int i = 0; i < depthMeasurements.length - 2; ++i) {
            testList.add(Integer.parseInt(depthMeasurements[i]) + Integer.parseInt(depthMeasurements[i + 1]) + Integer.parseInt(depthMeasurements[i + 2]));
        }

        for(int i = 0; i < testList.size() - 1; i++) {
            if(testList.get(i + 1) > testList.get(i)) {
                counter++;
            }
        }

        return counter;
    }
}
