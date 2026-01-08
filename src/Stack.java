public class Stack {
    
    // head of the list
    private Node top;

    public Stack() {
        this.top = null;
    }

    public Stack(Node newNode) {
        this.top = newNode;
    }

    public boolean isEmpty() {

        return top == null;
    }

    /**
     * Reads the first element's content
     * @return content of the first node
     */
    public int head() {
        
        return 0;
    }

    /**
     * Removes the first element from the stack, updating the top reference
     * @return node removed
     */
    public Node pop() {

        return null;
    }

    /**
     * Adds a node to the top of the stack
     * @param nowNode node to be added
     */
    public void push(Node nowNode) {

    }
}
