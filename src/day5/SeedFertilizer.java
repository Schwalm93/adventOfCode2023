package day5;

import java.util.ArrayList;
import java.util.List;

import utils.ReadData;
import utils.interfaces.Day;

public class SeedFertilizer implements Day {

    private static final String PATH_ONE = "adventOfCode2023\\src\\day5\\data\\data.csv";
    List<String> fileOne;

    public SeedFertilizer() {
        init();
    }

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
    }

    @Override
    public void execute() {
        List<String> builder = new ArrayList<>();
        List<List<String>> mapData = new ArrayList<>();
        for (String string : fileOne) {
            if (string.equals("")) {
                mapData.add(builder);
                builder = new ArrayList<>();
            } else {
                builder.add(string);
            }
        }
        Converter.init(mapData);
        Converter.run();
    }

    public static void main(String... args) {
        SeedFertilizer seedFertilizer = new SeedFertilizer();

        seedFertilizer.execute();
    }

}
