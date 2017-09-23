package main.DP;

/**
 * Description: 所有的房子的地形是一颗二叉树。约束条件是：相邻的房子装着相互联系的防盗系统，且当相邻的两个房子同一天被打劫时，该系统会自动报警
 * 
 * Example: 3 / \ 2 3 \ \ 3 1 最多能偷窃的金钱数是 3 + 3 + 1 = 7.
 *
 * 3 / \ 4 5 / \ \ 1 3 1 最多能偷窃的金钱数是 4 + 5 = 9
 *
 * https://leetcode.com/problems/house-robber-iii/
 *
 * @author andyli
 *
 */
public class HouseRobberIII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Version 1:
	// dp[i][0]表示以i为根的子树不偷根节点能获得的最高价值，dp[i][1]表示以i为根的子树偷根节点能获得的最高价值
	public int robV1(TreeNode root) {
		int[] dp = helper(root);
		return Math.max(dp[0], dp[1]);
	}

	private int[] helper(TreeNode root) {
		if (root == null) {
			return new int[] { 0, 0 };
		}

		int[] left = helper(root.left);
		int[] right = helper(root.right);
		int[] dp = new int[2];
		dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 左子树最大 + 右子树最大
		dp[1] = left[0] + right[0] + root.val;
		return dp;
	}

	// Version 2:
	// 自定义ResultType类
	class ResultType {
		public int rob;
		public int not_rob;

		public ResultType() {
			this.rob = 0;
			this.not_rob = 0;
		}
	}

	public int robV2(TreeNode root) {
		ResultType rst = helperV2(root);
		return Math.max(rst.rob, rst.not_rob);
	}

	private ResultType helperV2(TreeNode root) {
		ResultType rst = new ResultType();
		if (root == null) {
			return rst;
		}

		ResultType left = helperV2(root.left);
		ResultType right = helperV2(root.right);
		rst.rob = left.not_rob + right.not_rob + root.val;
		rst.not_rob = Math.max(left.rob, left.not_rob) + Math.max(right.rob, right.not_rob);

		return rst;
	}

}