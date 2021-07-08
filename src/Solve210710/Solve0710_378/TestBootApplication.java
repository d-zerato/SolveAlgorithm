package Solve210710.Solve0710_378;

public class TestBootApplication {
    //
    public static void main(String[] args) {
        Solution solution = new Solution();

//        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
//        int[][] matrix = {{1}};
        int[][] matrix = {{4,7,11}, {7,11,16},{10,11,20}};
        int result = solution.kthSmallest(matrix, 6);
        System.out.println("result : " + result);
    }
}
