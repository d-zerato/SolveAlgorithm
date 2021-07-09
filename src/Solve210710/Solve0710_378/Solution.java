package Solve210710.Solve0710_378;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //

    public int kthSmallest(int[][] matrix, int k) {
        //
        CompressionList compressionList = new CompressionList(matrix, k);

        while(true) {
            //
            int middleValue = compressionList.getMiddleValue();

            List<Integer> tinyList = compressionList
                    .getList()
                    .stream()
                    .filter(value -> value <= middleValue)
                    .collect(Collectors.toList());


            if (tinyList.size() != 0 && compressionList.getFindPoint() < 1) {
                return tinyList.get(0);
            }

            if (tinyList.size() > compressionList.getFindPoint()) {
                // *
                int maxValue = CompressionList.getMaxValue(tinyList);
                int minValue = CompressionList.getMinValue(tinyList);

                if (maxValue == minValue) {
                    return tinyList.get(0);
                }

                compressionList = new CompressionList(tinyList, compressionList.getFindPoint());
                continue;
            }

            if (tinyList.size() == compressionList.getFindPoint()) {
                // *
                return CompressionList.getMaxValue(tinyList);
            }

            List<Integer> overList = compressionList
                    .getList()
                    .stream()
                    .filter(value -> value > middleValue)
                    .collect(Collectors.toList());

            if (overList.size() == 0) {
                return tinyList.get(0);
            }

            if (tinyList.size() == 0 && compressionList.getFindPoint() < 1) {
                return CompressionList.getMinValue(overList);
            }

            compressionList = new CompressionList(overList, compressionList.getFindPoint() - tinyList.size());
        }
    }
}
