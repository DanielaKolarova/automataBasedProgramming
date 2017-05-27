package org.fsm.turnstile;

/**
 * Events that can be received by a turnstile {@link Turnstile}.
 */
public enum TurnstileEvent {

	/**
	 * Coin input event
	 */
	COIN,

	/**
	 * Pass through event
	 */
	PASS;

}
