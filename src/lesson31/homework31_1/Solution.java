package lesson31.homework31_1;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public Map<Character, Integer> countSymbols(String text){
        Map<Character, Integer> result = new TreeMap<>();

        for(Character ch : text.toCharArray())
            if(Character.isLetter(ch)) {
                result.put(ch, result.containsKey(ch) ? result.get(ch)+1 : 1);
            }
        return result;
    }

    public Map<String, Integer> words(String text){
        Map<String, Integer> result = new TreeMap<>();

        for(String word : text.trim().split(" "))
            if(word.length() > 2)
                if(result.containsKey(word))
                    result.put(word, result.get(word)+1);
                else
                    result.put(word, 1);
        return result;
    }

}
