package com.github.hbas.rules;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * FactsWithObjects is a special <code>FactDatabase</code> that also supports
 * parameters.
 * 
 * @see FactDatabase
 */
public class FactsWithObjects extends FactDatabase {
	private Map<String, Object> facts = new HashMap<String, Object>();

	/**
	 * Associates the specified value with the specified fact name. If the fact
	 * database previously contained a mapping for the name, the old value is
	 * replaced.
	 * 
	 * @param factName
	 *            The name of the fact
	 * @param value
	 *            value to be associated with the specified fact
	 */
	public FactsWithObjects put(String factName, Object value) {
		this.facts.put(factName, value);
		return this;
	}

	/**
	 * Returns the value to which the specified fact is mapped, or {@code null}
	 * if this map contains no mapping for the fact.
	 * 
	 * @param factName
	 *            The name of the fact
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, String factName) {
		return (T) this.facts.get(factName);
	}

	@Override
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

	@Override
	public void tellAsFalse(String fact) {
		this.put(fact, Boolean.FALSE);
	}

	@Override
	public Collection<String> getFacts() {
		return facts.keySet();
	}

}
