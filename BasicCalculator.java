/*
224. Basic Calculator (Hard)
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2

Example 2:

Input: " 2-1 + 2 "
Output: 3

Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //Use stack so most recent operation/number is at the top
        Stack<Integer> stack = new Stack<>();
        
        int res = 0;
        int num = 0;
        int sign = 1; //+1 or -1
        
        
        //Iterate through characters in String
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                num = num * 10 + currChar - '0'; //Multiple digit numbers
            } else if (currChar == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (currChar == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (currChar == '(') { 
                //Save result and sign in stack ')'
                stack.push(res); 
                stack.push(sign);
                
                //Reset the sign and result for value in parenthesis
                sign = 1;
                res = 0;
            } else if (currChar == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop(); //Multiply sign sign before parenthesis
                res += stack.pop(); //Add result calculated before parenthess
            } 
        }
        
        res += sign * num;
        return res;
        
    }
}