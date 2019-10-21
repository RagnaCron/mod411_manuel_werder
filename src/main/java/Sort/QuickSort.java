package Sort;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	private void medianOfThree(T[] list, int leftSide, int rightSide) {
		if (rightSide - leftSide > 3) {
			int middle = (leftSide + rightSide) / 2;
			if (list[leftSide].compareTo(list[middle]) > 0) swap(list, leftSide, middle);
			if (list[leftSide].compareTo(list[rightSide]) > 0) swap(list, leftSide, rightSide);
			else if (list[rightSide].compareTo(list[middle]) > 0) swap(list, rightSide, middle);
		}
	}

	@Override
	public void sort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}

//	Version 4 http://www.linux-related.de/index.html?coding/sort/sort_quick.htm
//	Fastest version!
	private void quickSort(T[] list, int leftSide, int rightSide) {
		if (rightSide > leftSide){
			int i = leftSide - 1;
			int j = rightSide;
			medianOfThree(list, leftSide, rightSide);
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

//	Version 1 http://www.linux-related.de/index.html?coding/sort/sort_quick.htm
//	private void quickSort(T[] list, int leftSide, int rightSide) {
//		if (rightSide > leftSide){
//			int i = leftSide - 1;
//			int j = rightSide;
//			medianOfThree(list, leftSide, rightSide);
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

//	Version 2 https://de.wikipedia.org/wiki/Quicksort
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

//	version 3 simple changes through me
//	private void quickSort(T[] list, int leftSide, int rightSide) {
//		if (rightSide > leftSide) {
//			int i = leftSide;
//			int j = rightSide - 1;
//			medianOfThree(list, leftSide, rightSide);
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
