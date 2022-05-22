public class Node<T, K extends Comparable<K>>{
    private K key;
    private T data;
    private Node<T, K> leftSon;
    private Node<T, K>  rightSon;
    private Node<T, K>  parent;

    public Node(T data, K key, Node<T, K> parent) {
        this.key = key;
        this.data = data;
        this.leftSon = null;
        this.rightSon = null;
        this.parent = parent;
    }

    public K getKey() { return this.key; }
    public T getData() { return this.data; }
    public Node<T, K> getLeftSon() { return this.leftSon; }
    public Node<T, K> getRightSon() { return this.rightSon; }
    public Node<T, K> getParent() { return this.parent; }

    public void setKey(K key) { this.key = key; }
    public void setData(T data) { this.data = data; }
    public void setLeftSon(Node<T, K> leftSon) { this.leftSon = leftSon; }
    public void setRightSon(Node<T, K> rightSon) { this.rightSon = rightSon; }
    public void setParent(Node<T, K> parent) { this.parent = parent; }
}

