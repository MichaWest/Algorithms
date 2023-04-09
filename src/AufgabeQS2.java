import java.util.*;

public class AufgabeQS2 {
    private Point[] points;
    private List<Point> punkten = new ArrayList<>();
    private Point[] result;

    public static void main(String[] args){
        new AufgabeQS2().run();
    }

    private void run(){
        Scanner s = new Scanner(System.in);
        //int n = s.nextInt();
        //int m = s.nextInt();
        int n = 50000+(int)(Math.random()*1000);
        int m = 50000+(int)(Math.random()*1000);
        points = new Point[m+2*n];
        result = new Point[m];
        int count = 0;
        for(int i=0; i<n; i++){
            //Point x = new Point(s.nextInt()-0.1, true);
            //Point y = new Point(s.nextInt()+0.1, false);
            Point x = new Point(100000000+(int)(Math.random()*1000)-0.1, true);
            Point y = new Point(100000000+(int)(Math.random()*1000)+0.1, false);
            points[count++] = x;  //x
            points[count++] = y; //y
            punkten.add(x);
            punkten.add(y);
        }
        for(int i=0; i<m; i++){
            //Point p = new Point(s.nextInt());
            Point p = new Point(100000000+(int)(Math.random()*1000));
            result[i] = p;
            points[count++]=p;
            punkten.add(p);
        }
        double start = System.currentTimeMillis();
        Collections.sort(punkten);
        double end = System.currentTimeMillis();
        System.out.println(punkten.size()+" Java's sorting: "+(end-start));

        start = System.currentTimeMillis();
        sort(0, m+2*n-1);
        end = System.currentTimeMillis();
        System.out.println(points.length+" My sorting: "+(end-start));

        //System.out.println();
        //for(int i=0; i<points.length;i++){System.out.print(points[i].x+" ");}
        //System.out.println();
        count();
        System.out.println();
        //for(Point p: result){System.out.print(p.f+" ");}
    }

    private void count(){
        int f = 0;
        for(int i=0; i<points.length;i++){
            Point temp = points[i];
            if(temp.f<0){ //if point is end or start
                if(temp.compare){ // if point is start
                    f++;
                } else{  //if point is end
                    f--;
                }
            } else{ //if point is normal point
               // System.out.print(f+" ("+temp.x+") ");
                temp.f = f;
            }
        }
    }

    private void sort(int l, int r){
        if(l>=r) return;
        if(r-l==1) return;
        int m = partition(l, r);
        sort(l, m-1);
        sort(m+1, r);
    }

    private int partition(int l, int r){
        Point temp = points[l];
        int m = l;
        for(int i=l; i<=r; i++){
            if(points[i].x < temp.x){
                m++;
                swap(i, m);
            }
        }
        swap(l, m);
        return m;
    }

    private void swap(int a, int b){
        Point temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }

    class Point implements Comparable<Point>{
        boolean compare; //true - start, false - end
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
