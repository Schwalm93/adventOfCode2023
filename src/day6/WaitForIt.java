package day6;

import java.util.List;

import utils.ReadData;
import utils.interfaces.Day;

public class WaitForIt implements Day {

    private static final String PATH_ONE = "adventOfCode2023\\src\\day6\\data\\data.csv";
    List<String> fileOne;

    public WaitForIt() {
        init();
    }

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
    }

    @Override
    public void execute() {
        List<Lap> laps = Lap.setLaps(fileOne);

        for (Lap lap : laps) {
            int lapTime = lap.getTime();
            int recordDistance = lap.getRecordDistance();

            for (int i = 0; i < lapTime; i++) {
                int rest = lapTime - i;
                int distance = i * rest;

                if (distance > recordDistance) {
                    lap.setWaysToWin(lap.getWaysToWin() + 1);
                }
            }
        }
        long waysToWin = 1;
        for (Lap lap : laps) {
            waysToWin *= lap.getWaysToWin();
        }
        System.out.println(waysToWin);
    }

    public static void main(String... args) {
        WaitForIt wait = new WaitForIt();

        wait.execute();
    }

}
