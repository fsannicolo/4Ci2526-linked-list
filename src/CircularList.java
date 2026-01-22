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

    public boolean contains(Node n) {

        return contains(head, n);
    }
    
    private boolean contains(Node cursor, Node n) {
        
        // exit clauses
        if (cursor == null) return false;
        if (cursor.equals(n)) return true;
        if (cursor == tail) return false;

        // recursive call
        return contains(cursor.getNext(), n);
    }
    // ------------------------------------------------

    /**
     * Checks whether the list is actually circular, meaning it doesn't have null pointers
     * @return true if it's circular, false otherwise
     */
    public boolean checkRing() {
        
        if (this.head == null) return false;

        // sweeps the list
        Node cursor = head;

        while (cursor != tail) {
            if (cursor == null) return false;
            cursor = cursor.getNext();
        }

        // checks the final reference
        if (tail.getNext() != head) return false;

        return true;
    }

    /**
     * Removes every node included in the interval (excluding the bounds)
     * @param start first index
     * @param end last index
     * @return number of nodes removes
     * @throws IllegalArgumentException
     */
    public int removeRange(int start, int end) throws IllegalArgumentException {

        // wrong direction
        if (start > end || start == end) return 0;

        if (head == null) return 0;

        if (start < 0 || end < 0 || start >= size() || end >= size()) 
            throw new IllegalArgumentException("Indexes must be not negative and can't exceed length!");

        // "cuts" the internal nodes
        Node startNode = get(start);
        Node endNode = get(end);
        startNode.setNext(endNode); 

        return end - start - 1; 
    }

    /**
     * Removes every node subsequent to a node identified by its index
     * @param last the very last node to survive
     */
    public void cut(int last) {

        if (head == null) return;

        if (last < 0) return;

        // if the index exceeds the length, I keep the remaining part (only because it's circular!!)
        last = last % size();

        // I keep just one node
        if (last == 0) {
            // head remains the same
            tail = head;
            head.setNext(head);  
        }

        Node cursor = get(last);
        cursor.setNext(head);
        tail = cursor;
    }

    public Node getPrev(Node n) {

        return null;
    }

    /**
     * Specifies the new starting and ending nodes of the list, if they are present. If not, they are added
     * as the new head and tail respectively
     * @param n1 new head node
     * @param n2 new tail node
     */
    public void newRing(Node n1, Node n2) {

        if (n1 == null || n2 == null) throw new NullPointerException("Nodes can't be null!");

        // if the nodes are equal
        if (n1 == n2) {
            head = n1;
            tail = n2;
            head.setNext(tail);
            tail.setNext(head);
            return;
        }

        // checks the first node
        if (contains(n1))
            head = n1;
        else { // and if head==null...
            n1.setNext(head);
            head = n1;
        }

        // if there's no tail yet, I'll end up with just 2 nodes
        if (tail == null) {
            head.setNext(n2);
            tail = n2;
            tail.setNext(head);
            return;
        }

        // checks the second node
        if (contains(n2))
            tail = n2;
        else {
            tail.setNext(n2);
            tail = n2;
        }

        // resets the last reference
        tail.setNext(head);
    }

    public void print() {

        if (head == null) return; 

        System.out.print('[');
        Node cursor = head;
        do {
            System.out.print(cursor.toString());
            cursor = cursor.getNext();
        }
        while (cursor != head);
        System.out.println(']');
    }
}


