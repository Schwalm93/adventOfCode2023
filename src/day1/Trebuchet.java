package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import utils.interfaces.Day;

public class Trebuchet implements Day {

    private static final String PATH = "adventOfCode2023\\src\\day1\\data\\data2.csv";
    private static HashMap<String, String> wordToNumber = new HashMap<>();
    private static List<String> pattern = Arrays.asList("one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine");

    public static void main(String[] args) {

        Trebuchet countDigits = new Trebuchet();

        countDigits.execute();
    }

    public Trebuchet() {
        wordToNumber.put("one", "o1e");
        wordToNumber.put("two", "t2o");
        wordToNumber.put("three", "t3e");
        wordToNumber.put("four", "f4r");
        wordToNumber.put("five", "f5e");
        wordToNumber.put("six", "6");
        wordToNumber.put("seven", "s7n");
        wordToNumber.put("eight", "e8t");
        wordToNumber.put("nine", "n9e");
    }

    @Override
    public void execute() {

        try {
            List<String> file = Files.readAllLines(new File(PATH).toPath());
            int sum = 0;
            int x;
            int y;

            int i = 0;
            for (String string : file) {
                i++;
                string = customReplace(string);
                string = string.replaceAll("[a-zA-Z]", "");

                if (string.length() > 1) {
                    x = Character.getNumericValue(string.charAt(0)) * 10;
                    y = Character.getNumericValue(string.charAt(string.length() - 1));
                } else {
                    x = Character.getNumericValue(string.charAt(0)) * 10;
                    y = Character.getNumericValue(string.charAt(0));
                }
                sum += (x + y);
            }

            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String customReplace(String input) {

        int occurance = input.length();
        String firstPatt = "one";
        String lastPatt = "one";

        for (String p : pattern) {
            if (input.indexOf(p) < occurance && input.indexOf(p) != -1) {
                firstPatt = p;
                occurance = input.indexOf(p);
            }
        }
        occurance = 0;
        for (String p : pattern) {
            if (input.lastIndexOf(p) >= occurance && input.lastIndexOf(p) != -1) {
                lastPatt = p;
                occurance = input.lastIndexOf(p);
            }
        }

        return input.replaceAll(firstPatt, wordToNumber.get(firstPatt).toString())
                .replaceAll(lastPatt, wordToNumber.get(lastPatt).toString());
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }
}
