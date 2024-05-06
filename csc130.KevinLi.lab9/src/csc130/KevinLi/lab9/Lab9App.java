package csc130.KevinLi.lab9;

public class Lab9App {

	public static void main(String[] args) {
		
		int[] arr = new int[] {6,11,9,7,4,5,10,2,19,28,1};
		
		System.out.println("Binary Search Tree\n");
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		for (int i : arr) {
			bst.insert(i);
		}
		
		bst.inOrder();
		bst.preOrder();
		bst.postOrder();
		bst.levelOrderPrint();
		System.out.println(bst.height());
		
		System.out.println("\nBinary Tree\n");
		BinaryTree<Integer> bt = new BinaryTree<Integer>();
		for (int i : arr)
			bt.insert(i);
		bt.inorder();
		bt.preorder();
		bt.postorder();
		bt.levelOrderPrint();
		
		System.out.println("\nHeap\n");
		
		BinaryTree<Integer> heap = new BinaryTree<Integer>();
		BinarySearchTree.buildHeap(arr, arr.length);
		for (int i : arr) 
			heap.insert(i);
		
		heap.levelOrderPrint();
		
		
	}

}
