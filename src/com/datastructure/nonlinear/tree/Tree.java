package com.datastructure.nonlinear.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
	static Node node;

	public void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println(" Inserted " + value + " to left of " + node.value);
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println("  Inserted " + value + " to right of " + node.value);
				node.right = new Node(value);
			}
		}
	}

	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traverseInOrder(node.left);
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			traverseInOrder(node.right);
			System.out.print(" " + node.value);
		}
	}

	public void traverseLevelOrderInOneLine(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node tempNode = queue.remove();
			System.out.printf("%d ", tempNode.value);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	static List<Node> printGivenLevel(Node root, int level) {
		List<Node> list = new ArrayList<>();
		if (root == null)
			return list;
		if (level == 1) {
			list.add(root);
		} else if (level > 1) {
			list.addAll(printGivenLevel(root.left, level - 1));
			list.addAll(printGivenLevel(root.right, level - 1));
		}
		return list;
	}

	List<List<Node>> list = new ArrayList<>();

	public static List<List<Node>> printLevelOrderLinebyLine(Node root) {
		List<List<Node>> ll = new ArrayList<>();
		int h = maxDepth(root);
		int i;
		for (i = 1; i <= h; i++) {
			List<Node> node = printGivenLevel(root, i);
			ll.add(node);
		}
		for (List<Node> nodelist : ll) {
			for (Node node : nodelist) {
				System.out.print(node.value + " ");
			}
			System.out.println();
		}
		return ll;
	}

	static int maxDepth(Node node) {
		if (node == null)
			return 0;
		else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);

			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	private void leftViewOfTree(Node root) {
		List<List<Node>> lln = printLevelOrderLinebyLine(root);
		for (List<Node> nodelist : lln) {
			System.out.print(nodelist.get(0).value + " ");
		}
	}

	private void rightViewOfTree(Node root) {
		List<List<Node>> lln = printLevelOrderLinebyLine(root);
		for (List<Node> nodelist : lln) {
			System.out.print(nodelist.get(nodelist.size() - 1).value + " ");
		}
	}

	public static Node searchNode(int x, Node n) {
		if (n == null || n.value == x)
			return n;
		else if (n.value > x)
			return searchNode(x, n.left);
		else
			return searchNode(x, n.right);
	}

	public static Node findMinimum(Node root) {
		if (root == null)
			return null;
		else if (root.left != null)
			return findMinimum(root.left); 
		return root;
	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		Node root = new Node(5);
		System.out.println("Building tree with root value " + root.value);
		tree.insert(root, 2);
		tree.insert(root, 4);
		tree.insert(root, 8);
		tree.insert(root, 6);
		tree.insert(root, 7);
		tree.insert(root, 3);
		tree.insert(root, 9);
		System.out.println("Traversing tree in order");
		tree.traverseInOrder(root);
		System.out.println();
		System.out.println("Traversing tree pre order");
		tree.traversePreOrder(root);
		System.out.println();
		System.out.println("Traversing tree post order");
		tree.traversePostOrder(root);
		System.out.println();
		System.out.println("Traversing tree levelorder order");
		tree.traverseLevelOrderInOneLine(root);
		System.out.println();
		System.out.println("Traversing tree levelorder order line by line");
		tree.printLevelOrderLinebyLine(root);
		System.out.println();
		tree.leftViewOfTree(root);
		tree.rightViewOfTree(root);
		System.out.println(tree.searchNode(4, root));
		System.out.println(tree.findMinimum(root));
		
	}

}