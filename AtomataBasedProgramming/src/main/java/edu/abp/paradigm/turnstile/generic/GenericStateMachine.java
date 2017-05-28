package edu.abp.paradigm.turnstile.generic;

/**
 * There are many different strategies for implementing FSM. This implementation
 * is based on <b>State Transition Table</b> representing mapping between event
 * and current state to a action and next state;
 *
 */
public class GenericStateMachine<S, E> implements StateMachine<S, E> {
	
	StateMachineConfig<S, E> config;

	public GenericStateMachine(StateMachineConfig<S, E> config) {
		this.config = config;
	}

	/**
	 * {@inheritDoc}
	 */
	public void event(E event) {
		Transition<S, E> transition = config.getTransition(config.getCurrentState(), event);
		transition.action.execute();
		
		config.setCurrentState(transition.getNewState());
	}
}