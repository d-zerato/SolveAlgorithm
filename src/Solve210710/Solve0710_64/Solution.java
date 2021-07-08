package Solve210710.Solve0710_64;

public class Solution {
    //
    public int minPathSum(int[][] grid) {
        int verticalSize = grid.length;
        int horizonSize = grid[0].length;

        int[][] resultMinGrid = new int[verticalSize][horizonSize];

        this.setResultGrid(grid, resultMinGrid, verticalSize, horizonSize);

        return resultMinGrid[verticalSize-1][horizonSize-1];
    }

    private void setResultGrid(int[][] initGrid, int[][] resultGrid, int verticalSize, int horizonSize) {
        //
        for (int verticalPoint = 0; verticalPoint < verticalSize; verticalPoint++) {
            for (int horizonPoint = 0; horizonPoint < horizonSize; horizonPoint++) {
                //
                if (verticalPoint == 0 && horizonPoint == 0) {
                    resultGrid[verticalPoint][horizonPoint] = initGrid[verticalPoint][horizonPoint];
                } else if (verticalPoint == 0) {
                    resultGrid[verticalPoint][horizonPoint] = resultGrid[verticalPoint][horizonPoint - 1] + initGrid[verticalPoint][horizonPoint];
                } else if (horizonPoint == 0) {
                    resultGrid[verticalPoint][horizonPoint] = resultGrid[verticalPoint - 1][horizonPoint] + initGrid[verticalPoint][horizonPoint];
                } else {
                    int tempHorValue = resultGrid[verticalPoint][horizonPoint - 1];
                    int tempVerValue = resultGrid[verticalPoint - 1][horizonPoint];

                    resultGrid[verticalPoint][horizonPoint] = Math.min(tempVerValue, tempHorValue) + initGrid[verticalPoint][horizonPoint];
                }
            }
        }
    }
}
