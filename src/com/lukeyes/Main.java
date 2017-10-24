package com.lukeyes;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = getRandomIntegers();//getIntegers();

        for(Integer value : set) {
            System.out.print(value + " ");
        }
        System.out.println();


        BinaryTree tree = new BinaryTree(set);
        TreePrinterClass printerClass = new TreePrinterClass(tree);
        printerClass.print();

    }

    private static Set<Integer> getIntegers() {
        Set<Integer> set = new LinkedHashSet<Integer>();
        //5 2 6 3 7 4 9 1 8
        set.add(5);
        set.add(2);
        set.add(6);
        set.add(3);
        set.add(7);
        set.add(4);
        set.add(9);
        set.add(1);
        set.add(8);
        return set;
    }

    private static Set<Integer> getRandomIntegers() {
        Random random = new Random();

        int bound = 9;

        int length = 9; //random.nextInt(bound) + 1;
        Set<Integer> set = new LinkedHashSet<Integer>();

        System.out.println("Length - " + length);

        for(int i = 0; i < length; i++) {

            boolean isAdded = false;
            int newValue = 0;
            while(!isAdded) {
                newValue = random.nextInt(bound) + 1;
                isAdded = set.add(newValue);
            }

            System.out.print(newValue + " ");
        }

        System.out.println();
        return set;
    }
}
