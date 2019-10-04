package linkedlist;

public class CompareLists {
	static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

		if(head1 == null || head2 == null) {
			return false;
		}

		SinglyLinkedListNode node1 = head1;
		SinglyLinkedListNode node2 = head2;
		
		while((node1 != null) && (node2 != null)) {
			if(node1.data != node2.data) {
				return false;
			}
			
			node1 = node1.next;
			node2 = node2.next;
		}
		
		if((node1 == null) && (node2 == null)) {
			return true;
		}
		return false;
    }

}
