package edu.abp.paradigm.turnstile.statepattern;

/**
 * Locked SM state
 */
public class LockedTurnstileState implements TPatternState {

	/**
	 * {@inheritDoc}
	 */
	public void coin(StatePatternBasedTurnstile turnstile) {
		turnstile.setUnlocked();
		turnstile.unlock();
	}

	/**
	 * {@inheritDoc}
	 */
	public void pass(StatePatternBasedTurnstile turnstile) {
		turnstile.alarm();
	}

}
