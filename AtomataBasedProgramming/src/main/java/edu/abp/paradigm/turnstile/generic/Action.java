package edu.abp.paradigm.turnstile.generic;

/**
 * Single Abstract Method interface (SAM Interface) or Functional interface
 * performing single action.
 *
 */
@FunctionalInterface
public interface Action {

	/**
	 * Execute an action
	 */
	public void execute();

}