/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Advent_of_code_2018;

import Advent_of_code_2018.days.Day;
import Advent_of_code_2018.days.day1.Day1;
import Advent_of_code_2018.days.day2.Day2;

public class App {
    public static void main(String[] args) {
        Day day = new Day2();

        System.out.println("### Day " + day.getDay() + " ###");
        System.out.println("P1: " + day.getResultP1(day.getInput1()));
        System.out.println("P2: " + day.getResultP2(day.getInput2()));
    }

}
