import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fibonacci {

    //Map<Integer, BigInteger> cache = new HashMap<>();
    List<BigInteger> cache = new ArrayList<>();
    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }

    int cnt;

    private BigInteger fibonacci(int n){
        for(int i = cache.size(); i <= n; i++){
            BigInteger res = cache.get(i-1).add(cache.get(i-2));
            cache.add(res);
        }
        return cache.get(n);
    }

    private void run(int n){
        System.out.println(n+": "+fibonacci(n));
    }

    public static void main(String[] args){
            long startTime = System.currentTimeMillis();
            new Fibonacci().run(100000);
            long finishTime = System.currentTimeMillis();
            System.out.println(finishTime - startTime + " ms");
    }
}
