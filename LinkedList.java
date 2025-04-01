public class LinkedList {

    Node head;

    // define the node
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    //insert data after d
    void insertAtMiddle(int data, int d) {
        Node curr = head;
    
        while (curr != null && curr.data != d) {
            curr = curr.next;
        }
    
        if (curr == null) {
            System.out.println("Node with value " + d + " not found.");
            return;
        }
    
        Node newnode = new Node(data);
        newnode.next = curr.next;
        curr.next = newnode;
    }
    
    //append node
    void appendNode(int data){
        //if no head
        if(head == null){
            head = new Node(data);
        }
        else{
            Node curr = head;

            while(curr.next !=null){
                curr= curr.next;
            }

            curr.next = new Node(data);
        }
    }

    //delete any node
    void deleteNode(int data){
        Node curr = head;

        //delete if head
        if(data == head.data){
            head = head.next;
            System.out.println("\nhead deleted and new head is: "+ head.data);
        }
        //if not head
        else{
            Node perv = head;
            while(curr.data != data){
                perv = curr;
                curr = curr.next;
            }
            //delete middle element
            if(curr.next != null){
                perv.next = curr.next;
                System.out.println("\nnode deleted: " + curr.data);
            }
            //last node
            else if(curr.next == null){
                perv.next=null;
                System.out.println("\nnode deleted: "+curr.data);
            }
        }

        return;
    }

    //to print all nodes
    void printLL(){
        if(head == null) System.out.println("linked list is empty.");

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data+"->");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // create a linked list and
        LinkedList ll = new LinkedList();

        //insert node to last
        ll.appendNode(15);
        ll.appendNode(14);
        ll.appendNode(74);
        ll.appendNode(44);
        ll.appendNode(84);
        ll.appendNode(45);

        //print the linked list
        ll.printLL();

        //first
        ll.deleteNode(15);
        ll.printLL();

        //middle
        ll.deleteNode(74);
        ll.printLL();

        //last
        ll.deleteNode(45);
        ll.printLL();

        //add node in middle
        ll.insertAtMiddle(69, 44);
        System.out.println("\nadded 69 after 44");
        ll.printLL();

    }
}
