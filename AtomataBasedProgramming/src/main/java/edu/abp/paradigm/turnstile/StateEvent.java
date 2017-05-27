package edu.abp.paradigm.turnstile;

/**
 * State(S) x Event(E) mapping triggering a transition as part of the transition
 * definition: State(S) x Event(E) -> Action(A) x State(S').
 * 
 * @param <S>
 *            State
 * @param <E>
 *            Event
 */
public class StateEvent<S, E> {

	S state;

	E event;

	public StateEvent(S state, E event) {
		this.state = state;
		this.event = event;
	}

	public S getState() {
		return state;
	}

	public E getEvent() {
		return event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateEvent<?, ?> other = (StateEvent<?, ?>) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}
