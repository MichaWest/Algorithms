import java.util.Scanner;

public class ChaffmanDecode {
    Knote root = new Knote(' ');
    char[] code;
    String message = "";

    public static void main(String[] args){
        new ChaffmanDecode().run();
    }

    public void run(){
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int n = s.nextInt();
        String[] codesAndSymbol = new String[count];
        s.nextLine();
        for(int i=0; i < count; i++){
            codesAndSymbol[i] = s.nextLine();
        }
        code = s.nextLine().toCharArray();
        makeBaum(codesAndSymbol);
        decode(root);
        System.out.println(message);
    }

    private void printBaum(Knote temp, int n){
        if(temp.rightChild!=null)
            printBaum(temp.rightChild, n+10);
        System.out.println(ots(n)+temp.symbol+"("+temp.code+")");
        if(temp.leftChild!=null)
            printBaum(temp.leftChild, n+10);
    }

    private String ots(int n){
        String s = "";
        for(int i=0; i < n; i++){
            s = s + " ";
        }
        return s;
    }

    private void makeBaum(String[] codesAndSymbol){
        for(int i=0; i<codesAndSymbol.length; i++){
            String symbol = codesAndSymbol[i].split(": ")[0];
            Knote temp = root;
            char[] code = codesAndSymbol[i].split(": ")[1].toCharArray();
            for(int j=0; j<code.length-1; j++){
                if(code[j] == '1'){
                    if(temp.rightChild == null){
                        temp.rightChild = new Knote(' ');
                    }
                    temp = temp.rightChild;
                } else {
                    if(temp.leftChild == null){
                        temp.leftChild = new Knote(' ');
                    }
                    temp = temp.leftChild;
                }
            }
            if(code[code.length-1]=='1'){
                temp.rightChild = new Knote(symbol.charAt(0));
                temp.rightChild.code = codesAndSymbol[i];
            } else {
                temp.leftChild = new Knote(symbol.charAt(0));
                temp.leftChild.code = codesAndSymbol[i];
            }
        }
    }

    int n = 0;
    private void decode(Knote temp){
        if((n < code.length)){
            if((temp.rightChild==null) && (temp.leftChild==null)){
                message = message + temp.symbol;
                decode(root);
            } else {
                if(code[n++] == '1'){
                    decode(temp.rightChild);
                } else {
                    decode(temp.leftChild);
                }
            }
        } else {
            if (temp.rightChild == null) {
                message = message + temp.symbol;
            }
        }
        n = 0;
    }

    private class Knote{
        char symbol;
        Knote rightChild;
        Knote leftChild;
        String code;

        public Knote(char s){
            symbol = s;
        }
    }
}
