package Iterator;

import java.util.Scanner;

public class IteratorTest {
    public static void
     main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("What size of array would you like?");
        int userChoice = s.nextInt();
        IteratedArray array = new IteratedArray(userChoice);
        for(Double i: array){
            System.out.println(i);
        }
        s.close();
    }
}