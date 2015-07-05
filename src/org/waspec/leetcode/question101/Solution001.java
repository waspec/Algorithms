package org.waspec.leetcode.question101;

import java.util.LinkedList;
import java.util.List;

/**
 * Symmetric Tree (2015.07.03~05 at Portland)
 */
public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right= new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(solution001.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> list1 = new LinkedList<TreeNode>();
        List<TreeNode> list2 = new LinkedList<TreeNode>();

        this.access1(root, list1);
        this.access2(root, list2);

        int size1 = list1.size();
        int size2 = list2.size();
        if (size1!=size2){
            return false;
        }else{
            for (int i = 0; i < size1; i++) {
                if (!this.areEqual(list1.get(i), list2.get(i))){
                    return false;
                }
            }
        }

        return true;
    }

    // 根->左->右
    private void access1(TreeNode node, List<TreeNode> result) {
        result.add(node);
        if (node != null) {
            access1(node.left, result);
            access1(node.right, result);
        }
    }

    // 根->右->左
    private void access2(TreeNode node, List<TreeNode> result) {
        result.add(node);
        if (node != null) {
            access2(node.right, result);
            access2(node.left, result);
        }
    }

    private boolean areEqual(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if (n1 != null && n2 != null && n1.val == n2.val) {
            return true;
        } else {
            return false;
        }
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
 * 思路：一上来能想出好多种做法。
 * （1）广度优先遍历，然后看每层是不是对称
 * （2）先序深度遍历一次，后序深度优先遍历一次，看得出的两列结果是否一致
 * （3）一左一右同步遍历（这个不需要额外空间，但不容易想清楚）
 * 策略：面试的时候先用（2）把答案搞定，然后再谋求实现（3）
 * 提示：方案（3）需要方法外部变量，也就是字段来参与
 * 提示：本题与100（检查两棵树是否相同）并非使用同样的方法
 * 注意：Java的LinkedList可以add入null值
 */