import java.util.*;

public class AufgabeQS {
    private List<Point> points = new ArrayList<>();
    private List<Point> result = new ArrayList<>();

    public static void main(String[] args){
        new AufgabeQS().run();
    }

    private void run(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        for(int i=0; i<n; i++){
            points.add(new Point(s.nextInt()-0.1, true));  //x
            points.add(new Point(s.nextInt()+0.1, false)); //y
        }
        for(int i=0; i<m; i++){
            Point p = new Point(s.nextLong());
            result.add(p);
            points.add(p);
        }
        Collections.sort(points);
        for(Point p: points){System.out.print(p.x+" ");}
        count();
        for(Point p: result){
            System.out.print(p.f+" ");
        }
    }

    private void count(){
        int f = 0;
        for(Point p: points){
            if(p.f<0){
                if(p.compare){
                    f++;
                } else{
                    f--;
                }
            } else{
                p.f = f;
            }
        }
    }

    class Point implements Comparable<Point>{
        boolean compare;
        double x;
        long f;

        public Point(double x){
            this.x = x;
            f = 0;
        }

        public Point(double x, boolean t){
            compare = t;
            this.x = x;
            f = -1;
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(this.x, o.x);
        }
    }
}