package Advent_of_code_2018.days.day7;

import Advent_of_code_2018.days.Day;

import java.util.*;
import java.util.stream.Collectors;

public class Day7 implements Day {
    private int nWorkers = 5;
    private int workBaseCost = 60;

    public void setWorkBaseCost(int workBaseCost) {
        this.workBaseCost = workBaseCost;
    }

    @Override
    public Object getResultP1(String input) {
        DepGraph depGraph = new DepGraph(input.split("\n"));

        StringBuilder sb = new StringBuilder();
        while (depGraph.size() > 0) {
            String workId = depGraph.getAvailableWork().get(0);
            sb.append(workId);
            depGraph.perform(workId);
        }
        return sb.toString();
    }

    @Override
    public Object getResultP2(String input) {
        DepGraph work = new DepGraph(input.split("\n"));

        int time = 0;
        List<Worker> workers = createWorkers(nWorkers, workBaseCost);
        while (work.size() > 0) {
            assignWork(workers, work);
            var workTime = getTimeToNextAvailableWorker(workers);
            time += workTime;
            work(workers, workTime, work);
        }

        return time;
    }

    private void work(List<Worker> workers, int time, DepGraph work) {
        workers.forEach(worker-> {
            worker.doWork(time);
            if (worker.isDone()) {
                work.perform(worker.getWorkId());
            }
        });
    }

    private static List<Worker> createWorkers(int nWorkers, int workBaseCost) {
        List<Worker> list = new ArrayList<>();
        for (int i = 0; i < nWorkers; i++) {
            list.add(new Worker(workBaseCost));
        }
        return list;
    }

    private int getTimeToNextAvailableWorker(List<Worker> workers) {
        return workers.stream()
                .filter(worker -> worker.getWorkLeft() != 0)
                .min(Comparator.comparingInt(Worker::getWorkLeft))
                .get()
                .getWorkLeft();
    }

    private void assignWork(List<Worker> workers, DepGraph work) {
        List<String> availableWork = filterActiveWork(work.getAvailableWork(), workers);
        for (var workId: availableWork) {
            Optional<Worker> worker = getAvailableWorker(workers);
            if (worker.isPresent()) {
                worker.get().assignWork(workId);
            } else {
                break;
            }
        }
    }

    private List<String> filterActiveWork(List<String> availableWork, List<Worker> workers) {
        List<String> activeWork = workers.stream().map(worker -> worker.getWorkId()).collect(Collectors.toList());
        return availableWork.stream().filter(workId -> !activeWork.contains(workId)).collect(Collectors.toList());
    }

    private Optional<Worker> getAvailableWorker(List<Worker> workers) {
        return workers.stream()
                .filter(worker -> worker.getWorkLeft() == 0)
                .findFirst();
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

