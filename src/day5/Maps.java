package day5;

import java.util.ArrayList;
import java.util.List;

import utils.DataHandling;

public class Maps {
    List<MapEntry> mapEntries = new ArrayList<>();

    public List<MapEntry> getMapEntries() {
        return mapEntries;
    }

    public void setMapEntries(List<MapEntry> mapEntries) {
        this.mapEntries = mapEntries;
    }

    @Override
    public String toString() {
        return "Maps [mapEntries=" + mapEntries + "]";
    }

    public static Maps setMap(List<String> data) {
        Maps maps = new Maps();
        data.remove(0);
        for (String string : data) {
            List<String> values = DataHandling.findIntegers(string);
            MapEntry mapEntry = setMapEntry(values);
            maps.getMapEntries().add(mapEntry);
        }
        return maps;
    }

    public static MapEntry setMapEntry(List<String> values) {
        try {
            return new MapEntry(
                    Long.parseLong(values.get(0)),
                    Long.parseLong(values.get(1)),
                    Long.parseLong(values.get(2)));
        } catch (Exception e) {
            System.out.println("Error - MapEntry couldn't be created.");
            throw new NumberFormatException();
        }
    }
}
