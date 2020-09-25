import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();

        String engTrans, rusTrans, choice, word;

        while (true){

            System.out.println("1 - Add\n2 - Print\n3 - Remove\n4 - Replace\n5 - Read Dictionary\n6 - Print Amount" + "\n");
            choice = in.next();

            if(choice.equals("1")){

                System.out.print("Word (Eng): ");
                engTrans = in.next();
                System.out.print("Translation (Rus): ");
                rusTrans = in.next();

                bt.addNode(engTrans, rusTrans);

            } else if(choice.equals("2")){

                bt.printNodes(bt.getRoot());

            } else if(choice.equals("3")){

                System.out.print("Word (Eng): ");
                word = in.next();

                bt.removeNode(word);

            } else if(choice.equals("4")){

                System.out.print("Word (Eng): ");
                word = in.next();
                System.out.print("New word (Eng): ");
                engTrans = in.next();
                System.out.print("Translation (Rus): ");
                rusTrans = in.next();

                bt.replaceNode(word, engTrans, rusTrans, bt);

            } else if(choice.equals("5")){

                bt.fileReading(bt);

            } else if(choice.equals("6")){

                int amount;
                amount = bt.getAmount(bt.getRoot());
                System.out.println("Amount: " + amount);

            } else {
                System.out.println("You missed! Try to hit the right button one more time.");
            }

        }

    }
}
