// Count Inversions
// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum. 

package GeeksforGeeks;

public class CountInversions {
    public static void main(String[] args) {
        int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }
    
    // Optimal Solution
    // Time Complexity - O(n log n)
    // Space Complexity - O(n)
    public static int inversionCount(int arr[]) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static int mergeSort(int arr[], int l, int r, int[] temp) {
        int count = 0;
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        count += mergeSort(arr, l, mid, temp);
        count += mergeSort(arr, mid + 1, r, temp);

        if (arr[mid] > arr[mid + 1]) {
            count += merge(arr, l, mid, r, temp);
        }
        return count;
    }

    private static int merge(int arr[], int l, int mid, int r, int[] temp) {
        int left = l, right = mid + 1, index = l;

        int count = 0;
        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                count += (mid - left + 1);
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= r) {
            temp[index++] = arr[right++];
        }
        System.arraycopy(temp, l, arr, l, r - l + 1);
        return count;
    }

    /*
    // Brute Force
    // Time Complexity - O(n^2)
    // Space Complexity - O(1)
    public static int inversionCount(int arr[]) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(i < j && arr[i] > arr[j]) count++;
            }
        }
        return count;
    }
    */
}
