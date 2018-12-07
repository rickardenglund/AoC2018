package Advent_of_code_2018.days.day7;

public class Worker {
    private final int workBaseCost;
    private int workLeft = 0;
    private String workId;

    public Worker(int workBaseCost) {
        this.workBaseCost = workBaseCost;
    }

    public int getWorkLeft() {
        return workLeft;

    }

    public void assignWork(String work) {
        workId = work;
        workLeft = letterToSeconds(work);
    }

    public int letterToSeconds(String id) {
        return Character.getNumericValue(id.charAt(0)) - 9 + workBaseCost;
    }

    public String getWorkId() {
        return workId;
    }

    public void doWork(int amount) {
        workLeft = Math.max(0, workLeft - amount);
    }

    @Override
    public String toString() {
        return "Worker{" + workId + ": " + workLeft +
                '}';
    }

    public boolean isDone() {
        return workLeft <= 0 && workId != null;
    }

    public void reset() {
        workId = null;
        workLeft = 0;
    }
}
