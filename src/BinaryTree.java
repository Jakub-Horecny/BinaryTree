import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

import exceptions.*;

public class BinaryTree<T, K extends Comparable<K>> {
    private Node<T, K> root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * true if this.root == node, false otherwise
     * @param node - tree node
     * @return true if node tree root
     */
    private boolean isRoot(Node<T, K> node) {
        return (node.getParent() == null);
    }

    /**
     * true if node has no sons, false otherwise
     * @param node - tree node
     * @return true if node is leaf
     */
    private boolean isLeaf(Node<T,K> node) {
        return (node.getLeftSon() == null && node.getRightSon() == null);
    }

    /**
     * true if node is a left son, false otherwise
     * @param node - tree node
     * @return true if node is left son
     */
    private boolean isLeftSon(Node<T,K> node) {
        return (node.getParent().getLeftSon() == node);
    }

    /**
     * true if node is a right son, false otherwise
     * @param node - tree node
     * @return true if node is right son
     */
    private boolean isRightSon(Node<T,K> node) {
        return (node.getParent().getRightSon() == node);
    }

    /**
     * true if node have a right son, false otherwise
     * @param node - tree node
     * @return true if node has right son
     */
    private boolean hasRightSon(Node<T,K> node) {
        return (node.getRightSon() != null);
    }

    /**
     * true if node have a left son, false otherwise
     * @param node - tree node
     * @return true if node has left son
     */
    private boolean hasLeftSon(Node<T,K> node) {
        return (node.getLeftSon() != null);
    }

    /**
     *  true if node have two sons, false otherwise
     * @param node - tree node
     * @return - true if node has only one son
     */
    public boolean hasTwoSons(Node<T,K> node) {
        return (this.hasLeftSon(node) && this.hasRightSon(node));
    }

    /**
     *  true if node have only one son, false otherwise
     * @param node - tree node
     * @return - true if node has only one son
     */
    public boolean hasOneSon(Node<T,K> node) {
        return (this.hasLeftSon(node) && !this.hasRightSon(node)
        || !this.hasLeftSon(node) && this.hasRightSon(node));
    }

