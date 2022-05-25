import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Stack;

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
        return (node.getParent().getLeftSon() == node);
    }
    private boolean isRightSon(Node<T,K> node) {
        return (node.getParent().getRightSon() == node);
    }

    private boolean hasRightSon(Node<T,K> node) {
        return (node.getRightSon() != null);
    }

    private boolean hasLeftSon(Node<T,K> node) {
        return (node.getLeftSon() != null);
    }

    public void inOrder() {
        if (this.root == null){
            return;
        }
        Stack<Node<T,K>> stack = new Stack<>();
        Node<T,K> tempNode = this.root;
        while(tempNode != null || stack.size() > 0){
            while(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.getLeftSon();
            }
            tempNode = stack.pop();
            System.out.println(tempNode.getData());
            tempNode = tempNode.getRightSon();
        }
    }

    public void preOrder() {
        if (this.root == null) {
            return;
        }
        Stack<Node<T,K>> stack = new Stack<>();
        Node<T,K> tempNode;
        stack.push(this.root);

        while(!stack.isEmpty()){
            tempNode = stack.pop();
            System.out.println(tempNode.getData());
            if (tempNode.getLeftSon() != null) {
                stack.push(tempNode.getLeftSon());
            }
            if (tempNode.getRightSon() != null) {
                stack.push(tempNode.getRightSon());
            }
        }
    }

    public void postOrder(){
        if (this.root == null){
            return;
        }
        Stack<Node<T,K>> stack = new Stack<>();
        Node<T,K> tempNode;
        Node<T,K> head = this.root;
        boolean finished;

        stack.push(this.root);

        while(!stack.isEmpty()) {
            tempNode = stack.peek();
            finished = (tempNode.getRightSon() == head ||
                        tempNode.getLeftSon() == head);

            if (this.isLeaf(tempNode) || finished) {
                stack.pop();
                System.out.println(tempNode.getData());
                head = tempNode;

            } else {
                if (tempNode.getRightSon() != null) {
                    stack.push(tempNode.getRightSon());
                }
                if (tempNode.getLeftSon() != null) {
                    stack.push(tempNode.getLeftSon());
                }
            }
        }
    }

    public void levelOrder() {
        if (this.root == null){
            return;
        }
        ArrayList<Node<T,K>> stack = new ArrayList<>();
        stack.add(this.root);
        System.out.println(this.root.getData());
        do {
            int tempSize = stack.size();
            for (int i = 0; i < tempSize; i++) {
                Node<T,K> tempNode = stack.remove(0);
                if (tempNode.getLeftSon() != null) {
                    stack.add(tempNode.getLeftSon());
                    System.out.println(tempNode.getLeftSon().getData());
                }
                if (tempNode.getRightSon() != null) {
                    stack.add(tempNode.getRightSon());
                    System.out.println(tempNode.getRightSon().getData());
                }
            }
        } while (!stack.isEmpty());
    }
    // TO DO
    private K findIntervalStart(K minKey, K maxKey){
        K intervalStart = maxKey;
        Node<T,K> tempNode = this.root;
        while(tempNode != null) {
            if (!this.isLeaf(tempNode)) {
                if (intervalStart.compareTo(tempNode.getKey()) > 0){
                    intervalStart = tempNode.getKey();
                }
                if (minKey.compareTo(tempNode.getKey()) == 0){
                    intervalStart = tempNode.getKey();
                    break;
                } else if (minKey.compareTo(tempNode.getKey()) > 0) {
                    tempNode = tempNode.getRightSon();
                } else {
                    tempNode = tempNode.getLeftSon();
                }
            } else {
                if (intervalStart.compareTo(tempNode.getKey()) > 0){
                    System.out.println();
                }
            }

        }
        return intervalStart;
    }

    public void intervalSearch(K minKey, K maxKey){
        // TO DO
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

    /**
     * returns depth of binary tree
     * @return depth of binary tree
     */
    public int treeDepth() {
        int depth = 0;
        if (this.root == null){
            return depth;
        }
        Stack<Node<T,K>> stack = new Stack<>();
        stack.push(this.root);
        do {
            int tempSize = stack.size();
            for (int i = 0; i < tempSize; i++) {
                Node<T,K> tempNode = stack.pop();
                if (tempNode.getLeftSon() != null){
                    stack.push(tempNode.getLeftSon());
                }
                if (tempNode.getRightSon() != null){
                    stack.push(tempNode.getRightSon());
                }
            }
            depth ++;
        } while (!stack.isEmpty());

        return depth;
    }

    /**
     * finds item in binary tree
     * @param key - key of node
     * @return value of node, null if node does not exists
     */
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

    /**
     * finds and returns node of binary tree
     * @param key - node key
     * @return node with corresponding key, null if node does not exist
     */
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

    /**
     * inserts new node to binary tree
     * @param data - node data
     * @param key - node key
     * @return true if successful, otherwise false
     */
    public boolean insert(T data, K key) {
        // if tree is empty
        if (this.root == null) {
            this.root = new Node<>(data, key, null);
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

    /**
     * deletes node of binary tree
     * @param key - key of node
     * @return value of deleted node or null if tree is empty
     */
    public T delete(K key) {
        Node<T,K> nodeToDelete = this.findNode(key);
        if (nodeToDelete == null) {
            return null;
        }
        // if tree has only one item, delete root and all its references
        if (this.isRoot(nodeToDelete) && this.isLeaf(nodeToDelete)) {
            T data = nodeToDelete.getData();
            nodeToDelete.delete();
            this.root = null;
            return data;
        }
        // if node is leaf, just delete leaf and all its references
        if (this.isLeaf(nodeToDelete)) {
            if (this.isLeftSon(nodeToDelete)) {
                nodeToDelete.getParent().setLeftSon(null);
            } else {
                nodeToDelete.getParent().setRightSon(null);
            }
            T data = nodeToDelete.getData();
            nodeToDelete.delete();
            nodeToDelete = null;
            return data;
        }
        if (!this.isLeaf(nodeToDelete)) {
            Node<T,K> successorNode = this.findNodeSuccessor(nodeToDelete);
            T data = nodeToDelete.getData();
            this.swapNodes(nodeToDelete, successorNode);
            if (this.isRoot(nodeToDelete)) {

                if (this.isLeftSon(successorNode)) {
                    successorNode.getParent().setLeftSon(null);
                } else {
                    successorNode.getParent().setRightSon(null);
                }

            } else if (this.isLeftSon(successorNode)) {
                successorNode.getParent().setLeftSon(null);
            } else {
                successorNode.getParent().setRightSon(null);
            }
            successorNode.delete();
            successorNode = null;
            return data;
        }
        return null;
    }

    /**
     * finds inOrder or preOrder successor for node
     * @param node - node for which successor is sought
     * @return successor node
     */
    private Node<T,K> findNodeSuccessor(Node<T,K> node) {
        Node<T,K> tempNode = node;
        if (tempNode.getLeftSon() != null) {
            tempNode = tempNode.getLeftSon();
            while(tempNode.getRightSon() != null){
                tempNode = tempNode.getRightSon();
            }
        } else {
            tempNode = tempNode.getRightSon();
            while(tempNode.getLeftSon() != null){
                tempNode = tempNode.getLeftSon();
            }
        }
        return tempNode;
    }

    private void swapNodes(@NotNull Node<T,K> node1, @NotNull Node<T,K> node2){
        T tempData = node1.getData();
        K tempKey = node1.getKey();

        node1.setData(node2.getData());
        node1.setKey(node2.getKey());

        node2.setData(tempData);
        node2.setKey(tempKey);
    }
}
