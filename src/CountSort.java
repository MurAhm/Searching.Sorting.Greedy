import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Arrays.sort;

public class CountSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(arr).max().getAsInt();
        
        int[] counts = new int[max + 1];

        sort(arr, counts);

        for (int index = 0; index < counts.length; index++) {
            if(counts[index] != 0) {
                for (int i = 0; i < counts[index]; i++) {
                    System.out.print(index + " ");
                }
            }
            
        }


    }
    public static void sort(int[] arr, int[] counts) {
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
    }
}
