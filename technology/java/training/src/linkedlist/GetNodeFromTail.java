package linkedlist;

public class GetNodeFromTail {

	public static void main(String[] args) {

	}


    static int getNode(SinglyLinkedListNode head, int positionFromTail) {

    	int index = 0;
    	int positionFromTop = heightOfLinkedList(head) -1 - positionFromTail;
    	SinglyLinkedListNode indexNode = head;
    	while(index != positionFromTop) {
    		indexNode = indexNode.next;
    		index++;
    	}
    	
    	return indexNode.data;

    }

    
	private static int heightOfLinkedList(SinglyLinkedListNode node) {
		if(node == null) {
			return 0;
		}else {
			return heightOfLinkedList(node.next) + 1;
		}
		
		
	}

}

