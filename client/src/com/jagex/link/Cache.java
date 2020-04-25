package com.jagex.link;

/**
 * A least-recently used cache, backed by a {@link HashTable} and a {@link Queue}.
 */
public final class Cache {

	/**
	 * The capacity of this cache.
	 */
	private int capacity;

	/**
	 * The empty cacheable.
	 */
	private Cacheable empty = new Cacheable();

	/**
	 * The history of Cacheables, used for LRU behaviour.
	 */
	private Queue history = new Queue();

	/**
	 * The HashTable backing this cache.
	 */
	private HashTable table = new HashTable(1024);

	/**
	 * The amount of unused slots in this cache.
	 */
	private int unused;

	/**
	 * Creates the Cache.
	 *
	 * @param capacity The capacity of this cache.
	 */
	public Cache(int capacity) {
		this.capacity = capacity;
		unused = capacity;
	}

	/**
	 * Clears the contents of this Cache.
	 */
	public void clear() {
		do {
			Cacheable front = history.pop();

			if (front != null) {
				front.unlink();
				front.unlinkCacheable();
			} else {
				unused = capacity;
				break;
			}
		} while (true);
	}

	/**
	 * Gets the {@link Cacheable} with the specified key.
	 *
	 * @param key The key.
	 * @return The Cacheable.
	 */
	public Cacheable get(long key) {
		Cacheable node = (Cacheable) table.get(key);
		if (node != null) {
			history.push(node);
		}

		return node;
	}

	public void put(long key, Cacheable value) {
		if (unused == 0) {
			Cacheable oldest = history.pop();
			oldest.unlink();
			oldest.unlinkCacheable();

			if (oldest == empty) {
				oldest = history.pop();
				oldest.unlink();
				oldest.unlinkCacheable();
			}
		} else {
			unused--;
		}

		table.put(key, value);
		history.push(value);
	}

}