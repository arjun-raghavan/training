package linkedlist.intersection;

import java.util.HashSet;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

public class LinkedListIntersect {

	public static void main(String[] args) {
		// list 1 
        Node n1 = new Node(1); 
        n1.next = new Node(2); 
        n1.next.next = new Node(3); 
        n1.next.next.next = new Node(4); 
        n1.next.next.next.next = new Node(5); 
        n1.next.next.next.next.next = new Node(6); 
        n1.next.next.next.next.next.next = new Node(7); 
        // list 2 
        Node n2 = new Node(10); 
        n2.next = new Node(9); 
        n2.next.next = new Node(8); 
        n2.next.next.next = n1.next.next.next; 
        printLinkedList(n1); 
        printLinkedList(n2); 
        System.out.println("heightOfLinkedList = "+heightOfLinkedList(n1));
        Node node = intersectingNode(n1, n2);
        if(node != null)
        	System.out.println(node.data);
        else
        	System.out.println("No Intersecting Node");
	}

	private static Node intersectingNode(Node n1, Node n2) {
		HashSet<Node> nodes = new HashSet<Node>();
		
		Node node = n1;
		while(node != null) {
			nodes.add(node);
			node = node.next;
		}
		
		node = n2;
		while(node != null) {
			if(nodes.contains(node)) {
				return node;
			}else {
				node = node.next;
			}
		}
		
		return null;
	}

	private static int heightOfLinkedList(Node node) {
		if(node == null) {
			return 0;
		}else {
			return heightOfLinkedList(node.next) + 1;
		}
		
		
	}
	
	private static void printLinkedList(Node n) {
		
		Node node = n;
		
		while(node != null) {
			System.out.print(""+node.data+" - ");
			node = node.next;
		}
		
		System.out.println("");
	}

}
