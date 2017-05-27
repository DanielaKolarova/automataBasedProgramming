package org.fsm.turnstile.statepattern;

/**
 * Represents a state machine state. The possible SM states will implement this
 * interface. Each interface method represents an SM event processing.
 *
 */
public interface TPatternState {

	/**
	 * Coin passed event processing
	 * 
	 * @param turnstile
	 *            A reference to the {@see Turnstile} that owns the state -
	 *            state's context.
	 */
	void coin(StatePatternBasedTurnstile turnstile);

	/**
	 * Turnstile passed event processing
	 * 
	 * @param turnstile
	 *            turnstile A reference to the {@see Turnstile} that owns the
	 *            state - state's context.
	 */
	void pass(StatePatternBasedTurnstile turnstile);

}
