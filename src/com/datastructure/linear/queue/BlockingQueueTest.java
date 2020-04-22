package com.datastructure.linear.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
	 public static void main(String[] args){
	    	BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

	        new Thread(new Producer(queue)).start();
	        new Thread(new Consumer(queue)).start();
	    }
}