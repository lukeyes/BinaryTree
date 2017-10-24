package com.lukeyes;

import java.util.*;

public class BinaryTree {

    private Node head = null;

    public BinaryTree() {

    }

    public BinaryTree(Set<Integer> values) {

        for(Integer value : values) {

            // insert value
            if(head == null) {
                Node n = new Node(value);
                head = n;
            } else {
                insert(head, value);
            }
        }
    }

    public Node getHead() { return this.head; }

    public void print() {
        printInFix(this.head);
    }

    private void printInFix(Node node) {
        if(node == null)
            return;

        printInFix(node.left);
        System.out.print(node.value + " ");
        printInFix(node.right);
    }

    private void printPreFix(Node node) {
        if(node == null)
            return;

        System.out.print(node.value + " ");
        printPreFix(node.left);
        printPreFix(node.right);
    }

    private void printPostFix(Node node) {
        if(node == null)
            return;

        printPostFix(node.left);
        printPostFix(node.right);

        System.out.print(node.value + " ");
    }

    private void insert(Node parent, int value) {

        if(value < parent.value) {
            // go left
            if(parent.left == null) {
                Node n = new Node(value);
                parent.left = n;
            } else {
                insert(parent.left, value);
            }

        } else {
            // go right
            if(parent.right == null) {
                Node n = new Node(value);
                parent.right = n;
            } else {
                insert(parent.right, value);
            }
        }
    }
}
