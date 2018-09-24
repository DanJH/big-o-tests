import java.io.*;

public class sortMethods {

    public static void main(String[] args) {
        mergeSort m = new mergeSort();
        InsertionSort s = new InsertionSort();
        long merge[][] = new long[100][100];
        long selection[][] = new long[100][100];
        long insertion[][] = new long[100][100];
        for(int j = 0; j < merge.length; j++) {
            for (int i = 0; i < merge[0].length; i++) {
                int arr[] = new int[10000 * (i + 1)];
                fill(arr);
                long timeStart = System.nanoTime();
                m.sort(arr);
                long timeEnd = System.nanoTime();
                merge[j][i] = timeEnd - timeStart;
            }
        }
        System.out.println("Merge Success");
        for(int j = 0; j < selection.length; j++) {
            for (int i = 0; i < selection[0].length; i++) {
                int arr[] = new int[10000 * (i + 1)];
                fill(arr);
                long timeStart = System.nanoTime();
                selectionSort.sort(arr);
                long timeEnd = System.nanoTime();
                selection[j][i] = timeEnd - timeStart;
            }
        }
        System.out.println("Selection Success");
        for(int j = 0; j < insertion.length; j++) {
            for (int i = 0; i < insertion[0].length; i++) {
                int arr[] = new int[10000 * (i + 1)];
                fill(arr);
                long timeStart = System.nanoTime();
                s.sort(arr);
                long timeEnd = System.nanoTime();
                insertion[j][i] = timeEnd - timeStart;
                System.out.println(insertion[j][i]);
            }
        }
        System.out.println("Insertion Success");
        long insertionRes[] = avg(insertion);
        long selectRes[] = avg(selection);
        long mergeRes[] = avg(merge);
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter("insertion.csv"));
            StringBuffer sb = new StringBuffer();

            for (long element : insertionRes) {
                sb.append(element);
                sb.append(",");
            }
            sb.append("\n");
            for (long element : selectRes) {
                sb.append(element);
                sb.append(",");
            }
            sb.append("\n");
            for (long element : mergeRes) {
                sb.append(element);
                sb.append(",");
            }
            br.write(sb.toString());
            br.close();
        } catch (IOException e){
            System.err.println("Caught IOException: " +  e.getMessage());
        }

    }





    public static long[] avg(long[][] arr){
        long avg[] = new long[arr[0].length];
        for(int k = 0; k < arr[0].length; k++){
           for(int j = 0; j < arr.length; j++){
               avg[k] = avg[k] + arr[j][k];
           }
        }
        for(int k = 0; k < arr[0].length; k++){
            avg[k] = avg[k]/arr.length;
        }
        return avg;
    }
    static void fill(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000000);
        }
    }
}