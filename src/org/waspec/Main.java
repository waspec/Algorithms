package org.waspec;

import org.waspec.org.waspec.algorithims.trees.binarytrees.BinaryTree;
import org.waspec.org.waspec.algorithims.trees.binarytrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

    }

    // Get all path of binary tree use Backtracking
    public static void test001(){
        Node root = BinaryTree.buildTree();
        List<List<Node>> result = new ArrayList<List<Node>>();
        Stack<Node> pathBase = new Stack<Node>();
        try {
            BinaryTree.getAllPathsUseBacktracking(result, pathBase, root);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (List<Node> path : result) {
            for (Node node : path) {
                System.out.print(node.payload);
                System.out.print("->");
            }

            System.out.println();
        }
    }
}

/***********************
 *Package Name Convention
 *1. LeetCode的题为：         org.waspec.leetcode.question###
 *2. 市面上的老题/新题：      org.waspec.jobmarket.question###
 *3. 经典算法、理论研究：      org.waspec.algorithms.xxx
 *
 ************************/