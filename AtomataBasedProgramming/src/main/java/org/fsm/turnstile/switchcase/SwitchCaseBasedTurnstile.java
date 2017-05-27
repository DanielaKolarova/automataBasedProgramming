package org.fsm.turnstile.switchcase;

import org.fsm.turnstile.AbstractTurnstile;
import org.fsm.turnstile.TurnstileEvent;
import org.fsm.turnstile.TurnstileState;
import org.fsm.turnstile.controller.TurnstileController;

/**
 * There are many different strategies for implementing FSM. The first, and most
 * direct, is though <b>nested switch/case statements</b>.
 *
 */
public class SwitchCaseBasedTurnstile extends AbstractTurnstile<TurnstileState> {

	/**
	 * Turnstile's constructor with controller for actions execution;
	 * 
	 * @param turnstileController
	 *            encapsulates the actions to be performed
	 *            {@link org.fsm.turnstile.controller.TurnstileController}
	 */
	public SwitchCaseBasedTurnstile(TurnstileController turnstileController) {
		super(turnstileController, TurnstileState.LOCKED);
	}

	/**
	 * The nested switch/case statement divides the code into four mutually
	 * exclusive zones, each corresponding to one of the transitions in the STD
	 * (state transition table). Each zone changes the state as needed and and
	 * then invokes the appropriate action.
	 * 
	 * @param event
	 *            {@link org.fsm.turnstile.TurnstileEvent} enumeration value
	 *            representing the event type that occurred
	 */
	public void event(TurnstileEvent event) {
		switch (state) {
		case LOCKED:
			switch (event) {
			case COIN:
				state = TurnstileState.UNLOCKED;
				turnstileController.unlock();
				break;
			case PASS:
				turnstileController.alarm();
				break;
			}
			break;
		case UNLOCKED:
			switch (event) {
			case COIN:
				turnstileController.thankyou();
				break;
			case PASS:
				state = TurnstileState.LOCKED;
				turnstileController.lock();
				break;
			}
			break;
		}
	}

}