 class LargestElement  {
    public static int findLargest(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8};
        System.out.println(findLargest(arr)); // 20
    }
}