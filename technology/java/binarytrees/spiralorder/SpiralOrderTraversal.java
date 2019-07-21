package binarytrees.spiralorder;

public class SpiralOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);

		printSpiral(tree.root);
	}

	private static void printSpiral(Node node) {
		int height = heightOfTree(node);
		System.out.println("heightOfTree = " + height);

		boolean printFromLeftToRight = false;

		for (int i = 1; i <= height; i++) {
			printAtGivenLevel(node, i, printFromLeftToRight);
			printFromLeftToRight = !printFromLeftToRight;
		}
	}

	private static void printAtGivenLevel(Node node, int level, boolean printFromLeftToRight) {
		if(node == null) {
			return;
		}{
			if(level == 1) {
				System.out.print(node.data+" ");
			}else {
				if(printFromLeftToRight) {
					//print left first
					printAtGivenLevel(node.left, level-1, printFromLeftToRight);
					printAtGivenLevel(node.right, level-1, printFromLeftToRight);
				}else {
					//print right first
					printAtGivenLevel(node.right, level-1, printFromLeftToRight);
					printAtGivenLevel(node.left, level-1, printFromLeftToRight);
				}
			}
			
		}
	}

	private static int heightOfTree(Node node) {
		if (node == null) {
			return 0;
		} else {
			int leftNodeHeight = heightOfTree(node.left);
			int rightNodeHeight = heightOfTree(node.right);

			if (leftNodeHeight > rightNodeHeight) {
				return leftNodeHeight + 1;
			} else {
				return rightNodeHeight + 1;
			}
		}
	}
}
