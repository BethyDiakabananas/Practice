package diakabana.datastructures.practice;

/**
 * Class <tt>ArrayBag</tt> stores <tt>Bag</tt> entries in a fixed-size array
 * 
 * @author Bethy Diakabana
 * @since 11/27/2015
 * @param <T>
 *            A <tt>Bag</tt> type
 */
public class ArrayBag<T> implements Bag<T> {
	private final T[] bag;
	private final static int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;

	/**
	 * Creates an empty bag with an initial capacity of 25 entries
	 */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end constructor

	/**
	 * Creates an empty bag having a given initial capacity
	 * 
	 * @param capacity
	 *            the integer capacity of the <tt>ArrayBag</tt>
	 */
	public ArrayBag(int capacity) {
		numberOfEntries = 0;
		// array contains null entries, therefore cast is safe
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[]) new Object[capacity]; // unchecked cast
		bag = tempBag;
	} // end constructor

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	} // end method getCurrentSize

	@Override
	public boolean isFull() {
		return numberOfEntries == bag.length;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		boolean isSuccessful = true;
		if (isFull())
			isSuccessful = false;
		else {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		return isSuccessful;
	} // end method add

	@Override
	public T remove() {
		T removedItem = null;
		if (numberOfEntries > 0) {
			numberOfEntries--;
			removedItem = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		} // end if
		return removedItem;
	} // end method remove

	@Override
	public boolean remove(T anEntry) {
		int index = getIndexOf(anEntry);
		T removedEntry = removeEntry(index);
		return anEntry.equals(removedEntry);
	} // end method remove

	@Override
	public void clear() {
		while (!isEmpty())
			remove();
	} // end method clear

	@Override
	public int getFrequency(T anEntry) {
		int frequency = 0;
		for (int i = 0; i < numberOfEntries; i++) {
			if (anEntry.equals(bag[i]))
				frequency++;
		} // end for
		return frequency;
	} // end method getFrequency

	@Override
	public boolean contains(T anEntry) {
		return getIndexOf(anEntry) > -1;
		// return getFrequency(anEntry) > 0;
	} // end method contains

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int i = 0; i < numberOfEntries; i++)
			result[i] = bag[i];
		return result;
	} // end method toArray

	/**
	 * Removes the entry at the given index within the <tt>ArrayBag</tt>.
	 * 
	 * @param givenIndex
	 *            index of element to be removed
	 * @return removed element
	 */
	private T removeEntry(int givenIndex) {
		T removedEntry = null;
		if (!isEmpty() && (givenIndex >= 0)) {
			removedEntry = bag[givenIndex];
			numberOfEntries--;
			bag[givenIndex] = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		} // end if
		return removedEntry;
	} // end method removeEntry

	/**
	 * Locates a given entry within the <tt>ArrayBag</tt>
	 * 
	 * @param anEntry
	 *            given index
	 * @return index of the entry
	 */
	private int getIndexOf(T anEntry) {
		int index = -1;
		boolean stillLooking = true;
		for (int i = 0; stillLooking && (i < numberOfEntries); i++) {
			if (anEntry.equals(bag[i])) {
				stillLooking = false;
				index = i;
			} // end if
		} // end for
		return index;
	}

}
