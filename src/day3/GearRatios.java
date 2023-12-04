package day3;

import java.util.List;

import utils.ReadData;
import utils.interfaces.Day;

public class GearRatios implements Day {
    private static final String PATH_ONE = "src/day3/data/data.csv";
    private static final String PATH_TWO = "src/day3/data/data2.csv";
    List<String> fileOne;
    List<String> fileTwo;

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
        fileTwo = ReadData.readFromCsv(PATH_TWO);
    }

    public static void main(String[] args) {
        GearRatios gearRatios = new GearRatios();

        gearRatios.execute();
    }

    @Override
    public void execute() {
        init();
        AdjacentChecker adjacentChecker = new AdjacentChecker();

        adjacentChecker.startCheck(fileOne, fileTwo);

    }
    
}
