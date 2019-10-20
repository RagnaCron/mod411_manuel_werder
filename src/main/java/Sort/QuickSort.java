package Sort;

import java.util.function.Predicate;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}

//	Version 1
	private void quickSort(T[] list, int leftSide, int rightSide) {
		if (rightSide > leftSide){
			int i = leftSide - 1;
			int j = rightSide;
			while (true) {
				while (list[++i].compareTo(list[rightSide]) < 0);
				while (list[--j].compareTo(list[rightSide]) > 0 && j > i);
				if (i >= j) break;
				swap(list, i, j);
			}
			swap(list, i, rightSide);
			quickSort(list, leftSide, i - 1);
			quickSort(list, i + 1, rightSide);
		}
	}

	private void swap(T[] list, int i, int j) {
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

//	Version 1
//	private void quickSort(T[] list, int leftSide, int rightSide) {
//		if (rightSide > leftSide){
//			int i = leftSide - 1;
//			int j = rightSide;
//			while (true) {
//				while (list[++i].compareTo(list[rightSide]) < 0);
//				while (list[--j].compareTo(list[rightSide]) > 0 && j > i);
//				if (i >= j) break;
//				swap(list, i, j);
//			}
//			swap(list, i, rightSide);
//			quickSort(list, leftSide, i - 1);
//			quickSort(list, i + 1, rightSide);
//		}
//	}

//	Version 2
//	private void quickSort(T[] list, int leftSide, int rightSide) {
//		if (rightSide > leftSide){
//			int divider = divide(list, leftSide, rightSide);
//			quickSort(list, leftSide, divider - 1);
//			quickSort(list, divider + 1, rightSide);
//		}
//	}
//
//	private int divide(T[] list, int leftSide, int rightSide) {
//		int i = leftSide;
//		int j = rightSide - 1;
//		T pivot = list[rightSide];
//		do {
//			while (i < rightSide && list[i].compareTo(pivot) < 0) i++;
//			while( j > leftSide && list[j].compareTo(pivot) >= 0) j--;
//			if (i < j) swap(list, i, j);
//		} while (i < j);
//		swap(list, i, rightSide);
//		return i;
//	}

//	version 3
//	private void quickSort(T[] list, int leftSide, int rightSide) {
//		if (leftSide < rightSide) {
//			int i = leftSide;
//			int j = rightSide - 1;
//			do {
//				while (i < rightSide && list[i].compareTo(list[rightSide]) < 0) i++;
//				while( j > leftSide && list[j].compareTo(list[rightSide]) >= 0) j--;
//				if (i < j) swap(list, i, j);
//			} while (i < j);
//			swap(list, i, rightSide);
//			quickSort(list, leftSide, i - 1);
//			quickSort(list, i + 1, rightSide);
//		}
//	}
}
