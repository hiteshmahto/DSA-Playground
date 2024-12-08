/*
13. Roman to Integer
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
*/


package Leetcode_Easy;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    // Time Complexity - O(n)
    // Space Complexity - O(1)
    public static int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentValue = getValue(s.charAt(i));
            if((i + 1) < s.length() && currentValue < getValue(s.charAt(i + 1))) sum -= currentValue;
            else sum += currentValue;
        }
        return sum;
    }

    private static int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
