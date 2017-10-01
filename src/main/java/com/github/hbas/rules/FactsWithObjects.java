package com.github.hbas.rules;

import java.util.HashMap;
import java.util.Map;

/**
 * FactsWithObjects is a special <code>FactDatabase</code> that also supports
 * parameters
 */
public class FactsWithObjects extends FactDatabase {
	private Map<String, Object> facts = new HashMap<String, Object>();

	public FactsWithObjects put(String key, Object value) {
		this.facts.put(key, value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, String key) {
		return (T) this.facts.get(key);
	}

	/**
	 * Checks if a fact is true
	 * 
	 * @param key
	 *            The name of the key
	 * 
	 * @return If the given key is <code>true</code>. Otherwise, returns false.
	 * 
	 * @throws ClassCastException
	 *             If the value associated with the given key is not a Boolean.
	 */
	public boolean is(String key) {
		if (!facts.containsKey(key)) {
			return false;
		}
		Object value = this.facts.get(key);
		return value != null && value.equals(Boolean.TRUE);
	}

	@Override
	public void tell(String fact) {
		this.put(fact, Boolean.TRUE);
	}

}
