import java.math.BigInteger;
import java.util.*;

public class Main {
    List<BigInteger> cache = new ArrayList<>();
    {
        cache.add(BigInteger.ZERO);
        cache.add(BigInteger.ONE);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        BigInteger a = new BigInteger(str[0]);
        BigInteger m = new BigInteger(str[1]);
        BigInteger result = new Main().fibonacci(a, m);
        System.out.println(result);
    }

    public BigInteger fibonacci(BigInteger n, BigInteger mod){
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger count = BigInteger.valueOf(0);
        while(!count.equals(n)){
            BigInteger c = a.add(b).remainder(mod);
            a = b;
            b = c;
            count = count.add(BigInteger.valueOf(1));
        }
        return a;
    }

}
