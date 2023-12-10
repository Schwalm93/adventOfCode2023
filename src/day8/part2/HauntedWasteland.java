package day8.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import day8.GraphNode;
import utils.LCMCalculator;
import utils.ReadData;
import utils.interfaces.Day;

public class HauntedWasteland implements Day {

    private static final String PATH_ONE = "adventOfCode2023\\src\\day8\\data\\data.csv";
    List<String> fileOne;

    public HauntedWasteland() {
        init();
    }

    @Override
    public void init() {
        fileOne = ReadData.readFromCsv(PATH_ONE);
    }

    @Override
    public void execute() {
        String[] direction = fileOne.get(0).split("(?<=\\G.{1})");
        Map<String, GraphNode> graphNodes = new HashMap<>();

        Pattern pattern = Pattern.compile("^(\\w+)\\s*=\\s*\\((\\w+),\\s*(\\w+)\\)$");

        for (String string : fileOne) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                GraphNode graphNode = new GraphNode(matcher.group(1));
                graphNodes.put(matcher.group(1), graphNode);
            }
        }
        for (String string : fileOne) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()) {
                graphNodes.get(matcher.group(1)).addNeighbor(graphNodes.get(matcher.group(2)), "L");
                graphNodes.get(matcher.group(1)).addNeighbor(graphNodes.get(matcher.group(3)), "R");
            }
        }

        List<GraphNode> listOfStartGraphNodes = graphNodes.values().stream().filter(e -> e.isStartWith())
                .collect(Collectors.toList());

        long steps = 0;
        boolean condition = true;
        List<Long> lcmValues = new ArrayList<>();

        while (condition) {
            for (String string : direction) {

                steps++;
                for (int j = 0; j < listOfStartGraphNodes.size(); j++) {
                    listOfStartGraphNodes.set(j, listOfStartGraphNodes.get(j).getNeighbor(string));
                    if (listOfStartGraphNodes.get(j).getName().charAt(2) == 'Z') {
                        lcmValues.add(steps);
                        listOfStartGraphNodes.remove(j);
                        j--;
                    }
                }
                if (listOfStartGraphNodes.size() == 0) {
                    condition = false;
                }

            }
        }
        System.out.println("LCM = " + LCMCalculator.findLCM(lcmValues));
    }

    public static void main(String... args) {
        HauntedWasteland hauntedWasteland = new HauntedWasteland();

        hauntedWasteland.execute();
    }
}
