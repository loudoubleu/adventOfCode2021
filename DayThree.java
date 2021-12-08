package adventofcode2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayThree {
    public static void main(String[] args) {
        String testString = "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010\n";

        //System.out.println(dayThreePartOne(input));
        //System.out.println(dayThreePartTwo(input));
        System.out.println(getO2GeneratorRating(testString.split("\n")));
        System.out.println(getCO2ScrubberRating(testString.split("\n")));
    }

    // Get power consumption (gamma rate * epsilon rate)
    public static int dayThreePartOne(String input) {
        String[] diagnosticData = input.split("\n");
        int gammaRate = 0;
        int epsilonRate = 0;
        int powerConsumption = 0;

        gammaRate = getGammaRateInDecimal(diagnosticData);
        epsilonRate = getEpsilonRateInDecimal(diagnosticData);

        powerConsumption = gammaRate * epsilonRate;

        return powerConsumption;
    }

    // Get the life support rating (oxygen generator rating * CO2 scrubber rating)
    public static int dayThreePartTwo(String input) {
        int lifeSupportRating = 0;
        int o2GeneratorRating = 0;
        int co2ScrubberRating = 0;
        String[] diagnosticData = input.split("\n");

        // Get O2 Generator Rating
        o2GeneratorRating = getO2GeneratorRating(diagnosticData);

        // Get CO2 Scrubber Rating
        co2ScrubberRating = getCO2ScrubberRating(diagnosticData);

        lifeSupportRating = o2GeneratorRating * co2ScrubberRating;

        return lifeSupportRating;
    }

    // Get the gamma rate:
    // Get the most common bit in each position
    // Create the binary string for these bits
    // Return the decimal representation of that binary
    public static int getGammaRateInDecimal(String[] data) {
        String gammaRate = "";
        int zeroCount = 0;
        int oneCount = 0;
        char bit;
        char[] numbersArray = new char[data[0].length()];

        for(int i = 0; i < data[0].length(); i++) {
            for(int j = 0; j < data.length; j++) {
                numbersArray = data[j].toCharArray();
                bit = numbersArray[i];
                if(bit == '0') {
                    zeroCount++;
                }
                else {
                    oneCount++;
                }
                numbersArray = null;
            }

            gammaRate += (zeroCount > oneCount) ? '0' : '1';
            zeroCount = 0;
            oneCount = 0;
        }

        return Integer.parseInt(gammaRate, 2);
    }

    // Get the epsilon rate:
    // Get the least common bit in each position
    // Create the binary string for these bits
    // Return the decimal representation of that binary
    public static int getEpsilonRateInDecimal(String[] data) {
        String epsilonRate = "";
        int zeroCount = 0;
        int oneCount = 0;
        char bit;
        char[] numbersArray = new char[data[0].length()];

        for(int i = 0; i < data[0].length(); i++) {
            for(int j = 0; j < data.length; j++) {
                numbersArray = data[j].toCharArray();
                bit = numbersArray[i];
                if(bit == '0') {
                    zeroCount++;
                }
                else {
                    oneCount++;
                }
                numbersArray = null;
            }

            epsilonRate += (zeroCount < oneCount) ? '0' : '1';
            zeroCount = 0;
            oneCount = 0;
        }

        return Integer.parseInt(epsilonRate, 2);
    }

    // Get the O2 Generator Rating:
    // Get the most common bit and keep all numbers
    // that has those bits in the current position
    public static int getO2GeneratorRating(String[] data) {
        List<String> zeroesList = new ArrayList<String>();
        List<String> onesList = new ArrayList<String>();
        List<String> currentList = Arrays.asList(data);
        int o2generatorRating = 0;
        int zeroCount = 0;
        int oneCount = 0;
        char bit;
        char[] numbersArray = new char[data[0].length()];

        for(int i = 0; i < currentList.get(0).length(); i++) {
            for(int j = 0; j < currentList.size(); j++) {
                numbersArray = currentList.get(j).toCharArray();
                bit = numbersArray[i];
                if(bit == '0') {
                    zeroCount++;
                    // Store numbers with 0 at this position
                    zeroesList.add(currentList.get(j));
                }
                else {
                    oneCount++;
                    // Store numbers with 1 at this position
                    onesList.add(currentList.get(j));
                }
                numbersArray = null;
            }

            if(zeroCount > oneCount) {
                currentList = new ArrayList<>(zeroesList);
            }
            else {
                currentList = new ArrayList<>(onesList);
            }

            zeroCount = 0;
            oneCount = 0;
            zeroesList.clear();
            onesList.clear();

            if(currentList.size() == 1)
                break;
        }

        o2generatorRating = Integer.parseInt(currentList.get(0), 2);

        return o2generatorRating;
    }

    // Get the CO2 Scrubber Rating:
    // Get the least common bit and keep all numbers
    // that has those bits in the current position
    public static int getCO2ScrubberRating(String[] data) {
        List<String> zeroesList = new ArrayList<String>();
        List<String> onesList = new ArrayList<String>();
        List<String> currentList = Arrays.asList(data);
        int co2ScrubberRating = 0;
        int zeroCount = 0;
        int oneCount = 0;
        char bit;
        char[] numbersArray = new char[data[0].length()];

        for(int i = 0; i < currentList.get(0).length(); i++) {
            for(int j = 0; j < currentList.size(); j++) {
                numbersArray = currentList.get(j).toCharArray();
                bit = numbersArray[i];
                if(bit == '0') {
                    zeroCount++;
                    // Store numbers with 0 at this position
                    zeroesList.add(currentList.get(j));
                }
                else {
                    oneCount++;
                    // Store numbers with 1 at this position
                    onesList.add(currentList.get(j));
                }
                numbersArray = null;
            }

            if(zeroCount > oneCount) {
                currentList = new ArrayList<>(onesList);
            }
            else {
                currentList = new ArrayList<>(zeroesList);
            }

            zeroCount = 0;
            oneCount = 0;
            zeroesList.clear();
            onesList.clear();

            if(currentList.size() == 1)
                break;
        }

        co2ScrubberRating = Integer.parseInt(currentList.get(0), 2);

        return co2ScrubberRating;
    }
}
