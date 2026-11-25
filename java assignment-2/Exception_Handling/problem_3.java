import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class problem_3 {
    public static void main(String[] args) {
        try{
            FileReader file=new FileReader("input.txt");
            System.out.println("opened");
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        int a=10;
        int b=0;
        try{
            int result=a/b;
            System.out.println("result="+result);
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }

    }
}




