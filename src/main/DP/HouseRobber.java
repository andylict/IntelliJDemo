package main.DP;
/**
 * Description:
 * 每个房子都存放着特定金额的钱。
 * 你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * 给定一个非负整数列表，表示每个房子中存放的钱， 计算：如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
 * 
 * Example:
 * given [3, 8, 4] output: 8
 * 
 * https://leetcode.com/problems/house-robber/
 * 
 * @author andyli
 *
 */
public class HouseRobber {
	// method 1: dp[i]: 前i个房子 最多打劫多少钱
	public long rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		long[] dp = new long[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]); // max(不抢当前房子，抢当前房子)
		}
		return dp[nums.length];
	}
	
	// method 2: 滚动数组 rolling array 优化
	public long robV2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		long[] dp = new long[2];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
		}
		return dp[nums.length % 2];
	}
}
