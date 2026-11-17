import java.util.ArrayList;
import java.util.List;

public class Canvas {

    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
        System.out.println(shape.getName() + " added to Canvas.");
    }

    public Memento saveState() {
        return new Memento(shapes);
    }

    public void restoreState(Memento memento) {
        shapes = memento.getSavedState();
        System.out.println("Canvas state restored.");
    }

    public void display() {
        System.out.println("Current Canvas: " + shapes);
    }
}
