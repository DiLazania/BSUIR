import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void addNodeTest_1() { //Checks positions of nodes via russian translations

        BinaryTree bt = new BinaryTree();

        bt.addNode("DiLazania", "Лазанья");
        bt.addNode("Spaghetti", "Спагетти");
        bt.addNode("Pizza", "Пицца");
        bt.addNode("Sushi", "Суши");
        bt.addNode("Ramen", "Рамен");
        bt.addNode("Coffee", "Кофе");

        String expected = "Лазанья";
        String actual = bt.getRoot().getRusTrans();
        assertEquals(expected, actual);

        expected = "Спагетти";
        actual = bt.getRoot().getRightChild().getRusTrans();
        assertEquals(expected, actual);

        expected = "Пицца";
        actual = bt.getRoot().getRightChild().getLeftChild().getRusTrans();
        assertEquals(expected, actual);

        expected = "Суши";
        actual = bt.getRoot().getRightChild().getRightChild().getRusTrans();
        assertEquals(expected, actual);

        expected = "Рамен";
        actual = bt.getRoot().getRightChild().getLeftChild().getRightChild().getRusTrans();
        assertEquals(expected, actual);

        expected = "Кофе";
        actual = bt.getRoot().getLeftChild().getRusTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void addNodeTest_2() { //Checks positions of nodes via english translations

        BinaryTree bt = new BinaryTree();

        bt.addNode("DiLazania", "Лазанья");
        bt.addNode("Spaghetti", "Спагетти");
        bt.addNode("Pizza", "Пицца");
        bt.addNode("Sushi", "Суши");
        bt.addNode("Ramen", "Рамен");
        bt.addNode("Coffee", "Кофе");

        String expected = "DiLazania";
        String actual = bt.getRoot().getEngTrans();
        assertEquals(expected, actual);

        expected = "Spaghetti";
        actual = bt.getRoot().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Pizza";
        actual = bt.getRoot().getRightChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Sushi";
        actual = bt.getRoot().getRightChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Ramen";
        actual = bt.getRoot().getRightChild().getLeftChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Coffee";
        actual = bt.getRoot().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void removeNodeTest_1() { //Replaces the node that has two children with right child

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
    public void removeNodeTest_2() { //Replaces the node that has two children with the leftmost child of it's right child

        BinaryTree bt = new BinaryTree();

        bt.addNode("Hello", "Привет");
        bt.addNode("Bye", "Пока");
        bt.addNode("Work", "Работа");
        bt.addNode("Zero", "Ноль");
        bt.addNode("Wab", "Тест");
        bt.addNode("Waa", "Тест");

        bt.removeNode("Hello");

        String expected = "Waa";
        String actual = bt.getRoot().getEngTrans();
        assertEquals(expected, actual);

        expected = "Work";
        actual = bt.getRoot().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Wab";
        actual = bt.getRoot().getRightChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Bye";
        actual = bt.getRoot().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Zero";
        actual = bt.getRoot().getRightChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void removeNodeTest_3() { //Checks amount of nodes before and after deletion + checks positions of nodes

        BinaryTree bt = new BinaryTree();

        bt.addNode("Hello", "Привет");
        bt.addNode("Bye", "Пока");
        bt.addNode("Work", "Работа");
        bt.addNode("Apple", "Тест");
        bt.addNode("Cloud", "Тест");

        int amount = bt.getAmount(bt.getRoot());
        int expected_integer = 5;
        int actual_integer = amount;
        assertEquals(expected_integer, actual_integer);

        bt.removeNode("Apple");

        String expected = "Hello";
        String actual = bt.getRoot().getEngTrans();
        assertEquals(expected, actual);

        expected = "Work";
        actual = bt.getRoot().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Bye";
        actual = bt.getRoot().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "Cloud";
        actual = bt.getRoot().getLeftChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        amount = bt.getAmount(bt.getRoot());
        expected_integer = 4;
        actual_integer = amount;
        assertEquals(expected_integer, actual_integer);

    }

    @Test
    public void replaceNodeTest_1() { //Checks replacement of the leaf

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
    public void replaceNodeTest_2() { //Checks replacement of the root

        BinaryTree bt = new BinaryTree();

        bt.addNode("bye", "пока");
        bt.addNode("apple", "яблоко");
        bt.addNode("cloud", "облако");

        bt.replaceNode("bye", "hello", "привет", bt);

        String expected = "hello";
        String actual = bt.getRoot().getRightChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void replaceNodeTest_3() { //Checks replacement of the node that has two children (but not the root)

        BinaryTree bt = new BinaryTree();

        bt.addNode("bye", "пока");
        bt.addNode("apple", "яблоко");
        bt.addNode("cloud", "облако");
        bt.addNode("work", "работа");
        bt.addNode("call", "звонок");

        bt.replaceNode("cloud", "hello", "привет", bt);

        String expected = "work";
        String actual = bt.getRoot().getRightChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "call";
        actual = bt.getRoot().getRightChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

        expected = "hello";
        actual = bt.getRoot().getRightChild().getLeftChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void fileReadingTest_1(){ //Checks adding nodes by reading from the file

        BinaryTree bt = new BinaryTree();

        bt.fileReading(bt);

        String expected = "Apple";
        String actual = bt.getRoot().getLeftChild().getLeftChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void fileReadingTest_2(){ // Checks adding nodes before and after reading from the file

        BinaryTree bt = new BinaryTree();

        bt.addNode("Walle", "Волли");
        bt.addNode("Ratatouille", "Рататуй");

        bt.fileReading(bt);

        bt.addNode("Сoco", "Коко");
        bt.addNode("Lionking", "Корольлев");

        String expected = "Pianist";
        String actual = bt.getRoot().getLeftChild().getLeftChild().getRightChild().getEngTrans();
        assertEquals(expected, actual);

    }

    @Test
    public void getAmountTest_1(){ // Checks getAmount function before and after reading from the file

        BinaryTree bt = new BinaryTree();

        bt.addNode("Lalaland", "Лалаленд");
        bt.addNode("Whiplash", "Одержимость");
        bt.addNode("Pianist", "Пианист");

        bt.fileReading(bt);

        bt.addNode("Interstellar", "Интерстеллар");
        bt.addNode("Joker", "Джокер");

        int expected = 5 + 5;
        int actual = bt.getAmount(bt.getRoot());
        assertEquals(expected, actual);

    }

    @Test
    public void getAmountTest_2(){ // Check getAmount function

        BinaryTree bt = new BinaryTree();

        bt.addNode("Walle", "Волли");
        bt.addNode("Ratatouille", "Рататуй");
        bt.addNode("Сoco", "Коко");
        bt.addNode("Lionking", "Корольлев");

        int expected = 4;
        int actual = bt.getAmount(bt.getRoot());
        assertEquals(expected, actual);

    }

}