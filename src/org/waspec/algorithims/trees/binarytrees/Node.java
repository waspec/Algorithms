package org.waspec.algorithims.trees.binarytrees;

/**
 * Created by Timothy on 3/22/2015.
 */
public class Node {
    public Node(int payload) {
        this.payload = payload;
    }

    public Node() {
    }

    public int payload;
    public Node leftChild;
    public Node rightChild;
}
