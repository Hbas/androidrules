package io.github.hbas.rules;

import java.util.HashMap;
import java.util.Map;

public class Facts {
	private Map<String, Object> facts = new HashMap<>();

	public Facts put(String key, Object value) {
		this.facts.put(key, value);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, String key) {
		return (T) this.facts.get(key);
	}

	public boolean is(String key) {
		if (!facts.containsKey(key)) {
			return false;
		}
		return get(Boolean.class, key);
	}

}
