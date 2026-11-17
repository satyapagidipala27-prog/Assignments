import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {

    private final Deque<Memento> undoStack = new ArrayDeque<>();
    private final Deque<Memento> redoStack = new ArrayDeque<>();

    /** Save the state from before a change. A new edit discards redo history. */
    public void saveState(Memento memento) {
        undoStack.push(memento);
        redoStack.clear();
    }

    public void undo(Canvas canvas) {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        redoStack.push(canvas.saveState());
        canvas.restoreState(undoStack.pop());
        canvas.display();
    }

    public void redo(Canvas canvas) {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        undoStack.push(canvas.saveState());
        canvas.restoreState(redoStack.pop());
        canvas.display();
    }
}
