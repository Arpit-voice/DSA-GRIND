import java.util.Arrays;

class Solution {
    int[] t = new int[46];

    public int climbStairs(int n) {
        Arrays.fill(t, -1);
        return solve(n);
    }

    private int solve(int n) {
        if (n == 1 || n == 2) return n;

        if (t[n] != -1) return t[n];

        return t[n] = solve(n - 1) + solve(n - 2);
    }
}