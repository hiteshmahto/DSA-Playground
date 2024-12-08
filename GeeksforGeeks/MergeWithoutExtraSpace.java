// Merge Without Extra Space
// Given two sorted arrays a[] and b[] in non-decreasing order. Merge them in sorted order without using any extra space. Modify a so that it contains the first n elements and modify b so that it contains the last m elements.

package GeeksforGeeks;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int a[] = {1, 5, 9, 10, 15, 20};
        int b[] = {2, 3, 8, 13};
        mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
    
    // Optimal Solution 1 - Gap Method
    
    private static void swapIfGreater(int a[], int b[], int index1, int index2) {
        if(a[index1] > b[index2]) {
            int temp = a[index1];
            a[index1] = b[index2];
            b[index2] = temp;
        }
    }
    
    // n -> a.length; m -> b.length
    // Time Complexity - O(log2(n + m)) * O(n + m)
    // Space Complexity - O(1)
    public static void mergeArrays(int a[], int b[]) {
        int totalLength = a.length + b.length;
        int gap = (totalLength / 2) + (totalLength % 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < totalLength) {
                // pointers are in both array 'a' and 'b'
                if(left < a.length && right >= a.length) {
                    swapIfGreater(a, b, left, right - a.length);
                } // both pointers are in 'b' array
                else if(left >= a.length) {
                    swapIfGreater(b, b, left - a.length, right - a.length);
                } // both pointers are in 'a' array
                else {
                    swapIfGreater(a, a, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    /*
    // Optimal Solution 2
    // n -> a.length; m -> b.length
    // Time Complexity - O(min(n, m)) + O(n log n) + O(m log m)
    // Space Complexity - O(1)

    public static void mergeArrays(int a[], int b[]) {
        int left = a.length - 1;
        int right = 0;
        while (left >= 0 && right < b.length) {
            if(a[left] > b[right]) {
                int temp = a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            } else break;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
    */

    /*
    // n -> a.length; m -> b.length
    // Time Complexity - O(n + m) + O(n + m)
    // Space Complexity - O(n + m)

    public static void mergeArrays(int a[], int b[]) {
        int left = 0, right = 0, index = 0;
        int mergedArr[] = new int[a.length + b.length];

        while(left < a.length && right < b.length) {
            if(a[left] > b[right]) {
                mergedArr[index] = b[right];
                right++;
            } else {
                mergedArr[index] = a[left];
                left++;
            }
            index++;
        }

        while (left < a.length) {
            mergedArr[index++] = a[left++];
        }

        while (right < b.length) {
            mergedArr[index++] = b[right++];
        }

        index = 0;
        while (index < mergedArr.length) {
            if(index < a.length) a[index] = mergedArr[index];
            else b[index - a.length] = mergedArr[index];
            index++;
        }
    }
    */
}
