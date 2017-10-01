package com.github.hbas.rules;

class RuleExecutor<T extends FactDatabase> {
	private static final int DEFAULT_MAX_RULE_EXECUTIONS = 10000;
	private Rule<T> rule;
	private int maxTimes;
	private int executions;

	RuleExecutor(Rule<T> rule) {
		this(rule, DEFAULT_MAX_RULE_EXECUTIONS);
	}

	RuleExecutor(Rule<T> rule, int maxTimes) {
		this.rule = rule;
		this.maxTimes = maxTimes;
		this.executions = 0;
	}

	boolean evaluate(T facts) {
		if (executions >= maxTimes) {
			return false;
		}
		return rule.evaluate(facts);
	}

	void execute(T facts) {
		executions++;
		rule.execute(facts);
	}

	void resetExecutions() {
		executions = 0;
	}

}
