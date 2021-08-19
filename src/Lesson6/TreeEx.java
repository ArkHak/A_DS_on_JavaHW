package Lesson6;

public class TreeEx<ID extends Comparable<ID>> {

    private Node node = null;

    private class Node {
        private ID ID;
        private int value;
        private Node leftChild;
        private Node rightChild;
        private int heightLvlTree;
        private int size;

        Node(ID ID, int value, int size, int heightLvlTree) {
            this.ID = ID;
            this.value = value;
            this.size = size;
            this.heightLvlTree = heightLvlTree;
        }
    }

    void put(ID ID, int value) {
        node = put(ID, value, node);
    }

    private Node put(ID ID, int value, Node node) {
        if (ID == null) {
            throw new IllegalArgumentException();
        }

        if (node == null) {
            return new Node(ID, value, 1, 0);
        }

        int res = ID.compareTo(node.ID);
        if (res == 0) {
            node.value = value;
        } else if (res < 0) {
            node.leftChild = put(ID, value, node.leftChild);
        } else {
            node.rightChild = put(ID, value, node.rightChild);
        }

        node.size = size(node.leftChild) + size(node.rightChild) + 1;

        if (node.leftChild == null && node.rightChild == null) {
            node.heightLvlTree = 0;
        } else if (node.leftChild != null && node.rightChild == null) {
            node.heightLvlTree = node.leftChild.heightLvlTree + 1;
        } else if (node.leftChild == null) {
            node.heightLvlTree = node.rightChild.heightLvlTree + 1;
        } else if (node.leftChild.heightLvlTree > node.rightChild.heightLvlTree) {
            node.heightLvlTree = node.leftChild.heightLvlTree + 1;
        } else if (node.leftChild.heightLvlTree < node.rightChild.heightLvlTree) {
            node.heightLvlTree = node.rightChild.heightLvlTree + 1;
        } else {
            node.heightLvlTree = node.leftChild.heightLvlTree + 1;
        }

        return node;
    }

    boolean isBalanced() {
        if (node == null || node.size == 1) {
            return true;
        } else {
            int leftHeight;
            int rightHeight;

            if (node.leftChild == null) {
                leftHeight = 0;
            } else {
                leftHeight = node.leftChild.heightLvlTree;
            }

            if (node.rightChild == null) {
                rightHeight = 0;
            } else {
                rightHeight = node.rightChild.heightLvlTree;
            }
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
    }

    private boolean isEmpty() {
        return node == null;
    }

    public int size() {
        return node == null ? 0 : node.size;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    int height() {
        return height(node);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.heightLvlTree;
    }
}