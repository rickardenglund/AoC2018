package Advent_of_code_2018.days.day7;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.util.Pos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 implements Day {
    private int nWorkers = 5;

    @Override
    public Object getResultP1(String input) {
        DepGraph depGraph = new DepGraph(input.split("\n"));

        StringBuilder sb = new StringBuilder();
        while (depGraph.size() > 0) {
            sb.append(depGraph.getNext());
        }
        return sb.toString();
    }

    @Override
    public Object getResultP2(String input) {
        DepGraph depGraph = new DepGraph(input.split("\n"));

        while (depGraph.size() > 0) {

            int sec = letterToSeconds(depGraph.getNext());
        }


        return null;
    }

    public int letterToSeconds(String next) {
        return 0;
    }


    public void setNWorkers(int n) {
        nWorkers = n;
    }

    @Override
    public int getDay() {
        return 7;
    }

    @Override
    public String getInput1() {
        return "Step W must be finished before step B can begin.\n" +
                "Step G must be finished before step T can begin.\n" +
                "Step B must be finished before step P can begin.\n" +
                "Step R must be finished before step M can begin.\n" +
                "Step K must be finished before step Q can begin.\n" +
                "Step Z must be finished before step X can begin.\n" +
                "Step V must be finished before step S can begin.\n" +
                "Step D must be finished before step U can begin.\n" +
                "Step Y must be finished before step J can begin.\n" +
                "Step A must be finished before step C can begin.\n" +
                "Step M must be finished before step U can begin.\n" +
                "Step E must be finished before step X can begin.\n" +
                "Step T must be finished before step F can begin.\n" +
                "Step U must be finished before step C can begin.\n" +
                "Step C must be finished before step Q can begin.\n" +
                "Step S must be finished before step N can begin.\n" +
                "Step X must be finished before step H can begin.\n" +
                "Step F must be finished before step L can begin.\n" +
                "Step Q must be finished before step J can begin.\n" +
                "Step P must be finished before step J can begin.\n" +
                "Step I must be finished before step L can begin.\n" +
                "Step J must be finished before step L can begin.\n" +
                "Step L must be finished before step N can begin.\n" +
                "Step H must be finished before step O can begin.\n" +
                "Step N must be finished before step O can begin.\n" +
                "Step B must be finished before step S can begin.\n" +
                "Step A must be finished before step T can begin.\n" +
                "Step G must be finished before step K can begin.\n" +
                "Step Z must be finished before step N can begin.\n" +
                "Step V must be finished before step I can begin.\n" +
                "Step Z must be finished before step Q can begin.\n" +
                "Step I must be finished before step J can begin.\n" +
                "Step S must be finished before step I can begin.\n" +
                "Step P must be finished before step I can begin.\n" +
                "Step B must be finished before step C can begin.\n" +
                "Step M must be finished before step L can begin.\n" +
                "Step G must be finished before step Z can begin.\n" +
                "Step M must be finished before step C can begin.\n" +
                "Step U must be finished before step F can begin.\n" +
                "Step B must be finished before step Y can begin.\n" +
                "Step W must be finished before step U can begin.\n" +
                "Step G must be finished before step M can begin.\n" +
                "Step M must be finished before step J can begin.\n" +
                "Step C must be finished before step L can begin.\n" +
                "Step K must be finished before step D can begin.\n" +
                "Step S must be finished before step X can begin.\n" +
                "Step Q must be finished before step N can begin.\n" +
                "Step V must be finished before step N can begin.\n" +
                "Step R must be finished before step C can begin.\n" +
                "Step E must be finished before step H can begin.\n" +
                "Step D must be finished before step P can begin.\n" +
                "Step H must be finished before step N can begin.\n" +
                "Step X must be finished before step O can begin.\n" +
                "Step K must be finished before step Y can begin.\n" +
                "Step R must be finished before step F can begin.\n" +
                "Step L must be finished before step O can begin.\n" +
                "Step Y must be finished before step M can begin.\n" +
                "Step T must be finished before step I can begin.\n" +
                "Step T must be finished before step Q can begin.\n" +
                "Step B must be finished before step F can begin.\n" +
                "Step C must be finished before step N can begin.\n" +
                "Step V must be finished before step M can begin.\n" +
                "Step T must be finished before step N can begin.\n" +
                "Step S must be finished before step L can begin.\n" +
                "Step P must be finished before step H can begin.\n" +
                "Step X must be finished before step Q can begin.\n" +
                "Step Z must be finished before step I can begin.\n" +
                "Step Q must be finished before step O can begin.\n" +
                "Step I must be finished before step N can begin.\n" +
                "Step E must be finished before step P can begin.\n" +
                "Step R must be finished before step L can begin.\n" +
                "Step P must be finished before step L can begin.\n" +
                "Step T must be finished before step H can begin.\n" +
                "Step G must be finished before step X can begin.\n" +
                "Step J must be finished before step H can begin.\n" +
                "Step G must be finished before step V can begin.\n" +
                "Step K must be finished before step N can begin.\n" +
                "Step R must be finished before step Q can begin.\n" +
                "Step Z must be finished before step T can begin.\n" +
                "Step E must be finished before step F can begin.\n" +
                "Step Y must be finished before step H can begin.\n" +
                "Step P must be finished before step N can begin.\n" +
                "Step S must be finished before step O can begin.\n" +
                "Step L must be finished before step H can begin.\n" +
                "Step W must be finished before step E can begin.\n" +
                "Step X must be finished before step N can begin.\n" +
                "Step Z must be finished before step D can begin.\n" +
                "Step A must be finished before step H can begin.\n" +
                "Step T must be finished before step X can begin.\n" +
                "Step E must be finished before step Q can begin.\n" +
                "Step K must be finished before step U can begin.\n" +
                "Step M must be finished before step T can begin.\n" +
                "Step J must be finished before step O can begin.\n" +
                "Step D must be finished before step N can begin.\n" +
                "Step K must be finished before step A can begin.\n" +
                "Step G must be finished before step E can begin.\n" +
                "Step R must be finished before step H can begin.\n" +
                "Step W must be finished before step M can begin.\n" +
                "Step U must be finished before step N can begin.\n" +
                "Step Q must be finished before step H can begin.\n" +
                "Step Y must be finished before step A can begin.";
    }
}

