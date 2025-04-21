public class LinkedLst {
    private Node head;
    private Node tail;
    private int size = 0;

    LinkedLst(){
        this.head = null;
        this.tail = null;
    }

    // I decided to make a doubly LinkedList, I think that'll give use more flexibility
    // on where we want to add our numbers

    // I need to think about a test case when a null Node is added
    public void addNumFront (int num) {
        Node temp = new Node(num);
        if (this.head == null) {
            this.head = temp;
            this.tail = temp;
            this.size += 1;
        } else {
            temp.setNext(this.head);
            this.head.setPrev(temp);
            this.head = temp;
            this.size++;
        }
    }

    public void addNumBack (int num){
        Node temp = new Node(num);
        if (this.head == null) {
            this.head = temp;
            this.tail = temp;
            this.size += 1;
        } else {
            temp.setPrev(this.tail);
            this.tail.setNext(temp);
            this.tail = temp;
            this.size++;
        }
    }

    // The method below is to turn num2 (the exponent) from a LinkedList into an int
    // so that it is easier to do the exponentiation
    public String getExpoInt(){
        int i;
        String expo_str = "";
        if(this.head == null){
            System.out.println("The Linked List is empty.");
            return null;
        }
        else {
            Node temp = this.tail;
            while(temp != null) {
                i = temp.getData();
                expo_str = i + expo_str;
                temp = temp.getPrev();
            }
            return expo_str;
        }
    }

    // I think it's okay to leave the Equation LinkedList as a singly Linked List
    // I don't see a scenario where we would need to add it from the back?
    // But if we need to I can change it, should be an easy fix
    public void addEq (Equation eq){
        if(this.head == null){
            this.head = new Node(eq);
            this.size += 1;
            return;
        }
        Node currentNode = this.head;
        while(currentNode.getNext() != null){
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(new Node(eq));
        this.size += 1;
    }

    // I need to think about when the LinkedList is null & when index > size
    public int getNum(int index){
        int i = index;
        Node currentNode = this.head;
        while(i > 0){
            currentNode = currentNode.getNext();
            i--;
        }
        return currentNode.getData();
    }

    public Equation getEq(int index){
        int i = index;
        Node currentNode = this.head;
        while(i > 0){
            currentNode = currentNode.getNext();
            i--;
        }
        return currentNode.getEq_data();
    }

    public int getSize(){
        return this.size;
    }

    public void setHead(Node node) {
        this.head = node;
    }

    public Node getHead() {
        return this.head;
    }

    /**
    * takes a linked list representing a number and removes any leading zeroes, or none if there are none
    */
    public void removeLeadZeros() {
        int i = 0;
        Node current = this.getHead();

        while(this.getNum(i) == 0) {
            current = current.getNext();
            i++;
        }

        this.setHead(current);// set the head to the current node
    }
}