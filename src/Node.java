public class Node {
    private int data;
    private Equation eq_data;
    private Node next;
    private Node prev;

    Node (int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node (Equation equation){
        this.eq_data = equation;
        this.next = null;
        this.prev = null;
    }

    // Getters
    public Equation getEq_data() {
        return eq_data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public int getData() {
        return data;
    }

    // Setters
    public void setData(int data) {
        this.data = data;
    }

    public void setEq_data(Equation eq_data) {
        this.eq_data = eq_data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;

    }
}