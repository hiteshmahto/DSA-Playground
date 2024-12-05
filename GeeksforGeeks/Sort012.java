// Sort 0s, 1s and 2s
// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

package GeeksforGeeks;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1, 2, 2, 1, 1, 0};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    // Dutch National Flag Algorithm
    // Time Complexity - O(n)
    // Space Complexity - O(1)
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while(mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /*
    // Time Complexity - O(2n)
    // Space Complexity - O(1)
    public static void sort012(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) count0++;
            else if(arr[i] == 1) count1++;
            else count2++;
        }
        for(int i = 0; i < count0; i++) arr[i] = 0;
        for(int i = count0; i < (count0 + count1); i++) arr[i] = 1;
        for(int i = (count0 + count1); i < (count0 + count1 + count2); i++) arr[i] = 2;
    }
    */
}
