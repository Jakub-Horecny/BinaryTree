public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
//        boolean r = tree.insert(50, 50);
//        System.out.println(r);
//        r = tree.insert(20, 20);
//        System.out.println(r);
//        r = tree.insert(100, 100);
//        System.out.println(r);
//        r = tree.insert(10, 10);
//        System.out.println(r);
//        r = tree.insert(30, 30);
//        System.out.println(r);
//        r = tree.insert(80, 80);
//        System.out.println(r);
//        r = tree.insert(150, 150);
//        System.out.println(r);
//        r = tree.insert(40, 40);
//        System.out.println(r);
        tree.insert(8, 8);
        tree.insert(3, 3);
        tree.insert(10, 10);
        tree.insert(1, 1);
        tree.insert(6, 6);
        tree.insert(14, 14);
        tree.insert(4, 4);
        tree.insert(7, 7);
        tree.insert(13, 13);
        tree.inOrderPrint();
        int i = tree.delete(3);
        System.out.println("********************");
        tree.inOrderPrint();
        i = tree.delete(8);
        System.out.println("********************");
        tree.inOrderPrint();
        i = tree.delete(6);
        System.out.println("********************");
        tree.inOrderPrint();


        tree.inOrderPrint();
        System.out.println("********************");
        tree.levelOrderPrint();
        System.out.println("********************");
        tree.preOrderPrint();
        System.out.println("********************");
        tree.postOrderPrint();
    }
}