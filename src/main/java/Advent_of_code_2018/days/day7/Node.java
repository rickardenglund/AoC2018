package Advent_of_code_2018.days.day7;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Node {

    private String id;
    private Set<String> dependencies = new HashSet<>();

    public Node(String id) {
        this.id = id;
    }

    public void addDependency(String part) {
        dependencies.add(part);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(id, node.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean hasDependencies() {
        return !dependencies.isEmpty();
    }

    public void removeDependency(String id) {
        dependencies.remove(id);
    }

    @Override
    public String toString() {
        return id + ": " + dependencies;
    }
}
