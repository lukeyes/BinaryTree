package com.lukeyes;

import java.util.*;

public class TreePrinterClass {

    private class PrintHelperClass {
        int value;
        int leftSize;
        int rightSize;
    }

    private BinaryTree tree;
    int maxX = 0;
    char printArray[][];
    int width = 0;
    int depth = 0;

    public TreePrinterClass(BinaryTree tree) {
        this.tree = tree;
    }


    public void print() {

        Node head = tree.getHead();

        if(head == null) {
            return;
        }

        this.depth = maxDepth(head, 0);
        this.width = (int) (Math.pow(2,depth) - 1);

        System.out.println("Print matrix:" + width + "x" + depth);


        printArray = new char[width][depth];
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < depth; y++) {
                printArray[x][y] = ' ';
            }
        }

        // start at head
        /*
        int xPos = (int) (Math.pow(2,depth-1));
        printArray[xPos][0] = Character.forDigit(head.value, 10);

        if(head.left != null) {
            int xPos2 = (int)(Math.pow(2, depth-2));
            printArray[xPos2][1] = Character.forDigit(head.left.value,10);
        }
        if(head.right != null) {
            int xPos2 = xPos + (int)(Math.pow(2, depth-2));
            printArray[xPos2][1] = Character.forDigit(head.right.value,10);
        }
        */
        setPrintArray(head,this.depth,1,0);

        printPrintArray();


    }

    private int setPrintArray(Node node, int maxDepth, int currDepth, int xOffset) {
        if(node == null) {
            return -1;
        }

        int xPos = (int) (Math.pow(2,maxDepth-currDepth))-1;
        xPos += xOffset;
        printArray[xPos][currDepth-1] = Character.forDigit(node.value, 10);

        int leftPos = -1;
        int rightPos = -1;
        if(node.left != null) {
            leftPos = setPrintArray(node.left, maxDepth, currDepth+1, xOffset);
        }
        if(node.right != null) {
            rightPos = setPrintArray(node.right, maxDepth, currDepth+1, xPos+1);
       }

        boolean hasLeft = leftPos >= 0;
        boolean hasRight = rightPos >= 0;
        if(currDepth != maxDepth) {
            if(hasLeft || hasRight) {
                printArray[xPos][currDepth] = '+';
            }

            if(hasLeft) {
                int currX = leftPos + 1;
                while (currX < xPos) {
                    printArray[currX][currDepth] = '-';
                    currX++;
                }
            }
            if(hasRight) {
                int currX = xPos + 1;
                while (currX < rightPos) {
                    printArray[currX][currDepth] = '-';
                    currX++;
                }
            }
        }

        return xPos;

    }

    private void printPrintArray() {
        for(int y = 0; y < depth; y++) {
            for(int x= 0; x < width; x++) {
                System.out.print(printArray[x][y]);
            }
            System.out.println();
        }
    }

    private int maxDepth(Node node, int depth) {

        if(node == null)
            return depth;

        int leftDepth = maxDepth(node.left, depth+1);
        int rightDepth = maxDepth(node.right, depth + 1);
        if(leftDepth > rightDepth)
            return leftDepth;
        else
            return rightDepth;
    }
}
