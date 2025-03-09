import java.util.Arrays;

class MergeSortThread extends Thread {
    private int[] arr;

    public MergeSortThread(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        mergeSort(arr);
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        MergeSortThread leftThread = new MergeSortThread(left);
        MergeSortThread rightThread = new MergeSortThread(right);

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}

public class MultiThreadedMergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6, 3, 7, 8};
        System.out.println("Original Array: " + Arrays.toString(arr));

        MergeSortThread.mergeSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
