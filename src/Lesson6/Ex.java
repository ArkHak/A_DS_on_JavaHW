package Lesson6;

import java.util.concurrent.ThreadLocalRandom;

public class Ex {

    public static void main(String[] args) {
        int countsTrees = 20;

        int balancedTree = 0;
        for (int i = 0; i < countsTrees; i++) {
            TreeEx<Integer> tree = new TreeEx<>();
            fillTree(tree);
            if (tree.isBalanced()) {
                balancedTree++;
            }
        }
        System.out.println("Создано: " + countsTrees + " деревьев.\n" +
                "Сбалансированных: " + balancedTree + ".\n" +
                "Несбалансированных: " + (countsTrees - balancedTree) + " (" +
                ((((float) (countsTrees - balancedTree)) * 100) / (float) countsTrees) + " %).");
    }

    private static void fillTree(TreeEx<Integer> Tree) {
        while (Tree.height() < 6) {
            int insertItem = ThreadLocalRandom.current().nextInt(-100, 100);
            Tree.put(insertItem, insertItem);
        }
    }
}