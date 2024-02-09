package t1.testtask.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.*;

public class StringFrequencyCounter {
    public static List<String> count(String string){
        Map<Character, Integer> allCharacters = new HashMap<>();
        for (Character element : string.toCharArray()){
            allCharacters.put(element, allCharacters.getOrDefault(element,0) + 1);
        }
        Queue<Pair> resultQueue = new PriorityQueue<>((o1,o2)-> o2.getFrequency() -o1.getFrequency());
        for (Map.Entry<Character, Integer> element : allCharacters.entrySet()){
            Pair curPair = new Pair(element.getKey(), element.getValue());
            resultQueue.offer(curPair);
        }
        List<String> answer = new ArrayList<>();
        while (!resultQueue.isEmpty()){
            Pair curPair = resultQueue.poll();
            answer.add(curPair.getCharacter().toString() + ": " + curPair.getFrequency());
        }

        return answer;
    }
    @AllArgsConstructor
    public static class Pair implements Serializable {
        @Getter
        private Character character;
        @Getter
        private Integer frequency;

    }

}
