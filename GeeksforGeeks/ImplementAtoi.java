/*
Implement Atoi -
Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.
Cases for atoi() conversion:
1. Skip any leading whitespaces.
2. Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
3. Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
4. If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.
*/

package GeeksforGeeks;

public class ImplementAtoi {
    public static void main(String[] args) {
        String s = "1231231231311133";
        System.out.println(myAtoi(s));
    }

    // Time Complexity - O(n)
    // Space Complexity - O(1)

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        int i = 0, n = s.length();
        int sign = 1;
        long result = 0;

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle the sign
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Process digits and construct the number
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return (int)(result * sign);
    }
}
