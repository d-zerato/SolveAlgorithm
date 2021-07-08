package Solve210710.Solve0710_1414;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //
    public int findMinFibonacciNumbers(int k) {

        System.out.println(this.generateFibonacciArray(k));

        return 0;
    }

    public List<Integer> generateFibonacciArray(int findValue) {
        //
        List<Integer> fibonacciList = new ArrayList<>();
        int recentValue = 0;
        int offset = 0;

        while (recentValue < findValue) {

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
            fibonacciList.add(recentValue);
            offset += 1;
        }

        return fibonacciList;
    }
}
