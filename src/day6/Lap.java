package day6;

import java.util.ArrayList;
import java.util.List;

import utils.DataHandling;

public class Lap {
    private int time;
    private int recordDistance;
    private int waysToWin;

    public Lap(int time, int distance) {
        this.time = time;
        this.recordDistance = distance;
    }

    public static List<Lap> setLaps(List<String> file) {
        List<String> data = DataHandling.findIntegers(file.get(0) + file.get(1));
        List<Lap> laps = new ArrayList<>();
        int size = data.size() / 2;

        for (int i = 0; i < data.size() - size; i++) {
            try {
                Lap lap = new Lap(Integer.parseInt(data.get(i)), Integer.parseInt(data.get(i + size)));
                laps.add(lap);
            } catch (Exception e) {
                System.out.println("Error - String couldn't be parsed to int");
                throw new NumberFormatException();
            }
        }
        return laps;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRecordDistance() {
        return recordDistance;
    }

    public void setRecordDistance(int distance) {
        this.recordDistance = distance;
    }

    public int getWaysToWin() {
        return waysToWin;
    }

    public void setWaysToWin(int waysToWin) {
        this.waysToWin = waysToWin;
    }

    @Override
    public String toString() {
        return "Lap [time=" + time + ", distance=" + recordDistance + " Ways " + waysToWin + "]";
    }

}
