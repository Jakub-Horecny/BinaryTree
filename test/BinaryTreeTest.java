import org.junit.jupiter.api.Test;

import javax.management.openmbean.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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

    /**
     *
     */
    @Test
    void treeDepthShouldBe10() {
        int depth = 10;
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i = 0; i < depth; i++) {
            tree.insert(i,i);
        }
        assertEquals(depth, tree.depth());
    }

    /**
     *
     */
    @Test
    void minKey() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i: this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.minKey, tree.minKey());
    }

    /**
     *
     */
    @Test
    void maxKey() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.maxKey, tree.maxKey());
    }

    /**
     *
     */
    @Test
    void minValue() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i: this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.minKey, tree.minValue());
    }

    /**
     *
     */
    @Test
    void maxValue() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        assertEquals(this.maxKey, tree.maxValue());
    }

    /**
     *
     */
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

    /**
     *
     */
    @Test
    void findAllItemsInTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        for (int i = 0; i < this.itemToFind.length; i++) {
            assertEquals(this.itemToFind[i], tree.find(this.treeList[i]));
        }
    }

    /**
     * find should throw an InvalidKeyException exception, because tree is empty
     */
    @Test
    void findShouldThrowException(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        assertThrowsExactly(InvalidKeyException.class,
                () -> tree.find(10)
        );
    }

    /**
     * find should throw an InvalidKeyException exception, because tree does not contain an item
     */
    @Test
    void findShouldThrowException2(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int item : this.treeList) {
            tree.insert(item, item);
        }
        assertThrowsExactly(InvalidKeyException.class,
                () -> tree.find(this.maxKey+1)
        );
    }

    /**
     *  inserting item with same key should throw an IllegalArgumentException exception
     */
    @Test
    void itemWithSameKeyShouldNotBeInserted(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        assertThrowsExactly(IllegalArgumentException.class, () ->
            tree.insert(10,10)
        );
    }


    /**
     *
     */
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
    /**
     * Test for interval search
     */
    @Test
    void intervalSearch() {
        int minInterval = 10000;
        int maxInterval = 500000;
        int min = 0;
        int max = 1000000;
        int key;
        int treeSize = 100000;
        boolean b;

        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        ArrayList<Integer> tempList = new ArrayList<>(treeSize);
        //tree.insert(maxInterval,maxInterval);
        //tree.insert(minInterval,minInterval);

        //tempList.add(maxInterval);
        //tempList.add(minInterval);
        for (int i = 0; i < treeSize; i++) {
            key = min + (int)(Math.random() * ((max - min) + 1));
            try {
                b = tree.insert(key, key);
                if (b) {
                    //if (key >= minInterval && key <= maxInterval) {
                        tempList.add(key);
                    //}
                }
            } catch (IllegalArgumentException ignored) {
            }
        }
        ArrayList<Integer> tempList2 = new ArrayList<>();

        for (int item : tempList) {
            if (item <= maxInterval && item >= minInterval) {
                tempList2.add(item);
            }
        }
        ArrayList<Integer> t = tree.intervalSearch(minInterval, maxInterval);
        Collections.sort(tempList2);
        //System.out.println(tempList2.get(tempList2.size()-1));
        //System.out.println(t.get(t.size()-1));

        assertEquals(tempList2, t);
    }

    /**
     * true if tree is empty
     */
    @Test
    void treeShouldBeEmpty(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        assertTrue(tree.isEmpty());
    }

    /**
     * false if tree is not empty
     */
    @Test
    void treeShouldNotBeEmpty(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(this.minKey,this.minKey);
        assertFalse(tree.isEmpty());
    }
    @Test
    void treeSize(){
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for(int item: this.treeList){
            tree.insert(item,item);
        }
        // System.out.println(this.treeList.length);
        // System.out.println(tree.size());
        assertEquals(this.treeList.length, tree.size());
    }

    /**
     * should delete all item from the tree
     * at the end tree should be empty
     */
    @Test
    void deleteAllItemFromTree(){
        int item;
        boolean b;
        int treeSize = 100000;

        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < treeSize; i++) {
            item = r.nextInt();
            try {
                b = tree.insert(item, item);
                if (b) {
                    tempList.add(item);
                }
            } catch (IllegalArgumentException ignored) {
            }
        }
        //System.out.println(tree.inOrder().size());
        //System.out.println(tempList.size());
        int tempSize = tempList.size();
        for (int i = 0; i < tempSize; i++) {
            tree.delete(tempList.get(0));
            //System.out.println(j);
            tempList.remove(0);
        }
        //System.out.println(tree.inOrder().size());
        //System.out.println(tempList.size());
        assertTrue(tree.isEmpty());
    }

    /**
     * delete should throw an exception because tree is empty
     */
    @Test
    void deleteShouldThrowExceptionBecauseTreeIsEmpty() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        assertThrowsExactly(InvalidKeyException.class, () ->
                tree.delete(this.minKey)
        );
    }

    /**
     * there is only one item in tree
     * item should be deleted
     */
    @Test
    void shouldDeleteItemFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(this.minKey, this.minKey);
        assertEquals(this.minKey,tree.delete(this.minKey));
        //System.out.println(tree.inOrder());
    }

    /**
     *    10                10
     *      \         ->
     *       20
     */
    @Test
    void shouldDeleteRightLeafFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(20,20);
        assertEquals(20,tree.delete(20));
        //System.out.println(tree.inOrder());
    }

    /**
     *    10            10
     *   /      ->
     *  5
     */
    @Test
    void shouldDeleteLeftLeafFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(5,5);
        assertEquals(5,tree.delete(5));
        //System.out.println(tree.inOrder());
    }

    /**
     *    10            5
     *   /      ->
     *  5
     */
    @Test
    void shouldDeleteRootWithLeftLeafFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(5,5);
        assertEquals(10,tree.delete(10));
        System.out.println(tree.inOrder());
    }

    /**
     *  10              10
     *    \               \
     *     20       ->     30
     *       \
     *        30
     */
    @Test
    void shouldDelete20FromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(20,20);
        tree.insert(30,30);
        assertEquals(20,tree.delete(20));
        //System.out.println(tree.inOrder());
    }

    /**
     *       100              100
     *      /               /
     *     5       ->     1
     *    /
     *   1
     */
    @Test
    void shouldDelete5FromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(100,100);
        tree.insert(5,5);
        tree.insert(1,1);
        assertEquals(5,tree.delete(5));
        System.out.println(tree.inOrder());
    }

    /**
     *  10              20
     *    \               \
     *     20       ->     30
     *       \
     *        30
     */
    @Test
    void shouldDelete10AsRootFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(20,20);
        //tree.insert(15,15);
        tree.insert(30,30);
        assertEquals(10,tree.delete(10));
        System.out.println(tree.inOrder());
    }

    /**
     *       100              100
     *      /               /
     *     5       ->     1
     *    /
     *   1
     */
    @Test
    void shouldDelete100AsRootFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(100,100);
        tree.insert(5,5);
        //tree.insert(6,6);
        tree.insert(1,1);
        assertEquals(100,tree.delete(100));
        System.out.println(tree.inOrder());
    }

    /**
     *  20 has a left son
     *      10              10
     *       \               \
     *        20       ->     15
     *       /
     *     15
     */
    @Test
    void shouldDelete20WithLeftSonFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(20,20);
        tree.insert(15,15);
        //tree.insert(12,12);
        assertEquals(20,tree.delete(20));
        //System.out.println(tree.inOrder());
    }

    /**
     *       100              100
     *      /               /
     *     5       ->     50
     *      \
     *       50
     */
    @Test
    void shouldDelete5WithRightSonFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(100,100);
        tree.insert(5,5);
        //tree.insert(6,6);
        tree.insert(50,50);
        assertEquals(5,tree.delete(5));
        //System.out.println(tree.inOrder());
    }

    /**
     *      10              10
     *       \               \
     *        20       ->     30
     *       /  \            /
     *     15    30        15
     */
    @Test
    void shouldDelete20WithTwoSonsFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(10,10);
        tree.insert(20,20);
        tree.insert(15,15);
        tree.insert(30,30);
        assertEquals(20,tree.delete(20));
        System.out.println(tree.inOrder());
    }

    /**
     *          100             100
     *          /              /
     *        5       ->     50
     *       /  \           /
     *     1    50         1
     */
    @Test
    void shouldDelete5WithTwoSonsFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(100,100);
        tree.insert(5,5);
        tree.insert(1,1);
        tree.insert(50,50);
        //tree.insert(0,0);
        System.out.println(tree.inOrder());
        assertEquals(5,tree.delete(5));
        System.out.println(tree.inOrder());
    }

    /**
     *          100                    50
     *         /   \                 /    \
     *        5     150      ->     5      150
     *       /  \                  / \
     *     1    50                1   25
     *    /    /                 /     \
     *   0    25                0       40
     *          \
     *           40
     */
    @Test
    void shouldDelete100WithTwoSonsFromTree() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        tree.insert(100,100);
        tree.insert(150,150);
        tree.insert(5,5);
        tree.insert(1,1);
        tree.insert(50,50);
        tree.insert(25,25);
        tree.insert(40,40);
        tree.insert(0,0);
        System.out.println(tree.inOrder());
        //tree.delete(100);
        assertEquals(100,tree.delete(100));
        System.out.println(tree.inOrder());

    }
}