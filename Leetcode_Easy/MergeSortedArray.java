// 88. Merge Sorted Array
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

package Leetcode_Easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    // Time Complexity - O(m + n)
    // Space Complexity - O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m + n - 1;
        m--; n--;
        while (m >= 0 && n >= 0) {
            if(nums1[m] < nums2[n]) nums1[last--] = nums2[n--];
            else nums1[last--] = nums1[m--];
        }
        while(n >= 0) {
            nums1[last--] = nums2[n--];
        }
    }
}
