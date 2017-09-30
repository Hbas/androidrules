package io.github.hbas.rules;

class RuleExecutor {
	private static final int DEFAULT_MAX_RULE_EXECUTIONS = 10000;
	private Rule rule;
	private int maxTimes;
	private int executions;

	public RuleExecutor(Rule rule) {
		this(rule, DEFAULT_MAX_RULE_EXECUTIONS);
	}

	public RuleExecutor(Rule rule, int maxTimes) {
		this.rule = rule;
		this.maxTimes = maxTimes;
		this.executions = 0;
	}

	public boolean evaluate(Facts facts) {
		if (executions >= maxTimes) {
			return false;
		}
		return rule.evaluate(facts);
	}

	public void execute(Facts facts) {
		executions++;
		rule.execute(facts);
	}

	public void resetExecutions() {
		executions = 0;
	}

}
