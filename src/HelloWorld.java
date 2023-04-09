public class HelloWorld {

    private void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        new HelloWorld().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}
