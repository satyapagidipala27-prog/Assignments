import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class problem_4 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        for(int i=0;i<=n;i++) {
            arr.add(input.nextInt());
        }
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(arr.get(i).equals(arr.get(j))) {
                    arr.remove(j);
                    j--;
                }
            }
        }
        System.out.println(arr);




    }
}
