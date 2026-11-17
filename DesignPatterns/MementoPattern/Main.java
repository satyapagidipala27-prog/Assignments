public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Caretaker caretaker = new Caretaker();

        caretaker.saveState(canvas.saveState());
        canvas.addShape(new Shape("Circle"));
        canvas.display();

        caretaker.saveState(canvas.saveState());
        canvas.addShape(new Shape("Square"));
        canvas.display();

        System.out.println("\n--- Undo ---");
        caretaker.undo(canvas);

        System.out.println("\n--- Redo ---");
        caretaker.redo(canvas);

        caretaker.saveState(canvas.saveState());
        canvas.addShape(new Shape("Triangle"));
        canvas.display();

        System.out.println("\n--- Undo ---");
        caretaker.undo(canvas);

        System.out.println("\n--- Redo ---");
        caretaker.redo(canvas);
    }
}
