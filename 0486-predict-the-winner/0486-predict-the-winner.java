class Solution {
       int[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];

        return solve(nums, 0, n - 1) >= 0;
    }
     private int solve(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int pickLeft = nums[i] - solve(nums, i + 1, j);
        int pickRight = nums[j] - solve(nums, i, j - 1);

        return dp[i][j] = Math.max(pickLeft, pickRight);
    }
}