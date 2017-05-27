package org.fsm.turnstile;

import org.fsm.turnstile.controller.TurnstileController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Base turnstile test that can be extended in order to be able to test various
 * implementations of the Turnstile interface.
 *
 */
public abstract class AbstractTurnstileTest {

	/**
	 * The turnstile to test
	 */
	private Turnstile turnstile;

	/**
	 * A Flag used for test validations
	 */
	private boolean lockCalled = false;

	/**
	 * A Flag used for test validations
	 */
	private boolean unlockCalled = false;

	/**
	 * A Flag used for test validations
	 */
	private boolean thankyouCalled = false;

	/**
	 * A Flag used for test validations
	 */
	private boolean alarmCalled = false;

	@Before
	public void setUp() {
		TurnstileController controller = new TurnstileController() {

			public void lock() {
				lockCalled = true;
			}

			public void unlock() {
				unlockCalled = true;
			}

			public void thankyou() {
				thankyouCalled = true;
			}

			public void alarm() {
				alarmCalled = true;
			}
		};

		turnstile = createTurnstile(controller);
	}

	@Test
	public void testInitialConditions() {
		turnstile.event(TurnstileEvent.PASS);
		Assert.assertTrue(alarmCalled);
	}

	@Test
	public void testCoinInLockedState() {
		turnstile.event(TurnstileEvent.COIN);
		Assert.assertTrue(unlockCalled);
	}

	@Test
	public void testCoinInUnlockedState() {
		turnstile.event(TurnstileEvent.COIN);
		turnstile.event(TurnstileEvent.COIN);
		Assert.assertTrue(thankyouCalled);
	}

	@Test
	public void testPassInLockedState() {
		turnstile.event(TurnstileEvent.PASS);
		Assert.assertTrue(alarmCalled);
	}

	@Test
	public void testPassInUnlockedState() {
		turnstile.event(TurnstileEvent.COIN);
		turnstile.event(TurnstileEvent.PASS);
		Assert.assertTrue(lockCalled);
	}

	protected abstract Turnstile createTurnstile(TurnstileController controller);
}
