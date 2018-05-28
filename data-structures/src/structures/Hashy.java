package structures;

import java.util.ArrayList;

public class Hashy<K, V> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashy hashy = new Hashy();
		hashy.put("sawyer", "burnett");
		hashy.put("kelsey", "taylor");
		hashy.put("scout", "dog");
		hashy.put("1", "2");
		System.out.println(hashy.size());
		System.out.println(hashy.get("kelsey"));
		System.out.println(hashy.containsKey("kelsey"));
		System.out.println(hashy.remove("kelsey"));
		System.out.println(hashy.get("kelsey"));
		System.out.println(hashy.containsKey("kelsey"));
	}

	private ArrayList<HashNode<K, V>> bucketArray;

	private int numBuckets;
	private int size;

	public Hashy() {
		bucketArray = new ArrayList();
		numBuckets = 10;
		size = 0;

		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode % numBuckets);
	}

	public void put(K key, V value) {

		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		while (head != null) {

			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);

		// if load factor is > .7 then double the size
		if ((1.0 * size) / numBuckets >= 0.7) {

			ArrayList<HashNode<K, V>> temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets *= 2;
			size = 0;
			for (int i = 0; i < numBuckets; i++)
				bucketArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					put(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}

		}
	}
	
	public boolean containsKey(K key) {
		
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		while (head != null) {
			if (head.key.equals(key)) {
				return true;
			}
			
			head = head.next;
		}
		
		return false;
	}

	public V get(K key) {

		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public V remove(K key) {
		
		int bucketIndex = getBucketIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
		HashNode<K, V> prev = null;
		
		while (head != null) {
			
			if (head.key.equals(key)) {
				break;
			}
			
			prev = head;
			head = head.next;
			
		}
		
		if (head == null) {
			return null;
		}
		size--;
		if (prev != null) {
			prev.next = head.next;
		} else {
			bucketArray.set(bucketIndex, head.next);
		}
		
		return head.value;
	}

	class HashNode<K, V> {
		K key;
		V value;

		HashNode<K, V> next;

		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
