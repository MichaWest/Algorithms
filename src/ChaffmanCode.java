import java.util.*;

public class ChaffmanCode {
    ArrayList<Knote> knotes;
    int count;
    String codes ="";
    String message = "";

    public static void main(String[] args){
        float start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        new ChaffmanCode().run(s.nextLine());
        float finish = System.currentTimeMillis();
        System.out.println(finish-start + " ms");
    }

    private void run(String s){
        makeKnoten(s);
        count = knotes.size();
        sortKnoten();
        makeBaum();
        String[] str = codes.split("\n");
        codes ="";
        for(int i= str.length-1; i>=0; i--){
            codes = codes + str[i] + "\n";
        }
        getMessage(s);
        printAnswer();
    }

    private void makeKnoten(String s){
        Map<Character, Integer> symboles = new HashMap<>();
        char[] str = s.toCharArray();
        for(int i=0; i<str.length; i++){
            char a = str[i];
            if(symboles.containsKey(a)){
                int h = symboles.get(a);
                symboles.replace(a, ++h);
            } else {
                symboles.put(a, 1);
            }
        }
        knotes = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: symboles.entrySet()){
            knotes.add(new Knote(entry.getKey(), entry.getValue()));
        }
    }

    private void sortKnoten(){
        for(int i=knotes.size(); i>0; i--){
            for(int j=0; j < i-1; j++){
                if(knotes.get(j).h > knotes.get(j+1).h){
                    swap(j, j+1);
                }
            }
        }
    }

    private void swap(int dex1, int dex2){
        Knote temp0 = knotes.get(dex1);
        knotes.set(dex1, knotes.get(dex2));
        knotes.set(dex2, temp0);
    }

    private void makeBaum(){
        if(knotes.size()!=1) {
            while (knotes.size() > 1) {
                Knote k = new Knote(' ', knotes.get(0).h + knotes.get(1).h);
                k.leftChild = knotes.get(0);
                k.rightChild = knotes.get(1);
                insert(k);
                knotes.remove(0);
                knotes.remove(0);
            }
            readBaum(knotes.get(0), "");
        }else {
            readBaum(knotes.get(0), "0");
        }

    }

    private void insert(Knote k){
        for(int i=0; i<knotes.size(); i++){
            if(k.h < knotes.get(i).h){
                knotes.add(i, k);
                return;
            }
        }
        knotes.add(k);
    }

    private void readBaum(Knote k, String code){
        if(k.rightChild==null && k.leftChild==null){
            codes = codes + k.s+": "+code + "\n";
            k.code = code;
            knotes.add(k);
        } else{
            readBaum(k.rightChild, code + "1");
            readBaum(k.leftChild, code + "0");
        }
    }

    private void getMessage(String s){
        char[] sym = s.toCharArray();
        for(int i=0; i<sym.length; i++){
            for(int j=0; j<knotes.size(); j++){
                if(knotes.get(j).s == sym[i]){
                    message = message + knotes.get(j).code;
                    break;
                }
            }

        }
    }

    private void printAnswer(){
        System.out.println((knotes.size()-1)+" "+message.length());
        System.out.print(codes);
        System.out.println(message);
    }

    private class Knote{
        public int h;
        public char s;
        public String code;
        public Knote rightChild;
        public Knote leftChild;

        public Knote(char sym, int hau){
            s = sym;
            h = hau;
            rightChild = null;
            leftChild = null;
        }

        public int getH(){
            return h;
        }

        public char getS(){
            return s;
        }
    }

}

