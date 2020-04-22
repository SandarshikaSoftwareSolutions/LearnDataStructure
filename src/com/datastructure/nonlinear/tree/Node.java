package com.datastructure.nonlinear.tree;

class Node {
	int value;
	Node left, right;

	Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
	}
	
}