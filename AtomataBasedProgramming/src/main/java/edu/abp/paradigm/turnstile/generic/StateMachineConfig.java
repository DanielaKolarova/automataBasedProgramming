package edu.abp.paradigm.turnstile.generic;

public interface StateMachineConfig<S, E> {
	
	S getCurrentState();
	
	void setCurrentState(S startState);

	Transition<S, E> getTransition(S state, E event);
}
