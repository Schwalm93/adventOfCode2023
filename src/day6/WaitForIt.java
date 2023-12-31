package day6;

import java.util.List;

import utils.ReadData;
import utils.interfaces.Day;

public class WaitForIt implements Day {

    private static final String PATH_ONE = "adventOfCode2023\\src\\day6\\data\\data.csv";
    private static final String PATH_TWO = "adventOfCode2023\\src\\day6\\data\\data2.csv";
    List<String> fileOne;
    List<String> fileTwo;

    public WaitForIt() {
        init();
    }

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
        fileTwo = ReadData.readFromCsv(PATH_TWO);
    }

    @Override
    public void execute() {
        List<Lap> laps = Lap.setLaps(fileOne);

        for (Lap lap : laps) {
            Long lapTime = lap.getTime();
            Long recordDistance = lap.getRecordDistance();
            for (int i = 0; i < lapTime; i++) {
                Long rest = lapTime - i;
                Long distance = i * rest;
                if (distance > recordDistance) {
                    lap.setWaysToWin(lap.getWaysToWin() + 1);
                }
            }
        }
        long waysToWin = 1;
        for (Lap lap : laps) {
            waysToWin *= lap.getWaysToWin();
        }
        System.out.println("ways to win = " + waysToWin);
    }

    public static void main(String... args) {
        WaitForIt wait = new WaitForIt();

        wait.execute();
    }

}
