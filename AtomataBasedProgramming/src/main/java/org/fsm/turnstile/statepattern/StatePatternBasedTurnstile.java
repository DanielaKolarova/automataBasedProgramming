package org.fsm.turnstile.statepattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.fsm.turnstile.AbstractTurnstile;
import org.fsm.turnstile.TurnstileEvent;
import org.fsm.turnstile.controller.TurnstileController;

public class StatePatternBasedTurnstile extends AbstractTurnstile<TPatternState> {

	/**
	 * Locked state instance. The event classes have no variables and therefore
	 * never need to have more than one instance.
	 */
	private static TPatternState lockedState = new LockedTurnstileState();

	/**
	 * Unlocked state instance. The event classes have no variables and
	 * therefore never need to have more than one instance.
	 */
	private static TPatternState unlockedState = new UnlockedTurnstileState();

	/**
	 * Method registry providing methods access based on an event.
	 * The method references TPatternState::coin and TPatternState::pass have the form 
	 * “Reference to an instance method of an arbitrary object” where the caller 
	 * provides the target instance to invoke the method on, 
	 * similar to the lambda expressions (t,e) -> l.coin(e) and (l,e) -> l.pass(e), 
	 * which is why the target instance becomes the first functional parameter.
	 */
	private Map<TurnstileEvent, BiConsumer<TPatternState, StatePatternBasedTurnstile>> methods = new HashMap<>();
	
	/**
	 * Turnstile's constructor with controller for actions execution;
	 * 
	 * @param turnstileController
	 *            encapsulates the actions to be performed
	 *            {@link org.fsm.turnstile.controller.TurnstileController}
	 */
	public StatePatternBasedTurnstile(TurnstileController controller) {
		super(controller, lockedState);

		methods.put(TurnstileEvent.COIN, TPatternState::coin);
		methods.put(TurnstileEvent.PASS, TPatternState::pass);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void event(TurnstileEvent event) {
		BiConsumer<TPatternState, StatePatternBasedTurnstile> consumer = methods.get(event);
		consumer.accept(state, this);
	}

	public void coin() {
		state.coin(this);
	}

	public void pass() {
		state.pass(this);
	}

	void setLocked() {
		state = lockedState;
	}

	void setUnlocked() {
		state = unlockedState;
	}

	boolean isLocked() {
		return state == lockedState;
	}

	boolean isUnlocked() {
		return state == unlockedState;
	}

	void thankyou() {
		turnstileController.thankyou();
	}

	void alarm() {
		turnstileController.alarm();
	}

	void lock() {
		turnstileController.lock();
	}

	void unlock() {
		turnstileController.unlock();
	}

}