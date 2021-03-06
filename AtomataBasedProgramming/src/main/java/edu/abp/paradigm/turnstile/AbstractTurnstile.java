package edu.abp.paradigm.turnstile;

import edu.abp.paradigm.turnstile.controller.TurnstileController;

/**
 * 
 * Abstract turnstile containing common parts of the turnstile SM.
 *
 * @param <S>
 *            States type
 */
public abstract class AbstractTurnstile<S> implements Turnstile {

	/**
	 * Initial state
	 */
	protected S state;

	/**
	 * Encapsulates the actions to be performed.
	 */
	protected TurnstileController turnstileController;

	/**
	 * Turnstile's constructor with controller for actions execution;
	 * 
	 * @param turnstileController
	 *            encapsulates the actions to be performed
	 *            {@link edu.abp.paradigm.turnstile.controller.TurnstileController}
	 */
	protected AbstractTurnstile(TurnstileController turnstileController, S initialState) {
		this.turnstileController = turnstileController;
		this.state = initialState;
	}
}
