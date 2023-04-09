import javafx.scene.Parent;

import java.util.Scanner;

public class ZahlSort {

    public static void main(String[] args){
        new ZahlSort().run();
    }

    private void run(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] m = new int[11];
        for(int i=0; i<n; i++){
            m[s.nextInt()]++;
        }
        for(int i=0; i<11; i++){
            if(m[i]==1){
                System.out.print(i+" ");
            }
            if(m[i]>1){
                for(int j=0; j<m[i]; j++){
                    System.out.print(i+" ");
                }
            }
        }
    }

}
