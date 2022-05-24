import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
    void insert() {
        BinaryTree<Integer, Integer> tree = new BinaryTree<>();
        for (int i : this.treeList) {
            tree.insert(i, i);
        }
        for (int item :this.itemToInsert) {
            assertTrue(tree.insert(item, item));
        }
    }

    @Test
    void delete() {
    }
}