import exceptions.EmptyTreeException;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private final int[] treeList;
    private final int[] itemToFind;
    private final int[] itemToInsert;
    private final int minKey;
    private final int maxKey;

    BinaryTreeTest() {
        this.minKey = 0;
        this.maxKey = 900;

        this.treeList = new int[]{20, 5, 3, 15, 23, 26, 7, 8, 9,
                50, 90, 99, 1, 2, 100, 200, 42, 69, 24, 34, 44, 54, this.maxKey, this.minKey};
        this.itemToFind = Arrays.copyOfRange(this.treeList, 0, 5);
        this.itemToInsert = new int[]{300,30,39,500,101};
    }

    @Test
    void treeDepthShouldBe10() {
        int depth = 10;
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i = 0; i < depth; i++) {
            tree.insert(i,i);
        }
        assertEquals(depth, tree.treeDepth());
    }

    @Test
    void treeDepthShouldBe20() {
        int depth = 10;
        int[] list = {20,5,3,15,23,26,7,8,9,50,90,99,1,2,100,200,42,69};
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i = 0; i < depth; i++) {
            tree.insert(list[i],list[i]);
        }
        assertEquals(depth, tree.treeDepth());
    }

    @Test
    void minKey() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i: this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.minKey, tree.minKey());
    }

    @Test
    void maxKey() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.maxKey, tree.maxKey());
    }

    @Test
    void minValue() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i: this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.minKey, tree.minValue());
    }

    @Test
    void maxValue() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.maxKey, tree.maxValue());
    }

    @Test
    void minNode() {
    }

    @Test
    void maxNode() {
    }

    @Test
    void inOrderTreeTraversal(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
            tempList.add(i);
        }
        Collections.sort(tempList);
        assertEquals(tempList,tree.inOrder());
    }

    @Test
    void find() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        for (int i = 0; i < this.itemToFind.length; i++) {
            assertEquals(this.itemToFind[i], tree.find(this.treeList[i]));
        }
    }

    @Test
    void insertAllItemToTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        for (int item :this.itemToInsert) {
            assertTrue(tree.insert(item, item));
        }
    }

    @Test
    void itemWithSameKeyWillNotBeInserted(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(50,50);
        assertFalse(tree.insert(50,50));
    }

    @Test
    void itemWithSameKeyWillNotBeInserted2() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for(int item: this.treeList){
            tree.insert(item,item);
        }
        assertFalse(tree.insert(this.treeList[0],this.treeList[0]));
    }

    @Test
    void deleteAllItemInTree() {
        ArrayList<Integer> stack = new ArrayList<>();
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int item: this.treeList) {
            stack.add(item);
            tree.insert(item, item);
        }
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            assertEquals(stack.get(i), tree.delete(stack.get(i)));
            System.out.println("Deleted item:" + stack.get(i));
            System.out.println(tree.inOrder());
            System.out.println(tree.inOrder().size());
            System.out.println("*************************");
            stack.remove(i);
        }
    }

    @Test
    void deleteAllItemInTree2() {
        int[] arr = {50,20,80,10,30,70,100,1,15,31,35,65,75,150};
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int item: arr) {
            tree.insert(item,item);
        }
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[i], tree.delete(arr[i]));
            System.out.println("Deleted item:" + arr[i]);
            System.out.println(tree.inOrder());
            System.out.println(tree.inOrder().size());
            System.out.println("*************************");
        }



    }

    @Test
    void leftRotation() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
//        tree.insert(5,5);
//        tree.insert(3,3);
//        tree.insert(6,6);
//        tree.insert(2,2);
//        tree.insert(4,4);
//        tree.insert(7,7);
//        tree.insert(1,1);
//        Node<Integer, Integer> tempNode = tree.findNode(3);
        tree.insert(42,42);
        tree.insert(16,16);
        tree.insert(58,58);
        tree.insert(8,8);
        tree.insert(25,25);
        tree.insert(49,49);
        tree.insert(62,62);
        Node<Integer, Integer> tempNode = tree.findNode(49);
        tree.leftRotation(tempNode);
        tree.inOrderPrint();
    }

    @Test
    void rightRotation() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(50,50);
        tree.insert(31,31);
        tree.insert(10,10);
        tree.insert(40,40);
        tree.insert(69,69);
        tree.insert(57,57);
        tree.insert(90,90);
        tree.insert(58,58);
        tree.insert(99,99);
        Node<Integer, Integer> tempNode = tree.findNode(69);
        tree.rightRotation(tempNode);
        tree.inOrderPrint();
    }

    @Test
    void findIntervalStart() throws EmptyTreeException {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(50,50);
        tree.insert(31,31);
        tree.insert(10,10);
        tree.insert(40,40);
        tree.insert(69,69);
        tree.insert(57,57);
        tree.insert(90,90);
        tree.insert(58,58);
        tree.insert(99,99);
        System.out.println(tree.findIntervalStart(20,99));
        System.out.println(tree.findIntervalStart(89,99));
        System.out.println(tree.findIntervalStart(58,99));
        System.out.println(tree.findIntervalStart(100,150));
    }

    @Test
    void findIntervalStart2() throws EmptyTreeException {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int item: this.treeList) {
            tree.insert(item, item);
        }
        System.out.println(Arrays.toString(this.treeList));

        System.out.println(tree.findIntervalStart(20,99));
        System.out.println(tree.findIntervalStart(89,99));
        System.out.println(tree.findIntervalStart(58,99));
        System.out.println(tree.findIntervalStart(100,150));
    }

    /**
     * Test for interval search
     */
    @Test
    void intervalSearch() {
        int minInterval = 10000;
        int maxInterval = 500000;
        int min = 0;
        int max = 1000000;
        int key = 0;
        int minKey = max;

        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            key = min + (int)(Math.random() * ((max - min) + 1));
            boolean b = tree.insert(key, key);
            if (b) {
                tempList.add(key);
                if (key < minKey && key >= minInterval){
                    minKey = key;
                }
            }
        }
        System.out.println(minKey);
        //ArrayList<Integer> resultList = tree.intervalSearch(minInterval, maxInterval);

        ArrayList<Integer> tempList2 = new ArrayList<>();
        for (int i = 0; i < tempList.size(); i++) {
            int temp = tempList.get(i);
            if (temp <= maxInterval && temp >= minInterval){
                tempList2.add(temp);
            }
        }
        Collections.sort(tempList2);
        System.out.println(tempList2);
        assertEquals(tempList2, tree.intervalSearch(minInterval, maxInterval));

    }
}