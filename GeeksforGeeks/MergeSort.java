// Merge Sort
// Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

// Divide and Merge
package GeeksforGeeks;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // Time Complexity - O(n log n)
    // Space Complexity - O(n)

    public static void mergeSort(int arr[], int l, int r) {
        int[] temp = new int[arr.length];
        mergeSort(arr, l, r, temp);
    }

    private static void mergeSort(int arr[], int l, int r, int[] temp) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid, temp);
        mergeSort(arr, mid + 1, r, temp);

        // Merge only if the two halves are not already sorted
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static void merge(int arr[], int l, int mid, int r, int[] temp) {
        int left = l, right = mid + 1, index = l;

        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }

        // Copy any remaining elements from the left subarray
        while (left <= mid) {
            temp[index++] = arr[left++];
        }

        // Copy any remaining elements from the right subarray
        while (right <= r) {
            temp[index++] = arr[right++];
        }

        // Copy sorted elements back to the original array
        System.arraycopy(temp, l, arr, l, r - l + 1);
    }
}
