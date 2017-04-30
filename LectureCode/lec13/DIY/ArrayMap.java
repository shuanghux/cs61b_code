/** Fill in the map implementation below. */
public class ArrayMap<K, V> {
	private K[] keys;
	private V[] values;
	private int size;

	public ArrayMap() {
		keys = (K[]) new Object[100];
		values = (V[]) new Object[100];
		size = 0;
	}

	private int findKey(K key) {
		for (int i = 0; i < size; i++) {
			if (keys[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public void put(K key, V value) {
		if (containsKey(key)) {
			values[findKey(key)] = value;
		} else {
			keys[size] = key;
			values[size] = value;
		}
		size += 1;
	}

	public V get(K key) {				
		int t = findKey(key);
		return values[t];
	}

	public boolean containsKey(K key) {
		if (findKey(key) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public K[] keys() {
		return keys;
	}
} 