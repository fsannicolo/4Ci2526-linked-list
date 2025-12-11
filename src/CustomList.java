public class CustomList {
    
    private Node head;

    public CustomList() {
        this.head = null;
    }

    public CustomList(Node newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {

        return head == null;
    }

    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {

        // the list is empty, I need to set a new head
        if (isEmpty()) {
            this.head = newNode;
            return;
        }

        // the node that "moves" inside the list
        Node cursor = head;

        // check if I've reached the second-to-last node
        while (cursor.getNext() != null) {
            cursor = cursor.getNext();
        }

        // I know that I've reached the end
        cursor.setNext(newNode);  
    }

    // recursive
    private void appendRec(Node cursor, Node newNode) {

        // exit clause
        if (cursor.getNext() == null) {
            cursor.setNext(newNode); 
            return;
        }

        // recursive call
        appendRec(cursor.getNext(), newNode); 
    }

    // wrapper
    public void appendRec(Node newNode) {

        if (isEmpty())
            this.head = newNode;
        else
            appendRec(head, newNode); 
    }

    /**
     * Outputs every list item on the console
     */
    public void print() {

        // the node that "moves" inside the list
        Node cursor = head;

        System.out.print("[");

        // I need to reach the very last element
        while (cursor != null) {
            System.out.print(cursor.getValue() + " ");

            // moves the cursor to the next node in the list
            cursor = cursor.getNext();
        }

        //for (Node cursor = head; cursor != null; cursor = cursor.getNext()) {}

        System.out.println("]");
    }


    // recursive version
    private void printRec(Node cursor) {
        // exit clause
        if (cursor == null) {
            return;
        }

        System.out.print(cursor.getValue() + " ");
        
        // recursive call
        printRec(cursor.getNext()); 
    } 

    // wrapper function
    public void printRec() {
        System.out.print("[");
        printRec(head);
        System.out.println("]");
    }
}
