package edu.abp.paradigm.turnstile.sttable;

import edu.abp.paradigm.turnstile.Action;
import edu.abp.paradigm.turnstile.TurnstileEvent;

/**
 * 
 * As suggested in Robert Martin's book
 *
 */
public class SampleTransition {

	TurnstileEvent currentState;
	TurnstileEvent event;
	
	TurnstileEvent newState;
	Action action;
	
	public SampleTransition(TurnstileEvent currentState, TurnstileEvent event, TurnstileEvent newState, Action action) {
		this.currentState = currentState;
		this.event = event;
		this.newState = newState;
		this.action = action;
	}

	public TurnstileEvent getCurrentState() {
		return currentState;
	}

	public TurnstileEvent getEvent() {
		return event;
	}

	public TurnstileEvent getNewState() {
		return newState;
	}

	public Action getAction() {
		return action;
	}
}
