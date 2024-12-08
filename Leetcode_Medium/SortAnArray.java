// 912. Sort an Array
// Given an array of integers nums, sort the array in ascending order and return it.
// You must solve the problem without using any built-in functions in O(n log(n)) time complexity and with the smallest space complexity possible.

// I'll solve using merge sort algorithm

package Leetcode_Medium;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        int nums[] = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    // Time Complexity - O(n log n)
    // Space Complexity - O(n)

    public static int[] sortArray(int[] nums) {
        int temp[] = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, (mid + 1), high, temp);
        if(nums[mid] > nums[mid + 1]) merge(nums, low, mid, high, temp);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int left = low, right = mid + 1, index = low;
        while (left <= mid && right <= high) {
            if(nums[left] < nums[right]) temp[index++] = nums[left++];
            else temp[index++] = nums[right++];
        }
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= high) {
            temp[index++] = nums[right++];
        }
        System.arraycopy(temp, low, nums, low, high - low + 1);
    }
}
