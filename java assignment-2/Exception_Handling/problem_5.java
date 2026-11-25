import java.util.*;
public class problem_5  {
    static class CustomException extends Exception {
        CustomException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    static void calculator() throws CustomException {
        try{
            int c=10;
            int d=0;
            int result=c/d;
            System.out.println(result);

        }
        catch(ArithmeticException e){
            throw new CustomException("invalid",e);
        }
    }
    public static void main(String[] args) {
        try{
            calculator();
        }
        catch(CustomException e){
            System.out.println(e.getMessage());
            System.out.println("Original Cause: " + e.getCause());
        }
    }
}