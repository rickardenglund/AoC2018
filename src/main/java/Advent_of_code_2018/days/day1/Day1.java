package Advent_of_code_2018.days.day1;

import Advent_of_code_2018.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Day1 implements Day {


    @Override
    public Object getResultP1(String input) {
        return Arrays.stream(input.split("\n"))
                .map(Integer::parseInt)
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public Object getResultP2(String input) {
        var steps = Arrays.stream(input.split("\n"))
                .map((Integer::parseInt))
                .collect(Collectors.toList());

        var visited = new TreeSet<Integer>();
        int current = 0;
        visited.add(current);

        while (true) {
            for (var step : steps) {
                current += step;

                if (visited.contains(current)) {
                    return current;
                } else {
                    visited.add(current);
                }
            }
        }
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public String getInput1() {
        return "+2\n+11\n+4\n-16\n-4\n+15\n+19\n-8\n-17\n+12\n+8\n+8\n+18\n-10\n-17\n-6\n+10\n+10\n+19\n+11\n+12\n-17\n+4\n-1\n+12\n+6\n+13\n+14\n+6\n+19\n+2\n+19\n-7\n-15\n+6\n-12\n-15\n-18\n+17\n+8\n+4\n+14\n+1\n+15\n-6\n-6\n+13\n+9\n-2\n+1\n+15\n-12\n+18\n+7\n-14\n+15\n-16\n+6\n-12\n-11\n-12\n-1\n-15\n-8\n-18\n-15\n+11\n+13\n-7\n+15\n+19\n+2\n+17\n-9\n-15\n-11\n-8\n+16\n+17\n-6\n+13\n+16\n-20\n+19\n+8\n+14\n+5\n+11\n-5\n+6\n+10\n+3\n-7\n-5\n-14\n+9\n+6\n+13\n+4\n-3\n-13\n-6\n-18\n-23\n-2\n+16\n+12\n-4\n+12\n+3\n-4\n+9\n-14\n+1\n-17\n-21\n+11\n-8\n+7\n-16\n-20\n-3\n-10\n-17\n-11\n+6\n-15\n-11\n+17\n+12\n-13\n-11\n-12\n-18\n-1\n+10\n-16\n-1\n-8\n+18\n+4\n+2\n-11\n-18\n+8\n+18\n-17\n+7\n+3\n+17\n+7\n+1\n-16\n+10\n-6\n-10\n+31\n-5\n-14\n+15\n+19\n+6\n-1\n+17\n-4\n+16\n-6\n+9\n-26\n-18\n+17\n-9\n-5\n-19\n+2\n+13\n+41\n-18\n+10\n-26\n-12\n+4\n-3\n-23\n-9\n-29\n-13\n+15\n+4\n-21\n+14\n+23\n-24\n-4\n-12\n-8\n-18\n-16\n-14\n+17\n-8\n-16\n+13\n-15\n+7\n+9\n-17\n-4\n-7\n-12\n+4\n+10\n-13\n-6\n-8\n+10\n+1\n+9\n-15\n+14\n-15\n+11\n-18\n-18\n+2\n+10\n-8\n-10\n+5\n-4\n+12\n-4\n-2\n+15\n+17\n+16\n+19\n+17\n+13\n+8\n-10\n+13\n+8\n-13\n-14\n+5\n-3\n-15\n-16\n-9\n-5\n-10\n+8\n-2\n+1\n-14\n-7\n-3\n-12\n-3\n+10\n-18\n+22\n+8\n-13\n-3\n-18\n-12\n-9\n+1\n-10\n+8\n-13\n-12\n-9\n-2\n+12\n-14\n+8\n-19\n-6\n-11\n+12\n+15\n+17\n+7\n-14\n+11\n+9\n-10\n-21\n+3\n-19\n-6\n-6\n+7\n+15\n-13\n-8\n+10\n-18\n+15\n-9\n-19\n+5\n+11\n-7\n-14\n+7\n+9\n+6\n+6\n+13\n+8\n+13\n+19\n-8\n-3\n-4\n-18\n+12\n-2\n+18\n+13\n-1\n+17\n-7\n+12\n+8\n+2\n+19\n-11\n+22\n+14\n+9\n-12\n+24\n+1\n+5\n+20\n-18\n+17\n-9\n+12\n-4\n-15\n-10\n+4\n-7\n+11\n+13\n+10\n+21\n-14\n-1\n-13\n-6\n+14\n+7\n+7\n+10\n+11\n-22\n+6\n+17\n+26\n-7\n+8\n-5\n+29\n-54\n-16\n+13\n+10\n-1\n-23\n+12\n-20\n-20\n-27\n+1\n-2\n-4\n-26\n-2\n-36\n-18\n+14\n-3\n-18\n-1\n+17\n+15\n-12\n+9\n+1\n+23\n-22\n-6\n-20\n+19\n+3\n-17\n-6\n-41\n-5\n-5\n-5\n-19\n-9\n-13\n+3\n+2\n+10\n+5\n-6\n-18\n-19\n+10\n+17\n+6\n-17\n+5\n-7\n+10\n+6\n-5\n-14\n+1\n-17\n-19\n+7\n+14\n-19\n+6\n+12\n-16\n+13\n-1\n+16\n+14\n-13\n-4\n+2\n-17\n-1\n-7\n-5\n-3\n-14\n-3\n+5\n+11\n-12\n-5\n-14\n+2\n+2\n-15\n+12\n-3\n+15\n-2\n+10\n+7\n-16\n+12\n-15\n+1\n-3\n-4\n-19\n+7\n-5\n+22\n+8\n+17\n+16\n+15\n+11\n+3\n-16\n-10\n+7\n+12\n+16\n+13\n-10\n+15\n-1\n-15\n+22\n+1\n+3\n+20\n+24\n+12\n+17\n-19\n-12\n+7\n-11\n-19\n+4\n+4\n-21\n+22\n+1\n+45\n+3\n-9\n+41\n-1\n+94\n+2\n+7\n-37\n+3\n+217\n+13\n+10\n-14\n+5\n-3\n-14\n-26\n-39\n+80\n+33\n+9\n-13\n+7\n+7\n-13\n-14\n+1\n+37\n+33\n+7\n+14\n+1\n-5\n-11\n-8\n-12\n+4\n+14\n-17\n+1\n-10\n-20\n-25\n+27\n+31\n-8\n+1\n+53\n+22\n+9\n-14\n-49\n+13\n-52\n-64\n-100\n+34\n+198\n+605\n+76787\n-8\n+13\n+4\n-8\n+5\n+9\n-7\n-13\n-6\n-4\n-20\n+6\n+12\n-4\n+7\n+5\n-14\n+10\n+17\n+18\n+18\n+5\n+6\n-12\n-6\n-8\n-13\n-5\n-8\n-17\n+6\n+2\n+3\n+18\n-1\n+20\n+14\n-18\n+21\n-12\n+3\n+8\n+6\n+21\n-3\n+1\n+9\n+16\n+15\n-7\n+1\n-16\n+17\n-5\n-15\n-14\n+3\n+3\n-4\n+2\n+1\n+16\n+19\n+12\n-4\n+14\n-8\n+17\n-7\n-1\n-3\n-11\n-12\n+7\n+9\n-10\n-13\n+1\n-8\n+4\n-12\n+13\n-10\n-8\n-3\n-19\n-12\n+7\n+9\n-1\n-9\n-4\n-19\n-12\n+17\n-12\n+19\n+18\n-12\n-7\n-10\n+5\n-21\n+4\n-6\n+4\n-15\n-9\n+19\n-17\n+21\n+12\n+24\n+13\n+18\n-16\n-11\n+10\n+18\n+7\n+16\n-10\n-4\n-13\n+29\n-13\n-9\n+3\n-22\n-13\n+67\n-10\n+9\n+6\n+2\n+8\n+6\n+18\n-16\n-15\n+9\n+2\n+3\n-4\n+7\n+18\n+12\n-10\n-15\n+1\n+11\n-9\n-19\n+15\n+8\n+11\n+2\n+3\n+9\n+14\n-19\n+16\n-5\n-12\n+8\n+17\n+4\n+10\n-13\n+19\n+9\n-19\n-11\n+8\n+6\n+3\n+5\n-16\n+3\n+7\n+11\n-1\n+5\n-7\n-12\n+13\n-6\n+1\n+18\n+6\n+1\n+14\n-7\n-2\n-13\n+18\n-1\n+18\n-5\n+3\n-14\n-17\n+1\n+13\n+16\n+14\n+4\n-13\n-12\n-1\n+2\n+3\n+14\n-1\n-6\n+12\n+8\n-11\n+6\n-7\n+19\n-16\n+5\n+18\n+11\n-16\n-8\n-3\n+13\n+6\n+7\n-14\n+9\n+14\n-7\n+9\n-14\n+1\n-6\n+16\n-2\n-12\n-5\n-8\n+7\n-19\n+13\n+2\n+7\n+13\n-8\n+7\n+15\n+9\n+10\n-5\n+4\n+7\n-1\n+12\n+13\n+13\n+10\n+13\n+13\n-6\n+12\n+10\n-5\n+9\n+11\n-16\n+8\n-11\n-15\n-15\n+10\n-17\n+2\n-6\n-11\n-14\n-13\n-14\n-5\n-8\n-1\n-7\n-7\n+21\n-11\n-5\n+3\n+5\n-15\n+20\n+8\n-17\n+7\n-13\n+35\n+6\n-3\n-1\n-16\n+8\n-5\n-10\n+14\n+20\n+13\n+10\n-20\n-17\n+13\n-2\n+9\n+19\n-8\n+4\n-2\n+12\n-15\n+12\n-4\n+20\n-7\n+2\n-5\n-19\n-3\n-1\n+3\n+6\n+7\n-20\n+19\n+15\n+10\n+3\n-7\n+1\n+13\n+4\n+6\n+5\n+4\n+4\n+7\n-19\n+16\n+2\n+4\n-8\n-7\n+18\n+15\n+6\n+1\n-13\n+14\n+18\n-7\n+8\n-16\n-10\n+13\n-12\n+13\n+14\n+14\n-8\n-19\n+4\n-15\n-16\n-16\n-8\n+10\n+17\n-12\n+10\n+8\n+19\n-13\n+14\n+12\n+3\n-10\n+2\n+14\n+1\n-2\n+3\n+16\n-3\n-12\n+5\n+4\n-19\n+17\n-4\n-8\n+15\n-6\n+14\n+21\n-4\n-18\n+4\n-8\n+21\n-28\n+5\n-25\n-4\n-2\n+14\n-2\n-22\n-9\n-7\n-5\n-20\n-17\n-6\n+8\n-5\n-4\n-2\n-15\n-6\n+13\n+13\n+13\n-29\n-16\n+13\n-38\n+5\n-16\n+4\n-15\n+19\n-31\n+24\n+6\n-13\n+20\n-47\n-6\n+13\n+14\n-79\n-14\n+11\n-4\n+24\n-18\n-1\n+20\n-4\n+24\n-26\n-25\n-16\n-6\n-8\n-7\n+8\n-77371";
    }

    @Override
    public String getInput2() {
        return getInput1();
    }
}


