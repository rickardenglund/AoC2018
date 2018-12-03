/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Advent_of_code_2018;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day1.Day1;
import Advent_of_code_2018.days.day2.Day2;
import Advent_of_code_2018.days.day3.Day3;
import com.google.common.base.Stopwatch;

import java.io.Console;
import java.io.IOException;

public class App {
    public static void run() {
        Day day = new Day3();
        Stopwatch timer = Stopwatch.createUnstarted();

        timer.start();
        Object resultP1 = day.getResultP1(day.getInput1());
        timer.stop();
        String split1 = timer.toString();
        timer.reset();
        timer.start();
        Object resultP2 = day.getResultP2(day.getInput2());
        timer.stop();
        String split2 = timer.toString();

        System.out.println("### Day " + day.getDay() + " ###");
        System.out.println("P1: " + resultP1);
        System.out.println("P2: " + resultP2);
        System.out.println("Time: " + split1 + ", " + split2);
    }

    public static void main(String[] args) {
        new App().run();
    }

}
