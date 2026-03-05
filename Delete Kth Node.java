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

    void deleteK(int k) {

        if (head == null) {
            return;
        }

        if (k == 1) {
            head = head.next;
            return;
        }

        Node temp = head;

        for (int i = 1; i < k - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Main list = new Main();

        int n = sc.nextInt();   

        for (int i = 0; i < n; i++) {
            list.insert(sc.nextInt());
        }

        int k = sc.nextInt();   
        list.deleteK(k);

        list.display();
    }
}
