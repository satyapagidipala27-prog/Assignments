public final class Shape {

    private final String name;

    public Shape(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Shape name must not be blank.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
