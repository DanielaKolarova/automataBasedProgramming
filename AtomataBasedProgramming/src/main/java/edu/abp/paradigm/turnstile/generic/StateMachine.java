package edu.abp.paradigm.turnstile.generic;

/**
 * Turnstile FSM interface
 * 
 * <E> event type
 */
public interface StateMachine<S, E> {

	/**
	 * Receives an event and reacts on it.
	 * 
	 * @param event
	 *            event that occurred
	 */
	void event(E event);

}