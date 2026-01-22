public class App {
    public static void main(String[] args) throws Exception {
        
        // CustomList list = new CustomList(new Node(5));
        // list.print();
        // //list.printRec();

        // Node n1 = new Node(4);
        // Node n2 = new Node(8);
        // n1.setNext(n2); 
        
        // list.append(n1);
        // list.print();  

        // Node n3 = new Node(0);
        // Node n4 = new Node(67);

        // list.add(0, n3);
        // list.add(2, n4);
        // list.print();

        // System.out.println(list.get(4));

        // Node r = list.remove(2);
        // System.out.println("Nodo rimosso: " + r);

        // // boolean res = list.remove(n4);
        // // System.out.println("Nodo rimosso? " + res);
        // list.print();

        // Node n5 = new Node(-3);
        // list.set(2, n5);
        // list.print();

        CircularList list = new CircularList();
        Node n1 = new Node(7);
        Node n2 = new Node(8);
        Node n3 = new Node(9);
        Node n4 = new Node(10);
        Node n5 = new Node(11);
        
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.add(n5);
        list.print();

        //list.cut(3);
        //list.print();

        //int removed = list.removeRange(0, 3);
        //System.out.printf("Nodes removed: %d \n", removed); 
        //list.print();

        Node n6 = new Node(-1);
        Node n7 = new Node(-2);

        list.newRing(n6, n7);
        list.print();

        list.newRing(n2, n4);
        list.print();

        list.newRing(n6, n4);
        list.print();

        list.newRing(n2, n7);
        list.print();

        System.out.println("----");
        CircularList list2 = new CircularList();
        list2.newRing(n6, n7);
        list2.print();
    }
}
