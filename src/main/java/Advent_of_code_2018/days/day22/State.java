package Advent_of_code_2018.days.day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class State {
    final Pos3D pos;
    final Tool tool;
    Optional<Integer> distance = Optional.empty();
    int estimatedDistance = 0;

    public State(Pos3D pos, Tool tool) {
        this.pos = pos;
        this.tool = tool;
    }

    public State(int x, int y, int depth, Tool tool) {
        pos = new Pos3D(x, y, depth);
        this.tool = tool;
    }

    public List<State> getNeighbours() {
        List<State> newStates = new ArrayList<>();
        for (Tool newTool : Tool.values()) {
            newStates.addAll(List.of(
                    new State(pos.x + 1, pos.y, pos.depth, newTool),
                    new State(pos.x - 1, pos.y, pos.depth, newTool),
                    new State(pos.x, pos.y + 1, pos.depth, newTool),
                    new State(pos.x, pos.y - 1, pos.depth, newTool),
                    new State(pos.x, pos.y, pos.depth + 1, newTool),
                    new State(pos.x, pos.y, pos.depth - 1, newTool)));
        }
        return newStates.stream()
                .filter(state -> state.pos.x >= 0)
                .filter(state -> state.pos.y >= 0)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return pos.equals(state.pos) &&
                tool == state.tool;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pos, tool);
    }

    @Override
    public String toString() {
        return pos.toString() + ": " + tool + " d: " + distance + " - " + estimatedDistance;
    }
}
