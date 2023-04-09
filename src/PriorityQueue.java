import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

public class PriorityQueue {
    private static int[] queue;
    int count;

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        queue = new int[count];
        s.nextLine();
        PriorityQueue user = new PriorityQueue();
        String[] commands = new String[count];
        for(int i=0; i<count; i++){
            commands[i] = s.nextLine();
        }
        for(int i=0; i<count; i++){
            String[] map = commands[i].split(" ");
            String command = map[0];
            switch (command){
                case("Insert"):
                    user.insert(Integer.parseInt(map[1]));
                    break;
                case("ExtractMax"):
                    user.extractMax();
                    break;
            }
        }
    }

    private void insert(int n){
        if(count==0){
            queue[count++] = n;
        } else {
            queue[count] = n;
            setUp(count++);
        }
    }

    private void setUp(int temp){
        while((queue[temp] > queue[(temp-1)/2]) && (temp!=0)){
            swap(temp,  (temp-1)/2);
            temp = (temp-1)/2;
        }
    }

    private void swap(int i1, int i2){
        int s = queue[i1];
        queue[i1] = queue[i2];
        queue[i2] = s;
    }

    private void extractMax(){
        System.out.println(queue[0]);
        delete();
    }

    private void delete(){
        swap(0, count-1);
        queue[--count] = 0;
        setDown(0);
    }

    private void setDown(int temp){
        int t = temp;
        while(queue[t] < queue[2*t+1] || queue[t] < queue[2*t] ){
            if(queue[2*t] > queue[2*t+1]){
                swap(2*t, t);
                t = 2*t;
            } else {
                swap(2*t+1, t);
                t = 2*t + 1;
            }
        }
    }
}
