package Advent_of_code_2018.days.day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DepGraph {
    private List<Node> nodes = new LinkedList<>();
    public DepGraph(String[] depStrs) {
        for (var str: depStrs) {
            String[] parts = str.split(" ");
            String nodeName = parts[7];
            String dependencyName = parts[1];

            if (!nodeExists(dependencyName)) {
                nodes.add(new Node(dependencyName));
            }

            Node node = getOrCreate(nodeName);

            if (!nodes.contains(node)) {
                nodes.add(node);
            }

            node.addDependency(dependencyName);
        }

        nodes.sort(Comparator.comparing(Node::getId));
    }

    private boolean nodeExists(String id) {
        for (var node: nodes) {
            if (node.getId().equals(id)) return true;
        }
        return false;
    }

    private Node getOrCreate(String id) {
        for (var node: nodes) {
            if (node.getId().equals(id)) return node;
        }
        return new Node(id);
    }

    public int size() {
        return nodes.size();
    }

    public String getNext() {
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if (!node.hasDependencies()) {
                String id = node.getId();
                nodes.remove(node);
                perform(id);
                return id;
            }
        }
        throw new RuntimeException("No Available nodes");
    }

    private void perform(String id) {
        for (var node: nodes) {
            node.removeDependency(id);
        }
    }
}
