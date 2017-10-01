package com.github.hbas.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A fact database is a collection of truths (booleans) about the current engine
 * execution.
 * 
 * Facts can be consulted (using the <code>is</code> method) or informed (using
 * the <code>tell</code> and <code>tellAsFalse</code> methods).
 */
public class FactDatabase {

	private List<String> factNames = new ArrayList<String>();

	/**
	 * Checks if a fact is true
	 * 
	 * @param fact
	 *            The name of the fact
	 * 
	 * @return If the given fact is <code>true</code>. Otherwise, returns false.
	 */
	public boolean is(String fact) {
		return factNames.contains(fact);
	}

	/**
	 * Tells that a fact is true
	 * 
	 * @param fact
	 *            The name of the fact
	 * 
	 */
	public void tell(String fact) {
		factNames.add(fact);
	}

	/**
	 * Tells that a fact is false
	 * 
	 * @param fact
	 *            The name of the fact
	 * 
	 */
	public void tellAsFalse(String fact) {
		factNames.remove(fact);
	}

	/**
	 * Lists the facts that are known (may or may not be true)
	 * 
	 * @return Facts that are known
	 * 
	 */
	public Collection<String> getFacts() {
		return factNames;
	}
}
