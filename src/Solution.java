import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 1;
        int j = 1;

        while(i <= 2*n){
            int var1 = i;
            while(var1 <= 2*n){
                System.out.print(var1);
                var1 = var1 + 2;
            }
            int var2 = j;
            while(var2 < i){
                System.out.print(var2);
                var2 = var2 + 2;
            }
            System.out.println();
            i = i + 2;


        }
    }


}