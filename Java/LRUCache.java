/* LRU Cache 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 */

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    // use LinkedHashMap
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		System.out.println(lru.get(2));
		lru.put(1, 10);
		lru.put(2, 20);
		System.out.println(lru.get(1));
		lru.put(3, 30); 
		System.out.println(lru.get(2));
	}

	private int capacity;

	public LRUCache(int capacity) {
		super(16, 0.75f, true);
		this.capacity = capacity;
	}

	public Integer get(Object key) {
		Integer v = super.get(key);
		if (v != null)
			return v;
		else
			return -1;
	}

	public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}

	public void set(int key, int value) {
		super.put(key, value);
	}
}

