//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Lab Work: Ask the user how many integer numbers to be sorted.
        // Declare the array and populate the array

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many integers do you want to sort? ");
        int input_size = scanner.nextInt();

        int[] input = new int[input_size];

        // Take input from the user using a loop
        System.out.println("Enter " + input_size + " integers:");

        for (int i = 0; i < input_size; i++) {
            input[i] = scanner.nextInt();
        }

        // Sorting the array
        MergeSort(input, 0, input_size - 1);

        // Already sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < input_size; i++) {
            System.out.print(input[i] + " ");
        }

        scanner.close();
    }


    public static void MergeSort(int[] A, int low, int high) {

        if (low < high) {

            // Dividing
            int mid = low + (high - low) / 2;

            MergeSort(A, low, mid);
            MergeSort(A, mid + 1, high);

            Merge(A, low, mid, high);
        }
    }


    public static void Merge(int[] A, int low, int mid, int high) {

        // Temp array
        int[] temp = new int[high - low + 1];

        int i = low;       // Beginning of left subarray
        int j = mid + 1;   // Beginning of right subarray
        int k = 0;         // Position in temporary array

        // Comparing values from both subarrays
        while (i <= mid && j <= high) {

            if (A[i] <= A[j]) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }

            k++;
        }

        //  remaining elements from left subarray
        while (i <= mid) {
            temp[k] = A[i];
            i++;
            k++;
        }

        //  remaining elements from right subarray
        while (j <= high) {
            temp[k] = A[j];
            j++;
            k++;
        }

        //  merged values back into original array
        for (i = 0; i < temp.length; i++) {
            A[low + i] = temp[i];
        }
    }
}