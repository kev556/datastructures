package ht;

import java.util.Map;

/**
 * 	Kevin Li N00969115
 */

public class SimpleEntry<K, V> implements Map.Entry<K, V> {
	
	// declare two instance vars:
	// key of type K
	// value of type V
	private K key;
	private V value;
	
	
	// parameterized constructor, you know what to do
	public SimpleEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public K getKey() {
		return key;
	}
	
	@Override
	public V getValue() {
		return value;
	}
	
	// this must set the value to newValue but return the old value
	@Override
	public V setValue(V newValue) {
		V temp = value;
		value = newValue;
		return temp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SimpleEntry [key = " + key.toString());
		sb.append(" , value = " + value.toString() + "]");
		return sb.toString();
	}
		
	
	
}