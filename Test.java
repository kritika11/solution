import java.util.*;
import java.lang.*;

public class Test {

    public static void main (String[] args) throws java.lang.Exception{
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        LinkedList ll3 = new LinkedList();
        Node mergedLinkedListHead;
        Scanner in = new Scanner(System.in);
        int sizeOfLinkedList1, sizeOfLinkedList2, value;

        // Read input from stdin
        sizeOfLinkedList1 = in.nextInt();
        sizeOfLinkedList2 = in.nextInt();
        for(int i=0;i<sizeOfLinkedList1;i++){
            value = in.nextInt();
            ll1.addNode(value);
        }
        for(int i=0;i<sizeOfLinkedList2;i++){
            value = in.nextInt();
            ll2.addNode(value);
        }
        
        mergedLinkedListHead = ll3.reverseMergeSortedLinkedLists(ll1.head,ll2.head);

        // Print output to console
        ll3.printLinkedList(mergedLinkedListHead);
    }
}

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList
{
    Node head, tail;

    LinkedList(){
        head = null;
        tail = null;
    }

    public void addNode(int new_data){
        Node temp = new Node(new_data);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            tail.next = temp;
            tail = temp;
        }
    }

    public void printLinkedList(Node headNode)
    {
        Node temp = headNode;
        if(headNode != null){
            while(temp.next != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data);
        }
    }

    public Node reverseMergeSortedLinkedLists(Node head1, Node head2)
    {
        if(head1 == null && head2 == null)
            return null;

        Node previous = null;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                Node next = head1.next;
                head1.next = previous;
                previous = head1;
                head1 = next;
            } else {
                Node next = head2.next;
                head2.next = previous;
                previous = head2;
                head2 = next;
            }
        }

        while(head1 != null) {
            Node next = head1.next;
            head1.next = previous;
            previous = head1;
            head1 = next;
        }

        while(head2 != null) {
            Node next = head2.next;
            head2.next = previous;
            previous = head2;
            head2 = next;
        }

        return previous;
    }
}

