package Praxis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GreednyKnapsack {

    class Item implements Comparable<Item>{
        int cost;
        int weight;

        public Item(int cost, int weight){
            this.cost = cost;
            this.weight = weight;
        }


        @Override
        public int compareTo(Item o) {
            double r1 = (double)this.cost/this.weight;
            double r2 = (double) o.cost/o.weight;
            return -Double.compare(r1, r2);
        }
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int W = input.nextInt();
        Item[] items = new Item[n];
        for(int i=0; i<n; i++){
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        //Array.sort(items);
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                long r1 = (long) o1.cost * o2.weight;
                long r2 = (long) o2.cost * o1.weight;
                return -Long.compare(r1, r2);
            }
        });

        double result = 0;
        for(Item item : items){
            if(item.weight <=W){
                result += item.cost;
                W -= item.weight;
            } else{
                result += (double) item.cost * W / item.weight;
                break;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new GreednyKnapsack().run();
    }
}
