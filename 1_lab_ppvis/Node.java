public class Node {

    private String engTrans, rusTrans;
    private Node leftChild, rightChild;

    Node(String engTrans, String rusTrans){

        this.engTrans = engTrans;
        this.rusTrans = rusTrans;

    }

    public String getEngTrans(){
        return this.engTrans;
    }

    public String getRusTrans(){
        return this.rusTrans;
    }

    public Node getLeftChild(){
        return this.leftChild;
    }

    public Node getRightChild(){
        return this.rightChild;
    }

    public void setRightChild(Node rightChild){
        this.rightChild = rightChild;
    }

    public void setLeftChild(Node leftChild){
        this.leftChild = leftChild;
    }

}
