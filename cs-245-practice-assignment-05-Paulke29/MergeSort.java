public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[]a) {
        if (a.length > 1) {
            // split array into two halves
            int[] left = FirstHalf(a);
            int[] right = SecondHalf(a);

            // recursively sort the two halves
            sort(left);
            sort(right);

            // merge the sorted halves into a sorted whole
            merge(a, left, right);
        }
    }
    public static int[] FirstHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    // Returns the second half of the given array.
    public static int[] SecondHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }
    public static void merge(int[] result,
                             int[] left, int[] right) {
        int index1 = 0;   // index into left array
        int index2 = 0;   // index into right array

        for (int i = 0; i < result.length; i++) {
            if (index2 >= right.length || (index1 < left.length &&
                    left[index1] <= right[index2])) {
                result[i] = left[index1];    // take from left
                index1++;
            } else {
                result[i] = right[index2];   // take from right
                index2++;
            }
        }
    }
}
