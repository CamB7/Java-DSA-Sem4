package UndoRedoManager;

public class UndoRedoManager<T> {
	private class Node {
		private final T state;
		private Node next;
		private Node previous;

		private Node (T state) {
			this.state = state;
		}
	}

	private Node currentState;

	//Undo Operation
	public void undo() {
		if (currentState == null) {
			System.out.println("No state to undo");
			return;
		}
		Node previousState = currentState.previous;
		if (previousState == null) {
			System.out.println("Reached the initial state");
		} else {
			currentState = previousState;
		}
	}

	//Add Operation
	public void addState (T newState) {
		//Create a new node
		Node newNode = new Node(newState);

		//Set the link for the new node
		newNode.previous = currentState;
		newNode.next = null;

		//update the next lonk
		if (currentState != null) {
			currentState.next = newNode;
		}

		//update the current to the new state
		currentState = newNode;
	}

	//Redo Operation
	public void redo() {
		if (currentState == null) {
			System.out.println("No state to undo");
			return;
		}
		Node nextState = currentState.next;
		if (nextState == null) {
			System.out.println("Reached the initial state");
		} else {
			currentState = nextState;
		}
	}

	public static void main(String[] args) {
		UndoRedoManager undoRedoManager = new UndoRedoManager();
		undoRedoManager.addState("State 1");
		undoRedoManager.addState("State 2");
		undoRedoManager.addState("State 3");
		undoRedoManager.addState("State 4");
		undoRedoManager.addState("State 5");

		System.out.println("Current: " + undoRedoManager.currentState.state);
		undoRedoManager.undo();
		System.out.println("Current: " + undoRedoManager.currentState.state);
		undoRedoManager.redo();
		System.out.println("Current: " + undoRedoManager.currentState.state);


	}
}
