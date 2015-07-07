package org.waspec.leetcode.question111;

public class Solution002 {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        int min = leftDepth < rightDepth ? leftDepth : rightDepth;
        return min + 1;
    }
}

/**
 * 原理：是左子树的深度小还是右子树的深度小？选小的，加1
 */