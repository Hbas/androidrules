package com.github.hbas.rules.test_utils;

import com.github.hbas.rules.FactsWithObjects;
import com.github.hbas.rules.Rule;

public class FizzRule implements Rule<FactsWithObjects> {

	@Override
	public boolean evaluate(FactsWithObjects facts) {
		return facts.get(Integer.class, "number") % 3 == 0;
	}

	@Override
	public void execute(FactsWithObjects facts) {
		facts.tell("fizz");
	}

}
