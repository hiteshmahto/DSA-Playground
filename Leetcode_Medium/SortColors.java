// 75. Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

package Leetcode_Medium;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int nums[] = {1, 2, 0, 0, 1, 1, 2, 2, 0, 0, 1};
        sort012(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Dutch National Flag Algorithm
    // Time Complexity - O(n)
    // Space Complexity - O(1)
    public static void sort012(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    /*
    // Time Complexity - O(2n)
    // Space Complexity - O(1)
    public static void sort012(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) count0++;
            else if(nums[i] == 1) count1++;
            else count2++;
        }
        for(int i = 0; i < count0; i++) nums[i] = 0;
        for(int i = count0; i < (count0 + count1); i++) nums[i] = 1;
        for(int i = (count0 + count1); i < (count0 + count1 + count2); i++) nums[i] = 2;
    }
    */

}
