package com.github.hbas.rules;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible to interpret and call all rules
 * 
 * @param <T>
 *            The FactDatabase that should be used by this engine
 */
public class RuleEngine<T extends FactDatabase> {

	private List<RuleExecutor<T>> rules = new ArrayList<RuleExecutor<T>>();

	/**
	 * Fire all the rules.
	 * 
	 * This method will run until all the rules evaluates to false or the
	 * maximum execution amount is reached.
	 * 
	 * @param facts
	 *            The fact database
	 */
	public void fire(T facts) {
		for (RuleExecutor<T> rule : rules) {
			rule.resetExecutions();
		}

		List<RuleExecutor<T>> rulesToRun = new ArrayList<RuleExecutor<T>>(rules.size());
		do {
			rulesToRun.clear();
			for (RuleExecutor<T> rule : rules) {
				if (rule.evaluate(facts)) {
					rulesToRun.add(rule);
				}
			}
			for (RuleExecutor<T> rule : rulesToRun) {
				rule.execute(facts);
			}
		} while (!rulesToRun.isEmpty());
	}

	/**
	 * Registers a rule on the engine, with the default maximum execution amount
	 * 
	 * @param rule
	 *            The rule
	 */
	public void register(Rule<T> rule) {
		register(new RuleExecutor<T>(rule));
	}

	/**
	 * Registers a rule on the engine, with the specified maximum execution
	 * amount
	 * 
	 * @param rule
	 *            The rule
	 * @param maxExecutionAmount
	 *            How many times, at most, this rule can be executed on a single
	 *            call to the RuleEngine.fire method
	 */
	public void register(Rule<T> rule, int maxExecutionAmount) {
		register(new RuleExecutor<T>(rule, maxExecutionAmount));
	}

	private void register(RuleExecutor<T> ruleExecutor) {
		rules.add(ruleExecutor);
	}

}
