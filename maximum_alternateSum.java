class Solution {//recursion+memoization approach
    public long solve(int[] nums, int i, boolean flag, long[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        int f = flag ? 1 : 0;
        if (dp[i][f] != -1) {
            return dp[i][f];
        }

        long val = nums[i];
        if (!flag) {
            val = -val;
        }

        long skip = solve(nums, i + 1, flag, dp);
        long take = solve(nums, i + 1, !flag, dp) + val;

        return dp[i][f] = Math.max(take, skip);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, true, dp);
    }
}
//bottom up approach