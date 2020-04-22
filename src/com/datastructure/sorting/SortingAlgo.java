package com.datastructure.sorting;

import java.util.Arrays;

public class SortingAlgo {
	public static int[] bubbleSort(int[] input) {
		System.out.println(Arrays.toString(input));
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length - 1 - i; j++) {
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
			System.out.print("Iteration " + (i + 1) + ": ");
			System.out.println(Arrays.toString(input));
		}
		return input;
	}

	public static int[] insertionSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			int valueToSort = arr[i];
			int j;
			for (j = i; j > 0 && arr[j - 1] > valueToSort; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = valueToSort;
			System.out.print("Iteration " + (i) + ": ");
			System.out.println(Arrays.toString(arr));
		}

		return arr;
	}

	public static int[] selectionSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[index])
					index = j;

			int smallerNumber = arr[index];
			arr[index] = arr[i];
			arr[i] = smallerNumber;
			System.out.print("Iteration " + (i) + ": ");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

	public static void buildheap(int[] arr) {
		for (int i = (arr.length - 1) / 2; i >= 0; i--) {
			heapify(arr, i, arr.length - 1);
		}
	}

	public static void heapify(int[] arr, int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max;
		if (left <= size && arr[left] > arr[i]) {
			max = left;
		} else {
			max = i;
		}

		if (right <= size && arr[right] > arr[max]) {
			max = right;
		}
		// If max is not current node, exchange it with max of left and right
		// child
		if (max != i) {
			exchange(arr, i, max);
			heapify(arr, max, size);
		}
	}

	public static void exchange(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static int[] heapSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		buildheap(arr);
		int sizeOfHeap = arr.length - 1;
		for (int i = sizeOfHeap; i > 0; i--) {
			exchange(arr, 0, i);
			sizeOfHeap = sizeOfHeap - 1;
			heapify(arr, 0, sizeOfHeap);
			System.out.print("Iteration " + (i) + ": ");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

	static int[] bucketSort(int[] nums, int max_value) {
		// Bucket Sort
		int[] Bucket = new int[max_value + 1];
		int[] sorted_nums = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			Bucket[nums[i]]++;
		int outPos = 0;
		for (int i = 0; i < Bucket.length; i++)
			for (int j = 0; j < Bucket[i]; j++)
				sorted_nums[outPos++] = i;
		return sorted_nums;
	}

	static int max_value(int[] nums) {
		int max_value = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] > max_value)
				max_value = nums[i];
		return max_value;
	}

	public static void main(String[] args) {
		int[] input = { 2, 1, 9, 6, 4, 3, 5 };
		// TODO Auto-generated method stub
		// System.out.println(Arrays.toString(bubbleSort(input)));
		// System.out.println(Arrays.toString(insertionSort(input)));
		// System.out.println(Arrays.toString(selectionSort(input)));
		// System.out.println(Arrays.toString(heapSort(input)));
		System.out.println(Arrays.toString(bucketSort(input, max_value(input))));
	}

}
