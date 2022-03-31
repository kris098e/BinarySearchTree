/** 
 * Gruppe:
 * Philip Jos Rosenlund Andersen, Phand18@student.sdu.dk
 * Kristian Degn Abrahamsen, Krabr21@student.sdu.dk
 * Andreas Viby Jensen, Andje21@student.sdu.dk
 */

import java.util.ArrayList;

public class DictBinTree implements Dict {

    private BinNode root;

    public boolean search(int key) {
        return auxSearch(root, key);
    }
    private boolean auxSearch(BinNode node, int key) {
        if(node == null)
            return false;
        if(node.key == key)
            return true;
        if(key < node.key)
            return auxSearch(node.left, key);
        else return auxSearch(node.right, key);
    }

    public void insert(int key) {
        BinNode y = null;
        BinNode x = root;
        while(x != null) {
            y = x;
            if(key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        if(y == null)
            root = new BinNode(key);
        else if(key < y.key)
            y.left = new BinNode(key);
        else y.right = new BinNode(key);
    }

    public ArrayList<Integer> orderedTraversal() {
        ArrayList<Integer> list = new ArrayList<>();
        auxInorder(root, list);
        return list;
    }

    private void auxInorder(BinNode node, ArrayList<Integer> list) {
        if(node != null) {
            auxInorder(node.left, list);
            list.add(node.key);
            auxInorder(node.right, list);
        }
    }


    private static class BinNode {

        private int key;
        private BinNode left;
        private BinNode right;

        private BinNode(int data) {
            key = data;
        }
    }
}
