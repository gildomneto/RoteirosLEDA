package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer retorno = null;
		if (array.length > 0){
			insertAuxiliar(array);
			if(comparator.compare(1, 2) > 0){
				retorno = floorMinHeap(numero, null);

			} else {
				retorno = floorMaxHeap(numero, null);
			}
		}
		return retorno;
	}

	private void insertAuxiliar(Integer[] array){
		this.heap = new Integer[array.length];
		this.index = -1;
		for (Integer numero : array){
			insert(numero);
		}
	}

	private Integer floorMinHeap(double numero, Integer floor) {
		Integer floorMin = floor;
		if (!isEmpty()) {
			if (rootElement() == numero) {
				floorMin = rootElement();
			} else if (rootElement() < numero) {
				Integer root = extractRootElement();
				floorMin = floorMinHeap(numero, root);
			}
		}
		return floorMin;
	}

	private Integer floorMaxHeap(double numero, Integer floor) {
		Integer floorMax = floor;
		if (!isEmpty()) {
			if (rootElement() <= numero) {
				floorMax = rootElement();
			} else {
				extractRootElement();
				floorMax = floorMaxHeap(numero, floor);
			}
		}
		return floorMax;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		this.index = -1;
		for (Integer i : array) {
			this.insert(i);
		}
		if(!isEmpty()) {
			for (int i = 0; i < array.length; i++) {
				if(this.rootElement() == numero) ceil = this.rootElement();

				else if(this.rootElement() > numero) {
					if(ceil == null || ceil > this.rootElement()) ceil = this.rootElement();
				}

				else {
					this.extractRootElement();
				}
			}
		}
		return ceil;
	}

}
