class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a), y = Math.abs(b);
        // ensure that abs(a) >= abs(b)
        if (x < y) return getSum(b, a);
        
        // abs(a) >= abs(b) --> 
        // a determines the sign
        int sign = a > 0 ? 1 : -1;
        
        if (a * b >= 0) {
            // sum of two positive integers x + y
            // where x > y
            while (y != 0) {
                int answer = x ^ y;
                int carry = (x & y) << 1;
                x = answer;
                y = carry;    
            }    
        } else {
            // difference of two positive integers x - y
            // where x > y
            while (y != 0) {
                int answer = x ^ y;
                int borrow = ((~x) & y) << 1;
                x = answer;
                y = borrow;    
            }    
        }
        return x * sign;
    }
}




class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int answer = a ^ b;
            int carry = (a & b) << 1;
            a = answer;
            b = carry;
        }
        
        return a;
    }
}

//Complexity Analysis

//Time complexity: \mathcal{O}(1)O(1) because each integer contains 3232 bits.

//Space complexity: \mathcal{O}(1)O(1) because we don't use any additional data structures.