package org.fsm.turnstile.sttable;

import org.fsm.turnstile.AbstractTurnstileTest;
import org.fsm.turnstile.Turnstile;
import org.fsm.turnstile.controller.TurnstileController;

/**
 * Tests the correctness of the state transitions based on events. Based on a
 * event and the current state it checks the corresponding action performed and
 * the result state.
 *
 */
public class TurnstileWithSTTTest extends AbstractTurnstileTest {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Turnstile createTurnstile(TurnstileController controller) {
		return new STTableBasedTurnstile(controller);
	}

}