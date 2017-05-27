package edu.abp.paradigm.turnstile.statepattern;

import edu.abp.paradigm.turnstile.AbstractTurnstileTest;
import edu.abp.paradigm.turnstile.Turnstile;
import edu.abp.paradigm.turnstile.controller.TurnstileController;
import edu.abp.paradigm.turnstile.statepattern.StatePatternBasedTurnstile;

/**
 * Tests the correctness of the state transitions based on events. Based on a
 * event and the current state it checks the corresponding action performed and
 * the result state.
 *
 */
public class TurnstileWithStatePatternTest extends AbstractTurnstileTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Turnstile createTurnstile(TurnstileController controller) {
		return new StatePatternBasedTurnstile(controller);
	}

}