package org.waspec.leetcode.Question112;

/**
 * Path Sum
 */

public class Solution001 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        Solution001 solution001 = new Solution001();
        System.out.println(solution001.hasPathSum(root,6));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null){
            return false;
        }

        return DFS(root, 0, sum);
    }

    private boolean DFS(TreeNode root, int upperSum, int targetSum) {
        int currentSum = upperSum + root.val;
        if (currentSum == targetSum) {
            return true;
        } else {
            boolean leftResult = false;
            boolean rightResult = false;
            if (root.left != null) {
                leftResult = DFS(root.left, currentSum, targetSum);
            }

            if (root.right != null) {
                rightResult = DFS(root.right, currentSum, targetSum);
            }

            return leftResult || rightResult;
        }
    }

    private boolean DFS2(TreeNode root, int upperSum, int targetSum){
        if (root==null){
            return false;
        }

        int currentSum = upperSum+root.val;

        // 提示：尾递归优化
        return  currentSum== targetSum
                || DFS2(root.left, currentSum, targetSum)
                || DFS2(root.right, currentSum, targetSum);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 感悟：一上来最朴素的想法是backtracking，但想想这样耗的资源太多，而且用不着记录path。仔细考虑一下，DFS就够用了。
 * 坏点：[1,2], 1这里结果是true，LeetCode期望是false，跟Question111同样情况。难道对path的定义有问题？
 */