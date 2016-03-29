package diakabana.datastructures.practice;

/**
 * Interface <tt>Bag</tt> describes the operations of a bag of objects
 * 
 * @author Bethy Diakabana
 * @since 11/27/2015
 * @param <T>
 *            A <tt>Bag</tt> object
 */
public interface Bag<T> {

	/**
	 * Gets the current numbers of entries in <tt>Bag</tt>
	 * 
	 * @return the integer number of entries currently in bag
	 */
	public int getCurrentSize();

	/**
	 * Sees whether this bag is full
	 * 
	 * @return true if bag is full
	 */
	public boolean isFull();

	/**
	 * Sees whether this bag is empty
	 * 
	 * @return true if bag is empty
	 */
	public boolean isEmpty();

	/**
	 * Adds a new entry to the bag.
	 * 
	 * @param newEntry
	 *            the object to be added as a new entry
	 * @return true if the addition is successful.
	 */
	public boolean add(T newEntry);

	/**
	 * Removes one unspecified entry from the bag if possible.
	 * 
	 * @return the removed entry if removal was successful, or null
	 */
	public T remove();

	/**
	 * Removes one occurrence of a given entry from the bag if possible.
	 * 
	 * @param anEntry
	 *            the entry to be removed
	 * @return true if the removal was successful
	 */
	public boolean remove(T anEntry);

	/**
	 * Removes all entries form bag
	 */
	public void clear();

	/**
	 * Counts the number of times a given entry appears in the bag.
	 * 
	 * @param anEntry
	 *            the entry to be counted
	 * @return the number of times an entry appears in the bag.
	 */
	public int getFrequency(T anEntry);

	/**
	 * Tests whether the bag contains a given entry.
	 * 
	 * @param anEntry
	 *            an entry to locate
	 * @return true if the bag contains the entry
	 */
	public boolean contains(T anEntry);

	/**
	 * Creates an array of all entries that are in the bag.
	 * 
	 * @return a newly allocated array of all entries in the bag.
	 */
	public T[] toArray();
} // end interface Bag
