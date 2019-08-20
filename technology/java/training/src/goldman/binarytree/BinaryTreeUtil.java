/**
 * 
 */
package goldman.binarytree;

/**
 * @author AR350758 BinaryTreeUtil.java Aug 20, 2019 8:24:17 PM
 */
public class BinaryTreeUtil {

	public static int heightOfTree(Node node) {
		if (node == null) {
			return 0;
		}

		int heightOfLeftNode = heightOfTree(node.left) + 1;
		int heightOfRightNode = heightOfTree(node.right) + 1;

		if (heightOfLeftNode > heightOfRightNode) {
			return heightOfLeftNode;
		} else {
			return heightOfRightNode;
		}
	}

	public static void spiralOrderTraversal(Node root) {

		int heightOfTree = heightOfTree(root);
		boolean fromLeftToRight = true;
		for (int i = 1; i <= heightOfTree; i++) {
			printAtGivenLevel(root, i, fromLeftToRight);
		}

	}

	private static void printAtGivenLevel(Node root, int i, boolean fromLeftToRight) {
		if (root == null) {
			return;
		}

		if (i == 1) {
			System.out.print(root.key);
			System.out.print(" ");
		} else {
			printAtGivenLevel(root.left, i - 1, fromLeftToRight);
			printAtGivenLevel(root.right, i - 1, fromLeftToRight);

		}

	}

}
