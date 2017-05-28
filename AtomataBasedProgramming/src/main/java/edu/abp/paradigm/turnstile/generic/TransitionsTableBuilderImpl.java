package edu.abp.paradigm.turnstile.generic;

import java.util.HashMap;
import java.util.Map;

import edu.abp.paradigm.turnstile.StateEvent;

public class TransitionsTableBuilderImpl<S, E> implements TransitionsTableBuilder<S, E> {

	private S startState;
	
	private S nextState;
	
	private E event;
	
	private Action action;

	Map<StateEvent<S, E>, Transition<S, E>> transitions = new HashMap<StateEvent<S, E>, Transition<S, E>>();

	@Override
	public TransitionsTableBuilder<S, E> startState(S startState) {
		this.startState = startState;
		
		return this;
	}

	@Override
	public TransitionsTableBuilder<S, E> event(E event) {
		this.event = event;
		
		return this;
	}

	@Override
	public TransitionsTableBuilder<S, E> nextState(S state) {
		this.nextState = state;
		
		return this;
	}

	@Override
	public TransitionsTableBuilder<S, E> action(Action action) {
		this.action = action;
		
		return this;
	}

	@Override
	public TransitionsTableBuilder<S, E> transition() {
		Transition<S, E> transition = new Transition<>(nextState, action);
		transitions.put(new StateEvent<>(startState, event), transition);
		
		return this;
	}

	@Override
	public Map<StateEvent<S, E>, Transition<S, E>> build() {
		return transitions;
	}

}
