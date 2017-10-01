package com.github.hbas.rules.test_utils;

import com.github.hbas.rules.FactsWithObjects;
import com.github.hbas.rules.Rule;

public class FizzBuzzRule implements Rule<FactsWithObjects> {

	@Override
	public boolean evaluate(FactsWithObjects facts) {
		return facts.is("fizz") && facts.is("buzz");
	}

	@Override
	public void execute(FactsWithObjects facts) {
		facts.tell("fizzbuzz");
	}

}
