package test.Solve0710_378;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //

    public int kthSmallest(int[][] matrix, int k) {
        //

        List<Integer> list = this.sorting(matrix);

        return list.get(k-1);
    }

    public List<Integer> sorting(int[][] matrix) {
        //
        List<Integer> linkedList = new LinkedList<>();

        for (int i=0; i < matrix.length; i++) {
            for (int j=0 ; j < matrix[0].length; i++) {
                if (i==0 && j==0) {
                    linkedList.add(matrix[i][j]);
                    continue;
                }

                int searchOffset = 0;
                while(true) {
                    if (searchOffset == linkedList.size()) {
                        linkedList.add(matrix[i][j]);
                        break;
                    }

                    if (linkedList.get(searchOffset) < matrix[i][j]) {
                        continue;
                    } else {
                        linkedList.add(searchOffset, matrix[i][j]);
                        break;
                    }
                }
            }
        }

        return linkedList;
    }
}
