package org.waspec.leetcode.question111;

/**
 * Minimum Depth of Binary Tree
 * Created by Timothy on 7/5/2015.
 *
 * @ Woodburn Premium Outlets, OR
 */
public class Solution001 {
    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);

        System.out.println(solution001.minDepth(root));
    }

    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        this.dft(root, 1);
        return this.minDepth;
    }

    private void dft(TreeNode root, int assumedLevel) {
        if (root != null) {
            this.minDepth = assumedLevel < this.minDepth ? assumedLevel : this.minDepth;
            dft(root.left, assumedLevel + 1);
            dft(root.right, assumedLevel + 1);
        } else {
            this.minDepth = assumedLevel - 1 < this.minDepth ? assumedLevel - 1 : this.minDepth;
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
 * 注意：本方案有问题尚未解决，请参考其它方案
 * 提示：再次面临DFT和BFT的选择。
 * 提示：感觉上BFT的效率高，但实际上并不一定——比如最短path出现在最后一层
 * 提示：选择好if条件，能让代码简化很多——尝试使用if(root.left!=null && root.right!=null)开始
 * 提示：此题也是“树的最深层级”解法，只需把'<'改成'>'
 * 坑，题眼：如何记录最小值——搞不好就永远记成0了。
 * 提示：本题是个经典的细致题，绝对适合练手
 * 提示：参数取名，不要叫level，而要叫“assumedLevel”
 *坏点：本题对“最短路径”的定义可能有问题——root只有left的时候，最短路径是1还是2？
 */