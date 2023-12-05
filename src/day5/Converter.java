package day5;

import java.util.List;

public class Converter {

    private static List<Seed> seeds;
    private static Maps soilMap;
    private static Maps fertiMap;
    private static Maps waterMap;
    private static Maps lightMap;
    private static Maps tempMap;
    private static Maps humidMap;
    private static Maps locationMap;

    private Converter() {
    };

    public static void init(List<List<String>> mapData) {
        seeds = Seed.setSeeds(mapData.get(0).get(0));
        soilMap = Maps.setMap(mapData.get(1));
        fertiMap = Maps.setMap(mapData.get(2));
        waterMap = Maps.setMap(mapData.get(3));
        lightMap = Maps.setMap(mapData.get(4));
        tempMap = Maps.setMap(mapData.get(5));
        humidMap = Maps.setMap(mapData.get(6));
        locationMap = Maps.setMap(mapData.get(7));
    }

    public static void run() {
        seedToSoil();
    }

    public static void seedToSoil() {
        for (Seed seed : seeds) {
            seed.setSoil(convert(seed.getSeed(), soilMap));
            seed.setFertilizer(convert(seed.getSoil(), fertiMap));
            seed.setWater(convert(seed.getFertilizer(), waterMap));
            seed.setLight(convert(seed.getWater(), lightMap));
            seed.setTemp(convert(seed.getLight(), tempMap));
            seed.setHumidity(convert(seed.getTemp(), humidMap));
            seed.setLocation(convert(seed.getHumidity(), locationMap));
        }
    }

    private static long convert(long valueToConvert, Maps map) {

        for (MapEntry location : map.mapEntries) {

            if (valueToConvert >= location.getSourceRange()
                    && valueToConvert <= (location.getSourceRange() + location.getOffset() - 1)) {
                long diff = valueToConvert - location.getSourceRange();
                return location.getDestRange() + diff;
            }
        }
        return valueToConvert;
    }

}
