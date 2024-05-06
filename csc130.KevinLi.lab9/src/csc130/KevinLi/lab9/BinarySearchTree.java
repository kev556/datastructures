package csc130.KevinLi.lab9;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	class BinaryNode<E extends Comparable<E>> {
		protected E data;
		protected BinaryNode<E> left, right;

		BinaryNode(E d) {
			data = d;
			left = right = null;
		}
		private int height(BinaryNode<T> node) {
			if(node == null)
			return -1;
			return(Math.max(height(node.left), height(node.right)) + 1);
		}
		public String toString() {
			return "" + data;
		}
	}

	private BinaryNode<T> root;
	
	public int height() {
		return root.height(root);
	}
	public void insert(T d) {
		root = insert(d, root);
	}

	public void preOrder() {
		System.out.println("\nPreorder:");
		preOrder(root);
	}

	public void inOrder() {
		System.out.println("\nInorder:");
		inOrder(root);
	}

	public void postOrder() {
		System.out.println("\nPostorder:");
		postOrder(root);
	}

	public void levelOrderPrint() {
		System.out.println("\nLevel order:");
		levelOrderPrint(root);
	}
	
	private BinaryNode<T> insert(T d, BinaryNode<T> root) {
		if (root == null)
			root = new BinaryNode<T>(d);
		else if (root.data.compareTo(d) > 0)
			root.left = insert(d, root.left);
		else
			root.right = insert(d, root.right);
		return root;
	}

	private void preOrder(BinaryNode<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private void inOrder(BinaryNode<T> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	private void postOrder(BinaryNode<T> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	private void levelOrderPrint(BinaryNode<T> root) {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		LinkedList<BinaryNode<T>> list = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> item = queue.remove();
			if (item != null) {
				list.add(item);
				if (item.left != null)
					queue.add(item.left);
				if (item.right != null)
					queue.add(item.right);
			}
		}
		System.out.println(list);
	}
	
	public static void buildHeap(int[] a,int size) {
		// start from last parent to first parent
		for(int i = size / 2 - 1; i >= 0; i--)
		heapify(a,i,size);
	}
	public static void heapify(int[] a, int i, int size) {
		int l = 2 * i + 1; // left child
		int r = 2 * i + 2; // right child
		int largest=i; // parent
		// find the larger of parent and left child
		if(l <= size-1 && a[l] > a[i])
		largest = l;
		else
		largest = i;
		// find the larger of parent and right child
		if(r <= size-1 && a[r] > a[largest])
		largest = r;
		// swap parent and larger child if necessary
		if(largest != i) {
		int temp = a[i];
		a[i] = a[largest];
		a[largest] = temp;
		// repeat heapify until all children are in a heap
		heapify(a, largest, size);
		}
	}
	
}