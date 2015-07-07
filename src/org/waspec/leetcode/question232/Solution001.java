package org.waspec.leetcode.question232;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 */
public class Solution001 {
    public static void main(String[] args) {

    }
}

class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        this.stack = new Stack<Integer>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        this.stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!this.stack.isEmpty()){
            this.stack.remove(0);
        }
    }

    // Get the front element.
    public int peek() {
        return this.stack.get(0).intValue();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return this.stack.empty();
    }
}
