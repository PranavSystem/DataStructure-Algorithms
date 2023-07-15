package linked_list;

import java.util.Scanner;

public class DoublyLinear {
	// Node is static member of class SinglyLinear
	static class Node {
		// Node class members
		private int data;
		private Node next;
		private Node prev;
		// Node class methods
		public Node() {
			data = 0;
			next = null;
			prev = null;
		}
		public Node(int val) {
			data = val;
			next = null;
			prev = null;
		}
	}

	// List class members
	public Node head;
	// List class methods
	public DoublyLinear() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	void displayForward() {
		System.out.println("List Forward:");
		Node trav = head;
		//special case 1: if empty list, then return
		if(head == null)
			return;
		while (trav != null) { // traverse all nodes
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
	
	void displayReverse() {
		System.out.println("List Reverse:");
		Node trav = head;
		//special case 1: if empty list, then return
		if(head == null)
			return;
		while(trav.next != null)		// traverse till last node
			trav = trav.next;
		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.prev;
		}
	}

	void addFirst(int val) {
		Node nn = new Node(val); // create new node and initialize it
		// special case 1:if list is empty
		if(isEmpty())
			head = nn;
		else {
		nn.next = head; // next node next should point to head
		head.prev = nn;	// new node's previous should point to head
		head = nn; // head should point to new node
		}
	}

	void addLast(int val) {
		Node nn = new Node(val); // create new node and initialize it
		// corner case 1: if list is empty then make new node as first node of list
		if (head == null)
			head = nn;
		else {
			Node trav = head;
			while (trav.next != null) // traverse till last node
				trav = trav.next;
			trav.next = nn; // add new node after trav (trav.next)
			nn.prev = trav;	// new node's previous points to trav
		}
	}

	void addAtPosition(int val, int pos) {
		// special case 1: if list is empty, add node at starts
		// special case 2: if pos<=1, add node at start
		if (head == null || pos <= 1)
			addFirst(val);
		else {
			Node nn = new Node(val); // create new node and init
			Node temp, trav = head;
			for (int i = 1; i < pos - 1; i++) { // traverse till pos-1
				// special case 3: if pos > length of list, add node at end
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			temp = trav.next;	// take temp pointer to node after trav
			nn.next = temp; // new node next points to temp(trav's next)
			nn.prev = trav;	// new node's previous points to trav
			trav.next = nn; // trav next should point to new node
			// special case 3: if adding node at end, this line not required
			if(temp != null)
				temp.prev = nn;	// temp's previous points to new node
		}
	}

	void deleteFirst() {
		// Special case:list is empty, add exception
		if (head == null)
			throw new RuntimeException("List is empty");
		//special case 2:if list has single node, make head null
		if(head.next == null)
			head = null;
		else {
		head = head.next;  // head should point to next node
		head.prev = null;	//head previous should be null;
		}
	}

	void deleteLast() {
		// Special case 1: list is empty, add exception
		if (head == null)
			throw new RuntimeException("List is empty");
		// special case 2: if list has only one element, make list empty (make head null)
		if( head.next == null )
			head = null;
		else {
			Node trav = head; 
			while (trav.next != null) { // traverse list till end
				trav = trav.next;
			}
			trav.prev.next = null; // 2nd last element next pointer made null
		}
	}

	void deleteAtPosition(int pos) {
		// Special case 1: if pos=1, delete first node
		if (pos == 1)
			deleteFirst();
		// special case 2: if list is empty or pos<1, throw exception
		if (head == null || pos < 1)
			throw new RuntimeException("List is empty or invalid position");
		else {
		Node trav = head; // take temp pointer running behind trav
		for (int i = 1; i < pos; i++) { // traverse till pos (trav)
			//special case 3:if pos is beyond list length, throw exception
			if(trav == null)
				throw new RuntimeException("Invalid position");
			trav = trav.next;
		}
		trav.prev.next = trav.next;	// trav's previous's next points to trav's next
		//special case 3: while deleting last node, skip next line
		if(trav.next != null)
			trav.next.prev = trav.prev; // trav's next's previous points to trav's previouss
		}
	}

	void deleteAll() {
		head.next = null;
		head = null; // all nodes will get garbage collected
	}

	public static void main(String[] args) {
		int choice, val, pos;
		DoublyLinear list = new DoublyLinear();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"0.Exit 1.Display 2.Add First 3.Add Last 4.Add at Position 5.Delete First 6.Delete Last 7.Delete at Position 8.Delete All");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				list.displayForward();
				list.displayReverse();
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
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				try {
					list.deleteLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
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
