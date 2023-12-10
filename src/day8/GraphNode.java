package day8;

import java.util.HashMap;
import java.util.Map;

public class GraphNode {
    private String name;
    private Map<String, GraphNode> neighbors;
    private boolean startWith;
    private boolean endsWith;

    public GraphNode(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
        if (name.charAt(2) == 'A') {
            startWith = true;
        } else if (name.charAt(2) == 'Z') {
            endsWith = true;
        }
    }

    public void addNeighbor(GraphNode node, String direction) {
        neighbors.put(direction, node);
    }

    public GraphNode getNeighbor(String direction) {
        return neighbors.get(direction);
    }

    public String getName() {
        return name;
    }

    public boolean isStartWith() {
        return startWith;
    }

    public boolean isEndsWith() {
        return endsWith;
    }

}
