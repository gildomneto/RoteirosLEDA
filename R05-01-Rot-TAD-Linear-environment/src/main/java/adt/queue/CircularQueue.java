package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (isEmpty()) {
			this.head = 0;
			this.tail = 0;
			this.array[0] = element;
			elements++;
		} else {
			tail = (tail + 1) % array.length;
			this.array[tail] = element;
			elements++;
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T value = array[head];

		if (this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
			this.elements = 0;
		} else {
			this.head = ((this.head + 1) % array.length);
			this.elements--;
		}
		return value;
	}

	@Override
	public T head() {
		if (this.isEmpty()) {
			return null;
		}
		return this.array[head];
	}

	@Override
	public boolean isEmpty() {
		return (this.elements == 0);
	}

	@Override
	public boolean isFull() {
		return (this.elements == array.length);
	}

}
