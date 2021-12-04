package adventofcode2021;

public class DayTwo {
    public static void main(String[] args) {
        String testString = "forward 5\n" + "down 5\n" + "forward 8\n" + "up 3\n" + "down 8\n" + "forward 2";

        System.out.println(dayTwoPartOne(testString));
        System.out.println(dayTwoPartTwo(testString));
    }

    // Get the product of your final horizontal position and depth
    public static int dayTwoPartOne(String input) {
        String[] positionData = input.split("\n");
        int positionTotal = 0;
        int depthTotal = 0;
        String[] tempValues = new String[2];
        String tempDirection = "";

        for(int i = 0; i < positionData.length; i++) {
            tempValues = positionData[i].split(" ");
            tempDirection = tempValues[0];
            switch (tempDirection) {
                case "forward":
                    positionTotal += Integer.parseInt(tempValues[1]);
                    break;
                case "down":
                    depthTotal += Integer.parseInt(tempValues[1]);
                    break;
                case "up":
                    depthTotal -= Integer.parseInt(tempValues[1]);
                    break;
            }
        }

        return positionTotal * depthTotal;
    }

    // Get the product of your final horizontal position and depth
    // with aim taken into consideration
    public static int dayTwoPartTwo(String input) {
        String[] positionData = input.split("\n");
        int positionTotal = 0;
        int depthTotal = 0;
        int aimTotal = 0;
        String[] tempValues = new String[2];
        String tempDirection = "";

        for(int i = 0; i < positionData.length; i++) {
            tempValues = positionData[i].split(" ");
            tempDirection = tempValues[0];
            switch (tempDirection) {
                case "forward":
                    positionTotal += Integer.parseInt(tempValues[1]);
                    depthTotal += (aimTotal * Integer.parseInt(tempValues[1]));
                    break;
                case "down":
                    aimTotal += Integer.parseInt(tempValues[1]);
                    //depthTotal += Integer.parseInt(tempValues[1]);
                    break;
                case "up":
                    aimTotal -= Integer.parseInt(tempValues[1]);
                    //depthTotal -= Integer.parseInt(tempValues[1]);
                    break;
            }
        }

        return positionTotal * depthTotal;
    }
}
