package Advent_of_code_2018.days.day19;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day19Test {

    @Test
    public void p1() {
        int expected = 6;
        String input = "#ip 0\n" +
                "seti 5 0 1\n" +
                "seti 6 0 2\n" +
                "addi 0 1 0\n" +
                "addr 1 2 3\n" +
                "setr 1 0 0\n" +
                "seti 8 0 4\n" +
                "seti 9 0 5";
        var sut = new Day19();
        assertEquals(expected, sut.getResultP1(input));
    }

    @Ignore
    @Test
    public void p2() {
        String expected = "";
        var sut = new Day19();
        String input = sut.getInput2();
        assertEquals(expected, sut.getResultP2(input));
    }


    @Test
    public void ex() {
        int _0 = 0; //0
        int _1 = 0; //1
        int _2 = 0; // 2
        int _3 = 0; // 3
        int _4 = 0; //4
        int _5 = 0; //5

        //17
        _2 += 2;
        _2 = _2 * _2;
        _2 = _2* 19;
        _2 = _2 * 11;
        _1 += 8;
        _1 = _1 * 22;
        _1 = _1 + 18;
        _2 = _1 + _2;

        if (_0 == 0) {
//            goto top
        }

        //: TOP
        _3 = 1;
        _4 = 1;
        _1 = _3 * _4;
//        _1 = (_1 == _2) ? 1 : 0; // line 4
        if (_1 == _2) {
            _5 += 5;
        }





    }
}