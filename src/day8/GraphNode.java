package day8;

import java.util.HashMap;
import java.util.Map;

public class GraphNode {
    String name;
    Map<String, GraphNode> neighbors;

    public GraphNode(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
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
}
