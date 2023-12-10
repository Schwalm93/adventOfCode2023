package day8.part1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import day8.GraphNode;
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
                graphNodes.putIfAbsent(matcher.group(1), new GraphNode(matcher.group(1)));
                graphNodes.putIfAbsent(matcher.group(2), new GraphNode(matcher.group(2)));
                graphNodes.putIfAbsent(matcher.group(3), new GraphNode(matcher.group(3)));
                graphNodes.get(matcher.group(1)).addNeighbor(graphNodes.get(matcher.group(2)), "L");
                graphNodes.get(matcher.group(1)).addNeighbor(graphNodes.get(matcher.group(3)), "R");
            }
        }

        GraphNode current = graphNodes.get("AAA");
        int i = 0;
        boolean condition = true;
        while (condition) {
            for (String string : direction) {
                current = current.getNeighbor(string);
                i++;
                if (current.getName().equals("ZZZ")) {
                    condition = false;
                    break;
                }
            }
        }
        System.out.println("Steps = " + i);
    }

    public static void main(String... args) {
        HauntedWasteland hauntedWasteland = new HauntedWasteland();

        hauntedWasteland.execute();
    }
}