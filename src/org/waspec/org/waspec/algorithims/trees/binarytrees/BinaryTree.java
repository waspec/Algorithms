package org.waspec.org.waspec.algorithims.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Timothy on 3/22/2015.
 */
public class BinaryTree {
    public static Node buildTree() {
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(4);
        root.leftChild.rightChild = new Node(5);
        root.rightChild.leftChild = new Node(6);
        root.rightChild.rightChild = new Node(7);

        return root;
    }

    // 有返回值，但性能稍有浪费的办法
    public static List<List<Node>> getAllPathsUseRecursion(Node root) {
        if (root == null) {
            return null; //空进空出，前后一致，减少麻烦
        }

        List<List<Node>> result = new ArrayList<List<Node>>();
        List<List<Node>> pathsFromLeftSubtree = getAllPathsUseRecursion(root.leftChild);
        List<List<Node>> pathsFromRightSubtree = getAllPathsUseRecursion(root.rightChild);
        if (pathsFromLeftSubtree != null) {
            result.addAll(pathsFromLeftSubtree);
        }

        if (pathsFromRightSubtree != null) {
            result.addAll(pathsFromRightSubtree);
        }

        // 题眼：使用seed或向路径头部插入
        if (result.size() == 0) {
            List<Node> seed = new ArrayList<Node>();
            seed.add(root);
            result.add(seed);
        } else {
            for (List<Node> path : result) {
                path.add(0, root);
            }
        }

        return result;
    }

    // 无返回值，使用参数承载结果，此参数并无“drill down”的功能，
    // 参数命名为pathBag比叫result效果要好得多
    // 用来保存结果的参数，传进去的时候不能为空！Java只有传值，形参是实参的copy，在方法体内new出的新对象是无法传出来的！
    public static void getAllPathsUseRecursion(List<List<Node>> pathBag, Node root) throws Exception {
        if (pathBag == null) {
            throw new Exception("Path bag cannot be null.");
        }

        if (root == null) {
            return; // 尽早检验参数合法性，尽早返回，避免把麻烦带处逻辑。如果这里不返回，下面生成seed的时候就会遇到麻烦。好习惯经常是不知不觉救你一命。
        }

        List<List<Node>> pathBagOfLeftSubtree = new ArrayList<List<Node>>();
        List<List<Node>> pathBagOfRightSubtree = new ArrayList<List<Node>>();
        getAllPathsUseRecursion(pathBagOfLeftSubtree, root.leftChild);
        getAllPathsUseRecursion(pathBagOfRightSubtree, root.rightChild);
        pathBag.addAll(pathBagOfLeftSubtree);
        pathBag.addAll(pathBagOfRightSubtree);

        // 题眼：seed或者向头部插入
        if (pathBag.size() == 0) {
            List<Node> path = new ArrayList<Node>();
            path.add(root);
            pathBag.add(path);
        } else {
            for (List<Node> path : pathBag) {
                path.add(0, root);
            }
        }
    }

    // pathBag和pathBase都是“穿墙”、“共用”的
    public static void getAllPathsUseBacktracking(List<List<Node>> pathBag, Stack<Node> pathBase, Node currentRoot) throws Exception {
        if (pathBag == null || pathBase == null) {
            throw new Exception("Path bag or path base cannot be null.");
        }

        pathBase.push(currentRoot);

        // 题眼：找到合法路径
        if (currentRoot.leftChild == null && currentRoot.rightChild == null) {
            pathBag.add(new ArrayList<Node>(pathBase)); // 最终结果的时候一定要new一个新对象（结果固化）！
        } else {
            if (currentRoot.leftChild!=null){
                getAllPathsUseBacktracking(pathBag, pathBase, currentRoot.leftChild);
            }

            if (currentRoot.rightChild!=null){
                getAllPathsUseBacktracking(pathBag, pathBase, currentRoot.rightChild);
            }
        }

        // 难点：为什么要pop()？pop()的位置？
        pathBase.pop();
    }
}
