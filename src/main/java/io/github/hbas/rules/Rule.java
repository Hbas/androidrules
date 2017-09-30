package io.github.hbas.rules;

public interface Rule {
	boolean evaluate(Facts facts);

	void execute(Facts facts);
}
