package edu.abp.paradigm.turnstile.generic;

import java.util.HashMap;
import java.util.Map;

import edu.abp.paradigm.turnstile.StateEvent;
import edu.abp.paradigm.turnstile.TurnstileEvent;
import edu.abp.paradigm.turnstile.TurnstileState;
import edu.abp.paradigm.turnstile.controller.TurnstileController;

public class TurnstileStateMachineConfig implements StateMachineConfig<TurnstileState, TurnstileEvent> {

	private TurnstileState currentState;
	/**
	 * Encapsulates the actions to be performed.
	 */
	private TurnstileController turnstileController;
	
	private Map<StateEvent<TurnstileState, TurnstileEvent>, Transition<TurnstileState, TurnstileEvent>> transitions;

	public TurnstileStateMachineConfig(TurnstileState startState, TurnstileController controller) {
		this.currentState = startState;
		this.turnstileController = controller;
		
		transitions = new HashMap<>();
		
		transitions.put(new StateEvent<>(TurnstileState.LOCKED, TurnstileEvent.COIN),
				new Transition<>(TurnstileState.UNLOCKED, turnstileController::unlock));

		transitions.put(new StateEvent<>(TurnstileState.LOCKED, TurnstileEvent.PASS),
				new Transition<>(TurnstileState.LOCKED, turnstileController::alarm));

		transitions.put(new StateEvent<>(TurnstileState.UNLOCKED, TurnstileEvent.COIN),
				new Transition<>(TurnstileState.UNLOCKED, turnstileController::thankyou));

		transitions.put(new StateEvent<>(TurnstileState.UNLOCKED, TurnstileEvent.PASS),
				new Transition<>(TurnstileState.LOCKED, turnstileController::lock));
	}

	@Override
	public TurnstileState getCurrentState() {
		return currentState;
	}

	@Override
	public void setCurrentState(TurnstileState currentState) {
		this.currentState = currentState;
	}

	@Override
	public Transition<TurnstileState, TurnstileEvent> getTransition(TurnstileState state, TurnstileEvent event) {
		return transitions.get(new StateEvent<>(state, event));
	}

}