public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        boolean r = tree.insert(50, 50);
        System.out.println(r);
        r = tree.insert(20, 20);
        System.out.println(r);
        r = tree.insert(100, 100);
        System.out.println(r);
        r = tree.insert(10, 10);
        System.out.println(r);
        r = tree.insert(30, 30);
        System.out.println(r);
        r = tree.insert(80, 80);
        System.out.println(r);
        r = tree.insert(150, 150);
        System.out.println(r);
        r = tree.insert(40, 40);
        System.out.println(r);

        System.out.println(tree.find(40));
        System.out.println(tree.find(49));
    }
}