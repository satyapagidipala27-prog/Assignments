public class problem_4 {

    static class CustomException extends Exception {
        CustomException(String message) {
            super(message);
        }
    }

    static void methodA() {
        try {
            methodB();
        } catch (CustomException e) {
            System.out.println("Caught in methodA: " + e.getMessage());
        }
    }

    static void methodB() throws CustomException {
        methodC();
    }

    static void methodC() throws CustomException {
        throw new CustomException("Exception thrown in methodC");
    }

    public static void main(String[] args) {
        methodA();
    }
}
