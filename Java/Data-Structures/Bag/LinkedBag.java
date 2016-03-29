package diakabana.datastructures.practice;

public class LinkedBag<T> implements Bag<T> {
	private Node<T> firstNode;
	private int numberOfEntries;
	
	/**
	 * Constructs a new <tt>LinkedBag</tt> object
	 */
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;
	} // end constructor

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	} // end method getCurrentsize

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}

	@Override
	public boolean add(T newEntry) {
		// adds to the beginning of the chain
		Node<T> newNode = new Node<T>(newEntry);
		newNode.setNext(firstNode);
		firstNode = newNode;
		numberOfEntries++;
		return true;
	} // end method add

	@Override
	public T remove() {
		T removedEntry = null;
		if (firstNode != null) {
			removedEntry = firstNode.getData();
			firstNode = firstNode.getNext();
			numberOfEntries--;
		} // end if
		return removedEntry;
	} // end method remove

	@Override
	public boolean remove(T anEntry) {
		boolean isSuccessful = false;
		Node<T> nodeToRemove = getReferenceTo(anEntry);
		if (nodeToRemove != null) {
			nodeToRemove.setData(firstNode.getData());
			remove();
			isSuccessful = true;
		} // end if
		return isSuccessful;
	} // end method remove

	@Override
	public void clear() {
		while (!isEmpty())
			remove();
	} // end method clear

	@Override
	public int getFrequency(T anEntry) {
		int frequency = 0;
		int counter = 0;
		Node<T> currentNode = firstNode;
		while ((counter < numberOfEntries) & (currentNode != null)) {
			if (anEntry.equals(currentNode.getData()))
				frequency++;
			counter++;
			currentNode = currentNode.getNext();
		} // end while
		return frequency;
	} // end method getFrequency

	@Override
	public boolean contains(T anEntry) {
		return getReferenceTo(anEntry) != null;
	} // end method contains

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		int index = 0;
		Node<T> currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = (T) currentNode.getData();
			index++;
			currentNode = currentNode.getNext();
		} // end while;
		return result;
	} // end method toArray
	
	private Node<T> getReferenceTo(T anEntry) {
		boolean stillLooking = true;
		Node<T> currentNode = firstNode;
		int counter = 0;
		while (stillLooking && (counter < numberOfEntries)) {
			if (anEntry.equals(currentNode.getData()))
				stillLooking = false;
			else {
				currentNode = currentNode.getNext();
				counter++;
			}
		} // end while
		return currentNode;
	} // end method getReferenceTo
} // end class LinkedBag

