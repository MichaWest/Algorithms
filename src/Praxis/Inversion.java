package Praxis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inversion {
    private int[] temp;
    private int [] a;

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new Inversion().run();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Input.txt"));
        int n = in.nextInt();
        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        temp = new int[n];
        mergeSort(0, n);
    }

    private void merge(int l, int m, int r){
        //a[l..m-1], a[m..r-1] -> a[l..r-1]
        int i = l;
        int j = m;
        for(int k=l;  k<r; k++){
            if(j == r || i<m && a[i] <= a[j]) temp[k] = a[i++];
            else {
                // a[i, i+1, ..., a.length-1] > b[j]
                temp[k] = a[j++];
                count += m - i;
            }
        }
        System.arraycopy(temp, l, a, l, r -l);
    }

    int count = 0;

    private void mergeSort(int l, int r){
        if(r <= l + 1);
        else {
            int m = (l + r) >> 1;
            mergeSort(l, m);
            mergeSort(m+1, r);
            merge(l, m, r);
        }
    }
}
