package com.datastructure.linear.queue;

import java.util.Arrays;

public class MyQueue {
	private int arr[];
	private int front;
	private int rear;
	private int capacity;
	private static int count;
	
	@Override
	public String toString() {
		return "[arr=" + Arrays.toString(arr) + ", front=" + front + ", rear=" + rear + ", capacity=" + capacity
				+  "]";
	}

	public MyQueue(int size) {
		arr = new int[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("UnderFlow Queur is EMPTY. Program Terminated");
			System.exit(1);
		}

		System.out.println("Removing element: " + arr[front]++);

		front = (front + 1) % capacity;
		count--;
	}

	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("OverFlow QUEUE is FULL. Program Terminated");
			System.exit(1);
		}

		System.out.println("Inserting " + item);

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("QUEUE is FULL. Program Terminated");
			System.exit(1);
		}
		return arr[front];
	}

	public static int size() {
		return count;
	}

	public Boolean isEmpty() {
		return (size() == 0);
	}

	public Boolean isFull() {
		return (size() == capacity);
	}

	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		queue.enqueue(4);
		System.out.println(queue);
		queue.enqueue(14);
		System.out.println(queue);
		queue.enqueue(24);
		System.out.println(queue);
		queue.enqueue(34);
		System.out.println(queue);
		queue.enqueue(44);
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
	}

}
