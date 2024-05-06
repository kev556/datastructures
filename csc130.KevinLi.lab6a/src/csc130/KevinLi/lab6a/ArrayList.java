package csc130.KevinLi.lab6a;

/**
* <b>Title:</b> Lab 6a:<br>

* <b>Filename:</b> ArrayList.java<br>
* <b>Date Written:</b> November 16, 2023<br>
* <b>Due Date:</b> November 18, 2023<br>
* <p>
* <b>Description:</b><br>
* Class defining an ArrayList, a List implemented using an array. 
* Contains predefined methods, and methods written by yours truly.
* Functionality is tested in Lab6aApp.java.
* </p>
* <br>
* <p>
*</p>
*@author Kevin Li
*/

public class ArrayList<T> implements List<T> {
	/**
	 * The list - generic array of items
	 */
	protected T[] data;
	/**
	 * The number of items in the list
	 */
	protected int size;
	/**
	 * default maximum capacity
	 */
	private static final int CAPACITY = 100;

	/**
	 * default constructor - creates a list that can store 100 items;<br>
	 * the size of the list is initialized to 0
	 */
	public ArrayList() {
		this(CAPACITY); // using the parameterized constructor - note CAPACITY must be static
	}

	/**
	 * parameterized constructor - allows the user to specify the size of
	 * the list.<br>
	 * The list created can store at most <i>size</i> items; the size of the list is
	 * initialized to 0.
	 * 
	 * @param size
	 *   indicates the maximum size of the list as specified by the user
	 */
	public ArrayList(int size) {
		if (size <= 0)
			throw new RuntimeException("Invalid List Size");

		data = (T[]) new Object[size];
		size = 0;
	}
	
    /**
     * empty method - determines whether or not the list is empty
     * @return <i>true</i> if the list is empty; <i>false</i> otherwise
     */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * getSize method - returns the number of items in the list
	 * 
	 * @return the number of items in the list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * makeEmpty method - makes the list empty and sets the size to 0
	 */
	public void clear() {		
		if(size > 0) {
			size = 0;
			data = (T[]) new Object[data.length]; 
			System.gc();
		}
	}

	/**
	 * toString method - returns the state of the object as a String
	 * 
	 * @return a String containing the items in the list
	 */
	public String toString() {
		String str = "The list contains " + size + " items.\n[";
		if (!isEmpty()) {
			for (int i = 0; i < size; i++)
				str += i + "\t" + data[i] + "\n";
		}
		return str + "]";
	}

	public boolean contains(T searchItem) {
		return indexOf(searchItem) >= 0;
	}

	public T get(int index) {
		if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
	
		return data[index];
	}

	public T remove(int index) {
		if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
		T info = null;
		if(index >= 0) {
			info = data[index];
			// shift nodes to the left
			for(int i=index;i < size-1; i++)
				data[i] = data[i+1];
			data[--size] = null;
		}
		return info;
	}
	/**
	 * A private utility method that expands the array by doubling its size 
	 * @return <i>true</i> if the item can be expanded, <i>false</i> otherwise
	 */
	protected boolean expandCapacity() {
		if(size * 2 <= Integer.MAX_VALUE) {
			T[] tempData = (T[]) new Object[data.length * 2]; // create a new array
			for(int i=0; i < size; i++)  
				tempData[i] = data[i];   // copy the contents of the old to the new
			
			data = tempData;   // instance variable points to the new array
			System.gc();
			return true;
		}
		return false;		
	}
	
	// WRITTEN BY KEVIN LI
	/*********************************************************************************/
	
	/**
	 * Adds an item to the end of a list, adding list capacity if out of bounds
	 */
	public void add(T item) {
		if (size == data.length)
			expandCapacity();
		
		data[size++] = item;  // add item, increment the count
	}
	/**
	 * Finds the index of the item specified and removes said item using remove(int)
	 */
	public T remove(T removeItem) {
		int indexAt = indexOf(removeItem);
		T temp = remove(indexAt);
		return temp;
	}
	/**
	 * Loops through the array to find an object equivalent to the searchItem, returning it 
	 * when found. returns -1 if not found
	 */
	public int indexOf(T searchItem) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(searchItem)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Loops through the array to find an object equivalent to the searchItem, storing the index 
	 * in indexOf when found. Returns the last object in the list equivalent to searchItem. returns -1 if not found
	 */
	public int lastIndexOf(T searchItem) {
		int indexOf = -1;
		for (int i = 0; i < size; i++) {
			if (data[i].equals(searchItem)) {
				indexOf = i;
			}
		}
		return indexOf;
	}
	/**
	 * Adds item to the list at a specified index. If an object exists at that index, shifts all objects to the right
	 * and inserts the new item in between at the specified index.
	 */
	public void add(int index, T item) {
		if (size == data.length)
			expandCapacity();
		
		T[] tempData = (T[]) new Object[data.length + 1];
		int i;
		
		if (index > size) {
			data[index] = item;
			size++;
		}
		else {
			for (i = 0; i < index; i++) {
				tempData[i] = data[i];
			}
			tempData[index] = item;
			size++;
			
			for (i = index + 1; i < size; i++) {
				tempData[i] = data[i - 1];
			}
		}
		data = tempData;
	}
	/**
	 * Sets the element at the specified index to item. Returns the element previously located at index.
	 */
	public T set(int index, T item) {
		T temp = data[index];
		data[index] = item;
		
		return temp;
	}
	/**
	 * Locates the index of an item equivalent to oldItem, and replaces that item with newItem using 
	 * set(int, T). returns the item previously at indexAt.
	 */
	public T set(T oldItem, T newItem) {
		int indexAt = indexOf(oldItem);
		T temp = data[indexAt];
		
		set(indexAt, newItem);
		return temp;
	}
}
