public class Problem {
	
	private Object initialState;
	
	private Object goalState;
	
	public Problem() {
		
	}
	
	
	public Problem(Object initial, Object goal) {
		this.initialState = initial;
		this.goalState = goal;
	}
	
	public Object getInitialState() {
		return initialState;
	}
	
	public void setInitialState(Object initial) {
		this.initialState = initial;
	}
	
	public Object getGoalState() {
		return goalState;
	}
	
	public void setGoalState(Object goal) {
		this.goalState = goal;
	}	
		
	
	public boolean isGoalState(Object state) {
		return state.toString().equals(this.goalState.toString());
	}
	
}