    /**
     * true if tree is empty, false otherwise
     * @return true if tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return (this.root == null);
    }

    /**
     * prints tree inOrder traversal
     */
    public void inOrderPrint() {
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

    /**
     * returns ArrayList of tree items in inOrder traversal
     * @return ArrayList of tree items
     */
    public ArrayList<T> inOrder() {
        ArrayList<T> tempList = new ArrayList<>(); // data to be returned
        if (this.root == null){
            return tempList;
        }
        Stack<Node<T,K>> stack = new Stack<>();
        Node<T,K> tempNode = this.root;
        while(tempNode != null || stack.size() > 0){
            while(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.getLeftSon();
            }
            tempNode = stack.pop();
            tempList.add(tempNode.getData());
            tempNode = tempNode.getRightSon();
        }
        return tempList;
    }

    /**
     * prints tree preOrder traversal
     */
    public void preOrderPrint() {
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

    /**
     * returns ArrayList of tree items in preOrder traversal
     * @return ArrayList of tree items
     */
    public ArrayList<T> preOrder(){
        ArrayList<T> tempList = new ArrayList<>(); // data to be returned
        if(this.root == null){
            //T[] list = (T[])new Object[0];
            //tempList.toArray(list);
            return tempList;
        }
        Stack<Node<T,K>> stack = new Stack<>();
        Node<T,K> tempNode;
        stack.push(this.root);

        while(!stack.isEmpty()){
            tempNode = stack.pop();
            tempList.add(tempNode.getData());
            if (tempNode.getLeftSon() != null) {
                stack.push(tempNode.getLeftSon());
            }
            if (tempNode.getRightSon() != null) {
                stack.push(tempNode.getRightSon());
            }
        }

        return tempList;
    }

    /**
     * prints tree postOrder traversal
     */
    public void postOrderPrint(){
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

    /**
     * returns ArrayList of tree items in postOrder traversal
     * @return ArrayList of tree items
     */
    public ArrayList<T> postOrder() {
        ArrayList<T> tempList = new ArrayList<>(); // data to be returned
        if (this.root == null){
            return tempList;
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
                tempList.add(tempNode.getData()); // **********
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
        return tempList;
    }

    /**
     * prints tree levelOrder traversal
     */
    public void levelOrderPrint() {
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

    /**
     * returns ArrayList of tree items in levelOrder traversal
     * @return ArrayList of tree items
     */
    public ArrayList<T> levelOrder(){
        ArrayList<T> tempList = new ArrayList<>(); // data to be returned
        if (this.root == null){
            return tempList;
        }
        ArrayList<Node<T,K>> stack = new ArrayList<>();
        stack.add(this.root);
        tempList.add(this.root.getData());//*****
        do {
            int tempSize = stack.size();
            for (int i = 0; i < tempSize; i++) {
                Node<T,K> tempNode = stack.remove(0);
                if (tempNode.getLeftSon() != null) {
                    stack.add(tempNode.getLeftSon());
                    tempList.add(tempNode.getLeftSon().getData());//*****
                }
                if (tempNode.getRightSon() != null) {
                    stack.add(tempNode.getRightSon());
                    tempList.add(tempNode.getRightSon().getData());//*****
                }
            }
        } while (!stack.isEmpty());
        return tempList;
    }

    /**
     * finds node that is has key that is closest to minimum of interval
     * @param minKey - minimum of interval search
     * @param maxKey - maximum of interval search
     * @return key of interval start
     */
    // TO DO
    public K findIntervalStart(K minKey, K maxKey) {
        if (this.root == null) {
            return null;
        }
        // if minKey > maxKey
        if (minKey.compareTo(maxKey) > 0){
            K temp = maxKey;
            maxKey = minKey;
            minKey = temp;
        }
        // if interval start <= min key
        K intervalStart = this.minKey();
        if (minKey.compareTo(intervalStart) <= 0) {
            return intervalStart;
        }
        intervalStart = this.maxKey();
        if (minKey.compareTo(intervalStart) > 0) {
            return intervalStart;
        }

        Node<T,K> tempNode = this.root;
        intervalStart = maxKey;
        while(tempNode != null) {
            /*
            if (!this.isLeaf(tempNode)) {
                if (intervalStart.compareTo(tempNode.getKey()) > 0 && minKey.compareTo(tempNode.getKey()) < 0 ) {
                    intervalStart = tempNode.getKey();
                }
                if (minKey.compareTo(tempNode.getKey()) == 0) {
                    intervalStart = tempNode.getKey();
                    break;
                } else if (minKey.compareTo(tempNode.getKey()) > 0) {
                    if (tempNode.getRightSon() != null){
                        tempNode = tempNode.getRightSon();
                    } else {
                        return tempNode.getKey();
                    }
                } else {
                    if (tempNode.getLeftSon() != null) {
                        tempNode = tempNode.getLeftSon();
                    } else {
                        return tempNode.getKey();
                    }
                }
            } else {
                if (intervalStart.compareTo(tempNode.getKey()) > 0 && minKey.compareTo(tempNode.getKey()) < 0) {
                    intervalStart = tempNode.getKey();

                } else {
                    return tempNode.getKey();
                }
            }
            */
            if (!this.isLeaf(tempNode)){
                if (intervalStart.compareTo(tempNode.getKey()) > 0
                        && minKey.compareTo(tempNode.getKey()) < 0) {
                    intervalStart = tempNode.getKey();
                }
                if (tempNode.getKey() == minKey){
                    return tempNode.getKey();
                } else if (minKey.compareTo(tempNode.getKey()) < 0) {
                    tempNode = tempNode.getLeftSon();
                } else
                    tempNode = tempNode.getRightSon();
            } else {
                if (intervalStart.compareTo(tempNode.getKey()) > 0
                        && minKey.compareTo(tempNode.getKey()) < 0) {
                    intervalStart = tempNode.getKey();
                }
                if (tempNode.getKey() == minKey){
                    return tempNode.getKey();
                }
                break;
            }
        }
        return intervalStart;
    }

    /**
     * returns ArrayList<T> of all items that have: key >= minKey and key <= maxKey
     * @param minKey minimum key of interval
     * @param maxKey maximum key of interval
     * @return ArrayList<T> of items in interval
     */
    public ArrayList<T> intervalSearch(K minKey, K maxKey) {
        K minimalKey = this.findIntervalStart(minKey, maxKey); // finds minimal key
        ArrayList<T> tempList = new ArrayList<>(); // data to be returned
        if(minimalKey == null){
            return tempList;
        }

        Node<T,K> tempNode = this.findNode(minimalKey);
        while (tempNode != null){
            if (maxKey.compareTo(tempNode.getKey()) >= 0) {
                tempList.add(tempNode.getData());
                // System.out.println(tempNode.getData());
                //tempNode = tempNode.getRightSon();
            } else {
                break;
            }
            tempNode = this.findInOrderSuccessor(tempNode);
        }
        return tempList;
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

    /**
     * finds and return min key in tree
     * @return min key in tree
     */
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

    /**
     * finds and return max key in tree
     * @return max key in tree
     */
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

    /**
     * finds and return data of node with the lowest key in tree
     * @return data of node with the lowest key
     */
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

    /**
     * finds and return data of node with the lowest key in tree
     * @return data of node with the lowest key
     */
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

    /**
     * finds and node with the lowest key in tree
     * @return data of node with the lowest key
     */
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

    /**
     * finds and return node with the highest key in tree
     * @return node with the highest key
     */
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
    public Node<T,K> findNode(K key){
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
     * inserts a new node to binary tree
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
                if (key.compareTo(tempNode.getKey()) == 0) {
                    return false;
                } else if (key.compareTo(tempNode.getKey()) > 0) {
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
     * deletes a node of binary tree
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
            //nodeToDelete = null;
            return data;
        }
        if (!this.isLeaf(nodeToDelete)) {
            Node<T,K> successorNode = this.findNodeSuccessor(nodeToDelete);
            T data = nodeToDelete.getData();

            if (this.isLeaf(successorNode)){

                this.swapNodes(nodeToDelete, successorNode);

                if(this.isRoot(nodeToDelete)) {

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
                //successorNode = null;

            } else {
                if (this.isRoot(nodeToDelete)){
                    this.root.delete();
                    this.root = successorNode;
                    successorNode.setParent(null);
                } else {
                    successorNode.setParent(nodeToDelete.getParent());
                    if (this.isLeftSon(nodeToDelete)){
                        nodeToDelete.setLeftSon(successorNode);
                    } else {
                        nodeToDelete.setRightSon(successorNode);
                    }
                    successorNode.delete();
                    //successorNode = null;
                }

            }
            return data;
        }
        return null;
    }

    public T delete2(K key) {
        Node<T,K> nodeToDelete = this.findNode(key); // finds node with corresponding key
        // if item in tree do not exist
        if (nodeToDelete == null) {
            return null;
        }
        T data = nodeToDelete.getData();
        // if tree has only one item, delete root and all its references
        if (this.isRoot(nodeToDelete) && this.isLeaf(nodeToDelete)) {
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
            nodeToDelete.delete();
            //nodeToDelete = null;
            return data;
        }
        // if node has only one child
        if(this.hasOneSon(nodeToDelete)) {
            Node<T,K> tempNode;
            if (this.hasLeftSon(nodeToDelete)){
                tempNode = nodeToDelete.getLeftSon();
            } else {
                tempNode = nodeToDelete.getRightSon();
            }
            this.swapNodes(nodeToDelete, tempNode);
            // if delete node is root, set new root
            if (this.isRoot(nodeToDelete)) {
                this.root = tempNode;
                tempNode.setParent(null);
                nodeToDelete.delete();
                return data;
            } else {

            }
        }
        return null;
    }

    /**
     * different approach to find inOrder successor for tree node
     * using ArrayDeque
     * @param node - node for inOrder successor
     * @return node that is inOrder successor for given node
     */
    private Node<T,K> inOrderSuccessor2(Node<T,K> node){
        Node<T,K> tempNode = this.root;
        Deque<Node<T,K>> stack = new ArrayDeque<>();
        while(tempNode != null || !stack.isEmpty()){
            while(tempNode != null){
                stack.push(tempNode);
                tempNode = tempNode.getLeftSon();
            }
            tempNode = stack.pop();
            if(tempNode.getKey().compareTo(node.getKey()) > 0)
                return tempNode;
            tempNode = tempNode.getRightSon();
        }
        return null;
    }

    /**
     * returns inOrder successor for given node
     * @param node - node for inOrder successor
     * @return node that is inOrder successor for given node
     */
    public Node<T,K> findInOrderSuccessor(Node<T,K> node) {
        Node<T,K> successor = null;
        if (this.hasRightSon(node)){
            successor = node.getRightSon();
            while (this.hasLeftSon(successor)) {
                successor = successor.getLeftSon();
            }
            return successor;
        }

        Node<T,K> tempNode = this.root;
        while (tempNode != null)
        {
            if (node.getKey().compareTo(tempNode.getKey()) < 0) {
                successor = tempNode;
                tempNode = tempNode.getLeftSon();
            } else if (node.getKey().compareTo(tempNode.getKey()) > 0)
                tempNode = tempNode.getRightSon();
            else
                break;
        }
        return successor;
    }

    /**
     * Left rotation around the given node
     * @param node - node to rotate around
     */
    public void leftRotation(Node<T,K> node){
        if (node.getRightSon() == null) {
            return;
        }
        Node<T,K> oldRight = node.getRightSon();
        node.setRightSon(oldRight.getLeftSon());
        if (this.isRoot(node)){
            this.root = oldRight;
        } else if (this.isLeftSon(node)) {
            node.getParent().setLeftSon(oldRight);
        } else {
            node.getParent().setRightSon(oldRight);
        }
        oldRight.setLeftSon(node);
    }

    /**
     * Right rotation around the given node
     * @param node - node to rotate around
     */
    public void rightRotation(Node<T,K> node){
        if (node.getLeftSon() == null) {
            return;
        }
        Node<T, K> oldLeft = node.getLeftSon();
        node.setLeftSon(oldLeft.getRightSon());
        if (this.isRoot(node)) {
            this.root = oldLeft;

        } else if (this.isLeftSon(node)){
            node.getLeftSon().setLeftSon(oldLeft);
        } else {
            node.getParent().setRightSon(oldLeft);
        }
        oldLeft.setRightSon(node);
    }

    /**
     * Swaps keys and values of two given nodes
     * @param node1 - first node
     * @param node2 - second node
     */
    private void swapNodes(Node<T,K> node1, Node<T,K> node2){
        T tempData = node1.getData();
        K tempKey = node1.getKey();

        node1.setData(node2.getData());
        node1.setKey(node2.getKey());

        node2.setData(tempData);
        node2.setKey(tempKey);
    }
}
