package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Direction;
import Advent_of_code_2018.util.Pos;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static Advent_of_code_2018.util.Direction.*;

public class Track {
    private final List<Direction> exits;
    Optional<Train> train = Optional.empty();

    public Track(char charAt) {
        switch (charAt) {
            case ' ':
                exits = Collections.emptyList();
                return;
            case '|':
                exits = List.of(NORTH, SOUTH);
                return;
            case '-':
                exits = List.of(WEST, EAST);
                return;
            case '+':
                exits = List.of(NORTH, EAST, SOUTH, WEST);
                return;
            case 'v':
                exits = List.of(NORTH, SOUTH);
                train = Optional.of(new Train(SOUTH));
                return;
            case '^':
                exits = List.of(NORTH, SOUTH);
                train = Optional.of(new Train(NORTH));
                return;
            case '>':
                exits = List.of(EAST, WEST);
                train = Optional.of(new Train(EAST));
                return;
            case '<':
                exits = List.of(EAST, WEST);
                train = Optional.of(new Train(WEST));
                return;
        }
        throw new RuntimeException("Invalid character: " + charAt);
    }

    public Track(char charAt, boolean west) {
        switch (charAt) {
            case '/':
                exits = west ? List.of(NORTH, WEST) : List.of(EAST, SOUTH);
                return;
            case '\\':
                exits = west ? List.of(WEST, SOUTH) : List.of(NORTH, EAST);
                return;
        }
        throw new RuntimeException("Invalid character: " + charAt);
    }

    @Override
    public String toString() {
        if (train.isPresent()) return train.get().toString();
        if (exits.size() == 2) {
            if (exits.containsAll(List.of(NORTH, SOUTH))) return "|";
            if (exits.containsAll(List.of(WEST, EAST))) return "-";
            if (exits.containsAll(List.of(NORTH, EAST))) return "\\";
            if (exits.containsAll(List.of(WEST, SOUTH))) return "\\";
            if (exits.containsAll(List.of(NORTH, WEST))) return "/";
            if (exits.containsAll(List.of(EAST, SOUTH))) return "/";
        } else if (exits.size() == 4) {
            return "+";
        }
        return ".";
    }

    public Train takeTrain() {
        Train train = this.train.get();
        this.train = Optional.empty();
        return train;
    }

    public Optional<Pos> getNewTrainPos(Pos currentPos, int currentTick) {
        if (train.isPresent() && train.get().getLastTick() == currentTick) {
            currentPos.step(train.get().getDirection());
            return Optional.of(currentPos);
        } else {
            return Optional.empty();
        }
    }

    public void setTrain(Train train, int tick) {
        if (this.train.isPresent()) throw new RuntimeException("Train Crash");

        // crossing
        if (exits.size() == 4) {
            List<Direction> possibleExits = exits.stream()
                    .filter(it -> !it.equals(opposite(train.getDirection())))
                    .collect(Collectors.toList());
            train.setDirection(possibleExits.get(0)); // TODO fix crossing
        }

        train.setTick(tick);
        Direction newDirection = getExit(train);
        train.setDirection(newDirection);
        this.train = Optional.of(train);
    }

    private Direction getExit(Train train) {
        Direction enteringAt = Direction.opposite(train.getDirection());
        return exits.stream()
                .filter(it -> !it.equals(enteringAt))
                .findFirst().get();
    }
}
