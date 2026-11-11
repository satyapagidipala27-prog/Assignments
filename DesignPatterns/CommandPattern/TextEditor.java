import java.util.Stack;

public class TextEditor {

    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {

        command.execute();

        undoStack.push(command);

        // A new operation clears redo history.
        redoStack.clear();
    }

    public void undo() {

        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        Command command = undoStack.pop();

        command.undo();

        redoStack.push(command);
    }

    public void redo() {

        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }

        Command command = redoStack.pop();

        command.execute();

        undoStack.push(command);
    }
}