import java.util.ArrayList;
import java.util.*;
public class problem_5 {
    public static void main(String[] args) {
            List<String> list=new ArrayList<>();
            Scanner input = new Scanner(System.in);
            int n=input.nextInt();
            for(int i=0;i<n;i++) {
                list.add(input.next());
            }
            String s1="satya";
            int[] char1=new int[s1.length()];;
            for(int i=0;i<s1.length();i++) {
                char1[i]=s1.charAt(i);
            }
            for(int i=0;i<char1.length;i++) {
                for(int j=i+1;j<char1.length;j++) {
                    if(char1[i]<char1[j]) {
                        int temp = char1[i];
                        char1[i] = char1[j];
                        char1[j] = temp;
                    }
                }
            }
        System.out.print("Sorted characters: ");
        for (int i = 0; i < char1.length; i++) {
            System.out.print((char) char1[i]);
        }
        System.out.println();

            ArrayList<String> arr=new ArrayList<>();
            for(int i=0;i<n;i++) {
               String s= list.get(i);
               char ch=s.charAt(0);
               arr.add(ch+"");
            }
            arr.sort(Comparator.reverseOrder());
            list.sort(Comparator.reverseOrder());
            System.out.println(arr);
            System.out.println(list);
    }
}
