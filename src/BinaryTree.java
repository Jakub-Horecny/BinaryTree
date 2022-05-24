import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BinaryTree<T, K extends Comparable<K>> {
    private Node<T, K> root;

    public BinaryTree() {
        this.root = null;
    }

    private boolean isRoot(@NotNull Node<T, K> node) {
        return (node.getParent() == null);
    }

    private boolean isLeaf(@NotNull Node<T,K> node) {
        return (node.getLeftSon() == null && node.getRightSon() == null);
    }
    private boolean isLeftSon(Node<T,K> node) {
        return (node.getParent().getLeftSon() != null);
    }
    private boolean isRightSon(Node<T,K> node) {
        return (node.getParent().getRightSon() != null);
    }

    private boolean hasRightSon(Node<T,K> node) {
        return (node.getRightSon() != null);
    }

    private boolean hasLeftSon(Node<T,K> node) {
        return (node.getLeftSon() != null);
    }

    public K minKey() {
        if (this.root == null){
            return null;
        }
        Node<T,K> tempNode = this.root;
        while (tempNode.getLeftSon() != null) {
            tempNode = tempNode.getLeftSon();
        }
        return tempNode.getKey();
    }

    public K maxKey() {
        if (this.root == null){
            return null;
        }
        Node<T,K> tempNode = this.root;
        while (tempNode.getRightSon() != null){
            tempNode = tempNode.getRightSon();
        }
        return tempNode.getKey();
    }

    public T minValue(){
        if (this.root == null){
            return null;
        }
        Node<T,K> tempNode = this.root;
        while (tempNode.getLeftSon() != null) {
            tempNode = tempNode.getLeftSon();
        }
        return tempNode.getData();
    }

    public T maxValue(){
        if (this.root == null){
            return null;
        }
        Node<T,K> tempNode = this.root;
        while (tempNode.getRightSon() != null) {
            tempNode = tempNode.getRightSon();
        }
        return tempNode.getData();
    }

    public Node<T,K> minNode(){
        if (this.root == null){
            return null;
        }
        Node<T,K> tempNode = this.root;
        while (tempNode.getLeftSon() != null) {
            tempNode = tempNode.getLeftSon();
        }
        return tempNode;
    }

    public Node<T,K> maxNode(){
        if (this.root == null){
            return null;
        }
        Node<T,K> tempNode = this.root;
        while (tempNode.getRightSon() != null) {
            tempNode = tempNode.getRightSon();
        }
        return tempNode;
    }

    public int treeDepth() {
        int depth = 0;
        if (this.root == null){
            return depth;
        }
        ArrayList<Node<T,K>> stack = new ArrayList<>();
        stack.add(this.root);
        do {
            int tempSize = stack.size();
            for (int i = 0; i < tempSize; i++) {
                Node<T,K> tempNode = stack.remove(0);
                if (tempNode.getLeftSon() != null){
                    stack.add(tempNode.getLeftSon());
                }
                if (tempNode.getRightSon() != null){
                    stack.add(tempNode.getRightSon());
                }
            }
            depth ++;
        } while (!stack.isEmpty());

        return depth;
    }

    public T find(K key) {
        if (this.root == null) {
            return null;
        } else {
            Node<T, K> tempNode = this.root;
            do {
                if (key.compareTo(tempNode.getKey()) == 0) {
                    return tempNode.getData();
                } else if (key.compareTo(tempNode.getKey()) > 0) {
                    tempNode = tempNode.getRightSon();
                } else {
                    tempNode = tempNode.getLeftSon();
                }
            } while (tempNode != null);
        }
        return null;
    }
    private Node<T,K> findNode(K key){
        if (this.root == null) {
            return null;
        } else {
            Node<T, K> tempNode = this.root;
            do {
                if (key.compareTo(tempNode.getKey()) == 0){
                    return tempNode;
                } else if (key.compareTo(tempNode.getKey()) > 0) {
                    tempNode = tempNode.getRightSon();
                } else {
                    tempNode = tempNode.getLeftSon();
                }
            } while (tempNode != null);
        }
        return null;
    }

    public boolean insert(T data, K key) {
        if (this.root == null) {
            this.root = new Node<>(data, key, null);
            //this.root = new Node<>(data, key, null);
            return true;
        } else {
            Node<T, K> tempNode = this.root;
            do {
                if (key.compareTo(tempNode.getKey()) > 0) {
                    if (tempNode.getRightSon() == null){
                        tempNode.setRightSon(new Node<>(data, key, tempNode));
                        return true;
                    } else {
                        tempNode = tempNode.getRightSon();
                    }
                } else if (key.compareTo(tempNode.getKey()) < 0) {
                    if (tempNode.getLeftSon() == null){
                        tempNode.setLeftSon(new Node<>(data, key, tempNode));
                        return true;
                    } else {
                        tempNode = tempNode.getLeftSon();
                    }
                }
            }
            while(tempNode != null);
        }
        return false;
    }

    public Node<T,K> delete(K key) {
        Node<T,K> nodeToDelete = this.findNode(key);
        if (nodeToDelete == null){
            return null;
        }
        if (this.isRoot(nodeToDelete) && this.isLeaf(nodeToDelete)){
            this.root = null;
            return nodeToDelete;
        }
        if (this.isLeaf(nodeToDelete)) {
            
            return nodeToDelete;
        }
        return null;
    }
}
