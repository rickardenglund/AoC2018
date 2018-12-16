package Advent_of_code_2018.days.day16;

import Advent_of_code_2018.days.Day;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day16 implements Day {
    @Override
    public Object getResultP1(String input) {
        String[] lines = input.split("\n");
        List<TestData> testData = createTestData(lines);

        CPU cpu = new CPU();
        long count = testData.stream()
                .filter(data -> cpu.getPossibleInstructions(data).size() > 2)
                .count();

        return count;
    }

    @Override
    public Object getResultP2(String input) {
        String[] lines = getInput1().split("\n");
        List<TestData> testData = createTestData(lines);

        CPU cpu = new CPU();
        testData.stream()
                .forEach(data -> cpu.getPossibleInstructions(data));

        input.lines().forEach(instr -> cpu.execute(instr));
        return cpu.getReg(0);
    }

    public List<TestData> createTestData(String[] lines) {
        List<TestData> testData = new ArrayList<>();
        for (int i = 0; i < lines.length; i += 4) {
            testData.add(new TestData(lines[i], lines[i + 1], lines[i + 2]));
        }
        return testData;
    }

    @Override
    public int getDay() {
        return 16;
    }

    @Override
    public String getInput2() {
        List<String> lines = readFile("day" + getDay() + "p2.txt");
        return StringUtils.join(lines, "\n");
    }
}
