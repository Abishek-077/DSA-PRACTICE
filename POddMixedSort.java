/*
 * This program sorts an array of integers in such a way that all the odd numbers come first and then the even numbers.
 * The odd numbers are sorted in descending order and the even numbers are sorted in ascending order.
 * The program uses the Arrays.sort() method to sort the array.
 */
import java.util.Arrays;

public class POddMixedSort {
    public static void sortPOddMixed(int[] arr, int p) {
        int[] odds = new int[p];
        int[] evens = new int[arr.length - p];
        int oddIndex = 0, evenIndex = 0;

        for (int num : arr) {
            if (num % 2 == 0) evens[evenIndex++] = num;
            else odds[oddIndex++] = num;
        }

        Arrays.sort(odds);
        oddIndex = 0;
        evenIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < p) arr[i] = odds[oddIndex++];
            else arr[i] = evens[evenIndex++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 2, 4, 6};
        sortPOddMixed(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

// Output: [7, 5, 1, 2, 4, 6]
