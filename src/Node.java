public class Node {

    // the data contained by the node
    private int value;

    // reference to the next node in the structure (linear and unidirectional)
    private Node next;

    public Node(int newValue) {
        this.value = newValue;
        this.next = null;       // default
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "{" + this.value + "}";
    }

    // checks what happens when equals() is called
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Node n = (Node)obj;
        if (value != n.getValue()) return false;

        return true;
    }
}