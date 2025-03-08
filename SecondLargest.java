public class SecondLargest {
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) throw new IllegalArgumentException();
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) throw new IllegalArgumentException("No second largest");
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 35};
        System.out.println(findSecondLargest(arr)); // 12
    }
}