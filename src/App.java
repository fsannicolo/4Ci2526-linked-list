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

        Node n3 = new Node(0);
        Node n4 = new Node(67);

        list.add(0, n3);
        list.add(2, n4);
        list.print();

        System.out.println(list.get(4));

        Node r = list.remove(2);
        System.out.println("Nodo rimosso: " + r);

        // boolean res = list.remove(n4);
        // System.out.println("Nodo rimosso? " + res);
        list.print();
    }
}
