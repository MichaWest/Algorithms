import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Summe {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        new Summe().run(n);
    }

    private void run(int zahl){
        int c = 1;
        List<Integer> items = new ArrayList<Integer>();
        int n = 0;
        int z = zahl;
        while((z!=0) && (c <= zahl)){
            if((z-c >= c+1) || (c == z)){
                items.add(c);
                z = z - c;
                n++;
            }
            c++;
        }
        System.out.println(n);
        for(Integer i: items){
            System.out.print(i+" ");
        }
    }
}
