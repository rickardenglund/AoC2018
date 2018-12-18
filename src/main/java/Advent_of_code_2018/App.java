/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Advent_of_code_2018;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day13.Day13;
import Advent_of_code_2018.days.day14.Day14;
import Advent_of_code_2018.days.day15.Day15;
import Advent_of_code_2018.days.day16.Day16;
import Advent_of_code_2018.days.day17.Day17;
import Advent_of_code_2018.days.day18.Day18;
import com.google.common.base.Stopwatch;

public class App {
    private static void run() {
        Stopwatch timer = Stopwatch.createUnstarted();
        timer.start();
        Day day = new Day14();
        timer.stop();
        String setupTime = timer.toString();
        timer.reset();

        String p1Input = day.getInput1();
        String p2Input = day.getInput2();
        timer.start();
        Object resultP1 = day.getResultP1(p1Input);
        timer.stop();
        String split1 = timer.toString();
        timer.reset();
        timer.start();
        Object resultP2 = day.getResultP2(p2Input);
        timer.stop();
        String split2 = timer.toString();

        System.out.println("### Day " + day.getDay() + " ###");
        System.out.println("P1: " + resultP1);
        System.out.println("P2: " + resultP2);
        System.out.println("Time: " + setupTime + ", " + split1 + " : " + split2);
    }

    public static void main(String[] args) {
        App.run();
    }

}
