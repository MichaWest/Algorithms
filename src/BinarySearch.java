import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    int[] array;

    public static void main(String[] args){
        float start = System.currentTimeMillis();
        new BinarySearch().run();
        float finish = System.currentTimeMillis();
        //System.out.println((finish-start) + " ms");
    }

    public void run(){
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        array = new int[count];
        for(int i=0; i<count; i++){
            array[i] = s.nextInt();
        }
        Arrays.sort(array);
        s.nextLine();
        String str = s.nextLine();
        String[] n = str.split(" ");
        int k = Integer.parseInt(n[0]);
        for(int i=1; i<k+1; i++){
            System.out.print(find(Integer.parseInt(n[i]))+" ");
        }
    }

    private int find(int e){
        int l = 0;
        int r = array.length-1;
        while(l <= r){
            int m = (l+r)/2;
            //System.out.println("m: "+m+", l: "+l+", r: "+r);
            if(array[m]==e){
                return m+1;
            } else if(array[m] > e){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}
