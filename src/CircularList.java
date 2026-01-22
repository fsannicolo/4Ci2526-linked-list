public class CircularList {
    
    private Node head, tail;

    public CircularList() {
        this.head = this.tail = null;
    }

    public CircularList(Node h, Node t) {
        this.head = h;
        this.tail = t;
        head.setNext(tail);
        tail.setNext(head);
    }

    public void add(Node newNode) {

        if (head == null && tail == null) {
            head = tail = newNode;
            head.setNext(tail);
            tail.setNext(head);
        }
        // else if (head == tail) {
        //     tail.setNext(newNode);
        //     tail = newNode;
        //     tail.setNext(head); 
        // }
        else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
    }

    // from CustomList ------------------------------------------------
    private int sizeRec(Node cursor) {

        // exit clause
        if (cursor == tail)
            return 1;

        // recursive call
        return sizeRec(cursor.getNext()) + 1;
    }

    public int size() {

        return sizeRec(head);
    }

    // wrapper
    private Node getRec(Node cursor, int index) {

        // exit clause
        if (index == 0)
            return cursor;

        // recursive call
        return getRec(cursor.getNext(), index-1);
    }

    /**
     * Gets the element in the specified position
     * @param index position to read
     * @return the element identified by the index
     * @throws IndexOutOfBoundsException
     */
    public Node get(int index) throws IndexOutOfBoundsException {
        // checks if the index is valid
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");

        return getRec(head, index);
    }
    // ------------------------------------------------

    public boolean checkRing() {
        return false;
    }

    public int removeRange(int start, int end) {

        return 0;
    }

    public void cut(int last) {

    }

    public Node getPrev(Node n) {

        return null;
    }

    public void newRing(Node n1, Node n2) {

    }

    public void print() {

        if (head == null) return; 

        Node cursor = head;
        do {
            System.out.println(cursor.toString());
            cursor = cursor.getNext();
        }
        while (cursor != head);
    }
}


