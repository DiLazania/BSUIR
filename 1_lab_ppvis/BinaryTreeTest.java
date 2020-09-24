import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void addNode() {

        BinaryTree bt = new BinaryTree();

        bt.addNode("Hello", "Привет");
        bt.addNode("Bye", "Пока");
        bt.addNode("Work", "Работа");
        bt.addNode("Cloud", "Облако");
        bt.addNode("Apple", "Яблоко");
        bt.addNode("Zero", "Ноль");

        String expected = "Облако";
        String actual = bt.getRoot().getLeftChild().getRightChild().getRusTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void removeNode() {

        BinaryTree bt = new BinaryTree();

        bt.addNode("Hello", "Привет");
        bt.addNode("Bye", "Пока");
        bt.addNode("Work", "Работа");
        bt.addNode("Cloud", "Облако");
        bt.addNode("Apple", "Яблоко");
        bt.addNode("Zero", "Ноль");
        bt.addNode("Wzork", "Тест");
        bt.addNode("Wzaork", "Тест");

        bt.removeNode("Hello");

        String expected = "Work";
        String actual = bt.getRoot().getEngTrans();
        assertEquals(expected, actual);

        expected = "Zero";
        actual = bt.getRoot().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Wzork";
        actual = bt.getRoot().getRightChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Bye";
        actual = bt.getRoot().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Cloud";
        actual = bt.getRoot().getLeftChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Apple";
        actual = bt.getRoot().getLeftChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Wzaork";
        actual = bt.getRoot().getRightChild().getLeftChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void replaceNode() {

        BinaryTree bt = new BinaryTree();

        bt.addNode("Apple", "Привет");
        bt.addNode("Bye", "Пока");
        bt.addNode("Work", "Работа");

        bt.replaceNode("Bye", "Hello", "Привет", bt);

        String expected = "Hello";
        String actual = bt.getRoot().getRightChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void fileReading() throws FileNotFoundException {

        BinaryTree bt = new BinaryTree();

        bt.fileReading(bt);

        String expected = "Apple";
        String actual = bt.getRoot().getLeftChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

    }
}