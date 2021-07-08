package Solve210710.Solve0710_64;

public class TestBootApplication {
    //
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sample1 = {{1,3,1}, {1,5,1}, {4,2,1}};
        int result = solution.minPathSum(sample1);

        System.out.println(result);
    }
}
