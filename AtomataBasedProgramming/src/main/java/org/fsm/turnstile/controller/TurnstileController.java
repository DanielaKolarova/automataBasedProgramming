package org.fsm.turnstile.controller;

/**
 * Decouples the logic of the finite state machine from the actions it needs to
 * perform. Another FSM, using very different logic, can use the
 * <code>TurnstileController</code> without any impact at all. The need to
 * create test code that verifies each unit in isolation forces us the decouple
 * the code.
 * 
 */
public interface TurnstileController {

	/**
	 * Locks the turnstile
	 */
	void lock();

	/**
	 * Unlocks the turnstile
	 */
	void unlock();

	/**
	 * Says thanks ;)
	 */
	void thankyou();

	/**
	 * Plays an alarm sound
	 */
	void alarm();

}