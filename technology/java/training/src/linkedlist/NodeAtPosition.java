package linkedlist;

import static linkedlist.DeleteNode.deleteNode;

public class NodeAtPosition {

	public static void main(String[] args) {
		SinglyLinkedList llist = new SinglyLinkedList();
		// int[] llistItems = new int[] { 16, 13, 7 };
		int[] llistItems = new int[] { 20, 6, 2, 19, 7, 4, 15, 9 };
		for (int llistItem : llistItems)
			llist.insertNode(llistItem);
		llist.printLinkedList();
		// SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, 1, 2);
		SinglyLinkedListNode llist_head = deleteNode(llist.head,3);
		 llist.printLinkedList(llist_head);
		 //llist.reversePrint(llist_head);
		 llist.printLinkedList(llist.reverse(llist.head));
		 //llist.printLinkedList();

	}

	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		int positionCount = 0;

		if (head == null) {
			head = node;
		}
		SinglyLinkedListNode positionNode = head;

		while (positionCount != (position - 1)) {
			positionCount++;
			positionNode = positionNode.next;
		}

		SinglyLinkedListNode tail = positionNode.next;
		node.next = tail;
		positionNode.next = node;

		return head;
	}

	
	
		
}
