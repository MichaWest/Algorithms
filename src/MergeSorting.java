import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeSorting {
    private static int l;
    private long f = 0;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        l = s.nextInt();
        long[] m  = new long[l];
        for(int i=0; i<l; i++){
            m[i] = s.nextInt();
        }
        new MergeSorting().run(m);
    }

    private void run(long[] m){
        Queue<long[]> q = new LinkedList<>();
        int n = (int) Math.pow(2, Math.ceil(Math.log(l)/Math.log(2)));
        for(int i=0; i<n-l; i++){
            q.add(new long[]{0});
        }
        for(int i=0; i<l; i++){
            q.add(new long[]{m[i]});
        }
        int c = 0;
        while(q.size()>1){
            q.add(merge(q.poll(), q.poll()));
            /*
            System.out.println("Queue"+(c++));
            for(int[] t: q){
                for(int i=0; i<t.length; i++){
                    System.out.print(t[i]+" ");
                }
                System.out.println();
            }
             */
        }
        System.out.println(f);
    }

    public long[] merge(long[] a, long[] b){
        int n = a.length;
        int y = b.length;
        long[] r = new long[n+y];
        int i=0, j=0;
        for(int t=0; t<y+n; t++){
            if(j>=y){
                r[t] = a[i++];
            } else if (i>=n){
                r[t] = b[j++];
            } else if(a[i] <= b[j]){
                r[t] = a[i++];
            } else {
                f += n - i;
                r[t] = b[j++];
                //System.out.println("Fehler: "+a[i]+" "+b[j-1]+" "+f);
            }
        }
        return r;
    }
}
