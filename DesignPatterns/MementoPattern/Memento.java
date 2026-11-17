import java.util.ArrayList;
import java.util.List;

/** An immutable snapshot whose state is only accessible to the originator. */
public final class Memento {

    private final List<Shape> shapes;

    Memento(List<Shape> shapes) {
        this.shapes = List.copyOf(shapes);
    }

    List<Shape> getSavedState() {
        return new ArrayList<>(shapes);
    }
}
