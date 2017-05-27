package edu.abp.paradigm.turnstile;

/**
 * Turnstile FSM interface
 */
public interface Turnstile {

	/**
	 * Receives an event and reacts on it.
	 * 
	 * @param event
	 *            {@link TurnstileEvent} enumeration value representing the
	 *            event type that occurred
	 */
	void event(TurnstileEvent event);

}