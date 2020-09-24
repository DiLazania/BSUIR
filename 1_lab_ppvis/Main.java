import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        BT_Window window = new BT_Window(bt);

        while (true){

            System.out.println("1 - Add\n2 - Print\n3 - Remove\n4 - Replace\n5 - Read Dictionary\n6 - Print Amount" +
                    "\n7 - Run window\n");
            int choice = in.nextInt();

            if(choice == 1){

                System.out.print("Word (Eng): ");
                String engTrans = in.next();
                System.out.print("Translation (Rus): ");
                String rusTrans = in.next();

                bt.addNode(engTrans, rusTrans);

            } else if(choice == 2){

                bt.printNodes(bt.getRoot());

            } else if(choice == 3){

                System.out.print("Word: ");
                String word = in.next();

                bt.removeNode(word);

            } else if(choice == 4){

                System.out.print("Word: ");
                String word = in.next();
                System.out.print("Word (Eng): ");
                String engTrans = in.next();
                System.out.print("Translation (Rus): ");
                String rusTrans = in.next();

                bt.replaceNode(word, engTrans, rusTrans, bt);

            } else if(choice == 5){

                bt.fileReading(bt);

            } else if(choice == 6){

                int amount;
                amount = bt.getAmount(bt.getRoot());
                System.out.println("Amount: " + amount);

            }

            else if(choice == 7){

                window.startGUI();

            }
        }
    }
}
