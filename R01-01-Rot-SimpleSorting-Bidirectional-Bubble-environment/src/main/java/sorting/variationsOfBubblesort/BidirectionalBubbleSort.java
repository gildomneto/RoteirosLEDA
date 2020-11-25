package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
			for (int i = leftIndex; i < rightIndex; i++) {
				for (int j = i + 1; j < rightIndex + 1; j++) {
					if (array[i].compareTo(array[j]) > 0) {
						Util.swap(array, i, j);
					}
				}
				for (int m = rightIndex - i; m > i; m--) {
					if (array[m - 1].compareTo(array[m]) > 0) {
						Util.swap(array, m, m - 1);
					}
				}
			}
	}
}
