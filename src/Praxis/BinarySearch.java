package Praxis;

import javafx.scene.Parent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new BinarySearch().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + "ms");
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        Arrays.sort(a);
        int k = in.nextInt();
        int[] b = new int[k];
        for(int i=0; i<k; i++){
            b[i] = in.nextInt();
        }
        for(int i=0; i<k; i++){
            System.out.print(binarySearch(a, b[i])+" ");
        }
        System.out.println();
    }

    private int binarySearch(int[] a, int x){
        int l = -1;
        int r = a.length;
        // a[l] < x
        // a[r] >= x
        while(r > l + 1) {
            int m = (l + r) >> 1;
            if(a[m] < x){
                l = m;
            } else {
                r = m;
            }
        }
        if(l>=0 && a[r] == x){
            return l;
        } else {
            return -1;
        }
    }

}
