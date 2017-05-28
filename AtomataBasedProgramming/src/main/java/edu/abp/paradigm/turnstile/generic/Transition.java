package edu.abp.paradigm.turnstile.generic;

/**
 * State transition class
 *
 */
class Transition<S, E> {

	/**
	 * Next state
	 */
	S newState;

	/**
	 * Action to be executed
	 */
	Action action;

	/**
	 * Default constructor
	 * 
	 * @param newState
	 *            Next state
	 * @param action
	 *            Action to be executed
	 */
	Transition(S newState, Action action) {
		this.newState = newState;
		this.action = action;
	}

	public S getNewState() {
		return newState;
	}

	public Action getAction() {
		return action;
	}
	
}