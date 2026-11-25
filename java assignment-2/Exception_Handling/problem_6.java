import java.awt.desktop.ScreenSleepEvent;
import java.util.*;
public class problem_6  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            String a=sc.next();
            String b=sc.next();
            try{
                int num1=Integer.parseInt(a);
                int num2=Integer.parseInt(b);
                int result=num1/num2;
                System.out.println(result);
            }
            catch(ArithmeticException e){
                System.out.println(e);
            }

        }
        catch(NumberFormatException e){
            System.out.println(e);
        }
        sc.close();
    }
}