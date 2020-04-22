package com.datastructure.linear.list;

public class MyLinkedList {
	static Node head;
	static int size=0;
	public static int incrementSize(){
		return size++;
	}
	public static int decrementSize(){
		return size--;
	}

	public static MyLinkedList insertAtEnd(MyLinkedList list, int nodeValue) {
		Node node = new Node(nodeValue);
		if (list.head == null) {
			head = node;
			incrementSize();
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = node;
			incrementSize();
		}
		return list;
	}

	public static MyLinkedList insertAfterNode(MyLinkedList list, int nodeValue, int nodeToInsert) {
		Node node = new Node(nodeToInsert);
		Node n = list.head;
		while (n.data != nodeValue) {
			n = n.next;
		}
		Node temp = n.next;
		n.next = node;
		node.next = temp;
		incrementSize();
		return list;
	}

	public static MyLinkedList insertAsFirstNode(MyLinkedList list, int value) {
		Node node = new Node(value);
		Node n = list.head;
		Node temp;
		temp=list.head;
		list.head =node;
		node.next=temp;
		incrementSize();
		return list;
	}

	public static MyLinkedList deleteNodeAtLast(MyLinkedList list, int toDelete){
		Node n = list.head;
		Node temp = null;
		while (n.data != toDelete) {
			temp=n;
			n = n.next;
		}
		temp.next=null;
		decrementSize();
		return list;
	}
	public static MyLinkedList deleteNodeAtFirst(MyLinkedList list, int toDelete){
		Node n = list.head;
		list.head=n.next;
		decrementSize();
		return list;
	}
	public static MyLinkedList deleteNodeAfterNode(MyLinkedList list, int toDelete){
		Node n = list.head;
		Node temp = null;
		while (n.data != toDelete) {
			temp=n;
			n = n.next;
		}
		temp.next=n.next;
		decrementSize();
	return list;	
	}
	public static void printlist(MyLinkedList node) {
		Node head = node.head;
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		MyLinkedList ll = new MyLinkedList();
		System.out.println("Size of list is :"+size);
		ll.insertAtEnd(ll, 1);
		System.out.println("Size of list is after 1st element :"+size);
		ll.insertAtEnd(ll, 2);System.out.println("Size of list is after 2nd element:"+size);
		ll.insertAtEnd(ll, 3);System.out.println("Size of list is after 3rd element:"+size);
		ll.insertAtEnd(ll, 4);System.out.println("Size of list is after 4th element:"+size);
		ll.insertAtEnd(ll, 5);System.out.println("Size of list is after 5th element:"+size);
		ll.insertAtEnd(ll, 6);System.out.println("Size of list is after 6th element:"+size);
		System.out.println("print list befor insertion of 22 is : "+size);
//		printlist(ll);
		
		ll.insertAfterNode(ll, 2, 22);
		System.out.println("print list After insertion of 22 is : "+size);
		printlist(ll);
		ll.insertAsFirstNode(ll, 32);
		System.out.println("After insertion of current node as head to the list is : "+size);
		printlist(ll);
		deleteNodeAtLast(ll, 6);
		System.out.println("After deleting 6 the list is : "+size);
		printlist(ll);
		deleteNodeAtFirst(ll, 32);
		System.out.println("After deleting head Node 32 the list is : "+size);
		printlist(ll);
		deleteNodeAfterNode(ll, 22);
		System.out.println("After deleting head Node After 22 the list is : "+size);
		printlist(ll);
//		deleteNodeAfterNode(ll, 52);
	}

}
