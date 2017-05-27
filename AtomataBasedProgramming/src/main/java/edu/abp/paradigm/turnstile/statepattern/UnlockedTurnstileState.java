package edu.abp.paradigm.turnstile.statepattern;

/**
 * Unlocked SM state
 */
public class UnlockedTurnstileState implements TPatternState {

	/**
	 * {@inheritDoc}
	 */
	public void coin(StatePatternBasedTurnstile turnstile) {
		turnstile.thankyou();
	}

	/**
	 * {@inheritDoc}
	 */
	public void pass(StatePatternBasedTurnstile turnstile) {
		turnstile.setLocked();
		turnstile.lock();
	}

}
