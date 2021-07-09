package Solve210710.Solve0703_647;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    //
    public int countSubstrings(String s) {
        return this.getAlphabetMap(s);
    }

    public int getAlphabetMap(String s) {
        //
        char[] charArray = s.toCharArray();
        Map<Character, AlphabetCounter> alphabetMap = new HashMap<>();


        for (int i=0; i<charArray.length; i++) {
            //
            AlphabetCounter alphabetCounter = alphabetMap.get(charArray[i]);

            if (alphabetCounter == null || alphabetCounter.count == 0) {
                alphabetMap.put(charArray[i], new AlphabetCounter(charArray[i]));
            } else {
                alphabetCounter.increaseCount();
                alphabetMap.put(alphabetCounter.alphabet, alphabetCounter);
            }
        }

        int totalCount = 0;
        for (AlphabetCounter alphabetCounter : alphabetMap.values()) {
            totalCount += alphabetCounter.getCount();
        }

        int singleListSize = (int)alphabetMap.values().stream().filter(counter -> counter.getCount() % 2 == 1).count();

        boolean singleCheck = false;
        if (singleListSize == 0) {
            singleListSize = 1;
            singleCheck = true;
        }

        List<AlphabetCounter> multipleList = alphabetMap.values().stream().filter(counter -> counter.getCount() > 2).collect(Collectors.toList());
        Map<Character, Integer> duplicateCountMap = new HashMap<>();
        multipleList.stream().map(value -> {
            duplicateCountMap.put(value.getAlphabet(), value.getCount() / 2);
            return null;
        });

        int duplicateTotalCount = 0;
        List<Integer> countList = duplicateCountMap.values().stream().collect(Collectors.toList());
        for (Integer count : countList) {
            duplicateTotalCount += count;
        }

        int allCharStringCount = this.factorial(duplicateTotalCount);

        if (allCharStringCount == 0) {
            allCharStringCount = 1;
        }

        int duplicateStringCount = 0;

        for (Integer value : duplicateCountMap.values()) {
            duplicateStringCount += factorial(value);
        }

        if (duplicateStringCount == 0) {
            duplicateStringCount = 1;
        }

        return totalCount + (allCharStringCount / duplicateStringCount * singleListSize);
    }

    public int factorial(int n) {
        int fac = 1;

        for (int i = 1; i <= n; i++)
            fac = fac * i;

        return fac;
    }
}