package edu.abp.paradigm.turnstile.sttable;

import static edu.abp.paradigm.turnstile.TurnstileEvent.*;
import static edu.abp.paradigm.turnstile.TurnstileState.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.abp.paradigm.turnstile.Turnstile;
import edu.abp.paradigm.turnstile.TurnstileEvent;
import edu.abp.paradigm.turnstile.TurnstileState;
import edu.abp.paradigm.turnstile.controller.TurnstileController;

/**
 * There are many different strategies for implementing FSM. This implementation
 * is based on <b>State Transition Table</b> representing mapping between event
 * and current state to a action and next state;
 *
 */
public class STTableBasedTurnstile2 implements Turnstile {

	/**
	 * Initial state
	 */
	private TurnstileState state = TurnstileState.LOCKED;

	private final TurnstileController turnstileController;
	
	private Transitions<TurnstileState, TurnstileEvent> transitions;

	public STTableBasedTurnstile2(TurnstileController controller, TransitionsBuilder<TurnstileState, TurnstileEvent> tBuilder) {
		
		this.turnstileController = controller;
		
		tBuilder.onStateEvent(LOCKED, COIN).action(() -> state = TurnstileState.UNLOCKED).action(turnstileController::unlock);
		tBuilder.onStateEvent(UNLOCKED, PASS).action(() -> state = TurnstileState.LOCKED).action(turnstileController::lock);
		tBuilder.onStateEvent(LOCKED, PASS).action(turnstileController::alarm);
		tBuilder.onStateEvent(UNLOCKED, COIN).action(turnstileController::thankyou);
	}

	/**
	 * The nested switch/case statement divides the code into four mutually
	 * exclusive zones, each corresponding to one of the transitions in the STD
	 * (state transition table). Each zone changes the state as needed and and
	 * then invokes the appropriate action.
	 * 
	 * @param event
	 */
	public void event(TurnstileEvent event) {
		transitions.transition(state, event);
	}

	/**
	 * Single Abstract Method interface (SAM Interface) or Functional interface
	 * performing single action.
	 *
	 */
	@FunctionalInterface
	private interface Action {
		void execute();
	}

	interface TransitionsBuilder<S, E> {

		TransitionsBuilder<S, E> onStateEvent(S state, E event);
		
		TransitionsBuilder<S, E> action(Action action);
	}

	class TransitionsBuilderImpl<S, E> implements TransitionsBuilder<S, E> {

		private Map<S, Map<E, List<Action>>> transitions;
		
		private List<Action> currentActionsList;
		

		public TransitionsBuilderImpl() {
			transitions = new HashMap<>();
		}

		
		public TransitionsBuilder<S, E> onStateEvent(S state, E event) {
			Map<E, List<Action>> currentEventMap = new HashMap<>();
			currentActionsList = new ArrayList<>();
			currentEventMap.put(event, currentActionsList);
			transitions.put(state, currentEventMap);

			return this;
		}
		
		public TransitionsBuilder<S, E> action(Action action) {
			currentActionsList.add(action);

			return this;
		}

		Transitions<S, E>  build() {
			return new TransitionsWithActions<S, E>(transitions);
		}
	}

	
	interface Transitions<S, E> {
		void transition(S state, E event);
	}
	
	class TransitionsWithActions<S, E> implements Transitions<S, E> {

		private Map<S, Map<E, List<Action>>> transitions;
		
		TransitionsWithActions(Map<S, Map<E, List<Action>>> transitions) {
			this.transitions = transitions;
		}
		
		@Override
		public void transition(S state, E event) {
			List<Action> actions = transitions.get(state).get(event);
			for (Action action : actions) {
				action.execute();
			}
		}
	}

}