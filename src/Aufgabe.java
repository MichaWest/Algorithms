import java.util.Scanner;

public class Aufgabe {
    public int[][] lines;

    public void run(int[][] l){
        lines = l;
        sort(0, lines[1].length-1);
        chose();
    }

    public static void main(String[] arg){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] l = new int[2][n];
        for(int i=0; i<n; i++){
            l[0][i] = s.nextInt();
            l[1][i] = s.nextInt();
        }
        new Aufgabe().run(l);
    }

    private void sort(int left, int right){
        int size = right - left + 1;
        if(size <= 3)
            manualSort(left, right);
        else{
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            sort(left, partition-1);
            sort(partition+1, right);
        }
    }

    private long medianOf3(int left, int right){
        int center = (left + right) / 2;

        if(lines[1][left] > lines[1][center])
            swap(left, center);
        if(lines[1][left] > lines[1][right])
            swap(left, right);
        if(lines[1][center] > lines[1][right])
            swap(center, right);
        swap(center, right - 1);
        return lines[1][right-1];
    }

    public void swap(int dex1, int dex2){
        int temp0 = lines[0][dex1];
        int temp1 = lines[1][dex1];
        lines[0][dex1] = lines[0][dex2];
        lines[1][dex1] = lines[1][dex2];
        lines[0][dex2] = temp0;
        lines[1][dex2] = temp1;
    }

    public int partitionIt(int left, int right, long pivot){
        int leftPtr = left; // Справа от первого элемента
        int rightPtr = right - 1; // Слева от опорного элемента
        while(true)
        {
            while( lines[1][++leftPtr] < pivot ) // Поиск большего элемента
                ; // (пустое тело цикла)
            while( lines[1][--rightPtr] > pivot ) // Поиск меньшего элемента
                ; // (пустое тело цикла)
            if(leftPtr >= rightPtr) // Если указатели сошлись,
                break; // разбиение закончено
            else // В противном случае
                swap(leftPtr, rightPtr); // поменять элементы местами
        }
        swap(leftPtr, right-1); // Восстановление опорного элемента
        return leftPtr;
    }

    public void manualSort(int left, int right) {
        int size = right-left+1;
        if(size <= 1)
            return; // Сортировка не требуется
        if(size == 2)
        { // 2-сортировка left и right
            if( lines[1][left] > lines[1][right] )
                swap(left, right);
            return;
        }
        else // Размер равен 3
        { // 3-сортировка left, center и right
            if( lines[1][left] > lines[1][right-1] )
                swap(left, right-1); // left, center
            if( lines[1][left] > lines[1][right] )
                swap(left, right); // left, right
            if( lines[1][right-1] > lines[1][right] )
                swap(right-1, right); // center, right
        }
    }

    private void chose(){
        int n = lines[1].length;
        int[] points = new int[n];
        int count = 0;
        points[count] = lines[1][0];
        for(int i=1; i<n; i++){
            if(lines[0][i]>points[count]){
                count++;
                points[count] = lines[1][i];
            }
        }
        System.out.println(count+1);
        for(int i=0; i<=count; i++){
            System.out.print(points[i]+" ");
        }
    }

}
