package org.waspec.leetcode.question199;

import java.util.*;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        TreeNode root = solution001.buildATree();
        List<Integer> result = solution001.rightSideView(root);
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> view = new HashMap<Integer, Integer>();
        dft(view, 0, root);
        List<Integer> result = new ArrayList<Integer>(view.values());
        return result;
    }

    public void dft(Map<Integer, Integer> view, int level, TreeNode root) {
        if (root == null)
            return;

        // 题眼：root有可能是某一level中“不是最右边的”一个node，为了不遮住它右边的结点，采取中序或者先序都可以
        // 但先序保证了view中的key是增序的
        view.put(level, root.val);
        dft(view, level + 1, root.left);
        dft(view, level + 1, root.right);
    }

    public TreeNode buildATree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }
}


class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 1. 最朴素的想法是BFT，但很快会发现用到的数据结构过多，逻辑也比较纠结。如果换到是真实面试，肯定就完了。所以，真面试的时候，第一关键是要选对方向。
 */