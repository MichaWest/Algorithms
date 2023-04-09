import java.beans.PropertyEditorSupport;

public class GCD {

    private long gcd(long a, long b){
        System.out.println(a+" "+ b);
        while(true) {
            if (a == 0) return b;
            if (b == 0) return a;
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
    }

    public void run() {
        System.out.println(gcd(145785697896584521L, 5841325415742547885L));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new GCD().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime-startTime +" ms");
    }
}
