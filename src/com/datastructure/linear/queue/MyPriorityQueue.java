package com.datastructure.linear.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyPriorityQueue {
	private Task[] heap;
	private int heapSize, capacity;

	/** Constructor **/
	public MyPriorityQueue(int capacity) {
		this.capacity = capacity + 1;
		heap = new Task[this.capacity];
		heapSize = 0;
	}
	public MyPriorityQueue() {
		this.capacity = 11;
		heap = new Task[this.capacity];
		heapSize = 0;
	}

	/** function to clear **/
	public void clear() {
		heap = new Task[capacity];
		heapSize = 0;
	}

	/** function to check if empty **/
	public boolean isEmpty() {
		return heapSize == 0;
	}

	/** function to check if full **/
	public boolean isFull() {
		return heapSize == capacity - 1;
	}

	/** function to get Size **/
	public int size() {
		return heapSize;
	}

	/** function to insert task **/
	// public void insert(String job, int priority)
	public void insert(List<Task> tasklist) {
		for (Task t : tasklist) {
			Task newJob = new Task(t.job, t.priority);

			heap[++heapSize] = newJob;
			int pos = heapSize;
			while (pos != 1 && newJob.priority > heap[pos / 2].priority) {
				heap[pos] = heap[pos / 2];
				pos /= 2;
			}
			heap[pos] = newJob;
		}
//		System.out.println(Arrays.toString(heap));
	}

	/** function to remove task **/
	public Task remove() {
		int parent, child;
		Task item, temp;
		if (isEmpty()) {
			System.out.println(""
					+ "queue Heap is empty");
			return null;
		}

		item = heap[1];
		temp = heap[heapSize--];

		parent = 1;
		child = 2;
		while (child <= heapSize) {
			if (child < heapSize && heap[child].priority < heap[child + 1].priority)
				child++;
			if (temp.priority >= heap[child].priority)
				break;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;

		return item;
	}

	@Override
	
	public String toString() {
		return "MyPriorityQueue [heap=" + Arrays.toString(heap) + ", heapSize=" + heapSize + ", capacity=" + capacity
				+ "]";
	}

	public static void main(String[] args) {
		{
			List<Task> listTask = new ArrayList<Task>();
			listTask.add(new Task("Job1", 1));
//			listTask.add(null);
			listTask.add(new Task("Job2", 2));
			listTask.add(new Task("Job3", 6));
			listTask.add(new Task("Job4", 4));
			listTask.add(new Task("job7", 4));
			listTask.add(new Task("Job5", 5));
			listTask.add(new Task("job6", 9));
			listTask.add(new Task("job7", 4));
			listTask.add(new Task("job8", 5));
			MyPriorityQueue mpq= new MyPriorityQueue(listTask.size());
//			MyPriorityQueue mpq= new MyPriorityQueue();
			mpq.insert(listTask);
//			System.out.println(mpq.toString());
			/*for(int i=0;i<listTask.size();i++){
			Task t=mpq.remove();
			System.out.println(t.toString());}*/
//			System.out.println(mpq);
			System.out.println(Arrays.toString(mpq.heap));
			System.out.println(mpq.isEmpty());
			System.out.println(mpq.isFull());
			System.out.println(mpq.capacity);
			mpq.clear();
			System.out.println(mpq);
			System.out.println(Arrays.toString(mpq.heap));
			
			
//			System.out.println(mpq.toString());
			/*Scanner scan = new Scanner(System.in);
			System.out.println("Priority Queue Test\n");

			System.out.println("Enter size of priority queue ");
			MyPriorityQueue pq = new MyPriorityQueue(scan.nextInt());

			char ch;
			 Perform Priority Queue operations 
			do {
				System.out.println("\nPriority Queue Operations\n");
				System.out.println("1. insert");
				System.out.println("2. remove");
				System.out.println("3. check empty");
				System.out.println("4. check full");
				System.out.println("5. clear");
				System.out.println("6. size");

				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter job name and priority");
					pq.insert(scan.next(), scan.nextInt());
					break;
				case 2:
					System.out.println("\nJob removed \n\n" + pq.remove());
					break;
				case 3:
					System.out.println("\nEmpty Status : " + pq.isEmpty());
					break;
				case 4:
					System.out.println("\nFull Status : " + pq.isFull());
					break;
				case 5:
					System.out.println("\nPriority Queue Cleared");
					pq.clear();
					break;
				case 6:
					System.out.println("\nSize = " + pq.size());
					break;
				default:
					System.out.println("Wrong Entry \n ");
					break;
				}

				System.out.println("\nDo you want to continue (Type y or n) \n");
				ch = scan.next().charAt(0);
			} while (ch == 'Y' || ch == 'y');
*/		}
	}
}
