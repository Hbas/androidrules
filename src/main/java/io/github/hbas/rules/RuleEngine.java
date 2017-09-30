package io.github.hbas.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

	private List<RuleExecutor> rules = new ArrayList<>();

	public void fire(Facts facts) {
		for (RuleExecutor rule : rules) {
			rule.resetExecutions();
		}
		
		List<RuleExecutor> rulesToRun = new ArrayList<>(rules.size());
		do {
			rulesToRun.clear();
			for (RuleExecutor rule : rules) {
				if (rule.evaluate(facts)) {
					rulesToRun.add(rule);
				}
			}
			for (RuleExecutor rule : rulesToRun) {
				rule.execute(facts);
			}
		} while (!rulesToRun.isEmpty());
	}

	public void register(Rule rule) {
		register(new RuleExecutor(rule));
	}

	public void register(Rule rule, int maxTimes) {
		register(new RuleExecutor(rule, maxTimes));
	}

	private void register(RuleExecutor ruleExecutor) {
		rules.add(ruleExecutor);
	}

}
