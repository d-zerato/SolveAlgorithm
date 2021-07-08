package Solve210703.Solve0703_03;

import java.util.*;

public class Solution {
    //
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        //
        int integerPattern = this.parsingNumberFormat(pattern);
        List<String> resultList = new ArrayList<>();

        for (int i=0; i< words.length; i++) {
            if (integerPattern == this.parsingNumberFormat(words[i])) {
                resultList.add(words[i]);
            }
        }

        return resultList;
    }

    public int parsingNumberFormat(String word) {
        //
        HashMap<Character, Integer> alphabetMap = new HashMap<>();
        int newId = 1;
        int resultFormatNumber = 0;
        int targetNumber = 0;

        for (int idx = 0; idx < word.length(); idx++) {
            if (newId == 1) {
                alphabetMap.put(word.charAt(idx), 1);
                targetNumber = 1;
            } else {
                if (alphabetMap.get(word.charAt(idx)) == null) {
                    alphabetMap.put(word.charAt(idx), newId);
                    targetNumber = newId;
                } else {
                    targetNumber = alphabetMap.get(word.charAt(idx));
                }
            }

            newId++;
            resultFormatNumber *= 10;
            resultFormatNumber += targetNumber;
//            resultFormatNumber = resultFormatNumber * 10 + targetNumber;
        }

        return resultFormatNumber;
    }
}
