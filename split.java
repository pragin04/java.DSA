import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    Node head;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void splitList() {

        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; 
        Node head1 = head;
        Node head2 = slow;

        System.out.print("First List: ");
        print(head1);

        System.out.print("\nSecond List: ");
        print(head2);
    }

    void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main list = new Main();

        while (true) {
            int x = sc.nextInt();
            if (x == -1) break;
            list.insert(x);
        }

        list.splitList();
    }
}
