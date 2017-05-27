package edu.abp.paradigm.turnstile.sttable;

import java.util.HashMap;
import java.util.Map;

import edu.abp.paradigm.turnstile.AbstractTurnstile;
import edu.abp.paradigm.turnstile.Action;
import edu.abp.paradigm.turnstile.StateEvent;
import edu.abp.paradigm.turnstile.TurnstileEvent;
import edu.abp.paradigm.turnstile.TurnstileState;
import edu.abp.paradigm.turnstile.controller.TurnstileController;

/**
 * There are many different strategies for implementing FSM. This implementation
 * is based on <b>State Transition Table</b> representing mapping between event
 * and current state to a action and next state;
 *
 */
public class STTableBasedTurnstile1 extends AbstractTurnstile<TurnstileState> {

	/**
	 * A transition function (State X Input → State) An output function (Input ×
	 * State → Output)
	 */
	private Map<StateEvent<TurnstileState, TurnstileEvent>, Transition> transitions = new HashMap<>();

	public STTableBasedTurnstile1(TurnstileController controller) {
		super(controller, TurnstileState.LOCKED);

		transitions.put(new StateEvent<>(TurnstileState.LOCKED, TurnstileEvent.COIN),
				new Transition(TurnstileState.UNLOCKED, turnstileController::unlock));

		transitions.put(new StateEvent<>(TurnstileState.LOCKED, TurnstileEvent.PASS),
				new Transition(TurnstileState.LOCKED, turnstileController::alarm));

		transitions.put(new StateEvent<>(TurnstileState.UNLOCKED, TurnstileEvent.COIN),
				new Transition(TurnstileState.UNLOCKED, turnstileController::thankyou));

		transitions.put(new StateEvent<>(TurnstileState.UNLOCKED, TurnstileEvent.PASS),
				new Transition(TurnstileState.LOCKED, turnstileController::lock));
	}

	/**
	 * {@inheritDoc}
	 */
	public void event(TurnstileEvent event) {
		Transition transition = transitions.get(new StateEvent<>(state, event));
		transition.action.execute();
		state = transition.newState;
	}

	/**
	 * State transition class representing a row in a state transition table.
	 *
	 */
	private class Transition {

		/**
		 * Next state
		 */
		TurnstileState newState;

		/**
		 * Action to be executed
		 */
		Action action;

		/**
		 * Default constructor
		 * 
		 * @param newState
		 *            Next state
		 * @param action
		 *            Action to be executed
		 */
		Transition(TurnstileState newState, Action action) {
			this.newState = newState;
			this.action = action;
		}
	}
}