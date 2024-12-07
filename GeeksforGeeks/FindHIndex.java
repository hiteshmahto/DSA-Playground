// Find H-Index
// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.
// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

package GeeksforGeeks;

public class FindHIndex {
    public static void main(String[] args) {
        int citations[] = {5, 1, 2, 4, 1};
        System.out.println(hIndex(citations));
    }

    // Time Complexity - O(n) + O(n) --> O(n)
    // Space Complexity - O(n) -- temporary array citationCounts of size n+1 is used

    public static int hIndex(int[] citations) {
        int[] citationCounts = new int[citations.length + 1];
        for (int n : citations) {
            if (n < citations.length) citationCounts[n]++;
            else citationCounts[citations.length]++;
        }

        int cumulativePapers = 0;
        for (int h = citationCounts.length - 1; h >= 0; h--) {
            cumulativePapers += citationCounts[h];
            if (cumulativePapers >= h) {
                return h;
            }
        }

        return 0;
    }
}
