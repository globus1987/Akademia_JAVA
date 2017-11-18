package pl.atena.edu.akademia.wyjatkigeneryki;

public class Entry<K,V> {
	private K key;
	private V value;
	public Entry(final K key, final V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return this.key;
	}
	public void setKey(final K key) {
		this.key = key;
	}
	public V getValue() {
		return this.value;
	}
	@Override
	public String toString() {
		return String.format("Entry [key=%s, value=%s]", this.key, this.value);
	}
	public void setValue(final V value) {
		this.value = value;
	}


}
