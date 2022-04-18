/** 
 * Gruppe:
 * Philip Jos Rosenlund Andersen, Phand18@student.sdu.dk
 * Kristian Degn Abrahamsen, Krabr21@student.sdu.dk
 * Andreas Viby Jensen, Andje21@student.sdu.dk
 */

import java.util.ArrayList;

public class DictBinTree implements Dict {

    // Pointer root, every method is done via the root-attribute
    private BinNode root;

    // Method for searching whether the specific key, given in the parameter of the function, is contained in the tree at the current state of the tree
    public boolean search(int key) {
        return auxSearch(root, key);
    }

    // Helper method for search. 
    private boolean auxSearch(BinNode node, int key) {
        // If in a leaf (null node), the key isnt contained in the tree
        if(node == null)
            return false;
        if(node.key == key)
            return true;
        // If key-value is less than current node-key-value, continue down left path to left child
        if(key < node.key)
            return auxSearch(node.left, key);
        // Else go right.
        else return auxSearch(node.right, key);
    }

    // Method for inserting a new key
    public void insert(int key) {
        // Temp-helper nodes for updating pointers
        BinNode y = null; 
        BinNode x = root; 

        // Looping down to a leaf
        while(x != null) {
            y = x;
            if(key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        if(y == null) // Case where root is null, we create the tree with the key
            root = new BinNode(key);
        else if(key < y.key) // Case where key is less than parent-node, left child is created to be a new node with the key-data 
            y.left = new BinNode(key);
        else y.right = new BinNode(key); // If not less or equal to parent-node, right child is created to be a new node with the key-data 
    }

    // Method returning an ArrayList list object containing Integer object, where the Integer objects are sorted by an inorder-traversal
    public ArrayList<Integer> orderedTraversal() {
        ArrayList<Integer> list = new ArrayList<>();
        auxInorder(root, list);
        return list;
    }

    // Helper method for adding elements to the ArrayList object given in the argument, in an inorder traversal recursivly
    private void auxInorder(BinNode node, ArrayList<Integer> list) {
        if(node != null) {
            auxInorder(node.left, list);
            list.add(node.key);
            auxInorder(node.right, list);
        }
    }

    // The node-class used for making the tree-structure
    private static class BinNode {

        private int key;
        private BinNode left;
        private BinNode right;

        private BinNode(int data) {
            key = data;
        }
    }
}
