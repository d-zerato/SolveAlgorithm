package Solve210710.Solve0710_1414;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //
    public int findMinFibonacciNumbers(int k) {
        //
        List<Integer> fibonacciArray = this.generateFibonacciArray(k);

        int result = 0;
        int remainValue = k;

        while(remainValue > 0) {
            //
            remainValue = this.getRemainderValue(fibonacciArray, remainValue);

            fibonacciArray = divideFibonacciArray(fibonacciArray, remainValue);

            result += 1;
        }

        return result;
    }

    public List<Integer> generateFibonacciArray(int findValue) {
        //
        List<Integer> fibonacciList = new ArrayList<>();
        int recentValue = 0;
        int offset = 0;

        while (true) {

            int firstPrev = 0;
            int secondPrev = 0;

            try {
                firstPrev  = fibonacciList.get(offset-1);
            } catch (IndexOutOfBoundsException e) {
                recentValue = 1;
                offset += 1;
                fibonacciList.add(recentValue);
                continue;
            }

            try {
                secondPrev = fibonacciList.get(offset-2);
            } catch (IndexOutOfBoundsException e) {
                recentValue = 1;
                offset += 1;
                fibonacciList.add(recentValue);
                continue;
            }

            recentValue = firstPrev + secondPrev;

            if (recentValue > findValue) {
                break;
            } else {
                fibonacciList.add(recentValue);
                offset += 1;
            }
        }

        return fibonacciList;
    }

    public List<Integer> divideFibonacciArray(List<Integer> fibonacciArray, int maxValue) {
        //
        List<Integer> newArray = new ArrayList<>();

        for (Integer intValue : fibonacciArray) {
            if (intValue <= maxValue) {
                newArray.add(intValue);
            } else {
                break;
            }
        }

        return newArray;
    }

    public int getRemainderValue(List<Integer> fibonacciArray, int findValue) {
        //
        int maxValue = 0;

        for (Integer targetValue : fibonacciArray) {
            //
            if (targetValue == findValue) {
                return 0;
            }

            if (targetValue > findValue) {
                break;
            }

            maxValue = targetValue;
        }

        return findValue - maxValue;
    }
}
