package com.github.hbas.rules.test_utils;

import com.github.hbas.rules.FactsWithObjects;
import com.github.hbas.rules.Rule;

public class BuzzRule implements Rule<FactsWithObjects> {

	@Override
	public boolean evaluate(FactsWithObjects facts) {
		return facts.get(Integer.class, "number") % 5 == 0;
	}

	@Override
	public void execute(FactsWithObjects facts) {
		facts.tell("buzz");
	}

}
