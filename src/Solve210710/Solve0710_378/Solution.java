package Solve210710.Solve0710_378;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //
    public int kthSmallest(int[][] matrix, int k) {
        //
        Integer findPoint = Integer.valueOf(k);
        List<Integer> matrixList = this.arrayToList(matrix);

        while(true) {
            //
            System.out.println("list : " + matrixList);
            System.out.println("list size : " + matrixList.size());

            if (findPoint.equals(matrixList.size())) {
                return this.getMaxValue(matrixList);
            }

            if (findPoint.equals(1)) {
                return this.getMinValue(matrixList);
            }

            boolean overListCheck = this.compressionList(matrixList, findPoint);

            if (overListCheck) {
                return matrixList.get(0);
            }
        }
    }

    private boolean compressionList(List<Integer> matrixList, Integer findPoint) {
        //
        int middleValue = this.getMiddleValue(matrixList);

        List<Integer> tinyList = matrixList.stream().filter(value -> value <= middleValue).collect(Collectors.toList());
        List<Integer> overList = matrixList.stream().filter(value -> value > middleValue).collect(Collectors.toList());

        if (findPoint.intValue() >= tinyList.size()) {
            matrixList = overList;
            findPoint = Integer.valueOf(findPoint.intValue() - middleValue);
        } else {
            matrixList = tinyList;
        }

        if (overList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private List<Integer> arrayToList(int[][] matrix) {
        //
        List<Integer> list = new ArrayList<>();

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }

        return list;
    }

    private int getMaxValue(List<Integer> matrixList) {
        //
        int maxValue = 0;


        for (Integer targetValue : matrixList) {

            if (maxValue == 0) {
                maxValue = targetValue;
            } else if (maxValue < targetValue) {
                maxValue = targetValue;
            }
        }

        return maxValue;
    }

    private int getMinValue(List<Integer> matrixList) {
        //
        int minValue = 0;

        for (Integer targetValue : matrixList) {
            if (minValue == 0) {
                minValue = targetValue;
            } else if (minValue > targetValue) {
                minValue = targetValue;
            }
        }

        return minValue;
    }

    private int getMiddleValue(List<Integer> matrixList) {
        int maxValue = 0;
        int minValue = 0;

        for (Integer targetValue : matrixList) {

            if (maxValue == 0) {
                maxValue = targetValue;
            }

            if (minValue == 0) {
                minValue = targetValue;
            }

            if (maxValue < targetValue) {
                maxValue = targetValue;
            }

            if (minValue > targetValue) {
                minValue = targetValue;
            }
        }

        return (maxValue+minValue)/2;
    }
}
