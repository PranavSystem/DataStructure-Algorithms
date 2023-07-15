package linked_list;

import java.util.Scanner;

public class SinglyLinearWithTail {
	// Node is static member of class SinglyLinear
	static class Node {
		// Node class members
		private int data;
		private Node next;
		// Node class methods
		public Node() {
			data = 0;
			next = null;
		}
		public Node(int val) {
			data = val;
			next = null;
		}
	}

	// List class members
	private Node head;
	private Node tail;
	// List class methods
	public SinglyLinearWithTail() {
		head = null;
		tail = null;
	}

	void display() {
		System.out.println("List:");
		Node trav = head;
		while (trav != null) { // traverse all nodes
			System.out.println(trav.data);
			trav = trav.next;
		}
	}

	void addFirst(int val) {
		Node nn = new Node(val); // create new node and initialize it
		// special case 1: if list is empty, first new node itself is last node
		if( head == null )
			tail = nn;
		nn.next = head; // next node next should point to head
		head = nn; // head should point to new node
	}

	void addLast(int val) {
		Node nn = new Node(val); // create new node and initialize it
		// corner case 1: if list is empty then make new node as first node of list
		if (head == null) {
			head = nn;
			tail = nn;
		}	
		else {
			// add new node to next of last node (tail)
			tail.next = nn;
			// update tail to new node
			tail = nn;
		}
	}

	void addAtPosition(int val, int pos) {
		// special case 1: if list is empty, add node at starts
		// special case 2: if pos<=1, add node at start
		if (head == null || pos <= 1)
			addFirst(val);
		else {
			Node nn = new Node(val); // create new node and init
			Node trav = head;
			for (int i = 0; i < pos - 1; i++) { // traverse till pos-1
				// special case 3: if pos > length of list, add node at end
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			nn.next = trav.next; // new node next points to trav next
			trav.next = nn; // trav next should point to new node4
		}
	}

	void deleteFirst() {
		// Special case:list is empty, add exception
		if (head == null)
			throw new RuntimeException("List is empty");
		else
			head = head.next; // head should point to next node
	}

	void deleteLast() {
		// Special case 1: list is empty, add exception
		if (head == null)
			throw new RuntimeException("List is empty");
		// special case 2: if list has only one element, make list empty (make head null)
		if( head.next == null )
			head = null;
		else {
			Node trav = head, temp = null; // take temp pointer running behind trav
			while (trav.next != null) { // traverse list till end
				temp = trav;
				trav = trav.next;
			}
			temp.next = null; // 2nd last element next pointer made null
		}
	}

	void deleteAtPosition(int pos) {
		// Special case 1: if pos=1, delete first node
		if (pos == 1)
			deleteFirst();
		// special case 2: if list is empty or pos<1, throw exception
		if (head == null || pos < 1)
			throw new RuntimeException("List is empty or invalid position");
		Node temp = null, trav = head; // take temp pointer running behind trav
		for (int i = 0; i < pos; i++) { // traverse till pos (trav)
			temp = trav;
			trav = trav.next;
		}
		temp.next = trav.next; // trav is node to be deleted and temp is node before that
	}

	void deleteAll() {
		head = null; // all nodes will get garbage collected
	}

	public static void main(String[] args) {
		int choice, val, pos;
		SinglyLinearWithTail list = new SinglyLinearWithTail();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"0.Exit 1.Display 2.Add First 3.Add Last 4.Add at Position 5.Delete First 6.Delete Last 7.Delete at Position 8.Delete All");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				list.display();
				break;
			case 2:
				System.out.println("Enter new element: ");
				list.addFirst(sc.nextInt());
				break;
			case 3:
				System.out.println("Enter new element: ");
				list.addLast(sc.nextInt());
				break;
			case 4:
				System.out.println("Enter new element: ");
				val = sc.nextInt();
				System.out.println("Enter the position: ");
				pos = sc.nextInt();
				list.addAtPosition(val, pos);
				break;
			case 5:
				try {
					list.deleteFirst();
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
				break;
			case 6:
				try {
					list.deleteLast();
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
				break;
			case 7:
				System.out.println("Enter position: ");
				list.deleteAtPosition(sc.nextInt());
				break;
			case 8:
				list.deleteAll();
				break;
			}
		} while (choice != 0);
		sc.close();
	}
}
