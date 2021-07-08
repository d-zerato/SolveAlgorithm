package Solve210703.Solve0703_02;

import java.util.ArrayList;
import java.util.List;

/*
 * 한 칸씩 식별
 * 1인 경우 그룹 식별
 *  - 그룹 가입
 *  - 연관 그룹 확인
 *      - 그룹 정리
 */

public class Solution {
    //
    public int numIslands(char[][] grid) {

        return 0;
    }

    private class Island {
        int verticalPoint;
        int horizonPoint;
        String pointId;

        public Island(int verticalPoint, int horizonPoint) {
            this.verticalPoint = verticalPoint;
            this.horizonPoint = horizonPoint;
            this.pointId = generateId(verticalPoint, horizonPoint);
        }

        public List<String> getRelatedGridId(int maxVerticalSize, int maxHorizonSize) {
            List<String> gridList = new ArrayList<>();

            if (this.verticalPoint > 0) {
                gridList.add(generateId(verticalPoint-1, horizonPoint));
            }

            if (this.horizonPoint > 0) {
                gridList.add(generateId(verticalPoint, horizonPoint-1));
            }

            if (this.verticalPoint < maxVerticalSize) {
                gridList.add(generateId(verticalPoint+1, horizonPoint));
            }

            if (this.horizonPoint < maxHorizonSize) {
                gridList.add(generateId(verticalPoint, horizonPoint+1));
            }

            return gridList;
        }
    }

    public String generateId(int verticalPoint, int horizonPoint) {
        //
        return ""+verticalPoint+"-"+horizonPoint;
    }
}
