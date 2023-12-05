package day5;

import java.util.ArrayList;
import java.util.List;

public class Seed {
    private long seed;
    private long soil;
    private long fertilizer;
    private long water;
    private long light;
    private long temp;
    private long humidity;
    private long location;

    public Seed(long seed) {
        this.seed = seed;
    }

    public long getSeed() {
        return seed;
    }

    public long getSoil() {
        return soil;
    }

    public void setSoil(long soil) {
        this.soil = soil;
    }

    public long getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(long fertilizer) {
        this.fertilizer = fertilizer;
    }

    public long getWater() {
        return water;
    }

    public void setWater(long water) {
        this.water = water;
    }

    public long getLight() {
        return light;
    }

    public void setLight(long light) {
        this.light = light;
    }

    public long getTemp() {
        return temp;
    }

    public void setTemp(long temp) {
        this.temp = temp;
    }

    public long getHumidity() {
        return humidity;
    }

    public void setHumidity(long humidity) {
        this.humidity = humidity;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Seed [seed=" + seed + ", soil=" + soil + ", fertilizer=" + fertilizer + ", water=" + water + ", light="
                + light + ", temp=" + temp + ", humidity=" + humidity + ", location=" + location + "]";
    }

    public static List<Seed> setSeeds(String data) {
        List<Seed> seeds = new ArrayList<>();
        String[] splitted = data.replace("seeds:", "").split(" ");
        for (int i = 0; i < splitted.length; i++) {
            if (!splitted[i].isEmpty()) {
                Seed seed = new Seed(Long.parseLong(splitted[i]));
                seeds.add(seed);
            }
        }
        return seeds;
    }

}
