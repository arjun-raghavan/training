package linkedlist;

public class DeleteNode {
	static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

		if(position == 0) {
			return head.next;
		}

		int positionCount = 0;
		SinglyLinkedListNode positionNode = head;
		while(positionCount != (position - 1)) {
			positionCount++;
			positionNode = positionNode.next;
		}
		
		positionNode.next = positionNode.next.next;
		
		return head;
    }
}
