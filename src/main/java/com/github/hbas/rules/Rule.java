package com.github.hbas.rules;

public interface Rule<T extends FactDatabase> {
	boolean evaluate(T facts);

	void execute(T facts);
}
