package tel_ran.collections;

public class Array {
	Object[] array;
	int size; // real number of elements
	int capacity;// possible number of elements with no additional allocation

	public Array() {
		capacity = 10;
		array = new Object[capacity];
	}

	public Array(int capacity) {
		this.capacity = capacity;
		array = new Object[capacity];
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return capacity;
	}

	/**
	 * 
	 * @param index
	 * @return object at the given index if the given index < 0 return element
	 *         at index 0 if the given index >= size return element at index
	 *         size-1 This method doesn't work if the array doesn't contain any
	 *         elements (size=0)
	 */
	public Object get(int index) {
		if (index < 0)
			index = 0;
		else if (index >= size)
			index = size - 1;
		return array[index];
	}

	/**
	 * 
	 * @param obj
	 *            adds the given obj at end of array
	 */
	public void add(Object obj) {
		if (size == capacity)
			createNewArray();
		array[size++] = obj;

	}

	private void createNewArray() {
		capacity *= 2;
		Object tmp[] = new Object[capacity];
		for (int i = 0; i < size; i++)
			tmp[i] = array[i];
		array = tmp;
	}

	/**
	 * 
	 * @param obj
	 * @param index
	 *            adds the given obj at the given index if the given index < 0
	 *            adds at beginning of the array if the given index > size adds
	 *            at end of the array
	 */
	public void add(Object obj, int index) {
		if (index < 0)
			index = 0;
		else if (index > size)
			index = size;
		if (size == capacity)
			createNewArray();
		for (int i = size; i > index; i--)
			array[i] = array[i - 1];
		array[index] = obj;
		size++;
	}

	/**
	 * removing an element at the given index
	 * 
	 * @param index
	 * @return false if the given index doesn't exist otherwise true
	 */
	public boolean remove(int index) {
		if (index < 0 || index >= size)
			return false;
		for (int i = index + 1; i < size; i++)
			array[i - 1] = array[i];
		size--;
		return true;
	}

	public int indexOf(Object pattern) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(pattern))
				return i;
		}
		return -1;
	}

	/**
	 * 
	 * @param pattern
	 * @return index of the last object equaled to the given pattern
	 */
	public int indexOfLast(Object pattern) {
		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(pattern))
				return i;
		}
		return -1;
	}

	public Object max(Comparator comp) {
		Object maximal = array[0];
		for (int i = 1; i < size; i++) {
			if (comp.compare(array[i], maximal) > 0)
				maximal = array[i];
		}
		return maximal;
	}

	public void sort(Comparator comp) {
		int nMoves = 0;
		int nElements = size - 1;
		do {
			nMoves = moveMaxToEnd(comp, nElements);
			nElements--;
		} while (nMoves > 0);

	}

	/**
	 * moves a maximal element to end of array
	 * 
	 * @nElements - number of elements in an array
	 * @return amount of swaps
	 */
	private int moveMaxToEnd(Comparator comp, int nElements) {
		int nMoves = 0;
		for (int i = 0; i < nElements; i++)
			if (comp.compare(array[i], array[i + 1]) > 0) {
				swap(i, i + 1);
				nMoves++;
			}
		return nMoves;
	}

	private void swap(int i, int j) {
		Object tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;

	}

	public int bsearch(Comparator comp, Object pattern) {
		int left = 0, right = size - 1, middle = 0;
		while (left <= right) {
			middle = (left + right) / 2;
			int fl = comp.compare(pattern, array[middle]);
			if (fl == 0)
				return middle;
			if (fl < 0)
				right = middle - 1;
			else
				left = middle + 1;
		}

		return -1;
	}

	public int indexOf(Comparator comp, Object pattern) {
		int index = bsearch(comp, pattern);
		if (index < 0)
			return -1;
		index--;
		while (index >= 0 && comp.compare(pattern, array[index]) == 0)
			index--;
		return index + 1;
	}

	public int indexOfLast(Comparator comp, Object pattern) {
		int index = bsearch(comp, pattern);
		if (index < 0)
			return -1;
		index++;
		while (index < size && comp.compare(pattern, array[index]) == 0)
			index++;
		return index - 1;
	}

	public int count(Comparator comp, Object pattern) {
		int index = indexOf(comp, pattern);
		if (index < 0)
			return 0;
		return indexOfLast(comp, pattern) - index + 1;
	}

	public Array find(Predicate predicate) {
		Array result = new Array(size);
		for (int i = 0; i < size; i++) {
			if (predicate.matches(array[i]))
				result.add(array[i]);
		}
		return result;

	}

}
