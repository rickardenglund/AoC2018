package Advent_of_code_2018.days.day7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getAvailableWork() {
        return nodes.stream()
                .filter(node -> !node.hasDependencies())
                .map(Node::getId)
                .sorted()
                .collect(Collectors.toList());
    }


    void perform(Worker worker) {
        String id = worker.getWorkId();
        worker.reset();
        perform(id);
    }

    public void perform(String id) {
        for (var node: nodes) {
            node.removeDependency(id);
        }
        nodes.removeIf(node -> node.getId().equals(id));
    }
}
