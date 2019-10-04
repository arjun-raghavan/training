package linkedlist;

public class MergeSortedLinkedLists {

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 3 };
		int[] arr2 = new int[] { 3, 4 };
		SinglyLinkedList llist1 = new SinglyLinkedList();
		for (int llistItem : arr1)
			llist1.insertNode(llistItem);

		SinglyLinkedList llist2 = new SinglyLinkedList();
		for (int llistItem : arr2)
			llist2.insertNode(llistItem);

		SinglyLinkedListNode newNode = mergeLists(llist1.head, llist2.head);
		printLinkedList(newNode);
	}

	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode insertionNode = null;
		SinglyLinkedListNode node1 = head1;
		SinglyLinkedListNode node2 = head2;
		SinglyLinkedListNode head = null;
		while ((node1 != null) && (node2 != null)) {
			if (node1.data > node2.data) {
				if (insertionNode == null) {
					head = insertionNode = node2;
				} else {
					insertionNode.next = node2;
					insertionNode = insertionNode.next;
				}
				node2 = node2.next;
			} else {
				if (insertionNode == null) {
					head = insertionNode = node1;
				} else {
					insertionNode.next = node1;
					insertionNode = insertionNode.next;
				}
				node1 = node1.next;
			}
		}

		if (node1 != null) {
			insertionNode.next = node1;
		}

		if (node2 != null) {
			insertionNode.next = node2;
		}

		return head;
	}

	public static void printLinkedList(SinglyLinkedListNode listNode) {

		SinglyLinkedListNode node = listNode;

		while (node != null) {
			System.out.print("" + node.data + " -> ");
			node = node.next;
		}

		System.out.println("");
	}

}
