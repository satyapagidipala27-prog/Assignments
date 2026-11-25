import java.io.IOException;
import java.util.*;
import java.io.*;

public class problem_2 {
    static class InvalidInputException extends Exception{
        InvalidInputException(String s){
            super(s);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            int n=sc.nextInt();
            if(n<=0){
                throw new InvalidInputException("Number must be positive");
            }
            else{
                System.out.println("accepted");
            }
        }
        catch(InvalidInputException e){
            System.out.println(e.getMessage());
        }
    }

}
