/*
Name: Jihyung Park
Date: 11/10/2021
Section: CS2336.504
Instructor: Mohamed Amine Belkoura

Program describe: Change basic merge sort method to sorting algorithm that can sort any comparable list. It have both merge sort method for
E and int. depend on argument,  it choose method and sort.
 */

package assignment;

import java.util.Date;

public class MergeSort {
	public static void mergeSort(int[] list) {
	    if (list.length > 1) {
	      // Merge sort the first half
	      int[] firstHalf = new int[list.length / 2];
	      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
	      mergeSort(firstHalf);

	      // Merge sort the second half
	      int secondHalfLength = list.length - list.length / 2;
	      int[] secondHalf = new int[secondHalfLength];
	      System.arraycopy(list, list.length / 2,
	        secondHalf, 0, secondHalfLength);
	      mergeSort(secondHalf);

	      // Merge firstHalf with secondHalf into list
	      merge(firstHalf, secondHalf, list);
	    }
	  }

	  /** Merge two sorted lists */
	  public static void merge(int[] list1, int[] list2, int[] temp) {
	    int current1 = 0; // Current index in list1
	    int current2 = 0; // Current index in list2
	    int current3 = 0; // Current index in temp

	    while (current1 < list1.length && current2 < list2.length) {
	      if (list1[current1] < list2[current2])
	        temp[current3++] = list1[current1++];
	      else
	        temp[current3++] = list2[current2++];
	    }

	    while (current1 < list1.length)
	      temp[current3++] = list1[current1++];

	    while (current2 < list2.length)
	      temp[current3++] = list2[current2++];
	  }

	/** The method for sorting the numbers */
	@SuppressWarnings("unchecked")
	public static <E extends Comparable<E>> void mergeSort(E[] list) {
		if (list.length > 1) {
			// Merge sort the first half
			E[] firstHalf = (E[]) (new Comparable[list.length / 2]);//we can not make array of E, so make array of comparable and cast to E
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

			mergeSort(firstHalf);

			// Merge sort the second half
			int secondHalfLength = list.length - list.length / 2;
			E[] secondHalf = (E[]) (new Comparable[secondHalfLength]);
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

			mergeSort(secondHalf);

			// Merge firstHalf with secondHalf into list
			merge(firstHalf, secondHalf, list);
		}

	}

	/** Merge two sorted lists */
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < list1.length && current2 < list2.length) {
			if (list1[current1].compareTo(list2[current2]) < 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}

		while (current1 < list1.length)
			temp[current3++] = list1[current1++];

		while (current2 < list2.length)
			temp[current3++] = list2[current2++];
	}

	/** A test method */
	public static void main(String[] args) {
		int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; //int list for test
		
		mergeSort(list);//list is int argument, so it call [mergeSort(int[] list)]
		
		for (int i = 0; i < list.length; i++)
		      System.out.print(list[i] + " ");
		
		System.out.println("");
		
		Date[] datelist = {new Date(20025689547l), new Date(34446954957l), new Date(22990000000l),
				new Date(58585689412l), new Date(67956898000l), new Date(105687456365l), new Date(34987400512l),
				new Date(125146636472l), new Date(125412566632l) }; //Date list for test
		
		mergeSort(datelist);//datelist is Date argument, so it call [<E extends Comparable<E>> void mergeSort(E[] list)]
		
		for (int i = 0; i < datelist.length; i++) {
			System.out.println("Date[" + i + "]= " + datelist[i].toString());
		}
	}
}
