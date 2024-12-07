// 274. H-Index
// Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
// According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

package Leetcode_Medium;

public class HIndex {
    public static void main(String[] args) {
        int citations[] = {3, 0, 6, 1, 5, 8, 4, 2};
        System.out.println(hIndex(citations));
    }

    // Time Complexity - O(n) + O(n) --> O(n)
    // Space Complexity - O(n) -- temporary array citationCounts of size n+1 is used
    public static int hIndex(int[] citations) {
        int citationCounts[] = new int[citations.length + 1];
        for(int n : citations) {
            if(n < citationCounts.length) citationCounts[n]++;
            else citationCounts[citations.length]++;
        }
        int cumulativePapers = 0;
        for(int h = citationCounts.length - 1; h >= 0; h--) {
            cumulativePapers += citationCounts[h];
            if(cumulativePapers >= h) return h;
        }
        return 0;
    }
}
