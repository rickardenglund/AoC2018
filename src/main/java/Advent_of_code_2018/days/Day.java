package Advent_of_code_2018.days;

public interface Day {
    Object getResultP1(String input);
    Object getResultP2(String input);
    int getDay();
    String getInput1();
    default String getInput2() {
        return getInput1();
    }

}
