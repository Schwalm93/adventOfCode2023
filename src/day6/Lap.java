package day6;

import java.util.ArrayList;
import java.util.List;

import utils.DataHandling;

public class Lap {
    private long time;
    private long recordDistance;
    private long waysToWin;

    public Lap(Long time, Long distance) {
        this.time = time;
        this.recordDistance = distance;
    }

    public static List<Lap> setLaps(List<String> file) {
        List<String> data = DataHandling.findIntegers(file.get(0) + file.get(1));
        List<Lap> laps = new ArrayList<>();
        int size = data.size() / 2;

        for (int i = 0; i < data.size() - size; i++) {
            try {
                Lap lap = new Lap(Long.parseLong(data.get(i)), Long.parseLong(data.get(i + size)));
                laps.add(lap);
            } catch (Exception e) {
                System.out.println("Error - String couldn't be parsed to int");
                throw new NumberFormatException();
            }
        }
        return laps;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getRecordDistance() {
        return recordDistance;
    }

    public void setRecordDistance(Long distance) {
        this.recordDistance = distance;
    }

    public Long getWaysToWin() {
        return waysToWin;
    }

    public void setWaysToWin(Long waysToWin) {
        this.waysToWin = waysToWin;
    }

    @Override
    public String toString() {
        return "Lap [time=" + time + ", distance=" + recordDistance + " Ways " + waysToWin + "]";
    }

}
