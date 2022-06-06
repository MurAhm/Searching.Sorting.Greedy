import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        sort(arr, 0, arr.length - 1);

        StringBuilder stringBuilder = new StringBuilder();

        for (int number : arr) {
            stringBuilder.append(number).append(" ");
        }

        System.out.println(stringBuilder.toString().trim());
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // Find the middle point
            int mid = (l + r) / 2;

        // Sort first and second halves
            sort(arr, l, mid);
            sort(arr, mid + 1, r);

        // Merge the sorted halves
            merge(arr, l, mid, r);
        }


    private static void merge(int[] arr, int l, int mid, int r) {

        // Find sizes of two subarrays to be merged
        int n1 = mid - l + 1;
        int n2 = r - mid;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarray array
        int k = l;

        while (i < n1 && j < n2){
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
