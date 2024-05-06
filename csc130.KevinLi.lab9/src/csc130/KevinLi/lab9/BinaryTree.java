package csc130.KevinLi.lab9;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	protected class BinaryNode<E> {
		private E data;
		private BinaryNode<E> left;
		private BinaryNode<E> right;

		public BinaryNode() {
			data = null;
			left = right = null;
		}

		public BinaryNode(E d) {
			data = d;
			left = right = null;
		}

		/**
		 * @return the data
		 */
		public E getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		public void setData(E data) {
			this.data = data;
		}

		/**
		 * @return the left
		 */
		public BinaryNode<E> getLeft() {
			return left;
		}

		/**
		 * @param left the left to set
		 */
		public void setLeft(BinaryNode<E> left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public BinaryNode<E> getRight() {
			return right;
		}

		/**
		 * @param right the right to set
		 */
		public void setRight(BinaryNode<E> right) {
			this.right = right;
		}
		public String toString() {
			return data.toString();
		}
	}

	private BinaryNode<T> root;
	private int size;

	public BinaryTree() {
	}

	public void insert(T d) {
		root = insert(d, root);
		if (root != null)
			size++;
	}

	private BinaryNode<T> insert(T info, BinaryNode<T> root) {
		if (root == null)
			return new BinaryNode<T>(info); // root (top/first) node
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode<T> element = queue.remove();
			if (element != null) {
				if (element.left == null) {
					element.left = new BinaryNode<T>(info);
					return root;
				} else
					queue.add(element.left);

				if (element.right == null) {
					element.right = new BinaryNode<T>(info);
					return root;
				} else
					queue.add(element.right);
			}
		}
		return root;
	}

	public int getSize() {
		return size;
	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(BinaryNode<T> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public void inorder() {
		inorder(root);
		System.out.println();
	}

	private void inorder(BinaryNode<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(BinaryNode<T> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
	public void levelOrderPrint() {
		levelOrderPrint(root);
	}
	private void levelOrderPrint(BinaryNode<T> root) {
		Queue<BinaryNode<T>> queue = new LinkedList<BinaryNode<T>>();
		List<BinaryNode<T>> list = new LinkedList<BinaryNode<T>>();
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

}
