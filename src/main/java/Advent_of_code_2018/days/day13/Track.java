package Advent_of_code_2018.days.day13;

import Advent_of_code_2018.util.Direction;

import java.util.List;
import java.util.Optional;

import static Advent_of_code_2018.util.Direction.*;

public class Track {
    private final List<Direction> exits;
    final Optional<Train> train;

    public Track(char charAt) {
        switch (charAt) {
            case '|':
                exits = List.of(NORTH, SOUTH);
                break;
            case '-':
                exits = List.of(WEST, EAST);
                break;
            case '/':
                exits = List.of(NORTH, WEST);
                break;
            case '\\':
                exits = List.of(NORTH, EAST);
                break;
            case '+':
                exits = List.of(NORTH, EAST, SOUTH, WEST);
                break;
            case 'v':
                exits = List.of(NORTH, SOUTH);
                train = Optional.of(new Train(SOUTH));
                break;
            case '^':
                exits = List.of(NORTH, SOUTH);
                train = Optional.of(new Train(NORTH));
                break;
            case '>':
                exits = List.of(EAST, WEST);
                train = Optional.of(new Train(EAST));
                break;
            case '<':
                exits = List.of(EAST, WEST);
                train = Optional.of(new Train(WEST));
                break;
        }
        throw new RuntimeException("Invalid character");
    }

    @Override
    public String toString() {
        if (train.isPresent()) return train.toString();
        if (exits.size() == 2 && exits.contains(List.of(NORTH, EAST))) return "|";
        return ".";
    }
}
