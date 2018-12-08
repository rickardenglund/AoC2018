package Advent_of_code_2018.days.day8;

import java.util.List;

public class Node {
    private final List<Node> childs;
    private final List<Integer> metas;
    private int size;

    public Node(List<Node> childs, List<Integer> metas, int size) {
        this.childs = childs;
        this.metas = metas;
        this.size = size;
    }

    public int getSum() {
        return metaSum() + childs.stream()
                .map(Node::getSum)
                .mapToInt(Integer::intValue).sum();
    }

    private Integer metaSum() {
        return metas.stream()
        .mapToInt(Integer::intValue).sum();
    }

    public int getSize() {
        return size;
    }

    public int getValue() {
        if (childs.isEmpty()) return metaSum();
        return metas.stream()
                .filter(index -> index > 0 && index <= childs.size())
                .map(index -> childs.get(index - 1).getValue())
                .mapToInt(Integer::intValue).sum();
    }

    public int countChilds() {
        return 1 + childs.stream()
                .map(child -> child.countChilds())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
