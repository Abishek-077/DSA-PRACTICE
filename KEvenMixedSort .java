import java.util.Arrays;

public class KEvenMixedSort {
    public static void sortKEvenMixed(int[] arr, int k) {
        int[] evens = new int[k]; 
        int[] odds = new int[arr.length - k]; 
        int evenIndex = 0, oddIndex = 0;

        // Step 1: Separate even and odd numbers
        for (int i = 0; i < arr.length; i++) {
            if (i < k) evens[evenIndex++] = arr[i];
            else odds[oddIndex++] = arr[i];
        }

        // Step 2: Sort only the odd numbers
        Arrays.sort(odds);

        // Step 3: Reconstruct the original array
        evenIndex = 0;
        oddIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) arr[i] = evens[evenIndex++];
            else arr[i] = odds[oddIndex++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 7, 5, 1};  
        sortKEvenMixed(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
