package edu.abp.paradigm.turnstile.generic;

import java.util.Map;

import edu.abp.paradigm.turnstile.StateEvent;

public interface TransitionsTableBuilder<S, E> {
	
	TransitionsTableBuilder<S, E> startState(S startState);

	TransitionsTableBuilder<S, E> event(E event);
	
	TransitionsTableBuilder<S, E> nextState(S state);
	
	TransitionsTableBuilder<S, E> action(Action action);
	
	TransitionsTableBuilder<S, E> transition();
	
	Map<StateEvent<S, E>, Transition<S, E>> build();
}
