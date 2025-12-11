public class App {
    public static void main(String[] args) throws Exception {
        
        CustomList list = new CustomList(new Node(5));
        list.print();
        //list.printRec();

        Node n1 = new Node(4);
        Node n2 = new Node(8);
        n1.setNext(n2); 
        
        list.append(n1);
        list.print();  
    }
}
