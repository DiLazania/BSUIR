import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinaryTree {

    private Node root;

    /// @param Two strings for translations of both languages.
    public void addNode(String engTrans, String rusTrans){

        Node newNode = new Node(engTrans, rusTrans);

        if(root == null){

            root = newNode;

        } else {

            Node focusNode = root;
            Node parent;

            while (true){

                parent = focusNode;

                if(engTrans.compareTo(focusNode.getEngTrans()) < 0){

                    focusNode = focusNode.getLeftChild();

                    if(focusNode == null){

                        parent.setLeftChild(newNode);
                        return;

                    }

                } else {

                    focusNode = focusNode.getRightChild();

                    if(focusNode == null){

                        parent.setRightChild(newNode);
                        return;

                    }
                }
            }
        }
    }

    /// @param Contains the word that should be removed.
    /// @note At first looks for the node that's going to be removed, then finding the place of the node that the removing node can be replaced by, and deleting in the end.
    public boolean removeNode(String engTrans){

        Node focusNode = root;
        Node parent = root;
        boolean isItALeftChild = true;

        while(focusNode.getEngTrans().compareTo(engTrans) != 0){

            parent = focusNode;

            if(engTrans.compareTo(focusNode.getEngTrans()) < 0){
                isItALeftChild = true;
                focusNode = focusNode.getLeftChild();
            } else {
                isItALeftChild = false;
                focusNode = focusNode.getRightChild();
            }
            if(focusNode == null){
                return false;
            }

        }

        if(focusNode.getLeftChild() == null && focusNode.getRightChild() == null){

            if(focusNode == root){
                root = null;
            } else if(isItALeftChild){
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }

        } else if(focusNode.getRightChild() == null){

            if(focusNode == root){
                root = focusNode.getLeftChild();
            } else if(isItALeftChild){
                parent.setLeftChild(focusNode.getLeftChild());
            } else {
                parent.setRightChild(focusNode.getLeftChild());
            }

        } else if(focusNode.getLeftChild() == null){

            if(focusNode == root){
                root = focusNode.getRightChild();
            } else if(isItALeftChild){
                parent.setLeftChild(focusNode.getRightChild());
            } else {
                parent.setRightChild(focusNode.getRightChild());
            }

        } else {

            Node replacement = getReplacementNode(focusNode);
            if(focusNode == root){
                root = replacement;
            } else if(isItALeftChild){
                parent.setLeftChild(replacement);
            } else {
                parent.setRightChild(replacement);
            }

            replacement.setLeftChild(focusNode.getLeftChild());

        }

        return true;

    }

    private Node getReplacementNode(Node replacedNode){

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node focusNode = replacedNode.getRightChild();

        while(focusNode != null){

            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();

        }

        if(replacement != replacedNode.getRightChild()){

            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replacedNode.getRightChild());

        }

        return replacement;

    }

    public void printNodes(Node focusNode){

        if(focusNode != null){

            System.out.println(focusNode.getEngTrans() + ": " + focusNode.getRusTrans());

            printNodes(focusNode.getRightChild());
            printNodes(focusNode.getLeftChild());


        }

    }

    public Node getRoot(){

        return root;

    }

    public int getAmount(Node focusNode){

        if(focusNode.getLeftChild() == null && focusNode.getRightChild() == null){

            return 1;

        }

        int left, right;

        if(focusNode.getLeftChild() != null){

            left = getAmount(focusNode.getLeftChild());

        } else {

            left = 0;

        }

        if(focusNode.getRightChild() != null){

            right = getAmount(focusNode.getRightChild());

        } else {

            right = 0;

        }

        return left + right + 1;

    }

    public void replaceNode(String key, String engTrans, String rusTrans, BinaryTree bt){

        bt.removeNode(key);
        bt.addNode(engTrans, rusTrans);

    }

    public void fileReading(BinaryTree bt) throws FileNotFoundException {

        File file = new File("C:\\Users\\Василий\\Desktop\\1labPPvIS\\src\\Dictionary.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){

            String engTrans = scan.nextLine();
            String rusTrans = scan.nextLine();
            bt.addNode(engTrans, rusTrans);

        }

    }

}