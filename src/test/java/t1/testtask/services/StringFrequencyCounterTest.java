package t1.testtask.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StringFrequencyCounterTest {

    @Test
    void countTest1() {
        String stringToOperate = "aaaaabcccc";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("a: 5");
        expectedResult.add("c: 4");
        expectedResult.add("b: 1");

        Assertions.assertEquals(expectedResult, StringFrequencyCounter.count(stringToOperate));

    }
    @Test
    void countTest2() {
        String stringToOperate = "";
        List<String> expectedResult = new ArrayList<>();
        Assertions.assertEquals(expectedResult, StringFrequencyCounter.count(stringToOperate));

    }
    @Test
    void countTest3() {
        int ampuntOfLetters = 150000;
        String stringToOperate = "b".repeat(ampuntOfLetters);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("b: " + ampuntOfLetters);
        Assertions.assertEquals(expectedResult, StringFrequencyCounter.count(stringToOperate));

    }
}