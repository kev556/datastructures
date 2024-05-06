package ht;

import java.util.NoSuchElementException;

/**
 * 	Kevin Li N00969115
 */

public class SimpleHashTable<K, V> 
{
	
	// instance vars:
	// an array of SimpleEntry called hashtable, use generics on declaration	
	private SimpleEntry<K,V> hashtable[];
	private int size;
	
	
	// default constructor, instantiate the array to size 5
	@SuppressWarnings("unchecked")
	public SimpleHashTable() {
		size = 5;
		hashtable = new SimpleEntry[size];
	}
	
	/**
	 * Puts an entry into the hashtable given the key and the value
	 * 
	 * When there is a collision, this implementation of hashtable will OVERWRITE the previous entry
	 * 
	 * @param key :the key for the hashtable entry 
	 * @param value :the value for the hashtable entry 
	 */
	public void put(K key, V value) {
		// Hashtables do not accept null keys or values.
		if (key == null || value == null)
			throw new NoSuchElementException("oops");
		/**
		 *  The method for compression in an hashtable is hashcode % size of table.
		 *  As it is possible for hashcodes to be negative, the abs() function is 
		 *  necessary to prevent negative indices.
		 */ 
		hashtable[Math.abs(key.hashCode()) % size] = new SimpleEntry<K,V>(key, value);
	}
	
	// return Value based on key or throw NoSuchElementException if it doesn't exist 
	public V get(K key) {
		if (hashtable[key.hashCode()] == null)
			throw new NoSuchElementException("Element does not exist");
		/** Hashes the key, getting the entry from the table using the same algorithm
		 * 	used to put it there. Obtains the value of the entry, then returns it.
		 */
		return hashtable[Math.abs(key.hashCode()) % size].getValue();
	}
	
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (SimpleEntry<K,V> se : hashtable)
			sb.append(se + "\n");
		
		return sb.toString();
	}
	
	
}
