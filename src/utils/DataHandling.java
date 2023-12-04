package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataHandling {

    private DataHandling() {

    }

    public static List<String> findIntegers(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<String> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(matcher.group());
        }
        return integerList;
    }

    public static List<String> findSpecialChars(String stringToSearch) {

        Pattern specialCharPattern = Pattern.compile("['!,@#§$%&*():;^_+=/|<>?{}\\[\\]~-]");
        Matcher matcher = specialCharPattern.matcher(stringToSearch);

        List<String> specialCharList = new ArrayList<>();
        while (matcher.find()) {
            specialCharList.add(matcher.group());
        }

        return specialCharList;
    }

    public static String fillUpWithChar(int length, char c) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
