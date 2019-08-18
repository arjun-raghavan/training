package queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CastleOnTheGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// breadthFirstSearch();
		
		System.out.println(""+diagonalTraverse());
	}

	static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
		return goalY;
	}

	static final int[] X_OFFSETS = { -1, 0, 1, 0 };
	static final int[] Y_OFFSETS = { 0, 1, 0, -1 };
	
	static int diagonalTraverse() {
		int startX = 0;
		int startY = 0; 
		int goalX = 0;
		int goalY = 3;
		
		int[][] array2D = new int[][] { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int array2DSize = array2D.length;

		int[][] traverseArray = new int[array2DSize][array2DSize];
		
		for(int[] array : traverseArray) {
			Arrays.fill(array, -1);
		}
		
		traverseArray[startX][startY] = 0;
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.offer(new Node(startX, startY));
		System.out.println("("+startX+","+startY+") - "+traverseArray[startX][startY]);
		while(true) {
			Node head = nodeQueue.poll();
			
			for(int i = 0; i < X_OFFSETS.length; i++) {
				int nextX = head.x;
				int nextY = head.y;
				
				while (isNotBlocked(array2D, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
					nextX += X_OFFSETS[i];
					nextY += Y_OFFSETS[i];

					if (nextX == goalX && nextY == goalY) {
						return traverseArray[head.x][head.y] + 1;
					}

					if (traverseArray[nextX][nextY] < 0) {
						traverseArray[nextX][nextY] = traverseArray[head.x][head.y] + 1;
						nodeQueue.offer(new Node(nextX, nextY));
						System.out.println("("+nextX+","+nextY+") - "+traverseArray[nextX][nextY]);
					}
				}
				
			}
		}
		
		
	}

	static boolean isNotBlocked(int[][] grid, int x, int y) {
		return x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == 0;
	}
	
	static void breadthFirstSearch() {
		int[][] array2D = new int[][] { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int[][] traverseArray = new int[array2D.length][array2D.length];

		

		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				if ((i == 0) && (j == 0)) {
					// first index
					traverseArray[i][j] = 0;
					continue;
				}

				if (array2D[i][j] == 1) {
					// obstacle
				} else {
					int valueAtIJ = traverseArray[i][j];
					Set<Integer> values = new HashSet<Integer>();

					int leftValue = 0;
					if ((j - 1) >= 0) {
						leftValue = traverseArray[i][j - 1];
						values.add(leftValue);
					}

					int rightValue = 0;
					if ((j + 1) < array2D[i].length) {
						rightValue = traverseArray[i][j + 1];
						values.add(rightValue);
					}

					int topValue = 0;
					if ((i - 1) >= 0) {
						topValue = traverseArray[i - 1][j];
						values.add(topValue);
					}

					int bottomValue = 0;
					if ((i + 1) < array2D.length) {
						bottomValue = traverseArray[i + 1][j];
						values.add(bottomValue);
					}

					if (values.isEmpty()) {

					} else {
						int max = Collections.max(values);
						if (valueAtIJ == 0) {
							traverseArray[i][j] = (max + 1);
						} else {
							if ((max + 1) <= valueAtIJ) {
								traverseArray[i][j] = (max + 1);
							}
						}
					}

				}

			}
		}

		print2D(array2D);
		System.out.println("");
		print2D(traverseArray);

	}

	public static void print2D(int mat[][]) {
		// Loop through all rows
		for (int i = 0; i < mat.length; i++) {

			// Loop through all elements of current row
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");

			System.out.println();
		}

	}

	
}

class Node {
	public int x;
	public int y;

	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
