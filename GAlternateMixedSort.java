import java.util.Arrays;

public class GAlternateMixedSort {
    public static void sortGAlternateMixed(int[] arr, int g) {
        int evenCount = (arr.length + 1) / 2; // Number of even-indexed positions
        int oddCount = arr.length / 2; // Number of odd-indexed positions

        int[] evenIndexed = new int[evenCount];  
        int[] remaining = new int[oddCount];

        int evenIdx = 0, remainIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) evenIndexed[evenIdx++] = arr[i];  // Store even-indexed numbers
            else remaining[remainIdx++] = arr[i];  // Store odd-indexed numbers
        }

        // Step 2: Sort even-indexed numbers in ascending order
        Arrays.sort(evenIndexed);

        // Step 3: Sort odd-indexed numbers in descending order
        Arrays.sort(remaining);
        for (int i = 0; i < remaining.length / 2; i++) {
            int temp = remaining[i];
            remaining[i] = remaining[remaining.length - 1 - i];
            remaining[remaining.length - 1 - i] = temp;
        }

        // Step 4: Reconstruct the array
        evenIdx = 0;
        remainIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) arr[i] = evenIndexed[evenIdx++];
            else arr[i] = remaining[remainIdx++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 2, 6, 5};
        sortGAlternateMixed(arr, arr.length / 2);
        System.out.println(Arrays.toString(arr));
    }
}

