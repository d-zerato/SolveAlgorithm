package Solve210710.Solve0710_378;

import java.util.ArrayList;
import java.util.List;

public class CompressionList {
    //
    private List<Integer> list;
    private int middleValue;
    private int findPoint;

    public CompressionList() {
        //
        this.list = new ArrayList<>();
        this.middleValue = 0;
        this.findPoint = 0;
    }

    public CompressionList(int[][] matrix, int k) {
//            this();
        this.list = arrayToList(matrix);
        this.findPoint = k;
        this.middleValue = setMiddleValue();
    }

    public CompressionList(List<Integer> list, int k) {
//            this();
        this.list = list;
        this.findPoint = k;
        this.middleValue = setMiddleValue();
    }

    private List<Integer> arrayToList(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        return list;
    }

    public List<Integer> getList() {
        //
        return this.list;
    }

    public int getFindPoint() {
        //
        return this.findPoint;
    }

    public int getMiddleValue() {
        //
        return this.middleValue;
    }

    private int setMiddleValue() {
        int maxValue = 0;
        int minValue = 0;

        for (Integer targetValue : this.list) {

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

    public static int getMaxValue(List<Integer> list) {
        //
        int maxValue = 0;

        for (Integer targetValue : list) {

            if (maxValue == 0) {
                maxValue = targetValue;
            } else if (maxValue < targetValue) {
                maxValue = targetValue;
            }
        }

        return maxValue;
    }

    public static int getMinValue(List<Integer> list) {
        //
        int minValue = 0;

        for (Integer targetValue : list) {
            if (minValue == 0) {
                minValue = targetValue;
            } else if (minValue > targetValue) {
                minValue = targetValue;
            }
        }

        return minValue;
    }
}
