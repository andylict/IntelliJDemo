package main.DP;
/**
 * Description:
 * 所有的房子围成了一个圈，这就意味着第一间房子和最后一间房子是挨着的。
 * 相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。
 * 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。
 * 
 * Example:
 * nums = [3,6,4], 返回　6，　你不能打劫3和4所在的房间，因为它们围成一个圈，是相邻的
 * 
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * @author andyli
 *
 */
public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		// 数组拆成2个：包含第一个房子的，不包含第一个房子的
		return Math.max(rob1(nums, 0, nums.length - 2), rob1(nums, 1, nums.length - 1));
	}
	
	private int rob1(int[] nums, int start, int end) {
		if (start > end) return 0;

		if (start == end) return nums[start];
		if (start + 1 == end) return Math.max(nums[start], nums[end]);

		int[] dp = new int[2];
		dp[start % 2] = nums[start];
		dp[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
			dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i]);
		}
		return dp[end % 2];
	}
}
