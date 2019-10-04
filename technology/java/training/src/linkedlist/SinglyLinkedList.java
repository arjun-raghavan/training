package linkedlist;

public class SinglyLinkedList {

	SinglyLinkedListNode head;

	public void insertNode(int llistItem) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(llistItem);

		if (head == null) {
			head = node;
		} else {
			SinglyLinkedListNode lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = node;
		}

	}

	public void printLinkedList() {

		SinglyLinkedListNode node = head;

		while (node != null) {
			System.out.print("" + node.data + " -> ");
			node = node.next;
		}

		System.out.println("");
	}

	public void printLinkedList(SinglyLinkedListNode listNode) {

		SinglyLinkedListNode node = listNode;

		while (node != null) {
			System.out.print("" + node.data + " -> ");
			node = node.next;
		}

		System.out.println("");
	}

	public void reversePrint(SinglyLinkedListNode head) {
		if (head == null) {
			return;
		}

		reversePrint(head.next);
		System.out.println("" + head.data);
	}

	public SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
		SinglyLinkedListNode nodeToReverse = head;
		SinglyLinkedListNode previousNode = null;
		SinglyLinkedListNode nextNode = null;

		while (nodeToReverse != null) {
			nextNode = nodeToReverse.next;
			nodeToReverse.next = previousNode;
			previousNode = nodeToReverse;
			nodeToReverse = nextNode;
		}

		return previousNode;

	}
}
