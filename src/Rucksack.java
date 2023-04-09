import java.util.Scanner;

public class Rucksack {
    private int valume;
    private double cost;
    private int[][] items;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int valume = s.nextInt();
        int[][] items = new int[2][n];
        for(int i=0; i<n; i++){
            items[0][i] = s.nextInt();
            items[1][i] = s.nextInt();
        }
        new Rucksack().run(valume, items);
    }

    private void run(int v, int[][] i){
        valume = v;
        items = i;
        sort();
        chose();
    }

    private void sort(){
        for(int n=items[0].length; n>0; n--) {
            for (int i = 0; i < n-1; i++) {
                if (getDichte(i + 1) > getDichte(i)) {
                    swap(i + 1, i);
                }
            }
        }
    }

    private double getDichte(int i){
        return (double) items[0][i]/(double) items[1][i];
    }


    private void swap(int dex1, int dex2){
        int temp0 = items[0][dex1];
        int temp1 = items[1][dex1];
        items[0][dex1] = items[0][dex2];
        items[1][dex1] = items[1][dex2];
        items[0][dex2] = temp0;
        items[1][dex2] = temp1;
    }

    private void chose(){
        int n = 0;
        for(int i=0; i<items[0].length; i++){
            System.out.print(getDichte(i));
            System.out.println(" "+items[0][i]+" "+ items[1][i]);
        }
        while((valume!=0) && (n<items[0].length)){
            put(items[0][n], items[1][n]);
            n++;
        }
        String res = String.format("%.3f", cost);
        System.out.println(res);
    }

    private void put(int c, int val){
        if(val <= valume){
            valume = valume - val;
            cost = cost + c;
        } else {
            cost = cost + (double) valume/ (double) val * (double) c;
            valume = 0;
        }
    }
}
