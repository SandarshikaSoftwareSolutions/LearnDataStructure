package com.datastructure.linear.stack;

import java.util.Arrays;

public class MyCustomStack {
	private int arr[];
	private int top;
	private int capacity;

	public MyCustomStack(int size) {
		{
			arr = new int[size];
			capacity = size;
			top = -1;
		}
	}

	public Boolean isFull() {
		return top == capacity - 1; // or return size() == capacity;
	}

	public Boolean isEmpty() {
		return top == -1; // or return size() == 0;
	}

	public int peek() {
		if (!isEmpty()) {
			System.out.println("Pointer in stack at index : " + top);
			return arr[top];
		} else
			System.exit(1);

		return -1;
	}

	public int size() {
		return top + 1;
	}

	public void push(int element) {
		if (isFull()) {
			System.out.println("OverFlow And element " + element + " is NOT INSERTED And the Program Terminated\n");
			System.exit(1);
		}

		System.out.println("Inserting " + element);
		arr[++top] = element;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("UnderFlow\nProgram Terminated\n");
			System.exit(1);
		}
		System.out.println("Removing " + peek());

		return arr[top--];
	}
	

	@Override
	public String toString() {
		return "MyCustomStack [arr=" + Arrays.toString(arr) + ", top=" + top + ", capacity=" + capacity + "]";
	}

	public static MyCustomStack sortStack(MyCustomStack stack) {
		MyCustomStack tempStack = new MyCustomStack(stack.size());
		while (!stack.isEmpty()) {
			int currentData = stack.pop();
			while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
				stack.push(tempStack.pop());
			}
			tempStack.push(currentData);
		}
		return tempStack;
	}

	public static void main(String[] args) {
		MyCustomStack stack = new MyCustomStack(5);
		System.out.println("Size of stack is: " + stack.size());
		// System.out.println("Pointer in stack at : "+stack.peek());
		stack.push(8);
		stack.peek();
		System.out.println("Size of stack is: " + stack.size());
		stack.push(4);
		stack.peek();
		System.out.println("Size of stack is: " + stack.size());
		stack.push(6);
		stack.peek();
		System.out.println("Size of stack is: " + stack.size());
		stack.push(5);
		stack.peek();
		System.out.println("Size of stack is: " + stack.size());
		stack.push(7);
		stack.peek();
		System.out.println("Size of stack is: " + stack.size());
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		MyCustomStack s= stack.sortStack(stack);
		System.out.println(s.toString());
		/*System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());*/
	}

}
