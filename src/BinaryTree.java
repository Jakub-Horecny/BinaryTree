
public class BinaryTree<T, K extends Comparable<K>> {
    private Node<T, K> root;

    public BinaryTree() {
        this.root = null;
    }

    private boolean isRoot(Node<T, K> node){
        return (node.getParent() == null);
    }

    public T find(K key) {
        if (this.root == null) {
            return null;
        } else {
            Node<T, K> tempNode = this.root;
            do {
                if (key.compareTo(tempNode.getKey()) == 0){
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
}
