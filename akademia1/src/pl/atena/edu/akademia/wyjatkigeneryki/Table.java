package pl.atena.edu.akademia.wyjatkigeneryki;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Table<K, V> {
	private List<Entry<K, V>> list = new ArrayList<>();

	public void addEntry(final K key, final V value) throws TableException {
		for (Entry<K, V> e : this.list) {
			if (e.getKey().equals(key)) {
				throw new TableException("klucz ju¿ istnieje");
			}
		}
		this.list.add(new Entry(key, value));
	}

	public void addEntry(final Entry<K, V> entry) {
		this.list.add(entry);
	}

	public void deleteEntry(final K key) {
		Predicate<Entry<K, V>> predicate = new Predicate<Entry<K, V>>() {
			@Override
			public boolean test(final Entry<K, V> t) {
				return t.getKey().equals(key);
			}
		};
		this.list.removeIf(predicate);

	}

	public void changeValue(final K key, final V newValue) {
		Predicate<Entry<K, V>> predicate = new Predicate<Entry<K, V>>() {
			@Override
			public boolean test(final Entry<K, V> t) {
				return t.getKey().equals(key);
			}
		};
		Entry<K, V> entry = this.filtruj(key);
		if (entry!=null) {
			entry.setValue(newValue);
		}
	}

	public V getValue(final K key) {
		Entry<K, V> entry = this.filtruj(key);
		return entry!=null? entry.getValue():(V) null;
	}

	public int getTableSize() {
		return this.list.size();
	}

	public void wyswietl() {
		this.list.forEach(System.out::println);
	}

	public Entry<K, V> filtruj(final K key) {
		Predicate<Entry<K, V>> predicate = new Predicate<Entry<K, V>>() {
			@Override
			public boolean test(final Entry<K, V> t) {
				return t.getKey().equals(key);
			}
		};
		for (Entry<K, V> e : this.list) {
			if (predicate.test(e)) {
				return e;
			}
		}
		return null;
	}
}
